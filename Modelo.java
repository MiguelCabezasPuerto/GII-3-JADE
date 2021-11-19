package corteIngles;

import java.util.ArrayList;

public class Modelo {
	 private ArrayList<Alojamiento>sitios; 
		
	 	public Modelo(){
	 		ArrayList<Alojamiento>es=new ArrayList<>();
			AlojamientoS as=new AlojamientoS(es);	
			sitios=as.getAlojamientos();
	 	}

		public ArrayList<Alojamiento> getSitios() {
			return sitios;
		}

		public void setSitios(ArrayList<Alojamiento> sitios) {
			this.sitios = sitios;
		}
	 	
	 
}
