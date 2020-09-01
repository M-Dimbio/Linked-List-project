
import java.util.NoSuchElementException;

public class CellList
{
    private CellNode head;
    private int size;
    private boolean blank=true;

    public CellList ()
    {
        this.head =null;
        this.size=0;
    }
    public CellList clone ()
    {
        return new CellList(this);
    }
    public CellList (CellList c)
    {
        CellNode t1,t2,t3;
        t1=c.head;
        t2=t3=null;
        size=c.size;
        while (t1!=null)
        {

            t3=new CellNode (t1.cell.clone(),null);
            if(head== null)
            {
                head=t2=t3;
            }
            t1=t1.nxt;
            t2.nxt=t3;
            t2=t3;

        }
        t2=t3=null;
    }
    public void addToStart(CellPhone cell){
        head= new CellNode(cell,head);
        size++;
    }
    public boolean insertAtIndex(CellPhone cell, int x) {

        if (x != size)
            verify(x);

        if (head == null) {
            System.out.println("List is empty!");
            return false;

        } else if (x == 0) {
            addToStart(cell);
            size++;
            return true;
        } else {
            CellNode t = head;
            int counter = 0;

            while (t != null) {
                if (x - 1 > counter) {
                    t = t.nxt;
                    counter++;
                } else if (x - 1 == counter) {
                    t.nxt = new CellNode(cell, t.nxt);
                    size++;
                    return true;
                }
            }
        }
        return false;

    }

    public void verify (int x)
    {
        try
        {
            if (x>(this.size-1)|| x<0)
            {
                throw new NoSuchElementException();
            }

        }
        catch (NoSuchElementException e)
        {
            System.out.println("The positon "+ x +" doesn't exist will terminate the program");
            System.exit(0);
        }
    }
    public boolean deleteFromIndex(int x)
    {

        verify(x);
        if (head== null)
        {
            System.out.println("List is empty!");
            return false;
        }
        if (x==0)
        {
           return deleteFromStart();

        }
        else
            {
            CellNode t = head;
            int counter = 0;
                while(t!=null)
                {
                    if ((x-1)>counter)
                    {
                        t=t.nxt;
                        counter++;
                    }
                    else if ((x-1)==counter)
                    {
                        t.nxt=t.nxt.nxt;
                        size--;
                        return true;
                    }
                }
                return false;
            }

    }
    public boolean deleteFromStart()
    {
        head=head.nxt;
        size--;
        return true;
    }
    public boolean replaceAtIndex(CellPhone cell, int x) {
        verify(x);

        if (head == null) {
            System.out.println("List is empty!");
            return false;
        }

        else {

            CellNode t = head;
            int counter = 0;
            while (t != null) {
                if (x==0) {
                    head=new CellNode(cell,t.nxt);
                    return true;

                }
                else if (x-1 > counter) {
                    t = t.nxt;
                    counter++;
                } else if (x-1 == counter) {
                    t.nxt = new CellNode(cell, t.nxt.nxt);
                    return true;
                }
            }
        }
        return false;

    }
    public CellNode find (long sn) // It violate the encapsulation because we are returning the pointer of the object. Then who ever
    {                              // is using the main have access to the whole list and can do what ever he want with it.
        int count =0;
        CellNode t = head;
        while (t!=null)
        {
            count++;
            if (t.cell.getSerialNumber()==sn)
            {
                if (blank)
                {
                    System.out.println(count + " iterations have been done");

                }
                return t;
            }
            else
                {
                    t=t.nxt;
                }
        }
        if (blank)
        {
            System.out.println(count + " iterations have been done and no result was found");

        }
        blank=true;
        return null;
    }
    public boolean contains (long sn)
    {
        blank=false;
        if(find(sn)!=null)
        {

            return true;
        }
        else {

            return false;
        }

    }

    public void showContents()
    {
        CellNode t = head;
        System.out.println("The current size of the list is "+size+".Here are the content of the list.");
        System.out.println("========================================================================================================================");
        int count =1;
        while (t!=null)
        {

            System.out.print(t.cell.toString());

            if (count %3 ==0)
            {
                System.out.println();
            }
            t=t.nxt;
            count++;
        }
        System.out.println("X");
    }


    public boolean equals(CellList c)
    {

        int count=0;
        if (c.head==null || this.head==null || c.size!=this.size )
            return false;
        CellNode t=c.head;
        CellNode n=this.head;
        while (t!=null && n!=null)
        {

            if (t.cell.equals(n.cell))
            {
                t=t.nxt;
                n=n.nxt;
                count++;
                continue;
            }
            else
                return false;
        }
        return true;

    }


    private class CellNode
    {
        private CellPhone cell;
        private CellNode nxt;
        public CellNode()
        {
            cell= null;
            nxt=null;
        }
        public CellNode(CellPhone cell,CellNode nxt)
        {
            this.cell=cell;
            this.nxt=nxt;
        }
        public CellNode(CellNode copyCellNOde)
        {   //if()
            this.cell=copyCellNOde.cell.clone();
            this.nxt=copyCellNOde.nxt;
        }
        public CellNode clone ()
        {
            return new CellNode(this);
        }

        public CellNode getNxt()
        {
            return nxt;
        }

        public void setNxt(CellNode nxt)
        {
            this.nxt = nxt;
        }

        public CellPhone getCell()
        {
            return cell;
        }

        public void setCell(CellPhone cell)
        {
            this.cell = cell;
        }

    }
}
