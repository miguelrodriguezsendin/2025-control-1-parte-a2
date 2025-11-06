package es.grise.upm.profundizacion.subscriptionService;

import java.util.ArrayList;
import java.util.Collection;

public class SubscriptionService {

    private Collection<User> subscribers;

    /*
     * Constructor
     */
    public SubscriptionService() {
        this.subscribers = new ArrayList<User>(); 
    }

    /*
     * Method to code
     */
    public void addSubscriber(User user)
            throws NullUserException, ExistingUserException, LocalUserDoesNotHaveNullEMailException {

        if (user == null) {
            throw new NullUserException("Usuario nulo");
        }

        if (subscribers.contains(user)) {
            throw new ExistingUserException("Usuario existente");
        }

        if (user.getDelivery() == Delivery.LOCAL && user.getEmail() != null) {
            throw new LocalUserDoesNotHaveNullEMailException("No tiene email");
        }
        subscribers.add(user);
    }

    /*
     * Other setters & getters
     */
    public Collection<User> getSubscribers() {
        return subscribers;
    }
}


