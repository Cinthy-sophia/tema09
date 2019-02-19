package com.cinthyasophia.tema09.Ejercicio11;

import com.cinthyasophia.tema09.Util.Lib;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejercicio11 {
    private boolean isNumber;
    private Lib lib = new Lib();
    private Scanner lector;
    private Alumno[] alumnos;
    private Grupo[] grupos;
    private String[] nombres = {"Juan", "Isabel", "Pablo", "Sergio", "Rubén", "Alicia", "Ana", "María", "José", "Fernando", "Germán"};
    private String[] apellidos = {"Fernández", "Gutiérrez", "Ramírez", "Torregrosa", "Signes", "García", "Gallego", "Alonso", "Tormos"};

    public Ejercicio11(int maxAlumnos, int nGrupos) {
        lector = new Scanner(System.in);
        int opcion;
        alumnos = new Alumno[maxAlumnos];
        grupos = new Grupo[nGrupos];
        generarDatosAleatorios(8);
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevoAlumno();
                    break;
                case 2:
                    bajaAlumno();
                    break;
                case 3:
                    consultas();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);
    }

    private void nuevoAlumno() {
        boolean validado = false;
        int nia;
        String nombre;
        String apellidos;
        String fechaNacimientoString;
        GregorianCalendar fechaNacimiento = null;
        Grupo grupo = null;
        long telefono;

        System.out.println("*** NUEVO ALUMNO ***" );
        do {
            System.out.print("Nia: ");
            nia = Integer.parseInt(lector.nextLine());
            validado = nia < 1999999 && nia > 0;
            if(!validado) {
                System.out.println("Nia debe estar comprendido en el rango [0-1999999]");
                lib.pausa();
            }
            /** Comprobamos que dicho NIA no esté duplicado **/
            if(buscarAlumnoPorNia(nia) >= 0) {
                validado = false;
                System.out.println("El nia introducido ya corresponde a un alumno.");
                System.out.println("Introduzca otro por favor");
                lib.pausa();
            }
        } while (!validado);

        do {
            System.out.print("Nombre: ");
            nombre = lector.nextLine();
            validado = nombre.length() > 2;
            if(!validado) {
                System.out.println("Nombre debe tener almenos 2 caracteres");
                lib.pausa();
            }
        } while (!validado);

        do {
            System.out.print("Apellidos: ");
            apellidos = lector.nextLine();
            validado = apellidos.length() > 2;
            if(!validado) {
                System.out.println("Apellidos debe tener almenos 2 caracteres");
                lib.pausa();
            }
        } while (!validado);

        do {
            System.out.print("Fecha nacimiento (dd-mm-yyyy): ");
            fechaNacimientoString = lector.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = sdf.parse(fechaNacimientoString);
                fechaNacimiento = new GregorianCalendar();
                fechaNacimiento.setTime(date);
                validado = true;
            } catch (ParseException pe) {
                validado = false;
                System.out.println("El formato de la fecha de nacimiento no es válido. Recuerde (dd-mm-yyyy).");
                lib.pausa();
            }
        } while (!validado);

        do {
            int i;
            System.out.println("Grupos disponibles");
            for(i = 0; i < grupos.length; i++) {
                System.out.println("Código: " + grupos[i].getCodigo() + ", nombre: " + grupos[i].getNombre());
            }
            System.out.print("Código del grupo: ");
            int codigo = Integer.parseInt(lector.nextLine());
            validado = false;
            i = 0;
            /** Buscamos que el código que ha introducido el usuario corresponde a un grupo válido **/
            /** En caso afirmativo lo asignamos **/
            while(i < grupos.length && !validado) {
                if(grupos[i].getCodigo() == codigo) {
                    grupo = grupos[i];
                    validado = true;
                } else {
                    i++;
                }
            }
        } while (!validado);

        do {
            System.out.print("Teléfono: ");
            telefono = Long.parseLong(lector.nextLine());
            /** Para facilitar la introducción de datos permitimos poner números pequeños como teléfono **/
            validado = telefono > 0 && telefono < 999999999;
        } while (!validado);

        /** Buscamos la primera posición libre para insertar el alumno **/
        int i = 0;
        boolean encontrado = false;
        while(i < alumnos.length && !encontrado) {
            if(alumnos[i] == null) {
                encontrado = true;
            } else {
                i++;
            }
        }
        /** Si lo hemos encontrado lo insertamos en la posición i **/
        if(encontrado){
            alumnos[i] = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);
            System.out.println("Alumno guardado correctamente");
        } else {
            System.out.println("Imposible añadir el alumno.");
            System.out.println("El array de alumnos está lleno");
        }
        lib.pausa();
    }

    private void bajaAlumno() {
        int nia;
        int pos;
        System.out.println("*** BAJA ALUMNO ***" );
        System.out.print("Nia: ");
        nia = Integer.parseInt(lector.nextLine());
        pos = buscarAlumnoPorNia(nia);
        if(pos >= 0) {
            alumnos[pos] = null;
            System.out.println("Alumno borrado correctamente");
        } else {
            System.out.println("No existe ningún alumno con el nia " + nia);
        }
        lib.pausa();
    }

    private void consultas() {
        int opcion;
        int i;
        do {
            opcion = menuConsultas();
            switch (opcion) {
                case 1:
                    //Por grupo
                    int codigo;
                    Alumno[] alumnosGrupo;
                    System.out.println("Grupos disponibles");
                    for (i = 0; i < grupos.length; i++) {
                        System.out.println("Código: " + grupos[i].getCodigo() + ", nombre: " + grupos[i].getNombre());
                    }
                    System.out.print("Código del grupo: ");
                    codigo = Integer.parseInt(lector.nextLine());
                    alumnosGrupo = buscarAlumnoPorGrupo(codigo);
                    if (alumnosGrupo != null) {
                        for (i = 0; i < alumnosGrupo.length; i++) {
                            System.out.println(alumnosGrupo[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado alumnos del grupo con código " + codigo);
                    }
                    lib.pausa();
                    break;
                case 2:
                    //Por edad
                    int edad;
                    Alumno[] alumnosEdad;
                    System.out.print("Edad: ");
                    edad = Integer.parseInt(lector.nextLine());
                    alumnosEdad = buscarAlumnoPorEdad(edad);
                    if (alumnosEdad != null) {
                        for (i = 0; i < alumnosEdad.length; i++) {
                            System.out.println(alumnosEdad[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado alumnos que tengan " + edad + " años");
                    }
                    lib.pausa();
                    break;
                case 3:
                    //Por nia
                    int nia;
                    System.out.print("Nia: ");
                    nia = Integer.parseInt(lector.nextLine());
                    int pos = buscarAlumnoPorNia(nia);
                    if(pos >= 0) {
                        System.out.println(alumnos[pos].toString());
                    } else {
                        System.out.println("No se ha encontrado ningún alumno con el nia " + nia);
                    }
                    lib.pausa();
                    break;
                case 4:
                    //Por apellidos
                    String apellidos;
                    Alumno[] alumnosApellidos;
                    System.out.print("Apellidos: ");
                    apellidos = lector.nextLine();
                    alumnosApellidos = buscarAlumnoPorApellidos(apellidos);
                    if (alumnosApellidos != null) {
                        for (i = 0; i < alumnosApellidos.length; i++) {
                            System.out.println(alumnosApellidos[i].toString());
                        }
                    } else {
                        System.out.println("No se han encontrado alumnos que tengan " + apellidos + " como apellidos");
                    }
                    lib.pausa();
                    break;
                case 5:
                    boolean fin = false;
                    i = 0;
                    //Mostrar todos los alumnos
                    while(i < alumnos.length && !fin) {
                        if(alumnos[i] != null) {
                            System.out.println(alumnos[i].toString());
                        } else {
                            fin = true;
                        }
                        i++;
                    }
                    lib.pausa();
                    break;
            }
        } while (opcion != 0);

    }

    private void generarDatosAleatorios(int nAlumnos) {
        generarGruposAleatorios();
        generarAlumnosAleatorios(nAlumnos);
    }

    private void generarGruposAleatorios() {
        for(int i = 0; i < grupos.length; i++) {
            grupos[i] = new Grupo(i, "GRUPO " + i);
        }
    }

    private void generarAlumnosAleatorios(int nAlumnos) {
        for(int i = 0; i < nAlumnos; i++) {
            alumnos[i] = alumnoAleatorio();
        }
    }
    private Alumno alumnoAleatorio() {
        int nia = lib.aleatorio(1000000, 1099999);
        String nombre = nombres[lib.aleatorio(0, nombres.length-1)];
        String apellido1 = apellidos[lib.aleatorio(0, apellidos.length-1)];
        String apellido2 = apellidos[lib.aleatorio(0, apellidos.length-1)];
        GregorianCalendar fechaNacimiento = new GregorianCalendar(lib.aleatorio(1985, 2005), lib.aleatorio(0, 11), lib.aleatorio(1,28));
        Grupo grupo = grupos[lib.aleatorio(0, grupos.length-1)];
        int telefono = lib.aleatorio(965700000, 965799999);
        return new Alumno(nia, nombre, apellido1 + " " + apellido2, fechaNacimiento, grupo, telefono);
    }

    private int menuPrincipal() {
        int opcion = -1;
        do {
            isNumber=true;
            System.out.println("*********************");
            System.out.println("** GESTIÓN ALUMNOS **");
            System.out.println("*********************");
            System.out.println("1. Nuevo alumno...");
            System.out.println("2. Baja de alumno...");
            System.out.println("3. Consultas...");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.print("Elija una opción: ");

            try{
                opcion = Integer.parseInt(lector.nextLine());
            }catch(NumberFormatException nfe){
                isNumber=false;

            }finally {

                if(opcion < 0 || opcion > 3) {
                    System.out.println("Elija una opción del menú [0-3]");
                    lib.pausa();
                }
            }

        } while (opcion < 0 || opcion > 3|| !isNumber);
        return opcion;
    }

    private int menuConsultas() {
        int opcion = -1;
        do {
            isNumber=true;
            System.out.println("***************");
            System.out.println("** CONSULTAS **");
            System.out.println("****************");
            System.out.println("1. Por grupo...");
            System.out.println("2. Por edad...");
            System.out.println("3. Por nia...");
            System.out.println("4. Por apellidos...");
            //Aunque no lo pide el ejercicio, añadimos la opción de mostrar todos para facilitar las pruebas
            System.out.println("5. Mostrar todos...");
            System.out.println("----------------");
            System.out.println("0. Volver al menú principal\n");
            System.out.print("Elija una opción: ");
            try{
                opcion = Integer.parseInt(lector.nextLine());
            }catch(NumberFormatException nfe){
                isNumber=false;

            }finally {

                if(opcion < 0 || opcion > 3) {
                    System.out.println("Elija una opción del menú [0-5]");
                    lib.pausa();
                }
            }

        } while (opcion < 0 || opcion > 5 || !isNumber);
        return opcion;
    }

    /**
     * Busca alumnos por Grupo
     * @param codigoGrupo
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorGrupo(int codigoGrupo) {
        Alumno[] alumnosGrupo = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        int i = 0;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                    nAlumnos++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(nAlumnos > 0) {
            i = 0;
            alumnosGrupo = new Alumno[nAlumnos];
            int cont = 0;
            fin = false;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            while(i < alumnos.length && !fin) {
                if(alumnos[i]!= null) {
                    if (alumnos[i].getGrupo().getCodigo() == codigoGrupo) {
                        alumnosGrupo[cont] = alumnos[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return alumnosGrupo;
    }

    /**
     * Busca alumnos por Edad
     * @param edad
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorEdad(int edad) {
        Alumno[] alumnosEdad = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        int i = 0;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getEdad() == edad) {
                    nAlumnos++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(nAlumnos > 0) {
            i = 0;
            fin = false;
            alumnosEdad = new Alumno[nAlumnos];
            int cont = 0;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            while(i < alumnos.length && !fin) {
                if(alumnos[i]!= null) {
                    if (alumnos[i].getEdad() == edad) {
                        alumnosEdad[cont] = alumnos[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return alumnosEdad;
    }

    /**
     * Busca un alumno por Nia
     * @param nia
     * @return Si lo encuentra devuelve la posición del array donde está el alumno,
     * en caso contrario devuelve -1
     */
    private int buscarAlumnoPorNia(int nia) {
        int i = 0;
        boolean fin = false;
        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getNia() == nia) {
                    return i;
                }
                i++;
            } else {
                fin = true;
            }
        }
        return -1;
    }

    /**
     * Busca alumnos por Apellidos
     * @param apellidos
     * @return Un array con los alumnos que ha encontrado, null si no ha encontrado
     */
    private Alumno[] buscarAlumnoPorApellidos(String apellidos) {
        Alumno[] alumnosApellidos = null;
        /** Lo ideal sería hacerlo con ArrayLists pero aún no los hemos visto */
        /** Calculamos primero cuantos alumnos hay que coincidan con el criterio de búsqueda **/
        int nAlumnos = 0;
        int i = 0;
        boolean fin = false;
        //Convertimos a minúsculas
        apellidos = apellidos.toLowerCase();

        while(i < alumnos.length && !fin) {
            if(alumnos[i]!= null) {
                if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                    nAlumnos++;
                }
                i++;
            } else {
                fin = true;
            }
        }
        if(nAlumnos > 0) {
            alumnosApellidos = new Alumno[nAlumnos];
            i = 0;
            int cont = 0;
            fin = false;
            /** Una vez sabemos el número de alumnos los asignamos al vector **/
            while(i < alumnos.length && !fin) {
                if(alumnos[i]!= null) {
                    if (alumnos[i].getApellidos().toLowerCase().contains(apellidos)) {
                        alumnosApellidos[cont] = alumnos[i];
                        cont++;
                    }
                    i++;
                } else {
                    fin = true;
                }
            }
        }
        return alumnosApellidos;
    }
}


