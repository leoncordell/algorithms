package com.algorithm.recursive;

public class FibonacciRecursion {

    public static void main(String[] args) {
        int count=15;

     //   printFibo(count);//n-2 because 2 numbers are already printed
     //   printFiboW(15);

        System.out.println("Recursive");
        System.out.print(n1 + " " +  n2 + " ");
        printFiboR(13);

    }

    private static void printFibo(int count) {
        int n1 =0; int n2 = 1; int n3 = 0;
        System.out.print(n1 + " ");
        System.out.print(n2 + " ");
        for(int i = 2; i<count; i++){
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 =n3;
        }
        System.out.println();
    }


    private static void printFiboW(int count) {
        int prev =0; int next = 1; int current =0; int i = 0;
        System.out.print(prev + " ");
        System.out.print(next + " ");
        //for(int i = 2; i<count; i++){
        while(i <= count){
            current = prev + next;
            System.out.print(current + " ");
            prev = next;
            next = current;
            i++;
        }
        System.out.println();

    }

    // Nth fib

    static int n1=0;
    static int n2 =1;
    static int n3 =0;

    static private  void printFiboR(int count) {
        if(count > 0 ){
            n3 = n2 + n1;
            n1 = n2;
            n2 = n3;
            System.out.print(n3 + " ");
            printFiboR(count-1);
        }

    }

}


