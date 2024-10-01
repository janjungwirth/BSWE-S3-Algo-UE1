package at.fh_burgenland.bswe.algo.sudoku;

import at.fh_burgenland.bswe.algo.exceptions.InvalidGameStateException;
import at.fh_burgenland.bswe.algo.exceptions.InvalidMoveException;
import at.fh_burgenland.bswe.algo.exceptions.InvalidSizeException;
import lombok.Getter;
import lombok.SneakyThrows;


public class Sudoku {
    private Integer[][] playgroud;
    @Getter
    private int GAME_SIZE;


    /**
     * Constructor of Sudoku game field
      * @param size the size of the sudoku e.g. 6x6, 9x9, etc
     * @throws InvalidSizeException
     */
    @SneakyThrows
    public Sudoku(int size) {
        GAME_SIZE=size;
        if(size <=5||size%3!=0)
            throw new InvalidSizeException("The Size must be at least 6 fields and dividable by 3");

        playgroud = new Integer[size][size];

        //Filling board
        for(int row=0;row<GAME_SIZE;row++)
            for(int col=0;col<GAME_SIZE;col++)
                playgroud[row][col]=0;



    }

    /**
     * Plays a number on the field
     * @param row to place the number
     * @param col to place the number
     * @param number wich number to place
     * @throws InvalidMoveException is thown if the player wants to place a number out of the game
     * @throws InvalidGameStateException is thown if the game was not yet implemented
     */
    @SneakyThrows
    public void playMove(int row, int col, int number) {
        if(row > GAME_SIZE || col > GAME_SIZE || row <0 || col <0)
            throw new InvalidMoveException("This play is out of field.");

        if(number <=0 || number>GAME_SIZE)
            throw new InvalidMoveException("Number "+number+" is not allowed.");

        if(playgroud==null)
            throw new InvalidGameStateException("The game board was not yet initialized.");

        if (checkMove(row, col, number))
            playgroud[row][col] = number;
        else
            throw new InvalidMoveException("Move is not allowed due to Move already present in Row/Col");
    }


    /**
     * Checks for an move if its legal or not
     * @param row to place the number
     * @param col to place the number
     * @param num wich number to place
     * @return
     *      *true = valid move
     *      *false = not a valid move
     */
    public boolean checkMove(int row, int col, int num) {
            // check the number being placed does not exist in the current row or column or 3x3 grid.
            int startRow = row / 3 * 3;
            int startCol = col / 3 * 3;

            for (int i = 0; i < 9; i++) {
                if (this.playgroud[i][col] == num || this.playgroud[row][i] == num ||
                        this.playgroud[startRow + i / 3][startCol + i % 3] == num) {
                    return false;
                }
            }

            return true;

    }


    /**
     * Prints the board to the console.
     */
    public void printBoard(){
        System.out.println(generatePrintableString());
    }

    /**
     *
     */
    public String generatePrintableString() {
        StringBuilder printable = new StringBuilder();
        for (Integer[] row : playgroud) {
            for (Integer col : row) {
                printable.append(col);
                printable.append(" ");
            }
            printable.append('\n');
        }
        return printable.toString();
    }


    /**
     * Returns a Number found at position row col
     * @param row location
     * @param col location
     * @return the number at this location
     */
    public int getNumberAt(int row, int col){
        return this.playgroud[row][col];
    }

    /**
     * Populates the Game with numbers
     * @param seed a string of numbers to populate a game in form 001020304567...
     *             //TODO refector to work with numbers 10 upwards
     */
    public void populateGame(String seed){
        char[] numbers = seed.toCharArray();
        int pointer=0;
        for(int row=0;row<GAME_SIZE;row++)
            for(int col=0;col<GAME_SIZE;col++)
                playgroud[row][col]=Integer.parseInt(String.valueOf(numbers[pointer++]));
    }

    /**
     * Resets the Value of a Game to 0
     */
    public void resetAt(int row, int col){
        this.playgroud[row][col]=0;
    }

    public Integer[][] getBoard() {
        return this.playgroud;
    }
}
