package top.auzqy.args.test03;

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

    @Test
    void onlyForPass() {
        System.out.println("pass");
    }

    static Stream<Arguments> schemaAndCommandProvider() {
        return Stream.of(
                Arguments.of("-l:boolean -p:integer -d:string",
                        "-l -p 8081 -d /usr/local"),
                Arguments.of("-l:boolean -p:integer -d:string",
                        "-l -p -9 -d /usr/local"),
                Arguments.of("-l:boolean -p:integer -d:string",
                        "-l false -p 8081 -d /usr/todo")
        );
    }

    @ParameterizedTest
    @MethodSource("schemaAndCommandProvider")
    void should(String schema, String command) {
        System.out.println(schema + command);
    }

}
