public class PuertaOcupadaException extends RuntimeException {

    private String puerta;

    public PuertaOcupadaException(String puerta) {
        super("La puerta de embarque '" + puerta + "' ya esta ocupada y no puede recibir otro vuelo.");
        this.puerta = puerta;
    }

    public String getPuerta() {
        return puerta;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

