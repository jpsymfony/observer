package question1;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * Decrivez votre classe ConcreteObserver ici.
 *
 * @author SAULNIER Jean-Pierre
 * @version 19 -02-2017
 */
public class ConcreteObserver implements Observer
{
    /**
     * Stack.
     */
    private Stack<Observable> senders;

    /**
     * Stack.
     */
    private Stack<Object> arguments;

    /**
     * Instantiates a new Concrete observer.
     */
    public ConcreteObserver()
    {
        senders = new Stack<Observable>();
        arguments = new Stack<Object>();
    }

    public void update(Observable observable, Object arg)
    {
        senders.push(observable);
        arguments.push(arg);
    }

    /**
     * Senders stack.
     *
     * @return the stack
     */
    public Stack<Observable> senders()
    {
        return senders;
    }

    /**
     * Arguments stack.
     *
     * @return the stack
     */
    public Stack<Object> arguments()
    {
        return arguments;
    }
}
