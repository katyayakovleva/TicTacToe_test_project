package TicTacToePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Input {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //TODO убрать static модификатор из методов этого класса
    public static String getAnswer() throws IOException {
        String answer = bufferedReader.readLine();
        while (!checkAnswer(answer)){
            PrintInfo.wrongInput(PrintInfo.WrongEnters.WRONG_ENTER_ANSWER);
            answer = bufferedReader.readLine();
        }
        return answer;
    }
    private static boolean checkAnswer(String answer){
        return answer.equals("no") || answer.equals("yes");
    }
    public static int getSize() throws IOException {
        String s = bufferedReader.readLine();
        //Regex, хороший вибор
        while (!Pattern.matches("^[1-9]\\d*$",s)){
            PrintInfo.wrongInput(PrintInfo.WrongEnters.WRONG_ENTER_SIZE);
            s = bufferedReader.readLine();
        }
        return Integer.parseInt(s);
    }
    public static int getRow() throws IOException {
        PrintInfo.row();
        String s = bufferedReader.readLine();
        while (!Pattern.matches("\\d",s)){
            s = bufferedReader.readLine();
        }
        return Integer.parseInt(s);
    }
    public static int getColumn() throws IOException {
        PrintInfo.column();
        String s = bufferedReader.readLine();
        while (!Pattern.matches("\\d",s)){
            s = bufferedReader.readLine();
        }
        return Integer.parseInt(s);
    }
}