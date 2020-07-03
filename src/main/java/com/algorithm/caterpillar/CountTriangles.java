package com.algorithm.caterpillar;

import java.util.Arrays;

public class CountTriangles {

    public static void main(String[] args) {
        int[] A = {10,2,5,1,8,12};
        System.out.println(solution(A));
    }

    static  public int solution(int[] A) {
        // write your code in Java SE 8


        Arrays.sort(A);
        //  System.out.println(Arrays.toString(A));

        int  count=0;
        int third = 0;

        for(int i = 0 ; i< A.length -2 ; i++){

            third = i + 2;
            for(int j = i +1 ; j<A.length -1 ;j++){
                while(third < A.length   && A[third] <A[i] + A[j]   ){
                    third++;
                }
                count = count + third-j -1 ;
                System.out.println(count);
            }
        }

        return  count;

    }

}
