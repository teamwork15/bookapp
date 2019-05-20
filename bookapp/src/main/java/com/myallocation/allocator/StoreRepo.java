package com.myallocation.allocator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepo extends JpaRepository<Storekeeper,Integer>{
@Query(value="select * from store where store_name=?1 and store_password=?2",nativeQuery=true)
public Storekeeper storeLogin(String storeName,String storePassword);
}
