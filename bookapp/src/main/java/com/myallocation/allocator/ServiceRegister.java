package com.myallocation.allocator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegister {
@Autowired
StudentRepo repo;
public void save(Student student) {
	repo.save(student);
}
public Student myStudent(String username,String password) {
	return repo.login(username, password);
}
}
