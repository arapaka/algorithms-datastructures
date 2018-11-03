package misc;


public class Misc {

    public static void printInt(int number, final int base) {
        String conversion = "0123456789ABCDEF";
        char digit = (char) (number % base);
        number = number / base;
        if (number != 0) {
            printInt(number, base);
        }
        System.out.print("" + conversion.charAt(digit));
    }

    public static void main(String[] args) {
        printInt(30, 5);
    }
}
