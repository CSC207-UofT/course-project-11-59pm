## Rajan's Conquest
By: Carson, Howard, Girish, Sayna, Armaan, Ansh, Kowan

Our game is an text based adventure game. The user will get a chance to play as a character in ancient India. The player will join one of five provinces in the land and is presented with 3 main choices in the year before a great battle is taken place. Each province has a chance to make tactical decisions and choose to join the great battle at the end of the year.

 If the player gets the chance to win all five provinces before the game ends, they win. Otherwise, the province with the most amount of land conuqered will win the game.

## Phase 2: Extendability Ideas: After Phase 2
- Different Types of Battle
- The UI needs to be more appealing  
- Might think about extending the game with more attributes -- territories 

## Instructions To Run the program: 
- You will first be prompted if you would like to load a previous save (Input: Y/N) <br />
**FOR TA:**
**If you already have a copy of the game, create a new copy of the game because we did some refactoring of package names, and pulling does not actually change gameState properly**
<br />
- In a new game state: [Selecting N for the first tbe Previous Load Game State] <br />
    &nbsp; Then you will be prompted to type your name <br />
    &nbsp; After you type your name, you will then be able to type the Province name <br />
    &nbsp; As you play the game, you will encounter the question about saving your gameState <br />
    &nbsp; If yes, the GameState will saved
    <br />
    
- If you load a game state: [Selecting Y for the first tbe Previous Load Game State] <br />
    &nbsp; If you input "default" it will automatically load a save.ser in the projects src file <br />
    &nbsp; After loading the file, the console should welcome you back to the game <br />
    <br />
    
Once the game state is saved/loaded you will now be able to play the game <br />
Your objective of the game is for your provience to not die ie keep all values above zero <br />
As well as battling other proviences <br />
To win the game you want to capture all proviences <br />
Every round you can either encouter a random story event where the input is Y/N <br />
Or a decision event, where you choose from 3 options listed where the input is 1,2, or 3 <br />. 
During the turns, user can generate summary of the States that happened which <br />
basically displays the attirbutes for their province. <br />.
  
