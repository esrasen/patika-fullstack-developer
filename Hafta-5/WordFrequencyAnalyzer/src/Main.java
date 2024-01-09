import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Bir metin giriniz: ");
        String text = input.nextLine();

        String[] words = text.split(" "); //metni boşluklara göre ayırdım.

        HashMap<String, Integer> wordFrequency = new HashMap<>();   //kelimeleri ve frekanslarını tutmak için bir HashMap oluşturdum.


        for (String word : words) {
            // Kelimenin tüm harflerini küçük harfe çevir
            word = word.toLowerCase();

            if (wordFrequency.containsKey(word)) {
                int count = wordFrequency.get(word);
                wordFrequency.put(word, count + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }

        String mostFrequentWord = "";
        int maxFrequency = 0;

        //kelimelerin frekanslarını karşılaştırarak en çok tekrar eden kelimeyi buldum.

        for (String word : wordFrequency.keySet()) {
            if (wordFrequency.get(word) > maxFrequency) {
                maxFrequency = wordFrequency.get(word);
                mostFrequentWord = word;
            }
        }

        //en çok tekrar eden kelimeyi ve kaç kere tekrar ettiğini yazdırdım.

        System.out.println("En çok tekrar eden kelime: " + mostFrequentWord);
        System.out.println("Bu kelime " + maxFrequency + " kere tekrar edildi.");

    }
}