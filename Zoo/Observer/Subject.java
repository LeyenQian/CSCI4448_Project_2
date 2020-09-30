package Zoo.Observer;

public interface Subject
{
    public void notify_observers(int flag, String info);
    public void add_observer(Observer observer);
    public void del_observer(Observer observer);
}
