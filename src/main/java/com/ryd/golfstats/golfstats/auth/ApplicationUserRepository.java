package com.ryd.golfstats.golfstats.auth;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);

    //todo - use a diff repo? - what is commented out below works or hardcode db
//    public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
//        ApplicationUser findByUsername(String username);
}