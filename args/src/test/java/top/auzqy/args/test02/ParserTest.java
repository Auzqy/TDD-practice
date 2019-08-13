package top.auzqy.args.test02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  args 项目测试类
 *
 *
 *          输入：
 *              "-l -p 8080 -d /usr/local"
 *          输出：
 *              解析后的参数及其值
 *              eg. -l : true
 *                  -p : 8080
 *          任务清单：
 *              1. 依据不同的输入，解析出对应的 schema 对象
 *              2. 创建一个解析器，可以依据不同的 Schema 和 inputStr 解析出对应的参数和值
 *
 *
 * createTime: 2019-08-13 19:19
 * @author au
 */
public class ParserTest {

    /**
     * description:  依据不同的输入，解析出对应的 schema 对象
     *              正常的参数输入的解析情况
     * createTime: 2019-08-13 19:46
     * @author au
     * @param structureDefineStr    定义参数解析结构的字符串
     * @param cliParam      命令行参数
     * @param paramType     命令行参数所属的类型
     * @param defaultValue  命令行参数的默认值
     */
    @ParameterizedTest
    @CsvSource({
//            "-l:boolean:false -p:integer:8080 -d:string:, -l, boolean, false",
//            "-l:boolean:false -p:integer:8080 -d:string:, -d, string, ''",
            "-l:false:boolean -p:8080:integer -d::string, -l, boolean, false",
            "-l:false:boolean -p:8080:integer -d::string, -d, string, ''",
    })
    void shouldReturnCorrectSchema(String structureDefineStr,
                                   String cliParam,
                                   String paramType,
                                   String defaultValue) throws Exception {
        ParserSchema schema = new ParserSchema(structureDefineStr);
        Assertions.assertEquals(cliParam, schema.getCliParam(cliParam));
        Assertions.assertEquals(paramType, schema.getCliParamType(cliParam));
        Assertions.assertEquals(defaultValue, schema.getDefaultValue(cliParam));
    }

    /**
     * description:  依据不同的输入，解析出对应的 schema 对象
     *          异常的参数输入的解析情况
     * createTime: 2019-08-13 20:17
     * @author au
     * @param structureDefineStr    定义参数解析结构的字符串
     * @param cliParam      命令行参数
     * @param paramType     命令行参数所属的类型
     * @param defaultValue  命令行参数的默认值
     */
    @ParameterizedTest
    @CsvSource({
            "-l:false:boolean -p:8080:integer -d::string, -s, string, ''",
    })
    void shouldThrowExceptionSchema(String structureDefineStr,
                                   String cliParam,
                                   String paramType,
                                   String defaultValue) throws Exception {
        ParserSchema schema = new ParserSchema(structureDefineStr);
        Assertions.assertThrows(UndefinedSchemaException.class,()->{
            //1：执行此语句会抛出一个 UndefinedSchemaException 异常，被assertThrows方法捕获
            schema.getDefaultValue(cliParam);
        },"当前不支持 " + cliParam +"类型的参数，请检查后再输入！");
    }

    /**
     * description:
     * createTime: 2019-08-13 23:26
     * @author au
     * @param structureDefineStr    定义参数解析结构的字符串
     * @param args    定义参数解析结构的字符串
     * @param cliParam      命令行参数
     * @param cliParamValue 命令行参数的实际值
     * @throws Exception
     */
    @ParameterizedTest
    @CsvSource({
        "-l:false:boolean -p:8080:integer -d::string, -l -p 8081 -d /usr/local, -l, true",
        "-l:false:boolean -p:8080:integer -d::string, -l -p 8081 -d /usr/local, -p, 8081",
        "-l:false:boolean -p:8080:integer -d::string, -l -p 8081 -d /usr/local, -d, /usr/local",
        "-l:false:boolean -p:8080:integer -d::string, -p 8081 -d /usr/local, -l, false", // 没有设置就取默认值
        "-l:false:boolean -p:8080:integer -d::string, '', -p, 8080", // 没有设置就取默认值
        "-l:false:boolean -p:8080:integer -d::string, '', -d, ''", // 没有设置就取默认值
        "-l:false:boolean -p:8080:integer -d::string, , -p, 8080", // 没有设置就取默认值
        "-l:false:boolean -p:8080:integer -d::string, , -d, ''", // 没有设置就取默认值
    })
    void shouldReturnCorrectArgs(String structureDefineStr,
                                 String args,
                                 String cliParam,
                                 String cliParamValue) throws Exception {
        MyParser myparser = new MyParser(new ParserSchema(structureDefineStr), args);
        Assertions.assertEquals(cliParamValue, myparser.getParamValue(cliParam));
    }

    /**
     * description:  命令行传入的参数符合参数结构，但是获取不合法的参数值，应该抛出异常
     * createTime: 2019-08-13 23:23
     * @author au
     * @param structureDefineStr    定义参数解析结构的字符串
     * @param args    定义参数解析结构的字符串
     * @param cliParam      命令行参数
     * @throws Exception
     */
    @ParameterizedTest
    @CsvSource({
        "-l:false:boolean -p:8080:integer -d::string, -l -p 8081 -d /usr/local, -s",
        "-l:false:boolean -p:8080:integer -d::string, , -m", // 没有设置就取默认值
        "-l:false:boolean -p:8080:integer -d::string, , -q", // 没有设置就取默认值
    })
    void shouldThrowExceptionArgs(String structureDefineStr,
                                 String args,
                                 String cliParam) throws Exception {
        MyParser myparser = new MyParser(new ParserSchema(structureDefineStr), args);
        Assertions.assertThrows(UndefinedSchemaException.class,()->{
            //1：执行此语句会抛出一个 UndefinedSchemaException 异常，被assertThrows方法捕获
            myparser.getParamValue(cliParam);
        },"当前不支持 " + cliParam +"类型的参数，请检查后再输入！");
    }

    /**
     * description:  命令行参数传递与参数结构规定的不符
     * createTime: 2019-08-13 23:20
     * @author au
     * @param structureDefineStr    定义参数解析结构的字符串
     * @param args    定义参数解析结构的字符串
     * @param cliParam      命令行参数
     * @throws Exception
     */
    @ParameterizedTest
    @CsvSource({
        "-l:false:boolean -p:8080:integer -d::string, -l -p 8081 -e /usr/local, -e",
        "-l:false:boolean -p:8080:integer -d::string, -s -p 8081 -e /usr/local, -s",
    })
    void shouldThrowExceptionArgsNonUndefinedArgs(String structureDefineStr,
                                 String args,
                                 String cliParam) throws Exception {
        Assertions.assertThrows(UndefinedSchemaException.class,()->{
            //1：执行此语句会抛出一个 UndefinedSchemaException 异常，被assertThrows方法捕获
            new MyParser(new ParserSchema(structureDefineStr), args);
        },"当前不支持 " + cliParam +"类型的参数，请检查后再输入！");
    }

    @ParameterizedTest
    @CsvSource({
            "-w, true",
            "-p, true",
            "-ll, true",
            "-9, false",
            "as, false"
    })
    void shouldRegex(String str, boolean flag) {
        Assertions.assertEquals(flag, str.matches("-[a-z]+"));
    }
}
