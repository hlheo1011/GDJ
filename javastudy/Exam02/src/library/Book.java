package library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor	 // new Book()
@AllArgsConstructor  // new Book(1, "어린왕자", "생텍쥐베리")
@Getter				 // getBookNo(), getTitle(), getAuthor()
@Setter 			 // setBooNo(1), setTitle("어린왕자"), setAuthor("생텍쥐베리")
@ToString
public class Book {
	
	private int bookNo;		// 1~100번까지 책 순서는 자동으로 부여
	private String title;	// 사용자 입력
	private String author;	// 사용자 입력
}
