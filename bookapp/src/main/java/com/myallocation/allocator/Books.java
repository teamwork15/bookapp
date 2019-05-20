package com.myallocation.allocator;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="allbooks")
public class Books {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="book_id")
private int bookId;

@Column(name="book_title")

private String bookTitle;

@Column(name="book_author")

private String bookAuthor;

@Column(name="book_genre")

private String bookGenre;

@Lob
private byte[] file;


public byte[] getFile() {
	return file;
}
public void setFile(byte[] file) {
	this.file = file;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public String getBookTitle() {
	return bookTitle;
}
public void setBookTitle(String bookTitle) {
	this.bookTitle = bookTitle;
}
public String getBookAuthor() {
	return bookAuthor;
}
public void setBookAuthor(String bookAuthor) {
	this.bookAuthor = bookAuthor;
}
public String getBookGenre() {
	return bookGenre;
}
public void setBookGenre(String bookGenre) {
	this.bookGenre = bookGenre;
}



	
}
