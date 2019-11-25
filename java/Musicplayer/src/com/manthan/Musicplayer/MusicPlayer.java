package com.manthan.Musicplayer;

import java.util.Scanner;





public class MusicPlayer {

	public static void main(String[] args) {

		MusicPlayerDao dao=new MusicPlayerImpl();
		AddSongNew ad=new AddSongNew();
		SearchNewSongs s=new SearchNewSongs();


		int choice;
		Scanner sc=new Scanner(System.in);
		System.out.println(" Press 1 for Play a song");
		System.out.println(" Press 2 for Search a song");
		System.out.println(" Press 3 for Show all songs");
		System.out.println(" Press 4 for Operate on songs");
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		int input;
		int input1;

		
			switch(choice)
			{
			case 1: System.out.println("enter your choice");
			System.out.println(" Press 1 for all songs");
			System.out.println(" Press 2 for all songs randomly");
			System.out.println(" Press 3 for particular songs");
			input=sc.nextInt();
			switch(input)
			{
			case 1:s.allsongs();


			break;
			case 2:s.allsongs();


			break;
			case 3:System.out.println("Search");
			int songid=sc.nextInt();
			dao.searchsongs(songid);

			break;
			}

			case 2: System.out.println("Search");
			System.out.println("enter the id");
			int songid=sc.nextInt();
			dao.searchsongs(songid);

			break;

			case 3:System.out.println("show all songs");
			s.allsongs();
			break;
			case 4:System.out.println("operate on songs and select your choice");
			System.out.println(" enter your choice");
			System.out.println(" Press 1 for add");
			System.out.println(" Press 2 for edit");
			System.out.println(" Press 3 for delete");
			
			input1=sc.nextInt();
			switch(input1)
			{
			case 1:
			ad.add();
			
			break;
			case 2: 
			UpdateSong u=new UpdateSong();
			u.update();
			break;

			case 3: 
			DeleteSong d=new DeleteSong();
			d.delete();

			break;
			}



			}
		}
		
		
	}


