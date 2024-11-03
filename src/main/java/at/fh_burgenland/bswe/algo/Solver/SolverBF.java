package at.fh_burgenland.bswe.algo.Solver;


import at.fh_burgenland.bswe.algo.sudoku.Sudoku;

import java.time.LocalDateTime;

public class SolverBF implements Solver {

    public void solve(Sudoku game) {
        solve(game, 0, 0);
    }

    private boolean solve(Sudoku game, int row, int col) {
        if (row == game.getGAME_SIZE()) { //O(1)
            return true; //O(1)
        }

        int nextRow, nextCol; //O(1)
        if (col == game.getGAME_SIZE() - 1) { //O(1)
            nextRow = row + 1; //O(1)
            nextCol = 0; //O(1)
        } else { //O(1)
            nextRow = row; //O(1)
            nextCol = col + 1; //O(1)
        }

        if (game.getNumberAt(row, col) != 0) { //O(1)
            return solve(game, nextRow, nextCol); //O(n2) Recursion
        }

        for (Integer num = Integer.valueOf(0); num <= game.getGAME_SIZE(); num++) { //O(n) weil es direkt proportional zu der größe des Feldes steht
            if (game.checkMove(row, col, num)) { //O(1)
                game.playMove(row, col, num); //O(1)
                if (solve(game, nextRow, nextCol)) { //O(n2) Recursion
                    return true; //O(1)
                } //O(1)
                game.resetAt(row, col); // undo move if not valid //O(1)
            }
        }
        return false;
    }
}

