package question2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Observable;
import java.util.Observer;

/**
 * The type Persistent observer.
 */
public class PersistentObserver implements Observer
{
    private Object arg;
    private String fileName;

    /**
     * Instantiates a new Persistent observer.
     *
     * @param fileName the file name
     */
    public PersistentObserver(String fileName)
    { // complété
        this.fileName = fileName;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        this.arg = arg;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(arg);
            oos.close();
        } catch (Exception e) {

        }
    }

    /**
     * Gets arg.
     *
     * @return the arg
     */
    public Object getArg()
    {  // retourne le message encapsulé
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            arg = ois.readObject();
            ois.close();
        } catch (Exception e) {

        }

        return arg;
    }
}
