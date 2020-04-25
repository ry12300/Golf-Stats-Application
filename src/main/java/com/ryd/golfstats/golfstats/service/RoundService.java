package com.ryd.golfstats.golfstats.service;

import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.repository.RoundRepository;
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
public class RoundService {

    @Autowired
    RoundRepository roundRepository;

    @Autowired
    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;

    }

    public List<Round> getRoundsByUserId(String userId) {
        return roundRepository.findByUserId(userId);
    }

    public List<Round> find() {
        return roundRepository.findAll();
    }

    public Round create(@Valid @NotNull @RequestBody Round round) {
        roundRepository.save(round);

        return round;
    }

    public void delete(ObjectId objectId) {
        Optional<Round> round = roundRepository.findBy_id(objectId);

        if (round.isPresent()) {
            roundRepository.delete(round.get());
        } else {
            log.info("Could not find Round with objectId: {} to delete ", objectId);
        }
    }

    //todo - add patch

}
