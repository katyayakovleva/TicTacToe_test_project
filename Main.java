import TicTacToePackage.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintInfo printInfo = new PrintInfo();
        printInfo.showMainGameText(PrintInfo.Answer.START);
        while (true){
                Input input = new Input();
                String answer = input.getAnswer();
            if (answer.equals("yes")){
                printInfo.showMainGameText(PrintInfo.Answer.YES);
                printInfo.printGetSize();
                int size = Input.getSize();
                TicTacToe ticTacToe = new TicTacToe(size);
                ticTacToe.ticTacToeGame();
            }
            else {
                printInfo.showMainGameText(PrintInfo.Answer.NO);
                return;
            }
            printInfo.showMainGameText(PrintInfo.Answer.REPEAT);
        }
    }
}