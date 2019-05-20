package com.myallocation.allocator;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouritesRepo extends JpaRepository<Favourites,String> {

@Query(value="select * from favourite where user_id=?1",nativeQuery=true)
public List<Favourites> findAllFav(int userId);

}
