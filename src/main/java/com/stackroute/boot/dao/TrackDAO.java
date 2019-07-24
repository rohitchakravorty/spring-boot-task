package com.stackroute.boot.dao;


import java.util.List;
import java.util.Optional;

import com.stackroute.boot.model.Track;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public interface TrackDAO {

	public Track saveTrack(Track track);

	public boolean deleteTrack(int id);

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public boolean UpdateTrack(int id,Track track);

	public List<Track> getTrackByName(String name);

   
}