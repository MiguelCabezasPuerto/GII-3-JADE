package corteIngles;

import java.util.ArrayList;

public class OcioS {
	int [][]c1=new int[12][31];
	int [][]c2=new int[12][31];
	int [][]c3=new int[12][31];
	int [][]c4=new int[12][31];
	int [][]c5=new int[12][31];
	private ArrayList<Ocio>ocios;
	
	public OcioS(ArrayList<Ocio>ocios){
		Ocio a1=new Ocio("Salamanca","Submarinismo",5,c1," ","O");
		Ocio a2=new Ocio("Albacete","Canoa",5,c1," ","O");
		Ocio a3=new Ocio("Benidorm","Escalada",5,c1," ","O");
		Ocio a4=new Ocio("Soria","Surf",5,c1," ","O");
		Ocio a5=new Ocio("Murcia","Barranquismo",1,c1," ","O");
		for(int i=0;i<12;i++){
			for(int j = 0; j < 31; j++) {
				c1[i][j]=a1.getPlazas();
				c2[i][j]=a2.getPlazas();
				c3[i][j]=a3.getPlazas();
				c4[i][j]=a4.getPlazas();
				c5[i][j]=a5.getPlazas();
			}
		}
		a1.setCalendario(c1);
		ocios.add(a1);
		a2.setCalendario(c2);
		ocios.add(a2);
		a3.setCalendario(c3);
		ocios.add(a3);
		a4.setCalendario(c4);
		ocios.add(a4);
		a5.setCalendario(c5);
		ocios.add(a5);
		this.ocios=ocios;
}

	public ArrayList<Ocio> getOcios() {
		return ocios;
	}

	public void setOcios(ArrayList<Ocio> ocios) {
		this.ocios = ocios;
	}
	
}