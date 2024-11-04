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

	
	/**
     * Metode per mostrar una instancia com a text 
     * @return String Text d'una instancia
     **/
	@Override
	public String toString() {
		return "Medalla [disciplina=" + disciplina + ", poblacioJocs=" + poblacioJocs + ", anyJocs=" + anyJocs
				+ ", nomProva=" + nomProva + ", genere=" + genere + ", medalla=" + medalla + ", tipusParticipacio="
				+ tipusParticipacio + ", paisAtleta=" + paisAtleta + "]";
	}
	/**
     * Metode per copiar els elements d'un objecte a un altre
     * @return Medalla 
     **/
	public Medalla copia() {
		Medalla aux=new Medalla(disciplina, poblacioJocs, anyJocs, nomProva, genere, medalla, tipusParticipacio, paisAtleta);
		return aux;
	}
	/**
     * Metode per comparar un element d'un objecte amb un altre
	 * @param nomCiutat
     * @return boolean si es igual o no 
     **/
    public boolean celebratEn(String nomCiutat) {
        return (poblacioJocs.equalsIgnoreCase(nomCiutat));
    }
	/**
     * Metode per comparar un element d'un objecte amb un altre
	 * @param anyJocs
     * @return boolean si es igual o no 
     **/
    public boolean celebratAny(int anyJocs) {
        return (this.anyJocs==anyJocs);
    }
	/**
     * Metode per comparar un element d'un objecte amb un altre
	 * @param tipusMedalla
     * @return boolean si es igual o no 
     **/
    public boolean esTipusMedalla(String tipusMedalla) {
        return (medalla.equalsIgnoreCase(tipusMedalla));
    }
	/**
     * Metode per comparar un element d'un objecte amb un altre
	 * @param pais
     * @return boolean si es igual o no 
     **/
    public boolean esDaquestPais(String pais) {
        return (paisAtleta.equalsIgnoreCase(pais));
    }
	/**
     * Metode per comparar un element d'un objecte amb un altre
	 * @param sexe
     * @return boolean si es igual o no 
     **/
    public boolean esDaquestSexe(String sexe) {
        return (genere.equalsIgnoreCase(sexe));
    }
	/**
     * getter per obtenir el país d'un objecte medalla
     * @return boolean si es igual o no 
     **/
    public String getPais() {
        return paisAtleta;
    }
	/**
     * Metode per comparar un element d'un objecte amb un altre
	 * @param nomProva
     * @return boolean si es igual o no 
     **/
	public boolean esAquestaProva(String nomProva) {
		return (this.nomProva.equalsIgnoreCase(nomProva));
	}
}
