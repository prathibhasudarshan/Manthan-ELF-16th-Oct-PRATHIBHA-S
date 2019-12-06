package com.manthan.javaclass;

import java.util.Scanner;

public class Hotel_Billing_Application_Main {

	public static void main(String[] args) {
		System.out.println("HOTEL APPLICATION");
		int choice;
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 to show all food items");
		System.out.println("Press 2 to take order from customers");
		System.out.println("Press 3 to operate on food items");
		System.out.println("Press 4 to total bill of the day");
		System.out.println("enter your choice");
		choice=sc.nextInt();
		String input = null ;
		int input1 = 0;
		
		switch(choice)
		{
		case 1:System.out.println("Showing all the items");
			DisplayingItems d1=new DisplayingItems();
			d1.showallitems();
			break;


		case 2:System.out.println("Taking the order");
				System.out.println("enter your choice for adding still items or exiting");
				System.out.println("press 1 for adding ");
				System.out.println("press 0 for exit");
				input1=sc.nextInt();
				for(int i=0;i<input1;i++)
				{
					if(input1==1)
					{
						AddItem a=new AddItem();
						a.add();
						continue;
						
					}
					else 
					{
						System.out.println("Generating the bill");
						 BillingOfItems b=new BillingOfItems();
						 b.bill();
						 break;	
					}	
				}
				
		case 3:System.out.println("enter your choice");
				System.out.println("Press A to add food item");
				System.out.println("Press B to remove food item");
				System.out.println("Press C to modify food item");
				input=sc.next();
				switch(input)
				{
				case "A":System.out.println("adding the items");
					AddItem a1=new AddItem();
					a1.add();
					break;
				case "B":System.out.println("removing  the items");
					DeletingItem d=new DeletingItem();
					d.delete();
					break;
				case "C":System.out.println("updating the items");
					ModifyItem m=new ModifyItem();
					m.update();
					break;
				}
				
		
		case 4:System.out.println("Generating the bill");
				BillingOfItems b1=new BillingOfItems();
				b1.bill();
				break;


		}
	}
}




