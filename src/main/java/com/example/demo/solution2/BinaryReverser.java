package com.example.demo.solution2;

public class BinaryReverser {

    public static void main(final String[] args) {
        System.out.print(reverse("47"));
    }

    public static String reverse(final String str) {
        final String binary = String.format("%8s", Integer.toBinaryString(Integer.parseInt(str))).replace(' ', '0');
        final Integer revBinary =  Integer.parseInt(new StringBuilder(binary).reverse().toString(), 2);
        return revBinary.toString();
    }

}
