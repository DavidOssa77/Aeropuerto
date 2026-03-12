public class GestorPasajeros {

    //Atributos
    private Pasajero[] pasajeros;
    private int        total;

    private static final int CAPACIDAD_INICIAL = 10;

    //Constructor
    public GestorPasajeros() {
        this.pasajeros = new Pasajero[CAPACIDAD_INICIAL];
        this.total     = 0;
    }

    //Métodos

    //Registra un nuevo pasajero en el sistema
    //Verifica duplicados y redimensiona si es necesario
    public void registrarPasajero(Pasajero pasajero) throws PasajeroDuplicadoException {
        if (pasajero == null) return;
        detectarDuplicados(pasajero);
        if (total == pasajeros.length) {
            redimensionar();
        }
        pasajeros[total] = pasajero;
        total++;
        System.out.println("Pasajero " + pasajero.getNombre()+ " registrado " );
    }

    //Busca un pasajero por su identificación
    public Pasajero buscarPasajero(String id) {
        if (id == null || id.isBlank()) return null;
        for (int i = 0; i < total; i++) {
            if (pasajeros[i].getIdentificacion().equals(id)) {
                System.out.println("El pasajero encontrado es: " + pasajeros[i]);
            }
        }
        return null;
    }

    //Verifica si ya existe un pasajero con la misma identificación
    //Se hace uso de la excepción para poder mostrar explícitamente el error
    public void detectarDuplicados(Pasajero pasajero) throws PasajeroDuplicadoException {
        for (int i = 0; i < total; i++) {
            if (pasajeros[i].getIdentificacion()
                    .equals(pasajero.getIdentificacion())) {
                throw new PasajeroDuplicadoException(pasajero.getIdentificacion());
            }
        }
    }

    //Elimina un pasajero por su identificación y compacta el array
    public void eliminarPasajero(String id) {

        //Si encuentra una entrada nula termina
        if (id == null || id.isBlank()) return; //Si encuentra una entrada nula termina

        //realiza la búsqueda y si no se actualiza la variable indice es porque no encontró nada
        int indice = -1;
        for (int i = 0; i < total; i++) {
            if (pasajeros[i].getIdentificacion().equals(id)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("No se encontró pasajero con ID: " + id);
            return;
        }

        // Si es capaz de eliminar una entrada se compacta el array para no dejar entradas vacías
        for (int i = indice; i < total - 1; i++) {
            pasajeros[i] = pasajeros[i + 1];
        }
        pasajeros[total - 1] = null;  // eliminar última referencia
        total--;
        System.out.println("Pasajero con ID " + id + " eliminado correctamente ✓");
    }

    //Da el total de los pasajeros y una lista de estos
    public void listarPasajeros() {
        if (total == 0) {
            System.out.println("No hay pasajeros registrados.");
            return;
        }
        System.out.println("Cantidad de Pasajeros (" + total + ")");
        for (int i = 0; i < total; i++) {
            System.out.println("  " + (i + 1) + " " + pasajeros[i]);
        }
    }

    //Redimensiona el array duplicando su capacidad
    public void redimensionar() {
        Pasajero[] nuevo = new Pasajero[pasajeros.length * 2];
        for (int i = 0; i < total; i++) {
            nuevo[i] = pasajeros[i];
        }
        pasajeros = nuevo;
        System.out.println("Array redimensionado, Nueva capacidad: " + pasajeros.length);
    }

    //Getters

    public int getTotal() {
        return total;
    }

    //Devuelve copia del array con solo los pasajeros activos
    public Pasajero[] getPasajeros() {
        Pasajero[] copia = new Pasajero[total];
        for (int i = 0; i < total; i++) {
            copia[i] = pasajeros[i];
        }
        return copia;
    }
}