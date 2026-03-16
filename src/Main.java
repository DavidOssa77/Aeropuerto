public class Main {

    public static void main(String[] args) {


        System.out.println("--------------------------------");
        System.out.println("--- PRUEBAS GESTOR VUELOS ---");
        System.out.println("--------------------------------");

        GestorVuelos gestor = new GestorVuelos();

        VueloNacional vuelo1 = new VueloNacional("AV201", "Bogotá", "Medellín", "14:30", "Avianca");
        VueloNacional vuelo2 = new VueloNacional("AV305", "Bogotá", "Cali", "09:00", "Avianca");
        VueloInternacional vuelo3 = new VueloInternacional("LA500", "Bogotá", "Miami", "08:00", "LATAM", "Estados Unidos", true);
        VueloInternacional vuelo4 = new VueloInternacional("IB900", "Bogotá", "Madrid", "22:00", "Iberia", "España", false);


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


        System.out.println("--------------------------------");
        System.out.println("------ PRUEBAS PASAJERO --------");
        System.out.println("--------------------------------");


        Pasajero p1 = new Pasajero("Juan", "1234", "Colombiana", "D14", 19.6);
        Pasajero p2 = new Pasajero("Nicolás", "2468", "Peruana", "A28", 23.0);
        Pasajero p3 = new Pasajero("Manuela", "1357", "Colombiana", "A1", 23.1);
        Pasajero p4 = new Pasajero("Tomás", "", "Venezolana", "C5", 17.0);

        // PRUEBA 1: visualización de los pasajeros
        System.out.println("\nPRUEBA 1: visualización de los pasajeros\n");
        System.out.println(p1);
        System.out.println(p2);
        p2.setAsiento("A15"); //prueba del setter
        System.out.println(p2); //Cambio de asiento
        System.out.println(p3);
        System.out.println(p4);

        // PRUEBA 2: validación
        System.out.println("\nPRUEBA 2: validación\n");
        System.out.println("pasajero 1 válido: " + p1.validar());
        System.out.println("pasajero 2 válido: " + p2.validar());
        System.out.println("pasajero 3 válido: " + p3.validar());
        System.out.println("pasajero 4 válido: " + p4.validar());

        // PRUEBA 3: existencia de equipajePesado()
        System.out.println("\nPRUEBA 3: existencia de equipajePesado()\n");
        System.out.println("pasajero 1 con exceso de equipaje: " + p1.equipajePesado());
        System.out.println("pasajero 2 con exceso de equipaje: " + p2.equipajePesado()); // funciona en la frontera
        System.out.println("pasajero 3 con exceso de equipaje: " + p3.equipajePesado());
        p3.setPesoEquipaje(23.0); //prueba del setter
        System.out.println("pasajero 3 con exceso de equipaje: " + p3.equipajePesado()); //ahora si es válido
        System.out.println("pasajero 4 con exceso de equipaje: " + p4.equipajePesado());

        // PRUEBA 4: equals() y hashCode()
        System.out.println("\nPRUEBA 4: equals() y hashCode()\n");
        Pasajero p1copy = new Pasajero("Juan", "1234", "Colombiana", "D14", 19.6);
        System.out.println("p1 == p1copy (misma id): " + p1.equals(p1copy));
        System.out.println("p1 == p2 (distinta id): " + p1.equals(p2));
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p1copy.hashCode(): " + p1copy.hashCode());

// PRUEBA 5: getRol()
        System.out.println("\nPRUEBA 5: getRol()\n");
        System.out.println("Rol p1: " + p1.getRol());

// PRUEBA 6: asignación de vuelos
        System.out.println("\nPRUEBA 6: asignación de vuelos");
        p1.agregarVuelo(vuelo1);
        p1.agregarVuelo(vuelo3);
        System.out.println("p1.getVuelos(): " + p1.getVuelos());
        System.out.println("p2.getVuelos(): " + p2.getVuelos());//no tiene vuelos asignados todavía
        System.out.println("p1.getTotalVuelos() " + p1.getTotalVuelos());


        System.out.println("--------------------------------");
        System.out.println("----- PRUEBAS Tripulación ------");
        System.out.println("--------------------------------");


        Tripulacion t1 = new Tripulacion("Camilo", "7543", "Colombiana", "Piloto", "AA11");
        Tripulacion t2 = new Tripulacion("Juan", "9345", "Alemán", "Copiloto", "BA11");
        Tripulacion t3 = new Tripulacion("Sofia", "2451", "Canadiense", "Azafata", "CA11");
        Tripulacion t4 = new Tripulacion("Julián", "4832", "Colombiana", "Azafato", "CA12");

//PRUEBA 1: Visualizar tripulación
        System.out.println("\nPRUEBA 1: Visualizar tripulación");
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);

//PRUEBA 2: getRol() en este caso cargo
        System.out.println("\n getRol() en este caso cargo\n");
        System.out.println(("t1.getRol(): " + t1.getRol()));
        System.out.println(("t2.getRol(): " + t2.getRol()));
        System.out.println(("t3.getRol(): " + t3.getRol()));
        t3.setRol("Capitana");
        t3.setLicencia("AA12");
        System.out.println("Nuevo rol t3: " + t3.getRol());
        System.out.println("Nueva licencia t3: " + t3.getLicencia());
        System.out.println(("t4.getRol(): " + t4.getRol()));

//PRUEBA 3: asinación de vuelos
        System.out.println("\nPRUEBA 3: asignación de vuelos");
        t1.asignarVuelo(vuelo1);
        t1.asignarVuelo(vuelo4);
        System.out.println("vuelos t1: " + t1.getVuelosAsignados());
        System.out.println("total vuelos t1: " + t1.getTotalVuelos());
        System.out.println("vuelos t2 " + t2.getVuelosAsignados());
        System.out.println("total vuelos t2: " + t2.getTotalVuelos());


        System.out.println("--------------------------------");
        System.out.println("--- PRUEBAS GestorPasajeros ----");
        System.out.println("--------------------------------");

        GestorPasajeros gestor1 = new GestorPasajeros();

//PRUEBA 1: registrar pasajero normal
        System.out.println("\nPRUEBA 1 registrar pasajero normal\n");
        try {
            gestor1.registrarPasajero(p1);
            gestor1.registrarPasajero(p2);
            gestor1.registrarPasajero(p3);
            System.out.println("Total pasajeros " + gestor1.getTotalPasajeros());
        } catch (PasajeroDuplicadoException e) {
            System.out.println("Error, hay pasajeros duplicados: " + e.getMessage());
        }
//PRUEBA 2: registrar pasajero duplicado
        System.out.println("\nPRUEBA 2 registrar pasajero duplicado\n");
        try {
            gestor1.registrarPasajero(p1copy);
            System.out.println("Total pasajeros " + gestor1.getTotalPasajeros());
        } catch (PasajeroDuplicadoException e) {
            System.out.println("Error, hay pasajeros duplicados: " + e.getMessage());
        }

//PRUEBA 3: registrar pasajero nulo
        System.out.println("\nPRUEBA 3 registrar pasajero nulo\n");
        try {
            gestor1.registrarPasajero(null);
            System.out.println("Total pasajeros " + gestor1.getTotalPasajeros()); //ignora el nulo
        } catch (PasajeroDuplicadoException e) {
            System.out.println("Error, hay pasajeros duplicados: " + e.getMessage());
        }

//PRUEBA 4: listar pasajeros
        System.out.println("\nPRUEBA 4 listar pasajeros\n");
        System.out.println(gestor1.listarPasajeros());

//PRUEBA 5: buscar pasajeros existentes y no existentes
        System.out.println("\nPRUEBA 5: buscar pasajeros existentes y no existentes\n");
        gestor1.buscarPasajero("1357");
        gestor1.buscarPasajero("99999");

//PRUEBA 6: eliminar pasajero existente e inexistente
        System.out.println("\nPRUEBA 6: eliminar pasajero existente\n");
        gestor1.eliminarPasajero("2468");
        gestor1.eliminarPasajero("2468");
        System.out.println(gestor1.getPasajeros());
        System.out.println("Nuevo total de pasajeros: " + gestor1.getTotalPasajeros());

//PRUEBA 7: redimensionar
        System.out.println("\nPRUEBA 7: redimensionar\n");
        GestorPasajeros gestorGrande = new GestorPasajeros();
        try {
            for (int i = 1; i <= 12; i++) {
                Pasajero p = new Pasajero("Pasajero" + i, "ID" + i, "Colombiana", i + "A", 10.0);
                gestorGrande.registrarPasajero(p);
            }
            System.out.println("Total registrados: " + gestorGrande.getTotalPasajeros()); // 12
        } catch (PasajeroDuplicadoException e) {
            System.out.println("Error: " + e.getMessage());
        }



        System.out.println("--------------------------------");
        System.out.println("--- PRUEBAS GESTOR PUERTAS ---");
        System.out.println("--------------------------------");

        System.out.println("\n--- PRUEBA 1: Crear una puerta valida ---");
        PuertaEmbarque puerta1 = new PuertaEmbarque("A3", 200);
        System.out.println("Resultado: " + puerta1.toString());

        System.out.println("\n--- PRUEBA 2: Crear una puerta con capacidad invalida ---");
        PuertaEmbarque puerta2 = new PuertaEmbarque("B1", -50);
        System.out.println("La puerta es valida: " + puerta2.validar());

        System.out.println("\n--- PRUEBA 3: Crear una puerta con numeroPuerta null ---");
        PuertaEmbarque puerta3 = new PuertaEmbarque(null, 100);
        System.out.println("La puerta es valida: " + puerta3.validar());

        System.out.println("\n--- PRUEBA 4: Verificar que una puerta nueva esta disponible ---");
        PuertaEmbarque puerta4 = new PuertaEmbarque("C5", 150);
        System.out.println("Esta disponible: " + puerta4.estaDisponible());

        System.out.println("\n--- PRUEBA 5: Asignar un vuelo a una puerta disponible ---");
        PuertaEmbarque puerta5 = new PuertaEmbarque("D2", 180);
        puerta5.asignarVuelo(vuelo2);

        System.out.println("\n--- PRUEBA 6: Asignar un vuelo a una puerta ya ocupada ---");
        puerta5.asignarVuelo(vuelo3);

        System.out.println("\n--- PRUEBA 7: Liberar una puerta ocupada ---");
        puerta5.liberarPuerta();

        System.out.println("\n--- PRUEBA 8: Comparar dos puertas con el mismo numero ---");
        PuertaEmbarque puerta6 = new PuertaEmbarque("A3", 200);
        PuertaEmbarque puerta7 = new PuertaEmbarque("A3", 100);
        System.out.println("Son iguales: " + puerta6.equals(puerta7));

        System.out.println("\n--- PRUEBA 9: Comparar dos puertas con diferente numero ---");
        PuertaEmbarque puerta8 = new PuertaEmbarque("A3", 200);
        PuertaEmbarque puerta9 = new PuertaEmbarque("B7", 200);
        System.out.println("Son iguales: " + puerta8.equals(puerta9));

        System.out.println("\n--- PRUEBA 10: Detectar conflicto de horario entre vuelos ---");
        PuertaEmbarque puerta10 = new PuertaEmbarque("E1", 200);
        puerta10.asignarVuelo(vuelo1);
        puerta10.liberarPuerta();
        puerta10.asignarVuelo(vuelo2);
        System.out.println("Hay conflicto de horario: " + puerta10.hayConflicto());

        System.out.println("\n--- PRUEBA 11: Agregar puertas al gestor ---");
        GestorPuertas gestorPuertas = new GestorPuertas();
        gestorPuertas.agregarPuerta(new PuertaEmbarque("A1", 100));
        gestorPuertas.agregarPuerta(new PuertaEmbarque("A2", 150));
        gestorPuertas.agregarPuerta(new PuertaEmbarque("A3", 200));
        gestorPuertas.listarPuertas();

        System.out.println("\n--- PRUEBA 12: Agregar una puerta duplicada al gestor ---");
        gestorPuertas.agregarPuerta(new PuertaEmbarque("A1", 100));

        System.out.println("\n--- PRUEBA 13: Asignar un vuelo a una puerta disponible en el gestor ---");
        gestorPuertas.asignarPuerta(vuelo4);

        System.out.println("\n--- PRUEBA 14: Asignar vuelo cuando no hay puertas disponibles ---");
        GestorPuertas gestorLleno = new GestorPuertas();
        PuertaEmbarque puertaOcupada = new PuertaEmbarque("Z1", 100);
        puertaOcupada.asignarVuelo(vuelo1);
        gestorLleno.agregarPuerta(puertaOcupada);
        gestorLleno.asignarPuerta(vuelo3);

        System.out.println("\n--- PRUEBA 15: Verificar conflictos en el gestor ---");
        GestorPuertas gestorConflicto = new GestorPuertas();
        PuertaEmbarque puertaConflicto1 = new PuertaEmbarque("G1", 200);
        PuertaEmbarque puertaConflicto2 = new PuertaEmbarque("G2", 150);
        VueloNacional vMismaHora1 = new VueloNacional("AV111", "Bogota", "Medellin", "10:00", "Avianca");
        VueloNacional vMismaHora2 = new VueloNacional("AV222", "Cali", "Cartagena", "10:00", "Latam");
        puertaConflicto1.asignarVuelo(vMismaHora1);
        puertaConflicto2.asignarVuelo(vMismaHora2);
        gestorConflicto.agregarPuerta(puertaConflicto1);
        gestorConflicto.agregarPuerta(puertaConflicto2);
        gestorConflicto.verificarConflictos();





    }



}
