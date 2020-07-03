package com.algorithm.dynamic;

public class MinAbsSum {

    public static void main(String[] args) {
        int[] A = {1,5,1,-2};

        System.out.println(solution(A));

    }

    static public int solution(int[] A){

        int sum =0 ;
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];

        }
        int[] dp = new int[sum+1];
        for (int k = 0; k < sum; k++) {
            dp[k] = -1;
        }
        dp[0] =1;
        for (int k = 0; k < A.length; k++) {
            for (int l = sum;l > -1 ; l--){
                if(dp[l]==1){
                    dp[l + A[k]]=1;
                }
            }
        }

        int result = sum;
        for (int r = dp.length/2  ; r > -1; r--) {
            if(dp[r] ==1){
                result= Math.abs(sum - 2*r);
                break;
            }
        }

        return  result;
    }



}
