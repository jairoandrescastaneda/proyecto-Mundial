package Controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Dao.EquipoDao;
import Dao.JugadorDao;
import model.Equipo;
import model.Jugador;
import model.JugadorPK;


@RestController
public class JugadorController {


@RequestMapping(value="/jugador/create/",params = { "nombre", 
		"posicion",
		"correo", 
		"equipo_id",
		"numero"
		,"fecha_nacimiento"},
		method = RequestMethod.POST)
public ResponseEntity  JugadorCreate(@RequestParam("nombre") String nombre,
		@RequestParam("posicion") String posicion, @RequestParam("correo") String correo,
@RequestParam("equipo_id") String equipo_id, @RequestParam("numero") String numero,@RequestParam("fecha_nacimiento") String fecha_nacimiento) {

	JugadorDao ju = new JugadorDao();
	Jugador jugador = new Jugador();
	jugador.setEmail(correo);
	jugador.setNombre(nombre);
	jugador.setPosicion(posicion);

	Date fecha = new Date();
	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 try {
		fecha = dateFormat.parse(fecha_nacimiento);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 jugador.setFechanacimiento(fecha);

	

	EquipoDao dao = new EquipoDao();
	Equipo equipo = dao.find(Integer.parseInt(equipo_id));
	jugador.setEquipoBean(equipo);
	
	
	JugadorPK jugadorpk = new JugadorPK();
	jugadorpk.setEquipo(equipo.getId());
	jugadorpk.setNumero(Integer.parseInt((numero)));
	jugador.setId(jugadorpk);
	ju.insert(jugador);
	
	
	return ResponseEntity.ok(HttpStatus.OK);
	 

}

@ResponseBody	
@RequestMapping("/jugador/")
public ArrayList<Jugador>ListarJugadores(){
	JugadorDao dao = new JugadorDao();
	return  dao.list();
	
	
}
	



@RequestMapping(value="/jugador/edit/",params = { "equipo_id","numero","nombre", 
		"posicion",
		"correo", 
		"equipo_id",
		"numero"
		,"fecha_nacimiento"},
		method = RequestMethod.POST)
public ResponseEntity EditarJugador(
		@RequestParam("nombre") String nombre,
		@RequestParam("posicion") String posicion, @RequestParam("correo") String correo,
@RequestParam("equipo_id") String equipo_id, @RequestParam("numero") String numero,@RequestParam("fecha_nacimiento") String fecha_nacimiento
)

{
	
	EquipoDao dao = new EquipoDao();
	
	return ResponseEntity.ok(HttpStatus.OK);
	
}

}
