package es.grise.upm.profundizacion.subscriptionService;

public class ExistingUserException extends Exception {
        public ExistingUserException(String mensaje) {
        super(mensaje);
    }
}