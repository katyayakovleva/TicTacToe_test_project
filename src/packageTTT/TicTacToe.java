package packageTTT;

public class TicTacToe {
    private final int SIZE;
    private final String [][] ticTacToeArr_;
    private String player_ ;

    public TicTacToe(int size){
        player_ = "O";
        SIZE = size;
        ticTacToeArr_ = new String[SIZE][SIZE];
    }
    public void ticTacToeGame(){
        TicTacToeField.getField(ticTacToeArr_, SIZE);
        while (!checkGameIsEnd()){
            getPlayerMove();
            TicTacToeField.getField(ticTacToeArr_, SIZE);
        }
        TicTacToeInfo.showWinner(player_);
    }
    private void getPlayerMove(){
        TicTacToeInfo.showCurrentPlayer(player_);
        while (true){
            int row = Input.getRow();
            int column = Input.getColumn();
            if (checkRowAndColumn(row,column)){
                changeTicTacToeArr(row, column);
                return;
            }else {
                TicTacToeInfo.wrongInput();
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
                return true;
            }
        }
        if (checkIfStringIsEqualsToXXXOrOOO(sCheckDiagonal1)
                || checkIfStringIsEqualsToXXXOrOOO(sCheckDiagonal2)) {
            return true;
        }
        if (!checkFieldIsFull()) {
            changePlayer();
        } else {
            TicTacToeInfo.draw();
        }
        return false;
    }
    private boolean checkIfStringIsEqualsToXXXOrOOO(StringBuilder stringCheck){
        return stringCheck.toString().equals("XXX") || stringCheck.toString().equals("OOO");
    }
    private boolean checkRowAndColumn(int row, int column){
        return ((row >= 1 && row <= 3) && (column >= 1 && column <= 3)
                && ticTacToeArr_[row-1][column-1] == null);
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
}