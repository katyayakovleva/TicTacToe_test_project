package TicTacToePackage;

public class TicTacToeInfo {
    public static void showCurrentPlayer(String player){
        System.out.println("Ход игрока "+ player + "\n");
    }
    public static void draw(){
        System.out.println("Ничья, играйте снова");
    }
    public static void showWinner(String player){
        System.out.println(player + " - победил\n");
    }
    public static void wrongInput(){
        System.out.println("Ты дурак? Вводи ещё раз.\n");
    }
}
