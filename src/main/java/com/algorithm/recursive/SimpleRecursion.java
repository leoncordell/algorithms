package com.algorithm.recursive;

public class SimpleRecursion {
    static int x=0;

    public static void main(String[] args) {
      //  doStuff();
        System.out.println(doFactorial(5));
    }

    static private  void  doStuff(){
        x++;
        if(x==5){
            return;
        }
        System.out.println("Called");

    }

    static private  int  doFactorial(int x){
        System.out.println("Factorial -" + x);
        if(x==1){
            return x;
        }
        int y = x* doFactorial(x-1);
        System.out.println("Return -" + y);
        return  y;

    }


}
