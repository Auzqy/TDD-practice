package top.auzqy.args.test03;

import java.util.HashMap;
import java.util.Map;

/**
 * description:  容许自定义的 schema
 * createTime: 2019-10-24 17:25
 * @author au
 */
public class Schemas {
    Map<String, String> schemas;

    public Schemas(String schema) {
        schemas = new HashMap<>();

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
