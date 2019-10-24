package top.auzqy.args.test03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * description:  schema test
 * createTime: 2019-10-24 17:12
 * @author au
 */
public class SchemaTest {

    static Stream<Arguments> schema_expected_paraName_paraValue() {
        return Stream.of(
                Arguments.of("l:bool","true","l","true"),
                Arguments.of("l:bool","false","l","false"),
                Arguments.of("l:bool","true","l",null)
        );
    }
    
    @ParameterizedTest
    @MethodSource("schema_expected_paraName_paraValue")
    void should_(String schema, String expected,
                 String paraName, String paraValue) {
        Schemas schemas = new Schemas(schema);
//        Assertions.assertEquals(expected,schemas.getValue(paraName,paraValue));
    }
}
