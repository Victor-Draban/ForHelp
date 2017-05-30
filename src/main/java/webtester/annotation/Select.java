package webtester.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.dbutils.ResultSetHandler;

import webtester.handler.DefaultResultSetHandler;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Select {

	String sql();
	
	Class<? extends ResultSetHandler> resultSetHandlerClass() default DefaultResultSetHandler.class;
	
}
