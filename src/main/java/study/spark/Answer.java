package study.spark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 09:29
 */
@AllArgsConstructor
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Answer {

    private int code;
    private String body;

    public Answer(int code) {
        this.code = code;
        this.body = "";
    }

    public static Answer ok(String body) {
        return new Answer(200, body);
    }

    public static Answer created(String body) {
        return new Answer(201, body);
    }
}
