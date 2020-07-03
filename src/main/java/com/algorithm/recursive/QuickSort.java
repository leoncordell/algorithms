package com.algorithm.recursive;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] A = {1,2,3,4,56,7,23};

        quickSort(A,0,A.length-1);
        System.out.println(Arrays.toString(A));

    }

    static void quickSort(int[] A,int low,int high){
        if(low<high) {
            int pivot = partition(A, low, high);
            quickSort(A,low,pivot-1);
            quickSort(A,pivot+1,high);

        }

    }

    static private int partition(int[] A,int low,int high){
        int pivot = A[high];
        int j = low-1;
        for (int i = low; i < high; i++) {
            if(A[i] < pivot){
                j++;
                int  tmp = A[j];
                A[j]=A[i];
                A[i]=tmp;

            }
        }
        // Swap  pivot
        int tmp = A[j+1];
        A[j+1] = pivot;
        A[high] = tmp;
        return j+1;
    }


}
