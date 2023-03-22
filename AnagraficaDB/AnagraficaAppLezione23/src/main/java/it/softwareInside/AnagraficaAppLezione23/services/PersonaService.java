package it.softwareInside.AnagraficaAppLezione23.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.repository.PersonaRepository;
import jakarta.validation.Valid;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	/**
	 * Metodo per aggiungere una persona passando
	 * come parametro un oggetto di tipo persona
	 * @param persona
	 * @return
	 */
	public boolean addPersona(@Valid Persona persona) {
		try {

			personaRepository.save(persona);

			return true;

		} catch (Exception e) {
			System.out.println("sei un pirla: "+e);
			
			return false;

		}
	}
	/**
	 * Metodo per cancellare una persona passando
	 * come parametro il codice fiscale
	 * @param codiceFiscale
	 * @return
	 */
	public Persona deletePersona(String codiceFiscale) {

		try {

			Persona personaTmp = personaRepository.findById(codiceFiscale).get();
			
			personaRepository.deleteById(codiceFiscale);
			
			return personaTmp;

		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * Metodo per cancellare tutte le persone 
	 * 
	 * @param codiceFiscale
	 * @return
	 */
	public void deleteAll() {
		try {

			personaRepository.deleteAll();
			System.out.println("Hai cancellato tutto con successo!");

		} catch (Exception e) {
			System.out.println("Non ha cancellato nulla");
		}
	}
	/**
	 * Metodo per modificare una persona passando
	 * come parametro un oggetto di tipo persona
	 * @param codiceFiscale
	 * @return
	 */
	public boolean updatePersona(@Valid Persona persona) {
		return addPersona(persona);
	}
	/**
	 * Metodo per stampare una persona passando
	 * come parametro il codice fiscale
	 * @param codiceFiscale
	 * @return
	 */
	public Persona getPersona(String codiceFiscale) {

		try {

			return personaRepository.findById(codiceFiscale).get();

		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * Metodo per stampare la lista delle persone 
	 * presenti nel db
	 * @param codiceFiscale
	 * @return
	 */
	public Iterable<Persona> getAll() {

		try {

			return personaRepository.findAll();

		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * Metodo per stampare tutte le persone 
	 * con eta maggiore o uguale a 25 passando
	 * come parametro un iterable di persona.
	 * Uso di un foreach per confrontare le persone con l'eta richiesta.
	 * @param codiceFiscale
	 * @return
	 */
	public Iterable<Persona> calcolaEtaMaggiore25(Iterable<Persona> persone) {

		ArrayList<Persona> over25 = new ArrayList<>();

		for (Persona persona : personaRepository.findAll()) {
			if (persona.getEta() >= 25)
				over25.add(persona);
			
		}
		return over25;
	}
}
