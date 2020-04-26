package com.ryd.golfstats.golfstats.controller;

import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.service.UserRoundService;
import com.ryd.golfstats.golfstats.utils.Assert;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/{userId}/rounds")
@Slf4j
public class UserRoundsController {

    private UserRoundService userRoundService;

    @Autowired
    public UserRoundsController(UserRoundService userRoundService) {
        Assert.notNull(userRoundService, "roundService");
        this.userRoundService = userRoundService;
    }

    /**
     * Gets all Rounds belonging to a specific User
     */
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Round> getAllRoundsByUserId(@PathVariable String userId) {
        return userRoundService.getAllRoundsByUserId(userId);
    }

    /**
     * Gets a specific Round by id
     */
    @GetMapping(
        path = "/{roundId}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Round> getRoundByUserIdAndId(@PathVariable String userId, @PathVariable String roundId) {
        ObjectId objectId = new ObjectId(roundId);
        return userRoundService.getRoundByUserIdAndId(userId, objectId);
    }

    /**
     * Creates a Round
     */
    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public Round create(@PathVariable String userId, @Valid @RequestBody Round round) {
        userRoundService.create(userId, round);
        return round;
    }

    /**
     * Deletes a Round
     */
    @DeleteMapping(
        path = "/{roundId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String userId, @PathVariable String roundId) {
        //todo - need to return an id?

        ObjectId objectId = new ObjectId(roundId);
        userRoundService.delete(userId, objectId);

    }

//    /**
//     * Edits a Round
//     */
//    @PutMapping(
//        path = "/{roundId}",
//        produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    @ResponseStatus(HttpStatus.OK)
//    public void edit(@PathVariable String userId, @PathVariable String roundId, @Valid @RequestBody Round updatedRound) {
//        //todo - need to return an id?
//
//        ObjectId objectId = new ObjectId(roundId);
//
//        userRoundService.put(userId, objectId, updatedRound);
//
//    }

}
