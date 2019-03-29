package saleCars;

import com.google.gson.Gson;
import mappingXML.FinishCar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GetItemFromDBController extends HttpServlet {

    ServiceItem service = ServiceItem.getINSTANCE();
    SessionFactory factory = SessionFactorySingleton.getSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("Hello from GET in getItemController");
        Session session = factory.openSession();
        session.beginTransaction();
        List<FinishCar> cars = session.createQuery("from FinishCar ").list();
        System.out.println(new Gson().toJson(cars));
        PrintWriter writer = resp.getWriter();
//        writer.append(toTranslite);
        writer.flush();
        session.close();
        System.out.println("В конце метода GET");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        String toTranslite = new Gson().toJson(service.getFinishCars());
        System.out.println(toTranslite);
        PrintWriter writer = resp.getWriter();
        writer.append(toTranslite);
        writer.flush();
    }
}
