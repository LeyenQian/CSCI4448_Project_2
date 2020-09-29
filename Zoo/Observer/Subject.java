package Zoo.Observer;

public interface Subject
{
    public void notify_observers(int flag);
    public void add_observer(Observer observer);
    public void del_observer(Observer observer);
}
