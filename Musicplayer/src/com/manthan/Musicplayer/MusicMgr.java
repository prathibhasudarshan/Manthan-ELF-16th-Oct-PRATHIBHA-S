package com.manthan.Musicplayer;



public class MusicMgr {
	
	
	private  MusicMgr()
	{
		
	}

	
	public static MusicPlayerDao getDaoIns()
	{
		return new MusicPlayerImpl();
		
	}
}
