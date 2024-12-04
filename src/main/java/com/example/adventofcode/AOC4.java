package com.example.adventofcode;

import java.util.Objects;

public class AOC4 {

    public int getXMASCountInPuzzle(char[][] puzzle) {
        int count = 0;
        int rows = puzzle.length;
        int cols = puzzle[0].length;
        char startingChar = 'X';

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (puzzle[i][j] == startingChar) {
                    // Check horizontal right
                    if (j + 3 < cols &&
                            puzzle[i][j + 1] == 'M' &&
                            puzzle[i][j + 2] == 'A' &&
                            puzzle[i][j + 3] == 'S') {
                        count++;
                    }

                    // Check horizontal left
                    if (j - 3 >= 0 &&
                            puzzle[i][j - 1] == 'M' &&
                            puzzle[i][j - 2] == 'A' &&
                            puzzle[i][j - 3] == 'S') {
                        count++;
                    }

                    // Check vertical down
                    if (i + 3 < rows &&
                            puzzle[i + 1][j] == 'M' &&
                            puzzle[i + 2][j] == 'A' &&
                            puzzle[i + 3][j] == 'S') {
                        count++;
                    }

                    // Check vertical up
                    if (i - 3 >= 0 &&
                            puzzle[i - 1][j] == 'M' &&
                            puzzle[i - 2][j] == 'A' &&
                            puzzle[i - 3][j] == 'S') {
                        count++;
                    }

                    // Check diagonal right down
                    if (i + 3 < rows && j + 3 < cols &&
                            puzzle[i + 1][j + 1] == 'M' &&
                            puzzle[i + 2][j + 2] == 'A' &&
                            puzzle[i + 3][j + 3] == 'S') {
                        count++;
                    }

                    // Check diagonal left up
                    if (i - 3 >= 0 && j - 3 >= 0 &&
                            puzzle[i - 1][j - 1] == 'M' &&
                            puzzle[i - 2][j - 2] == 'A' &&
                            puzzle[i - 3][j - 3] == 'S') {
                        count++;
                    }

                    // Check diagonal left down
                    if (i + 3 < rows && j - 3 >= 0 &&
                            puzzle[i + 1][j - 1] == 'M' &&
                            puzzle[i + 2][j - 2] == 'A' &&
                            puzzle[i + 3][j - 3] == 'S') {
                        count++;
                    }

                    // Check diagonal right up
                    if (i - 3 >= 0 && j + 3 < cols &&
                            puzzle[i - 1][j + 1] == 'M' &&
                            puzzle[i - 2][j + 2] == 'A' &&
                            puzzle[i - 3][j + 3] == 'S') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int getMASCountInPuzzleWithXShape(char[][] puzzle) {
        int count = 0;
        int rows = puzzle.length;
        int cols = puzzle[0].length;

        // Iterate over each cell to look for 'A' (the center of X-MAS)
        for (int i = 1; i < rows - 1; i++) { // Avoid top and bottom rows
            for (int j = 1; j < cols - 1; j++) { // Avoid left and right columns
                if (puzzle[i][j] == 'A') {
                    // Check if this 'A' can be the center of an X-MAS pattern
                    if (isXMAS(puzzle, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isXMAS(char[][] puzzle, int centerRow, int centerCol) {
        // Check for forward-slashing(/) diagonal ("MAS" or "SAM")
        boolean forwardDiagonalMAS =
                (puzzle[centerRow - 1][centerCol - 1] == 'M' &&
                        puzzle[centerRow][centerCol] == 'A' &&
                        puzzle[centerRow + 1][centerCol + 1] == 'S') ||
                        (puzzle[centerRow - 1][centerCol - 1] == 'S' &&
                                puzzle[centerRow][centerCol] == 'A' &&
                                puzzle[centerRow + 1][centerCol + 1] == 'M');

        // Check for back-slashing(\) diagonal ("MAS" or "SAM")
        boolean backDiagonalMAS =
                (puzzle[centerRow - 1][centerCol + 1] == 'M' &&
                        puzzle[centerRow][centerCol] == 'A' &&
                        puzzle[centerRow + 1][centerCol - 1] == 'S') ||
                        (puzzle[centerRow - 1][centerCol + 1] == 'S' &&
                                puzzle[centerRow][centerCol] == 'A' &&
                                puzzle[centerRow + 1][centerCol - 1] == 'M');

        return forwardDiagonalMAS && backDiagonalMAS;
    }

}
