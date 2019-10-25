package top.auzqy.args.test03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * description:  args 总体目标test
 * createTime: 2019-10-24 16:32
 * @author au
 */
public class ArgsTest {

    static Stream<Arguments> schema_command_expected_paraName_provider() {
        return Stream.of(
                Arguments.of("l:bool p:int d:str",
                        "-l -p 8081 -d /usr/local", true, "l"),
                Arguments.of("l:bool p:int d:str",
                        "-l -p 8081 -d /usr/local", "8081", "p"),
                Arguments.of("l:bool p:int d:str",
                        "-l -p 8081 -d /usr/local", "/usr/local", "d")

//                Arguments.of("-l:boolean -p:integer -d:string",
//                        "-l -p -9 -d /usr/local"),
//                Arguments.of("-l:boolean -p:integer -d:string",
//                        "-l false -p 8081 -d /usr/todo")
        );
    }

    @ParameterizedTest
    @MethodSource("schema_command_expected_paraName_provider")
    void should(String schema, String command,
                Object expected, String paraName) {
        Args args = new Args(schema, command);
        Assertions.assertEquals(expected,args.getValue(paraName));
    }

}
