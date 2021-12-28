package main;

public class Page {
	private static int LINE_CAPACITY = 100;
	private int number;
	private String text;
	
	public Page(int number, String text) {
		this.number = number;
		this.text = text;
	}

	public int getNumber() {
		return number;
	}

	public String getText() {
		return text;
	}
	
	public static void setLineCapacity(int capacity) {
		Page.LINE_CAPACITY = capacity;
	}
	
	public String toString() {
		String s = "";
		int beginIndex = 0;
		int endIndex = LINE_CAPACITY;
		if (endIndex > text.length()) {
			endIndex = text.length();
		}
		for (int i = 0; i < (int)((text.length() + LINE_CAPACITY - 1) / LINE_CAPACITY); i++) {
			s += text.substring(beginIndex, endIndex) + "\n";
			beginIndex = endIndex;
			endIndex += LINE_CAPACITY;
			if (endIndex > text.length()) {
				endIndex = text.length();
			}
		}
		return s + "\t\t\t\t" + number + "\n\n";
	}
}
