# **Phase 2**

**Project Domain:**  **Rajan&#39;s Conquest**

**Collaborators: Ansh, Armaan, Carson, Kowan, Howard, Girish, Sayna**

### Updated program specification:

The game &quot;Rajan&#39;s Conquest&quot; runs through the main file. When the program runs, the game asks the client whether they want to load or save a game state, where the client can answer yes (Y) or no (N). If they say yes, the game picks up from the previous save with a welcoming message to the user. If they say no, the client is prompted to choose a name for themselves and the province that they will be controlling and playing against the AI provinces in the game, of which there are four. Once the player has chosen a name for their province, the game will randomly generate values (preset ranges for the attributes) for the resources that the province will have, such as the number of civilians, soldiers, food, and gold. The game then moves into the decision-making phase, where the user gets to act on presented events with a Y/N option; we have predetermined effects to the attribute when they select either of those options for any events that may come up. Depending on whether they accept the event, their stats will be adjusted accordingly. Additionally, the user can also be presented with standard decisions where the user gets to make a choice between whether they want to boost their food resources, enlist more soldiers, or increase revenue. These choices depend on the user (according to the limits of the game&#39;s logic) and are not locked in by the program. Each of these decisions will cost different types of resources, and after the choice is made the user will choose how much of these resources they would like to obtain. Overall, there would be three choices in total which concludes a round. The round can have a mixture of decisions and events, which is all dependent on the answers that the user provides (but we decided to keep the ratio between special events and decisions as 2 to 1).

Next up, after a round is finished, all the values are displayed to the user that comprises the name of the province, and their attributes that include: Soldier and Civilians Count, Food Count, and Gold Count within the province. This provides an insight to the user as to what&#39;s happening around the game along with their own province. The user is prompted whether they want to go into a battle, in which the player is again asked to make a Y/N choice. If Y is chosen, the Battle starts where the user is given the list of provinces that are active (alive) during that round, and then the user gets to choose which of the following AI provinces they would like to battle. Following this, the user then enters a battle with the desired province they want to battle (which happens within the backend), and then the winner of the battle is displayed to the user at the end. After the winner is announced, if the province is left with no people remaining, specifically, no soldier or civilians left, they become inactive (dead), which is notified within the terminal to the user. Then, every province&#39;s food value is reduced depending on the number of players. Lastly, before the round ends, the user has an option to get a summary of what has happened during a round. If Y is selected, then a tidy table with their attributes will be displayed. After every round, the gameState will be automatically saved to the save.ser file.

The Battle and Decision-making process continues to loop back and forth until the user loses a battle and dies (given they lost either all their civilians or soldiers are lost) or if the user manages to conquer every AI province and the user wins the game.

### New Design Decisions:

### \*\* They are combined from the Phase 0, Phase 1 and Phase 2\*\*

- **Deleted the Player class:** As a group, we decided that it would be better to have one class making decisions for how the game works rather than have two classes interact with each other to make decisions. We realized that the two classes did the same work which could lead to code smells in the future as well as duplication of the two classes that function the same way. We decide to make the provinces the main element instead of further dividing up the provinces into user-controlled or Ai-controlled. This ultimately got rid of a lot of duplication happening in the province class and the Player classes. This gets rid of the coupling between two entity classes as well as duplicate code, thus eliminating the code smells about duplication of code. **AIDecisionMarker** was also added based upon a random algorithm that decides for all AI provinces.

- **Removed the runner, Controller**  **C**** lass:** There were too many unnecessary layers between the outer layer of the program and the entities. Thus, we removed the layers since it was highly redundantand had the GameEngine run through the main file which has the same functionality as the runner and the controller class, just combined into one.

- **Province**  **has a builder design pattern:** For phase 0, our implementation of the building a province was predetermined within the constructor and Province class that stored all the attributes thatwere used by both User and AI players.To resolve this, we used the Builder design pattern to assist us with creating the objects. To simplify how the province is used the Builder design pattern is used to create AI and user provinces for within the game. We created a builder design pattern for the province class to avoid cluttering the GameEngine with province constructors. The builder design province performs the same functionality as before with the same attributes (Gold, Food, Civilians, Soldiers and province name). The ulterior motive was to not predetermined these states, rather have them set as a random which aligns with our of the logic of the game. To do so, we set a certain range on the attributes for every province, making it random at every new game.

- **Packaging:** We began packaging our files for a cleaner architecture by features and functionality they have. To avoid the clutter and organization between the packages, we created the design pattern packages, separated from features of the game called: **snapshots** and **province\_construction** ,

- **Added serialization to**  **game\_save**** :** This is needed to save the current game&#39;s state and this automatically saves the game after every round so the user can log back into the game when needed.

- **Events:** More events were added to the game as well as different types of effects on one&#39;s province attributes. These were predetermined since it would be prone to have more and more bugs if they were to be set at random. So, we decided to keep them constant for a certain event, however added tons of more events such that they are different and varying at every round.

- **Battle Class modification:** Before the modification, the battle class took in a hashmap of all the provinces (AI and User) that wanted to go into battle and made them go into battle. The new Battle class simply takes one AI province of the user&#39;s choice and makes the User province and the chosen AI province go into battle. This implementation makes the game easier to track. to change the Province instances, Battle interacts with the ProcessValues class now, which then modifies the Province entities.
- **Added ProcessValues class:** This class is responsible for updating all attributes of the Province class. The class decouples the process of updating the values of the attributes of the Province, which happens frequently and in multiple places of the program, from different classes.
- **Memento Design Pattern:** We implemented the Memento Design Pattern to store the current province&#39;s attributes and then further use it to display a summary in the UI. The Memento Design has a very basic implementation as it takes a copy of the current Province state and then turns into a MementoProvince which is stored as a List in the Caretaker Province. The Originator Province handles both turning and converting the Provinces into the MementoProvince and restoring the previous state Object.

### Adhering to Clean Architecture:

Within our project, each class that we have constructed belongs to a layer that fulfills a certain policy. Our entity classes, such as **game\_save package, Decisions, Events, and ProvinceConstruction, snapshot package** are higher-level policies and they have no knowledge of the outer layer classes. Within the entity classes, there is no mention of classes that are a part of the outer layer, no print calls or any sort of updates to the variables. Moving, Battle on, Use Case classes that we have are the **Battle, ProcessValues, AIDecisionMaker** are the classes that manipulate the entities and specify how the game is supposed to be run. The battle class runs the battle, updates the values by using the other UseCases. Moreover, the GameEngine, the core of the program, acts like a controller and presenter that provides the ui to display what is needed. GameEngine is the core of the game, where it is responsible to get all the decisions, and keyboard commands from the user and then calling the various use cases to do some computations to update the attributes, and lastly returns the output that needs to be displayed to the ui. Finally, **UserInterface** is the outermost layer of our program and it interacts with the use case classes only. All other outputs of the Entity classes must go through the use case classes (or the controller GameEngine) to have output through the UserInterface.

**Scenario Walkthrough:**

- The game Rajan&#39;s Conquest is run through the main module. An instance of the GameEngine class gets created in the main module.
- GameEngine interacts with UserInterface to get input value for save decision and with GameLoad/GameState to save the state through serialization process.
- GameEngine interacts with the ProvinceAssembler class, which has the Builder Design pattern.
  - The provinceAssembler will then create 4 AIProvinces and 1 UserProvince, which implement ProvinceLayout interface through ProvinceBuilder which implements ProvinceBuilderLayout interface.
  - The UserProvince is created by GameEngine interacting with the UserInterface which takes in values for the name of the province and the name of the player. These values are assigned to the UserProvince and passed into ProvinceAssembler
- ·When the game is running, each turn the GameEngine:
  - Calls on the Events class (Entity class) to prompt the events. Events has no mentions of GameEngine (Use Case) or any other outer level classes.
  - Calls on Decision (Entity class) to prompt the decisions. Decisions has no mentions of GameEngine (Use Case) or any other outer level classes.
  - Calls on the OriginatorProvince class, passing in the Province as awhich has the Memento design pattern. This process will keep track of the current state of the Province.
  - Calls on Battle (Use Case class), to make two Provinces go to battle with each other.
    - Battle class will interact with ProcessValue(UseCase), which makes calculations on battle outcomes.
  - OriginatorProvince and MementoProvince are used GameEngine to print the results of the decision/event/battle round.
  - ·ProccessValue is called again to reduce food after each battle.
  - During all of these steps (except ProcessValues) GameEngine calls on UserInterface class to get input values for decisions/event/battle choice. After all the steps GameEngine calls on ProcessValues to update the attributes of the Provinces.
  - GameEngine calls on SaveLoad class to save the values of the turn, there is an interaction with UserInterface once again to get the file that will be saved to externally.
- This turn process is continued until either all of the AIProvinces die in the game, or the UserProvince that the player controls dies and is no longer active.

### Consistency with the SOLID Design Principles:

- **SRP:** All the classes that we have in our program simply take care of one task. The task that they take care of is what they are named after, for example, the battle class is simply named after taking care of the task of performing a battle between two provinces.

- **Potential Bad Design Decision:** Game Engine does some behaviors that a typical controller is not permitted to do, according to the Clean Architecture. For example, GameEngine behaves partly as a Controller, but it also is the core of the program so it initializes everything within the classes, which makes it more like a Use Case. So there is definitely an overlap between the layer interface adapters and the application business rules.

- **OCP:** All the classes we have implemented are meant for a running game, though we have left enough room to be able to add new features to our game. An example of this would be our Events class where we could keep adding new events which a player can choose from and that does not change the way other methods in that class interact with such a change. More concretely, we can see that the construction of provinces can have several other variables, through the interfaces and instance variables, which in turn implies that it is open for extendability, however closed for modification.

- **Potentially Bad for Design:** The OCP is violated by a very small margin when saving the game&#39;s current state since we know that there are only 5 attributes with the province, so we index into the array from multiples of 5. However, let&#39;s say we add another attribute in the Provinces, it is relatively easy to extend that, however when saving the length of the list to save the current game state then we would go so the indexing numbers would change therefore, a few code chunks need modification, but not very big where the entire program crashes.

- **LSP**** :** Our code abides by the LSP by using interfaces that follow the design principles as demonstrated in other portions of the code. We chose to implement interfaces over inheritance since interfaces reduce tight coupling between the parent and child classes. One of the main implementations of this can be seen in the provinces, where we construct both an Ai province and a User province. Both sub-provinces are able to do whatever the main province interface can do with added functionality. Thus adhering to the LSP.

- **Potential Bad Design:** Perhaps when extending the game to different users, we would need to use this solid principle, which should have more features than the Parent class so that we are not violating the principle.

- **ISP:** The interfaces that we have within our program are simple and straightforward and are simply designed to help with what they are needed for. An example of this is the ProvinceLayout interface that simply has the getter and setter methods for a province.

- **Potential Bad Design:** Possibly adding the input boundary and output boundary that is implemented by the GameEngine instead of using the UI class to obtain information and sending information to display. This is helpful since, this will segrate the UI class and keep that class mainly for display and within the Input and Output Boundary have the methods to take the information and get the information from the Use Case.

- **DIP:** Classes that are implementing interfaces cannot be seen by the client code, ensuring that client code consumes the interface. Through the hierarchical deconstruction of high-level code to level code that defers dependencies from the former to the latter, we are ensuring that aspects of the code that are very &quot;volatile&quot; are not heavily relied on.

### Packaging Strategies:

When it came to deciding the packaging strategies, we initially thought about using packaging by layer but then came to the conclusion that it might be the most optimal way to package our files. Then our group decided that packaging by feature, therefore the files that interact with each other the most will be in the same package in order to minimize the number of imports. Moreover, we created different packages for the construction of the Province and the user state&#39;s savings.

### Design patterns your group has implemented:

In this Phase 2, our group implemented and improved the 2 design patterns. The first design pattern that was implemented is the builder design pattern for the class Provinces. We added such a design pattern to distinguish between building an AIProvince and a UserProvince. Additionally, one of the reasons was to avoid cluttering the GameEngine with a bunch of province constructors. The builder design pattern allows for a cleaner construction of the provinces. Furthermore, the builder design pattern allows for further enhancements down the line if we plan to make a change with province attributes, functionality, and other activities.

We also added a memento design pattern to the provinces to keep track of the previous states of Province Objects that occur during the game. We need to keep track of this to have it displayed after each round to let the user know about the progress they have made and the effect it has on their attributes. The use of this is to help the user not scroll up and down in order to keep track of the changes made to the provinces. This also allowed the UI and the output to be more presentable to the User.

Another Design Pattern that we can incorporate with more time, would be the Strategy Design Pattern, where we wanted to have a different type of province: we would have this family of provinces to choose from such as more army based, religion based, more agriculture, would imply a higher effect on their certain attributes.

Moreover, we can turn the Battle into more real and live happening like we do with our decisions and their attributes. While doing this, we can have various types of Battles where again, we can simply use the Strategy design pattern between which battle to choose. This would mean the user would be more interactive when doing a battle such as choosing weapons, army count, and more.

**UML Diagram:**

![](RackMultipart20211209-4-idykzx_html_773b93094546f8cf.png)

**Worked well so far with the Design:**

Within the design so far, we think that our design follows the clean architecture and design principles that were discussed in class. As the program sticks to the principles of clean architecture, we also manage to keep good layers and separation between the entities, use cases, and Ui&#39;s. The design itself should be extendable with the help of the implementation that we created using the builder design pattern since it opens up various paths to add many variables that can lead to making the game complicated as well as extendable for Phase 2.

In Phase 2, we continued to adhere to the principles of clean architecture and SOLID design principles, and followed the naming convention, and documentation according to the things that were taught in class. We also handled most of the bugs while testing the game around several things that can happen.

### Use of Github Features:

Within our project, the use of the pull requests feature was quite prevalent. We all had created our own branches at the start of the project and any changes we made individually were then committed and pushed. We all later created pull requests and then reviewed the pull requests by observing the changes and then merging them to the main branch if there were no conflicts and everyone had agreed to the merge. However, the action and issues features were not frequently used within the project due to primarily using Discord as the primary tool for communicating about any issues or implementations to be made. Moving forward into Phase2, we hope to use the Issues and Actions features more and to migrate fully to GitHub. This would ultimately make development easier and efficient since we would be able to directly comment on any issues within the codebase. It also includes the ability to mention specific people which can make it easier to assign issues or a specific responsibility.

In Phase2, we continued to use the features of github such as the pull requests with more use of reviews to make sure that the people who are working together are looking at the code and their changes. Moreover, we used the Issues feature on github to discuss any problems, todo&#39;s or what needs to be done on github instead of Discord, which was quite helpful.

### Code Style and Documentation:

We made use of the naming conventions for the different identities. Ensured that our methods were short and followed the single responsibility principle. Guaranteed an appropriate use of the public and static modifiers where needed. Ensured that there weren&#39;t excessive instance variables per class.

We believe that our documentation for each function and the variables makes the code easy to read and understand. We included a javadoc at the top of each class which indicates the main functionality of the file to give the reader a general understanding of the file. Additionally, we also included javadocs for each function, and for the methods that required heavy logic, intermediate comments were added to make the code readable. While still making sure that we are not over-commenting. We also ensured that before merging we reviewed what was being added within the pull request and tried to recommend any additions they should make before it&#39;s merged to the main branch.

### Refactoring:

One of the biggest refactoring in our project involved the province class. Prior to phase 1, the construction of the Ai Province and User Province created a lot of redundant and cluttering code to the GameEngine. To fix this issue, we choose to create the province in another location and to ultimately reduce the cluttering in the GameEngine. With the help of the builder design pattern we could implement the new province class which freed up a huge chunk of space from the Game Engine.

**Refactored the GameManager Class to GameEngine and organized how it functions:** We thought that the name &quot;engine&quot; suited the class much not cover much better as it is the core class of how the game runs. Before the modification of this class had a lot of unnecessary methods that did ground. Now GameEngine interacts with all the entities and use cases of our program along with our output UserInterface class. GameEngine had a lot of coupling with the entity classes, which was bad. So, we decided to refactor the entire class from top to bottom, and added additional use cases to decouple.

Some of the main warnings we had upon opening IntelliJ were usually with the javadoc, whether that is the dangling javadoc or declaration with the javadoc. Additionally, there were many warnings with the assert statements within the test files which could not be resolved since they alter the logic of the statements.

To fix this issue, we implemented a List which contained sequences of boolean values which corresponded to values of our testing statements. We then iterated through the List and with each boolean used the assert statement.

We also tackled the occasional warning regarding the for loops being replaced with the &quot;for each&quot; loops. Additionally, the &quot;raw use of parameterized class&quot; was quite prevalent with lists providing the specific type of the list in the form of a generic fixed warning. Another warning was regarding the instance variables being final variables, since some of the instances were not being changed or altered in any way the final keyword was used to remove the warning. Also, some of the test methods within the test package had empty methods specifically for the teardown function, so we chose to remove the teardown function from all of the tests since it was not being used. Removing any methods or variables not being used, extracting duplicate methods and then using the method to avoid duplicity and using the appropriate naming conventions for different identifiers.

**Testing:**

- Classes that we tested: We have tested most Entity classes within our program, since they are independent of any other classes. We have also tested some of the Use Case classes such as Battle. We tested the functionality of their classes and whether the methods in this class return the correct value and the attributes maintain their correct values after any operation.
- Classes that we have not tested: Classes we did not test were some of the Use Case classes such as GameEngine as it is dependent on many Entity classes, such as Events, Decisions, and Battle. Testing this class would be very difficult. It was also difficult to test the UserInterface as it was dealing with input and output. So the way that we verified that all the methods worked correctly was manually testing each method. When we tested these functions, we rigged the program to give a specific user interface function, and tested every case to make sure it worked correctly.
- For the Overall Test coverage, the percentage that we got was 82%, and this was due the tests not being done in UI, Main, and the GameEngine.

### Code Organization:

- We have packaged our classes by feature and named carefully each package after what the classes within are meant to do. An example of this the package of &quot;provinceconstruction&quot; and it contains all the classes that are related to constructing the AIProvince and UserProvince. Therefore it is very easy to navigate through the packages to find the relevant classes.
- Each class within our program includes a short and clear description of what the class is meant to do and the attributes that each class has. This will give the reader a clear idea of what each class does, so they will not spend time figuring out what the code written is meant for.
- There are useful comments left throughout each method of each class to make the code easier to follow and understand. Our team ensured that the comments were left in places where the code would be harder to understand.

### Functionality:

- The game follows through with the specification that we had written in phase 1 and 2. We have implemented all of the features that we have planned to.
- We believe that our game is sufficiently ambitious as we have created a game where a user can firstly control a province and play against AI controlled provinces. With every province there are statistics such as Gold, soldiers, and civilians to keep track of which can be affected by different decisions/events. There are also Use cases such as battles that have detailed algorithms of how they decide a winner, which is not purely based on chance. alongside being able to play the game, a user is able to load a game when the game is first started and able to save after each round that is played.

- We have implemented serialization in the class GameState which allows the user to load and save game states to files. The user can load the game at the beginning of the game and can save after each round.

### Summary of Contributions to the Project

**Ansh:** Implemented the Memento Design Pattern with Sayna, Province Class (initially) and Discussed the implementation of the Design Pattern with Armaan. Other Areas that I helped wherever needed such as in the GameEngine. In the future, as the game gets complicated I plan on adding more attributes to the province class and then further refining the design patterns that I worked on with Armaan and Sayna.

ADDED: Fixing bugs (specifically about the summary), documenting over all the classes and making sure they do make sense. Working closely with Howard, Armaan, Sayna for Battle and GameEngine. Assisted people with wherever necessary as well as added some methods in the UserInterface for the Memento Design Pattern

**Sig. PR** : [https://github.com/CSC207-UofT/course-project-11-59pm/pull/77](https://github.com/CSC207-UofT/course-project-11-59pm/pull/77)

This is a significant PR since the Memento Design Pattern was fixed as in it was working properly during the running of the game as well as the bug that was there in Phase 1 was fixed.

**Armaan:** Implemented the ProvinceConstruction package which uses the builder design pattern. Worked on other tasks with Ansh. I plan to add more attributes to the provinces in the near future and work on possibly changing how the ProvinceConstruction might perform as we enhance the game for Phase2. Also, plan on aiding Ansh with any tasks he needs.

ADDED: Worked on the Documentations, testing classes, and assisting wherever the help was required. The code cleaning up in half of the classes was conducted by me and I continued to make sure all the tests + the Game were still running and not buggy.

**Sig. PR:** [https://github.com/CSC207-UofT/course-project-11-59pm/pull/53](https://github.com/CSC207-UofT/course-project-11-59pm/pull/53).

This was my most significant PR since this PR Specifically implements the Builder Design Pattern. The Builder design patterns as a big improvement leading upto the phase1, which avoids cluttering the GameEngine with province constructors.

**Kowan:** Worked on and continues to update UserInterface so that all other classes that require user input get what they need. Other group members can assume they get the input they want, and that reduces what they need to worry about. Also developed is the AIDecisionMaker, which for now is just a simple AI that controls the computer AI. Will continue to keep the UserInterface up to date and add more stylistic changes so that output looks better. Will continue to develop AIDecisionMaker so that ai is more sophisticated and can make better decisions governing the province based on each province&#39;s attributes making the game more difficult for the human player.

ADDED: Improvements to UserInterface to continuously keep up with the demands for input of other classes, and make sure only valid input is accepted. Improved AIDecisionMaker so that the AI now acts even more sophisticated, taking in the state of its own province, and making an educated decision based on what it thinks will keep itself in the game.

**Sig. PR:** [https://github.com/CSC207-UofT/course-project-11-59pm/pull/96/commits](https://github.com/CSC207-UofT/course-project-11-59pm/pull/96/commits)

While this PR did not add any logic or decision making in the code, this PR made a lot of improvements to documentation, code structure, and overall cleanliness and readability of the code. Lots of documentation for every method was added to inform other members of what each function does.

**Girish:** Worked on and updated the gameState package, which works better with other classes compared to phase 0. Helped with the restructuring of the battle class with Ansh and Sayna. Aided Howard and Carson with restarting the base game and starting fresh.

ADDED: Cleaning up classes as well as working on the GameState and collaborating with Kowan to add more methods that I needed to use. Further, cleaned up the Exceptions that were occurring in Phase 1. Worked on gameEngine and UI classes, to make game saving and loading seamless for the user, with automatic saving. Lastly, tested out the game thoroughly by going over several rounds to make sure there are no exceptions/bugs that we were not able to catch.

**Sig. PR:** [https://github.com/CSC207-UofT/course-project-11-59pm/pull/75](https://github.com/CSC207-UofT/course-project-11-59pm/pull/75)

**Sayna:** helped with the development and writing of test cases for class Battle. helped write the memento design pattern with Ansh and Armaan. For phase 2 planning on working on extending the battle class to be able to get more fair outcomes out of a battle between provinces. The battle class could also be extended to have more than one province go into battle at a time (hashmap idea).

ADDED: worked on battle class and made it interact with ProcessValue class, so that provinces can change outside of battle class and through ProcessValue. Added methods to ProcessValues so that it will handle changes made after a battle has taken place between two provinces. Added test cases for multiple classes, testing whether they return the correct values for the methods of the class.

**Sig. PR:** [https://github.com/CSC207-UofT/course-project-11-59pm/pull/113](https://github.com/CSC207-UofT/course-project-11-59pm/pull/113)

**Carson:** Designed and implemented the GameEngine, and fixed bugs with Howard. Also helped with other classes and problems they ran into while implementing their classes while giving them what is required by the GameEngine: for example, Battle and UserInterface. Also collaborated with Howard to improve the playability of the game.

ADDED: Assisted Howard in implementing GameEngine, figuring out the logistics of the game and adding features to make it more accessible for users. Added documentation and fixed warnings around the entire project, and overall helped with everything around the project, mostly collaborating with Howard.

**Sig. PR:** [https://github.com/CSC207-UofT/course-project-11-59pm/pull/107](https://github.com/CSC207-UofT/course-project-11-59pm/pull/107)

Although this pull request is not heavily detailed, I think it was very representative of the type of work that I was doing during the project during this second phase. After designing details of the game, my main priority was fixing bugs and cleaning up warnings; in this PR I did both by eliminating redundant return statements and adding new details to the game. Since the food attribute in Province was essentially redundant for a while, I introduced a feature that made each province&#39;s population &quot;consume&quot; a percentage of it each round in order to add more challenge and variation to the game, as well as just give the attribute some purpose after it was left behind in a previous update.

**Howard:** Designed and implemented the GameEngine and did all the linking between the Entity, Use Case, UserInterface along with Carson. Also implemented the ProcessValues class. Further fixed bugs that came across during the running process of the game.

ADDED: Worked on further implementing the GameEngine, fixed several bugs and documented his class, Added more events and made the event have different effects on one&#39;s province. Moreover, I figured out the edge cases and wrote the code to handle the exceptions.

**Sig. PR:** [https://github.com/CSC207-UofT/course-project-11-59pm/pull/102](https://github.com/CSC207-UofT/course-project-11-59pm/pull/102)

For this pull request, I changed the names of the folders to match the package conventions in order to make our code more neat. I also did a lot of the todos that other people made. In addition, I did some bug fixing and made our game more runnable. If you enter an invalid statement, it will ask you to enter it again.

**\*\*NOTE: We all contributed with the Refactoring, Documentation, Document, and the Slides. \*\***

###


###


### Accessibility Report Questions

1.
  1. **Equitable Use:** Our program acts the same way for all users since there is no discrimination or segregation between users. We never ask for personal data so we cannot differentiate any users, and so everyone is treated fair. The design of our program allows for 100% privacy and security since users never need to enter their personal information.
  2. **Flexibility in Use:** Since the program is not timed or reliant on any specific right or hand access, then the program adheres to the principal. Right or left hand users operate the same since we use simple key inputs on the keyboard, and the entire program acts at the users pace, allowing them to play on their own time. The accuracy and precision requirements of the user are low, since the program uses simple key inputs.
  3. **Simple and Intuitive Use:** The program is simple and intuitive for the user, eliminating complexity. The program only uses simple key inputs, and if the user types incorrectly, the program asks them again for valid input. Information is always blocked together for related data, such as province attributes, and there is always prompting whenever input is needed from the user. When a task is complete, there is always a summary of their data displayed so that there is feedback after what they did.
  4. **Perceptible Information:** Whenever data is presented to the user, everything related is always blocked together and surrounded by a box to signify their relevance to each other. There are also spaces around the boxes to further the redundancy of information, allowing a contrast between related information and other information. Although we do adhere to this principle, there is still room for improvement, such as adding the ability to input with a mouse or adding different modes of presentation, such as pictures.
  5. **Tolerance for Error:** The tolerance for Error in our program is very good. The most used elements, which are user input in the form of y or n, are allowed to be inputted at capital or lowercase. This eliminates confusion for the user. Also, any invalid data given by the user is rejected, and the user is prompted again to enter valid input. This happens until valid input is given which acts as a fail safe feature. Since the input for users is limited, the possibility of encountering warnings or errors for the program are effectively zero.
  6. **Low Physical Effort:** The effort required to use the program ranges from how the player wants to play, but generally stays low and efficient. The most power comes from thinking about how they want to play, and so that range of effort is solely dependent on how the user wants to play. The program has low physical effort to use, and allows the user to maintain a neutral body position since it is all just reading.
  7. **Size and Space for Approach and Use:** There is always a clear line of sight to important elements and they are always highlighted with boxes and spaces. The only component that requires reaching is the input line, which is always in the same position, unless the user moves it themselves, which accommodates variations in sight lines. Since this program only requires a keyboard, there is a lot of space for assistive devices and personal assistance.

1. We would likely market a program towards people between the ages of 18 and 29 who are fans of video games. Due to the cult interest in fantasy from many people in this age demographic as well as the widespread popularity of _The Lord of The Rings_ and _Game of Thrones_ among young adults, we are confident that our game would appeal towards them. The fantastical elements, compounded with the narrative aspects of the game and the subtle allusions to beloved stories like _Monty Python and The Holy Grail_, are very compelling to gamers in this age demographic. Furthermore, games with &quot;conquer the world&quot; elements are very popular in this specific age group, as are video games in general. Additionally, simple, digestible games are very agreeable to the attention spans of younger age demographics. Our game is engaging and entertaining without being very challenging or dense for players, and thus would likely be popular among young, casual gamers.
2. There are certainly specific demographics that are less likely to be interested in Rajan&#39;s Conquest. Older generations in particular who are generally unfamiliar with modern technology and games are particularly predisposed against our product. Additionally, gamers who appreciate visuals over text may be put off by our text-based game, which solely relies on the terminal to tell its story. Rather than being immersive and (MMO)RPG-centric, the game is much more focused on chess-like mechanics that focus on logic over visual stimulation. Moreover, a lack of interest in fantasy and its popular tropes will also make some of the storytelling details in our events a bit opaque; consequently, those who are not big fans of the genre are less likely to be drawn towards the game.
