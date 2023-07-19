package study.spark.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.StringWriter;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 11:38
 */
@UtilityClass
public class JsonUtils {

    private final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String dataToJson(Object data) {
        try {
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, data);
            return sw.toString();
        } catch (IOException e) {
            throw new RuntimeException("IOException from a StringWriter?");
        }
    }

    public <V> V convertJson(String body, Class<V> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();

        V value = null;
        try {
            value = objectMapper.readValue(body, clazz);
        } catch (Exception ignored) {
        }
        return value;
    }
}
