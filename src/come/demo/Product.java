package come.demo;

public class Product
{
    private String pname;
    private int pno;
    private int price;
    private String brand;

    public Product(String pname,int pno,int price,String brand)
    {
        this.pname = pname;
        this.pno = pno;
        this.price = price;
        this.brand = brand;
    }
    public Product()
    {

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
