package Zoo.Employee.Type;

import Zoo.Employee.ZooEmployee;
import Zoo.Observer.Observer;

public class ZooAnnouncer extends ZooEmployee implements Observer
{
    public void check_notify(int flag)
    {
        String content = "";
        
        if ( flag == Zookeeper.FLAG_WORK_BEGIN )
        {
            content = "Zookeeper is about to work!";
        }
        else if ( flag == Zookeeper.FLAG_WORK_END )
        {
            content = "Zookeeper is about to leave!";
        }
        else if ( flag == Zookeeper.FLAG_ANIMAL_WAKE_UP )
        {
            content = "Zookeeper is about to wake the animals!";
        }
        else if ( flag == Zookeeper.FLAG_ANIMAL_FEED )
        {
            content = "Zookeeper is about to feed the animals!";
        }
        else if ( flag == Zookeeper.FLAG_ANIMAL_EXERCISE )
        {
            content = "Zookeeper is about to exercise the animals!";
        }
        else if ( flag == Zookeeper.FLAG_ANIMAL_SLEEP )
        {
            content = "Zookeeper is about to let the animals sleep!";
        }
        else if ( flag == Zookeeper.FLAG_ANIMAL_ROLLCALL )
        {
            content = "Zookeeper is about to roll call the animals!";
        }
        
        System.out.println(String.format("#[%s] %s says: \"%s\"", this.type, this.name, content));
    }
}
