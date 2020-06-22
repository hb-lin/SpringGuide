package entity;

/**
 * java反射测试entity
 * @author linhb
 * @create 2019-09-10
 */
public class TestEntity extends BaseEntity{

    private String name;

    private String privateName;

    public String publicName;

    String defaultName;

    protected String protectedName;

    public TestEntity() {
        System.out.println("构造testEntity");
    }

    public TestEntity(String name, String privateName, String publicName, String defaultName, String protectedName) {
        System.out.println("带参构造testEntity");
        this.name = name;
        this.privateName = privateName;
        this.publicName = publicName;
        this.defaultName = defaultName;
        this.protectedName = protectedName;
    }

    private String privateMethod(){
        return "private";
    }

    public String publicMethod(){
        return "public";
    }


    String defaultMethod(){
        return "default";
    }

    protected String protectedMethod(){
        return "protected";
    }
}
