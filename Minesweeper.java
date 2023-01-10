public class Minesweeper
{
    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        // boolean array of m*n; true for having mines in the cell
        boolean[][] mines = new boolean[m+2][n+2]; 
        int count = 0;

        // count the mines and break
        for (int i = 1; i < n +1; i++)
        {
            for (int j = 1; j < m + 1; j++)
            {
                mines[i][j] = true;
                count++;
                if(count == k)
                {
                    break;
                }
            }
            if(count == k)
            {
                break;
            }
        }

        // coordinate the mines randomly
        for(int i = 1; i < m + 1; i++)
        {
            for(int j = 1; j < n + 1; j++)
            {
                int row = i + (int)(Math.random() * (m + 1 - i));
                int column = j + (int)(Math.random() * (n + 1 - j));
                boolean t = mines[row][column];
                mines[row][column] = mines[i][j];
                mines[i][j] = t;                
            }
        }
        
        int[][] num_board = new int[m][n];

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if(mines[i][j] != true)
                {
                    int count1 = 0;
                    // nested loop for the 8 neighbors of the cell
                    for (int row = i - 1; row <= i + 1; row++)
                    {
                        for (int column = j - 1; column <= j; column++)
                        {
                            if(mines[row][column] == true)
                            {
                                count1++;
                            }
                        }
                    }
                    num_board[i-1][j-1] = count1;    
                }
                else
                {
                    num_board[i-1][j-1] = k + 1;
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(num_board[i][j] == k + 1)
                {
                    if (j == n - 1)
                    {
                        System.out.print("*");
                    }
                    else
                    {
                        System.out.print("*  ");
                    }
                }
                else
                {
                    if (j == n - 1) 
                    {
                        System.out.print(num_board[i][j]);
                    } 
                    else 
                    {
                        System.out.print(num_board[i][j] + "  ");
                    }

                }
            }
            System.out.println("");
        }
    }
}