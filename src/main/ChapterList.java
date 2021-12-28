package main;

public class ChapterList extends ObjectList {
	public ChapterList() {
		super();
	}
	
	public ChapterList(int size) {
		super(size);
	}
	
	public void append(Chapter chapter) {
		super.append(chapter);
	}
	
	public Chapter get(int index) {
		return (Chapter) super.get(index);
	}
}
