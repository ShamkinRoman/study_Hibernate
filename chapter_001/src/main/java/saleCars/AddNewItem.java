package saleCars;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class AddNewItem extends HttpServlet {
    private final ServiceItem service = ServiceItem.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/newItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        String s;
        System.out.println("In POST method");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = req.getReader();
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Kostyl kostyl = gson.fromJson(sb.toString(), Kostyl.class);
        System.out.println(kostyl);
        System.out.println(kostyl.getBodyCar());
        System.out.println(kostyl.getEngine());
        System.out.println(kostyl.getTransmission());
        System.out.println(kostyl.getUser());
    }
}

