package com.manthan.Musicplayer;



public interface MusicPlayerDao {
	public MusicPlayerInfoBean searchsongs(int songid) ;
	public boolean addsongs(MusicPlayerInfoBean infoBean);
	
	
	public boolean Update(int songid,String songtitle );
		
	public boolean delete(int songid);

}
