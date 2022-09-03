package com.springboot.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.entity.Track;
import com.springboot.app.repo.Repo;


@Service
public class TrackServiceImpl {
	
	/*
	 * List<Track> list;
	 * 
	 * public TrackServiceImpl() { list=new ArrayList<>(); list.add(new
	 * Track(1,"session","mitali")); list.add(new Track(2,"cache","pooja"));
	 * list.add(new Track(3,"logs","ljljl")); }
	 * 
	 * public List<Track> getTrack() { // TODO Auto-generated method stub return
	 * list; }
	 * 
	 * @Override public Track gettrack1(long trackid) { Track t=null; for(Track
	 * c:list) { if(c.getId()==trackid) { t=c; break; } } return t; }
	 * 
	 * @Override public Track add(Track track) { list.add(track); return track; }
	 */

	@Autowired
	Repo repo;
	public Collection<? extends Track> getAlltrack() {
	List<Track>tracklist=new ArrayList<>();
	repo.findAll().forEach(tracklist :: add);
	return tracklist;
	}
	public Collection<? extends Track> getHistoryById(String userId) {
		List<Track>tracklist=new ArrayList<>();
		tracklist.add(repo.findById(userId).get());
		return tracklist;
	}
	public Collection<? extends Track> getAllHistoryById(String userId) {
		List<Track>tracklist=new ArrayList<>();
		List<String> idList=Arrays.asList(userId.split(","));
		repo.findAllById(idList).forEach(tracklist::add);
		return tracklist;
	}
	public String saveTrack1(Track track) {
	Track saveTrack=repo.save(track);
	if(saveTrack!=null) {
		return "saved Track"+ saveTrack.getUserid();
	}
	else {
		return "failed Track"+track.getUserid();
	}
	}
	public String saveTrackList(List<Track> trackList) {
		List<Track>savedtrackList=new ArrayList<>();
		repo.saveAll(trackList).forEach(savedtrackList::add);
		return "saved userid"+savedtrackList.stream().map(u->u.getUserid()).collect(Collectors.toList());
	}
	
}
