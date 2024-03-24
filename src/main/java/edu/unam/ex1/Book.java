package edu.unam.ex1;

public class Book {

	@Printable(upperCase = false)
	String title;
	@Printable(upperCase = true)
	String author;

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
