import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int number = random.nextInt(100);
        int right = 0;
        int selectedNumber = 0;
        int[] wrongNumbers = new int[5];
        boolean isWin = false;
        boolean isWrong = false;


        while (right < 5) {
            System.out.print("Lütfen tahmininizi giriniz: ");
            selectedNumber = input.nextInt();

            if (selectedNumber < 0 || selectedNumber > 99) {
                System.out.println("Lütfen 0 ile 100 arasında bir sayı giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Kalan hak: " + (5 - right));
                } else {
                    isWrong = true;
                }
                continue;
            }
            if (selectedNumber == number) {
                System.out.println("Tebrikler, doğru tahmin!");
                isWin = true;
                break;
            } else {
                System.out.println("Yanlış tahmin!");
                if (selectedNumber < number) {
                    System.out.println("Girdiğiniz sayı, gizli sayıdan küçük.");
                } else {
                    System.out.println("Girdiğiniz sayı, gizli sayıdan büyük.");

                }
                wrongNumbers[right] = selectedNumber;
                right++;
                System.out.println("Kalan hak: " + (5 - right));

            }
        }


        if (!isWin) {
            System.out.println("Kaybettiniz!");
            System.out.println("Gizli sayı: " + number);

            if (!isWrong) {
                System.out.println("Tahminleriniz: " + Arrays.toString(wrongNumbers));
            }
        }
    }
}