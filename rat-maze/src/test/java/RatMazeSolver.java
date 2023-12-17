import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RatMazeSolver  implements ActionListener{
    private int[][] maze;
    private int[][] visited;
    private int size;
    private boolean solved;

    public RatMazeSolver(int[][] maze) {
        this.maze = maze;
        size = maze.length;
        visited = new int[size][size];
        solved = false;
    }

    public void solve(int row , int col) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {
            findPath(row, col);
        });

        executor.shutdown();
    }

    private void findPath(int row, int col) {
        if (row == size - 1 && col == size - 1) {
            visited[row][col] = 1;
            solved = true;
            printSolution();
            return;
        }
        if (isValidMove(row, col)) {
            visited[row][col] = 1;
           
            if (row + 1 < size && !solved) {
              
                    solve(row + 1, col);
               
            }

            if (col + 1 < size && !solved) {
                
                    solve(row, col + 1);
                
            }

            visited[row][col] = 0;
        }
    }

    private boolean isValidMove(int row, int col) {
        return (row >= 0 && row < size && col >= 0 && col < size && maze[row][col] == 1 && visited[row][col] == 0);
    }

    private void printSolution() {
        System.out.println("Solution found!");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
        };

        RatMazeSolver solver = new RatMazeSolver(maze);
        solver.solve(0,0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        }
}