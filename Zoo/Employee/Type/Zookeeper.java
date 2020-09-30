package Zoo.Employee.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Animals.Animal;
import Zoo.Zoo;
import Zoo.Employee.ZooEmployee;
import Zoo.Employee.Constants;
import Zoo.Observer.Observer;
import Zoo.Observer.Subject;

public class Zookeeper extends ZooEmployee implements Subject, Observer
{
    private List<Observer> observers = new ArrayList<Observer>();
    private Zoo zoo;

    public Zookeeper(Zoo zoo)
    {
        this.zoo = zoo;
    }
    
    public void notify_observers(int flag, String info)
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).check_notify(flag, info);
        }
    }

    public void add_observer(Observer observer)
    {
        observers.add(observer);
    }

    public void del_observer(Observer observer)
    {
        observers.remove(observer);
    }

    public void check_notify(int flag, String info)
    {
        if ( flag == Constants.FLAG_WORK_BEGIN )
        {
            notify_observers(Constants.FLAG_WORK_BEGIN, this.get_type() + "<" + this.get_identity() + ">" );
            this.arrive();
            return;
        }
        
        if ( flag == Constants.FLAG_WORK_END )
        {
            notify_observers(Constants.FLAG_WORK_END, this.get_type() + "<" + this.get_identity() + ">" );
            this.leave();
            return;
        }

        for (Map.Entry<String, Animal> animal_set : zoo.animals.entrySet())
        {
            Animal animal = animal_set.getValue();

            if ( flag == Constants.FLAG_ANIMAL_WAKE_UP )
            {
                this.wake_animal(animal);
            }
            else if ( flag == Constants.FLAG_ANIMAL_ROLLCALL )
            {
                this.roll_call_animal(animal);
            }
            else if ( flag == Constants.FLAG_ANIMAL_FEED )
            {
                this.feed_animal(animal);
            }
            else if ( flag == Constants.FLAG_ANIMAL_EXERCISE )
            {
                this.exercise_animal(animal);
            }
            else if ( flag == Constants.FLAG_ANIMAL_SLEEP )
            {
                this.tell_animal_to_sleep(animal);
            }
        }
    }

    public void wake_animal(Animal animal)
    {
        notify_observers(Constants.FLAG_ANIMAL_WAKE_UP, "");
        System.out.println(String.format("#[%s] %s wakes up %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.wake_up();
    }

    public void roll_call_animal(Animal animal)
    {
        notify_observers(Constants.FLAG_ANIMAL_ROLLCALL, "");
        System.out.println(String.format("#[%s] %s roll call %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.make_noise();
    }

    public void feed_animal(Animal animal)
    {
        notify_observers(Constants.FLAG_ANIMAL_FEED, "");
        System.out.println(String.format("#[%s] %s feeds %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.eat();
    }

    public void exercise_animal(Animal animal)
    {
        notify_observers(Constants.FLAG_ANIMAL_EXERCISE, "");
        System.out.println(String.format("#[%s] %s exercises %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.roam();
    }

    public void tell_animal_to_sleep(Animal animal)
    {
        notify_observers(Constants.FLAG_ANIMAL_SLEEP, "");
        System.out.println(String.format("#[%s] %s tells %s <%s> to sleep.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.sleep();
    }
}