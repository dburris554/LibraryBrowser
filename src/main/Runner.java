package main;

import java.io.FileNotFoundException;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		BookList library = LibraryGenerator.generate();
		System.out.println(library);
	}
}
