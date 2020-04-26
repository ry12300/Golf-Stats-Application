package com.ryd.golfstats.golfstats.controller;

import com.ryd.golfstats.golfstats.AbstractUnitTests;
import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.testUtils.Mocks;
import com.ryd.golfstats.golfstats.testUtils.Requests;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@AutoConfigureMockMvc
public class UserRoundsControllerTest extends AbstractUnitTests {

    private static String STUB_USER_ID = "user3";
    private static String STUB_ROUND_ID = "7e3b270222252b2dadd547fb";

    @Autowired
    private MockMvc mockMvc;

    private Round round;

    private ObjectId objectId;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        round = Mocks.pinehurstRound();
        objectId = Mocks.objectId();
    }

    @Test
    public void shouldGetAllRoundsByUserId() throws Exception {

        // setup
        given(userRoundService.getAllRoundsByUserId(STUB_USER_ID)).willReturn(Collections.singletonList(round));

        // mock the rounds/userId request
        RequestBuilder requestBuilder = Requests.getAllRoundsByUserId(STUB_USER_ID);

        // perform the requests
        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
            .andReturn()
            .getResponse();

        // asserts
        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void shouldGetSpecificRound() throws Exception {

        // setup
        given(userRoundService.getRoundByUserIdAndId(STUB_ROUND_ID, objectId)).willReturn(Optional.of(round));

        // mock the rounds/userId request
        RequestBuilder requestBuilder = Requests.getSpecificRound(STUB_USER_ID, STUB_ROUND_ID);

        // perform the requests
        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
            .andReturn()
            .getResponse();

        // asserts
        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    public void shouldCreateRound() throws Exception {

        // setup
        given(userRoundService.create(STUB_USER_ID, round)).willReturn(round);

        // mock the rounds/userId request
        RequestBuilder requestBuilder = Requests.createRound(STUB_USER_ID, round);

        // perform the requests
        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
            .andReturn()
            .getResponse();

        // asserts
        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
    }

    // todo - need a return value to mock this?
//    @Test
//    public void shouldDeleteRound() throws Exception {
//
//        // setup
//        given(userRoundService.create(anyString(), round)).willReturn(round);
//
//        // mock the rounds/userId request
//        RequestBuilder requestBuilder = Requests.createRound(STUB_USER_ID,round);
//
//        // perform the requests
//        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
//            .andReturn()
//            .getResponse();
//
//        // asserts
//        assertNotNull(response);
//        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
//    }
}
