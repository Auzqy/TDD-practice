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
                Arguments.of("l:bool",true,"l","true"),
                Arguments.of("l:bool",false,"l","false"),
                Arguments.of("l:bool",false,"l",null),

                Arguments.of("l:int","1","l","1"),
                Arguments.of("l:int","-9","l","-9"),

                Arguments.of("l:str","abc","l","abc")
        );
    }

    @ParameterizedTest
    @MethodSource("schema_expected_paraName_paraValue")
//    void should_(String schema, String expected,
//                 String paraName, String paraValue) {
    void should_(String schema, Object expected,
                 String paraName, String paraValue) {
        Schemas schemas = new Schemas(schema);
        /*
            其实测试不光是测值，同时也是测类型
            这种 toString() 的方式是达不到
            这种目的的
         */
//        Assertions.assertEquals(expected,
//                schemas.getValue(paraName,paraValue).toString());
        Assertions.assertEquals(expected,
                schemas.getValue(paraName,paraValue));
    }
}
