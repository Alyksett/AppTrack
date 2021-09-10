import java.util.HashMap;

public class Driver {
    static HashMap<String, Company> database = new HashMap<String, Company>();

    public static void main(String[] args){
        

        MyFrame GUI = new MyFrame();
        GUI.setVisible(true);

    }

    public boolean addApplication(String name, String date, String OA, String rejected, String notes){
        
        database.add(name, new Company(name, date, OA, rejected, notes));
        
        return false;
    }
}
