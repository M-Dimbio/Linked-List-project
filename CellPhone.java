import java.util.Scanner;
public class CellPhone implements Cloneable2
{
    private long serialNumber;
    private String brand;
    private int year;
    private double price;
    public CellPhone ()
    {
        this.serialNumber=0;
        this.brand= "null";
        this.year=0;
        this.price=0;
    }
    public CellPhone(long serialNumber, String brand,int year,double price)
    {
        this.serialNumber=serialNumber;
        this.brand=brand;
        this.year=year;
        this.price=price;
    }
    public CellPhone(CellPhone cellPhone,long serialNumber)
    {
        this.price=cellPhone.price;
        this.brand=cellPhone.brand;
        this.year=cellPhone.year;
        this.serialNumber=serialNumber;
    }


    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public long getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
//    public CellPhone clone(long serialNumber)
//    {
//        return new CellPhone(this,serialNumber);
//    }



    public String toString()
    {
         return "[" + serialNumber + ":" + brand + " " + price +"$ "+year+  "]---->";
    }


    public boolean equals(Object obj)
    {
        if (obj==null || obj.getClass()!=this.getClass() || this==null)
            return false;
        CellPhone c= (CellPhone)obj;
        if (this.year==c.year && this.price== c.price&& this.brand==c.brand)
            return true;
        else
            return false;
    }


    public CellPhone clone()
    {
        int sn;
        System.out.println("Enter your new Serial Number");
        Scanner kb=new Scanner(System.in);
        sn=kb.nextInt();
        if (sn==this.serialNumber)
        {
            System.out.println("Serial number is identical please enter a new Serial Number");
            clone();
        }

        return new CellPhone(this,sn);
    }
}
