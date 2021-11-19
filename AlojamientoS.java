package corteIngles;

import java.util.*;

public class AlojamientoS{
	int [][]c1=new int[12][31];
	int [][]c2=new int[12][31];
	int [][]c3=new int[12][31];
	int [][]c4=new int[12][31];
	int [][]c5=new int[12][31];
	private ArrayList<Alojamiento>alojamientos;
	
	public AlojamientoS(ArrayList<Alojamiento>alojamientos){
		Alojamiento a1=new Alojamiento("Salamanca","Corona",5,c1," ","A");
		Alojamiento a2=new Alojamiento("Washington","Torre Trump",10,c2," ","A");
		Alojamiento a3=new Alojamiento("Madrid","Ritz",15,c3," ","A");
		Alojamiento a4=new Alojamiento("Salamanca","Alameda Palace",7,c4," ","A");
		Alojamiento a5=new Alojamiento("Madrid","Pension Loli",1,c5," ","A");
		for(int i=0;i<12;i++) {
			for(int j = 0; j < 31; j++) {
				c1[i][j]=a1.getHabitaciones();
				c2[i][j]=a2.getHabitaciones();
				c3[i][j]=a3.getHabitaciones();
				c4[i][j]=a4.getHabitaciones();
				c5[i][j]=a5.getHabitaciones();
			}
		}
		a1.setCalendario(c1);
		alojamientos.add(a1);
		a2.setCalendario(c2);
		alojamientos.add(a2);
		a3.setCalendario(c3);
		alojamientos.add(a3);
		a4.setCalendario(c4);
		alojamientos.add(a4);
		a5.setCalendario(c5);
		alojamientos.add(a5);
		this.alojamientos=alojamientos;
	}

	public ArrayList<Alojamiento> getAlojamientos() {
		return alojamientos;
	}

	public void setAlojamientos(ArrayList<Alojamiento> alojamientos) {
		this.alojamientos = alojamientos;
	}
	
	
}
