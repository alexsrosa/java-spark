package study.spark.model;

import java.util.List;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:49
 */
public interface HelloModel {

    String createHello(String name);

    boolean deleteHelloByName(String name);

    List<String> getHellos();
}
