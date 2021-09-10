public class Company {
    private String companyName;
    private String applyDate;
    private String OA;
    private String notes;

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

    public void updateNotes(String update){
        this.OA = update;
    }

}
