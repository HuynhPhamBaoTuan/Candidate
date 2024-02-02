package Model;

public class Fresher extends Candidate{
    private int Graduate_date;
    private String Graduate_rank;
    private String Education;

    public Fresher(int id, String phone, String firstname, String lastname, String address, int birthDate, int CandidateType, String email, int Graduate_date, String Graduate_rank, String Education) {
        super(id, phone, firstname, lastname, address, birthDate, CandidateType, email);
        this.Graduate_date = Graduate_date;
        this.Graduate_rank = Graduate_rank;
        this.Education = Education;
    }

    public int getGraduate_date() {
        return Graduate_date;
    }

    public String getGraduate_rank() {
        return Graduate_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setGraduate_date(int graduate_date) {
        this.Graduate_date = graduate_date;
    }

    public void setGraduate_rank(String graduate_rank) {
        this.Graduate_rank = graduate_rank;
    }

    public void setUni_edu(String uni_edu) {
        this.Education = uni_edu;
    }
}