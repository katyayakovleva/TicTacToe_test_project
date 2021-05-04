package tictactoe_project.TicTacToePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Input {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static PrintInfo printInfo = new PrintInfo();

    public String getAnswer() throws IOException {
        String answer = bufferedReader.readLine();
        while (!checkAnswer(answer)){
            printInfo.wrongInput(PrintInfo.WrongEnters.WRONG_ENTER_ANSWER);
            answer = bufferedReader.readLine();
        }
        return answer;
    }
    private boolean checkAnswer(String answer){
        return answer.equals("no") || answer.equals("yes");
    }
    public static int getSize() throws IOException {
        String s = bufferedReader.readLine();
        while (!Pattern.matches("^[1-9]\\d*$",s)){
            printInfo.wrongInput(PrintInfo.WrongEnters.WRONG_ENTER_SIZE);
            s = bufferedReader.readLine();
        }
        return Integer.parseInt(s);
    }
    public int getRow() throws IOException {
        printInfo.row();
        String s = bufferedReader.readLine();
        while (!Pattern.matches("\\d",s)){
            s = bufferedReader.readLine();
        }
        return Integer.parseInt(s);
    }
    public int getColumn() throws IOException {
        printInfo.column();
        String s = bufferedReader.readLine();
        while (!Pattern.matches("\\d",s)){
            s = bufferedReader.readLine();
        }
        return Integer.parseInt(s);
    }
}
