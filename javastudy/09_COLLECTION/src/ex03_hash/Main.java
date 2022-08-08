package ex03_hash;

public class Main {

	public static void main(String[] args) {		
		
		Book book1 = new Book();
		System.out.println(book1.hashCode());
		
		Book book2 = new Book();
		System.out.println(book2.hashCode());
	
	}

}
