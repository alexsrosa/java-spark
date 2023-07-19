package study.spark.handler;

import study.spark.Answer;
import study.spark.payload.HelloPayload;
import study.spark.repository.HelloRepository;

import java.util.Map;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:49
 */
public class PostHelloHandler extends AbstractRequestHandler<HelloPayload> {

    @Override
    protected Answer processImpl(HelloPayload value, Map<String, String> queryParams) {
        HelloRepository.save(value.getName());
        return Answer.created(String.format("Hello for %s was added", value.getName()));
    }
}
