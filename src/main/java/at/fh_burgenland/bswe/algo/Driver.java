package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.sudoku.Sudoku;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Driver {

    public static void main(String[] args) {
        Sudoku game = new Sudoku(9);
        game.playMove(0,0,1);
        game.printBoard();
    }

}
