public interface Cancelable {

    // Ejecuta la cancelación del objeto.
    // Debe cambiar el estado interno a CANCELADO.

    void cancelar();

    // Verifica si el objeto ya fue cancelado.
    // Devuelve true si está cancelado, false si no.

    boolean estaCancelado();
}

