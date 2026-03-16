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
                if (puertas[i] != null) {
                    if (puertas[i].estaDisponible()) {
                        puertas[i].asignarVuelo(v);
                        return;
                    }
                }
            }
            throw new Exception("Todas las puertas estan ocupadas, no se pudo asignar el vuelo.");
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public void verificarConflictos() {
        System.out.println("\n=== Puertas con vuelos a la misma hora ===");
        boolean hayAlguno = false;

        for (int i = 0; i < totalPuertas; i++) {
            for (int j = i + 1; j < totalPuertas; j++) {
                if (puertas[i] != null) {
                    if (puertas[j] != null) {
                        if (puertas[i].getVueloAsignado() != null) {
                            if (puertas[j].getVueloAsignado() != null) {
                                if (puertas[i].getVueloAsignado().getHoraSalida().equals(puertas[j].getVueloAsignado().getHoraSalida())) {
                                    System.out.println("Hora: " + puertas[i].getVueloAsignado().getHoraSalida()
                                            + " | Puerta " + puertas[i].getNumeroPuerta()
                                            + " - " + puertas[i].getVueloAsignado().getAerolinea()
                                            + " " + puertas[i].getVueloAsignado().getCodigoVuelo()
                                            + " | Puerta " + puertas[j].getNumeroPuerta()
                                            + " - " + puertas[j].getVueloAsignado().getAerolinea()
                                            + " " + puertas[j].getVueloAsignado().getCodigoVuelo());
                                    hayAlguno = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!hayAlguno) {
            System.out.println("No hay puertas con vuelos a la misma hora.");
        }
        System.out.println("==========================================\n");
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