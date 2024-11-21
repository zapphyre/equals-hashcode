package pojo;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.List;
import java.util.Objects;

@Value
@Builder
public class KeyValueEqHs {
    String key;
    int code;

    @Singular
    List<Integer> values;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValueEqHs keyValueEqHs = (KeyValueEqHs) o;
        return Objects.equals(key, keyValueEqHs.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}
