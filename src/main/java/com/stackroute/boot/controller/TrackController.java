package com.stackroute.boot.controller;

import com.stackroute.boot.services.TrackServices;
import com.stackroute.boot.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {
	@Autowired
	TrackServices trackServices;
	//update all the methods with code
	@RequestMapping("/")
	public String indexPage(Model model) {
		List<Track> list = trackServices.getAllTracks();
		model.addAttribute("tracks", list);
		return "index";
	}
	@RequestMapping("/saveTrack")
	public ResponseEntity<?> saveTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try
		{
			trackServices.saveTrack(track);
			responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
		}
		catch(Exception ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}


	@RequestMapping("/updateTrack/{id}")
	public ResponseEntity<?> updateTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try
		{
			trackServices.saveTrack(track);
			responseEntity = new ResponseEntity("Successfully updated", HttpStatus.CREATED);
		}
		catch(Exception ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@RequestMapping("/deleteTrack")
	public ResponseEntity<?> deleteTrack(@RequestBody Track track)
	{

		ResponseEntity responseEntity;
		try
		{
			trackServices.deleteTrack(track.getId());
			responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
		}
		catch(Exception ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@RequestMapping("/getAllTracks")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(trackServices.getAllTracks(), HttpStatus.OK);
	}
	@RequestMapping("/user")
	public List<Track> findByTrack(@RequestBody String name)
	{
		return  trackServices.getTrackByName(name);
	}
}
