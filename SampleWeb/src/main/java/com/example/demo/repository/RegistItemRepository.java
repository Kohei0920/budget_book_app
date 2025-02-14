package com.example.demo.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RegistItem;

@Repository
public interface RegistItemRepository extends JpaRepository<RegistItem, Integer>{

	/*日付並び替え*/
	public List<RegistItem> findAllByOrderByDate();
	
	/*日付検索*/
	public List<RegistItem> findByDateOrderByItemDesc(LocalDate date);
}
