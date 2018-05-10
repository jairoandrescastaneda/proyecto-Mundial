package Controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Dao.EquipoDao;
import model.Equipo;

@RestController
public class EquipoController {

	@RequestMapping("/equipo/create")
	public ResponseEntity Equipocreate(@RequestParam("nombre") String nombre, @RequestParam("presidente") String presidente){
		
	Equipo e = new Equipo();
	e.setNombre(nombre);
	e.setPresidente(presidente);
	EquipoDao dao = new EquipoDao();
	dao.insert(e);
		
		return ResponseEntity.ok(HttpStatus.OK); 
	}
	
	
	//lista el equiupo
	@ResponseBody()
	@RequestMapping("/equipo/listar/")
	public ArrayList<Equipo>  EquipoListar() {
	EquipoDao dao = new EquipoDao();
	ArrayList<Equipo>equipos = dao.list();
	return equipos;
	
	}
	
	
	//Edicion de equipo recibe nombre, presidente, e id
	@RequestMapping("equipo/edit")
	public ResponseEntity EquipoEditar(@RequestParam("nombre") String nombre , @RequestParam("presidente") String presidente,@RequestParam("pk") String pk) {
		EquipoDao dao = new EquipoDao();
		Equipo equipo = dao.find(Integer.parseInt(pk));
		
		equipo.setNombre(nombre);
		equipo.setPresidente(presidente);
		return ResponseEntity.ok(HttpStatus.OK);
		
	}
	
}
