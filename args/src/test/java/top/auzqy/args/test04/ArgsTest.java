package top.auzqy.args.test04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArgsTest {
    
    static Stream<Arguments> valExpected_flagInput_SchemaInput_commandInput() {
        String schemaTestcase1 = "l:bool p:int d:str";

        String commandTestcase1 = "-l -p 8080 -d /usr/logs";
        String commandTestcase2 = "-l true -p -9 -d /usr/logs";
        return Stream.of(
                Arguments.of(false,"l", commandTestcase1, schemaTestcase1),
                Arguments.of(8080,"p", commandTestcase1, schemaTestcase1),
                Arguments.of("/usr/logs","d", commandTestcase1, schemaTestcase1),
                Arguments.of(true,"l", commandTestcase2, schemaTestcase1),
                Arguments.of(-9,"p", commandTestcase2, schemaTestcase1),
                Arguments.of("/usr/logs","d", commandTestcase2, schemaTestcase1)
        );
    }
    
    @ParameterizedTest
    @MethodSource("valExpected_flagInput_SchemaInput_commandInput")
    void should_(Object expected, String flag,
                 String commandStr, String schemaStr) {
        Args args = new Args(commandStr, schemaStr);
        Assertions.assertEquals(expected,args.getValue(flag));
    }
}
