# Maze Game

This program is a simple game done entirely in a Java console terminal. The user has the option to choose the right positions in order to make it out of a maze of 1's and 0's. The 1'srepresent spaces the player cannot enter, while the 0's are open spaces for the user to freely move around in. The player's current position is marked with a red "X" printed on
the game board, while the exit of the maze is marked with a green "E".

When the program begins, the user will be asked if they want their starting position to be in the middle or the beginning of the maze. This is done simply for players who want different difficulties. For example, in the image below, this is the user's position after starting in the middle of the game board:

![alt text](https://i.imgur.com/UKphsfJ.png)

## Movement

Now to actually play the game. As seen in the image, the user is given four options of movement on the game board: left, right, up, and down. The user may inputted a non-case-sensitive "L", "R", "U", or "D" to move in their corresponding direction. If a user tries to lead their position cursor off the board grid or into a "wall" of 1's, the program will ask them to try again. Otherwise, their cursor will move to that space on the grid and the board is re-printed to the console.

## Code Structure

The Maze Game program utilizes various structures depending on the algorithm and the specific class' purpose in the program. To maintain the user's current position and to easily manipulate it depending on their input, a Node class is utilized that keeps track of their horizontal and vertical coordinates on the grid. The Maze class holds all functions utilized by the main class and manipulates the values of the grid. When a user inputs a new direction to move, the Maze class will create a new Node with the new coordinates and push it into a stack in order to keep track of the user's trail. The Maze class also performs two more functions: printing the board and checking for win conditions. To check for the win condition, the endCheck method will check if the user's current Node has coordinates that are equal to the exit of the maze.

The main class uses sentinel loop patterns when receiving user input in order to check if they are legitimate. If the user input is not correct based on the prompt's standards, the program will loop back and ask for another input from the user. For example, when the user chooses their initial position on the board and does not enter a 1 or a 2, it will loop back. A snippet of this code is shown below:

![alt text](https://i.imgur.com/wqGLb6v.png)

The main class also uses a single do-while loop while the game is active. If the user has not completed the maze yet, the game will keep looping and asking them for direction inputs. Once the user has successfully completed the maze, the program excitedly congratulates them and then subsequently terminates:

![alt text](https://i.imgur.com/lDWfAcM.png)


### Future Plans / To-Do List
- Colored grid spots... since the grid is all a single color except for the player's position and the exit of the maze, the user may have difficulty looking at the board and differentiating walls from open spots.
- Different maze grids... the program currently only has one maze for the user to play on. I plan to have multiple grids in the project's source folder, for which the program will use a random number generator to choose from them.
