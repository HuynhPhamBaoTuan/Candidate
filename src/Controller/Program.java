package Controller;

import java.util.ArrayList;
import java.util.Collections;
import Common.Algorithm;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;

public class Program {
    static ArrayList<Candidate> cnd_list = new ArrayList<>();
    public static void createCandidate(int type){
        System.out.println("Create new candidate:");
        boolean loop=true;
        do{
            int id;
            boolean invalid=false;
            do{
               id = Algorithm.getInt("Enter id: ");
               if(cnd_list.size()>=1){
                  for(Candidate cnd : cnd_list){
                    if(cnd.getId()==id){
                      invalid=true;
                      System.out.println("This id has already existed!");
                      break;
                    }
                  }
                }
            } while(invalid);
            String firstname = Algorithm.GetString("Enter first name: ", false);
            String lastname = Algorithm.GetString("Enter last name: ", false);
            String address = Algorithm.GetString("Enter address: ", false);
            String phone = Algorithm.getPhone("Enter phone number: ");
            String email = Algorithm.getEmail("Enter email: ");
            int birthdate = Algorithm.getDate("Enter birth date(year): ");
            Candidate cnd = new Candidate(id, phone, firstname, lastname, address, birthdate, type, email);
            Program program = new Program();
            switch(type){
               case 0:
                   program.createExperience(cnd);
                   break;
               case 1:
                   program.createFresher(cnd);
                   break;
               case 2:
                   program.createIntern(cnd);
                   break;
            }
            if(Algorithm.GetYesNo("Do you want to continue (Y/N)? ")==false){
                loop=false;
                System.out.println();
            }
       } while(loop);
       System.out.println("Candidate created: ");
       for(Candidate cnd : cnd_list){
           cnd.print();
       }
        System.out.println();
    }
    
    public void createExperience(Candidate cnd){
        System.out.println("Input informations of a experience candiate: ");
        int yearExp = Algorithm.getYear("Enter year of experience: ");
        String proskill = Algorithm.GetString("Enter professional skill: ", false);
        cnd_list.add(new Experience(cnd.getId(), cnd.getPhone(), cnd.getFirstname(), cnd.getLastname(), cnd.getAddress(), cnd.getBirthDate(), cnd.getCandidateType(), cnd.getEmail(), yearExp, proskill));
        System.out.println("Create experience candiate successfully!");
    }
    
    public void createFresher(Candidate cnd){
        System.out.println("Input informations of a fresher candiate: ");
        int graduate_date;
        do{
          graduate_date = Algorithm.getDate("Enter graduated time: ");
          if(graduate_date<cnd.getBirthDate())
                System.out.println("Graduated date must be larger than birth date!");
        } while(graduate_date<cnd.getBirthDate());
        String graduate_rank = Algorithm.getRank("Enter rank of graduation: ");
        String uni_edu = Algorithm.GetString("Enter university graduated from: ", false);
        cnd_list.add(new Fresher(cnd.getId(), cnd.getPhone(), cnd.getFirstname(), cnd.getLastname(), cnd.getAddress(), cnd.getBirthDate(), cnd.getCandidateType(), cnd.getEmail(), graduate_date, graduate_rank, uni_edu));
        System.out.println("Create fresher candiate successfully!");
    }
    
    public void createIntern(Candidate cnd){
        System.out.println("Input informations of a intern candiate: ");
        String majors = Algorithm.GetString("Enter majors: ", false);
        int semester = Algorithm.getInt("Enter semester: ");
        String uni_name = Algorithm.GetString("Enter university studying: ", false);
        cnd_list.add(new Intern(cnd.getId(), cnd.getPhone(), cnd.getFirstname(), cnd.getLastname(), cnd.getAddress(), cnd.getBirthDate(), cnd.getCandidateType(), cnd.getEmail(), majors, semester, uni_name));
        System.out.println("Create intern candiate successfully!");
    }
    
    public void displayClassifiedCandidate(){
        int id=0;
        String firstname="", lastname="", address="", phone="", email="";
        int birthDate=0;
        int typeCandidate=0;
        Candidate cnd_cmp = new Candidate(id, phone, firstname, lastname, address, birthDate, typeCandidate, email);
        Collections.sort(cnd_list, cnd_cmp);
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for(Candidate cnd : cnd_list){
            if(cnd instanceof Experience)
                System.out.println(cnd.getFirstname()+" "+cnd.getLastname());
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for(Candidate cnd : cnd_list){
            if(cnd instanceof Fresher)
                System.out.println(cnd.getFirstname()+" "+cnd.getLastname());
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for(Candidate cnd : cnd_list){
            if(cnd instanceof Intern)
                System.out.println(cnd.getFirstname()+" "+cnd.getLastname());
        }
        System.out.println();
    }
    
    public void searchCandidate(){
        Program program = new Program();
        program.displayClassifiedCandidate();
        int id=0;
        String firstname="", lastname="", address="", phone="", email="";
        int birthDate=0;
        int typeCandidate=0;
        Candidate cnd_cmp = new Candidate(id, phone, firstname, lastname, address, birthDate, typeCandidate, email);
        Collections.sort(cnd_list, cnd_cmp);
        String searchName = Algorithm.GetString("Input Candidate name (First name or Last name): ", false);
        int input_type = Algorithm.getCandidateType("Input type of candidate: ");
        boolean exist = false;
        System.out.println("The candidates found:");
        for(Candidate cnd : cnd_list){
            if((cnd.getFirstname().contains(searchName)||cnd.getLastname().contains(searchName)) && cnd.getCandidateType()==input_type){
                System.out.println(cnd.getFirstname()+" "+cnd.getLastname()+" | "+cnd.getBirthDate()+" | "+cnd.getAddress()+" | "+cnd.getPhone()+" | "+cnd.getEmail()+" | "+cnd.getCandidateType());
                exist = true;
            }
        }
        if(exist==false) System.out.println("The candidate do not exist!");
    }   
}