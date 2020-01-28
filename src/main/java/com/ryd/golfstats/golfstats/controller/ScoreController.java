package com.ryd.golfstats.golfstats.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Returns a users scores
 */
@CrossOrigin
@RestController
@RequestMapping("/scores")
@Slf4j
public class ScoreController {

    private static final String SCORE = "score";

    @Autowired
    public ScoreController() {

    }

    @GetMapping(
        path = "/{identity}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String get(@PathVariable String identity) {

        return "User: " + identity + " | Score: " + 89;
    }

}
