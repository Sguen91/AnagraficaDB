package it.softwareInside.AnagraficaAppLezione23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Persona {
	@Id
	@Size(min=5,max=5)
	private  String codiceFiscale;
	
	@Min(15)
	
	private int eta;
	
	@NotNull(message = "errore nome null")
	@NotEmpty(message = "errore nome empty")
	private String nome;
	
	@NotNull(message = "errore cog null")
	@NotEmpty(message = "errore cog empty")
	private String cognome;
	
	public Persona(String codiceFiscale, String nome, String cognome, int eta) {
		setCodiceFiscale(codiceFiscale);
		setNome(nome);
		setCognome(cognome);
		setEta(eta);

	}
	
}
