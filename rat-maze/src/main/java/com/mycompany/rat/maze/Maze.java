package com.mycompany.rat.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Maze extends JFrame implements ActionListener {

    private int[][] maze;
    private String[][] pathc;
    private int pathIndex;
     private int threadX = 1; // Starting position of the thread
    private int threadY = 1;
    private Timer timer;

    public List<Integer> path = new ArrayList<>();
    public List<Integer> path1 = new ArrayList<>();
    public ArrayList<Boolean> visited = new ArrayList<>();

    public Maze(int n) {
        setTitle("Maze");
        setSize(480, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        maze = Mazee.numOfMaze(n);
        pathc = new String[maze.length][maze[0].length];

        timer = new Timer(500, this); // Timer for animation
        timer.start();
        
  ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {
            DepthFrist th1 = new DepthFrist(maze, 1, 1, path);
                    Thread t1 = new Thread(th1);
                    t1.start();
        });

        executor.shutdown();


    }
private int thread2X=1; // X-coordinate for the second paint
private int thread2Y=2; // Y-coordinate for the second paint
    @Override
    public void actionPerformed(ActionEvent e) {
        int[] dx = {1, 0, -1, 0}; // Possible movements in x-direction
        int[] dy = {0, 1, 0, -1}; // Possible movements in y-direction
        int[] dx1 = {0, 1, -1, 0}; // Possible movements in x-direction
        int[] dy1 = {1, 0, 0, -1}; // Possible movements in y-direction
        

    // Check the available neighboring cells
    for (int i = 0; i < 4; i++) {
        int nextX = threadX + dx[i];
        int nextY = threadY + dy[i];

        // Check if the neighboring cell is within the maze boundaries and is part of the available path
        if (nextX >= 0 && nextX < maze[0].length && nextY >= 0 && nextY < maze.length
                && maze[nextY][nextX] == 0 || maze[nextY][nextX] == 9) {
            threadX = nextX;
            threadY = nextY;
            break;
        }
    }
     // Check if the first paint has reached the end point
    if (threadX == maze.length - 2 && threadY == maze.length - 2) {
        timer.stop();
    }
       // Move the second paint along its available path
    for (int i = 0; i < 4; i++) {
        int nextX = thread2X + dx1[i];
        int nextY = thread2Y + dy1[i];

        // Check if the neighboring cell is within the maze boundaries and is part of the available path
        if (nextX >= 0 && nextX < maze[0].length && nextY >= 0 && nextY < maze.length
                && maze[nextY][nextX] == 0 || maze[nextY][nextX] == 9) {
            thread2X = nextX;
            thread2Y = nextY;
            break;
        }
    }

        repaint(); // Update the display
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.translate(50, 50);

        // Draw the maze
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.ORANGE;
                        break;
                    case 2:
                        color = Color.RED;
                        break;
                    case 4:
                        color = Color.GREEN;
                        break;
                    default:
                        color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.GRAY);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }
        }

    // Draw the solved path
    for (int p = 0; p < path.size(); p += 2) {
        int pathX = path.get(p);
        int pathY = path.get(p + 1);
        g.setColor(Color.GREEN);
        g.fillRect(pathX * 30, pathY * 30, 30, 30);
         g.setColor(Color.blue);
         g.fillOval(threadX * 30, threadY * 30, 30, 30);
         g.setColor(Color.orange);
         g.fillOval(thread2X * 30, thread2Y * 30, 30, 30);
    }

    // Stop the animation when the thread reaches the end of the path
    if (thread2X == maze.length-2 && thread2Y == maze.length-2) {
        timer.stop();
    }
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              InterFace numInterface = new InterFace();
              numInterface.setVisible(true);

            }
        });
    }
}