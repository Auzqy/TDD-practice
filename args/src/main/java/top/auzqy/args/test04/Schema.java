package top.auzqy.args.test04;

import java.util.HashMap;
import java.util.Map;

public class Schema {
    private Map<String, String> schemaMap;

    public Schema(String schemaStr) {
        schemaMap = new HashMap();
        String[] schemaPair = schemaStr.split(" ");
        for (String itemSchema : schemaPair) {
            String[] s = itemSchema.split(":");
            schemaMap.put(s[0], s[1]);
        }
    }

    public Object getType(String flag) {
        String type = schemaMap.get(flag);
        switch (type) {
            case "bool":
                return Boolean.class;
            case "int":
                return Integer.class;
            case "str":
                return String.class;
            default:
                return Object.class;
        }
    }
}
