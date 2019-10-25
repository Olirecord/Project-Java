package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GameRepo extends JpaRepository<GamesWish,String> {

	public ArrayList<GamesWish> filterPlatform(String a);
	public ArrayList<GamesWish> filterReleaseD();
	public ArrayList<GamesWish> filterTopPrice();
	public String filterLowPrice();
	
	public GamesWish findBygame(String game);
	
	public ArrayList<GamesWish> findAll(); 
	
	public ArrayList<GamesWish> displayAll();
	
	
	
	
}
