package TPAGENDA;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    
    //Metodos
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public static LocalDate dateInput(String userInput) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(userInput, dateFormat);
    
        return date ;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int opcionesMenu = 0, opcionesSeleccion = 0;
        String nombre,descripcion,horaRecordatorio,horaInicioEvento,horaFinEvento,lugarDelEvento;
        LocalDate fecha;
        ArrayList<Evento> events = new ArrayList<Evento>();
        ArrayList<Tarea> tasks = new ArrayList<Tarea>();
        ArrayList<Recordatorio> reminders = new ArrayList<Recordatorio>();
        
        do {
            clearScreen();
            try {
                System.out.println("Presione 1 para cargar una nueva Tarea-Evento-Recordatorio a tu agenda \n");
                System.out.println("Presione 2 para buscar una Tarea-Evento-Recordatorio de tu agenda y modificarla \n");
                System.out.println("Presione 3 para eliminar una Tarea-Evento-Recordatorio de tu agenda \n");
                System.out.println("Presione 0 para salir del programa \n");
                opcionesMenu = input.nextInt();
                input.nextLine();
                
            } catch (Exception e) {
                System.out.println("Ingreso un valor no valido\n");
            }            

            switch(opcionesMenu){
                case 1://Asignar Tarea Evento Recordatorio
                    
                    clearScreen();                
                    try {
                        System.out.println("[1]Tarea \n[2]Evento\n[3]Recordatorio\n");
                        opcionesSeleccion = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }                    

                    switch(opcionesSeleccion){
                        case 1:
                            clearScreen();
                            System.out.print("ingrese el nombre de la tarea \n");
                            nombre= input.nextLine();
                            
                            System.out.print("ingrese el fecha de la tarea \n");
                            descripcion= input.nextLine();
                            
                            System.out.print("ingrese el descripcion de la tarea \n"); 
                            fecha= dateInput(input.nextLine());

                            Tarea tarea = new Tarea(nombre,descripcion,fecha);
                            
                            tarea.setCheck(false);
                            tasks.add(tarea);
                            break;
                        case 2:
                            clearScreen();
                            
                            System.out.print("ingrese el nombre de la Evento \n");
                            nombre= input.nextLine();
                            
                            System.out.print("ingrese el fecha de la Evento \n");
                            descripcion= input.nextLine();
                            
                            System.out.print("ingrese el descripcion de la Evento \n"); 
                            fecha= dateInput(input.nextLine());

                            Evento evento = new Evento(nombre,descripcion,fecha);
                            
                            System.out.print("ingrese el lugar del Evento \n");
                            lugarDelEvento= input.nextLine();
                            
                            System.out.print("ingrese el horario de inicio del Evento \n");
                            horaInicioEvento= input.nextLine();
                            
                            System.out.print("ingrese el horario de finalizacion del Evento \n");
                            horaFinEvento= input.nextLine();


                            evento.setLugarDelEvento(lugarDelEvento);
                            evento.setHoraInicio(horaInicioEvento);
                            evento.setHoraFin(horaFinEvento);
                            
                            events.add(evento);
                            break;
                        
                        case 3:
                            
                            System.out.print("ingrese el nombre del Recordatorio \n");
                            nombre= input.nextLine();
                            
                            System.out.print("ingrese el fecha del Recordatorio  \n");
                            descripcion= input.nextLine();
                            
                            System.out.print("ingrese el descripcion del Recordatorio \n"); 
                            fecha= dateInput(input.nextLine());
                            
                            Recordatorio recordatorio = new Recordatorio(nombre,descripcion,fecha);
                            
                            System.out.print("ingrese el horario de la Recordatorio \n");
                            horaRecordatorio= input.nextLine();
                            
                            recordatorio.setHoraRecordatorio();
                            
                            reminders.add(recordatorio);

                            break;
                        default:
                            clearScreen();
                            System.out.println("\n Ingrese una opcion valida ");
                        break;
                    }
                    break;
                
                case 2://buscar y modificar
                    clearScreen();               
                    try {
                        System.out.println("[1]Tarea \n[2]Evento\n[3]Recordatorio\n");
                        opcionesSeleccion = input.nextInt();
                        input.nextLine();
                        
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }
                    
                    System.out.print("ingrese el nombre\n");
                    nombre= input.nextLine();
                    
                    System.out.print("ingrese la fecha\n");
                    descripcion= input.nextLine();
                    
                    System.out.print("ingrese la descripcion\n"); 
                    fecha= dateInput(input.nextLine());
                    
                    switch(opcionesSeleccion){
                        
                        case 1:
                            for (Tarea tarea : tasks) {
                                if (tarea.nombre==nombre && tarea.fecha==fecha && tarea.descripcion==descripcion){
                                    Boolean check = false;
                                    String respuesta;
                                    System.out.print("Realizo la tarea? [1 SI] [0 No]\n");
                                    respuesta=input.nextLine();
                                    
                                    if (respuesta=="1"){
                                        check = true;
                                    }else{
                                        check = false;
                                    }
                                    

                                    tarea.setDescripcion(descripcion);
                                    tarea.setFecha(fecha);
                                    tarea.setNombre(nombre);
                                    tarea.setCheck(check);
                                }
                            }

                            break;
                        case 2:
                            for (Evento evento : events) {
                                if (evento.nombre==nombre && evento.fecha==fecha && evento.descripcion==descripcion){
                                    
                                    System.out.print("ingrese el lugar del Evento \n");
                                    lugarDelEvento= input.nextLine();
                                    
                                    System.out.print("ingrese el horario de inicio del Evento \n");
                                    horaInicioEvento= input.nextLine();
                                    
                                    System.out.print("ingrese el horario de finalizacion del Evento \n");
                                    horaFinEvento= input.nextLine();

                                    evento.setDescripcion(descripcion);
                                    evento.setFecha(fecha);
                                    evento.setNombre(nombre);
                                    evento.setHoraInicio(horaInicioEvento);
                                    evento.setHoraFin(horaFinEvento);
                                    evento.setLugarDelEvento(lugarDelEvento);
                                }
                                    
                            }
                            
                            break;
                        case 3:
                            for (Recordatorio recordatorio : reminders) {
                                if (recordatorio.nombre==nombre && recordatorio.fecha==fecha && recordatorio.descripcion==descripcion){
                                    
                                    System.out.print("ingrese el horario del Recordatorio \n");
                                    horaRecordatorio= input.nextLine();
                                    
                                    recordatorio.setDescripcion(descripcion);
                                    recordatorio.setFecha(fecha);
                                    recordatorio.setNombre(nombre);
                                    recordatorio.setHoraRecordatorio(horaRecordatorio);
                                }
                            }
                            break;
                        default:
                            clearScreen();
                            System.out.println("\n Ingrese una opcion valida ");
                            break;
                    }
                    break;
                
                case 3://eliminar
                    clearScreen();                
                    try {
                        System.out.println("[1]Tarea \n[2]Evento\n[3]Recordatorio\n");
                        opcionesSeleccion = input.nextInt();
                        input.nextLine();
                        
                    } catch (Exception e) {
                        System.out.println("Ingreso un valor no valido\n");
                    }
                    

                    System.out.print("ingrese el nombre\n");
                    nombre= input.nextLine();
                    
                    System.out.print("ingrese la fecha\n");
                    descripcion= input.nextLine();
                    
                    System.out.print("ingrese la descripcion\n"); 
                    fecha= dateInput(input.nextLine());

                    switch(opcionesSeleccion){
                        case 1:
                            for(Tarea tarea:tasks){
                                if(tarea.descripcion == descripcion && tarea.nombre == nombre && tarea.fecha == fecha){
                                    tasks.remove(tarea);
                                }
                            }
                            break;
                        case 2:
                            for(Evento evento : events){
                                if(evento.descripcion == descripcion && evento.nombre == nombre && evento.fecha == fecha){
                                    events.remove(evento);
                                }
                            }

                            break;
                        case 3:
                            for(Recordatorio recordatorio : reminders){
                                if(recordatorio.nombre==nombre && recordatorio.descripcion==descripcion && recordatorio.fecha==fecha){
                                    reminders.remove(recordatorio);
                                }
                            }
                            break;
                        default:
                            clearScreen();
                            System.out.println("\n Ingrese una opcion valida ");
                            break;
                    }
                    break;

                case 0:
                    clearScreen();
                    System.out.println(" El programa a finalizado correctamente ");
                    break;
                
                default:
                    clearScreen();
                    System.out.println(" \n Ingrese una opcion valida ");
                    break;

            }

        }while(opcionesMenu!=0);

        input.close();
    }

}
