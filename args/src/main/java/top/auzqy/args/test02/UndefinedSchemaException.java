package top.auzqy.args.test02;

/**
 * description:  为定义的 schema 类型的异常
 * createTime: 2019-08-13 20:40
 * @author au
 */
public class UndefinedSchemaException extends Exception {

    public UndefinedSchemaException() {
    }

    public UndefinedSchemaException(String message) {
        // 把参数传递给Throwable的带String参数的构造方法
        super(message);
    }
}
