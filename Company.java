public class Company {
    private String companyName;
    private String applyDate;
    private String OA;
    private String appState;
    private String notes;

    //constructor
    public Company(String name, String date, String newOA, String newRejected, String newNotes){
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
