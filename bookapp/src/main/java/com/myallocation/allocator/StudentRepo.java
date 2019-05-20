package com.myallocation.allocator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student,String>{
@Query(value="select * from myregister where username=?1 and password=?2",nativeQuery=true)
public Student login(String username,String password);
}
