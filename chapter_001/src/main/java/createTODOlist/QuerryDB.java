package createTODOlist;

/**
 * Класс для преобразования полученных данных к формату TASK, по двум параметрам.
 */
public class QuerryDB {
    private String desc;
    private String done;

    public QuerryDB(String desc, String done) {
        this.desc = desc;
        this.done = done;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getDone() {
        Boolean result = false;
        if (this.done.equals("true")) {
            result = true;
        }
        return result;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
