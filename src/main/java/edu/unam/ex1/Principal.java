package edu.unam.ex1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		List<Object> lista = new ArrayList<Object>();
        lista.add(new Book("titulo1", "pedro"));
        process(lista);

	}

	public static void process(List<Object> lista) {

		try {
			for (Object o : lista) {
				Field[] campos = o.getClass().getDeclaredFields();

				for (Field campo : campos) {

					Printable imprimir = campo.getAnnotation(Printable.class);
					System.out.println(imprimir);
					if (imprimir != null) {
						if (imprimir.upperCase()) {
							System.out.println(campo.get(o).toString().toUpperCase());
						} else {
							System.out.println(campo.get(o).toString());

						}
					}
				}
			}
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
