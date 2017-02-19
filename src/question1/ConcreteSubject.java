package question1;

import java.util.Observable;
import java.util.ArrayList;

/**
 * Decrivez votre classe ConcreteSubject ici.
 *
 * @author SAULNIER Jean-Pierre
 * @version 19 -02-2017
 */
public class ConcreteSubject extends Observable
{
    private ArrayList<String> list;

    /**
     * Instantiates a new Concrete subject.
     */
    public ConcreteSubject()
    {
        list = new ArrayList<String>();
    }

    /**
     * Insert.
     *
     * @param name the name
     */
    public void insert(String name)
    {
        list.add(name);
        setChanged();
        notifyObservers(name);
    }

    public String toString()
    {
        return list.toString();
    }

}
