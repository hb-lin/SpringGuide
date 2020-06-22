package entity;

/**
 * @author linhb
 * @create 2019-09-10
 */
public class BaseEntity {

    private String privateGuid;

    public String publicGuid;

    String defaultGuid;

    protected String protectedGuid;

    public BaseEntity() {
        System.out.println("构造BaseEntity");
    }

    public BaseEntity(String privateGuid, String publicGuid, String defaultGuid, String protectedGuid) {
        System.out.println("带参构造BaseEntity");
        this.privateGuid = privateGuid;
        this.publicGuid = publicGuid;
        this.defaultGuid = defaultGuid;
        this.protectedGuid = protectedGuid;
    }

    private String getPrivateGuid(){
        return "private";
    }

    public String getublicGuidP(){
        return "public";
    }

    String getDefaultGuid(){
        return "default";
    }

    protected String getProtectedGuid(){
        return "protected";
    }
}
