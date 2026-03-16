public class GestorPasajeros {

    //Atributos
    private Pasajero[] pasajeros;
    private int totalPasajeros;

    private static final int CAPACIDAD_INICIAL = 10;

    //Constructor
    public GestorPasajeros() {
        this.pasajeros = new Pasajero[CAPACIDAD_INICIAL];
        this.totalPasajeros = 0;
    }

    //Métodos

    //Registra un nuevo pasajero en el sistema
    //Verifica duplicados y redimensiona si es necesario
    public void registrarPasajero(Pasajero pasajero) throws PasajeroDuplicadoException {
        if (pasajero == null) return;
        detectarDuplicados(pasajero);
        if (totalPasajeros == pasajeros.length) {
            redimensionar();
        }
        pasajeros[totalPasajeros] = pasajero;
        totalPasajeros++;
        System.out.println("Pasajero " + pasajero.getNombre()+ " registrado " );
    }

    //Busca un pasajero por su identificación
    public Pasajero buscarPasajero(String id) {
        if (id == null || id.isBlank()) return null;
        for (int i = 0; i < totalPasajeros; i++) {
            if (pasajeros[i].getIdentificacion().equals(id)) {
                System.out.println("El pasajero encontrado es: " + pasajeros[i]);
                return pasajeros[i];
            }
        }
        System.out.println("El pasajero con id: " + id + " no existe.");
        return null;
    }

    //Verifica si ya existe un pasajero con la misma identificación
    //Se hace uso de la excepción para poder mostrar explícitamente el error
    public void detectarDuplicados(Pasajero pasajero) throws PasajeroDuplicadoException {
        for (int i = 0; i < totalPasajeros; i++) {
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
        for (int i = 0; i < totalPasajeros; i++) {
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
        for (int i = indice; i < totalPasajeros - 1; i++) {
            pasajeros[i] = pasajeros[i + 1];
        }
        pasajeros[totalPasajeros - 1] = null;  // eliminar última referencia
        totalPasajeros--;
        System.out.println("Pasajero con ID " + id + " eliminado correctamente ✓");
    }

    //Da el total de los pasajeros y una lista de estos
    public String listarPasajeros() {
        if (totalPasajeros == 0) return "No hay pasajeros registrados.";
        String resultado = "Cantidad de Pasajeros (" + totalPasajeros + ")\n";
        for (int i = 0; i < totalPasajeros; i++) {
            resultado += "  " + (i + 1) + " " + pasajeros[i] + "\n";
        }
        return resultado;
    }

    //Redimensiona el array duplicando su capacidad
    public void redimensionar() {
        Pasajero[] nuevo = new Pasajero[pasajeros.length * 2];
        for (int i = 0; i < totalPasajeros; i++) {
            nuevo[i] = pasajeros[i];
        }
        pasajeros = nuevo;
        System.out.println("Array redimensionado, Nueva capacidad: " + pasajeros.length);
    }

    //Getters

    public int getTotalPasajeros() {
        return totalPasajeros;
    }

    //Devuelve copia del array con solo los pasajeros activos
    public String getPasajeros() {
        if (totalPasajeros == 0) return "No hay pasajeros almacenados";
        String resultado = "";
        for (int i = 0; i < totalPasajeros; i++) {
            resultado += "  [" + (i + 1) + "] " + pasajeros[i] + "\n";
        }
        return resultado;
    }

}