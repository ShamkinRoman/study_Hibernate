package saleCars;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUser {

    public void loginResult(HttpServletRequest req) {

        HttpSession session = req.getSession();
        if (req.getParameter("enter").equals("enter"))
            session.setAttribute("access", "loginOk");
        else
            session.setAttribute("access", "loginNot");
    }
}
