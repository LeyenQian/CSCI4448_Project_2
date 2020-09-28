package Zoo.Employee;


public abstract class ZooEmployee {
    protected String type = this.getClass().getSimpleName();
    protected String name;
    protected int identity;

    // encapsulation: create getter and setter functions as following
    public String get_type()
    {
        return this.type;
    }
    
    public void set_name(String name)
    {
        this.name = name;
    }

    public String get_name()
    {
        return this.name;
    }

    public void set_identity(int identity)
    {
        this.identity = identity;
    }

    public int get_identity()
    {
        return this.identity;
    }
}
