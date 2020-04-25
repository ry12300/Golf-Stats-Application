package com.ryd.golfstats.golfstats.controller;

import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.util.AbstractUnitTests;
import com.ryd.golfstats.golfstats.util.Mocks;
import com.ryd.golfstats.golfstats.util.Requests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@AutoConfigureMockMvc
public class RoundsControllerTest extends AbstractUnitTests {

    private static String STUB_USER_ID = "user3";

    @Autowired
    private MockMvc mockMvc;

    private Round round;

    @Before
    public void setUp() {
        initMocks(this);
        round = Mocks.pinehurstRound();
    }

    @Test
    public void shouldGetAllRoundsByUserId() throws Exception {

        // setup
        given(roundService.getRoundsByUserId(STUB_USER_ID)).willReturn(Collections.singletonList(round));

        // mock the rounds/userId request
        RequestBuilder requestBuilder = Requests.getRoundsByUserId(STUB_USER_ID);

        // perform the requests
        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
            .andReturn()
            .getResponse();

        // asserts
        assertNotNull(response);
        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

//    @Test
//    public void shouldCreateRound() throws Exception {
//
//        // setup
//        given(roundService.create(round)).willReturn(round);
//
//        // mock the rounds/userId request
//        RequestBuilder requestBuilder = Requests.createRound(round);
//
//        // perform the requests
//        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
//            .andReturn()
//            .getResponse();
//
//        // asserts
//        assertNotNull(response);
//        assertEquals(response.getStatus(), HttpStatus.CREATED);
//    }
}
