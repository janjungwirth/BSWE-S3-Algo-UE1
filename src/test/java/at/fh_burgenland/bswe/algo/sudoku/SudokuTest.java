package at.fh_burgenland.bswe.algo.sudoku;

import at.fh_burgenland.bswe.algo.exceptions.InvalidMoveException;
import at.fh_burgenland.bswe.algo.exceptions.InvalidSizeException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    static Sudoku game = null;
    @BeforeAll
    static void setUp(){
        game = new Sudoku(9);
    }


    @AfterEach
    void reset(){
        setUp();
    }

    @Nested
    @DisplayName("Play Move Tests")
    class PlayMove{


        /**
         * This Test will check the place move function
         *  *Number will be placed on correct location
         *  *No Error will be thrown
         */
        @Test
        @DisplayName("Place Number at Valid")
        public void placeMoveValid() {
            game.playMove(0, 0, 1);
            String expected = "1 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n";
            String actual = game.generatePrintableString();
            assertEquals(expected,actual);
            assertEquals(actual.getBytes(StandardCharsets.UTF_8)[0],'1');

        }
        /**
         * This Test will check the place move function
         *  *Number will be placed on correct location
         *  *No Error will be thrown
         */
        @Test
        @DisplayName("Place Number at Valid")
        public void placeMoveInvalidGrid() {
            game.playMove(0, 0, 1);
            InvalidMoveException thrown = assertThrows(
                    InvalidMoveException.class,
                    () -> game.playMove(1, 1, 1),
                    "Expected playMove to throw, but it didn't"
            );
            String expected = "1 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n";
            String actual = game.generatePrintableString();
            assertEquals(expected,actual);
            assertEquals(actual.getBytes(StandardCharsets.UTF_8)[0],'1');

        }

        /**
         * No duplicate Number allowed in one Colum
         */
        @Test
        @DisplayName("Place Number at Invalid Position")
        public void placeMoveInvalidCOL(){
            game.playMove(0, 0, 1);
            InvalidMoveException thrown = assertThrows(
                    InvalidMoveException.class,
                    () -> game.playMove(3, 0, 1),
                    "Expected playMove to throw, but it didn't"
            );
            String expected = "1 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n";
            String actual = game.generatePrintableString();
            assertEquals(expected,actual);
            assertEquals(actual.getBytes(StandardCharsets.UTF_8)[0],'1');
        }

        /**
         * No duplicate Number allowed in one Row
         */
        @Test
        @DisplayName("Place Number at Invalid Position")
        public void placeMoveInvalidROW(){
            game.playMove(0, 0, 1);
            InvalidMoveException thrown = assertThrows(
                    InvalidMoveException.class,
                    () -> game.playMove(0, 3, 1),
                    "Expected playMove to throw, but it didn't"
            );
            String expected = "1 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n";
            String actual = game.generatePrintableString();
            assertEquals(expected,actual);
            assertEquals(actual.getBytes(StandardCharsets.UTF_8)[0],'1');
        }

        /**
         * This test checks if invalid numbers cant be placed
         */
        @DisplayName("Play Invalid number")
        @ParameterizedTest
        @ValueSource(ints = {0, -1, 10})
        public void playInvalidNumber(int number){
            InvalidMoveException thrown = assertThrows(
                    InvalidMoveException.class,
                    () -> game.playMove(1, 0, number),
                    "Expected playMove to throw, but it didn't"
            );
            assertEquals(thrown.getMessage(), "Number "+number+" is not allowed.");
        }
    }

    @Nested
    @DisplayName("Create Game Test")
    class CreateGame{

        /**
         * Creation did not throw an Exception and Field is filled with 0
         */
        @Test
        @DisplayName("Create valid Game field")
        public void createValidGame(){
            String expected = "0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 \n";
            String actual = game.generatePrintableString();
            assertEquals(expected,actual);
        }

        /**
         * Creating a Game with size less or Equals then 5 will throw an error
         */
        @Test
        @DisplayName("Create invalid Game field")
        public void createInvalidGame(){
            InvalidSizeException thrown = assertThrows(
                    InvalidSizeException.class,
                    () -> game=new Sudoku(5),
                    "Expected new Sudoku(5) to throw, but it didn't"
            );
            assertEquals(thrown.getMessage(), "The Size must be at least 6 fields and dividable by 3");
        }

    }


}