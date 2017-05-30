package webtester.repository.impl;

import java.sql.Connection;

public class ConnectionUtils {

	public static final ThreadLocal<Connection> connections = new ThreadLocal<Connection>();
	
	public static Connection getCurrentConnection() {
		Connection c = connections.get();
		if (c == null) {
			throw new IllegalStateException("Connection not found for current thread");
		}
		return c;
	}
	
	public static void setCurrentConnection(Connection c) {
		connections.set(c);
	}
	
	public static void removeCurrentConnection() {
		connections.remove();
	}
}
