package com.demosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demosp.model.ItemFav;


@Repository
public interface ItemFavRepository extends JpaRepository<ItemFav, Integer>{

}
