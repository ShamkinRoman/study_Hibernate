package createTODOlist;

import com.google.gson.Gson;

import java.util.List;

public class ServiceDB implements AutoCloseable {
    private StoreDB storeDB = new StoreDB();

    public QuerryDB makeQuerryDB(String string) {
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
