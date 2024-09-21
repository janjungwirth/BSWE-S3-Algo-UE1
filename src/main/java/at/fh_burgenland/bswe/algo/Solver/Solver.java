package at.fh_burgenland.bswe.algo.Solver;

import at.fh_burgenland.bswe.algo.sudoku.Sudoku;

public interface Solver {
    /**
     * This function will try to solve a Sudoku game board
     * @param game the board it wants to solve
     * @return True: game was solved False: Game was not solved
     */
    void solve(Sudoku game);
}
