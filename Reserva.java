package corteIngles;

import java.io.Serializable;

public class Reserva implements Serializable {
	private String destino;
	private int ida;
	private int vuelta;
	private int mes;
	private String tipo;
	private String usuarioEmisor;
	private String hotel;
	private int mesVuelta;
	
	public Reserva(String destino, int ida, int vuelta, String tipo,String emisor,String h, int mes, int mesVuelta) {
		this.destino = destino;
		this.ida = ida;
		this.vuelta = vuelta;
		this.tipo = tipo;
		this.usuarioEmisor=emisor;
		this.hotel=h;
		this.mes = mes;
		this.mesVuelta = mesVuelta;
	}

	
	
	public int getMesVuelta() {
		return mesVuelta;
	}


	public void setMesVuelta(int mesVuelta) {
		this.mesVuelta = mesVuelta;
	}


	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getIda() {
		return ida;
	}

	public void setIda(int ida) {
		this.ida = ida;
	}

	public int getVuelta() {
		return vuelta;
	}

	public void setVuelta(int vuelta) {
		this.vuelta = vuelta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuarioEmisor() {
		return usuarioEmisor;
	}

	public void setUsuarioEmisor(String usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	
	
	
}
