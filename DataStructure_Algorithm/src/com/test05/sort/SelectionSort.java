package com.test05.sort;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {6,4,8,3,1,10,7};
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		System.out.println("오름차순 정렬-선택정렬");
		selectionSort(arr,arr.length);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void selectionSort(int[] a, int n) {
		for(int i=0; i<n-1; i++) {
			int min=i;
			for(int j=i+1; j<n; j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			int tmp=a[i];
			a[i]=a[min];
			a[min]=tmp;
		}
	}
}
