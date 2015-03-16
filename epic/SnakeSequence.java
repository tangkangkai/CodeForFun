/*
 * You are given a grid of numbers. A snakesequence is made up of adjacent
 * numbers such that for each number, the number on the right or the number
 * below it is +1 or -1 its value. Given a grid, find thelongest snake
 * sequences and their lengths
 */

public int longestSnakeSequence(int[][] grid) {
	if (grid == null || grid.length == 0) {
		return 0;
	}

	int rows = grid.length;
	int columns = grid[0].length;
	// record the length end in logestSequence[i][j]
	int[][] logestSequence = new int[rows][columns];

	// initialzie
	logestSequence[0][0] = 1;
	for (int i = 1; i < rows; i++) {
		logestSequence[i][0] = validSequence(grid, i - 1, 0, i, 0) ? logestSequence[i - 1][0] + 1
				: 1;
	}

	for (int i = 1; i < columns; i++) {
		logestSequence[0][i] = validSequence(grid, 0, i - 1, 0, i) ? logestSequence[0][i - 1] + 1
				: 1;
	}

	for (int i = 1; i < rows; i++) {
		for (int j = 1; j < columns; j++) {
			int logest = 0;
			if (validSequence(grid, i - 1, j, i, j)) {
				logest = Math.max(logest, 1 + logestSequence[i - 1][j]);
			}

			if (validSequence(grid, i, j - 1, i, j)) {
				logest = Math.max(logest, 1 + logestSequence[i][j - 1]);
			}
			logestSequence[i][j] = logest;

		}
	}
	// get the result
	int logest = 0;
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < columns; j++) {
			logest = Math.max(logest, logestSequence[i][j]);
		}
	}

	return logest;
}

public boolean validSequence(int[][] grid, int row1, int column1, int row2,
		int column2) {

	return Math.abs(grid[row1][column1] - grid[row2][column2]) == 1;
}

@Test
public void testSnakeSequence() {
	int[][] board = new int[][] { { 1, 3, 2, 6, 8 }, { -9, 7, 1, -1, 2 },
			{ 1, 5, 0, 1, 9 } };

	System.out.println(longestSnakeSequence(board));
}