package question2;

import java.util.Observable;
import java.util.Observer;

/**
 * The type Sensor observer.
 */
public class SensorObserver implements Observer
{
    private Object arg;  // l'argument transmis a la notification, soit une instance de MessageEvent

    @Override
    public void update(Observable o, Object arg)
    {
        this.arg = arg;
    }

    /**
     * Gets arg.
     *
     * @return the arg
     */
    public Object getArg()
    {  // en cas de doute, lire la classe de tests unitaires
        return arg;
    }
}
