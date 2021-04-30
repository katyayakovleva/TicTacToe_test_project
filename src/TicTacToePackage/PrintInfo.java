package TicTacToePackage;

public class PrintInfo {

    public enum Answer{START, YES, NO, REPEAT}
    public enum WrongEnters{ WRONG_ENTER_ANSWER, WRONG_ENTER_PLACE_DONT_EXIST, WRONG_ENTER_RACE_IS_FULL, WRONG_ENTER_SIZE}
    //Лямбда кейсы, неплохо
    //Свежий функционал в JDK
    //TODO убрать static модификатор из методов этого класса
    public static void showMainGameText(Answer answer){
        switch (answer) {
            case START -> System.out.print("\nХотите начать игру (yes/no): ");
            case YES -> System.out.println("\nНачинаем игру\n");
            case NO -> System.out.println("Ну окей(");
            case REPEAT -> System.out.print("\nЕщё разок?(yes/no): ");
            default -> throw new IllegalStateException("Unexpected value: " + answer);
        }
    }
    public static void printGetSize(){
        System.out.print("Введите размер поля для игры: ");
    }
    public static void showCurrentPlayer(String player){
        System.out.println("Ход игрока "+ player + "\n");
    }
    public static void draw(){
        System.out.println("Ничья, играйте снова");
    }
    public static void showWinner(String player){
        System.out.println(player + " - победил\n");
    }
    public static void row(){
        System.out.print("Рядочек: ");
    }
    public static void column(){
        System.out.print("Столбик: ");
    }
    public static void wrongInput(WrongEnters wrongEnter){
        switch (wrongEnter){
            case WRONG_ENTER_ANSWER ->System.out.println("\nЧто за хрень ты ввел? Теперь ещё раз и нормально, пожалуйста!");
            case WRONG_ENTER_SIZE -> {
                System.out.println("\nВведите число больше 0, потому что вы ввели бред\n");
                printGetSize();
            }
            case WRONG_ENTER_RACE_IS_FULL -> System.out.println("\nВидимо у кого-то проблемы с памятью) Это место уже занято\n");
            case WRONG_ENTER_PLACE_DONT_EXIST -> System.out.println("\nПротри глаза, ты где такое место на поле то увидел?\n");
            default -> throw new IllegalStateException("Unexpected value");
        }
    }
}