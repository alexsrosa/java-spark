package study.spark.handler;

import study.spark.Answer;
import study.spark.payload.HelloPayload;
import study.spark.repository.HelloRepository;
import study.spark.utils.JsonUtils;

import java.util.Map;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:49
 */
public class GetAllHelloHandler extends AbstractRequestHandler<HelloPayload> {

    @Override
    protected Answer processImpl(HelloPayload value, Map<String, String> queryParams) {
        return Answer.ok(JsonUtils.dataToJson(HelloRepository.fetchAll()));
    }
}
