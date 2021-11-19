package corteIngles;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class CyclicBehaviourOcio extends CyclicBehaviour {
	Reserva r;
	Ocio a,b;
	static int p=0;
	ArrayList<Ocio> a2;
	String ciudad;
	String actividad;
	int fecha, mes;

	public CyclicBehaviourOcio(Agent agent) {
		super(agent);
	}
	
	@Override
	public void action() {
		int encontrado=0;
		int disponibles=1;
		ACLMessage msg  = this.myAgent.blockingReceive(MessageTemplate.MatchOntology("ontologia"));

		try {
			r = (Reserva) msg.getContentObject();
			actividad=r.getHotel();
			fecha=r.getIda();
			ciudad=r.getDestino();
			mes = r.getMes();
		} catch (UnreadableException e1) {
			e1.printStackTrace();
		}
		String emisor=r.getUsuarioEmisor();
		if(p==0) {
			Modelo2 m=new Modelo2();
			ArrayList<Ocio> a1 = m.getSitios();
			a2 = a1;
			p=p+1;
		}
		for(int i=0;i<a2.size();i++) {
			if(a2.get(i).getCiudad().equalsIgnoreCase(ciudad)) {
				if(a2.get(i).getNombreActividad().equalsIgnoreCase(actividad)) {
					a=new Ocio(a2.get(i).getCiudad(),a2.get(i).getNombreActividad(),a2.get(i).getPlazas(),a2.get(i).getCalendario(),emisor,"O");
					encontrado=1;
					break;
				}
			}
		}
		
		if(encontrado==1) {
			int calendario[][]=a.getCalendario();
				if(calendario[mes-1][fecha]==0) {
					disponibles=0;
				}
			
			if(disponibles==0) {
				b=new Ocio("","",0,null,emisor,"O");
				Utils.enviarMensaje(this.myAgent,"corteIngles",b,0,"O");
			}
			else {
			
				calendario[mes-1][fecha]-=1;
			
			Utils.enviarMensaje(this.myAgent,"corteIngles",a,0,"O");
			}
		}
		else {
			b=new Ocio("","",0,null,emisor,"O");
			Utils.enviarMensaje(this.myAgent,"corteIngles",b,0,"O");
		}
	}
	

}
