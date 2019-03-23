package saleCars;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet Controller.
 * Exist authorization.
 * Use MAP for access(numeric).
 */
public class SigninControllerCars extends HttpServlet {
    private LoginUser loginUser = new LoginUser();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/LoginViewCars.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String enter = req.getParameter("enter");
//        System.out.println(login + " " + " " + password + " " + enter);
        loginUser.loginResult(req);

        System.out.println(req.getSession().getAttribute("access"));
//        doGet(req, resp);

        if (req.getSession().getAttribute("access").equals("loginOk")) {
//            HttpSession session = req.getSession();
//            session.setAttribute("access", roles.get(validate.isCheckPass(login, password)));
//            session.setAttribute("role", validate.isCheckPass(login, password));
//            session.setAttribute("login", login);
//            session.setAttribute("addWrongRole", " not");
//            session.setAttribute("addNot", "");
//            session.setAttribute("updateNot", "");
//            System.out.println(session.getAttribute("access"));
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Wrong authorization");
            doGet(req, resp);
        }
    }
}
