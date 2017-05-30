package webtester.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="CheckRoleFilter")
public class CheckRoleFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		String role = (String) req.getSession().getAttribute("role");
		String currentURL = req.getRequestURI();
		
		if (role.equals("student") & !currentURL.startsWith("/student")) {
			resp.sendRedirect("/student/all-test-for-students");
		} else if (role.equals("admin") & !currentURL.startsWith("/admin")) {
			resp.sendRedirect("/admin");
		} else if (role.equals("tutor") & !currentURL.startsWith("/tutor")) {
			resp.sendRedirect("/tutor");
		} else if(role.equals("advance tutor") & !currentURL.startsWith("/tutor")) {
			resp.sendRedirect("/tutor");
		} else {
			chain.doFilter(req, resp);
		}
	}

}
