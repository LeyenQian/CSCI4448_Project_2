package Animals.Ursidae.Breed;
import Animals.Ursidae.Ursidae;
import Animals.Ursidae.UrsidaeDelegation;


public class Panda extends Ursidae
{
    // delegation
    private UrsidaeDelegation ursidae_delegation = new UrsidaeDelegation();

    public Panda(String name)
    {
        super(name);
    }

    // call the eat method from <ursidae_delegation> instead of the original one that inherited from <animal>
    public void eat()
    {
        ursidae_delegation.eat_for_panda(this.type, this.name);
    }
}
