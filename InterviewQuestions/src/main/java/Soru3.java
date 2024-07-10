public class Soru3 {
    public static void main(String[] args) {
        /*
        3. Write a Java program to check if a vowel is present in a string.
        */

        System.out.println(check("Ali Can"));

    }
    public static  boolean check(String s){
        return  s.toLowerCase().matches(".*[aeiou]*.");
    }
}
