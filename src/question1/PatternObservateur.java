package question1;

/**
 * The type Pattern observateur.
 */
public class PatternObservateur extends junit.framework.TestCase
{
    /**
     * Test notify.
     */
    public void testNotify()
    {
        ConcreteSubject list = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver();
        list.addObserver(observer);
        list.insert("il fait beau, ce matin");

        assertEquals(list, observer.senders().pop());
        assertEquals("il fait beau, ce matin", observer.arguments().pop());
        list.insert("super !!");
    }

    /**
     * 1 liste et 2 observateurs.
     * Vérifier ci-dessous, au moins que les deux observateurs ont été bien notifiés.
     * Rappel : Le dernier élément entré sera le premier à sortir de la pile !
     */
    public void test1()
    {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");

        // a completer
        // verifier ci dessous, au moins que les deux observateurs ont bien été notifiés
        assertFalse(o1.senders().empty() && o1.arguments().empty());
        assertFalse(o2.senders().empty() && o2.arguments().empty());

        // observateur #1 -------------------------------
        assertEquals(l1, o1.senders().pop());
        assertEquals(" 1 ", o1.arguments().pop());

        assertEquals(l1, o1.senders().pop());
        assertEquals("test", o1.arguments().pop());

        // observateur #2 -------------------------------
        assertEquals(l1, o2.senders().pop());
        assertEquals(" 1 ", o2.arguments().pop());

        assertEquals(l1, o2.senders().pop());
        assertEquals("test", o2.arguments().pop());

        // ne pas modifier ces lignes, dernieres assertions de cette methode
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    /**
     * 2 listes et 1 observateur.
     * Vérifier ci-dessous, (au moins) que l'observateur a été
     * bien notifié par les deux listes (l1 et l2 :> ConcreteSubject).
     * Le dernier élément entré sera le premier à sortir de la pile !
     */
    public void test2()
    {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteSubject l2 = new ConcreteSubject();

        ConcreteObserver o = new ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");

        // a completer
        // verifier (au moins) que l'observateur a bien ete notifie par les deux listes
        // les arguments de l'observer sont au nombre de 4: B, testB, A, testA
        assertEquals(4, o.arguments().size());

        // les senders de l'observer sont au nombre de 4: l2, l2, l1, l1
        assertEquals(4, o.senders().size());
        assertTrue(o.senders().contains(l1));
        assertTrue(o.senders().contains(l2));

        assertFalse(o.senders().empty() && o.arguments().empty());

        assertEquals(l2, o.senders().pop());
        assertEquals(" B ", o.arguments().pop());
        assertEquals(l2, o.senders().pop());
        assertEquals("testB", o.arguments().pop());

        assertEquals(l1, o.senders().pop());
        assertEquals(" A ", o.arguments().pop());
        assertEquals(l1, o.senders().pop());
        assertEquals("testA", o.arguments().pop());

        // ne pas modifier cette ligne, derniere assertion de cette methode
        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    /**
     * ==> 2 listes et 2 observateurs.
     * Vérifier le bon fonctionnement de :
     * - countObservers()
     * - deleteObserver(Observer o)
     * - deleteObservers()
     */
    public void test3()
    {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteSubject l2 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);

        // a completer
        // verifier le bon fonctionnement de countObservers(), de deleteObserver et deleteObservers()
        // -----------------------------------------------------------
        // Nombre d'observateurs dans les listes l1 et l2.
        assertEquals(2, l1.countObservers());
        assertEquals(2, l2.countObservers());

        // Suppression de tous les Observateurs de la liste l1.
        l1.deleteObservers();

        // Suppression de l'observateur "o1" de la liste l2.
        l2.deleteObserver(o1);
        l2.deleteObserver(o2);

        // ne pas modifier ces lignes, dernieres assertions de cette methode
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
}

