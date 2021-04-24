
//TODO создать отдельный класс чтения ввода пользователя и убрать всё использование Scanner за его пределами
import java.util.Scanner;

//TODO ознакомится с Java Code Conventions или же Google Java Style Guide
//TODO вынести все вызовы уведомлений (вроде "ход игрока Х") в отдельный класс
public class TicTacToe {
    private final int SIZE;
    private final String [][] arrOfXAndO;

    String player = "O";
    //TODO стабилизировать количество отступов между методами; вот тут отступа нет, а перед getXorO() он есть
    public TicTacToe(int n){
        SIZE = n;
        arrOfXAndO = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arrOfXAndO[i][j] = " ";
            }
        }
    }
    public void game(){
        field();
        while (checkGame()){
            System.out.println("Ход игрока "+ player + "\n");
            getXorO();
            field();
        }
    }
    //TODO вынести отрисовку поля в отдельный класс
    private void field(){
        System.out.println("Текущий вид поля:\n");
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i+1)+ "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+1);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" "+ arrOfXAndO[i][j] +" ");
                if (j<SIZE-1)System.out.print("|");
            }
            System.out.println();
            if (i<SIZE-1){
                System.out.print(" ");
                for (int j = 0; j < SIZE; j++) {

                        System.out.print("---");

                    if (j < SIZE-1){
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    private void getXorO(){
        while (true){
            Scanner in = new Scanner(System.in);
            System.out.print("Рядочек: ");
            int line = in.nextInt();
            System.out.print("Столбик: ");
            int column=in.nextInt();
            System.out.println();
            if (checkInput(line,column)){
                changeField(line, column);
                return;
            }else {
                System.out.println("Ты дурак? Вводи ещё раз.\n");
            }
        }

    }
    private void changeField(int row, int column){
        arrOfXAndO[row-1][column-1] = player;
    }
    public boolean checkGame(){
        boolean game = false;
        String X = "XXX";
        String O = "OOO";
        StringBuilder sCheck3 = new StringBuilder();
        StringBuilder sCheck4 = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {

            StringBuilder sCheck1 = new StringBuilder();
            StringBuilder sCheck2 = new StringBuilder();

            for (int j = 0; j < SIZE; j++) {
               sCheck1.append(arrOfXAndO[i][j]);
               sCheck2.append(arrOfXAndO[j][i]);
               if (i == j){
                   sCheck3.append(arrOfXAndO[i][j]);
               }
            }
            sCheck4.append(arrOfXAndO[SIZE-1-i][i]);
            if (sCheck1.toString().equals(X) || sCheck1.toString().equals(O)
                    || sCheck2.toString().equals(X) || sCheck2.toString().equals(O)) {
                game = true;
            }
        }
        if (sCheck3.toString().equals(X) || sCheck3.toString().equals(O)
                || sCheck4.toString().equals(X) || sCheck4.toString().equals(O)) {
            game = true;
        }
        if (game) {
            showWinner();
            return false;
        } else {
            if (checkFieldIsFull()) {
                changePlayer();
                return true;
            }
            else {
                System.out.println("Ничья, играйте снова");
                return false;
            }
        }
    }
    private void showWinner(){
        System.out.println(player + " - победил\n");
        changePlayer();
        System.out.println(player + " - позорно проиграл\n");
    }
    private boolean checkFieldIsFull(){
        int n = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arrOfXAndO[i][j].equals(" "))
                    n++;
            }
        }
        return (n != 0);
    }
    private boolean checkInput(int line, int column){
        return ((line >= 1 && line <= 3) && (column >= 1 && column <= 3) && arrOfXAndO[line-1][column-1].equals(" "));
    }
    private void changePlayer(){
        if (player.equals("X")){
            player = "O";
        }else player = "X";
    }
}
