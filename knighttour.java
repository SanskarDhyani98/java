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
    public static boolean solveKTutil(int x,int y,int sol[][],int c,int[]xs,int[]ys)
    {
        if(c==N*N)
        {  
            // printSolution(sol);
            return true;
        }
    
    for(int i=0;i<8;i++)
    {  int next_x=x+xs[i];
        int next_y=y+ys[i];
        if(isSafe(next_x, next_y, sol))
        {  sol[next_x][next_y]=c;
            if(solveKTutil(next_x,next_y,sol,c+1,xs,ys))
            return true;
            else
            sol[next_x][next_y]=-1;
        }
    }
    return false;
    }
    public static void solveKT()
    {{
    int xs[]={1,2,-1,-1,1,2,-2,-2};;
    int ys[]={2,1,2,-2,-2,-1,1,-1};
    int sol[][]=new int[N][N];
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<N;j++)
        sol[i][j]=-1;
    }
    sol[0][0]=0;
      if(!solveKTutil(0,0,sol,1,xs,ys))
      {
         System.out.println("Solution does not exist");
      }
      else{
        System.out.println("Solution exists");
        printSolution(sol);
      }
    }}
    public static void main(String args[])
    {
        // Function Call
        solveKT();
    }
}
