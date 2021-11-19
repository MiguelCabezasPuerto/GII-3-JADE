package corteIngles;

import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AgenteOcio extends Agent {
	
	@Override
	protected void setup() {
		//Servicios
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		
		ServiceDescription sd=new ServiceDescription();
		sd.setName("Servicio Corte Ingles");
		sd.setType("ocio");
		sd.addOntologies("ontologia");
		sd.addLanguages(new SLCodec().getName());
		
		dfd.addServices(sd);
		
		//Avisar al DF de que ese agente da el servicio definido
		try{
			DFService.register(this, dfd);
		}catch (FIPAException e){
				e.printStackTrace();
		}
		
		//Definir comportamientos
		addBehaviour(new CyclicBehaviourOcio(this));
	}
}
