public class Tripulacion extends Persona {

    //Atributos
    private String  cargo;
    private String  licencia;
    private Vuelo[] vuelosAsignados;
    private int totalVuelos;

    private static final int CAPACIDAD_INICIAL = 10;

    //Constructor
    public Tripulacion(String nombre, String identificacion, String nacionalidad,
                       String cargo, String licencia) {
        super(nombre, identificacion, nacionalidad);
        this.cargo = cargo;
        this.licencia = licencia;
        this.vuelosAsignados = new Vuelo[CAPACIDAD_INICIAL];
        this.totalVuelos = 0;
    }



    @Override
    public void agregarVuelo(Vuelo vuelo) {
        if (vuelo == null) return;
        if (totalVuelos == vuelosAsignados.length) {
            redimensionar();
        }
        vuelosAsignados[totalVuelos] = vuelo;
        totalVuelos++;
    }

    //Métodos propios

    public void asignarVuelo(Vuelo vuelo) {
        if (vuelo == null) return;
        for (int i = 0; i < totalVuelos; i++) {
            if (vuelosAsignados[i].equals(vuelo)) {
                System.out.println("El vuelo ya está asignado a " + nombre);
                return;
            }
        }
        agregarVuelo(vuelo);
    }

    private void redimensionar() {
        Vuelo[] nuevo = new Vuelo[vuelosAsignados.length * 2];
        for (int i = 0; i < totalVuelos; i++) {
            nuevo[i] = vuelosAsignados[i];
        }
        vuelosAsignados = nuevo;
    }

    //Sobrescritura de Object

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Tripulacion{"
                + "nombre= '" + nombre          + '\''
                + ", id= '" + identificacion   + '\''
                + ", nacionalidad= '" + nacionalidad     + '\''
                + ", cargo= '" + cargo            + '\''
                + ", licencia= '" + licencia         + '\''
                + ", vuelosAsignados= '"+ totalVuelos     + "'}";
    }

    //Getters y Setters


    @Override
    public String getRol() {
        return cargo;
    }

    public void setRol(String cargo) {
        this.cargo = cargo;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getTotalVuelos() {
        return totalVuelos;
    }

    public String getVuelosAsignados() {
        if (totalVuelos == 0) return "Sin vuelos asignados.";
        String resultado = "";
        for (int i = 0; i < totalVuelos; i++) {
            resultado += "  [" + (i + 1) + "] " + vuelosAsignados[i] + "\n";
        }
        return resultado;
    }
}