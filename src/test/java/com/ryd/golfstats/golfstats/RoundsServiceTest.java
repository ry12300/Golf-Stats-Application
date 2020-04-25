package com.ryd.golfstats.golfstats;

import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.service.RoundService;
import com.ryd.golfstats.golfstats.util.AbstractUnitTests;
import com.ryd.golfstats.golfstats.util.Mocks;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class RoundsServiceTest extends AbstractUnitTests {

    private static String STUB_USER_ID = "user3";

    // class under test - note injectMocks not autowired
    @InjectMocks
    RoundService roundService;

    private Round round;

    private ObjectId objectId;

    @Before
    public void setUp() {
        initMocks(this);
        round = Mocks.pinehurstRound();
        objectId = Mocks.objectId();
    }

    @Test
    public void shouldGetRoundsByUserId(){

        // setup
        given(roundRepository.findByUserId(anyString())).willReturn(Collections.singletonList(round));

        // call method under test
        List<Round> rounds = roundService.getRoundsByUserId(STUB_USER_ID);

        // asserts
        assertNotNull(rounds);
        assertEquals(1, rounds.size());
        assertEquals("user3",rounds.get(0).userId());
    }

    @Test
    public void shouldFindAllRounds(){

        // setup
        given(roundRepository.findAll()).willReturn(Collections.singletonList(round));

        // call method under test
        List<Round> rounds = roundService.find();

        // asserts
        assertNotNull(rounds);
        assertEquals(1, rounds.size());
        assertEquals("user3",rounds.get(0).userId());
    }

    @Test
    public void shouldCreateRound(){

        // setup
        given(roundRepository.save(round)).willReturn(round);

        // call method under test
        Round createdRound = roundService.create(round);

        // asserts
        assertNotNull(createdRound);
        assertEquals("user3",createdRound.userId());
    }

    @Test
    public void ShouldDeleteRound(){

        // setup
        given(roundRepository.findBy_id(objectId)).willReturn(Optional.of(round));

        // call method under test
        roundService.delete(objectId);

        // asserts
        verify(roundRepository, times(1)).delete(round);
    }

    // todo - add patch test when implemented
}
