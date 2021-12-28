package main;

public abstract class ObjectList {
	public static final int DEFAULT_SIZE = 10;
	private Object[] data;
	
	public ObjectList() {
		data = new Object[DEFAULT_SIZE];
	}
	
	public ObjectList(int size) {
		data = new Object[size];
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public int getCount() {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null) {
				return i;
			}
		}
		return data.length;
	}
	
	public void append(Object obj) {
		int count = getCount();
		int capacity = data.length;
		if (count >= capacity / 2) {
			Object[] temp = data;
			data = new Object[data.length * 2];
			for (int i = 0; i < count; i++) {
				data[i] = temp[i];
			}
		}
		data[count] = obj;
	}
	
	public Object get(int index) {
		return data[index];
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < getCount(); i++) {
			s += data[i].toString();
		}
		
		return s;
	}
}
