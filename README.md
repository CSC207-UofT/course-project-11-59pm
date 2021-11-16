## Rajan's Conquest
By: Carson, Howard, Girish, Sayna, Armaan, Ansh, Kowan

Our game is an text based adventure game. The user will get a chance to play as a character in ancient India. The player will join one of five provinces in the land and is presented with 3 main choices in the year before a great battle is taken place. Each province has a chance to make tactical decisions and choose to join the great battle at the end of the year.

There will be a limited amount of years before the game ends. If the player gets the chance to win all five provinces before the game ends, they win. Otherwise, the province with the most amount of land concurred will win the game.

## Phase 2: Extendability Ideas:
- Saving the entire Game (Essentially, the entire GameEngine) instead of just a province.
- Fixing the small bug and just playing with the game to check the logic
- The UI needs to be more appealing  
- Might think about extending the game with more attributes.

## Intructions To Run the program: 
- You will first be prompted if you would like to load a previous save (Input: Y/N) <br />
**FOR TA:**
**If you already have a copy of the game, create a new copy of the game because we did some refactoring of package names, and pulling does not actually change gameState properly**
<br />
- In a new game state: <br />
    &nbsp; Then you will be prompted to type your name <br />
    &nbsp; After you type your name, you will then be able to type the Provience name <br />
    &nbsp; Then you will be prompted to insert a filePath for a save file  <br />
    &nbsp; The file path should not include the actual .ser file, but just the folder you want it to be in <br />
    &nbsp; Sample input for windows filePath: C:\Users\YOURUSERNAME\Desktop\ <br />
    &nbsp; Sample input for macOS filePath: /Users/username/Desktop/ <br />
    &nbsp; Not including a final slash is also valid (C:\Users\YOURUSERNAME\Desktop) <br />
    &nbsp; If you input "default" it will automatically save in the projects src file <br />
    &nbsp; With these examples, a save file called save.ser would be saved to the desktop <br />
    <br />
- If you load a game state: <br />
    &nbsp; insert the file path of the folder containg the save.ser file <br />
    &nbsp; Dont include the actual save.ser part of the file path <br />
    &nbsp; Sample input for windows filePath: C:\Users\YOURUSERNAME\Desktop\ <br />
    &nbsp; Sample input for macOS filePath: /Users/username/Desktop/ <br />
    &nbsp;  Not including a final slash is also valid (C:\Users\YOURUSERNAME\Desktop) <br />
    &nbsp; With these examples, there should exist a save file called save.ser in the desktop <br />
    &nbsp; If you input "default" it will automatically load a save.ser in the projects src file <br />
    &nbsp; After loading the file, the console should welcome you back to the game <br />
    <br />
Once the game state is saved/loaded you will now be able to play the game <br />
Your objective of the game is for your provience to not die ie keep all values above zero <br />
Aswell as battling other proviences, and claiming their territory <br />
To win the game you want to capture all proviences <br />
Every round you can either encouter a random story event where the input is Y/N <br />
Or a decision event, where you choose from 3 options listed where the input is 1,2, or 3 <br />

  
