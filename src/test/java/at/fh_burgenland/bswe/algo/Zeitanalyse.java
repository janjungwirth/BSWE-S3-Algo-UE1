package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.Solver.SolverBF;
import at.fh_burgenland.bswe.algo.sudoku.Sudoku;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Zeitanalyse {

    public static void main(String[] args) {
        Sudoku game = new Sudoku(9);
        SolverBF solver = new SolverBF();

        log.atInfo().log("start,end,time");
        for(int i=0;i<50;i++) {
            game.populateGame("080200000600003017000070090400002000000401900070800230050900000940107008200086000");

            long startTime = System.currentTimeMillis();
            solver.solve(game);
            long endTime = System.currentTimeMillis();
            log.atInfo().log(startTime+","+endTime+","+(endTime-startTime));
        }
    }
}
