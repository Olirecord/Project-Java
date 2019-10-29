package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controllers.Data.Data;

@RestController
@CrossOrigin
@RequestMapping("/gameapp")
public class GameController {

	@Autowired
	private GameRepo repo;
	@Autowired
	private GamesService service;
	
	@GetMapping("/displayall")
	public ArrayList<GamesWish> displayAll(){
		return service.displayAll();
	}
	

	//SEARCH AND FILTER RESULTS
	
	
	@GetMapping("/filterLowPrice")
	public ArrayList<GamesWish> filterLowPrice() {
		return service.filterLowPrice();
	}
	@GetMapping("/filterPlatform")
	public ArrayList<GamesWish> filterPlatform(){
		return service.filterPlatform();
	}
	@GetMapping("/filterTopPrice")
	public ArrayList<GamesWish> filterTopPrice() {
		return service.filterTopPrice();
	}
	@GetMapping("/filterReleaseD")
	public ArrayList<GamesWish> filterReleaseD(){
		return service.filterReleaseD();
	}
	

	
	
	//BEGINNING OF add NEW game
	// add way to ensure platform is entered correctly and price.
	@PostMapping("/addGame")
	public String addGame(@RequestBody GamesWish ref) {
		repo.save(ref);
		return "Game added to wishlist";
	}
	
	//DELETE A RECORD
	
	@DeleteMapping("/deleteEntry/{id}")
	public String DeleteEntry(@PathVariable Long id){
		 repo.deleteById(id);
		 return "Game removed from wishlist";
	}
	
	
	//UPDATE EXISTING RECORDS
	
	@PutMapping("/UpdateRank/{id}/{newRank}")
	public String UpdateRank(@PathVariable Long id, @PathVariable int newRank) {
		GamesWish g= repo.findByid(id);
		g.setRank(newRank);
		repo.save(g);
		return "Rank updated";
	}
	@PutMapping("/UpdatePrice/{id}/{newPrice}")
	public String UpdateRank(@PathVariable Long id, @PathVariable float newPrice) {
		GamesWish g= repo.findByid(id);
		g.setPrice(newPrice);
		repo.save(g);
		return "Price updated";
	}
	@PutMapping("/UpdateDate/{id}/{newDate}")
	public String UpdateRank(@PathVariable Long id, @PathVariable Date newDate) {
		GamesWish g= repo.findByid(id);
		g.setReleaseD(newDate);
		repo.save(g);
		return "Release date updated";
	}
	@PutMapping("/UpdateGame/{id}/{newGame}")
	public String UpdateGame(@PathVariable Long id, @PathVariable String newGame) {
		GamesWish g= repo.findByid(id);
		g.setGame(newGame);
		repo.save(g);
		return "Game updated";
	}
	@PutMapping("/UpdatePlatform/{id}/{newPlat}")
	public String UpdateRank(@PathVariable Long id, @PathVariable String newPlat) {
		GamesWish g= repo.findByid(id);
		g.setPlatform(newPlat);
		repo.save(g);
		return "Platform updated";
	}
	
	
	
	
	
	
	
}
