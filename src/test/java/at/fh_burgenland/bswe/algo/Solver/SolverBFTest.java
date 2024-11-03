package at.fh_burgenland.bswe.algo.Solver;

import at.fh_burgenland.bswe.algo.sudoku.Sudoku;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverBFTest {

    /**
     * Given: You have a 9x9 Game.
     * When: A playable seed is the input.
     * Then: The algorithm solves it.
     */
    @Test
    @DisplayName("Solve 9 by 9 Grid")
    public void solveTest9x9(){
        Sudoku game = new Sudoku(9);

        String expected =
                "7 8 4 2 1 9 6 5 3 \n" +
                "6 9 2 5 4 3 8 1 7 \n" +
                "5 3 1 6 7 8 4 9 2 \n" +
                "4 6 3 7 9 2 1 8 5 \n" +
                "8 2 5 4 3 1 9 7 6 \n" +
                "1 7 9 8 6 5 2 3 4 \n" +
                "3 5 8 9 2 4 7 6 1 \n" +
                "9 4 6 1 5 7 3 2 8 \n" +
                "2 1 7 3 8 6 5 4 9 \n";

                game.populateGame("080200000600003017000070090400002000000401900070800230050900000940107008200086000");

        SolverBF solver = new SolverBF();
        solver.solve(game);
        String actual = game.generatePrintableString();

        assertEquals(expected, actual);
    }
}