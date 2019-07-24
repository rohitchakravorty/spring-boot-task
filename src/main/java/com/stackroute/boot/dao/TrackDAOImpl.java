package com.stackroute.boot.dao;

import java.util.List;
import java.util.Optional;

import com.stackroute.boot.repository.TrackRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.boot.model.Track;
import org.springframework.stereotype.Service;

@Service
public class TrackDAOImpl implements TrackDAO {

	@Autowired
	private TrackRepository trackRepository;
	public TrackDAOImpl(TrackRepository trackRepository)
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

}
