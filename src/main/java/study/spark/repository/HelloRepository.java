package study.spark.repository;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex Rosa</a>
 * @since 19/07/2023 11:10
 */
@UtilityClass
public class HelloRepository {

    private static final Set<String> hellos = new HashSet<>();

    public void save(String name) {
        hellos.add(name);
    }

    public Set<String> fetchAll() {
        return hellos;
    }

    public void deleteAll() {
        hellos.clear();
    }
}
