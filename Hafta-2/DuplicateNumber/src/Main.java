public class Main {
    // Bir değerin bir dizide daha önce bulunup bulunmadığını kontrol eden fonksiyon
    static boolean isFind(int[] arr, int value) {
        for (int i : arr) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] list = {15, 12, 22, 12, 788, -74, 788, 1, -1, -778, 2, 2, 4, 4, 4, 0, 8, -74};
        //tekrar eden sayıları tutmak için bir dizi oluşturuyoruz
        int[] duplicate = new int[list.length];
        int startIndex = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                //eğer i. eleman j. elemana eşitse ve çift sayıysa
                if (list[i] == list[j] && list[i] % 2 == 0) {
                    //daha önce eklenmediyse duplicate dizisine ekle
                    if (!isFind(duplicate, list[i])) {
                        duplicate[startIndex++] = list[i];
                    }
                    break;
                }
            }
        }

        //tekrar eden çift sayıları yazdır

        if (startIndex > 0) {
            System.out.println("Tekrar eden çift sayılar:");
            for (int k = 0; k < startIndex; k++) {
                System.out.println(duplicate[k]);
            }
        } else {
            System.out.println("Tekrar eden çift sayı bulunamadı.");
        }
    }
}