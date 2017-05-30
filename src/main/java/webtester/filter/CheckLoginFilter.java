package webtester.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webtester.Constants;
import webtester.model.Account;

@WebFilter(filterName="CheckLoginFilter")
public class CheckLoginFilter extends AbstractFilter {

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		Account account = (Account) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
		String currentUrl = req.getRequestURI();
		if (account == null && isProtectedUrl(currentUrl)) {
			resp.sendRedirect("/login");
		} else {
			chain.doFilter(req, resp);
		}
	}

	private boolean isProtectedUrl(String currentUrl) {
		if (currentUrl.startsWith("/admin")) {
			return true;
		} else if (currentUrl.startsWith("/tutor")) {
			return true;
		} else if (currentUrl.startsWith("/advance-tutor")) {
			return true;
		} else if (currentUrl.startsWith("/student")) {
			return true;
		}
		return false;
	}
}
