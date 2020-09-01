import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.ArrayList;
public class CellListUtilization
{
    public static void main(String[] args)
    {
        ArrayList<Long> serialArray= new ArrayList();
        Long serialNumber;
        CellList c1=new CellList();
        CellList c2=new CellList();
        Scanner kb= new Scanner (System.in);
        Scanner sc;
        PrintWriter pw;
        try
        {
            kb= new Scanner(System.in);
            sc = new Scanner(new FileInputStream("Cell_Info.txt"));
            while (sc.hasNext())
            {
                long sn= sc.nextLong();
                String brand= sc.next();
                double price=sc.nextDouble();
                int year =sc.nextInt();
                if (!c1.contains(sn))
                {
                    c1.addToStart(new CellPhone(sn, brand, year, price));
                    c2.addToStart(new CellPhone(sn, brand, year, price));
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file either doesn't exist or is corrupted.");
        }
        c1.showContents();
        System.out.println();
        System.out.println("Insert a serial number: ");
        serialNumber = kb.nextLong();
        c1.find(serialNumber);

        System.out.println(c1.equals(c2));
        System.out.println();
        System.out.println("************Testing multiple serial numbers************* ");
        System.out.println();

        long breaker = 0;
        System.out.println("Please enter all your serial numbers and enter -1 when you are done. ");

        while (breaker != -1) {
            breaker = kb.nextLong();
            if (breaker != -1)
                serialArray.add(breaker);

        }

        for (int i = 0; i < serialArray.size(); i++) {
            c1.find(serialArray.get(i));
        }

        System.out.println(
                "*******************************************************************************************************");

        CellPhone cell1 = new CellPhone(72637, "acer", 2018, 467.90);
        CellPhone cell2 = cell1.clone();

        // Testing clone() method of CellPhone:
        System.out.println(cell1 + "*********\n" + cell2);

        System.out.println();
        System.out.println(
                "*******************************************************************************************************");

//		CellList c3 = new CellList();
//		CellList c4 = new CellList(c1);
//
//		c3.showContents();
//		c4.showContents();

        System.out.println(
                "*******************************************InsertAtIndex() method*******************************************************");
        c1.insertAtIndex(cell1, 0);
        c1.showContents();
        System.out.println(
                "*************************************************************************************************************************");
        System.out.println();
        System.out.println(
                "******************************************DeleteFromIndex() method*********************************************************************************");
        c2.deleteFromIndex(22);
        c2.showContents();
        System.out.println(
                "***************************************************************************************************************************");
        System.out.println();

        System.out.println(
                "******************************************DeleteFromStart() method*********************************************************************************");
        c2.deleteFromStart();
        c2.showContents();
        System.out.println(
                "**********************************************************************************************************************");
        System.out.println();
        System.out.println(
                "******************************************replaceAtIndex() method*********************************************************************************");
        c2.replaceAtIndex(cell1, 0);
        c2.showContents();
        System.out.println(
                "*********************************************************************************************************************************");
        System.out.println();


    }
}
