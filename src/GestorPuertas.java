public class GestorPuertas {

    private PuertaEmbarque[] puertas;
    private int              totalPuertas;

    private static final int CAPACIDAD_INICIAL = 10;

    public GestorPuertas() {
        this.puertas      = new PuertaEmbarque[CAPACIDAD_INICIAL];
        this.totalPuertas = 0;
    }

    public void agregarPuerta(PuertaEmbarque p) {
        try {
            if (p == null || !p.validar()) {
                throw new Exception("La puerta es nula o no paso la validacion.");
            }
            for (int i = 0; i < totalPuertas; i++) {
                if (puertas[i].equals(p)) {
                    throw new Exception("La puerta '" + p.getNumeroPuerta() + "' ya esta registrada.");
                }
            }
            if (totalPuertas == puertas.length) {
                redimensionar();
            }
            puertas[totalPuertas] = p;
            totalPuertas++;
            System.out.println("[GestorPuertas] Puerta '" + p.getNumeroPuerta() + "' agregada.");
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void asignarPuerta(Vuelo v) {
        try {
            if (v == null) {
                throw new Exception("El vuelo no puede ser nulo.");
            }
            for (int i = 0; i < totalPuertas; i++) {
                if (puertas[i].estaDisponible()) {
                    puertas[i].asignarVuelo(v);
                    return;
                }
            }
            throw new PuertaOcupadaException("SIN_PUERTA_DISPONIBLE");
        } catch (PuertaOcupadaException e) {
            System.out.println("[ERROR] No hay puertas disponibles. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void verificarConflictos() {
        System.out.println("\n=== Verificacion de conflictos de horario ===");
        boolean hayAlguno = false;
        for (int i = 0; i < totalPuertas; i++) {
            if (puertas[i].hayConflicto()) {
                System.out.println("[CONFLICTO] Puerta '"
                        + puertas[i].getNumeroPuerta()
                        + "' tiene vuelos con horarios en conflicto.");
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("Sin conflictos detectados.");
        }
        System.out.println("=============================================\n");
    }

    public void listarPuertas() {
        System.out.println("\n========== Puertas de Embarque ==========");
        if (totalPuertas == 0) {
            System.out.println("No hay puertas registradas.");
        } else {
            for (int i = 0; i < totalPuertas; i++) {
                System.out.println((i + 1) + ". " + puertas[i].toString());
            }
        }
        System.out.println("=========================================\n");
    }

    private void redimensionar() {
        PuertaEmbarque[] nuevo = new PuertaEmbarque[puertas.length * 2];
        for (int i = 0; i < totalPuertas; i++) {
            nuevo[i] = puertas[i];
        }
        puertas = nuevo;
        System.out.println("[GestorPuertas] Arreglo redimensionado a " + puertas.length + " posiciones.");
    }

    public int getTotalPuertas() { return totalPuertas; }

    public PuertaEmbarque getPuerta(int indice) {
        if (indice < 0 || indice >= totalPuertas) {
            return null;
        }
        return puertas[indice];
    }
}