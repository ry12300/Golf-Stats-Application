package com.ryd.golfstats.golfstats.util;

import com.ryd.golfstats.golfstats.GolfStatsApplication;
import com.ryd.golfstats.golfstats.service.RoundService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class should be extended by all Unit Test classes
 * to avoid repeating mock object creation in many classes
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = GolfStatsApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class AbstractUnitTests {

    //todo - change below from being public?

    /*
     * The behaviour of the mocks below should be
     * defined in concrete classes. E.g. given/wens
     */
    @MockBean
    public RoundService roundService;
}
