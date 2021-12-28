package main;

public class BookList extends ObjectList {
	public BookList() {
		super();
	}
	
	public BookList(int size) {
		super(size);
	}
	
	public void append(Book book) {
		super.append(book);
	}
	
	public Book get(int index) {
		return (Book) super.get(index);
	}
}
