package Dao;

import Utils.Conexion;
import model.Jugador;

public class JugadorDao  extends Conexion<Jugador>{
	
	public  JugadorDao() {
		super(Jugador.class);
	}

}
