package es.grise.upm.profundizacion.subscriptionService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Collection;

public class SubscriptionServiceTest {

    private SubscriptionService service;

    @BeforeEach
    public void setUp() {
        service = new SubscriptionService();
    }

    @Test
    public void testInitialSubscribersListIsEmpty() {
        Collection<User> subscribers = service.getSubscribers();
        assertNotNull(subscribers);
        assertTrue(subscribers.isEmpty());
    }

    @Test
    public void testAddNullUser() {
        assertThrows(NullUserException.class, () -> service.addSubscriber(null));
    }

    @Test
    public void testAddExistingUser() throws Exception {
        User user = Mockito.mock(User.class);
        Mockito.when(user.getEmail()).thenReturn("test@ejemplo.com");
        Mockito.when(user.getDelivery()).thenReturn(Delivery.DO_NOT_DELIVER);

        service.addSubscriber(user);
        assertThrows(ExistingUserException.class, () -> service.addSubscriber(user));
    }

    @Test
    public void testLocalUserConEmail() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.getEmail()).thenReturn("local@ejemplo.com");
        Mockito.when(user.getDelivery()).thenReturn(Delivery.LOCAL);

        assertThrows(LocalUserDoesNotHaveNullEMailException.class, () -> service.addSubscriber(user));
    }

}
