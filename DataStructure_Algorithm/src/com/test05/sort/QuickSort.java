package com.test05.sort;

public class QuickSort {

	public static void quickSort(int[] a, int left, int right) {
		int lc = left;
		int rc = right;
		int x = a[(lc+rc)/2]; //피벗(배열 가운데 데이터)
		
		do {
			while(a[lc]<x) {lc++;}
			while(a[rc]>x) {rc--;}
			
			if(lc<=rc) {
				int tmp = a[lc];
				a[lc] = a[rc];
				a[rc] = tmp;
				lc++;
				rc--;
			}
			
		}while(lc<=rc);
		
		if(left<rc) {
			quickSort(a, left, rc);
		}
		if(lc<right) {
			quickSort(a, lc, right);
		}
	}

	public static void main(String[] args) {
		int[] arr = {5,8,4,2,6,1,3,9,7};
		quickSort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
