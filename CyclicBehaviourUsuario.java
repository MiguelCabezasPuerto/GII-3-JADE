package corteIngles;
import java.util.InputMismatchException;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class CyclicBehaviourUsuario extends CyclicBehaviour {
	static int i = 0;
	Reserva r;
	int checkDestinoAlojamiento,checkDestinoOcio,checkMesIdaAlojamiento,checkMesVueltaAlojamiento;
	int ckeckMesIdaOcio,checkFechaIdaAlojamiento,checkFechaIdaOcio,checkFechaVueltaAlojamiento;
	int checkHotel,checkActividad,checkCiudad;
	
	
	
	
	public CyclicBehaviourUsuario(Agent agent) {
		super(agent);
	}

	@Override
	public void action() {
		
		checkDestinoAlojamiento=checkDestinoOcio=checkMesIdaAlojamiento=checkMesVueltaAlojamiento=0;
		ckeckMesIdaOcio=checkFechaIdaAlojamiento=checkFechaIdaOcio=checkFechaVueltaAlojamiento=0;
		checkHotel=checkActividad=checkCiudad=0;
		
		
		Scanner sc = new Scanner(System.in);
		int mesA, mesO, ida, vuelta, fecha, mesV;
		
		/*
		if(i > 0) {
			ACLMessage msgu = this.myAgent.blockingReceive();
		}else {
			i++;
		}
		*/
		//Pregunta 1
			System.out.println("¿Desea hacer un viaje? S|N : ");
			String respuesta = sc.nextLine();
			if(respuesta.equalsIgnoreCase("S")) {
				
				
				System.out.println("Introduzca el destino:");
				String destino = sc.nextLine();
				
				
				
					
				do {
					try {
				System.out.println("Introduzca el mes de ida:");
				mesA = sc.nextInt();
				}catch(InputMismatchException mm) {
					System.err.println("Interferencias disculpe");
					mesA=0;
					sc.nextLine();
				}
				}while(mesA < 1 || mesA > 12);
				
				
				
				
					
				do {
					try {
					System.out.println("Introduzca el mes de vuelta:");
					mesV = sc.nextInt();
				}catch(InputMismatchException mm) {
					System.err.println("Interferencias disculpe");
					mesV=0;
					sc.nextLine();
				}
				}while(mesV < 1 || mesV > 12 || mesV<mesA);
					
					
				
				if(mesA == 2) {
					
						
					do {
						try {
						System.out.println("Introduzca la fecha de ida:");
						ida = sc.nextInt();
					}catch(InputMismatchException mm) {
						System.err.println("Interferencias disculpe");
						ida=0;
						sc.nextLine();
					}
					}while(ida < 1 || ida > 26);
					
						
					
					
				}else if(mesA == 11 || mesA == 4 || mesA == 6 || mesA == 9) {
					
						
					do {
						try {
						System.out.println("Introduzca la fecha de ida:");
						ida = sc.nextInt();
					}catch(InputMismatchException mm) {
						System.err.println("Interferencias disculpe");
						ida=0;
						sc.nextLine();
					}
					}while(ida < 1 || ida > 28);
					
						
					
				}else {
					
						
					do {
						try {
						System.out.println("Introduzca la fecha de ida:");
						ida = sc.nextInt();
					}catch(InputMismatchException mm) {
						System.err.println("Interferencias disculpe");
						ida=0;
						sc.nextLine();
					}
					}while(ida < 1 || ida > 29);
					
						
					
				}
				
				if(mesA == mesV) {
					if(mesV == 2) {
						
							
						do {
							try {
							System.out.println("Introduzca la fecha de vuelta:");
							vuelta = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							vuelta=32;
							sc.nextLine();
						}
						}while(vuelta > 28 || vuelta < ida);
						
							
						
					}else if(mesA == 11 || mesA == 4 || mesA == 6 || mesA == 9) {
						
							
						do {
							try {
							System.out.println("Introduzca la fecha de vuelta:");
							vuelta = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							vuelta=35;
							sc.nextLine();
						}
						}while(vuelta > 30 || vuelta < ida);
						
							
						
					}else {
						
							
						do {
							try {
							System.out.println("Introduzca la fecha de vuelta:");
							vuelta = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							vuelta=35;
							sc.nextLine();
						}
						}while(vuelta > 31 || vuelta < ida);
					
							
						
					}
				}else {
					if(mesV == 2) {
						
							
						do {
							try {
							System.out.println("Introduzca la fecha de vuelta:");
							vuelta = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							vuelta=35;
							sc.nextLine();
						}
						}while(vuelta > 28 || vuelta < 1);
						
							
						
					}else if(mesA == 11 || mesA == 4 || mesA == 6 || mesA == 9) {
						
							
						do {
							try {
							System.out.println("Introduzca la fecha de vuelta:");
							vuelta = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							vuelta=35;
							sc.nextLine();
						}
						}while(vuelta > 30 || vuelta < 1);
						
							
						
					}else {
						
							
						do {
							try {
							System.out.println("Introduzca la fecha de vuelta:");
							vuelta = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							vuelta=35;
							sc.nextLine();
						}
						}while(vuelta > 31 || vuelta < 1);
						
							
						
					}
				}
				
				sc.nextLine();
				System.out.println("Introduzca nombre del hotel:");
				String hotel = sc.nextLine();
				String usuarioSolicitante=this.myAgent.getAID().getLocalName();
				r =  new Reserva(destino, ida, vuelta, "A",usuarioSolicitante,hotel,mesA, mesV); //meter usuario solicitante como atributo de la clase Reservas y en la clase Ocio
				//Mandar mensaje
				Utils.enviarMensaje(this.myAgent, "corteIngles", r, 1,"");
				//Utils.enviarMensajeAUsuario(this.myAgent, "usuario", " ");
			}else if (respuesta.equalsIgnoreCase("N")){
	
		
		//Pregunta 2
		
			System.out.println("¿Desea ver actividades de ocio? S|N \n");
			String respuesta2 = sc.nextLine();
			if(respuesta2.equalsIgnoreCase("S")) {
				System.out.println("Introduzca la ciudad:");
				String ciudad = sc.nextLine();
				do {
					try {
				System.out.println("Introduzca el mes:");
				mesO = sc.nextInt();
					}catch(InputMismatchException mm) {
						System.err.println("Interferencias disculpe");
						mesO=0;
						sc.nextLine();
					}
				}while(mesO < 1 || mesO > 12);
				if(mesO == 2) {
					do {
						try {
						System.out.println("Introduzca la fecha:");
						fecha = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							fecha=0;
							sc.nextLine();
						}
					}while(fecha < 1 || fecha > 28);
				}else if(mesO == 11 || mesO == 4 || mesO == 6 || mesO == 9) {
					do {
						try {
						System.out.println("Introduzca la fecha:");
						fecha = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							fecha=0;
							sc.nextLine();
						}
					}while(fecha < 1 || fecha > 30);
				}else {
					do {
						try {
						System.out.println("Introduzca la fecha:");
						fecha = sc.nextInt();
						}catch(InputMismatchException mm) {
							System.err.println("Interferencias disculpe");
							fecha=0;
							sc.nextLine();
						}
					}while(fecha < 1 || fecha > 31);
				}
				sc.nextLine();
				String usuarioSolicitante=this.myAgent.getAID().getLocalName();
				System.out.println("Introduzca nombre de la actividad:");
				String actividad=sc.nextLine();
				r=new Reserva(ciudad,fecha,-1,"O",usuarioSolicitante,actividad, mesO, 0);
				//Mandar mensaje
				Utils.enviarMensaje(this.myAgent, "corteIngles", r, 1,"");
				//Utils.enviarMensajeAUsuario(this.myAgent, "usuario", " ");
			}else if (respuesta2.equalsIgnoreCase("N")){
				this.myAgent.doDelete();
			}
			}
			
			ACLMessage msg = this.myAgent.blockingReceive();
			//si es el contenido del mensaje null imprimir que no hay sitio, sino imprimir contenido del mensaje
			try {
				
				if(r.getTipo().equalsIgnoreCase("A")) {
					Alojamiento a = (Alojamiento) msg.getContentObject();
					
					if(a.getCiudad().equalsIgnoreCase("")) {
						System.out.println("No disponible en estos momentos");
					}
					else {
						System.out.printf("INFORMACION DE LA RESERVA\n");
						System.out.printf("==========================\n");
						System.out.printf("HOTEL:%s\t\tFECHA IDA:%d/%d\t\tFECHA VUELTA:%d/%d\t\tCIUDAD:%s\n",a.getNombreHotel(),r.getIda(),r.getMes(),r.getVuelta(),r.getMesVuelta(),a.getCiudad());
					}
				}else {
					Ocio o=(Ocio) msg.getContentObject();
					if(o.getCiudad().equalsIgnoreCase("")) {
						System.out.println("No disponible en estos momentos");
					}
					else {
						System.out.printf("INFORMACION DE LA RESERVA\n");
						System.out.printf("==========================\n");
						System.out.printf("ACTIVIDAD:%s\t\tFECHA:%d/%d\t\tCIUDAD:%s\n",o.getNombreActividad(),r.getIda(),r.getMes(),o.getCiudad());
					}
				}
			} catch (UnreadableException e1) {
				e1.printStackTrace();
			}
			}
		//Esperar respuesta e imprimirla

		

}
