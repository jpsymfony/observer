package question2;

import java.util.Observable;

/**
 * The type Sensor.
 */
public class Sensor extends Observable
{
    private String name;
    private int value;
    private MessageEvent event;

    /**
     * Instantiates a new Sensor.
     *
     * @param name the name
     */
    public Sensor(String name)
    {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String toString()
    {
        return this.name;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(int value)
    {
        this.value = value;
        /* On change l'état de l'observer */
        setChanged();
        event = new MessageEvent(this, Integer.toString(value));

        /* On notifie les observateurs inscrits */
        notifyObservers(event);
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue()
    {
        return value;
    }
}
