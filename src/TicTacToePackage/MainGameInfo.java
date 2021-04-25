package TicTacToePackage;

public class MainGameInfo {
    //идея с switch неплохая, но не рациональная, т.к. добавляет лишнюю задержку на сравнение строк
    //я подозреваю что ты здесь изобретала Factory Pattern, но получилось что то не то.
    //Заменить строки на значения из enum множества, и будет то что надо
    public static void showMainGameText(String answer){
        switch (answer) {
            case "start" -> System.out.println("Хотите начать игру (yes/no)");
            case "yes" -> System.out.println("Начинаем игру\n");
            case "no" -> System.out.println("Ну окей");
            case "repeat" -> System.out.println("\nЕщё разок?(yes/no)");
            default -> throw new IllegalStateException("Unexpected value: " + answer);
        }
    }
}
