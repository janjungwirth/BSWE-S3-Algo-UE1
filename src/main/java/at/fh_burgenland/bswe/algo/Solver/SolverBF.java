package at.fh_burgenland.bswe.algo.Solver;


import at.fh_burgenland.bswe.algo.sudoku.Sudoku;

import java.util.LinkedList;
import java.util.List;

public class SolverBF implements Solver {


    private static class Position {
        final Integer row;
        final Integer col;

        public Position(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * @param game the board it wants to solve
     */
    @Override
    public void solve(Sudoku game) {
        List<Position> positionList = new LinkedList<>();
        Position pointer =new Position(0,0);

        for(int row=0; row<game.getGAME_SIZE();row++)
            for(int col=0; col<game.getGAME_SIZE();col++)
                if(game.getNumberAt(row,col)==0){
                    positionList.add(new Position(row,col));
                    pointer=positionList.getLast();
                    for(int number=1;number<=game.getGAME_SIZE();number++){
                        if(game.checkMove(row,col,number)){
                            game.playMove(row,col,number);
                        }
                        game.resetAt(positionList.getLast().row, positionList.getLast().col);
                        positionList.removeLast();
                    }
                }

        //schau nach zahl
        //schau nach nächste zahl
        //geh zurück schau nächste zahl
    }

    public static void main(String[] args) {
        //"006100345801040720003602891560020913342009087007300000080001470010467000000000000"
        Sudoku game = new Sudoku(9);
        SolverBF bf = new SolverBF();
        game.populateGame("006100345801040720003602891560020913342009087007300000080001470010467000000000000");
        game.printBoard();
        bf.solve(game);
        game.printBoard();
    }
}

