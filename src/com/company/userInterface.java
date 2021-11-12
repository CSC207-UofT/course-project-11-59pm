/** This class is responsible for taking user inputs for the choice of event
 * and translating them to other use Case Classes.
 * This class also displays anything from other classes
 */
package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class userInterface {
    //This Scanner object takes the input on the next line, it will be used commonly
    Scanner input = new Scanner(System.in);

    public String getStatus(){
        //TODO: decide what this function gets the status of
        return "TODO";
    }

    public String getDecisionsChoice(){
        /* Display choices and Get the choice of the player, and return the choice as a string
         *
         * This function should be called after display decisions so that the UI is clean and makes sense*/
        this.displayText("Please choose your choice (Enter a number, 1-3):");
        String choice = input.nextLine();
        // The following line is how many choices we provide
        List<String> validChoices = Arrays.asList("1","2","3");
        boolean valid = validChoices.contains(choice);

        // This function will loop until it gets a valid input
        while (!valid) {
            this.displayText("Please enter a valid choice (Enter a number, 1-3)");
            choice = input.nextLine();
            valid = validChoices.contains(choice);
        }

        return choice;
    }

    public String getEventChoice(){
        /* This even is very similar to getDecisions, but it only gets a y/n for events.

        upper or lower case is accepted */
        this.displayText("Do you want this event Y/N?");
        String choice = input.nextLine();
        List<String> validChoices = Arrays.asList("Y","N");
        boolean valid = validChoices.contains(choice);

        //this function will loop until a valid input is given
        while (!valid) {
            this.displayText("Please enter a valid choice (Enter Y/N)");
            choice = input.nextLine();
            valid = validChoices.contains(choice);
        }
        return choice;
    }


    public void displayText(String Text){
        /*This method will display the decisions or text that is given to it*/
        System.out.println(Text);
    }

    public List<String> startPlayer() {
        this.displayText("What is your name: "); // ask user for their name
        String name = input.nextLine();

        // choosing a name for the province that the player will play as
        this.displayText(name + ", choose a name for your province:");
        String provinceName = input.nextLine();

        this.displayText(name + ", your province name is " + provinceName);
        return Arrays.asList(name, provinceName);
    }

    public static userInterface initializeUI() {
        userInterface ui = new userInterface();
        return ui;
    }
}
