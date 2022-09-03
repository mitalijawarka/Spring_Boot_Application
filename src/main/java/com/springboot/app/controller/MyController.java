package com.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.entity.Track;
import com.springboot.app.service.TrackServiceImpl;

@RestController
@RequestMapping(path="/track")
public class MyController {
	
	@Autowired 
	TrackServiceImpl trackservice;
	
	/*
	 * @Autowired 
	 * private TrackService trackservice;
	 * 
	 * @GetMapping("/home") public String home() { return "Hi in String function"; }
	 * 
	 * @GetMapping("/track") public List<Track> gettrack() { return
	 * this.trackservice.getTrack();
	 * 
	 * }
	 * 
	 * @GetMapping("/track/{getHistory}") public Track gettrack1(@PathVariable
	 * String trackid ) { return this.trackservice.
	 * gettrack1(Long.parseLong(trackid)); }
	 * 
	 * @PostMapping("track/trackValue") public List<Track> add(@RequestBody Track
	 * track) {
	 * 
	 * return this.trackservice.getTrack();
	 * 
	 * }
	 */
	@GetMapping(path="/getHistory")
	public List<Track> getAllTrack()
	{
		List<Track>tracklist=new ArrayList<>();
		tracklist.addAll(trackservice.getAlltrack());
		return tracklist;
	}
	
	@GetMapping(path="/getHistoryById/{userId}")
	public List<Track> getHistoryById(@PathVariable(name="userId")String userId)
	{
		List<Track>tracklist=new ArrayList<>();
		tracklist.addAll(trackservice.getHistoryById(userId));
		return tracklist;
	}
	
	@GetMapping(path="/getAllHistoryById/{userId}")
	public List<Track> getAllHistoryById(@PathVariable(name="userId")String userId)
	{
		List<Track>tracklist=new ArrayList<>();
		tracklist.addAll(trackservice.getAllHistoryById(userId));
		return tracklist;
	}
	
	@PostMapping(path="/saveTrack")
	public String saveTrack1(@RequestBody Track track)
	{
		return trackservice.saveTrack1(track);
		
	}
	
	@PostMapping(path="/saveTrackList")
	public String saveTrackList(@RequestBody List<Track>trackList)
	{
		return trackservice.saveTrackList(trackList);
		
	}
	
}

