import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir metin girin:  ");
        String text = scanner.nextLine();


        writeToTextFile("Hafta-6/Notepad/notes.txt", text);      // dosyaya yazma işlemi
        String savedText = readFromTextFile("Hafta-6/Notepad/notes.txt");     // dosyadan okuma işlemi
        System.out.print("Kaydedilen metin: " + savedText);               // okunan metni ekrana yazdırma

    }

    // dosyaya yazma işlemi
    private static void writeToTextFile(String filePath, String text) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true))) {
            //append true döndüğünde dosyanın sonuna ekler, false döndüğünde dosyayı sıfırlar.
            printWriter.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // dosyadan okuma işlemi
    private static String readFromTextFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();     // okunan metni geri döndür
    }
}