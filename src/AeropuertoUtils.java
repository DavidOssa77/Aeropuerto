//Clase utilitaria con métodos estáticos de uso general en el sistema aeroportuario

public class AeropuertoUtils {

    // Constructor
    private AeropuertoUtils() {
    }

    //Valida que un horario tenga el formato HH:mm
    public static boolean validarHorario(String h) {
        if (h == null || h.isBlank()) return false;
        if (h.length() != 5) return false;
        if (h.charAt(2) != ':') return false;
        try {
            int horas = Integer.parseInt(h.substring(0, 2));
            int minutos = Integer.parseInt(h.substring(3, 5));
            return horas >= 0 && horas <= 23
                    && minutos >= 0 && minutos <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
