package TicTacToePackage;

import java.io.IOException;

public class TicTacToe {
    private final int SIZE;
    private final String [][] ticTacToeArr_;
    private String player_ ;
    private final Input input_;
    private final PrintInfo printInfo_;
    private String checkX = "";
    private String checkO = "";

    public TicTacToe(int size){
        player_ = "O";
        SIZE = size;
        ticTacToeArr_ = new String[SIZE][SIZE];
        input_ = new Input();
        printInfo_ = new PrintInfo();
        for (int i = 0; i < SIZE; i++) {
            checkX = "%sX".formatted(checkX);
            checkO = "%sO".formatted(checkO);
        }
    }
    public void ticTacToeGame() throws IOException {
        TicTacToeField.getField(ticTacToeArr_, SIZE);
        while (!checkGameIsEnd()){
            getPlayerMove();
            TicTacToeField.getField(ticTacToeArr_, SIZE);
        }

    }
    private void getPlayerMove() throws IOException {
        printInfo_.showCurrentPlayer(player_);
        while (true){
            int row = input_.getRow();
            int column = input_.getColumn();
            if (checkRowAndColumn(row,column)){
                changeTicTacToeArr(row, column);
                return;
            }
        }
    }
    private void changeTicTacToeArr(int row, int column){
        ticTacToeArr_[row-1][column-1] = player_;
    }
    public boolean checkGameIsEnd(){
        StringBuilder sCheckDiagonal1 = new StringBuilder();
        StringBuilder sCheckDiagonal2 = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {

            StringBuilder sCheckRows = new StringBuilder();
            StringBuilder sCheckColumns = new StringBuilder();

            for (int j = 0; j < SIZE; j++) {
                sCheckRows.append(ticTacToeArr_[i][j]);
                sCheckColumns.append(ticTacToeArr_[j][i]);
                if (i == j){
                    sCheckDiagonal1.append(ticTacToeArr_[i][j]);
                }
            }
            sCheckDiagonal2.append(ticTacToeArr_[SIZE-1-i][i]);
            if (checkIfStringIsEqualsToXXXOrOOO(sCheckRows)
                    || checkIfStringIsEqualsToXXXOrOOO(sCheckColumns)) {
                printInfo_.showWinner(player_);
                return true;
            }
        }
        if (checkIfStringIsEqualsToXXXOrOOO(sCheckDiagonal1)
                || checkIfStringIsEqualsToXXXOrOOO(sCheckDiagonal2)) {
            printInfo_.showWinner(player_);
            return true;
        }
        if (!checkFieldIsFull()) {
            changePlayer();
        } else {
            printInfo_.draw();
            return true;
        }
        return false;
    }
    private void changePlayer(){
        if (!player_.equals("X")) {
            player_ = "X";
        } else {
            player_ = "O";
        }
    }
    private boolean checkFieldIsFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (ticTacToeArr_[i][j] == null)
                    return false;
            }
        }
        return true;
    }
    private boolean checkRowAndColumn(int row, int column){
        if (row < 1 || row > SIZE || column < 1 || column > SIZE){
            printInfo_.wrongInput(PrintInfo.WrongEnters.WRONG_ENTER_PLACE_DONT_EXIST);
            return false;
        }
        else if(ticTacToeArr_[row-1][column-1] != null){
            printInfo_.wrongInput(PrintInfo.WrongEnters.WRONG_ENTER_RACE_IS_FULL);
            return false;
        }
        else {
            return true;
        }
    }
    private boolean checkIfStringIsEqualsToXXXOrOOO(StringBuilder stringCheck){
        return stringCheck.toString().equals(checkX) || stringCheck.toString().equals(checkO);
    }
}