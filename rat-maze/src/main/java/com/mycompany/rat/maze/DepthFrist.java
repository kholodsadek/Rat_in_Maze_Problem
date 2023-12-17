package com.mycompany.rat.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepthFrist implements Runnable{

    private int[][] maze;
    private int x;
    private int y;
    private List<Integer> path;
    private List<Integer> path1;
   
    public DepthFrist(int[][] maze, int x, int y, List<Integer> path) {
        this.maze = maze;
        this.x = x;
        this.y = y;
        this.path = path;  
    }
    @Override
    public void run() {
         searchPath(maze, x, y, path);
         
       if((searchPath(maze, x , y + 1, path)) && (searchPath(maze, x + 1, y, path))){
                path.add(x);
                path.add(y);
                DepthFrist th1 = new DepthFrist(maze, x, y+1, path);
                Thread t1 = new Thread(th1);
                t1.start();
             try {
                 t1.join();
             } catch (InterruptedException ex) {
                 Logger.getLogger(DepthFrist.class.getName()).log(Level.SEVERE, null, ex);
             }
                DepthFrist th2 = new DepthFrist(maze, x+1, y, path);
                Thread t2 = new Thread(th2);
                t2.start();
             try {
                 t2.join();
             } catch (InterruptedException ex) {
                 Logger.getLogger(DepthFrist.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
       else{
           searchPath(maze, x, y, path);
       }
         }
    
     public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path ) {
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }
        if (maze[y][x] == 0) {
            if((searchPath(maze, x , y + 1, path)) && (searchPath(maze, x + 1, y, path))){
                path.add(x);
                path.add(y);
                return true;
            }
            
            if (searchPath(maze, x , y+1 , path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            if (searchPath(maze, x+1 , y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
             maze[y][x] =2;
        }
    return false;
}
}