package Excepciones;

public class RegistroYaExisteException extends Exception {

    public RegistroYaExisteException(String mensaje) {
        super(mensaje);
    }
}