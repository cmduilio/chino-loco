package com.mainPackage.controller;

import com.mainPackage.model.Day;
import com.mainPackage.repository.BaseRepository;
import com.mainPackage.repository.DayRepository;
import com.mainPackage.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//implementation of controller interface
@RestController
public class PingController implements com.mainPackage.controller.Controller{

    @Autowired
    private Repository dayRepository;

    private static final Logger log = LoggerFactory.getLogger(PingController.class);


    @GetMapping
	@RequestMapping(value = {"/ping" })
	public String getWeather() throws Exception{

        log.info("pong");
        return "pong";
	}

    @GetMapping
    @RequestMapping(value = {"/pings" })
    public String getAll() throws Exception{

        List<Day> asd = ((DayRepository) dayRepository).getList();
        return "pong";
    }
}
