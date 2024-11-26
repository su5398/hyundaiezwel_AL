package com.test01.recursive.hanoi;

public class Hanoi {
	public static void main(String[] args) {
		new Hanoi().hanoi(3, 1, 3);
	}
	
	//no:원판의 개수, x: 시작기둥, y: 목표기둥
	//no개의 원판을 x에서 y로 이동
	public void hanoi(int no, int x, int y) {
		if(no>1) {
			hanoi(no-1, x, 6-x-y);
		}
		System.out.println("원판"+no+"을 "+x+"번 기둥에서 "+y+"번 기둥으로 옮김.");
		if(no>1) {
			hanoi(no-1, 6-x-y,y);
		}
	}
}
