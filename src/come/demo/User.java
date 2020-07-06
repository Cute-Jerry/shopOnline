package come.demo;

import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter;

public class User
{
    private String user_name;
    private String uno;
    private String password;
    private String telephone;
    private String address;
    public User(String user_name, String uno, String password, String telephone, String address)
    {
        this.user_name = user_name;
        this.uno = uno;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
    }
    public User()
    {

    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUno() {
        return uno;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }
}
