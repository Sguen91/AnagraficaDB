package it.softwareInside.AnagraficaAppLezione23.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.services.PersonaService;

@RestController
public class PersonaRestController {

	
	@Autowired
	PersonaService personaService;
	
	
	@PostMapping("/add")
	public boolean addPersona(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}
	
	@GetMapping("/getPersona")
	public Persona getPersona(@RequestParam("codiceFiscale") String codiceFiscale) {
		return personaService.getPersona(codiceFiscale);
	}
	
	@GetMapping("/getAll")
	public Iterable<Persona> getAll() {
		return personaService.getAll();
	}
	
	@DeleteMapping("/deletePersona")
	public Persona delete(@RequestParam("delete")String codiceFiscale) {
		return personaService.deletePersona(codiceFiscale);
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAll() {
		personaService.deleteAll();
	}
	
	@PostMapping("/update")
	public boolean updatePersona(@RequestBody Persona persona) {
		return personaService.updatePersona(persona);
	}
	
	@GetMapping("/etaSuperiore")
	public Iterable<Persona> getEta() {
		return personaService.calcolaEtaMaggiore25(getAll());
	}
}
