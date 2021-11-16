











**Phase 1**

**Project Domain: Rajan’s Conquest**

**Collaborators: Ansh, Armaan, Carson, Kowan, Howard, Girish, Sayna**











**Updated program specification:**

The game “Raja’s Conquest” is running through the main file. When the program runs, the game asks the client whether they want to load or save a game state, where the client can answer yes (Y) or no (N) to.  After that the client is prompted to choose a name for the province they will be controlling and playing against the AI provinces in the game (There will be 4 other provinces in the game). Once the player has chosen a name for their province, the game will randomly generate values (preset ranges for the attributes) for the resources that the province will have, such as the number of civilians, soldiers, food, and gold. The game then moves into the decision-making phase, where the user gets to either have an special event that has (Y/N) choice and we have predetermined what happens when they select either of those options for various events that may come up. In other cases, if the user doesn’t want to say “Y” to a special event, then the normal decisions starts to take place (displaying the 3 questions at each turn) where the user gets to make a choice between whether they want to boost their food resources, enlist more soldiers, or increase revenue. Each of these decisions will cost different types of resources and after the choice is made the user will choose how much of these resources they would like to obtain. Next, there would be 3 turns in total which concludes a round. The round can have a mixture of the decisions and the special events which is all dependent on the answer that the user provides (but we decided to keep the ratio between special events:decisions as 0.40: 0.60). 

Next up, after a round is finished, all the values are displayed to the user that comprises the name of the province, and their attributes that includes: Soldier and Civilians Count, Food Count, and Gold Count within the province . This provides an insight to the user as to what’s happening around the game along with their own province. The user is prompted whether they want to go into a battle, in which the player is again asked to make a Y/N choice. When chosen Y, the Battle starts where the user is given the list of provinces that are active (alive) or survive during that round and then the user gets to choose which of the following AI provinces they would like to battle. Following this, the user then enters a battle with the desired province they want to battle (which happens within the backend) and then the winner of the battle is displayed to the user at the end. After the winner is announced, if the province is left with no people remaining, specifically, no soldier or civilians left, they become inactive (dead), that is notified within the terminal to the user. 

`	`The Battle and Decision making process continues to loop back and forth until the user loses a battle and dies (given they lost either all their civilians or soldiers are lost) or if the user manages to conquer every AI province, therefore the user wins the game!






**Previous program specification: (From Phase 0)**

This game will be an adventure game within a fantasy world where the player will get the chance to win by conquering the other provinces. The player begins the game as the ruler of their own province. Each province (AI) will have its own individual set of skills, which can be earned by the player through playing the game and conquering said provinces. Each month within the game, the player will be given 3 decision-making choices that can increase or decrease the player’s attributes while other provinces make decisions simultaneously. Each province has the choice of attacking another faction or not attacking at all: at the end of the year, the decisions are made on the “battle day”. Towards the end of the month (after the three choices are done), players will be asked if they want to start a battle and choose between the provinces. 

Running the program creates a new userInterface through an API call, which creates the new user interface instance in the userInterface class file. The user interface starts a dialogue during which the user enters their name. Then the API creates a new Player object using the given name, whereupon the GameManager class starts the whole game cycle and presents choices for the player to make. The player can enter 1, 2, or 3 acceptable numbers to choose choices on a line that says “input:” to the player. The program is designed to ignore cases since the options are only 1, 2, 3, or an acceptable number for the inputs. The program is limited to very few inputs, and if the player does not give a valid input, they are asked to choose again.

At the end of each turn, there is a possibility that a random event can occur, chosen randomly through the hashmap events class. One of the player’s three decisions a month will be replaced with a method to address the event instead. During the battle day, the Player can ration the number of troops between a battle with a province. To keep things simple for now, we will only allow players and provinces to be in a single battle at a time (between a player and one province only) and disallow other provinces to attack during the battle day. 

**New Design Decisions:** 

- **Deleted the Player class:** As a group, we decided that it would be better to have one class making decisions for how the game work rather than have two classes interact with each other to make decisions. We realized that the two classes did the same work which could lead to code smells in the future as well as duplication of the two classes that function the same way. We decide to make the provinces the main element instead of further dividing up the provinces into user-controlled or Ai-controlled. This ultimately got rid of a lot of duplication happening in the province class and the Player classes. 
- **Removed the runner, Controller Class:** There were too many unnecessary layers between the outer layer of the program and the entities. Thus, we decided to remove the layers since it was highly redundant and had the GameManager run through the main file which has the same functionality as runner and the controller class. 
- **Refactored the GameManager Class to GameEngine and organized how it functions:** We thought that the name “engine” suited the class much better as it is the core class of how the game runs. Before the modification of this class had a lot of unnecessary methods that did not cover much ground. Now GameEngine interacts with all the entities and use cases of our program along with our output UserInterface class.
- **Province has a builder design pattern:** For phase 0, we Before our province class was a simple class that was used by both user and AI players. To simplify how the province is used the Builder design pattern is used to create AI and user provinces for the game. We created a builder design pattern for the province class to avoid cluttering the GameEngine with province constructors. The builder design province performs the same functionality as before with the same attributes (Gold, Food, Civilians, Soldiers and province name), we decide to make another attribute be part of the province which is the province captured. This attribute represents the provinces captured by a province after winning against them in war. 
- **Packaging:** We began packaging our files for a cleaner architecture.
- **Added serialization to GameState:** To be able to save to files we added serialization to our code
- **Battle Class modification:** Before the modification, the battle class took in a hashmap of all the provinces (AI and User) that wanted to go into battle and made them go into battle. The new Battle class simply takes one AI province of the user’s choice and makes the User province and the chosen AI province go into battle. This implementation makes the game easier to track.

**Adhering to Clean Architecture:** 

Within our project, each class that we have constructed belongs to a layer that fulfills a certain policy. Our entity classes, such as Battle, GameState, Decisions, Events, and ProvinceConstruction package are higher-level policies and they have no knowledge of the outer layer classes. Within the entity classes, there is no mention of classes that are a part of the outer layer. The Use Case classes that we have are the GameEngine, ProcessValues, AIDecisionMaker are the classes that manipulate the entities and specify how the game is supposed to be run. UserInterface is the outermost layer of our program and it interacts with the use case classes only. All other outputs of the Entity classes must go through the use case classes (mostly GameEngine) to have output through the UserInterface.

**Consistency with the SOLID Design Principles:**

- **SRP:** All the classes that we have in our program simply take care of one task. The task that they take care of is what they are named after, for example, the battle class is simply named after taking care of the task of performing a battle between two provinces.
- **OCP:** So far all of the classes we have implemented are meant for a running game, though we have left enough room to be able to add new features to our game. An example of this would be our Events class where we could keep adding new events which a player can choose from and that does not change the way other methods in that class interact with such a change.
- **LSP:** Rather than using superclasses within object-oriented programming, we just implemented interfaces which followed the design principles as demonstrated in other portions of the code.
- **ISP:** The interfaces that we have within our program are simple and straightforward and are simply designed to help with what they are needed for. An example of this is the ProvinceLayout interface that simply has the getter and setter methods for a province.
- **DIP:** Classes which are implementing interfaces cannot be seen by the client code, ensuring that client code consumes the interface. Through the hierarchical deconstruction of high-level code to level-code that defers dependencies from the former to the latter, we are ensuring that aspects of the code that are very “volatile” are not heavily relied on.

**Packaging Strategies:**

When it came to deciding the packaging strategies, we initially thought about using packaging by layer but then came to the conclusion that it might be the most optimal way to package our files. Then our group decided that packaging by feature, therefore the files that interact with each other the most will be in the same package in order to minimize the number of imports.

**Design patterns your group has implemented:**

In this Phase 1, our group implemented 3 new design patterns, one being serialization for the GameState, where the state of the game is saved and can, later on, be retrieved from a file. The second design pattern that was implemented is the builder design pattern for the class Provinces. We decided to add such a design pattern to distinguish between building an AIProvince and a UserProvince. Additionally, one of the reasons was to avoid cluttering the GameEngine with a bunch of province constructors. The builder design pattern allows for a cleaner construction of the provinces. Furthermore, the builder design pattern allows for further enhancements down the line if we plan to make a change with province attributes, functionality, and other activities. We also added a memento design pattern to the provinces to keep track of the previous states of Provinces Objects that occur during the game. We need to keep track of this to have it displayed after each round to let the user know about the progress they have made and the effect it has on their attributes. The use of this is to help the user to not scroll up and down in order to keep a track.

**UML Diagram:**


` `**Progress Report:**

- open questions your group is struggling with
- what has worked well so far with your design
- **a summary of what each group member has been working on and plans to work on next**

**Open Questions:** 

- **Question 1:** How can we test UserInterface class using joint tests? Currently, we are manually testing the input-output system in UserInterface and making sure that only usable inputs are accepted. How can we test if we must input things to see if they work correctly?
- **Question 2:** What exactly is workspace.xml, and how does it contribute to the development of our program? Furthermore, why does it always serve as a nuisance when we’re trying to commit and push?
- **Question 3:** What is a general rule of thumb for iteration? Sometimes, we have something occur two or three times, and we are unsure whether we should just create a loop or do them one by one. Should we just decide this based on how much code would be in the iterative body?

**Worked well so far with the Design:** 

`	`Within the design so far, we think that our design follows the clean architecture and design principles that were discussed in class. As the program sticks to the principles of clean architecture, we also manage to keep good layers and separation between the entities, use cases and Ui’s. The design itself should extendable with the help of the implementation that we created using builder design pattern, since it opens up various paths to add many variables that can lead to make the game complicated as well as extendable for Phase 2. 

**Summary of Contributions to the Project**

**Ansh:** Implemented the Memento Design Pattern with Sayna, Province Class (initially) and Discussed the implementation of the Design Pattern with Armaan. Other Areas that I helped wherever needed such as in the GameEngine. In the future, as the game gets complicated I plan on adding more attributes to the province class and then further refining the design patterns that I worked on with Armaan and Sayna. 

**Armaan:** Implemented the ProvinceConstruction package which uses the builder design pattern. Worked on other tasks with Ansh. I plan to add more attributes to the provinces in the near future and work on possibly changing how the ProvinceConstruction might perform as we enhance the game for Phase2. Also, plan on aiding Ansh with any tasks he needs. 

**Kowan:** Worked on and continues to update UserInterface so that all other classes that require user input get what they need. Other group members can assume they get the input they want, and that reduces what they need to worry about. Also developed is the AIDecision maker, which for now is just a simple AI that controls the computer AI. Will continue to keep the UserInterface up to date and add more stylistic changes so that output looks better. Will continue to develop AIDecisions so that ai is more sophisticated and can make better decisions governing the province based on each province's attributes making the game more difficult for the human player.

**Girish:** Worked on and updated the gameState package, which works better with other classes compared to phase 0. Helped with the restructuring of the battle class with Ansh and Sayna. Aided Howard and Carson with restarting the base game and starting fresh. In the future I will create a better system to efficiently create save points, and load the latest points.**  

**Sayna:** helped with the development and writing of test cases for class Battle. helped write the memento design pattern with Ansh and Armaan. For phase 2 planning on working on extending the battle class to be able to get more fair outcomes out of a battle between provinces. The battle class could also be extended to have more than one province go into battle at a time (hashmap idea).

**Carson:** Designed and implemented the Game Engine, and fixing bugs with Howard. Also helped with other classes and problems they ran into while implementing their classes while giving them what is required by the GameEngine: for example, Battle and UserInterface. 

**Howard:** Designed and implemented the GameEngine and did all the linking between the Entity, Use Case, UserInterface along with Carson. Also implemented the ProcessValues class. Further fixed bugs that came across during the running process of the game. 

**\*\*NOTE: We all contributed with the Refactoring, Documentation, Document, and the Slides. \*\***	
