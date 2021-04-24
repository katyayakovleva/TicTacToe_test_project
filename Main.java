import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Хотите начать игру (yes/no)");

        while (true){
            Scanner in = new Scanner(System.in);
            String s = in.next();
            System.out.println();
            while (!checkInput(s)){
                System.out.println("Что за хрень ты ввел? Теперь ещё раз и нормально, пожалуйста!");
                s = in.next();
            }
            if (s.equals("yes")){
                System.out.print("Выбирете размер поля: ");
                int n = in.nextInt();
                TicTacToe ticTacToe = new TicTacToe(n);
                ticTacToe.game();
            }
            else if (s.equals("no")){
                System.out.println("Ну окей");
                return;
            }
            System.out.println("\nЕщё разок?(yes/no)");
        }
    }
    private static boolean checkInput(String s){
        return s.equals("no") || s.equals("yes");
    }
}
