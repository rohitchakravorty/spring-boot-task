package com.stackroute.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.boot.BootApplication;
import com.stackroute.boot.services.TrackService;
import com.stackroute.boot.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes=BootApplication.class)
public class TrackControllerTest {

    private MockMvc mockMvc;
    private Track track;

    @Mock
    private TrackService trackDAO;

    @InjectMocks
    private TrackController trackController;

    @Before
    public void setUp() throws Exception {
        trackController = new TrackController(trackDAO);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(this.trackController).build();
        this.track = new Track(1, "jjj", "sd");

    }

    @Test
    public void saveTrack() throws Exception {
        when(trackDAO.saveTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/saveTrack")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getTrack() throws Exception
    {

        when(trackDAO.getAllTracks()).thenReturn((List<Track>) track);
        mockMvc.perform(MockMvcRequestBuilders.get("/getAllTracks")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void updateTrack() throws Exception
    {

        when(trackDAO.UpdateTrack(any(),any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.get("/updateTrack/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteTrack() throws Exception
    {

        when(trackDAO.deleteTrack(anyInt())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.get("/deleteTrack")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}