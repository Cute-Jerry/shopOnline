package come.demo;

public class Order
{
    private String pname;
    private int pno;
    private int price;
    private String brand;
    private String uno;
    public Order(String pname,int pno,int price,String brand,String uno)
    {
        this.pname = pname;
        this.pno = pno;
        this.price = price;
        this.brand = brand;
        this.uno = uno;
    }

    public Order()
    {

    }

    public void setUno(String uno)
    {
        this.uno = uno;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUno() {
        return uno;
    }

    public int getPno() {
        return pno;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getPname() {
        return pname;
    }
}
