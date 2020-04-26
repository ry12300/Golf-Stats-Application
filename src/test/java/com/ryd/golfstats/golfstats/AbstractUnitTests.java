package com.ryd.golfstats.golfstats;

import com.ryd.golfstats.golfstats.repository.RoundRepository;
import com.ryd.golfstats.golfstats.service.UserRoundService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * This class should be extended by all Unit Test classes
 * to avoid repeating mock object creation in many classes
 */
@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
@SpringBootTest(
    classes = GolfStatsApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class AbstractUnitTests {

    //todo - change below from being public?

    /*
     * The behaviour of the mocks below should be
     * defined in concrete classes. E.g. given/whens
     */
    @MockBean
    public UserRoundService userRoundService;

    @MockBean
    public RoundRepository roundRepository;

}
