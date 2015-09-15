public class NumIslands {
  int[] DIRECTIONX = { -1, 0, 1, 0 };
  int[] DIRECTIONY = { 0, -1, 0, 1 };

  // https://leetcode.com/problems/number-of-islands
  /**
   * Given a 2d grid map of '1's (land) and '0's (water), count the number of
   * islands. An island is surrounded by water and is formed by connecting
   * adjacent lands horizontally or vertically. You may assume all four edges of
   * the grid are all surrounded by water.
   */
  public int numIslands(char[][] grid) {
    int lengthX = grid.length;
    if (lengthX == 0)
      return 0;
    int lengthY = grid[0].length;
    int result = 0;

    char[][] visit = new char[lengthX][lengthY];
    for (int x = 0; x < lengthX; x++)
      for (int y = 0; y < lengthY; y++) {
        result += visitIslands(grid, visit, x, y);
      }
    return result;
  }

  private int visitIslands(char[][] grid, char[][] visit, int x, int y) {
    if (y >= grid[0].length || x >= grid.length || x < 0 || y < 0)
      return 0;
    if (grid[x][y] == '0')
      return 0;
    if (visit[x][y] == 'v')
      return 0;
    visit[x][y] = 'v';
    for (int i = 0; i < 4; i++) {
      visitIslands(grid, visit, x + DIRECTIONX[i], y + DIRECTIONY[i]);
    }
    return 1;
  }

  public static void main(String[] args) {
    NumIslands solution = new NumIslands();
    char[][] island = { { '1', '1', '1', '1', '0' },
        { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' } };
    char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '1', '0', '0' },
        { '0', '0', '0', '1', '1' } };
    char[][] empty = {};
    System.out.println(solution.numIslands(island));
    System.out.println(solution.numIslands(grid));
    System.out.println(solution.numIslands(empty));
  }
}
