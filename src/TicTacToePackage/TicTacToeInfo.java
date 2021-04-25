package TicTacToePackage;

public class TicTacToeInfo {
    //То что я хотел увидеть, да
    //Но поскольку у нас уже два класса отвечают за разные подходы к выводу данных игрокам
    //Лучше будет обьединить их под одним package
    //Например, назовём его TicTacToePackage.view
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
