public class GestorVuelos {

    // Atributos
    private Vuelo[] vuelos;
    private int totalVuelos;
    private static final int CAPACIDAD_INICIAL = 10;

    // Constructor
    public GestorVuelos() {
        this.vuelos = new Vuelo[CAPACIDAD_INICIAL];
        this.totalVuelos = 0;
    }

    // Método para agregar vuelos al array
    public void agregarVuelo(Vuelo v) {
        try {
            if (v == null) {
                throw new VueloInvalidoException("El vuelo no puede ser nulo.");
            }
            if (!v.validar()) {
                throw new VueloInvalidoException("El vuelo " + v.getCodigoVuelo() + " tiene datos invalidos.");
            }
            if (v.hayConflicto()) {
                throw new VueloInvalidoException("El vuelo " + v.getCodigoVuelo() + " tiene conflicto de origen y destino.");
            }
            if (v.estaCancelado()) {
                throw new VueloCanceladoException("No se puede agregar el vuelo " + v.getCodigoVuelo() + " porque esta cancelado.");
            }
            for (int i = 0; i < totalVuelos; i++) {
                if (vuelos[i].equals(v)) {
                    throw new VueloInvalidoException("El vuelo " + v.getCodigoVuelo() + " ya existe.");
                }
            }
            if (totalVuelos == vuelos.length) {
                redimensionar();
            }
            vuelos[totalVuelos] = v;
            totalVuelos++;
            System.out.println("Vuelo " + v.getCodigoVuelo() + " agregado correctamente.");
        } catch (VueloInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (VueloCanceladoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para buscar un vuelo
    public Vuelo buscarVuelo(String codigoVuelo) {
        try {
            if (codigoVuelo == null || codigoVuelo.isEmpty()) {
                throw new VueloInvalidoException("El codigo de vuelo no puede ser nulo o vacio.");
            }
            for (int i = 0; i < totalVuelos; i++) {
                if (vuelos[i].getCodigoVuelo().equals(codigoVuelo)) {
                    System.out.println("Vuelo encontrado: " + vuelos[i].toString());
                    return vuelos[i];
                }
            }
            throw new VueloInvalidoException("Vuelo " + codigoVuelo + " no encontrado.");
        } catch (VueloInvalidoException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Método para cancelar un vuelo
    public void cancelarVuelo(String codigoVuelo) {
        try {
            Vuelo v = buscarVuelo(codigoVuelo);
            if (v == null) {
                throw new VueloInvalidoException("No se puede cancelar, vuelo " + codigoVuelo + " no encontrado.");
            }
            if (v.estaCancelado()) {
                throw new VueloCanceladoException("El vuelo " + codigoVuelo + " ya estaba cancelado.");
            }
            v.cancelar();
            System.out.println("Vuelo " + codigoVuelo + " cancelado correctamente.");
        } catch (VueloInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (VueloCanceladoException e) {
            System.out.println(e.getMessage());
        }
    }


    // Método para listar los vuelos
    public void listarVuelos() {
        if (totalVuelos == 0) {
            System.out.println("No hay vuelos registrados.");
            return;
        }
        System.out.println("VUELOS REGISTRADOS:");
        for (int i = 0; i < totalVuelos; i++) {
            System.out.println(vuelos[i].toString());
        }
    }

    // Método para validar todos los vuelos
    public void validarTodos() {
        System.out.println("VALIDANDO VUELOS:");
        for (int i = 0; i < totalVuelos; i++) {
            if (vuelos[i].validar()) {
                System.out.println("Vuelo " + vuelos[i].getCodigoVuelo() + ": VALIDO");
            } else {
                System.out.println("Vuelo " + vuelos[i].getCodigoVuelo() + ": INVALIDO");
            }
        }
    }

    // Método para redimensionar el espacio del array
    private void redimensionar() {
        Vuelo[] nuevoArray = new Vuelo[vuelos.length * 2];
        for (int i = 0; i < totalVuelos; i++) {
            nuevoArray[i] = vuelos[i];
        }
        vuelos = nuevoArray;
        System.out.println("Array redimensionado a " + vuelos.length + " espacios.");
    }

    // Getter
    public int getTotalVuelos() {
        return totalVuelos;
    }
}