import java.util.Scanner;

public class Main {
    static boolean isPrime(int number, int i) {
        // 2'den küçük veya eşit olan sayılar asal değildir
        if (number <= 2)
            return (number == 2) ? true : false;
        // Eğer sayı i'ye tam bölünüyorsa, asal değildir
        if (number % i == 0)
            return false;
        // Eğer i'nin karesi sayıdan büyükse, sayı asaldır
        if (i * i > number)
            return true;
        // Yukarıdaki koşullar sağlanmazsa, bir sonraki böleni kontrol etmek üzere recursive olarak devam et
        return isPrime(number, i + 1);
    }

    public static void main(String[] args) {

        // Kullanıcıdan sayı al
        Scanner scan = new Scanner(System.in);
        System.out.println("Sayı giriniz :");
        int number = scan.nextInt();

        // isPrime metodu ile sayının asal olup olmadığını kontrol et ve sonucu ekrana yazdır
        System.out.println(isPrime(number, 2) ? "Sayı asaldır." : "Sayı asal değildir.");
    }
}