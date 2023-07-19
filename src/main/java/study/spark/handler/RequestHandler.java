package study.spark.handler;

import study.spark.Answer;
import study.spark.Validable;

import java.util.Map;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:26
 */
public interface RequestHandler<V extends Validable> {

    Answer process(V value, Map<String, String> urlParams);
}
