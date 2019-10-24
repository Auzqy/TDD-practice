package top.auzqy.args.test03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description:  容许自定义的 schema
 * createTime: 2019-10-24 17:25
 * @author au
 */
public class Schemas {
    Map<String, String> schemas;

    public Schemas(String schemaConfig) {
        schemas = new HashMap<>();
        Arrays.asList(schemaConfig.split(","))
                .forEach(flag -> {
                    String[] nameValue = flag.split(":");
                    schemas.put(nameValue[0].substring(1), nameValue[1]);
                });
    }

    public Object getValue(String paraName, String paraValue) {
        String type = schemas.get(paraName);
        switch (type) {
            case "bool":
                return "true".equalsIgnoreCase(paraValue);
            default:
                return paraValue;
        }
    }
}
