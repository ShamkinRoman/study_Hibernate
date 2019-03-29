package cars.database;

public class test {
    public static void main(String[] args) {
        StorageDB storageDB = StorageDB.getINSTANCE();
        System.out.println(storageDB.getFinishCar());
        try {
            storageDB.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
