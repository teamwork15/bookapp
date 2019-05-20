package com.myallocation.allocator;

import java.sql.Blob;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClass {

@Autowired
BooksRepo brepo;

@Autowired
UsersRepo urepo;

@Autowired
FavouritesRepo frepo;

@Autowired
StoreRepo srepo;

public List<Books> getAll(){
return brepo.findAll();	
}
public String addBook(Books book) {
	brepo.save(book);
	return "book saved succesfully!";
}
public String updateBook(Books book) {
	String message="";
brepo.save(book);
	if(brepo.save(book)!=null) {
		message="record updated successfully!";
	}
	else {
		message="record updated to insert!";
	}
	return message;
}
public Books getBook(String bookTitle) {
	
	return brepo.findByBookTitle(bookTitle);
}
public String deleteBook(String bookTitle) {
	String message="";
int q=brepo.deleteByTitle(bookTitle);
if(q>0) {
	message="deletion successful!";
}
else {
	message="failed to delete";
}
return message;
}
public String addUser(Users user) {
	urepo.save(user);
	String message="";	
	
	if(urepo.save(user)!=null) {
		message="record updated successfully!";
	}
	else {
		message="record updated to insert!";
	}
	return message;
}
public Users loginUser(String userName,String userPassword) {
return urepo.login(userName,userPassword);
}
public String addFavourite(Favourites favourite) {
	frepo.save(favourite);
	String message="";	
	
	if(frepo.save(favourite)!=null) {
		message="favourite added successfully!";
	}
	else {
		message="favourite not added!";
	}
	return message;
}
public String addStore(Storekeeper store) {
	srepo.save(store);
String message="";	
	
	if(srepo.save(store)!=null) {
		message="keeper added successfully!";
	}
	else {
		message="keeper not added!";
	}
	return message;
}
public Storekeeper login(String storeName,String storePassword) {
	return srepo.storeLogin(storeName, storePassword);
}
public List<Favourites> getFavourites(int userId) {
	return frepo.findAllFav(userId);
	
}

public Blob getBlob(String bookTitle) {
	
	return brepo.getBook(bookTitle);
}
}
