
/*    --------------------- Maze ----------------------------

    Written by: Caden Perez
    Project start date: 11/20/2020

    Desc: Main class for the Maze Game project. Prompts all user input to the console and manages class objects.

      -------------------------------------------------------     */


package lab9_3;
import java.io.*;
import java.util.Scanner;

public class Lab9_3 {
    public static void main(String[] args) throws IOException {
        Scanner stringIn = new Scanner(System.in);
        boolean valid;
        boolean endCheck;
        String dir;
        
        System.out.println("Welcome to the maze. The space labelled 'E' is the exit. The space labelled 'X' is your current position.");
        System.out.println("To move your space, you will enter 'L', 'R', 'U' or 'D'.");
        /* Gets user input for starting position and checks if they are valid.
           For example, enter 20 for the row and 20 for the column to start at
           the lower right corner of the maze.
        */
        System.out.println("Would you like to (1) start from the middle of the maze or (2) start from the end? \n Please enter 1 or 2: ");
        String startpoint = stringIn.nextLine();
        while (!(startpoint.equals("1") || startpoint.equals("2"))) {
            System.out.println("Input was invalid. Please enter 1 or 2: ");
            startpoint = stringIn.nextLine();
        }
        
        // Creates a maze with the given starting position.
        Maze maze;
        if (startpoint.equals("1"))
            maze = new Maze(10, 10);
        else
            maze = new Maze(20, 20);
        
        maze.printMaze();
        // Prompts user input to move spaces until they reach the end.
        do {
            do {
                System.out.println("Please enter your desired direction (L, R, U, D):");
                dir = stringIn.nextLine();
                if (!(dir.equalsIgnoreCase("L") || dir.equalsIgnoreCase("R") 
                        || dir.equalsIgnoreCase("U") || dir.equalsIgnoreCase("D"))) {
                    System.out.print("Input was in valid. ");
                    valid = false;
                }
                else valid = true;
            } while (!valid);
            maze.setPosition(dir);
            maze.printMaze();
            
            endCheck = maze.endCheck();
        } while(!endCheck);
        System.out.println("Congratulations! You have exited the maze!");
    }
}