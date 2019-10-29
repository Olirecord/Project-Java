package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.transaction.TransactionScoped;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface GameRepo extends JpaRepository<GamesWish,String> {

	public ArrayList<GamesWish> filterPlatform();
	public ArrayList<GamesWish> filterReleaseD();
	public ArrayList<GamesWish> filterTopPrice();
	public ArrayList<GamesWish> filterLowPrice();
	
	public GamesWish findByid(Long id);
	
	public ArrayList<GamesWish> findAll(); 
	
	public ArrayList<GamesWish> displayAll();
	
	@Transactional
	@Modifying
	public void deleteById(Long id);
	
	
	
}
