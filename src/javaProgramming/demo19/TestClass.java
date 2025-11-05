package javaProgramming.demo19;

public class TestClass {
    private String privateField;       // 私有属性
    protected int protectedField;      // 保护属性
    String defaultField;               // 默认访问权限属性（无修饰符）
    public boolean publicField;         // 公有属性
    public static final String STATIC_FIELD = "静态常量"; // 静态+常量属性

    public TestClass() {}

    public void publicMethod() {}                          // 公有无参方法
    private String privateMethod(int param) { return ""; } // 私有带参方法（有返回值）
    protected void protectedMethod(String param1, boolean param2) {} // 保护带多参数方法
    void defaultMethod() {}                               // 默认访问权限方法
    public static void staticMethod() {}                   // 静态方法
}
