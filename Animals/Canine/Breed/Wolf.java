package Animals.Canine.Breed;
import Animals.Canine.Canine;


public class Wolf extends Canine
{
    public Wolf(String name)
    {
        super(name);
    }

    // override the wake_up and eat methods
    // this is for project requirement
    public void wake_up()
    {
        System.out.println(String.format("#[%s] %s wakes up (overrided).", this.type, this.name));
    }

    public void eat()
    {
        System.out.println(String.format("#[%s] %s eats. (overrided)", this.type, this.name));
    }
}
