package com.training.service;
import com.training.exception.EmailException;
import com.training.exception.PhoneNoException;
import com.training.modal.*;
import java.util.*;
public class TestPhoneBook {

	public static void main(String[] args) {
		System.out.println("--------Phone Book--------");
		System.out.println("Enter 1 for adding contact");
		System.out.println("Enter 2 for searching contacts");
		System.out.println("Enter 3 for updating contact");
		System.out.println("Enter 4 for deleting contact");
		System.out.println("Enter 5 for displaying all contacts");
		System.out.println("Enter any key to exit");
		Set<PhoneBook> s = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter name of the contact : ");
				String name = sc.next();
				sc.nextLine();
				
				System.out.println("Enter Phone Number : ");
				String phNo = sc.next();
				
				System.out.println("Enter Email Id : ");
				String email = sc.next();
				
				System.out.println("Enter Address : ");
				String addr = sc.next();
				sc.nextLine();
				try {
					PhoneBook p = new PhoneBook(name, phNo, email, addr);
					s.add(p);
					System.out.println("Contact added");
				}
				catch(PhoneNoException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				catch(EmailException e)
				{
					System.out.println("Error : "+e.getMessage());
				}
				
			    break;
			case 2:
				System.out.println("Enter name to search contact : ");
				String searchName = sc.next();
				int searchFlag=0;
				for (PhoneBook p1 : s) {
					if(p1.getContactName().equals(searchName)) {
						searchFlag=1;
						System.out.println(p1);
					}
				}
				if(searchFlag==0)
					System.out.println("Name not Found!!");
				break;
			case 3:
				System.out.println("Enter name to update contact : ");
				String upName = sc.next();
				int updateFlag=0;
				
				for (PhoneBook up : s) {
					if(up.getContactName().equals(upName))
					{
						updateFlag=1;
						System.out.println("Enter 1 to update name");
						System.out.println("Enter 2 to update Phone number");
						System.out.println("Enter 3 to update email");
						System.out.println("Enter 4 to update Address");
						int opt = sc.nextInt();
						if(opt == 1)
						{
							System.out.println("Enter the name to be updated");
							String updatedName = sc.next();
							up.setContactName(updatedName);
							System.out.println("Name Changed!!");
						}
						else if(opt == 2)
						{
							System.out.println("Enter the phone number to be updated");
							String updPhNo = sc.next();
							try{
								up.setPhoneNo(updPhNo);
								System.out.println("Phone number Changed!!");
							}
							catch(PhoneNoException e) {
								System.out.println("Error : "+e.getMessage());
							}
							
						}
						else if(opt == 3)
						{
							System.out.println("Enter the email to be updated");
							String updEmail = sc.next();
							try {
								up.setEmail(updEmail);
								System.out.println("Email Changed!!");
							}
							catch(EmailException e) {
								System.out.println("Error : "+e.getMessage());
							}
						}
						else if(opt == 4)
						{
							System.out.println("Enter the address to be updated");
							String updAddr = sc.next();
							up.setAddress(updAddr);
							System.out.println("Address Changed!!");
						}
						else
							System.out.println("Invalid choice ");
					}
					
				}
				if(updateFlag==0)
					System.out.println("Name not found!!");
				break;
			case 4:
				System.out.println("Enter name to delete contact :");
				String delName = sc.next();
				int delFlag=0;
				for (PhoneBook de : s) {
					if(de.getContactName().equals(delName)) {
						s.remove(de);
						delFlag = 1;
						System.out.println("Contact Deleted!!");
						break;
					}
				}
				if(delFlag==0) 
					System.out.println("Name not Found!!");
				break;
			case 5:
				for (PhoneBook dis:s) {
					System.out.println(dis);
				}
			default:
				loop = false;
				
			}
		}
		sc.close();
	}

}

