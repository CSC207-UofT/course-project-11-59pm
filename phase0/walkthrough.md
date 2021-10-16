### Scenario Walkthrough

When the user runs the runner file, it instantiates an object of the userInterface class using the api call. Through the userInterface object, the ui can prompt the user for their name, which is used by the api class to create a new Player class for the user. The Player class is used by the GameManager class, which runs and manages the entire game. The GameManager class creates five instances of the Province class with their own values: four are AI-controlled, and the fifth is assigned to the player. Then, the gameState saves the province and player statistics to an ArrayList, which are continually updated as the game progresses (after each battle/event decision). The GameManager then simulates rounds of the game through a while loop, using the userInterface to give the user three decisions each turn. After their three decisions for the round are made, the user must choose which, if any, province they would like to attack. Should they choose to fight another province, GameManager uses the Battle class to determine the outcome. All user-based interactions rely on api calls in order to utilize the userInterface.

The Player and Province classes update their statistics based on the Battle’s outcome, and the GameState class stores the new versions in the game files. At the end of each iteration, there is the possibility of an event occurring, whose type and magnitude is determined by the Event class. Upon beginning a new round, the userInterface will give the user two of their usually available decisions; the third will address the event. Additionally, the GameManager will check at the end of each iteration to see if the player has been defeated, or if all the other provinces have been defeated by accessing their statistics through the Player and Province classes. If either case occurs, the GameManager will present the winner and conclude the game.