package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/search")
	public Search search(@RequestParam(value = "term", defaultValue = "comedy") String term){
		Search mySearch = new Search(counter.incrementAndGet(), term);
		mySearch.find();
		return mySearch;
	}
}
