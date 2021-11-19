package corteIngles;

import java.io.Serializable;

public class Ocio implements Serializable {
	private String ciudad;
	private String nombreActividad;
	private int plazas;
	private int[][] calendario;
	private String usuarioEmisor;
	private String tipoActividad;
	
	public Ocio(String ciudad, String nombreActividad, int plazas, int [][] calendario,String emisor,String ta){
		this.ciudad = ciudad;
		this.nombreActividad = nombreActividad;
		this.plazas = plazas;
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

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
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
