package webtester.handler;

import java.sql.ResultSet;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import webtester.annotation.Column;

class DefaultRowResultSetHandler<T> implements ResultSetHandler<T> {

	private final Class<T> classEntity;
	
	DefaultRowResultSetHandler(Class<T> classEntity) {
		super();
		this.classEntity = classEntity;
	}
	
	public T handle(ResultSet rs) throws SQLException {
		try {
			T entity = classEntity.newInstance();
			Field[] fields = classEntity.getDeclaredFields();
			
			for(Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				field.setAccessible(true);
				String columnLabel = field.getName();
				Column columnAnnotation = field.getAnnotation(Column.class);
				if (columnAnnotation != null) {
					columnLabel = columnAnnotation.value();
				}
				Object value = rs.getObject(columnLabel);
				field.set(entity, value);
			}
			
			return entity;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

}
