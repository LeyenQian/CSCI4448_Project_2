package Animals;
import java.time.Instant;


// we set Animal as an abstract class, all other class like <Canine> or <Cat> shall extends this class.
// Abstraction and polymorphism are highly related, we may consider those subclasses are the implementation of polymorphism.
public abstract class Animal
{
    // encapsulation: type and name are only visible to subclass, other classes can only gain access through getter and setter methods.
    protected String type = this.getClass().getSimpleName();
    protected String name;

    // provide two constructors here (overload)
    // the default constructor here is only for test purpose, so no subclasses provide the same implementation.
    public Animal()
    {}

    // I don't think set name in constructor is a good idea
    // based on the project requirement, set name can be failed, if the initial is not same with that of the class name.
    public Animal(String name)
    {
        if(!this.set_name(name))
        {
            // if the user given name does not match the constraint, we shall give it a default one
            // based on the condition on zoo class, two animals shall not share the same name
            // we add a timestamp to differentiate them.
            this.set_name(this.type + "_default_name_" + Instant.now());
        }
    }

    public String get_type()
    {
        return this.type;
    }
    
    public boolean set_name(String name)
    {
        // this is only for test purpose, no value assigned when test animal class directly
        if( this.type.length() == 0 )
        {
            this.type = "animal";
        }

        if(  name.length() < 1 || !name.toUpperCase().startsWith(this.type.substring(0, 1).toUpperCase()) )
        {
            System.out.println(String.format("#[%s] set name failed, name must starts with the character '%s' or '%s'.", this.type, this.type.substring(0, 1), this.type.substring(0, 1).toUpperCase()));    
            return false;
        }

        this.name = name;
        return true;
    }

    public String get_name()
    {
        return this.name;
    }

    // all animals share some behaviors in common.
    // Therefore, we define and implement all common methods here
    // all subclass can access, override or overload them. 
    public void wake_up()
    {
        System.out.println(String.format("#[%s] %s wakes up.", this.type, this.name));
    }

    public void sleep()
    {
        System.out.println(String.format("#[%s] %s sleeps.", this.type, this.name));
    }

    public void eat()
    {
        System.out.println(String.format("#[%s] %s eats.", this.type, this.name));
    }

    public void make_noise()
    {
        System.out.println(String.format("#[%s] %s makes noise.", this.type, this.name));
    }

    public void roam()
    {
        System.out.println(String.format("#[%s] %s roams.", this.type, this.name));
    }






    // test
    public static void main(String[] args)
    {
        Animal animal = new Animal("ss"){};
        System.out.println(animal.get_name());
    }
}