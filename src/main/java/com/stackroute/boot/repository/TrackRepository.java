package com.stackroute.boot.repository;

import com.stackroute.boot.model.Track;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrackRepository extends MongoRepository<Track,Integer>
{
       List<Track> findTrackByName(String name);
}
