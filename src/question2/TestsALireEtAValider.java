package question2;

/**
 * The type Tests a lire et a valider.
 */
public class TestsALireEtAValider extends junit.framework.TestCase
{
    private static String getValue(Object arg) throws Exception
    {
        return ((MessageEvent) arg).getMessage(); // du a l'encapsulation de la valeur dans le message
    }

    /**
     * Test un observateur un capteur.
     *
     * @throws Exception the exception
     */
    public void testUnObservateurUnCapteur() throws Exception
    {
        SensorObserver so1 = new SensorObserver();
        assertTrue(" getArg() != null ???", so1.getArg() == null);

        Sensor sensor1 = new Sensor("sensor1");
        sensor1.setValue(33);
        assertTrue(" getArg() != null ???", so1.getArg() == null);

        sensor1.addObserver(so1); // a decommenter ...
        assertTrue(" getArg() != null ???", so1.getArg() == null);
        sensor1.setValue(34);
        assertTrue(" getArg() == null ???", so1.getArg() != null);
        assertTrue(" getArg() erroné ???", getValue(so1.getArg()).equals("34"));

        PersistentObserver po1 = new PersistentObserver("test.txt");
        Sensor sensor2 = new Sensor("sensor2");
        sensor2.addObserver(po1);
        sensor2.setValue(35);
        assertTrue(" getArg() erroné ???", getValue(po1.getArg()).equals("35"));
    }
}

