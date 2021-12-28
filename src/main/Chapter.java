package main;

public class Chapter {
	private String title;
	private int number;
	private PageList pages;
	
	public Chapter(String title, int number, PageList pages) {
		this.title = title;
		this.number = number;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public int getNumber() {
		return number;
	}

	public PageList getPages() {
		return pages;
	}
	
	public String toString() {
		return "Chapter " + number + ": " + title + "\n" + pages.toString();
	}
}
