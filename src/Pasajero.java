public class Pasajero extends Persona implements Validable {

    //Atributos
    private String  asiento;
    private Vuelo[] vuelos;
    private int totalVuelos;
    private double  pesoEquipaje;

    private static final int CAPACIDAD_INICIAL = 10;
    private static final double LIMITE_EQUIPAJE   = 23.0;

    //Constructor
    public Pasajero(String nombre, String identificacion, String nacionalidad,
                    String asiento, double pesoEquipaje) {
        super(nombre, identificacion, nacionalidad);
        this.asiento      = asiento;
        this.pesoEquipaje = pesoEquipaje;
        this.vuelos       = new Vuelo[CAPACIDAD_INICIAL];
        this.totalVuelos  = 0;
    }



    //Sirve para actualizar los vuelos y la cantidad después de inicializar las variables en el constructor
    @Override
    public void agregarVuelo(Vuelo vuelo) {
        if (vuelo == null) return;
        if (totalVuelos == vuelos.length) {
            redimensionar();
        }
        vuelos[totalVuelos] = vuelo;
        totalVuelos++;
    }


    //Un pasajero es válido si tiene nombre, identificación, asiento asignado no nulos
    // y un peso de equipaje no negativo
    @Override
    public boolean validar() {
        return nombre != null && !nombre.isBlank()
                && identificacion != null && !identificacion.isBlank()
                && asiento != null && !asiento.isBlank()
                && pesoEquipaje  >= 0;
    }

    //Se define el conflicto como un exceso de equipaje
    @Override
    public boolean hayConflicto() {
        return pesoEquipaje > LIMITE_EQUIPAJE;
    }


    //Métodos propios

    //Indica si el equipaje supera el límite de 23 kg
    public boolean equipajePesado() {
        return hayConflicto();
    }

    //Redimensiona el array de vuelos duplicando su capacidad
    private void redimensionar() {
        Vuelo[] nuevo = new Vuelo[vuelos.length * 2];
        for (int i = 0; i < totalVuelos; i++) {
            nuevo[i] = vuelos[i];
        }
        vuelos = nuevo;
    }

    //Sobrescritura de Object

    //Dos pasajeros son iguales si tienen la misma identificación
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //Se sobreescribe el hash para seguir la lógica de equals
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    //Utilización del toString para que al instanciar la clase podamos ver sus atributos con sout
    @Override
    public String toString() {
        return "Pasajero{"
                + "nombre= '" +nombre+ '\''
                + ", id= '" +identificacion+'\''
                + ", nacionalidad= '" +nacionalidad+'\''
                + ", asiento= '"+ asiento+'\''
                + ", pesoEquipaje= '"+pesoEquipaje+ "kg'"
                + ", totalVuelos= '"+totalVuelos+"'}";
    }

    //Getters y Setters


    @Override
    public String getRol() {
        return "Pasajero";
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public double getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(double pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    public int getTotalVuelos() {
        return totalVuelos;
    }
    //nos muestra los vuelos (puede que haya espacios vacíos en el array pero la copia solo toma los índices no nulos)
    public Vuelo[] getVuelos() {
        Vuelo[] copia = new Vuelo[totalVuelos];
        for (int i = 0; i < totalVuelos; i++) {
            copia[i] = vuelos[i];
        }
        return copia;
    }
}