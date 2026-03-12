
//Excepción personalizada que se lanza cuando se intenta registrar
//un pasajero que ya existe en el sistema (misma identificación).
// Se lanza desde: GestorPasajeros.registrarPasajero()


public class PasajeroDuplicadoException extends Exception {

    //Atributos
    private String identificacion;

    //Constructor
    public PasajeroDuplicadoException(String identificacion) {
        super("El pasajero con identificación " + identificacion
                + " ya se encuentra registrado en el sistema.");
        this.identificacion = identificacion;
    }

    //Métodos

    //Sobreescritura de getMessage() heredado de Exception.
    //Devuelve el mensaje descriptivo del error.

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}


