package com.test05.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr = {6,4,3,7,1,9,8};
		bubble(arr, arr.length);
		
		System.out.println("오름차순 정렬");
		for(int i=0; i<arr.length; i++) {
			System.out.println("i : "+arr[i]);
		}
	}
	
	public static void bubble(int[] a, int n) {
		for(int i=0; i<n-1; i++) {
			int cnt = 0;
			for(int j=n-1; j>i; j--) {
				if(a[j-1]>a[j]) {
					int tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
					cnt++;
				}
			}
			if(cnt==0) {break;}
		}
	}
}
