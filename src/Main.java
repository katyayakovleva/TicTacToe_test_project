import TicTacToePackage.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintInfo.showMainGameText(PrintInfo.Answer.START);
        while (true){
                String answer = Input.getAnswer();
            if (answer.equals("yes")){
                PrintInfo.showMainGameText(PrintInfo.Answer.YES);
                PrintInfo.printGetSize();
                int size = Input.getSize();
                TicTacToe ticTacToe = new TicTacToe(size);
                ticTacToe.ticTacToeGame();
            }
            else {
                PrintInfo.showMainGameText(PrintInfo.Answer.NO);
                return;
            }
            PrintInfo.showMainGameText(PrintInfo.Answer.REPEAT);
        }
    }
}