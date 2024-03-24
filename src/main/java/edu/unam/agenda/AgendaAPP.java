package edu.unam.agenda;

import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.model.*;
import edu.unam.agenda.service.*;
import edu.unam.agenda.service.impl.*;

import java.util.*;

public class AgendaAPP {
    private Scanner sn;
    //private final PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
    //private final ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
    private final ContactService contactService = ContactServiceImpl.getInstance();
    private final MeansContactsService meansContactsService = MeansContactsServiceImpl.getInstance();
    private final CatalogService catalogService = CatalogServiceImpl.getInstance();

    public static void main(String[] args) {
        HibernateUtil.init();
        AgendaAPP catalogosAPP = new AgendaAPP();
        catalogosAPP.cargaMenu();
    }

    public void cargaMenu() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Catalogos");
            System.out.println("2. Contactos");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú catalogos --");
                        cargaMenuCatalogos();
                        break;
                    case 2:
                        System.out.println("-- Entrando Contactos --");
                        cargaMenuContactos();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir) ;
    }

    public void cargaMenuCatalogos() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Medio Contacto");
            System.out.println("2. Tipo Contacto");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Catálogo Medio Contacto --");
                        cargaMenuMedioContacto();
                        break;
                    case 2:
                        System.out.println("-- Entrando Catálogo Tipo Contacto --");
                        cargaMenuTipoContacto();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuMedioContacto() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Medio Contacto por ID");
            System.out.println("2. Ver Medios Contactos");
            System.out.println("3. Insertar Medio Contacto");
            System.out.println("4. Actualizar Medio Contacto");
            System.out.println("5. Eliminar Medio Contacto");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver Medio Contacto por ID --");
                        consultaMedioContactoRegistrosPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos Medios Contactos --");
                        consultaMedioContactoRegistros();
                        break;
                    case 3:
                        System.out.println("-- Entrando Crea Medio Contacto --");
                        insertaMedioContactoRegistros();
                        break;
                    case 4:
                        System.out.println("-- Entrando Actualiza Medio Contacto --");
                        actualizaMedioContactoRegistros();
                        break;
                    case 5:
                        System.out.println("-- Entrando Elimina Medio Contacto --");
                        eliminaMedioContactoRegistros();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuTipoContacto() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Tipo Contacto por ID");
            System.out.println("2. Ver Tipos Contactos");
            System.out.println("3. Insertar Tipo Contacto");
            System.out.println("4. Actualizar Tipo Contacto");
            System.out.println("5. Eliminar Tipo Contacto");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver Medio Contacto por ID --");
                        consultaTipoContactoRegistrosPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos Medios Contactos --");
                        consultaTipoContactoRegistros();
                        break;
                    case 3:
                        System.out.println("-- Entrando Crea Medio Contacto --");
                        insertaTipoContactoRegistros();
                        break;
                    case 4:
                        System.out.println("-- Entrando Actualiza Medio Contacto --");
                        actualizaTipoContactoRegistros();
                        break;
                    case 5:
                        System.out.println("-- Entrando Elimina Medio Contacto --");
                        eliminaTipoContactoRegistros();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuContactos() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver Contacto por ID");
            System.out.println("2. Ver Contactos");
            System.out.println("3. Insertar Contacto");
            System.out.println("4. Actualizar Contacto");
            System.out.println("5. Eliminar Contacto");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver Contacto por ID --");
                        consultaContactoRegistrosPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos Contactos --");
                        consultaContactoRegistros();
                        break;
                    case 3:
                        System.out.println("-- Entrando Crea Contacto --");
                        insertaContactoRegistros();
                        break;
                    case 4:
                        System.out.println("-- Entrando Actualiza Contacto --");
                        actualizaContactoRegistros();
                        break;
                    case 5:
                        System.out.println("-- Entrando Elimina Contacto --");
                        eliminaContactoRegistros();
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void consultaMedioContactoRegistros() {
        for (PhoneType medioContacto : catalogService.getAllPhoneType()) {
            System.out.println("Medio Contacto:" + medioContacto.toString());
        }
    }

    public void consultaMedioContactoRegistrosPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        PhoneType medioContacto = catalogService.getPhoneTypeById(busca);
        if (medioContacto != null)
            System.out.println("Medio Contacto:" + medioContacto.toString());
        else
            System.out.println("Medio Contacto no encontrado");
    }

    public void insertaMedioContactoRegistros() {
		/*Scanner scanner = new Scanner(System.in);
        PhoneType nuevo = new PhoneType();
        System.out.println("Dame nombre: ");
        nuevo.setName(scanner.nextLine());
        nuevo.setStatus("ACTIVO");
        if (phoneTypeService.insertPhoneType(nuevo))
            System.out.println("Insertado correctamente");
        else
            System.out.println("Error al insertar registro");*/
        System.out.println("TODO");
    }

    public void actualizaMedioContactoRegistros() {
		/*Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a actualizar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        PhoneType medioContacto = phoneTypeService.getPhoneTypeById(busca);
        if (medioContacto != null) {
            System.out.println("Medio Contacto:" + medioContacto.toString());
            System.out.println("Dame nombre: ");
            medioContacto.setName(scanner.nextLine());
            if (phoneTypeService.updatePhoneType(medioContacto))
                System.out.println("Actualizado correctamente");
            else
                System.out.println("Error al actualizar registro");
        } else
            System.out.println("Medio Contacto no encontrado");*/
        System.out.println("TODO");
    }

    public void eliminaMedioContactoRegistros() {
		/*Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a eliminar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        PhoneType medioContacto = phoneTypeService.getPhoneTypeById(busca);
        if (medioContacto != null) {
            System.out.println("Medio Contacto:" + medioContacto.toString());
            if (phoneTypeService.deletePhoneType(medioContacto))
                System.out.println("Eliminado correctamente");
            else
                System.out.println("Error al eliminar registro");
        } else
            System.out.println("Medio Contacto no encontrado");*/
        System.out.println("TODO");
    }


    public void consultaTipoContactoRegistros() {
        for (Catalog tipoContacto : catalogService.getAllContactType()) {
            System.out.println("Medio Contacto:" + tipoContacto.toString());
        }
		/*for (ContactType tipoContacto : contactTypeService.getAllContactType()) {
            System.out.println("Tipo Contacto:" + tipoContacto.toString());
        }*/
    }

    public void consultaTipoContactoRegistrosPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        //ContactType tipoContacto = contactTypeService.getContactTypeById(busca);
        Catalog tipoContacto = catalogService.getContactTypeById(busca);
        if (tipoContacto != null)
            System.out.println("Tipo Contacto:" + tipoContacto.toString());
        else
            System.out.println("Tipo Contacto no encontrado");
    }

    public void insertaTipoContactoRegistros() {
		/*Scanner scanner = new Scanner(System.in);
        ContactType nuevo = new ContactType();
        System.out.println("Dame nombre: ");
        nuevo.setName(scanner.nextLine());
        nuevo.setStatus("ACTIVO");
        if (contactTypeService.insertContactType(nuevo))
            System.out.println("Insertado correctamente");
        else
            System.out.println("Error al insertar registro");*/
        System.out.println("TODO");
    }

    public void actualizaTipoContactoRegistros() {
		/*Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a actualizar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        ContactType tipoContacto = contactTypeService.getContactTypeById(busca);
        if (tipoContacto != null) {
            System.out.println("Medio Contacto:" + tipoContacto.toString());
            System.out.println("Dame nombre: ");
            tipoContacto.setName(scanner.nextLine());
            if (contactTypeService.updateContactType(tipoContacto))
                System.out.println("Actualizado correctamente");
            else
                System.out.println("Error al actualizar registro");
        } else
            System.out.println("Medio Contacto no encontrado");*/
        System.out.println("TODO");
    }

    public void eliminaTipoContactoRegistros() {
		/*Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a eliminar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        ContactType tipoContacto = contactTypeService.getContactTypeById(busca);
        if (tipoContacto != null) {
            System.out.println("Medio Contacto:" + tipoContacto.toString());
            if (contactTypeService.deleteContactType(tipoContacto))
                System.out.println("Eliminado correctamente");
            else
                System.out.println("Error al eliminar registro");
        } else
            System.out.println("Medio Contacto no encontrado");*/
        System.out.println("TODO");
    }

    public void consultaContactoRegistros() {
        for (Contact contacto : contactService.getAllContacts()) {
            System.out.println("Contacto:" + contacto.toString());
        }
    }

    public void consultaContactoRegistrosPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        Contact contacto = contactService.getContactById(busca);
        if (contacto != null)
            System.out.println("Contacto:" + contacto.toString());
        else
            System.out.println("Contacto no encontrado");
    }

    public void insertaContactoRegistros() {
        Scanner scanner = new Scanner(System.in);
        Contact nuevo = new Contact();
        System.out.println("Dame nombre: ");
        nuevo.setName(scanner.nextLine());
        System.out.println("Dame apellidos: ");
        nuevo.setLastName(scanner.nextLine());
        System.out.println("Dame edad: ");
        nuevo.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Dame dirección: ");
        nuevo.setAddress(scanner.nextLine());
        System.out.println("Tipos de Contactos a elegir: ");
        consultaTipoContactoRegistros();
        System.out.println("Dame ID Tipo Contacto: ");
        int busca = scanner.nextInt();
        scanner.nextLine();
        //ContactType tipoContacto = contactTypeService.getContactTypeById(busca);
        ContactType tipoContacto = catalogService.getContactTypeById(busca);
        if (tipoContacto != null)
            nuevo.setContactType(tipoContacto);
        else
            nuevo.setContactType(null);
        System.out.println("Medios de Contactos a elegir: ");
        consultaMedioContactoRegistros();
        System.out.println("Dame ID Medio Contacto: ");
        busca = scanner.nextInt();
        scanner.nextLine();
        //PhoneType medio = phoneTypeService.getPhoneTypeById(busca); //obtencion de catalogo de medio contacto
        PhoneType medio = catalogService.getPhoneTypeById(busca); //obtencion de catalogo de medio contacto
        MeansContacts contactoMedio = new MeansContacts(); //creacion de contacto medio
        System.out.println("Dame numero de telefono: ");
        contactoMedio.setValue(scanner.nextLine()); //llenado de datos de contacto medio
        contactoMedio.setPhoneType(medio); //relacionamos contacto medio con catalogo medio contacto
        contactoMedio.setContact(nuevo); // relacionamos con contacto
        Set<MeansContacts> contactosMedios = new HashSet<>(); //generamos la coleccion
        contactosMedios.add(contactoMedio); //llenamos la coleccion
        nuevo.setMeansContacts(contactosMedios);
        if (contactService.insertContact(nuevo))
            System.out.println("Insertado correctamente");
        else
            System.out.println("Error al insertar registro");
    }

    public void actualizaContactoRegistros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a actualizar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        Contact nuevo = contactService.getContactById(busca);
        if (nuevo != null) {
            System.out.println("Dame nombre: ");
            nuevo.setName(scanner.nextLine());
            System.out.println("Dame apellidos: ");
            nuevo.setLastName(scanner.nextLine());
            System.out.println("Dame edad: ");
            nuevo.setAge(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Dame dirección: ");
            nuevo.setAddress(scanner.nextLine());
            System.out.println("Tipos de Contactos a elegir: ");
            consultaTipoContactoRegistros();
            System.out.println("Dame ID Tipo Contacto: ");
            busca = scanner.nextInt();
            scanner.nextLine();
            //ContactType tipoContacto = contactTypeService.getContactTypeById(busca);
            ContactType tipoContacto = catalogService.getContactTypeById(busca);
            nuevo.setContactType(tipoContacto);

            //se eliminan los anteriores para evitar conflictos
            List<MeansContacts> medios = meansContactsService.getMeansContactsByContact(nuevo.getId());
            for (MeansContacts medio : medios) {
                meansContactsService.deleteMeansContacts(medio);
            }
            //se procede a adjuntar uno nuevo
            System.out.println("Medios de Contactos a elegir: ");
            consultaMedioContactoRegistros();
            System.out.println("Dame ID Medio Contacto: ");
            busca = scanner.nextInt();
            scanner.nextLine();
            //PhoneType medio = phoneTypeService.getPhoneTypeById(busca); //obtencion de catalogo de medio contacto
            PhoneType medio = catalogService.getPhoneTypeById(busca); //obtencion de catalogo de medio contacto
            MeansContacts contactoMedio = new MeansContacts(); //creacion de contacto medio
            System.out.println("Dame numero de telefono: ");
            contactoMedio.setValue(scanner.nextLine()); //llenado de datos de contacto medio
            contactoMedio.setPhoneType(medio); //relacionamos contacto medio con catalogo medio contacto
            contactoMedio.setContact(nuevo); // relacionamos con contacto
            Set<MeansContacts> contactosMedios = new HashSet<>(); //generamos la coleccion
            contactosMedios.add(contactoMedio); //llenamos la coleccion
            nuevo.setMeansContacts(contactosMedios);
            if (contactService.updateContact(nuevo))
                System.out.println("Insertado correctamente");
            else
                System.out.println("Error al insertar registro");
        } else
            System.out.println("Medio Contacto no encontrado");
    }

    public void eliminaContactoRegistros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a eliminar:");
        int busca = scanner.nextInt();
        scanner.nextLine();//limpieza
        Contact contacto = contactService.getContactById(busca);
        if (contacto != null) {
            System.out.println("Contacto:" + contacto.toString());
            //se hace forzado, puesto que cascade no funciona
            List<MeansContacts> medios = meansContactsService.getMeansContactsByContact(contacto.getId());
            for (MeansContacts medio : medios) {
                meansContactsService.deleteMeansContacts(medio);
            }
            contacto.setMeansContacts(null);// se elimina, sino, falla
            if (contactService.deleteContact(contacto))
                System.out.println("Eliminado correctamente");
            else
                System.out.println("Error al eliminar registro");
        } else
            System.out.println("Contacto no encontrado");
    }
}
