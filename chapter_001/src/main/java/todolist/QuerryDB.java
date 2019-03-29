package todolist;

/**
 * Класс для преобразования полученных данных к формату TASK, по двум параметрам.
 */
public class QuerryDB {
    private String id=null;
    private String desc;
    private String done;


    public QuerryDB(String desc, String done) {
        this.desc = desc;
        this.done = done;
    }

    public QuerryDB(String id, String desc, String done) {
        this.id = id;
        this.desc = desc;
        this.done = done;
    }

    public Integer getId() {
        return id!=null ? Integer.parseInt(id) : null;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "QuerryDB{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", done='" + done + '\'' +
                '}';
    }
}
