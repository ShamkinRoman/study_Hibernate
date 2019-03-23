package saleCars;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter. Check success enter.
 */
public class AuthFilterCars implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().contains("/sign")) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = req.getSession();
            if (session.getAttribute("access") == null) {
                System.out.println("Внутри Фильтра");
                ((HttpServletResponse) response).sendRedirect(String.format("%s/signin", req.getContextPath()));
                return;
            }
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
