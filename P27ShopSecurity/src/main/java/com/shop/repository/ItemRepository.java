package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.shop.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>,
			QuerydslPredicateExecutor<Item>{
	//쿼리 메소드
	//find+(entity이름)+By+변수명
	List<Item> findByItemNm(String itemNm);
	//And Or =(is equal) Between
	List<Item> findByItemNmOrItemDetail(String itemNm,String itemDetail);
	//LessThan LessThanEqual GreaterThan GreaterThanEqual
	List<Item> findByPriceLessThan(Integer price);
	
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
	//JPQL java persistance query language
    @Query("select i from Item i where i.itemDetail like " +
            "%:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value="select * from item i where i.item_detail like " +
            "%:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
	
    
    
    
    
    
    
    
}
