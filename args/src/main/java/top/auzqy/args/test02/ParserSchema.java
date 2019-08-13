package top.auzqy.args.test02;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * description:  参数解析器的参数结构类
 * createTime: 2019-08-13 20:20
 *
 * @author au
 */
public class ParserSchema {

    // todo 这种格式的解析再想想
//    private static final String DEFAULT_STRUCTURE_STR = "-l:boolean:false -p:integer:8080 -d:string:";

    private static final String DEFAULT_STRUCTURE_STR = "-l:false:boolean -p:8080:integer -d::string";

    private Map<String,InnerSchema> innerSchemaMap;

    public ParserSchema() throws Exception {
        this(DEFAULT_STRUCTURE_STR);
    }

    public ParserSchema(String structureDefineStr) throws Exception {
        String[] schemaArrays = structureDefineStr.split(" ");
        if (schemaArrays.length == 0) {
            throw new Exception("参数结构定义不正确，请按照如下格式定义（中间已一个空格间隔）：" + DEFAULT_STRUCTURE_STR);
        }
        innerSchemaMap = new HashMap<>();
        for (String schema : schemaArrays) {
            String[] schemaArr = schema.split(":");
            if (3 != schemaArr.length) {
                throw new Exception("参数结构定义不正确，" +
                        "请按照如下格式定义（-参数名:参数类型:默认的参数值）,eg. -l:false:boolean");
            }
            InnerSchema innerSchema = new InnerSchema(schemaArr);
            innerSchemaMap.put(schemaArr[0], innerSchema);
        }
    }

    public Map<String, InnerSchema> getInnerSchemaMap() {
        return innerSchemaMap;
    }

    public String getCliParam(String cliParam) throws UndefinedSchemaException {
        return getInnerSchema(cliParam).getCliParam();
    }

    public String getCliParamType(String cliParam) throws UndefinedSchemaException {
        return getInnerSchema(cliParam).getCliType();
    }

    public String getDefaultValue(String cliParam) throws UndefinedSchemaException{
        return getInnerSchema(cliParam).getCliDefaultValue();
    }

    public InnerSchema getInnerSchema(String cliParam) throws UndefinedSchemaException {
        InnerSchema innerSchema = innerSchemaMap.get(cliParam);
        if (null == innerSchema) {
            throw new UndefinedSchemaException("当前不支持 " + cliParam +"类型的参数，请检查后再输入！");
        }
        return innerSchema;
    }

    static class InnerSchema {
        private String cliParam;
        private String cliType;
        private String cliDefaultValue;
        private String cliParamValue;
        InnerSchema(String[] schemaArr) {
            this.cliParam = schemaArr[0];
            this.cliDefaultValue = schemaArr[1];
            this.cliType = schemaArr[2];
            this.cliParamValue = schemaArr[1]; // 将初始值设置为默认值
        }

        public String getCliParam() {
            return cliParam;
        }

        public String getCliType() {
            return cliType;
        }

        public String getCliDefaultValue() {
            return cliDefaultValue;
        }

        public String getCliParamValue() {
            return cliParamValue;
        }

        public void setCliParamValue(String cliParamValue) {
            this.cliParamValue = cliParamValue;
        }
    }
}
