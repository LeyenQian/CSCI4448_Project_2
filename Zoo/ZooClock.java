package Zoo;

import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

import Zoo.Observer.Subject;
import Zoo.Employee.Constants;
import Zoo.Employee.Type.ZooAnnouncer;
import Zoo.Observer.Observer;

public class ZooClock implements Subject
{
    protected String type = this.getClass().getSimpleName();
    private List<Observer> observers = new ArrayList<Observer>();

    public void notify_observers(int flag, String info)
    {
        for (int i = 0; i < observers.size(); i++) {
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

    public void perform_daily_routing(int days, ZooAnnouncer announcer)
    {
        for (int day = 1; day <= days; day ++)
        {
            System.out.println(String.format("-------------------------------------------------------- Day %d --------------------------------------------------------", day));

            announcer.arrive();
            for(int time = Constants.TIME_WORK_BEGIN; time <= Constants.TIME_WORK_END; time ++)
            {
                System.out.println("\n*******************************************************************************************");
                System.out.println(String.format("#[%s] current time is %d.", this.type, time));

                if ( time ==  Constants.TIME_WORK_BEGIN)
                {
                    this.notify_observers(Constants.FLAG_WORK_BEGIN, "");
                }
                else if ( time == Constants.TIME_WORK_END )
                {
                    this.notify_observers(Constants.FLAG_WORK_END, "");
                }
                else if ( time == Constants.TIME_FOOD_LUNCH )
                {
                    this.notify_observers(Constants.FLAG_FOOD_LUNCH, "");
                }
                else if ( time == Constants.TIME_FOOD_DINNER )
                {
                    this.notify_observers(Constants.FLAG_FOOD_DINNER, "");
                }
                else if ( time == Constants.TIME_ANIMAL_WAKE_UP )
                {
                    this.notify_observers(Constants.FLAG_ANIMAL_WAKE_UP, "");
                }
                else if ( time == Constants.TIME_ANIMAL_ROLLCALL )
                {
                    this.notify_observers(Constants.FLAG_ANIMAL_ROLLCALL, "");
                }
                else if ( time == Constants.TIME_ANIMAL_FEED )
                {
                    this.notify_observers(Constants.FLAG_ANIMAL_FEED, "");
                }
                else if ( time == Constants.TIME_ANIMAL_EXERCISE )
                {
                    this.notify_observers(Constants.FLAG_ANIMAL_EXERCISE, "");
                }
                else if ( time == Constants.TIME_ANIMAL_SLEEP )
                {
                    this.notify_observers(Constants.FLAG_ANIMAL_SLEEP, "");
                }
                System.out.println("*******************************************************************************************\n");
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
            announcer.leave();
        }
    }
}
