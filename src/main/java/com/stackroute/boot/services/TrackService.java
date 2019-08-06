package com.stackroute.boot.services;


import java.util.List;

import com.stackroute.boot.model.Track;
import org.springframework.stereotype.Service;

@Service
public interface TrackService {
	public Track saveTrack(Track track);

	public boolean deleteTrack(int id);

	public List<Track> getAllTracks();

	public Track getTrackById(int id);

	public boolean UpdateTrack(int id,Track track);


   
}