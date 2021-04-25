package packageTTT;

import java.util.Scanner;

public class Input {

    static Scanner in = new Scanner(System.in);

    public static int getSize(){
        System.out.print("Выбирете размер поля: ");
        return in.nextInt();
    }
    public static String getAnswer(){
        String answer = in.next();
        while (!checkAnswer(answer)){
            System.out.println("\nЧто за хрень ты ввел? Теперь ещё раз и нормально, пожалуйста!");
            answer = in.next();
        }
        return answer;
    }
    private static boolean checkAnswer(String s){
        return s.equals("no") || s.equals("yes");
    }
    public static int getRow(){
        System.out.print("Рядочек: ");
        return  in.nextInt();
    }
    public static int getColumn(){
        System.out.print("Столбик: ");
        return in.nextInt();
    }

}