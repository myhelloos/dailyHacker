/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    * Integers in each row are sorted from left to right.

    * Integers in each column are sorted from up to bottom.

    * No duplicate integers in each row or column.

Example
Consider the following matrix:

[

    [1, 3, 5, 7],

    [2, 4, 7, 8],

    [3, 5, 9, 10]

]

Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space
*/

public class Search2D {
     /**
      * @param matrix: A list of lists of integers
      * @param: A number you want to search in the matrix
      * @return: An integer indicate the occurrence of target in the given matrix
      */
     public int searchMatrix(int[][] matrix, int target) {
         // write your code here
         if (matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
         int m = matrix.length;
         int n = matrix[0].length;
         int count = 0;
         int row = m-1;
         int col = 0;
         while (row>=0 && row<m && col>=0 && col<n) {
             int cur = matrix[row][col];
             if (cur == target) {
                 count++;
                 col++;
                 row--;
             }
             else if (cur > target) {
                 row--;
             }
             else col++;
         }
         return count;
     }

     public static void main(String[] args) {
       Search2D solution = new Search2D();
       int[][] matrix =
       {
          {1, 3, 5, 7},
          {2, 4, 7, 8},
          {3, 5, 9, 10},

        };
        System.out.println(solution.searchMatrix(matrix, 3));
     }
 }
