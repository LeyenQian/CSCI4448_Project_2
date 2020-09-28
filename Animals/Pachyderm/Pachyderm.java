package Animals.Pachyderm;
import Animals.Animal;


public class Pachyderm extends Animal
{
    public Pachyderm(String name)
    {
        super(name);
    }
    
    // polymorphism: add more methods in addition to the methods inherit from Animal class
    public void charge()
    {
        System.out.println(String.format("#[%s] %s charges.", this.type, this.name));
    }

    // polymorphism: override the roam method in the second level subclasss
    public void roam()
    {
        int rand = (int) ((Math.random() * (100 - 1)) + 1);
        if( rand <= 25 )
        {
            this.charge();
            return;
        }

        super.roam();
    }
}
