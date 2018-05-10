package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipo database table.
 * 
 */

@Entity
@Table(name="equipo")
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	private String presidente;

	//bi-directional many-to-one association to Jugador
	@OneToMany(mappedBy="equipoBean")
	private List<Jugador> jugadors;

	public Equipo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresidente() {
		return this.presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public List<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(List<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Jugador addJugador(Jugador jugador) {
		getJugadors().add(jugador);
		jugador.setEquipoBean(this);

		return jugador;
	}

	public Jugador removeJugador(Jugador jugador) {
		getJugadors().remove(jugador);
		jugador.setEquipoBean(null);

		return jugador;
	}

}