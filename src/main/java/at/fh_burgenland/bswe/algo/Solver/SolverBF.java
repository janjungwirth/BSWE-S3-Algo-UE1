package at.fh_burgenland.bswe.algo.Solver;


import at.fh_burgenland.bswe.algo.sudoku.Sudoku;

import java.time.LocalDateTime;

public class SolverBF implements Solver {

    public void solve(Sudoku game) {
        solve(game, 0, 0);
    }

    public boolean solve(Sudoku game, int row, int col) {
        if (row == game.getGAME_SIZE()) {
            return true;
        }

        int nextRow, nextCol;
        if (col == game.getGAME_SIZE() - 1) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }

        // if the current position already contains a number, skip it
        if (game.getNumberAt(row, col) != 0) {
            return solve(game, nextRow, nextCol);
        }

        for (int num = 0; num <= game.getGAME_SIZE(); num++) {
            if (game.checkMove(row, col, num)) {
                game.playMove(row, col, num);
                if (solve(game, nextRow, nextCol)) {
                    return true;
                }
                game.resetAt(row, col); // undo move if not valid
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            long l = System.currentTimeMillis();
            Sudoku game = new Sudoku(9);
            SolverBF bf = new SolverBF();
            game.populateGame("080200000600003017000070090400002000000401900070800230050900000940107008200086000");
//            game.printBoard();
            bf.solve(game);
//            game.printBoard();
            System.out.println(System.currentTimeMillis() - l);
            //"006100345801040720003602891560020913342009087007300000080001470010467000000000000" //unsolved yet but solvable
        }
    }
}

