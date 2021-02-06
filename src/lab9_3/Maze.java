
/*    --------------------- Maze ----------------------------

    Written by: Caden Perez
    Project start date: 11/20/2020

    Desc: Utility class for the Maze Game project. Keeps track of the user's position through a node and determines if their
        input is valid. It also prints the maze's contents and will check for any win conditions.

      -------------------------------------------------------     */

package lab9_3;
import java.util.Stack;
import java.util.Scanner;
import java.io.*;

public class Maze {
    // Stack is used to keep track of the user's trail in the maze.
    final Stack<Node> trail = new Stack<>();
    final String[] maze = new String[20];
    // Coordinate values for the end of the maze.
    private int endX;
    private int endY;
    // Color formatting for console output.
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    // Sets the starting point for the maze.
    public Maze(int row, int column) throws IOException {
        // Sets the initial position in the maze.
        Node current = new Node(row-1, column-1);
        trail.push(current);
        // Scan file for values in maze.
        File file = new File("maze.txt");
        Scanner read = new Scanner(file);
        for(int r=0; r<20; r++) {
            maze[r] = read.nextLine();
            for(int c=0; c<20; c++) {
                if (maze[r].substring(c, c+1).equals("E")) {
                    endX = r;
                    endY = c;
                }
            }
        }
    }
    // Prints the maze with the current position.
    public void printMaze() {
        // Cleans out the console for formatting.
        // Prints the maze.
        for(int i=0; i<20; i++) {
            for (int j=0; j<20; j++) {
                if (i == trail.peek().r && j == trail.peek().c)
                    System.out.print(ANSI_RED + "X" + ANSI_RESET);
                else {
                    if (maze[i].substring(j,j+1).equals("E"))
                        System.out.print(ANSI_GREEN + "E" + ANSI_RESET);
                    else
                        System.out.print(maze[i].substring(j, j+1));
                }
            }
            System.out.println();
        }
    }
    // Sets the new trail position based on user input.
    public void setPosition(String dir) {
        int x = trail.peek().r;
        int y = trail.peek().c;
        Node newPos;
        // This if block determines if the user input is valid. 
        if (dir.equalsIgnoreCase("R") && y!=19 && !maze[x].substring(y+1, y+2).equals("1"))
            newPos = new Node(x, y+1);
        else if (dir.equalsIgnoreCase("L") && y!=0 && !maze[x].substring(y-1, y).equals("1"))
            newPos = new Node(x, y-1);
        else if (dir.equalsIgnoreCase("U") && x!=0 && !maze[x-1].substring(y, y+1).equals("1"))
            newPos = new Node(x-1, y);
        else if (dir.equalsIgnoreCase("D") && x!=19 && !maze[x+1].substring(y, y+1).equals("1"))
            newPos = new Node(x+1, y);
        else {
            // Formatting spaces if the position is not valid.
            for(int i=0; i<10; i++) {
                System.out.println();
            }
            System.out.println("You cannot enter that space.");
            return;
        }
        for (int i=0; i<10; i++) {
                System.out.println();
            }
        // Pushes the new position into the stack.
        trail.push(newPos);
    }
    /* Checks if the player's position is at the end.
       Also checks if the user has hit a dead end. If they
       do, the method pops the stack.     */
    public boolean endCheck() {
        int x = trail.peek().r;
        int y = trail.peek().c;
        return (x == endX && y == endY);
    }
}