package com.ryd.golfstats.golfstats.service;

import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.repository.RoundRepository;
import com.ryd.golfstats.golfstats.utils.Assert;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service("RoundService")
public class UserRoundService {

    @Autowired
    RoundRepository roundRepository;

    @Autowired
    public UserRoundService(RoundRepository roundRepository) {
        Assert.notNull(roundRepository, "roundRepository");
        this.roundRepository = roundRepository;
    }

    public Optional<Round> getRoundByUserIdAndId(String userId, ObjectId objectId) {
        return roundRepository.findByUserIdAnd_id(userId, objectId);
    }

    public List<Round> getAllRoundsByUserId(String userId) {
        return roundRepository.findByUserId(userId);
    }

    public Round create(String userId, @Valid @NotNull @RequestBody Round round) {

        // set userId from path
        round.userId(userId);

        roundRepository.save(round);
        return round;
    }

    public void delete(String userId, ObjectId objectId) {
        Optional<Round> round = roundRepository.findByUserIdAnd_id(userId, objectId);

        //todo - need to return proper REST codes - e.g. if not found return 400
        if (round.isPresent()) {
            roundRepository.delete(round.get());
        } else {
            log.info("Could not find Round with objectId: {} to delete ", objectId);
        }
    }

//    public void put(String userId, ObjectId objectId, Round updatedRound) {
//
//        // get original round
//        Optional<Round> round = roundRepository.findByUserIdAnd_id(userId, objectId);
//
//        //todo - how to implement PUT in mongo to update to "updatedRound"?
//    }

}
