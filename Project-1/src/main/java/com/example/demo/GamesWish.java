package com.example.demo;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@NamedQueries(value= {
		@NamedQuery(
					name="GamesWish.filterLowPrice",
					query="Select p from GamesWish p order by p.price"),
		@NamedQuery(
					name="GamesWish.filterTopPrice",
					query="Select p from GamesWish p order by p.price desc"),
		@NamedQuery(
					name="GamesWish.filterReleaseD",
					query="Select p from GamesWish p order by p.releaseD desc"),
		 
		@NamedQuery(name="GamesWish.filterPlatform",
					query="SELECT p from GamesWish p WHERE p.platform=?1 order by p.price desc"),
		
		@NamedQuery(name="GamesWish.displayAll",
					query="select p from GamesWish p order by p.grank")
		
})
@Table(name="gameswish")

public class GamesWish {
	
	@Id 
	
	
	private String game;
	private String platform;
	private  Date releaseD;
	private float price;
	private int grank;
	
	
	
	public GamesWish() {}
	
	

	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public Date getReleaseD() {
		return releaseD;
	}

	public void setReleaseD(Date releaseD) {
		this.releaseD = releaseD;
	}

	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getRank() {
		return grank;
	}
	public void setRank(int rank) {
		this.grank = rank;
	}

}
