package top.auzqy.args.test04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SchemaTest {

    static Stream<Arguments> typeExpected_flagInput_stringSchema() {
        String schemaTestcase1 = "l:bool p:int d:str";
        return Stream.of(
                Arguments.of(Boolean.class,"l",schemaTestcase1),
                Arguments.of(Integer.class,"p",schemaTestcase1),
                Arguments.of(String.class,"d",schemaTestcase1)
        );
    }

    @ParameterizedTest
    @MethodSource("typeExpected_flagInput_stringSchema")
    void should_return_current_type(Object expected,
                                    String flag,
                                    String schemaStr) {
        Schema schema = new Schema(schemaStr);
        Assertions.assertEquals(expected, schema.getType(flag));
    }
}
