package Zoo.Employee.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Animals.Animal;
import Zoo.Zoo;
import Zoo.Employee.ZooEmployee;
import Zoo.Observer.Observer;
import Zoo.Observer.Subject;

public class Zookeeper extends ZooEmployee implements Subject
{
    public static final int FLAG_WORK_BEGIN      = 0x0;
    public static final int FLAG_WORK_END        = 0x1;
    public static final int FLAG_ANIMAL_WAKE_UP  = 0x2;
    public static final int FLAG_ANIMAL_FEED     = 0x3;
    public static final int FLAG_ANIMAL_EXERCISE = 0x4;
    public static final int FLAG_ANIMAL_SLEEP    = 0x5;
    public static final int FLAG_ANIMAL_ROLLCALL = 0X6;

    private List<Observer> observers = new ArrayList<Observer>();
    
    public void notify_observers(int flag)
    {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).check_notify(flag);
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

    public void wake_animal(Animal animal)
    {
        notify_observers(FLAG_ANIMAL_WAKE_UP);
        System.out.println(String.format("#[%s] %s wakes up %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.wake_up();
    }

    public void roll_call_animal(Animal animal)
    {
        notify_observers(FLAG_ANIMAL_ROLLCALL);
        System.out.println(String.format("#[%s] %s roll call %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.make_noise();
    }

    public void feed_animal(Animal animal)
    {
        notify_observers(FLAG_ANIMAL_FEED);
        System.out.println(String.format("#[%s] %s feeds %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.eat();
    }

    public void exercise_animal(Animal animal)
    {
        notify_observers(FLAG_ANIMAL_EXERCISE);
        System.out.println(String.format("#[%s] %s exercises %s <%s>.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.roam();
    }

    public void tell_animal_to_sleep(Animal animal)
    {
        notify_observers(FLAG_ANIMAL_SLEEP);
        System.out.println(String.format("#[%s] %s tells %s <%s> to sleep.", this.type, this.name, animal.get_name(), animal.get_type()));
        animal.sleep();
    }

    public void perform_daily_task(Animal animal)
    {
        System.out.println();
        this.wake_animal(animal);
        this.roll_call_animal(animal);
        this.feed_animal(animal);
        this.exercise_animal(animal);
        this.tell_animal_to_sleep(animal);
        System.out.println();
    }

    public void visit_zoo(Zoo zoo, int total_days)
    {
        for(int i = 1; i <= total_days; i++)
        {
            System.out.println("\n\n\n");
            System.out.println(String.format("∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨ [%s] %s arrives at %s on Day %d ∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨∨", this.type, this.name, zoo.get_type(), i));
            notify_observers(FLAG_WORK_BEGIN);
            for (Map.Entry<String, Animal> animal : zoo.animals.entrySet())
            {
                this.perform_daily_task(animal.getValue());
            }
            notify_observers(FLAG_WORK_END);
            System.out.println(String.format("∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧ [%s] %s arrives at %s on Day %d ∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧∧", this.type, this.name, zoo.get_type(), i));
        }
    }





    
    // test cases
    public static void main(String[] args)
    {
        Zookeeper employee_test = new Zookeeper();
        employee_test.set_name("zoo_keeper_a");
        employee_test.set_identity(123456);

        System.out.println(employee_test.get_type());
        System.out.println(employee_test.get_name());
        System.out.println(employee_test.get_identity());
    }
}