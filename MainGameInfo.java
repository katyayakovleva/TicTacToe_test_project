public class MainGameInfo {
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
