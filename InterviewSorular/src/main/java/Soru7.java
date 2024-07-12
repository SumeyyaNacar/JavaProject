public class Soru7 {
    public static void main(String[] args) {
        //7. How do you check whether a string is a palindrome in Java?

        String s ="121";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
       int length = s.length();
       boolean result = true;
        for (int i = 0; i < length/2; i++) {
            if (s.charAt(i)!= s.charAt(length-i-1)){
                result = false;
            }

        }return result;

    }
}
