package top.auzqy.args.test03;

public class Args {

    private Schemas schema;
    private Commands command;

    public Args(String schema, String command) {
        this.schema = new Schemas(schema);
        this.command = new Commands(command);
    }

    public Object getValue(String paraName) {
        return schema.getValue(paraName,command.getValue(paraName));
    }
}
