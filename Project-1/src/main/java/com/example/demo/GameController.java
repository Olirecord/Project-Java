package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public String filterLowPrice() {
		return service.filterLowPrice();
	}
	@GetMapping("/filterPlatform/{platform}")
	public ArrayList<GamesWish> filterPlatform(@PathVariable String platform){
		return service.filterPlatform(platform);
	}
	@GetMapping("/filterTopPrice")
	public ArrayList<GamesWish> filterTopPrice() {
		return service.filterTopPrice();
	}
	@GetMapping("/filterReleaseD")
	public ArrayList<GamesWish> filterReleaseD(){
		return service.filterReleaseD();
	}
	
	@GetMapping("/ShowAll")
	public ArrayList<GamesWish> ShowAll(){
		return repo.findAll();
	}
	
	
	@GetMapping("/FindGame/{game}")
	public GamesWish FindGame(@PathVariable String game){
		return repo.findBygame(game);
	}
	
	
	//BEGINNING OF add NEW game
	// add way to ensure platform is entered correctly and price.
	@PostMapping("/addGame")
	public String addGame(@RequestBody GamesWish ref) {
		repo.save(ref);
		return "Game added to wishlist";
	}
	
	//DELETE A RECORD
	
	@PutMapping("/DeleteEntry/{game}")
	public String DeleteEntry(@PathVariable String game){
		 repo.deleteById(game);
		 return "Game removed from wishlist";
	}
	
	
	//UPDATE EXISTING RECORDS
	
	@PutMapping("/UpdateRank/{game}/{newRank}")
	public String UpdateRank(@PathVariable String game, @PathVariable int newRank) {
		GamesWish g= repo.findBygame(game);
		g.setRank(newRank);
		repo.save(g);
		return "Game rank updated";
	}
	@PutMapping("/UpdatePrice/{game}/{newPrice}")
	public String UpdateRank(@PathVariable String game, @PathVariable float newPrice) {
		GamesWish g= repo.findBygame(game);
		g.setPrice(newPrice);
		repo.save(g);
		return "Game price updated";
	}
	@PutMapping("/UpdateDate/{game}/{newDate}")
	public String UpdateRank(@PathVariable String game, @PathVariable Date newDate) {
		GamesWish g= repo.findBygame(game);
		g.setReleaseD(newDate);
		repo.save(g);
		return "Release date updated";
	}
	
	
	
	
	
	
	
}
