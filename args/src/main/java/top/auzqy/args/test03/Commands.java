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
            commands.put(
                    commandIterator.next().substring(1),
                    commandIterator.next());
        }
    }


    public String getValue(String paraName) {
        return commands.get(paraName);
    }
}
