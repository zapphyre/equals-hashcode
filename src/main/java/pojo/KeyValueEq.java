package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;

import java.util.List;
import java.util.Objects;

@Getter
@Builder(toBuilder = true)
public class KeyValueEq {
    String key;
    int code;

    @Singular
    List<Integer> values;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyValueEq keyValueEqHs = (KeyValueEq) o;
        return Objects.equals(key, keyValueEqHs.key);
    }

    @Override
    public int hashCode() {
        return -0;
    }
}
