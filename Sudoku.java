public class Sudoku
{
    public static boolean isSafe(int[][] a,int i,int j, int x)
    {
        for(int k=0;k<9;k++)
        {
           if(a[k][j]==x)
           return false;
           if(a[i][k]==x)
           return false;
        }
        int sr=(i/3)*3;
        int sc=(j/3)*3;
        for(int y=sr;y<sr+3;y++)
        {
          for(int z=sc;z<sc+3;z++)
      {  if(a[y][z]==x)
          return false;
  
      }    
  }
  return true;
  
      }
   
    public static boolean sudokuSolver(int sudoku[][],int row,int col)
    {
     //base case
   if(row==9)
  { return true;}
   

    //recursion
    int nextRow=row;int nextCol=col+1;
    if(col+1==9)
    {
        nextRow=row+1;
        nextCol=0;
    }
    if(sudoku[row][col]!=0)
    {
        return sudokuSolver(sudoku,nextRow,nextCol);
    }
    for(int digit=1;digit<=9;digit++){
        if(isSafe(sudoku,row,col,digit))
        {
            sudoku[row][col]=digit;
            if(sudokuSolver(sudoku,nextRow,nextCol))  //soln exists
            {
             return true;
            }
            sudoku[row][col]=0;
        }  
    }
    return false;
    }
    public static void printSudoku(int sudoku[][])
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(sudoku[i][j]+" ");
            }
             System.out.println();
        }
    }
    public static void main(String args[])
    {  int sudoku[][]= { {3, 0, 6, 5, 0, 8, 4, 0, 0},
   {5, 2, 0, 0, 0, 0, 0, 0, 0},
   {0, 8, 7, 0, 0, 0, 0, 3, 1},
{0, 0, 3, 0, 1, 0, 0, 8, 0},
{9, 0, 0, 8, 6, 3, 0, 0, 5},
{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
{1, 3, 0, 0, 0, 0, 2, 5, 0},
{0, 0, 0, 0, 0, 0, 0, 7, 4},
{0, 0, 5, 2, 0, 6, 3, 0, 0} };
if(sudokuSolver(sudoku,0,0))
{
    System.out.println("Solution exists");
    printSudoku(sudoku);
}
else {
     System.out.println("Solution does not exist");

}
    }
}