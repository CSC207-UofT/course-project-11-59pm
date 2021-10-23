package main.java;
import java.util.ArrayList;


public class Decisions {
    private ArrayList<String> decisionQuestions = new ArrayList<>();

    public Decisions() {
        this.decisionQuestions.add("Do you want to boost your food for one round?");
        this.decisionQuestions.add("Do you want to enlist more soldiers?");
        this.decisionQuestions.add("Do you want to increase revenue?");
    }

    public ArrayList<String> getDecisionQuestions() {
        return decisionQuestions;
    }

    public void displayQuestions(){
        for(int i = 0; i < decisionQuestions.size(); i++){
            System.out.println(decisionQuestions.get(i));
        }
    }
}
