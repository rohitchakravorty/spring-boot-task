package com.stackroute.boot.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.stackroute.boot.services.TrackService;
import com.stackroute.boot.exception.TrackAlreadyExistsException;
import com.stackroute.boot.model.Track;
import com.stackroute.boot.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@JsonFilter("hello")
public class TrackController {
	@Autowired
    TrackService trackDAO;
	//update all the methods with code


    public TrackController(TrackService trackDAO) {
        this.trackDAO = trackDAO;
    }

    @PostMapping("/saveJson")
	public ResponseEntity<?> saveTracksJson(@RequestBody List<Track> tracks)
	{
		ResponseEntity responseEntity;
		for(Track t1:tracks)
		{
			try {
				trackDAO.saveTrack(t1);
			} catch (TrackAlreadyExistsException e) {
				e.printStackTrace();e.printStackTrace();
			}
		}
		responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);

		return responseEntity;
	}

	@PostMapping("/track")
	public ResponseEntity<?> saveTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try
		{
			trackDAO.saveTrack(track);
			responseEntity = new ResponseEntity("Successfully created", HttpStatus.CREATED);
		}
		catch(TrackAlreadyExistsException ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		};
		return responseEntity;
	}


	@PostMapping("/track/{id}")
	public ResponseEntity<?> updateTrack(@RequestBody Track track)
	{
		ResponseEntity responseEntity;
		try
		{
			trackDAO.saveTrack(track);
			responseEntity = new ResponseEntity("Successfully updated", HttpStatus.OK);
		}
		catch(Exception ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@DeleteMapping("/track")
	public ResponseEntity<?> deleteTrack(@RequestBody Track track)
	{

		ResponseEntity responseEntity;
		try
		{
			trackDAO.deleteTrack(track.getId());
			responseEntity = new ResponseEntity("Successfully deleted", HttpStatus.OK);
		}
		catch(Exception ex) {
			responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("/track")
	public ResponseEntity<?> getAllTracks() {
		return new ResponseEntity<>(trackDAO.getAllTracks(), HttpStatus.OK);
	}





}
