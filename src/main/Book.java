package main;

public class Book {
	private String title;
	private String author;
	private ChapterList chapters;
	
	public Book(String title, String author, ChapterList chapters) {
		this.title = title;
		this.author = author;
		this.chapters = chapters;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public ChapterList getChapters() {
		return chapters;
	}
	
	public String toString() {
		return title + "\n" 
				+ "Written By " + author + "\n"
				+ chapters.toString();
	}
}
