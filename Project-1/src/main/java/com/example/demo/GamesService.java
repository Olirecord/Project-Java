package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GamesService {

		@Autowired
		private GameRepo gr;
	
		public ArrayList<GamesWish> filterLowPrice() {
			return gr.filterLowPrice();
		}
	public ArrayList<GamesWish> filterTopPrice() {
		return gr.filterTopPrice();
	}
	public ArrayList<GamesWish> filterReleaseD(){
		return gr.filterReleaseD();
	}
	public ArrayList<GamesWish> filterPlatform(){
		return gr.filterPlatform();
	}
	public ArrayList<GamesWish> displayAll(){
		return gr.displayAll();
	}
	
	
	
}
