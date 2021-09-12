import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Company {
    private String companyName;
    private String applyDate;
    private String OA;
    private String appState;
    private String notes;

    //constructor
    public Company(){
        companyName = "fix";
        applyDate = "fix";
        OA = "fix";
        appState = "fix";
        notes = "fix";
    }
    @JsonCreator
    public Company(
            @JsonProperty("companyName") String name, 
            @JsonProperty("applyDate")String date, 
            @JsonProperty("OA")String newOA, 
            @JsonProperty("appState")String newRejected, 
            @JsonProperty("notes")String newNotes) {
        this.companyName = name;
        this.applyDate = date;
        this.OA = newOA;
        this.appState = newRejected;
        this.notes = newNotes;
    }
    
    
    //accessor methods
    public String getComanyName(){
        return companyName;
    }

    public String getApplyDate(){
        return applyDate;
    }

    public String getOA(){
        return OA;
    }

    public String getAppState(){
        return appState;
    }

    public String getNotes(){
        return notes;
    }

    //mutator methods
    public void updateCompanyName(String name){
        this.companyName = name;
    }

    public void updateApplyDate(String date){
        this.applyDate = date;
    }

    public void updateOA(String update){
        this.OA = update;
    }

    public void updateAppState(String update){
        this.appState = update;
    }

    public void updateNotes(String update){
        this.notes = update;
    }

}
