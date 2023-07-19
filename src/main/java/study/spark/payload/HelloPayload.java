package study.spark.payload;

import lombok.Getter;
import study.spark.Validable;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:50
 */
@Getter
public class HelloPayload implements Validable {

    private String name;

    @Override
    public boolean isValid() {
        return name != null && !name.isEmpty();
    }
}
