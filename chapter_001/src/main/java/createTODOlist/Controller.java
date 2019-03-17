package createTODOlist;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class Controller extends HttpServlet {
    private List<Task> task;
    private List<Task> temp;
    SessionFactory factory;
    Session session;

    @Override
    public void init() throws ServletException {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
    }

    @Override
    public void destroy() {
        session.close();
        factory.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session.beginTransaction();
        temp = session.createQuery("from Task").list();
        if (!req.getParameter("show").equals("all")) {
            task = temp.stream().filter(x -> x.getDone()).collect(Collectors.toList());
        } else
            task = temp;
        String json = new Gson().toJson(task);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        writer.append(json);
        writer.flush();
        session.getTransaction().commit();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        String s;
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = req.getReader();
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            QuerryDB desc = gson.fromJson(sb.toString(), QuerryDB.class);
            session.beginTransaction();
            Task task = new Task();
            task.setCreated(new Timestamp(System.currentTimeMillis()));
            task.setDesc(desc.getDesc());
            task.setDone(false);
            session.saveOrUpdate(task);
            session.getTransaction().commit();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
