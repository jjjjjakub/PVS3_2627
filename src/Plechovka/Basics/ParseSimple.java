package Plechovka.Basics;

import java.util.Arrays;

public class ParseSimple {
    public static void main(String[] args) {
        String data = "This is number:5";

        data.substring(data.indexOf(':')); //rozdělit pomocí substring
        String[] tokens = data.split(":");
        int paresedNumber = Integer.parseInt(tokens[1]);
        System.out.println(paresedNumber);
    }
}
