package todolist;

import com.google.gson.Gson;

import java.util.List;

/**
 * Класс для преобразования из (в) строки формата JSON в String, с последующей записью(выдачи) данных БД.
 */
public class ServiceDB implements AutoCloseable {
    private final StoreDB storeDB = StoreDB.getInstance();
    private static ServiceDB INSTANCE = new ServiceDB();

    private ServiceDB() {
    }

    public static ServiceDB getINSTANCE() {
        return INSTANCE;
    }

    protected QuerryDB makeQuerryDB(String string) {
        Gson gson = new Gson();
        QuerryDB taskToAdd = gson.fromJson(string, QuerryDB.class); //Подставной класс для удобства.
        System.out.println("incoming task " + taskToAdd.toString()); // для проверки.
        return taskToAdd;
    }

    protected void addTask(String string) {
        storeDB.addTask(makeQuerryDB(string));
    }

    protected List<Task> getListTask(String string) {
        return storeDB.getListTask(string);
    }

    protected String getListTaskAsJson(String string) {
        String json = new Gson().toJson(getListTask(string));
        return json;
    }

    @Override
    public void close() {
        try {
            storeDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
