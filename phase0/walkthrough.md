### Scenario Walkthrough

When the user runs the runner file, it instantiates an object of the userInterface class using an api function call. Through the userInterface object, the ui can prompt the user for their name, which is used by the api class to create a new Player class for the user. The Player class is used by the GameManager class, which runs and manages the entire game. The GameManager class creates five instances of the Province class with their own values: four are AI-controlled, and the fifth is assigned to the player. Then, the api function call instantiates a GameManager class which the gameState uses to save the province and player statistics to an ArrayList, which are continually updated as the game progresses (after each battle/event decision). 

