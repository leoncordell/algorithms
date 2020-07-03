package com.algorithm.recursive;

public class LengthString {

    public static void main(String[] args) {
        String S  = "Awhatsop";

        System.out.println(lengthS(S));

    }

    static private  int  lengthS(String s){
        if(s.equals("")){
            return 0;
        }
        return  lengthS(s.substring(1)) + 1;
    }


}
