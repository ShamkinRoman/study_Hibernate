package saleCars;

import com.google.gson.Gson;
import mappingXML.Item;

import java.util.List;

public class ServiceItem implements AutoCloseable{
    private final StorageItem storage = StorageItem.getInstance();
    private static ServiceItem INSTANCE = new ServiceItem();

    private ServiceItem() {
    }

    public static ServiceItem getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void close() throws Exception {
        this.storage.close();
    }

    protected List<Item> getListTask(String string) {
        return storage.getListTask(string);
    }

    protected String getListTaskAsJson(String string) {
        String json = new Gson().toJson(getListTask(string));
        return json;
    }

}
