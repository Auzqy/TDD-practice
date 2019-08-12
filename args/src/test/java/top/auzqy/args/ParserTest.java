package top.auzqy.args;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  参数解析器
 *      任务清单：
 *          1。 参数结构（schema）
 *              可以定义成抽象接口，找个Map<Enum,Schema> （这样的话对扩展开放）
 *              1.1 依据如参可以找到对应的类型，如果没哟给个对应
 *                  的错误提示（这一点题目没要求，属于画蛇添足）;
 *                  如果找到，则返回对应的该类型;
 *          2。 todo 参数解析
 *              2.1 入参，String[], 以空格截取
 *              2.2 遍历参数结构的 key，找一个新的结构去存储实际传进来的参数
 *              2.3 如果参数结构不匹配，那么给出友好的错误提示
 *
 *
 * createTime: 2019-08-12 14:54
 * @author au
 */
public class ParserTest {

    private AbstractParserSchema parseSchema;

    @ParameterizedTest
    @CsvSource({
            "-p, port",
            "-l, logging",
            "-d, directory"
    })
    void shouldReturnCorrectSubClassOfSchema(String param, String className) {
        Assertions.assertEquals(className,
                parseSchema.getSimpleClassNameByParam(param));
    }
}
