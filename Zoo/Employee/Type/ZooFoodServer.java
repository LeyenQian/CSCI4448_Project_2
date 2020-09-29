package Zoo.Employee.Type;

import java.util.ArrayList;
import java.util.List;

import Zoo.Employee.Constants;
import Zoo.Employee.ZooEmployee;
import Zoo.Observer.Observer;
import Zoo.Observer.Subject;

public class ZooFoodServer extends ZooEmployee implements Subject, Observer
{
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

    public void check_notify(int flag)
    {
        if ( flag == Constants.FLAG_WORK_BEGIN )
        {
            this.arrive();
        }
        else if ( flag == Constants.FLAG_WORK_END )
        {
            this.leave();
        }
        else if ( flag == Constants.FLAG_FOOD_LUNCH || flag == Constants.FLAG_FOOD_DINNER)
        {
            this.make_food();
            this.serve_food(flag);
            this.clean();
        }
    }
    
    public void arrive()
    {   
        System.out.println(String.format("#[%s] %s arrives.", this.type, this.name));
    }

    public void leave()
    {
        System.out.println(String.format("#[%s] %s leaves.", this.type, this.name));
    }

    public void make_food()
    {
        System.out.println(String.format("#[%s] %s is making food.", this.type, this.name));
    }

    public void serve_food(int food_type)
    {
        notify_observers(food_type);
        System.out.println(String.format("#[%s] %s serves food.", this.type, this.name));
    }

    public void clean()
    {
        System.out.println(String.format("#[%s] %s cleans.", this.type, this.name));
    }
}
