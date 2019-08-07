package com.stackroute.boot.services;

import java.util.List;

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
	public Track saveTrack(Track track) {

		Track track1 = trackRepository.save(track);
		return track1;
	}

	@Override
	public boolean deleteTrack(int id) {

		trackRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Track> getAllTracks() {
		return trackRepository.findAll();

	}

	@Override
	public Track getTrackById(int id) {
	return trackRepository.getOne(id);

	}


	public boolean UpdateTrack(int id,Track track) {
		Track toBeUpdated = trackRepository.getOne(id);
		trackRepository.delete(toBeUpdated);
		Track updatedTrack = trackRepository.save(track);
		return true;

	}

	@Override
	public List<Track> getTrackByName(String name) {
		return trackRepository.findTrackByName(name);

	}
}
