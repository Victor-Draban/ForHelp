<%@tag import="java.util.ResourceBundle"%>
<%@tag import="java.util.Locale"%>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ attribute name="key" required="true" %>

<%
Locale locale = request.getLocale();
ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
String value = rb.getString(key);
%>

<%=value%>