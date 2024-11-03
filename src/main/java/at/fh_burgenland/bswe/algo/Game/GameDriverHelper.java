package at.fh_burgenland.bswe.algo.Game;

import at.fh_burgenland.bswe.algo.Solver.SolverBF;
import at.fh_burgenland.bswe.algo.sudoku.Sudoku;

import java.util.Scanner;

public class GameDriverHelper {
    private Sudoku game = new Sudoku(9);

    public void playGame() {
        System.out.println(
                "Please enter a Game Seed!\n" +
                        "The Format of the Seed is 0 for no number, and all in one line.\n" +
                        "Example: 080200000600003017000070090400002000000401900070800230050900000940107008200086000");
        boolean running = true;

        Scanner scanner = new Scanner(System.in);

        do {
//            try {
                System.out.print("Input: ");
                String seed = scanner.nextLine();

                game.populateGame(seed);
                new SolverBF().solve(game);
                game.printBoard();

                System.out.println("Want to play again? (Y/N) ");
                System.out.print("Input: ");
                running = scanner.nextLine().toLowerCase().contains("y");

//            } catch (Exception e) {
//                System.out.println("Something went wrong. Please ensure the correct input format and valid data.");
//            }
        } while (running);

    }
}
