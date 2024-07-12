import java.util.Scanner;

public class SelectStudent {

    /*
    Proje: Spor kursu icin secilecek ogrencileri belirleyelim.

    Kurs gereklilikleri:
        Erkekler: boy: 1.60 ve ustu
                  kilo: 70-90 kg
        Kadinlar: boy : 1.50 ve ustu
                  kilo: 50-70 kg

    Kullanicidan ogrenci sayisi ve her bir ogrenci icin isim,
    cinsiyet, kilo ve boy girmesini isteyiniz

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Merhaba, lutfen formu dolduruuz");
        System.out.print("Ogrenci sayisini giriniz : ");
        int numberStudent = scan.nextInt();

        String[] students = new String[numberStudent];
        String[] gender = new String[numberStudent];
        double[] height = new double[numberStudent];
        double[] weight = new double[numberStudent];
        boolean isSuccess = true;

        do {
            isSuccess = true;//hatali giriste false cekti ve surekli basa donuyor. islemi tamamlamak icin true yaptik
            for (int i = 0; i < numberStudent; i++) {
                System.out.print("Isim : ");
                students[i] = scan.next();

                System.out.print("Cinsiyet : ");
                String gen = scan.next().toUpperCase().substring(0, 1);
                if (gen.equals("K") || gen.equals("E")) {
                    gender[i] = gen;
                } else {
                    System.out.println("Hatali giris");
                    isSuccess = false;
                    break;
                }
                System.out.print("Boy : ");
                height[i] = scan.nextDouble();

                System.out.print("Kilo : ");
                weight[i] = scan.nextDouble();
            }
        } while (!isSuccess);

        System.out.println();
        int counter=0;
        System.out.println("****Kursa secilen ogrenciler****");

        for (int i = 0; i < numberStudent; i++) {
            if (gender[i].equals("K") && weight[i] >= 50 && height[i] <= 70 && height[i] >= 1.50) {
                System.out.println("Isim : " + students[i] + ", Cinsiyet : "
                        + gender[i] + ", Boy : " + height[i] + ", Kilo :" + weight[i]);
            } else if (gender[i].equals("E") && weight[i] >= 70 && height[i] <= 90 && height[i] >= 1.60) {
                System.out.println("Isim : " + students[i] + ", Cinsiyet : "
                        + gender[i] + ", Boy : " + height[i] + ", Kilo :" + weight[i]);
                counter++;
            }
        }
        //kursa secilen ogrenci yoksa
        if (counter ==0){
            System.out.println("Maalesef kurs gereksinimlerini saglayan ogrenci bulunamadi");
        }

    }


}
