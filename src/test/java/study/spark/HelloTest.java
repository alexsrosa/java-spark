package study.spark;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import study.spark.repository.HelloRepository;
import study.spark.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spark.Spark.awaitInitialization;
import static spark.Spark.stop;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:20
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HelloTest {

    @BeforeAll
    void setUp() {
        Routes.establishRoutes();
        awaitInitialization();

        HelloRepository.deleteAll();
    }

    @AfterAll
    void tearDown() {
        stop();
    }

    @Test
    void Given_GetHello_When_NotExistsHellos_Then_ResultOkAndEmptyList() {
        ApiTestUtils.TestResponse res = ApiTestUtils.request("GET", "/hello", null);
        assert res != null;
        assertEquals(200, res.status);
        assertEquals(Collections.emptyList(), JsonUtils.convertJson(res.body, ArrayList.class));
    }

    @Test
    @Disabled
    void Given_PostHello_When_WantToAddNewHello_Then_ResultOkAndAfterFoundHello() {
        ApiTestUtils.TestResponse res = ApiTestUtils.request("POST", "/hello", "{\"name\":\"Alex\"}");
        assert res != null;
        assertEquals(200, res.status);
        assertEquals("Hello for Alex was added", res.body);
    }

}