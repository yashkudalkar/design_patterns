package nullObjectDesignPattern;

/*
base interface or abstract class that client will use.
* AbstractObject defines the contract Client expects
* it may also contain shared logic for the implementing classes
* */
abstract class Emp
{
    protected String name;
    public abstract boolean isNull();
    public abstract String getName();
}

/*
Real object impl
RealObject implements AbstractObject and provides real behavior
*/
class Coder extends Emp
{
    public Coder(String name)
    {
        this.name = name;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public boolean isNull()
    {
        return false;
    }
}

/*
NullObject implements AbstractObject and provides neutral behavior
 in case of null scenarios
 */
class NoClient extends Emp
{
    @Override
    public String getName()
    {
        return "Not Available";
    }

    @Override
    public boolean isNull()
    {
        return true;
    }
}

class EmpData
{
    public static final String[] names = {"Lokesh", "Kushagra", "Vikram"};
    public static Emp getClient(String name)
    {
        for (String s : names) {
            if (s.equalsIgnoreCase(name)) {
                return new Coder(name);
            }
        }
        return new NoClient();
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Emp emp1 = EmpData.getClient("Lokesh");
        Emp emp2 = EmpData.getClient("Kushagra");
        Emp emp3 = EmpData.getClient("Vikram");
        Emp emp4 = EmpData.getClient("Rishabh");

        System.out.println(emp1.getName());
        System.out.println(emp2.getName());
        System.out.println(emp3.getName());
        System.out.println(emp4.getName());
    }
}