package dades;

public class Medalla {
	private String disciplina;
	private String poblacioJocs;
	private int anyJocs;
	private String nomProva;
	private String genere;
	private String medalla;
	private String tipusParticipacio;
	private String paisAtleta;

	/**
     * Constructor de la clase Medalla.
     * @param nombre Nombre de la medalla.
     * @param tipo Tipo de la medalla (oro, plata, bronce).
     * @param año Año en que se obtuvo la medalla.
     **/
	public Medalla(String disciplina, String poblacioJocs, int anyJocs, String nomProva, String genere, String medalla,
			String tipusParticipacio, String paisAtleta) {
		this.disciplina = disciplina;
		this.poblacioJocs = poblacioJocs;
		this.anyJocs = anyJocs;
		this.nomProva = nomProva;
		this.genere = genere;
		this.medalla = medalla;
		this.tipusParticipacio = tipusParticipacio;
		this.paisAtleta = paisAtleta;
	}

	

	@Override
	public String toString() {
		return "Medalla [disciplina=" + disciplina + ", poblacioJocs=" + poblacioJocs + ", anyJocs=" + anyJocs
				+ ", nomProva=" + nomProva + ", genere=" + genere + ", medalla=" + medalla + ", tipusParticipacio="
				+ tipusParticipacio + ", paisAtleta=" + paisAtleta + "]";
	}

	public Medalla copia() {
		Medalla aux=new Medalla(disciplina, poblacioJocs, anyJocs, nomProva, genere, medalla, tipusParticipacio, paisAtleta);
		return aux;
	}

    public boolean celebratEn(String nomCiutat) {
        return (poblacioJocs.equalsIgnoreCase(nomCiutat));
    }

    public boolean celebratAny(int anyJocs) {
        return (this.anyJocs==anyJocs);
    }

    public boolean esTipusMedalla(String tipusMedalla) {
        return (medalla.equalsIgnoreCase(tipusMedalla));
    }

    public boolean esDaquestPais(String pais) {
        return (paisAtleta.equalsIgnoreCase(pais));
    }

    public boolean esDaquestSexe(String sexe) {
        return (genere.equalsIgnoreCase(sexe));
    }

    public String getPais() {
        return paisAtleta;
    }

	public boolean esAquestaProva(String nomProva) {
		return (this.nomProva.equalsIgnoreCase(nomProva));
	}
}
