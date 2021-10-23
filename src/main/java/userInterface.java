/** This class is responsible for taking user inputs for the choice of event
 * and translating them to other use Case Classes.
 * This class also displays anything from other classes
 */
package main.java;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

    public String getDecisions(){
        /* Display choices and Get the choice of the player, and return the choice as a string
        *
        * This function should be called after display decisions so that the UI is clean and makes sense*/
        this.displayDecisions("Please choose your choice (Enter a number, 1-5):");
        String choice = input.nextLine();
        // The following line is how many choices we provide
        List<String> validChoices = Arrays.asList("1","2","3","4","5");
        boolean valid = validChoices.contains(choice);

        // This function will loop until it gets a valid input
        while (!valid) {
            this.displayDecisions("Please enter a valid choice (Enter a number, 1-5)");
            choice = input.nextLine();
            valid = validChoices.contains(choice);
        }

        return choice;
    }

    public void displayDecisions(String decisions){
        /*This method will display the decisions or text that is given to it*/
        System.out.println(decisions);
    }

    public void startPlayer() {
        System.out.println("What is your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        controller.runStartPlayer(name);
    }
    public static userInterface initializeUI() {
        userInterface ui = new userInterface();
        return ui;
    }
}
