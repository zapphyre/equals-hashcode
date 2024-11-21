package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Getter
@Builder(toBuilder = true)
public class KeyValue {
    String key;
    int code;

    @Singular
    List<Integer> values;
}
