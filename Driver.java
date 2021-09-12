/** 
 * 
 * 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;


public class Driver {
    static HashMap<String, Company> database = new HashMap<String, Company>();
    public static void main(String[] args) throws IOException, ParseException{
        MyFrame GUI = new MyFrame();
        openFile();
        GUI.setVisible(true);
        MyFrame.updateAppCounter();
    }
    public static void saveFile() throws IOException{
        Gson gson1 = new Gson();

        try(Writer writer = new FileWriter("dataSave.json")){
            gson1.toJson(database, writer);
        }
    }
    public static void openFile() throws IOException, ParseException{

        try(FileReader reader = new FileReader("dataSave.json")){

            TypeReference<HashMap<String, Company>> typeRef = new TypeReference<>() {};
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Company> mapping = mapper.readValue(reader, typeRef);
            
            database.putAll(mapping);            
        }
        catch(FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public static boolean addApplication(String name, String date, String OA, String rejected, String notes){
        
        database.put(name, new Company(name, date, OA, rejected, notes));
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

    public static int getTotalApplications(){
        //System.out.println(database.get("Company name").getApplyDate());
        return database.keySet().size();
    }
}
