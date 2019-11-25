package com.manthan.Thread;

public class Test {

	public static void main(String[] args) {
		Pvr r=new Pvr();
		User u=new User(r);
		u.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}


}
