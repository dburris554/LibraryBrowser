package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class LibraryGenerator {
	private static int PAGE_CAPACITY = 500;
	
	public static BookList generate() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("library.lib"));
		BookList bookList = new BookList();
		while (scan.hasNextLine()) {
			String title = scan.nextLine();
			String author = scan.nextLine();
			ChapterList chapters = generateChapters(scan);
			bookList.append(new Book(title, author, chapters));
		}
		return bookList;
	}
	
	public static void setPageCapacity(int capacity) {
		LibraryGenerator.PAGE_CAPACITY = capacity;
	}

	private static ChapterList generateChapters(Scanner scan) {
		ChapterList chapters = new ChapterList();
		int chapterCounter = 1;
		while (scan.hasNextLine()) {
			String lineToCheck = scan.nextLine();
			if (!lineToCheck.isEmpty()) {
				String chapterName = lineToCheck;
				String chapterText = scan.nextLine();
				//Break down chapter text into pages
				PageList pages = generatePages(chapterText);
				chapters.append(new Chapter(chapterName, chapterCounter, pages));
				chapterCounter++;
			} else {
				break;
			}
		}
		return chapters;
	}

	private static PageList generatePages(String chapterText) {
		PageList pageList = new PageList();
		int beginIndex = 0;
		int endIndex = PAGE_CAPACITY;
		if (endIndex > chapterText.length()) {
			endIndex = chapterText.length();
		}
		//Round up to nearest whole number of pages
		for (int i = 0; i < (int)((chapterText.length() + PAGE_CAPACITY - 1) / PAGE_CAPACITY); i++) {
			String pageText = chapterText.substring(beginIndex, endIndex);
			pageList.append(new Page(i + 1, pageText));
			beginIndex = endIndex;
			endIndex += PAGE_CAPACITY;
			//Partial last page check
			if (endIndex > chapterText.length()) {
				endIndex = chapterText.length();
			}
		}
		return pageList;
	}
}
