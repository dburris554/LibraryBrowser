package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class LibraryGenerator {
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
		int pageCapacity = 500;
		int beginIndex = 0;
		int endIndex = pageCapacity;
		if (endIndex > chapterText.length()) {
			endIndex = chapterText.length();
		}
		//Round up to nearest whole number of pages
		for (int i = 0; i < (int)((chapterText.length() + pageCapacity - 1) / pageCapacity); i++) {
			String pageText = chapterText.substring(beginIndex, endIndex);
			pageList.append(new Page(i + 1, pageText));
			beginIndex = endIndex;
			endIndex += pageCapacity;
			//Partial last page check
			if (endIndex > chapterText.length()) {
				endIndex = chapterText.length();
			}
		}
		return pageList;
	}
}
