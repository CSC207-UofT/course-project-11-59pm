package com.company.UI;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
/**
 *
 * This class is responsible for taking user inputs for the choice of event
 * and translating them to other use Case Classes.
 * This class also displays anything from other classes
 *
 */

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

    /** Gets the value that the player wants to spend to gain a specific resource
     *
     * @param decision 1 is how much money player spends for food, 2 is how many civilians for soldiers, and 3 is
     *                 money gain for civilians.
     */
    public int getDecisionValues(String decision, int maximum){

        String choice = null;
        boolean intAsStr = true;
        boolean isValid = false;

        while (!isValid){
            // Get value that player wants
            choice = getDecisionHelper(decision);

            // Split given number into string compenents
            String[] checks = choice.split("");

            // Check that given string is in the numbers
            intAsStr = checkValid(checks,intAsStr);

            // check if given input is valid
            if (!intAsStr){
                displayText("Your input is not valid! Enter a number:");
            }
            else if (Integer.parseInt(choice) > maximum){
                /** NOTE: if the value is too large, the program will crash! This is due to a parseInt problem that we
                cannot fix! */
                displayText("Your maximum is "+ maximum+"! You have passed this. Please enter a valid number");
            }

            else {
                isValid = true;
                displayText("Adjustments will be made shortly.");
                displayText("\n");
            }
        }

        return Integer.parseInt(choice);
    }
    /** Gets the value that the player wants to spend to gain a specific resource
     *
     * @param checks a list of characters to check if they are valid
     * @param intAsStr if the string is valid
     */
    public boolean checkValid(String[] checks, Boolean intAsStr){
        List<String> validChoices = Arrays.asList("1","2","3","4","5","6","7","8","9","0");

        for (String curr: checks){
            if (!validChoices.contains(curr)){
                intAsStr = false;
                break;
            }
            intAsStr = true;
        }

        return intAsStr;
    }

    /** Gets the value that the player wants to spend to gain a specific resource
     *
     * @param decision returns the player choice
     */
    public String getDecisionHelper(String decision){
        String choice;
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
        return choice;
    }

    public String getEventChoice(){
        /* This even is very similar to getDecisions, but it only gets a y/n for events.

        upper or lower case is accepted */
        this.displayText("Do you want this event Y/N?");
        String choice = input.nextLine();
        return getString(choice);
    }

    private String getString(String choice) {
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
        return !getString(choice).equals("n") && !getString(choice).equals("N");
    }

    public String selectOpponent(List<String> opponentList) {
        // Allows user to pick an opponent

        for (int i = 1; i <= opponentList.size(); i++){
            this.displayText(i + ". " + opponentList.get(i - 1));
        }
        this.displayText("Select a number to indicate which opponent you would like to battle:");

        String choice = input.nextLine();

        List<String> validChoices = new ArrayList<>();
        for (int i = 1; i <= opponentList.size(); i++){
            validChoices.add(String.valueOf(i));
        }

        boolean valid = validChoices.contains(choice);

        //this function will loop until a valid input is given
        while (!valid) {
            this.displayText("Please enter a valid choice:");
            choice = input.nextLine();
            valid = validChoices.contains(choice);
        }

        return opponentList.get(Integer.parseInt(choice) - 1);
    }

    public static UserInterface initializeUI() {
        return new UserInterface();
    }

    public Boolean askLoad(){
        this.displayText("Would you like to load a previous save?(Y/N): ");
        String ans = input.nextLine();
        return ans.equals("Y") || ans.equals("y");
    }
    public Boolean askSummary() {
        this.displayText("Would you like to get a summary");
        String ans = input.nextLine();
        return ans.equalsIgnoreCase("Y");
    }

    public String getFilePathLoad(){
        this.displayText("Please paste the file path of where the folder containing save.ser save file is (Type 'default' for default filePath)");
        return getFile();
    }

    public String getFilePathSave(){
        this.displayText("Please paste the file path of folder of where you would like to save file to be  (Type 'default' for default filePath)");
        return getFile();
    }

    private String getFile() {
        String ans = input.nextLine();
        if (((Objects.equals(ans, "default") || (Objects.equals(ans, "Default"))))) {
            Path resourceDirectory = Paths.get("src");
            String filePath = resourceDirectory.toFile().getAbsolutePath();
            ans = filePath;
        }

        if (ans.endsWith("/") || ans.endsWith("\\") )
        {
            ans = ans + "save.ser";
        }
        else{
            ans = ans + "/save.ser";
        }

        return ans;
    }

    public ArrayList<Integer> askForBounds(){
        ArrayList<Integer> bounds = new ArrayList<>();
        this.displayText("Enter the lowest state values you require: ");
        int lowBound = input.nextInt();
        this.displayText("Enter the highest state values you require: ");
        int upBound = input.nextInt();
        bounds.add(lowBound);
        bounds.add(upBound);
        return bounds;
    }

    public void displaySummary(ArrayList provinceAttributes){
        System.out.println("====================================");
        System.out.println("Name: " + provinceAttributes.get(0));
        System.out.println("Gold: " + provinceAttributes.get(1));
        System.out.println("Civilians " + provinceAttributes.get(2));
        System.out.println("Soldiers " + provinceAttributes.get(3));
        System.out.println("Food " + provinceAttributes.get(4));
        System.out.println("====================================");
    }
}