package corteIngles;

import java.util.ArrayList;
import java.io.*;

public class Alojamiento implements Serializable{
	private String ciudad;
	private String nombreHotel;
	private int habitaciones;
	private int[][] calendario;
	private String usuarioEmisor;
	private String tipoActividad;
	
	public Alojamiento(String ciudad, String nombreHotel, int habitaciones, int [][] calendario,String emisor,String ta){
		this.ciudad = ciudad;
		this.nombreHotel = nombreHotel;
		this.habitaciones = habitaciones;
		this.calendario = calendario;
		this.usuarioEmisor=emisor;
		this.tipoActividad=ta;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public int[][] getCalendario() {
		return calendario;
	}

	public void setCalendario(int[][] calendario) {
		this.calendario = calendario;
	}

	public String getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(String usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
	
	
}
