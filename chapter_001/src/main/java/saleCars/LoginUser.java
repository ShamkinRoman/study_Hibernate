package saleCars;

import mappingXML.Customer;
import mappingXML.placeholder.FindObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUser {
    FindObject findObject = new FindObject();

    public void loginResult(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("access", "loginNot");
        if (req.getParameter("enter").equals("enter")) {
            Customer customer = (Customer) findObject.findOneObj(String.format("From Customer where namecustomer = '%s'", req.getParameter("login")));
            System.out.println(customer);
            if (customer != null && customer.getPasswordCustomer().equals(req.getParameter("password"))) {
                session.setAttribute("access", "loginOk");
                session.setAttribute("user", req.getParameter("login"));
            }
        } else {
            Customer customer = new Customer();
            customer.setNameCustomer(req.getParameter("login"));
            customer.setPasswordCustomer(req.getParameter("password"));
            if (findObject.addCustomer(customer)) {
                session.setAttribute("access", "loginOk");
                session.setAttribute("user", req.getParameter("login"));
            }
        }
    }
}
