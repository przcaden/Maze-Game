
/*    --------------------- Maze ----------------------------

    Written by: Caden Perez
    Project start date: 11/20/2020

    Desc: Simple node class for the Maze class. Keeps track of the user's position in the maze.

      -------------------------------------------------------     */

package lab9_3;

public class Node {
    public int r;
    public int c;
    
    public Node(int row, int column) {
        r = row;
        c = column;
    }
}