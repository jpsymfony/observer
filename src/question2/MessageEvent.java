package question2;

/**
 * Classe associe a l'evenement.
 * La source de l'evenement et le message transmis sont encapsules.
 *
 * @see java.util.EventObject
 */
public class MessageEvent extends java.util.EventObject
{
    private String message;

    /**
     * Instantiates a new Message event.
     *
     * @param source  the source
     * @param message the message
     */
    public MessageEvent(Object source, String message)
    {
        super(source);
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }
} 
