package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.println("Welcome to my Library!");
		while (choice != 4) {
			System.out.println("Main Menu:");
			System.out.println("(1) Pick a book to read\n"
					+ "(2) Change page capacity\n"
					+ "(3) Change line capacity\n"
					+ "(4) Quit");
			choice = input.nextInt();
			if (choice == 1) {
				BookList libraryBooks = LibraryGenerator.generate();
				while (choice != libraryBooks.getCount()+1) {
					System.out.println("Book Menu:");
			        for (int i = 1; i <= libraryBooks.getCount(); i++) {
			        	System.out.println("(" + i + ") " + libraryBooks.get(i-1).getTitle());
			        }
			        System.out.println("(" + (libraryBooks.getCount()+1) + ") Back to Main Menu");
			        choice = input.nextInt();
			        if (choice >= 1 && choice <= libraryBooks.getCount()) {
			        	System.out.println(libraryBooks.get(choice-1));
			        	System.out.println("Note: Give any input to go back");
			        	input.next();
			        } else if (choice != libraryBooks.getCount()+1) {
			        	System.out.println("Wrong input! Try again.");
			        }
		        }
			} else if (choice == 2) {
				//Ask for new value and call setter
				System.out.println("Enter the new page capacity:");
				LibraryGenerator.setPageCapacity(input.nextInt());
			} else if (choice == 3) {
				//Ask for new value and call setter
				System.out.println("Enter the new line capacity:");
				Page.setLineCapacity(input.nextInt());
			} else {
				//Tell user they gave wrong input
			}
		}
		input.close();
	}
}
