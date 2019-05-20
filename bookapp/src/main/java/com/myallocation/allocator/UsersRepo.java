package com.myallocation.allocator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepo extends JpaRepository<Users,Integer>{
@Query(value="SELECT * FROM USERS WHERE USER_NAME=?1 AND USER_PASSWORD=?2",nativeQuery=true)
public Users login(String userName,String userPassword);
}
