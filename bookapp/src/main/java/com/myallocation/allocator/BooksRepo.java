package com.myallocation.allocator;


import java.sql.Blob;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface BooksRepo extends JpaRepository<Books,Integer>{
public Books findByBookTitle(String bookTitle);
@Modifying
@Transactional
@Query(value="delete from allbooks where book_title=?1",nativeQuery=true)
public int deleteByTitle(String bookTitle);

@Query(value="select file from allbooks where book_title=?1",nativeQuery=true)
public Blob getBook(String bookTitle);

}
