import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber, colNumber;
    char[][] field;
    char[][] holderField;
    int colInput;
    int rowInput;


    public MineSweeper(int rowNumber, int colNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.field = new char[rowNumber][colNumber];
        this.holderField = new char[rowNumber][colNumber];
    }
    public  void EmptyField(){
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                field[i][j] = '-';
            }
        }
    }
    public void Mine(){
        int mineCount = (colNumber*rowNumber)/4;
        //int[][] holder = new int[rowNumber][colNumber];
        Random rand = new Random();
        int starsPlaced = 0;
        EmptyField();
        while (starsPlaced < mineCount) {
            int randomRow = rand.nextInt(rowNumber);
            int randomCol = rand.nextInt(colNumber);
            if (field[randomRow][randomCol] != '*') {
                field[randomRow][randomCol] = '*';
                starsPlaced++;
            }
        }
        System.arraycopy(field,0,holderField,0,field.length);
    }

    public void GetValue(){
        Scanner imp = new Scanner(System.in);
        System.out.println("satır giriniz : ");
        int rowInput = imp.nextInt();
        System.out.println("sütun giriniz : ");
        int colInput = imp.nextInt();
        if (rowInput<rowNumber && colInput<colNumber){
            this.rowInput =  rowInput;
            this.colInput = colInput;
        }else{
            System.out.println("Oyun alaninin içinde bir deger giriniz");
            GetValue();
        }
    }

    public  void PrintScreen(){
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(holderField[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("=======================================");
        EmptyField();
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                System.out.print(field[i][j]);
            }
            System.out.print("\n");
        }

    }

    public void run(){

        Mine();
        PrintScreen();
        GetValue();
    }

}
