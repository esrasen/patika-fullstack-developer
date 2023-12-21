public class Main {

    // Palindrome kelime, tersten okunuşu da aynı olan kelimelerdir.
    static boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /*      // 2. yöntem
    static boolean isPalindrome2(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return word.equals(reverse);
    }
    */

    public static void main(String[] args) {

        String[] words = {"madam", "ada", "kayak", "kabak", "kayık" };
        for (String word : words) {
            System.out.println(word + " : " + isPalindrome(word));
        }
    }
}
