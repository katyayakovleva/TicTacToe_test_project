import packageTTT.TicTacToe;
import packageTTT.Input;

public class Main {
    public static void main(String[] args) {
        MainGameInfo.showMainGameText("start");
        while (true){
            String answer = Input.getAnswer();
            if (answer.equals("yes")){
                MainGameInfo.showMainGameText("yes");
                int size = Input.getSize();
                TicTacToe ticTacToe = new TicTacToe(size);
                ticTacToe.ticTacToeGame();
            }
            else {
                MainGameInfo.showMainGameText("no");
                return;
            }
            MainGameInfo.showMainGameText("repeat");
        }
    }
}