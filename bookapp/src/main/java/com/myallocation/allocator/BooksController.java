package com.myallocation.allocator;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookstore")
public class BooksController {
public static int BUFFER_SIZE=1024*100;


private ServletContext context;

@Autowired
ServiceClass service;
public void getServletContext(ServletContext serv) {
	this.context=serv;
}
public ServletContext getServletContext() {
	return context;
}
@RequestMapping("/home")
public ModelAndView getHome(){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("home");
	return mv;
}

@RequestMapping("/userpage")
public ModelAndView getPage(){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("userpage");
	return mv;
}
@RequestMapping("/storepage")
public ModelAndView getSp(){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("storepage");
	return mv;
}
@RequestMapping("/storeregister")
public ModelAndView getSR(){
	ModelAndView mv=new ModelAndView();
	mv.addObject("storekeepers",new Storekeeper());
	mv.setViewName("storeregiter");
	return mv;
}
@RequestMapping("/storelogin")
public ModelAndView getSL(){
	ModelAndView mv=new ModelAndView();
	mv.addObject("storekeepers",new Storekeeper());
	mv.setViewName("storelogin");
	return mv;
}
@RequestMapping("/userregister")
public ModelAndView getAddU(){
	ModelAndView mv=new ModelAndView();
	mv.addObject("users",new Users());
	mv.setViewName("userregister");
	return mv;
}
@RequestMapping("/loginuser")
public ModelAndView getAddUS(){
	ModelAndView mv=new ModelAndView();
	mv.addObject("users",new Users());
	mv.setViewName("userlogin");
	return mv;
}

@RequestMapping("/addbookpage")
public ModelAndView getAdd(){
	ModelAndView mv=new ModelAndView();
	mv.addObject("books",new Books());
	mv.setViewName("addbook");
	return mv;
}
@RequestMapping("/allbooks")
public ModelAndView getAll(@RequestParam int userId){
	ModelAndView mv=new ModelAndView();
	List<Books> getBooks=new ArrayList<>();
	
	getBooks=service.getAll();
	mv.addObject("userId",userId);
	mv.addObject("booklist",getBooks);
	mv.setViewName("userview");
	return mv;
}
@RequestMapping("/allstorebooks")
public ModelAndView getStoreBooks(){
	ModelAndView mv=new ModelAndView();
	List<Books> getBooks=new ArrayList<>();
	getBooks=service.getAll();
	mv.addObject("booklist",getBooks);
	mv.setViewName("storeview");
	return mv;
}
@RequestMapping(method=RequestMethod.POST,value="/addbooks")
public ModelAndView addBook(@RequestParam String bookTitle,@RequestParam String bookAuthor,
		@RequestParam String bookGenre,@RequestPart MultipartFile file) throws IOException{
	ModelAndView mv=new ModelAndView();
	Books book=new Books();
	byte[] myfile=file.getBytes();
	book.setFile(myfile);
	book.setBookTitle(bookTitle);
	book.setBookAuthor(bookAuthor);
	book.setBookGenre(bookGenre);
	service.addBook(book);
    mv.setViewName("addbook");
	
    return mv;
}

@RequestMapping("/findbook")
public ModelAndView getBook(@RequestParam String bookTitle) {
	ModelAndView mv=new ModelAndView();
    service.getBook(bookTitle);
    mv.addObject("book",service.getBook(bookTitle));
    mv.setViewName("viewbook");
    return mv;
}
@RequestMapping("/updatebook") 
public ModelAndView updateBook(@RequestParam int bookId,Books book) {
	ModelAndView mv=new ModelAndView();
	service.updateBook(book);
	mv.addObject("message",service.updateBook(book));
    mv.setViewName("updatepage");
    return mv;
	}
@RequestMapping("/findstorebook")
public ModelAndView findstorebook(@RequestParam String bookTitle) {
	ModelAndView mv=new ModelAndView();
	service.getBook(bookTitle);
    mv.addObject("book",service.getBook(bookTitle));
    mv.setViewName("viewstorebook");
    return mv;
}

@RequestMapping("/deletebook")
public ModelAndView deleteBook(@RequestParam String bookTitle) {
	ModelAndView mv=new ModelAndView();
	
	String message=service.deleteBook(bookTitle);
	mv.addObject("message",message);
	List<Books> getBooks=new ArrayList<>();
	getBooks=service.getAll();
	mv.addObject("booklist",getBooks);
	mv.setViewName("storeview");
	
  
	
 return mv;
}
@RequestMapping(method=RequestMethod.POST,value="/adduser")
public ModelAndView addUser(@Valid Users user,BindingResult result) {
	ModelAndView mv=new ModelAndView();
	if(result.hasErrors()) 
	{
	mv.addObject("users",user);	
	mv.setViewName("userregister");
	}
	else {
    service.addUser(user);
	mv.addObject("user",service.addUser(user));
	mv.addObject("users",new Users());
	mv.setViewName("userlogin");
	}
	return mv;
	}
@RequestMapping("/userlogin")
public ModelAndView login(@RequestParam String userName,@RequestParam String userPassword) {
	ModelAndView mv=new ModelAndView();
	service.loginUser(userName,userPassword);
	if(service.loginUser(userName,userPassword) != null) {
		mv.addObject("user",service.loginUser(userName,userPassword));
		mv.setViewName("userportal");
		return mv;
	}
	else {
		mv.setViewName("userpage");
		return mv;
	}
	
}
@RequestMapping("/addfavourite")
public ModelAndView addFavourite(Favourites favourite,@RequestParam int userId) {
	ModelAndView mv=new ModelAndView();
	String message=service.addFavourite(favourite);
	mv.addObject("message",message);
	List<Books> getBooks=new ArrayList<>();
	getBooks=service.getAll();
	mv.addObject("booklist",getBooks);
	mv.addObject("userId",userId);
	mv.setViewName("userview");
	return mv;
}
@RequestMapping(method=RequestMethod.POST,value="/addstorekeeper")
public ModelAndView addBook(@Valid Storekeeper store,BindingResult result) {
	ModelAndView mv=new ModelAndView();
	if(result.hasErrors()) 
	{
	mv.addObject("storekeepers",store);	
	mv.setViewName("storeregiter");
	}
	else {
    service.addStore(store);
	mv.addObject("user",service.addStore(store));
	mv.addObject("storekeepers",new Storekeeper());
	mv.setViewName("storelogin");
	}
	return mv;
}
@RequestMapping("/loginstore")
public ModelAndView storeLogin(@RequestParam String storeName,@RequestParam String storePassword) {
	ModelAndView mv=new ModelAndView();
	service.login(storeName,storePassword);
	if(service.login(storeName,storePassword) != null) {
		mv.addObject("store",service.login(storeName,storePassword));
		mv.setViewName("storeportal");
	}
	else {

		mv.setViewName("storepage");
	}
	return mv;
}
@RequestMapping("/viewfavourites")
public ModelAndView getFavourites(@RequestParam int userId){
	ModelAndView mv=new ModelAndView();
	List<Favourites> getFavourites=new ArrayList<>();
	getFavourites=service.getFavourites(userId);
	mv.addObject("favourites",getFavourites);
	mv.setViewName("favouritesview");
	return mv;
}
@RequestMapping("/download")
	public ModelAndView download(HttpServletResponse response,
			@RequestParam("bookTitle") String bookTitle) throws ServletException,IOException, SQLException{
	ModelAndView mv=new ModelAndView();
	Blob blob=service.getBlob(bookTitle);
	String filename=bookTitle;
	try {
    response.setHeader("Content-Disposition","inline; filename=\""+filename+"\"");
    OutputStream out=response.getOutputStream();
	response.setContentType("application/octet-stream");
	IOUtils.copy(blob.getBinaryStream(),out);
	out.flush();
	out.close();
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
	return mv;
}
}