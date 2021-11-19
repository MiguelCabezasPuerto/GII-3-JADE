package corteIngles;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;


public class CyclicBehaviourAlojamiento extends CyclicBehaviour {
	Reserva r;
	Alojamiento a,b;
	static int p=0;
	ArrayList<Alojamiento> a2;
	String ciudad;
	String hotel;
	
	int ida,vuelta, mes, mesV;
	
	public CyclicBehaviourAlojamiento(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		int encontrado=0;
		int disponibles=1;
		ACLMessage msg  = this.myAgent.blockingReceive(MessageTemplate.MatchOntology("ontologia"));
		
		try {
			r = (Reserva) msg.getContentObject();
			ciudad=r.getDestino();
			hotel=r.getHotel();
			ida=r.getIda();
			vuelta=r.getVuelta();
			mes = r.getMes();
			mesV = r.getMesVuelta();
			
		} catch (UnreadableException e1) {
			e1.printStackTrace();
		}
		String emisor=r.getUsuarioEmisor();
		if(p==0) {
			Modelo m=new Modelo();
			ArrayList<Alojamiento> a1 = m.getSitios();
			a2 = a1;
			p=p+1;
		}
		
		for(int i=0;i<a2.size();i++) {
			if(a2.get(i).getCiudad().equalsIgnoreCase(ciudad)) {
				if(a2.get(i).getNombreHotel().equalsIgnoreCase(hotel)) {
					a=new Alojamiento(a2.get(i).getCiudad(),a2.get(i).getNombreHotel(),a2.get(i).getHabitaciones(),a2.get(i).getCalendario(),emisor,"A");
					encontrado=1;
					break;
				}
			}
		}
		
		if(encontrado==1) {
			if(mes == mesV) {
				int calendario[][]=a.getCalendario();
				for(int j=(ida-1);j<vuelta;j++) {
					if(calendario[mes-1][j]==0) {
						disponibles=0;
						break;
					}
				}
				if(disponibles==0) {
					b=new Alojamiento("","",0,null,emisor,"A");
					Utils.enviarMensaje(this.myAgent,"corteIngles",b,0,"A");
				}
				else {
					for(int l=(ida-1);l<vuelta;l++) {
						calendario[mes-1][l]-=1;
					}
					Utils.enviarMensaje(this.myAgent,"corteIngles",a,0,"A");
				}
			}else {
				int calendario[][]=a.getCalendario();
				if(mes == 2) {
					for(int j=(ida-1);j<28;j++) {
						if(calendario[mes-1][j]==0) {
							disponibles=0;
							break;
						}
					}
					for(int j=0;j<(vuelta-1);j++) {
						if(calendario[mes-1][j]==0) {
							disponibles=0;
							break;
						}
					}
				}else if(mes == 11 || mes == 4 || mes == 6 || mes == 9) {
					for(int j=(ida-1);j<30;j++) {
						if(calendario[mes-1][j]==0) {
							disponibles=0;
							break;
						}
					}
					for(int j=0;j<(vuelta-1);j++) {
						if(calendario[mes-1][j]==0) {
							disponibles=0;
							break;
						}
					}
				}else {
					for(int j=(ida-1);j<31;j++) {
						if(calendario[mes-1][j]==0) {
							disponibles=0;
							break;
						}
					}
					for(int j=0;j<(vuelta-1);j++) {
						if(calendario[mes-1][j]==0) {
							disponibles=0;
							break;
						}
					}
				}
				
				if(disponibles==0) {
					b=new Alojamiento("","",0,null,emisor,"A");
					Utils.enviarMensaje(this.myAgent,"corteIngles",b,0,"A");
				}
				else {
					for(int l=(ida-1);l<vuelta;l++) {
						calendario[mes-1][l]-=1;
					}
					Utils.enviarMensaje(this.myAgent,"corteIngles",a,0,"A");
				}
			}
		}
		else {
			b=new Alojamiento("","",0,null,emisor,"A");
			Utils.enviarMensaje(this.myAgent,"corteIngles",b,0,"A");
		}
			
	}

}
