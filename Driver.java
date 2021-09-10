import java.util.HashMap;

public class Driver {
    static HashMap<String, Company> database = new HashMap<String, Company>();

    public static void main(String[] args){
        

        MyFrame GUI = new MyFrame();
        GUI.setVisible(true);

    }

    public static boolean addApplication(String name, String date, String OA, String rejected, String notes){
        
        database.put(name, new Company(name, date, OA, rejected, notes));
        System.out.println("Add Application.");
        if(database.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    public static String[] getCompanyNames(){
        String[] nameArray = new String[database.keySet().size()];
        nameArray = database.keySet().toArray(nameArray);
        System.out.println("Get company names.");
        return nameArray;
    }

    public static void updateApplication(String name, String date, String OA, String appState, String Notes){
        database.get(name).updateApplyDate(date);
        database.get(name).updateOA(OA);
        database.get(name).updateAppState(appState);
        database.get(name).updateNotes(Notes);
        System.out.println("Update Application.");
    }

}
