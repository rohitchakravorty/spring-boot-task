package com.stackroute.boot.dao;

import com.stackroute.boot.exception.TrackAlreadyExistsException;
import com.stackroute.boot.exception.TrackNotFoundException;
import com.stackroute.boot.model.Track;

import com.stackroute.boot.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackDAOImplTest {
    Track track;
    @Mock
    TrackRepository trackRepository;


    @InjectMocks
    TrackDAOImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setName("sdd");
        track.setId(2);
        track.setComment("sddsafs");
        list = new ArrayList<>();
        list.add(track);
    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);
        verify(trackRepository,times(1)).save(track);

    }

    @Test
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track)any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);


    }

    @Test
    public void getAllTrack(){

        trackRepository.save(track);

        when(trackRepository.findAll()).thenReturn(list);
        List<Track> tracklist = trackService.getAllTracks();
        Assert.assertEquals(list,tracklist);
    }

    @Test
    public void deleteById() throws TrackNotFoundException {
        trackService.deleteTrack(track.getId() );
        verify(trackRepository).deleteById(anyInt());
    }






}

