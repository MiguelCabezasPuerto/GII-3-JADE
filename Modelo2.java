package corteIngles;

import java.util.ArrayList;

public class Modelo2 {
	 private ArrayList<Ocio>sitios; 
		
	 	public Modelo2(){
	 		ArrayList<Ocio>es=new ArrayList<>();
			OcioS as=new OcioS(es);	
			sitios=as.getOcios();
	 	}

		public ArrayList<Ocio> getSitios() {
			return sitios;
		}

		public void setSitios(ArrayList<Ocio> sitios) {
			this.sitios = sitios;
		}
}
