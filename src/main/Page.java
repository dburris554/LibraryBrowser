package main;

public class Page {
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
	
	public String toString() {
		int lineCapacity = 100;
		String s = "";
		int beginIndex = 0;
		int endIndex = lineCapacity;
		if (endIndex > text.length()) {
			endIndex = text.length();
		}
		for (int i = 0; i < (int)((text.length() + lineCapacity - 1) / lineCapacity); i++) {
			s += text.substring(beginIndex, endIndex) + "\n";
			beginIndex = endIndex;
			endIndex += lineCapacity;
			if (endIndex > text.length()) {
				endIndex = text.length();
			}
		}
		return s + "\t\t\t\t" + number + "\n\n";
	}
}
