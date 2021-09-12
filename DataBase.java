import java.util.HashMap;

public class DataBase {
    HashMap<String, Company> database;
    public DataBase(){
        database = new HashMap<String, Company>(){};
    }

    public HashMap<String, Company> getDataBase(){
        return database;
    }
}
