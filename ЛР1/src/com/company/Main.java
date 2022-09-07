package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = new char[0];
        boolean flag = true;
        int i;
        StringBuilder binary = new StringBuilder();
        System.out.println("Введите число в двоичном формате (101):");
        while (flag) {
            String num = in.nextLine();
            chars = num.toCharArray();
            i = 0;
            while (i < chars.length) {
                if (chars[i] == '0' || chars[i] == '1') {
                    binary.append(chars[i]);
                    i++;
                    if (i == chars.length) {
                        flag = false;
                        break;
                    }
                } else {
                    binary.delete(0, binary.length());
                    System.out.println("Вы ввели число не в двоичном формате, введите число еще раз (101):");
                    break;
                }
            }
        }
        in.close();
        System.out.println(Integer.toOctalString(Integer.parseInt(binary.toString(), 2)));
        System.out.println(octal(decimal(chars)));
        System.out.println(Octal(chars));
    }

    public static int decimal(char[] chars) {
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                result += Math.pow(2, chars.length - 1 - i);
            }
        }
        return result;
    }

    public static String octal(int decimal) {
        String result = "";
        while (decimal > 0) {
            result = (decimal % 8) + result;
            decimal /= 8;
        }
        return result;
    }

    public static String Octal(char[] chars) {
        String result = "";
        String binary = "";
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("000", "0");
        mapa.put("1", "1");
        mapa.put("01", "1");
        mapa.put("001", "1");
        mapa.put("10", "2");
        mapa.put("010", "2");
        mapa.put("11", "3");
        mapa.put("011", "3");
        mapa.put("100", "4");
        mapa.put("101", "5");
        mapa.put("110", "6");
        mapa.put("111", "7");
        for (int i = chars.length - 1; i >= 0; i--) {
            binary = chars[i] + binary;
            if ((chars.length - i) % 3 == 0 || i == 0) {
                result = mapa.get(binary) + result;
                binary = "";
            }
        }
        return result;
    }

}
