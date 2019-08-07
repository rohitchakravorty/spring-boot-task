package com.stackroute.boot.repository;

import com.stackroute.boot.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface TrackRepository extends MongoRepository<Track,Integer>
{
       List<Track> findTrackByName(String name);
}
