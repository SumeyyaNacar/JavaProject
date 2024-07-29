public class Bilet {

    public int distance;
    public int typeNo;
    public double price;
    public int seatNo;

    public void printBilet(Bus bus) {//obje uzerinden cagiracagiz, static yapmaya gerek yok
        System.out.println("Toplam tutar: " + price);
        System.out.println("---Bilet Detay---");
        System.out.println("Otobus plakasi : "+ bus.numberPlate);
        System.out.println("Mesafe :" + distance);
        System.out.println("Yolculuk tipi : " + (typeNo == 1 ? "Tek Yon" : "Cift Yon"));
        System.out.println("Koltuk No : " + seatNo);
        System.out.println("Keyifli Yolculuklar ");
    }


}
