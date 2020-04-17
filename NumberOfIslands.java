/*
Day 17

Given a 2d grid map of '1's (land) and '0's (water),
count the number of islands. An island is surrounded by water and
is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3
*/


class NumberOfIslands{
    
	public static int numIslands(char[][] grid) {
        int island_count = 0;
		for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    markIslandTiles(grid, i, j);
                    island_count++;
                }
            }
        }
        return island_count;
    }
    
    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, -1, 1};
	public static void markIslandTiles(char[][] grid, int i, int j) {
        grid[i][j] = 'x';
        for (int k = 0; k < x.length; k++) {
            int dx = j + x[k];
            int dy = i + y[k];
            // check if coord is in the map and
            // check if coord value is one:
            if(
                dx >= 0 &&
                dx < grid[0].length &&
                
                dy >= 0 &&
                dy < grid.length &&

                grid[dy][dx] == '1' // check last to avoid ArrayIndexOutOfBoundsException
            ){
                markIslandTiles(grid, dy, dx);
            }
        } 
    }


    public static void main(String[] args) {
        char[][] arr = {{'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}};

        System.out.println(numIslands(arr));

        arr = new char[][] {{'1','1','0','0','0'},
                            {'1','1','0','0','0'},
                            {'0','0','1','0','0'},
                            {'0','0','0','1','1'}};
        System.out.println(numIslands(arr));
    }
}

