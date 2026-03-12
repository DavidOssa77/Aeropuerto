public abstract class Vuelo implements Validable, Cancelable {

    // Atributos
    protected String codigoVuelo;
    protected String origen;
    protected String destino;
    protected String horaSalida;
    protected String aerolinea;
    protected EstadoVuelo estado;
    protected PuertaEmbarque puerta;

    // Constructor
    public Vuelo(String codigoVuelo, String origen, String destino,
                 String horaSalida, String aerolinea) {
        this.codigoVuelo = codigoVuelo;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.aerolinea = aerolinea;
        this.estado = EstadoVuelo.PROGRAMADO;
        this.puerta = null;
    }

    // Método abstracto
    public abstract String getTipoVuelo();

    // definimos los métodos de la interfaz validable como asbtractos
    // con el fin de que se tengan que usar obligatoriamente en las clases hijas
    public abstract boolean validar();
    public abstract boolean hayConflicto();


    // Getters y Setters
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public EstadoVuelo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }


    public PuertaEmbarque getPuerta() {
        return puerta;
    }

    public void setPuerta(PuertaEmbarque puerta) {
        this.puerta = puerta;
    }

    // Métodos obligatorios de la interfaz Cancelable
    public void cancelar() {
        this.estado = EstadoVuelo.CANCELADO;
    }

    public boolean estaCancelado() {
        return this.estado == EstadoVuelo.CANCELADO;
    }

    // Sobreescritura obligatoria de métodos de Object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Vuelo)) return false;
        Vuelo otro = (Vuelo) obj;
        return this.codigoVuelo.equals(otro.codigoVuelo);
    }

    @Override
    public int hashCode() {
        return codigoVuelo.hashCode();
    }

    @Override
    public String toString() {
        return "Vuelo[" +
                "codigo=" + codigoVuelo +
                ", origen=" + origen +
                ", destino=" + destino +
                ", horaSalida=" + horaSalida +
                ", aerolinea=" + aerolinea +
                ", estado=" + estado +
                ", tipo=" + getTipoVuelo() +
                "]";
    }
}
