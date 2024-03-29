import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
public class Phone extends Product {        //Product sınıfından kalıtım aldık
    private int memory;
    private double screenSize;
    private int ram;
    private int camera;
    private int battery;
    private String color;

    public Phone(int id, String name, double price, int discount, int stock, String brand, int memory, double screenSize, int ram, int camera, int battery, String color) {
        super(id, name, price, discount, stock, brand);     //super anahtar kelimesi ile üst sınıfın constructor'ını çağırdık
        this.memory = memory;
        this.screenSize = screenSize;
        this.ram = ram;
        this.camera = camera;
        this.battery = battery;
        this.color = color;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    //listeleme
    public static void listPhoneMenu() {

        phones();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            try {
                System.out.println("1 - Telefonları Listele");
                System.out.println("2 - Telefon Ekle");
                System.out.println("3 - Telefon Sil");
                System.out.println("4 - Markaya Göre Listele");
                System.out.println("5 - ID'ye Göre Telefon Listele");
                System.out.println("0 - Önceki Menü");
                System.out.println("Tercihiniz: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        listPhones();
                        break;
                    case 2:
                        addPhone(phones);
                        break;
                    case 3:
                        deletePhone(phones);
                        break;
                    case 4:
                        listPhonesByBrand("brand");
                        break;
                    case 5:
                        listPhoneById(0);
                        break;
                    case 0:
                        System.out.println("Önceki menüye dönülüyor...");
                        break;
                    default:
                        System.out.println("Yanlış bir işlem seçtiniz!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Hatalı giriş yaptınız. Lütfen doğru türde tekrar deneyiniz.");
                input.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    //telefonlar
    static ArrayList<Phone> phones = new ArrayList<>();

    public static void phones() {
        phones.add(new Phone(1, "IPhone 8", 5000, 10, 50, "Apple", 64, 4.7, 2, 12, 1821, "Siyah"));
        phones.add(new Phone(2, "IPhone 12", 10000, 10, 50, "Apple", 128, 6.1, 4, 12, 2815, "Beyaz"));
        phones.add(new Phone(3, "Samsung Galaxy A51", 3000, 10, 50, "Samsung", 128, 6.5, 4, 48, 4000, "Mavi"));
        phones.add(new Phone(4, "Samsung Galaxy A71", 4000, 10, 50, "Samsung", 128, 6.7, 6, 64, 4500, "Siyah"));
        phones.add(new Phone(5, "Huawei P30 Lite", 2000, 10, 50, "Huawei", 128, 6.15, 4, 48, 3340, "Beyaz"));
        phones.add(new Phone(6, "Huawei P40 Lite", 3000, 10, 50, "Huawei", 128, 6.4, 6, 48, 4200, "Siyah"));


    }

    //listeleme
    public static void listPhones() {
        System.out.println("-----------------------------------------------------Telefon Listesi-----------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s | %-9s |\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        for (Phone phone : phones) {        //phones listesindeki her bir telefon için
            System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d | %-9d | %-9d | %-9s |\n",
                    phone.getId(), phone.getName(), phone.getPrice(), phone.getBrand(), phone.getMemory(), phone.getScreenSize(), phone.getCamera(), phone.getBattery(), phone.getRam(), phone.getColor());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    //ekleme
    public static void addPhone(ArrayList<Phone> phones) {

        Scanner input = new Scanner(System.in);
        ArrayList<Phone> newPhones = new ArrayList<>();     //Yeni telefonları bu listeye ekleyeceğiz

        try {                     //Hatalı girişlerde programın çökmemesi için try-catch bloğu kullandım
            System.out.println("Bir ID giriniz:");
            int id = input.nextInt();
            input.nextLine();

            boolean isIdExist = false;
            for (Phone phone : phones) {
                if (phone.getId() == id) {
                    isIdExist = true;
                    break;
                }
            }
            if (isIdExist) {
                System.out.println("Bu id ile kayıtlı bir telefon bulunmaktadır.");
            } else {
                System.out.println("Eklemek istediğiniz telefonun adını giriniz: ");
                String name = input.nextLine();
                System.out.println("Eklemek istediğiniz telefonun fiyatını giriniz: ");
                double price = input.nextDouble();
                System.out.println("Eklemek istediğiniz telefonun markasını giriniz: ");
                String brand;
                do {        //Marka doğru girilene kadar döngü devam edecek
                    brand = input.next();
                    brand = brand.substring(0, 1).toUpperCase() + brand.substring(1).toLowerCase();    //Marka isminin ilk harfini büyük harf yapmak için

                    if (Brand.isValidBrand(brand)) {
                        System.out.println("Marka doğru girildi.");
                    } else {
                        System.out.println("Marka yanlış girildi. Lütfen listedeki bir markayı seçiniz.");
                        Brand.listBrands();
                    }

                } while (!Brand.isValidBrand(brand));
                System.out.println("Eklemek istediğiniz telefonun depolama alanını giriniz: ");
                int memory = input.nextInt();
                System.out.println("Eklemek istediğiniz telefonun ekran boyutunu giriniz: ");
                double screenSize = input.nextDouble();
                System.out.println("Eklemek istediğiniz telefonun kamerasının kaç megapiksel olduğunu giriniz: ");
                int camera = input.nextInt();
                System.out.println("Eklemek istediğiniz telefonun bataryasının kaç mAh olduğunu giriniz: ");
                int battery = input.nextInt();
                System.out.println("Eklemek istediğiniz telefonun RAM miktarını giriniz: ");
                int ram = input.nextInt();
                System.out.println("Eklemek istediğiniz telefonun rengini giriniz: ");
                String color = input.next();
                color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();    //Renk isminin ilk harfini büyük harf yapmak için
                int discount = 10;
                int stock = 50;

                newPhones.add(new Phone(id, name, price, discount, stock, brand, memory, screenSize, ram, camera, battery, color));
                phones.addAll(newPhones);

                System.out.println("Telefon başarıyla eklendi.");
                listPhones();
            }

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("Hatalı giriş yaptınız. Lütfen doğru türde tekrar deneyiniz.");
            input.nextLine();

        }
    }


    //silme
    public static void deletePhone(ArrayList<Phone> phones) {
        Scanner input = new Scanner(System.in);
        System.out.println("Silmek istediğiniz telefonun id'sini giriniz: ");
        int id = input.nextInt();

        ArrayList<Integer> indexesToRemove = new ArrayList<>();
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getId() == id) {
                indexesToRemove.add(i);
                break;  // Telefon bulundu, döngüyü sonlandırabiliriz.
            }
        }

        if (!indexesToRemove.isEmpty()) {
            for (int i : indexesToRemove) {
                phones.remove(i);
            }
            System.out.println("Telefon başarıyla silindi.");
            listPhones();
        } else {
            System.out.println("Bu id ile kayıtlı bir telefon bulunmamaktadır.");
        }
    }

    //markaya göre listeleme

    public static void listPhonesByBrand(String brand) {
        System.out.println("İstediğiniz markayı giriniz: ");
        Scanner input = new Scanner(System.in);
        brand = input.next();
        boolean isBrandExist = false;
        for (Phone phone : phones) {
            if (phone.getBrand().equalsIgnoreCase(brand)) {
               System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d | %-9d | %-9d | %-9s |\n",
                        phone.getId(), phone.getName(), phone.getPrice(), phone.getBrand(), phone.getMemory(), phone.getScreenSize(), phone.getCamera(), phone.getBattery(), phone.getRam(), phone.getColor());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                isBrandExist = true;
            }
        }
            if (!isBrandExist) {
                System.out.println("Bu markaya ait telefon bulunmamaktadır.");
            }

        }


    // id'ye göre telefon getirme

    public static void listPhoneById(int id) {
        System.out.println("İstediğiniz telefonun id'sini giriniz: ");
        Scanner input = new Scanner(System.in);
        id = input.nextInt();

        boolean isIdExist = false;

                for (Phone p : phones) {
                    if (p.getId() == id) {
                        System.out.println("-----------------------------------------------------Telefon Listesi-----------------------------------------------------------------");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.format("| %-2d | %-30s | %-9.2f | %-9s | %-9d | %-9.1f | %-9d | %-9d | %-9d | %-9s |\n",
                                p.getId(), p.getName(), p.getPrice(), p.getBrand(), p.getMemory(), p.getScreenSize(), p.getCamera(), p.getBattery(), p.getRam(), p.getColor());
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                        isIdExist = true;
                    }
                }
                if (!isIdExist) {
                    System.out.println("Bu id ile kayıtlı bir telefon bulunmamaktadır.");
                }
            }
        }

