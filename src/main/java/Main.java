import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //TODO: Input/Output
    //[Ⅰ, Ⅱ, Ⅲ, Ⅳ, Ⅴ, Ⅵ, Ⅶ, Ⅷ, Ⅸ, Ⅹ, Ⅼ, Ⅽ]
    static String[] rumbers = {"\u2160", "\u2161", "\u2162", "\u2163", "\u2164", "\u2165", "\u2166", "\u2167", "\u2168", "\u2169", "\u216c", "\u216d"};
    static int[] numbarray = new int[0];

    public static void main(String[] args) {
        int input = input();

        clearnumbarray();
        if (!check_input(input)) System.exit(1);
        int rest = whichfirstnumber(input);
        rest = teenth(rest);
        addrest(rest);
        String output = convert();
        System.out.println("Output: " + output);
        System.out.println("For Numbers Check: https://www.cuemath.com/numbers/roman-numerals-1-to-100/");
    }
    public static int input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Input: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Please Enter a number.");
            System.exit(2);
        }
        return scanner.nextInt();

    }
    //TODO:Change to Switch-Case
    public static int whichfirstnumber(int input) {
        if ((input % 50) >= 40) {
            return addFirstNumber(input);
        } else if (input < 40) {
            return input;
        } else if (input == 100) {
            addtoarray(100);
            return 0;
        } else {
            addtoarray(50);
            return input - 50;
        }
    }
    /*public static int whichfirstnumber(int input) {
        boolean state = true;
        switch (true){
            case 100 == input:
                addtoarray(100);
                return 0;
            case 50 == input:
                addtoarray(50);
                return input - 50;
            case ((input % 50) >= 40 && (input % 50) <= 49):
                return addFirstNumber(input);
            default:
                return input;
        }
    }*/
    public static void clearnumbarray() {
        numbarray = new int[0];
    }
    public static boolean check_input(int input) {
        return (input >= 1 && input <= 100);
    }
    public static int addFirstNumber(int number) {
        addtoarray(10);
        if (number < 50) {
            addtoarray(50);
            return number % 40;
        } else {
            addtoarray(100);
            return number % 90;
        }
    }
    public static void addtoarray(int toadd) {
        numbarray = Arrays.copyOf(numbarray, numbarray.length + 1);
        numbarray[numbarray.length - 1] = toadd;
    }
    public static int teenth(int input) {
        while (input >= 10) {
            addtoarray(10);
            input -= 10;
        }
        return input;
    }
    public static void addrest(int input) {
        if (input != 0) addtoarray(input);
    }
    public static String convert() {
        int length = numbarray.length;
        String[] romanarray = new String[length];
        for (int i = 0; i < length; i++) {
            if (numbarray[i] == 50) {
                romanarray[i] = rumbers[11 - 1];
            } else if (numbarray[i] == 100) {
                romanarray[i] = rumbers[12 - 1];
            } else {
                romanarray[i] = rumbers[numbarray[i] - 1];
            }
        }
        String output = Arrays.toString(romanarray);
        output = output.replace("[", "");
        output = output.replace("]", "");
        output = output.replace(",", "");
        output = output.replace(" ", "");
        output = output.trim();
        return output;
    }
}