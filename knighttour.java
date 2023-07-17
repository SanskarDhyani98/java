public class knighttour {
    static int N = 8;
  
    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    static boolean isSafe(int x, int y, int sol[][])
    {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }
  
    /* A utility function to print solution
       matrix sol[N][N] */
    static void printSolution(int sol[][])
    {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        // Function Call
        solveKT();
    }
}
