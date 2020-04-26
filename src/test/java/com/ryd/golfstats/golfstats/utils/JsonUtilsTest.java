package com.ryd.golfstats.golfstats.utils;

import com.ryd.golfstats.golfstats.AbstractUnitTests;
import com.ryd.golfstats.golfstats.model.Round;
import com.ryd.golfstats.golfstats.testUtils.Mocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

@DisplayName("Test JsonUtils")
public class JsonUtilsTest extends AbstractUnitTests {

    private Round round;

    @BeforeEach //note this replaces the junit 4 @Before
    public void setUp() {

        initMocks(this);
        round = Mocks.pinehurstRound();
    }

    @DisplayName("Test toJson()")
    @Test
    public void shouldConvertObjectToJson() {

        String json = JsonUtils.toJson(round);

        assertNotNull(json);
        assertTrue(json.contains("Pinehurst"));

    }

    @DisplayName("Test fromJson()")
    @Test
    public void shouldConvertJsonToRound() {

        Round roundFromJson = JsonUtils.fromJson("{\n" +
            "    \"userId\": \"User2\",\n" +
            "    \"course\": \"Spyglass\",\n" +
            "    \"date\": \"20-01-2020\",\n" +
            "    \"score\": 90,\n" +
            "    \"fairwayPercentage\": 55,\n" +
            "    \"greenPercentage\": 45,\n" +
            "    \"numberOfPutts\": 38,\n" +
            "    \"notes\": \"bad pace control on putts\"\n" +
            "}");

        assertNotNull(roundFromJson);
        assertEquals("User2", roundFromJson.userId());
        assertEquals("Spyglass", roundFromJson.course());
    }

    @DisplayName("Test fromJson() error is thrown")
    @Test
    public void shouldThrowErrorIfJsonIsInvalid() {

        String invalidJson = "{\n" +
            "    \"userId\": \"User2\"\n" + // no comma on this line as error
            "    \"course\": \"Spyglass\",\n" +
            "    \"date\": \"20-01-2020\",\n" +
            "    \"score\": 90,\n" +
            "    \"fairwayPercentage\": 55,\n" +
            "    \"greenPercentage\": 45,\n" +
            "    \"numberOfPutts\": 38,\n" +
            "    \"notes\": \"bad pace control on putts\"\n" +
            "}";

        Assertions.assertThrows(RuntimeException.class, () -> {
            JsonUtils.fromJson(invalidJson);
        });
    }

}
