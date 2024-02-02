package Model;

public class Experience extends Candidate{
    private int ExpInYear;
    private String ProSkill;
    
    public Experience(int id, String phone, String firstname, String lastname, String address, int birthDate, int CandidateType, String email, int expinyear, String proskill){
        super(id, phone, firstname, lastname, address, birthDate, CandidateType, email);
        this.ExpInYear = expinyear;
        this.ProSkill = proskill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public String getProskill() {
        return ProSkill;
    }

    public void setExpInYear(int expinyear) {
        this.ExpInYear = expinyear;
    }

    public void setProskill(String proskill) {
        this.ProSkill = proskill;
    }
}