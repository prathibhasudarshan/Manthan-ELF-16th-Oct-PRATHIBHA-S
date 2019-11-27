package com.manthan.Thread;

public class TestA {

	public static void main(String[] args) {
		System.out.println("main started");
		Pen p=new Pen();
		Thread t=new Thread(p);
		t.start(); 
		System.out.println("ended");
	}

}
