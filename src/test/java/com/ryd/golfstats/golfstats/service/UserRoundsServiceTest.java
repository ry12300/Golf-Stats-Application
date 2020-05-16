package com.ryd.golfstats.golfstats.service;

import com.ryd.golfstats.golfstats.AbstractUnitTests;
import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.testUtils.Mocks;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@DisplayName("Test UserRoundsServiceTest")
public class UserRoundsServiceTest extends AbstractUnitTests {

    private static String STUB_USER_ID = "user3";
    private static String STUB_ROUND_ID = "7e3b270222252b2dadd547fb";

    // class under test
    UserRoundService userRoundService;

    private Round round;

    private ObjectId objectId;

    @BeforeEach //note this replaces the junit 4 @Before
    public void setUp() {

        initMocks(this);
        round = Mocks.pinehurstRound();
        objectId = Mocks.objectId();

        userRoundService = new UserRoundService((roundRepository));
    }

    @DisplayName("Test RoundService.getAllRoundsByUserId()")
    @Test
    public void shouldGetRoundsByUserId() {

        // setup
        given(roundRepository.findByUserId(anyString())).willReturn(Collections.singletonList(round));

        // call method under test
        List<Round> rounds = userRoundService.getAllRoundsByUserId(STUB_USER_ID);

        // asserts
        assertNotNull(rounds);
        assertEquals(1, rounds.size());
        assertEquals("user3", rounds.get(0).userId());
    }


    @DisplayName("Test RoundService.create()")
    @Test
    public void shouldCreateRound() {

        // setup
        given(roundRepository.save(round)).willReturn(round);

        // call method under test
        Round createdRound = userRoundService.create(STUB_USER_ID, round);

        // asserts
        assertNotNull(createdRound);
        assertEquals("user3", createdRound.userId());
    }

    @DisplayName("Test RoundService.delete()")
    @Test
    public void ShouldDeleteRound() {

        // setup
        given(roundRepository.findByUserIdAnd_id(STUB_USER_ID, objectId)).willReturn(Optional.of(round));

        // call method under test
        userRoundService.delete(STUB_USER_ID, objectId);

        // asserts
        verify(roundRepository, times(1)).delete(round);
    }

    // todo - add patch test when implemented
}
