package view;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String>{
    public Menu() {
        super();
    }

    public void print(){
        for(String s : this){
            System.out.println(s);
        }
    }
     
    static int getInt(String msg){
        int val=0;
        boolean check=false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            try{
              val = Integer.parseInt(sc.nextLine());
              if((val>=1)&&(val<=5)){
                    check = true;
              }
              else{
                  System.out.println("Wrong Input!!");
              }
            } catch(NumberFormatException e){
                System.out.println("Wrong Input!!");
            }
        } while(check==false); 
        return val;
     }
    public int getUserChoices(){
        return getInt("Enter your choose: ");
    }
}