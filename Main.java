import java.util.Scanner;
import Animals.Animal;
import Animals.Canine.Breed.*;
import Animals.Feline.Breed.*;
import Animals.Pachyderm.Breed.*;
import Animals.Ursidae.Breed.*;
import Zoo.Zoo;
import Zoo.Employee.Type.Zookeeper;


public class Main
{
    // identity is just the reference number or the memory address of a specific instance
    // different instances shall have different identity
    // instances like zoo_keeper, dog, wolf... are the examples
    
    public static void main(String[] args)
    {
        // ask user to input a number
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int days = scan.nextInt();
        scan.close();

        System.out.println("\n\n----------------------------------------- Zoo Beg -----------------------------------------");

        // Employee
        Zookeeper zoo_keeper = new Zookeeper();
        zoo_keeper.set_identity(9567);
        zoo_keeper.set_name("zoo_keeper_name");

        // Canine
        Animal dog_a = new Dog("dog_a_name");
        Animal dog_b = new Dog("dog_b_name");
        Animal wolf_a = new Wolf("wolf_a_name");
        Animal wolf_b = new Wolf("wolf_b_name");

        // Feline
        Animal cat_a = new Cat("cat_a_name");
        Animal cat_b = new Cat("cat_b_name");
        Animal lion_a = new Lion("lion_a_name");
        Animal lion_b = new Lion("lion_b_name");
        Animal tiger_a = new Tiger("tiger_a_name");
        Animal tiger_b = new Tiger("tiger_b_name");
        
        // Pachyderm
        Animal elephant_a = new Elephant("elephant_a_name");
        Animal elephant_b = new Elephant("elephant_b_name");
        Animal hippo_a = new Hippo("hippo_a_name");
        Animal hippo_b = new Hippo("hippo_b_name");
        Animal rhino_a = new Rhino("rhino_a");
        Animal rhino_b = new Rhino("rhino_b");

        // Ursidae
        Animal panda_a = new Panda("panda_a_name");
        Animal panda_b = new Panda("panda_b_name");
        Animal polar_bear_a = new PolarBear("polar_bear_a_name");
        Animal polar_bear_b = new PolarBear("polar_bear_b_name");

        // Zoo
        Zoo zoo = new Zoo();
        zoo.add_employee(zoo_keeper);

        zoo.add_animal(dog_a);
        zoo.add_animal(dog_b);

        zoo.add_animal(wolf_a);
        zoo.add_animal(wolf_b);

        zoo.add_animal(cat_a);
        zoo.add_animal(cat_b);

        zoo.add_animal(lion_a);
        zoo.add_animal(lion_b);

        zoo.add_animal(tiger_a);
        zoo.add_animal(tiger_b);

        zoo.add_animal(elephant_a);
        zoo.add_animal(elephant_b);

        zoo.add_animal(hippo_a);
        zoo.add_animal(hippo_b);

        zoo.add_animal(rhino_a);
        zoo.add_animal(rhino_b);

        zoo.add_animal(panda_a);
        zoo.add_animal(panda_b);

        zoo.add_animal(polar_bear_a);
        zoo.add_animal(polar_bear_b);

        zoo_keeper.visit_zoo(zoo, days);

        System.out.println("----------------------------------------- Zoo End -----------------------------------------\n\n");
    }
}