public abstract class Persona {

    //Atributos
    protected String nombre;
    protected String identificacion;
    protected String nacionalidad;

    //Constructor
    public Persona(String nombre, String identificacion, String nacionalidad) {
        this.nombre        = nombre;
        this.identificacion = identificacion;
        this.nacionalidad  = nacionalidad;
    }

    public abstract String getRol();

    public abstract void agregarVuelo(Vuelo vuelo);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona otra = (Persona) obj;
        // Dos personas son iguales si tienen la misma identificación
        return identificacion != null && identificacion.equals(otra.identificacion);
    }

    @Override
    public int hashCode() {
        return identificacion != null ? identificacion.hashCode() : 0;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
