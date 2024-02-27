package co.edu.escuelaing.sparkdockerdemolive;

public class ApplicationUtilService {
    public static String getCos(String number){
        String numberSin = String.valueOf(Math.cos(Double.parseDouble(number)));
        return numberSin;
    }
    public static String getSin(String number){
        String numberCos = String.valueOf(Math.sin(Double.parseDouble(number)));
        return numberCos;
    }
    public static String isPalindrome(String word) {
        word = word.toLowerCase();
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return "No es Palindromo";
            }
        }

        return "Es Palindromo";
    }

    public static String getMagnitude(String str1, String str2){
        String ansMagnitude = String.valueOf(Math.sqrt(Math.pow(2, Double.parseDouble(str1)) + Math.pow(2, Double.parseDouble(str2))));
        return ansMagnitude;
    }
}
