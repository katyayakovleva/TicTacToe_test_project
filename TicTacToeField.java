package TicTacToePackage;

public class TicTacToeField {
    public static void getField(String[][] ticTacToeArr, int size){
        System.out.println("Текущий вид поля:\n");
        System.out.print(" ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + (i+1)+ "  ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i+1);
            for (int j = 0; j < size; j++) {
                if(ticTacToeArr[i][j] == null){
                    System.out.print("   ");
                }
                else {
                    System.out.print(" "+ ticTacToeArr[i][j]+" ");
                }
                if (j<size-1)System.out.print("|");
            }
            System.out.println();
            if (i<size-1){
                System.out.print(" ");
                for (int j = 0; j < size; j++) {
                    System.out.print("---");

                    if (j < size-1){
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}
