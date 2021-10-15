/** This class is responsible for taking user inputs for the choice of event
 * and translating them to other use Case Classes.
 * This class also displays anything from other classes
 */
package main.java;
import java.util.Scanner;

public class userInterface {
    //This Scanner object takes the input on the next line, it will be used commonly
    Scanner input = new Scanner(System.in);

    public String getName(){
        /*This method will get the name of the user used at the beginning of the game*/
        this.displayDecisions("Please enter your name: ");
        return input.nextLine();
    }

    public String getStatus(){
        //TODO: decide what this function gets the status of
        return "TODO";
    }

    public String choiceOfProvince(){
        /* Maybe a go or not. Choose what province you will fight as*/
        //TODO: decide if we will allow the user to choose a province to start as
        return "CHOICE OF PROVINCE";
    }

    public int getDecisions(String decisions){
        /* Display choices and Get the choice of the player, and return the choice as an integer*/
        this.displayDecisions("Please choose your choice:");

        //TODO: update this when we know how decisions will be given
        displayDecisions("1. Nobility \n2. Peasant");
        return Integer.parseInt(input.nextLine());
    }

    public void displayDecisions(String decisions){
        /*This method will display the decisions or text that is given to it*/
        System.out.println(decisions);
    }

    public void startPlayer() {
        System.out.println("What is your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        api.runStartPlayer(name);
    }
    public static userInterface initializeUI() {
        userInterface ui = new userInterface();
        return ui;
    }
}
