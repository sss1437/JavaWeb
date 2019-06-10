package read;

/**
 * @Description: javabean
 * @Author: zdd
 * @Date: 2019/6/9
 */

/**
 * javabean
 *         1)当前类是一个具体类
 *         2）在类中提供私有的字段（属性）private String id(id字段属性)
 *         3）提供对外的公共方法setxxx/getxxx/isxxx
 *         public void setId（）/getId（）
 *         将Id的首字母小写；id（bean的属性）
 *         4）类实现序列化接口：serializable接口（jdk大量的常用类：String。。。）
 */
public class Contact {
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String emile;
    private String address;

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", emile='" + emile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmile() {
        return emile;
    }

    public void setEmile(String emile) {
        this.emile = emile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
