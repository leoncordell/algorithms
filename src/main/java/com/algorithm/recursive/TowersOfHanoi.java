package com.algorithm.recursive;

public class TowersOfHanoi {




    public static void main(String[] args) {
        int N = 4;

        resolve(4,'A','B','C');


    }

    private static void resolve(int N, char from,
                                char to, char aux){
        if(N==1){
            System.out.println("Move from:" + from + " Move to ");
        }

    }





}
