package TicTacToePackage;

import java.util.Scanner;

public class Input {
    //Поскольку Scanner теперь используется только в одном месте, нет никакой проблемы применить вместо него что то другое
    //TODO Потому Scanner мы заменим на более современный InputStreamReader, а конкретнее, его реализацию - BufferedReader
    static Scanner in = new Scanner(System.in);

    public static int getSize(){
        //TODO Есть три отдельных класса для вывода информации игроку, но вызовы print всё ещё встречаются в коде - не дело
        System.out.print("Выбирете размер поля: ");
        //TODO
        //В описании метода nextInt можно заметить что он может выдавать достаточно много различных RuntimeException, в зависимости от ввода
        //И эти ошибки приведут к остановке прогреммы, чего нам допускать не стоит
        return in.nextInt();
        //Throws:
        //InputMismatchException – if the next token does not match the Integer regular expression, or is out of range
        //NoSuchElementException – if input is exhausted
        //IllegalStateException – if this scanner is closed
    }
    public static String getAnswer(){
        String answer = in.next();
        while (!checkAnswer(answer)){
            System.out.println("\nЧто за хрень ты ввел? Теперь ещё раз и нормально, пожалуйста!");
            answer = in.next();
            //Throws:
            //NoSuchElementException – if no more tokens are available
            //IllegalStateException – if this scanner is closed
        }
        return answer;
    }
    //В отличии от ввода цифр, здесь есть определённая валидация
    private static boolean checkAnswer(String s){
        return s.equals("no") || s.equals("yes");
    }
    public static int getRow(){
        System.out.print("Рядочек: ");
        return  in.nextInt();
        //Throws:
        //InputMismatchException – if the next token does not match the Integer regular expression, or is out of range
        //NoSuchElementException – if input is exhausted
        //IllegalStateException – if this scanner is closed
    }
    public static int getColumn(){
        System.out.print("Столбик: ");
        return in.nextInt();
        //Throws:
        //InputMismatchException – if the next token does not match the Integer regular expression, or is out of range
        //NoSuchElementException – if input is exhausted
        //IllegalStateException – if this scanner is closed
    }

}
