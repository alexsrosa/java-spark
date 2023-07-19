package study.spark;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import study.spark.handler.GetAllHelloHandler;
import study.spark.handler.PostHelloHandler;

import static spark.Spark.get;
import static spark.Spark.initExceptionHandler;
import static spark.Spark.post;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 11:57
 */
@Slf4j
@UtilityClass
public class Routes {

    public void establishRoutes() {
        initExceptionHandler(e -> log.error("ignite failed"));

        get("/hello/:name", (req, res) -> "Hello " + req.params(":name"));

        get("/hello", new GetAllHelloHandler());
        post("/hello", new PostHelloHandler());
    }
}
