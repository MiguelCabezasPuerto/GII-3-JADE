package corteIngles;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class CyclicBehaviourCorteIngles extends CyclicBehaviour {
	Reserva r;

	public CyclicBehaviourCorteIngles(Agent agent) {
		super(agent);
	}
	
	//@SuppressWarnings("deprecation")
	@Override
	public void action() {
		ACLMessage msg  = this.myAgent.receive(MessageTemplate.MatchOntology("ontologia"));
		
	if(msg!=null) {
		
		if(msg.getPerformative()==ACLMessage.REQUEST) {
			try {
				r = (Reserva) msg.getContentObject();
			} catch (UnreadableException e1) {
				e1.printStackTrace();
			}
			if(r.getTipo().equalsIgnoreCase("A")) {
				try {
					Utils.enviarMensaje(this.myAgent,"alojamiento",msg.getContentObject(),1,"");
				} catch (UnreadableException e) {
					e.printStackTrace();
				}
			}else if(r.getTipo().equalsIgnoreCase("O")){
					try {
						Utils.enviarMensaje(this.myAgent, "ocio", msg.getContentObject(),1,"");
					} catch (UnreadableException e) {
						e.printStackTrace();
					}
				}
		}else if(msg.getPerformative()==ACLMessage.INFORM) {
			try {
				Utils.enviarMensajeAUsuarioAlojamiento(this.myAgent,"usuario",msg.getContentObject());
			} catch (UnreadableException e) {
				e.printStackTrace();
			}
		}else if(msg.getPerformative()==ACLMessage.AGREE) {
			try {
				Utils.enviarMensajeAUsuarioOcio(this.myAgent,"usuario",msg.getContentObject());
			} catch (UnreadableException e) {
				e.printStackTrace();
			}
		}
	}
	else {
		block();
	}
	}

}
