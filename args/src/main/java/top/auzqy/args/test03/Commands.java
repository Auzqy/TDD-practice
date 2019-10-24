package top.auzqy.args.test03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/**
 * description:  命令行参数解析
 * createTime: 2019-10-24 18:19
 * @author au
 */
public class Commands {
    Map<String, String> commands;

    public Commands(String commandLine) {
        commands = new HashMap<>();
        ListIterator<String> commandIterator =
                Arrays.asList(commandLine.split("\\s+"))
                        .listIterator();
        while (commandIterator.hasNext()) {
            String name = commandIterator.next().substring(1);
            if (commandIterator.hasNext()) {
                String value = commandIterator.next();
                if (isValue(value)) {
                    commands.put(name, value);
                } else {
                    commandIterator.previous();
                }
            }
        }

        // 处理 bool 默认值的情况
        String boolValue = commands.get("l");
        if (null == boolValue) {
            commands.put("l", "true");
        }
    }

    private boolean isValue(String value) {
        if (value.charAt(0) == '-') {
            if (value.length() > 2) {
                return true;
            }
            if(value.charAt(1) >= '0' && value.charAt(1) >= '9'){
                return true;
            }
            return false;
        }
        return true;
    }


    public String getValue(String paraName) {
        return commands.get(paraName);
    }
}
