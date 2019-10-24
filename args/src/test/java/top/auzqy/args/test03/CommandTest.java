package top.auzqy.args.test03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CommandTest {
    
    static Stream<Arguments> command_excepted_paraName_paraValue() {
        return Stream.of(
                Arguments.of("-l -p 8081 -d /usr/local", true, "l"),
                Arguments.of("-l true -p 8081 -d /usr/local", true, "l")
//                Arguments.of("-l true -p 8081 -d /usr/local", 8081, "p")
        );
    }
    
    @ParameterizedTest
    @MethodSource("command_excepted_paraName_paraValue")
    void should_command_excepted_paraName_paraValue(
            String command, Object expected,
            String paraName) {
//        Commands commands = new Commands(command);
//        Assertions.assertEquals(expected,commands.getValue(paraName));
    }
}
