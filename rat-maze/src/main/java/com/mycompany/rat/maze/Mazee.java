package com.mycompany.rat.maze;

import java.util.*;

public class Mazee {
     public static int [][] numOfMaze(int n){
       

  Random rand = new Random();
    
   int [][] maze = new int[n+2][n+2];
   
       for(int i = 0; i < maze.length ; i++) {
            for (int j = 0; j < maze.length ; j++) {
                maze[i][j] = rand.nextInt(2);
                if((i==1 && j==1)||
                        (i==1 && j==3) || (i==1 && j==5) ||
                        (i==1 && j==6) || (i==1 && j==7) ||
                        (i==3 && j==4) || (i==3 && j==5) ||
                        (i==4 && j==1) || (i==4 && j==2)||
                        (i==4 && j==5) || (i==5 && j==2) ||
                        (i==5 && j==4) || (i==5 && j==5) ||
                        (i==6 && j==0) || (i==8 && j==3)||
                        (i==9 && j==3) || (i==10 && j==3) ||
                        (i==2 && j==9) || (i==2 && j==10) ||
                        (i==3 && j==9) || (i==3 && j==10) ||
                        (i==4 && j==9) || (i==4 && j==10) ||
                        (i==8 && j==8) || (i==9 && j==7) ||
                        (i==9 && j==8) || (i==9 && j==9) ||
                        (i==11 && j==0) || (i==11 && j==5) ) {
                    maze[i][j]= 1;
                }
                else{
                    maze[i][j]=0;
                }
                
            }
        }
       for (int i = 0; i < n + 2; i++) {
            maze[i][0] = 1;     // Set left border to 1
            maze[i][n + 1] = 1; // Set right border to 1
        }

        for (int j = 0; j < n + 2; j++) {
            maze[0][j] = 1;     // Set top border to 1
            maze[n + 1][j] = 1; // Set bottom border to 1
        }
       maze [1][1]=0;
       maze [n][n]=9;
       
       return maze;
   }
    
}
