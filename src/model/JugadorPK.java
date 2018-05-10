package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the jugador database table.
 * 
 */
@Embeddable
public class JugadorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=true, updatable=true)
	private int equipo;

	private int numero;

	public JugadorPK() {
	}
	public int getEquipo() {
		return this.equipo;
	}
	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JugadorPK)) {
			return false;
		}
		JugadorPK castOther = (JugadorPK)other;
		return 
			(this.equipo == castOther.equipo)
			&& (this.numero == castOther.numero);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.equipo;
		hash = hash * prime + this.numero;
		
		return hash;
	}
}