package top.auzqy.args;

import java.util.HashMap;
import java.util.Map;

/**
 * description:  用于解析器的参数结构
 * createTime: 2019-08-12 15:19
 * @author au
 */
public abstract class AbstractParserSchema {

    private static Map<String, AbstractParserSchema> parserSchemaMap = new HashMap<>();

    /**
     * description:
     *          todo 这里是不是可以再智能的自动化一点，
     *              比如拿到他的所有子类，然后自动的初始化，
     *              key 呢如果重复就多加一位字母
     * createTime: 2019-08-12 15:33
     * @author au
     */
    static {
        parserSchemaMap.put("-p", new PortSchema());
//        parserSchemaMap.put("-l", new LoggingSchema());
//        parserSchemaMap.put("-d", new DirectorySchema());
    }

    String getSimpleClassNameByParam(String param){
        AbstractParserSchema abstractParserSchema = parserSchemaMap.get(param);
        if (null != abstractParserSchema) {
            return abstractParserSchema.getClass().getSimpleName();
        } else {
            return "您输入的参数：" + param + "无效";
        }
    };
}
