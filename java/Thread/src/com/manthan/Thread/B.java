package com.manthan.Thread;

public class B {

	public static void main(String[] args) {
		System.out.println("main started");
		MyTask m=new MyTask();
		m.start();
		System.out.println("main ended");
	}

}
