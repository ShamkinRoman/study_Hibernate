package createTODOlist;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Сервлет ддя приема(передачи) данных из таблицы postgresql в формате JSON используюя HIBERNATE.
 */
public class Controller extends HttpServlet {
    private ServiceDB serviceDB = new ServiceDB();

    /**
     * Передаем записи их таблицы в зависимости от параметра show. All все, иначе только у которых поле done = TRUE.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException какой-то эксепшэн :).
     * @throws IOException      что - то странное.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String showAll = req.getParameter("show");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        writer.append(serviceDB.getListTaskAsJson(showAll));
        writer.flush();
    }

    /**
     * Метод для приема данных в формате JSON, преобразовании его к типу QuerryBD и записи в БД.
     *
     * @param req  запрос.
     * @param resp ответ.
     * @throws ServletException Ошибка1.
     * @throws IOException      Ошибка2.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        resp.setCharacterEncoding("UTF-8");
        String s;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = req.getReader();
            while ((s = reader.readLine()) != null) {
                sb.append(s);
            }
            serviceDB.addTask(sb.toString());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        serviceDB.close();
        super.destroy();
    }
}