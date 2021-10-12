package main.java;
import java.util.Scanner;

public class Controller {
    /* This class is responsible for taking user inputs for the choice of event and translating them to other use
    * Case Classes. This class also displays anything from other classes*/
    Scanner input = new Scanner(System.in);
    public String getName(){
        /*This method will get the name of the user used at the beginning of the game*/
        return "TO DO";
    }

    public String choiceOfProvince(){
        /* Maybe a go or not. Choose what province you will fight as*/
        return "CHOICE OF PROVINCE";
    }

    public int getDecisions(){
        /* Get the choice of the player, and return the choice as an integer*/
        int choice = 0;
        return choice;
    }

    public void displayDecisions(String decisions){
        /*This method will display the decisions that are given to it*/
        System.out.println(decisions);
    }

}
