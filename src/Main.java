public class Main {
    public static void main(String[] args) {

        GestorVuelos gestor = new GestorVuelos();

        VueloNacional vuelo1 = new VueloNacional("AV201", "Bogotá", "Medellín", "14:30", "Avianca");
        VueloNacional vuelo2 = new VueloNacional("AV305", "Bogotá", "Cali", "09:00", "Avianca");
        VueloInternacional vuelo3 = new VueloInternacional("LA500", "Bogotá", "Miami", "08:00", "LATAM", "Estados Unidos", true);
        VueloInternacional vuelo4 = new VueloInternacional("IB900", "Bogotá", "Madrid", "22:00", "Iberia", "España", false);

        System.out.println("--------------------------------");
        System.out.println("--- PRUEBAS GESTOR VUELOS ---");
        System.out.println("--------------------------------");

// PRUEBA 1: Agregar vuelos correctos
        System.out.println("\n--- PRUEBA 1: Agregar vuelos correctos ---");
        gestor.agregarVuelo(vuelo1);
        gestor.agregarVuelo(vuelo2);
        gestor.agregarVuelo(vuelo3);
        gestor.agregarVuelo(vuelo4);

// PRUEBA 2: Listar vuelos
        System.out.println("\n--- PRUEBA 2: Listar vuelos ---");
        gestor.listarVuelos();

// PRUEBA 3: Agregar vuelo nulo
        System.out.println("\n--- PRUEBA 3: Agregar vuelo nulo ---");
        gestor.agregarVuelo(null);

// PRUEBA 4: Agregar vuelo con datos invalidos
        System.out.println("\n--- PRUEBA 4: Agregar vuelo con datos invalidos ---");
        VueloNacional vueloInvalido = new VueloNacional("", "Bogotá", "Medellín", "14:30", "Avianca");
        gestor.agregarVuelo(vueloInvalido);

// PRUEBA 5: Agregar vuelo con conflicto — demuestra hayConflicto()
        System.out.println("\n--- PRUEBA 5: Agregar vuelo con conflicto origen-destino ---");
        VueloNacional vueloConflicto = new VueloNacional("AV999", "Bogotá", "Bogotá", "10:00", "Avianca");
        gestor.agregarVuelo(vueloConflicto);

// PRUEBA 6: Agregar vuelo duplicado
        System.out.println("\n--- PRUEBA 6: Agregar vuelo duplicado ---");
        VueloNacional vuelo1Duplicado = new VueloNacional("AV201", "Bogotá", "Medellín", "14:30", "Avianca");
        gestor.agregarVuelo(vuelo1Duplicado);

// PRUEBA 7: Agregar vuelo cancelado
        System.out.println("\n--- PRUEBA 7: Agregar vuelo cancelado ---");
        VueloNacional vueloCancelado = new VueloNacional("AV777", "Bogotá", "Pereira", "11:00", "Avianca");
        vueloCancelado.cancelar();
        gestor.agregarVuelo(vueloCancelado);

// PRUEBA 8: Buscar vuelo existente
        System.out.println("\n--- PRUEBA 8: Buscar vuelo existente ---");
        gestor.buscarVuelo("LA500");

// PRUEBA 9: Buscar vuelo no existente
        System.out.println("\n--- PRUEBA 9: Buscar vuelo no existente ---");
        gestor.buscarVuelo("XX999");

// PRUEBA 10: Cancelar vuelo
        System.out.println("\n--- PRUEBA 10: Cancelar vuelo existente ---");
        gestor.cancelarVuelo("AV201");

// PRUEBA 11: Cancelar vuelo ya cancelado —
        System.out.println("\n--- PRUEBA 11: Cancelar vuelo ya cancelado ---");
        gestor.cancelarVuelo("AV201");

// PRUEBA 12: Cancelar vuelo no existente
        System.out.println("\n--- PRUEBA 12: Cancelar vuelo no existente ---");
        gestor.cancelarVuelo("XX000");

// PRUEBA 13: Validar todos
        System.out.println("\n--- PRUEBA 13: Validar todos los vuelos ---");
        gestor.validarTodos();

// PRUEBA 14: Getters y setters
        System.out.println("\n--- PRUEBA 14: Getters y setters ---");
        System.out.println("Codigo: " + vuelo1.getCodigoVuelo());
        System.out.println("Origen: " + vuelo1.getOrigen());
        System.out.println("Aerolinea antes: " + vuelo1.getAerolinea());
        vuelo1.setAerolinea("Latam");
        System.out.println("Aerolinea despues: " + vuelo1.getAerolinea());
        System.out.println("Estado antes: " + vuelo1.getEstado());
        vuelo1.setEstado(EstadoVuelo.EN_EMBARQUE);
        System.out.println("Estado despues: " + vuelo1.getEstado());
        System.out.println("Pais destino antes: " + vuelo3.getPaisDestino());
        vuelo3.setPaisDestino("Canada");
        System.out.println("Pais destino despues: " + vuelo3.getPaisDestino());

// PRUEBA 15: Redimensionamiento del array — demuestra AeropuertoUtils
        System.out.println("\n--- PRUEBA 15: Redimensionamiento del array ---");
        GestorVuelos gestorRedim = new GestorVuelos();
        for (int i = 1; i <= 11; i++) {
            VueloNacional vueloTemp = new VueloNacional("AV" + i, "Bogotá", "Medellín", "10:00", "Avianca");
            gestorRedim.agregarVuelo(vueloTemp);
        }
        System.out.println("Total vuelos tras redimensionar: " + gestorRedim.getTotalVuelos());



    }


}
