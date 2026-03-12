public class VueloNacional extends Vuelo  {

    // Constructor
    public VueloNacional(String codigoVuelo, String origen, String destino,
                         String horaSalida, String aerolinea) {
        super(codigoVuelo, origen, destino, horaSalida, aerolinea);
    }

    // Método abstracto herdedado
    @Override
    public String getTipoVuelo() {
        return "Nacional";
    }

    // Métodos obligatorio de la interfaz Validable
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
        return "VueloNacional[" +
                "codigo=" + codigoVuelo +
                ", origen=" + origen +
                ", destino=" + destino +
                ", horaSalida=" + horaSalida +
                ", aerolinea=" + aerolinea +
                ", estado=" + estado +
                "]";
    }
}