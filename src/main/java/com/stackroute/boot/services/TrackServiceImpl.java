package com.stackroute.boot.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.boot.exception.TrackAlreadyExistsException;
import com.stackroute.boot.exception.TrackNotFoundException;
import com.stackroute.boot.repository.TrackRepository;


import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.boot.model.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {

	@Autowired
	private TrackRepository trackRepository;
	public TrackServiceImpl(TrackRepository trackRepository)
	{
		this.trackRepository = trackRepository;
	}

	//implement all the methods

	@Override
	public Track saveTrack(Track track) throws TrackAlreadyExistsException {

		if(trackRepository.existsById(track.getId()))
		{
			throw new TrackAlreadyExistsException("The track already exists");
		}
		Track track1 = trackRepository.save(track);
		return track1;
	}

	@Override
	public boolean deleteTrack(int id) throws TrackNotFoundException{

		if(!trackRepository.findById(id).isEmpty())
		{
			throw new TrackNotFoundException("The track does not exist");
		}
		else {
			trackRepository.deleteById(id);
			return true;
		}
	}

	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();

	}

	@Override
	public Track getTrackById(int id) {
	Optional<Track> result = trackRepository.findById(id);

	if(result.isPresent()){
		return result.get();
	}
	else
	{
		throw new RuntimeException("Not available");
	}

	}


	public boolean UpdateTrack(int id,Track track) {
//		Track toBeUpdated = this.getTrackById(id);
//		trackRepository.delete(toBeUpdated);
//		Track updatedTrack = trackRepository.save(track);
		return true;

	}

	@Override
	public List<Track> getTrackByName(String name) {
		return trackRepository.findTrackByName(name);

	}
}
