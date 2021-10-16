### Progress Report

#### Specification Summary
Currently, the scenario walkthrough does not have much user interaction because a large portion of the start of the run 
is set up for the game. Currently the applied scenario walkthrough is as follows:

The user is asked to input their name of choice. The game manager class then creates five province classes, one of which 
will be given to the player. A large chunk of time is devoted to following the Clean Architecture guidelines when we 
developed the classes and code. Understanding the new system and implementing the classes was the difficult part.

#### Skeleton Program
Our skeleton program was developed by following the guideline of the Clean Architecture guidelines, and therefore there 
is not much logic or implementation of the classes so far. The following slides are summaries of the goals of each class 
developed that we would like to reach in the future.

#### About The Project
Our game is an text based adventure game. The user will get a chance to play as a character in ancient India.
The player will join one of five provinces in the land and is presented with 3 main choices in the year before a great 
battle is taken place. Each province has a chance to make tactical decisions and choose to join the great battle at the 
end of the year.

There will be a limited amount of years before the game ends. If the player gets the chance to win all five provinces 
before the game ends, they win. Otherwise, the province with the most amount of land concurred will win the game.

#### Walkthrough Summary and What Works Well
Our classes constantly interact with one another. The GameManager class, which runs the game,  interacts with most of 
the other classes. The individual instances of the Province class are instantiated in the GameManager class, the Battle 
and Events classes are used depending on the user’s choices through the userInterface, and the GameManager uses 
gameState to update values of the Player and Provinces classes. The api class is also pivotal to the game’s 
performance: it creates the userInterface which collects user inputs to be used by all the other classes, and receives 
a name with which the Player class is instantiated. Continually as GameManager loops through turns of the game, it 
relies on Battle, Events, gameEvents, and userInterface which in turn interact with one another and the Player and 
Province classes. The synergy between the classes is our program's primary success thus far. Thanks to our early 
diligence with the CRC cards, we were able to comfortably figure out how to ensure that the different classes are 
interacting perfectly with one another.

#### Our Team's Current and Future Tasks
Kowan implemented the userInterface class, and is going to continue developing front-end elements and the user 
interface.

Sayna implemented the Battle Class and typed up the CRC cards.

Howard implemented the Events class and the unit tests, and will be working on the GameManager class.

Carson assisted where needed on everything and worked significantly on the write-ups. He will be working on the Events 
class, as well as generally doing some of everything.

Ansh implemented the Province class and worked on the other classes as well. He will continue to assist generally and 
add features to Province.

Armaan implemented the Player class, and will be adding AI decisions and strengthening relationships between other 
classes.

Girish implemented the API and will be continually updating the APi to bridge the gap from user interface and use cases.