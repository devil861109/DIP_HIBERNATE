package edu.unam.agenda;

import edu.unam.agenda.hibernate.HibernateUtil;
import edu.unam.agenda.service.MeansContactsService;
import edu.unam.agenda.service.ContactService;
import edu.unam.agenda.service.PhoneTypeService;
import edu.unam.agenda.service.ContactTypeService;
import edu.unam.agenda.service.impl.MeansContactsServiceImpl;
import edu.unam.agenda.service.impl.ContactServiceImpl;
import edu.unam.agenda.service.impl.PhoneTypeServiceImpl;
import edu.unam.agenda.service.impl.ContactTypeServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaAPP {
	private Scanner sn;
	private final PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
	private final ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
	private final ContactService contactService = ContactServiceImpl.getInstance();
	private final MeansContactsService meansContactsService = MeansContactsServiceImpl.getInstance();

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
                        break;
                    case 2:
                        System.out.println("-- Entrando Contactos --");
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
}
