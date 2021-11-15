/**
 *
 * This class is responsible for taking user inputs for the choice of event
 * and translating them to other use Case Classes.
 * This class also displays anything from other classes
 *
 */
package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //This Scanner object takes the input on the next line, it will be used commonly
    Scanner input = new Scanner(System.in);

    public String getDecisionsChoice(){
        /* Display choices and Get the choice of the player, and return the choice as a string
         *
         * This function should be called after display decisions so that the UI is clean and makes sense*/
        displayText("Please choose your choice (Enter a number, 1-3):");
        String choice = input.nextLine();
        // The following line is how many choices we provide
        List<String> validChoices = Arrays.asList("1","2","3");
        boolean valid = validChoices.contains(choice);

        // This function will loop until it gets a valid input
        while (!valid) {
            displayText("Please enter a valid choice (Enter a number, 1-3)");
            choice = input.nextLine();
            valid = validChoices.contains(choice);
        }

        return choice;
    }

    public int getDecisionValues(String decision, int maximum){
        /** Gets the value that the player wants to spend to gain a specific resource
         *
         * @param decision 1 is how much money player spends for food, 2 is how many civilians for soldiers, and 3 is
         *                 money gain for civilians.
         */
        String choice = null;
        boolean intAsStr = true;
        boolean isValid = false;
        List<String> validChoices = Arrays.asList("1","2","3","4","5","6","7","8","9","0");

        while (!isValid){
            if (decision.equals("1")){
                displayText("How much money will you pay to gain food? Conversion rate for food is 1 gold = 2 food");
                choice = input.nextLine();
            }

            else if (decision.equals("2")){
                displayText("How many civilians will you give to gain soldiers? " +
                        "Conversion rate for soldiers is 1 civilian = 1 soldier");
                choice = input.nextLine();
            }

            else{
                displayText("How many civilians will you tax more to gain money? " +
                        "Conversion rate for money is 1 civilian = 2 gold");
                choice = input.nextLine();
            }

            String[] checks = choice.split("");

            for (String curr: checks){
                if (!validChoices.contains(curr)){
                    intAsStr = false;
                    break;
                }
                intAsStr = true;
            }

            // check if given input is valid
            if (!intAsStr){
                displayText("Your input is not valid! Enter a number:");
            }
            else if (Integer.parseInt(choice) > maximum){
                displayText("Your maximum is "+ maximum+"! You have passed this. Please enter a valid number");
            }

            else {
                isValid = true;
                displayText("Adjustments will be made shortly.");
            }
        }

        return Integer.parseInt(choice);
    }

    public String getEventChoice(){
        /* This even is very similar to getDecisions, but it only gets a y/n for events.

        upper or lower case is accepted */
        this.displayText("Do you want this event Y/N?");
        String choice = input.nextLine();
        List<String> validChoices = Arrays.asList("Y","N","y","n");
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

    public List startPlayer() {
        this.displayText("What is your name: "); // ask user for their name
        String name = input.nextLine();

        // choosing a name for the province that the player will play as
        this.displayText(name + ", choose a name for your province:");
        String provinceName = input.nextLine();

        this.displayText(name + ", your province name is " + provinceName);
        return Arrays.asList(name, provinceName);
    }

    public boolean beginBattle() {
        // A method that asks the user if the want to battle, and returns a boolean based on answer
        this.displayText("Would you like to battle? Y/N:");
        String choice = input.nextLine();
        List<String> validChoices = Arrays.asList("Y","N","y","n");
        boolean valid = validChoices.contains(choice);

        //this function will loop until a valid input is given
        while (!valid) {
            this.displayText("Please enter a valid choice (Enter Y/N)");
            choice = input.nextLine();
            valid = validChoices.contains(choice);
        }

        if (choice.equals("n") || choice.equals("N")){
            return false;
        }

        return true;
    }

    public static UserInterface initializeUI() {
        UserInterface ui = new UserInterface();
        return ui;
    }
    
    public Boolean askLoad(){
        this.displayText("Would you like to load a previous save?(Y/N): ");
        String ans = input.nextLine();
        if (ans.equals("Y") || ans.equals("y")){
            return true;
        }
        return false;
    }

    public String getFilePathLoad(){
        this.displayText("Please paste the file path of where the folder containing save.ser save file is");
        String ans = input.nextLine();
        if (ans.endsWith("/") || ans.endsWith("\\") )
        {
            ans = ans + "save.ser";
        }
        else {
            ans = ans + "/save.ser";
        }

        return ans;
    }

    public String getFilePathSave(){
        this.displayText("Please paste the file path of folder of where you would like to save file to be");
        String ans = input.nextLine();
        if (ans.endsWith("/") || ans.endsWith("\\") )
        {
            ans = ans + "save.ser";
        }
        else{
            ans = ans + "/save.ser";
        }

        return ans;
    }
}
