package study.spark.handler;

import spark.Request;
import spark.Response;
import spark.Route;
import study.spark.Answer;
import study.spark.Validable;
import study.spark.utils.JsonUtils;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:41
 */
public abstract class AbstractRequestHandler<V extends Validable> implements RequestHandler<V>, Route {

    private final Class<V> valueClass;
    private static final int HTTP_BAD_REQUEST = 400;

    AbstractRequestHandler() {
        this.valueClass = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public final Answer process(V value, Map<String, String> queryParams) {
        if (value != null && !value.isValid()) {
            return new Answer(HTTP_BAD_REQUEST);
        } else {
            return processImpl(value, queryParams);
        }
    }

    protected abstract Answer processImpl(V value, Map<String, String> queryParams);

    @Override
    public Object handle(Request request, Response response) {
        V value = JsonUtils.convertJson(request.body(), valueClass);
        Map<String, String> queryParams = new HashMap<>();
        Answer answer = process(value, queryParams);
        response.status(answer.getCode());
        response.type("application/json");
        response.body(answer.getBody());
        return answer.getBody();
    }
}
