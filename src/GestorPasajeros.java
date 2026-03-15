public class GestorPasajeros {

    //Atributos
    private Pasajero[] pasajeros;
    private int total_pasajeros;

    private static final int CAPACIDAD_INICIAL = 10;

    //Constructor
    public GestorPasajeros() {
        this.pasajeros = new Pasajero[CAPACIDAD_INICIAL];
        this.total_pasajeros = 0;
    }

    //Métodos

    //Registra un nuevo pasajero en el sistema
    //Verifica duplicados y redimensiona si es necesario
    public void registrarPasajero(Pasajero pasajero) throws PasajeroDuplicadoException {
        if (pasajero == null) return;
        detectarDuplicados(pasajero);
        if (total_pasajeros == pasajeros.length) {
            redimensionar();
        }
        pasajeros[total_pasajeros] = pasajero;
        total_pasajeros++;
        System.out.println("Pasajero " + pasajero.getNombre()+ " registrado " );
    }

    //Busca un pasajero por su identificación
    public Pasajero buscarPasajero(String id) {
        if (id == null || id.isBlank()) return null;
        for (int i = 0; i < total_pasajeros; i++) {
            if (pasajeros[i].getIdentificacion().equals(id)) {
                System.out.println("El pasajero encontrado es: " + pasajeros[i]);
            }
        }
        return null;
    }

    //Verifica si ya existe un pasajero con la misma identificación
    //Se hace uso de la excepción para poder mostrar explícitamente el error
    public void detectarDuplicados(Pasajero pasajero) throws PasajeroDuplicadoException {
        for (int i = 0; i < total_pasajeros; i++) {
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
        for (int i = 0; i < total_pasajeros; i++) {
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
        for (int i = indice; i < total_pasajeros - 1; i++) {
            pasajeros[i] = pasajeros[i + 1];
        }
        pasajeros[total_pasajeros - 1] = null;  // eliminar última referencia
        total_pasajeros--;
        System.out.println("Pasajero con ID " + id + " eliminado correctamente ✓");
    }

    //Da el total de los pasajeros y una lista de estos
    public void listarPasajeros() {
        if (total_pasajeros == 0) {
            System.out.println("No hay pasajeros registrados.");
            return;
        }
        System.out.println("Cantidad de Pasajeros (" + total_pasajeros + ")");
        for (int i = 0; i < total_pasajeros; i++) {
            System.out.println("  " + (i + 1) + " " + pasajeros[i]);
        }
    }

    //Redimensiona el array duplicando su capacidad
    public void redimensionar() {
        Pasajero[] nuevo = new Pasajero[pasajeros.length * 2];
        for (int i = 0; i < total_pasajeros; i++) {
            nuevo[i] = pasajeros[i];
        }
        pasajeros = nuevo;
        System.out.println("Array redimensionado, Nueva capacidad: " + pasajeros.length);
    }

    //Getters

    public int getTotal_pasajeros() {
        return total_pasajeros;
    }

    //Devuelve copia del array con solo los pasajeros activos
    public Pasajero[] getPasajeros() {
        Pasajero[] copia = new Pasajero[total_pasajeros];
        for (int i = 0; i < total_pasajeros; i++) {
            copia[i] = pasajeros[i];
        }
        return copia;
    }
}