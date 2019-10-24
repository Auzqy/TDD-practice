package top.auzqy.args.test03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

//    @ParameterizedTest
//    @CsvSource({
//            "-l:boolean -p:integer -d:string, -l, boolean, false",
//            "-l:boolean -p:integer -d:string, -d, string, ''",
//    })
//    void should() {
//
//    }
}
