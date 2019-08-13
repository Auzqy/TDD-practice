package top.auzqy.args.test02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:  解析器
 * createTime: 2019-08-13 21:56
 * @author au
 */
public class MyParser {

    private ParserSchema parserSchema;

    public MyParser(ParserSchema parserSchema, String args) throws UndefinedSchemaException {
        this.parserSchema = parserSchema;
        if (null != args) {
            String[] argsArr = args.trim().split(" ");
            if (argsArr.length > 0) {
                Pattern pattern;
                for (int i=0; i< argsArr.length;) {
                    String regex = "-[a-z]+";
                    boolean matches = argsArr[i].matches(regex);
                    // todo 还有一种都没有匹配上的情况没有处理
                    if (matches) {
                        ParserSchema.InnerSchema innerSchema = parserSchema.getInnerSchema(argsArr[i]);
                        // 该值后面跟的是另一个参数
                        if (argsArr[i + 1].matches(regex)) {
                            // 如果该值为 boolean 那么该值设置为 true
                            if ("boolean".equalsIgnoreCase(innerSchema.getCliType())) {
                                innerSchema.setCliParamValue("true");
                            } else {
                                innerSchema.setCliParamValue(innerSchema.getCliDefaultValue());
                            }
                            i++;
                        } else { // todo 这里没有校验 argsArr[i + 1] 类型
                            innerSchema.setCliParamValue(argsArr[i + 1]);
                            i += 2;
                        }
                    } else {
                        i++;
                    }
                }
            }
        }

    }

    public String getParamValue(String cliParam) throws UndefinedSchemaException {
        return parserSchema.getInnerSchema(cliParam).getCliParamValue();
    }
}
