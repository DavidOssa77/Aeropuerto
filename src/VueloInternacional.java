public class VueloInternacional extends Vuelo  {

    // Atributos
    private String paisDestino;
    private boolean requiereVisa;

    // Constructor
    public VueloInternacional(String codigoVuelo, String origen, String destino,
                              String horaSalida, String aerolinea,
                              String paisDestino, boolean requiereVisa) {
        super(codigoVuelo, origen, destino, horaSalida, aerolinea);
        this.paisDestino = paisDestino;
        this.requiereVisa = requiereVisa;
    }

    // Método abstracto herdedado
    @Override
    public String getTipoVuelo() {
        return "Internacional";
    }

    // Getters y Setters
    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public boolean isRequiereVisa() {
        return requiereVisa;
    }

    public void setRequiereVisa(boolean requiereVisa) {
        this.requiereVisa = requiereVisa;
    }

    // Métodos obligatorios de la interfaz Validable
    @Override
    public boolean validar() {
        if (codigoVuelo == null || codigoVuelo.isEmpty()) {
            return false;
        }
        if (origen == null || origen.isEmpty()) {
            return false;
        }
        if (destino == null || destino.isEmpty()) {
            return false;
        }
        if (horaSalida == null || horaSalida.isEmpty()) {
            return false;
        }
        if (aerolinea == null || aerolinea.isEmpty()) {
            return false;
        }
        if (paisDestino == null || paisDestino.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hayConflicto() {
        if (origen.equals(destino)) {
            return true;
        }
        return false;
    }



    // Sobrescritura obligatoria de métodos de Object
    @Override
    public String toString() {
        return "VueloInternacional[" +
                "codigo=" + codigoVuelo +
                ", origen=" + origen +
                ", destino=" + destino +
                ", horaSalida=" + horaSalida +
                ", aerolinea=" + aerolinea +
                ", paisDestino=" + paisDestino +
                ", requiereVisa=" + requiereVisa +
                ", estado=" + estado +
                "]";
    }
}