public class PuertaEmbarque implements Validable {

    private String  numeroPuerta;
    private int     capacidad;
    private boolean ocupada;
    private Vuelo[] vuelosAsignados;
    private int     totalVuelos;

    private static final int CAPACIDAD_INICIAL = 5;

    public PuertaEmbarque(String numeroPuerta, int capacidad) {
        this.numeroPuerta    = numeroPuerta;
        this.capacidad       = capacidad;
        this.ocupada         = false;
        this.vuelosAsignados = new Vuelo[CAPACIDAD_INICIAL];
        this.totalVuelos     = 0;
    }

    public void asignarVuelo(Vuelo v) {
        try {
            if (ocupada) {
                throw new PuertaOcupadaException(numeroPuerta);
            }
            if (totalVuelos == vuelosAsignados.length) {
                redimensionar();
            }
            vuelosAsignados[totalVuelos] = v;
            totalVuelos++;
            ocupada = true;
            System.out.println("[Puerta " + numeroPuerta + "] Vuelo '"
                    + v.getCodigoVuelo() + "' asignado correctamente.");
        } catch (PuertaOcupadaException e) {
            System.out.println("[ERROR] No se pudo asignar el vuelo. " + e.getMessage());
        }
    }

    public void liberarPuerta() {
        this.ocupada = false;
        System.out.println("[Puerta " + numeroPuerta + "] Puerta liberada y disponible.");
    }

    public boolean estaDisponible() {
        return !ocupada;
    }

    @Override
    public boolean validar() {
        if (numeroPuerta == null) {
            return false;
        }
        if (capacidad <= 0) {
            return false;
        }
        return true;
    }

    public Vuelo getVueloAsignado() {
        if (totalVuelos == 0) {
            return null;
        }
        return vuelosAsignados[totalVuelos - 1];
    }

    @Override
    public boolean hayConflicto() {
        return false;
    }

    private void redimensionar() {
        Vuelo[] nuevo = new Vuelo[vuelosAsignados.length * 2];
        for (int i = 0; i < totalVuelos; i++) {
            nuevo[i] = vuelosAsignados[i];
        }
        vuelosAsignados = nuevo;
    }

    public String getNumeroPuerta() { return numeroPuerta; }

    public int getCapacidad()       { return capacidad; }

    public boolean isOcupada()      { return ocupada; }

    public int getTotalVuelos()     { return totalVuelos; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PuertaEmbarque otra = (PuertaEmbarque) obj;
        return numeroPuerta.equals(otra.numeroPuerta);
    }

    @Override
    public int hashCode() {
        return numeroPuerta.hashCode();
    }

    @Override
    public String toString() {
        return "PuertaEmbarque{"
                + "numero='" + numeroPuerta + '\''
                + ", capacidad=" + capacidad
                + ", ocupada=" + ocupada
                + ", totalVuelos=" + totalVuelos
                + '}';
    }
}

