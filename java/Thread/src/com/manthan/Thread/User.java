package com.manthan.Thread;

public class User extends Thread {
	Pvr p;

	public User(Pvr ref) {
		this.p = ref;
	}
	
	@Override
	public void run() {
		p.confirm();
	}
}
