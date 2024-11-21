import org.junit.jupiter.api.Test;
import pojo.KeyValue;
import pojo.KeyValueEq;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EqualsAndHashcodeTest {

    private static final String MAP_VALUE = "mapValue";

    @Test
    void givenNoEqualsAndHashcodeImplemented_elementCanOnlyBeFoundByCreatingInstance() {
        // Given
        KeyValue first = KeyValue.builder()
                .key("some")
                .build();

        KeyValue second = first.toBuilder().build();

        // When
        Map<KeyValue, String> kvMap = new HashMap<>();
        kvMap.put(first, MAP_VALUE);

        // Then
        // memory references anr not the same; different objects
        assertNotSame(first, second);

        // only set field is equal in both instances
        assertEquals(first.getKey(), second.getKey());

        // we can get the value from the map by same object instance we used during put
        assertNotNull(kvMap.get(first));

        // we cannot get the value if object is different without equals
        assertNull(kvMap.get(second));
    }

    @Test
    void givenEqualsImplementedAndHashcodeNot_weCanGetValueByDifferentObjectLogicallyEqualWithoutHashcode() {
        // Given
        KeyValueEq first = KeyValueEq.builder()
                .key("key").value(4).code(3)
                .build();

        KeyValueEq second = first.toBuilder()
                .value(9).code(8)
                .build();

        // When
        Map<KeyValueEq, String> kvMap = new HashMap<>();
        kvMap.put(first, MAP_VALUE);

        // Then
        // different memory references
        assertNotSame(first, second);

        // same logical objects
        assertEquals(first, second);

        // can get a value by instance that was used during a put
        assertNotNull(kvMap.get(first));

        // can get a value by logically equal key with hardcoded harshCode impl
        assertNotNull(kvMap.get(second));
    }

    @Test
    void givenHashCodeEqualsImplemented_lookupIsPerformant() {
//        ...
    }
}
