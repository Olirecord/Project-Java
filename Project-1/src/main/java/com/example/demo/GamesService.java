package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

		@Autowired
		private GameRepo gr;
	
		public String filterLowPrice() {
			return gr.filterLowPrice();
		}
	public ArrayList<GamesWish> filterTopPrice() {
		return gr.filterTopPrice();
	}
	public ArrayList<GamesWish> filterReleaseD(){
		return gr.filterReleaseD();
	}
	public ArrayList<GamesWish> filterPlatform(String a){
		return gr.filterPlatform(a);
	}
	public ArrayList<GamesWish> displayAll(){
		return gr.displayAll();
	}
	
}
