package main;

public class PageList extends ObjectList {
	public PageList() {
		super();
	}
	
	public PageList(int size) {
		super(size);
	}
	
	public void append(Page page) {
		super.append(page);
	}
	
	public Page get(int index) {
		 return (Page) super.get(index);
	}
}
