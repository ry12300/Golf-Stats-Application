package com.ryd.golfstats.golfstats.repository;

import com.ryd.golfstats.golfstats.model.Round;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoundRepository extends MongoRepository<Round, String> {

    List<Round> findByUserId(String userId);

    @Query("{'userId' : ?0 , '_id' : ?1}")
    Optional<Round> findByUserIdAnd_id(String userId, ObjectId _id);

}
