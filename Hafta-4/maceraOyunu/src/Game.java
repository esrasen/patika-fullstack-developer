import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);
    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !");
        System.out.println("Lütfen bir karakter seçiniz : ");
        player.selectChar();


        Location location = null;
        while (true) {

            player.printInfo();
                System.out.println("=====================================================");
                System.out.println("=================== Bölgeler ========================");
                System.out.println("1 - Güvenli Ev --> Canınız yenilenir.");
                System.out.println("2 - Mağaza --> Silah ve zırh satın alabilirsiniz.");
                System.out.println("3 - Mağara --> Ödül <Yemek>, Dikkatli ol!!Zombi ile savaşabilirsiniz.");
                System.out.println("4 - Orman --> Ödül <Odun>, Dikkatli ol!!Karşına vampir çıkabilir.");
                System.out.println("5 - Nehir --> Ödül <Su>, Dikkatli ol!!Karşına ayı çıkabilir.");
                System.out.println("6 - Maden --> Ödül <Para,Silah,Zırh>, Dikkatli ol!!Karşına yılan çıkabilir.");
                System.out.println("0 - Çıkış yap --> Oyunu sonlandırır.");
                System.out.println("Lütfe gitmek istediğiniz bölgeyi seçiniz :");
                int selectLoc = input.nextInt();


                switch (selectLoc){
                    case 0:
                        location = null;
                        break;
                    case 1:     //Tüm ödülleri topladığında oyunu kazanırsın.
                        if (player.getInventory().isFood() && player.getInventory().isFirewood() && player.getInventory().isWater()){
                            System.out.println("Tebrikler! Oyunu kazandınız!");
                            return;
                        }
                        location = new SafeHouse(player);
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:
                        if (player.getInventory().isFood() == false) {
                            location = new Cave(player);
                            break;
                        } else {        //Ödülü aldıktan sonra tekrar mağaraya girmesin diye
                            System.out.println("Mağaraya daha önce girdiniz ve ödülünüzü aldınız!");
                            continue;
                        }
                    case 4:
                        if (player.getInventory().isFirewood() == false) {
                            location = new Forest(player);
                            break;
                        } else {        //Ödülü aldıktan sonra tekrar ormana girmesin diye
                            System.out.println("Ormana daha önce girdiniz ve ödülünüzü aldınız!");
                            continue;
                        }
                    case 5:
                        if (player.getInventory().isWater() == false) {
                            location = new River(player);
                            break;
                        } else {        //Ödülü aldıktan sonra tekrar nehire girmesin diye
                            System.out.println("Nehire daha önce girdiniz ve ödülünüzü aldınız!");
                            continue;
                        }
                    case 6:
                        location = new Mine(player);
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir bölge seçiniz !");
                }

                if (location == null){
                    System.out.println("Oyun Bitti.Çabuk vazgeçtin !");
                    break;
                }
                if (!location.onLocation()){
                    System.out.println("Oyunu kaybettiniz !");
                    break;
                }

            }

        }

    }
