package com.stackroute.boot.controller;

import com.stackroute.boot.services.TrackService;
import com.stackroute.boot.exception.TrackAlreadyExistsException;
import com.stackroute.boot.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {
	@Autowired
	TrackService trackService;
	//update all the methods with code

	@PostMapping("/saveTrack")
	public ResponseEntity<?> saveTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try
		{
			trackService.saveTrack(track);
			responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
		}
		catch(TrackAlreadyExistsException ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}


	@PostMapping("/updateTrack/{id}")
	public ResponseEntity<?> updateTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try
		{
			trackService.saveTrack(track);
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
			trackService.deleteTrack(track.getId());
			responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
		}
		catch(Exception ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("/getAllTracks")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.OK);
	}
	@GetMapping("/user")
	public List<Track> findByTrack(@RequestBody String name)
	{
		return  trackService.getTrackByName(name);
	}
}
