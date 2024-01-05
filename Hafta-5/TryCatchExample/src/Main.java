import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //10 elemanlı bir dizi tanımladım.
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Bir index giriniz: ");
        int index = input.nextInt();

        //try-catch bloğu içerisinde dizinin elemanlarına erişmeye çalıştım.
        //eğer girilen index dizinin boyutundan büyükse catch bloğu çalışacak.
        try {
            System.out.println("Dizinin " + index + ". elemanı: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dizinin boyutunu aştınız!");
            System.out.println(e.toString());
        }finally {
            input.close();
        }
    }
}