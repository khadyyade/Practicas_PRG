package llista;
import dades.*;



public class LlistaMedalles {


    private int nmedalles;
    private Medalla[] llista;

	/**
     * Constructor de la clase LlistaMedalles.
     * @param n quantita de medalles
     **/
    public LlistaMedalles(int n){
        nmedalles = 0;
        llista = new Medalla[n];
    }
	/**
     * Metode que afegeix medalla mentre hi hagi espai a la taula de medalles
     * @param Medalla nova medalla
     **/
    public void afegirMedalla(Medalla m){

        if(nmedalles < llista.length){
            llista[nmedalles] = m.copia();
            nmedalles++;
        }

    }

    /**
     * Metode per mostrar totes les medalles
     * @return String Conjunt de totes les medalles 
     **/

    public String toString() {
        String resultat= "";
        for (int i = 0; i < nmedalles; i++) {
            resultat = resultat +"["+(i+1)+"] "+ llista[i].toString() + "\n";
        }
        return resultat;
	}

     /**
     * Metode per fer una consulta concreta: ciutat any medalla i pais
     * @param ciutat
     * @param any
     * @param medalla
     * @param inicials
     * @return int total de medalles que cumpleixen les caracteristiques
     **/

    public int consultaMedalles(String ciutat, int any, String medalla, String inicials){
        int nummedalles = 0;
        for (int i = 0; i < nmedalles; i++) {
            if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any) && llista[i].esDaquestPais(inicials) && llista[i].esTipusMedalla(medalla)){
                nummedalles++;
            }
        }
        return nummedalles;
    }

    /**
     * Metode per fer una consulta concreta: la primera medalla que cumpleix medalla, sexe i any
     * @param medalla
     * @param sexe
     * @param any
     * @return Medalla instancia de la primera medalla
     **/

    public Medalla consultaMedallaprimera (String medalla, String sexe, int any){
        
        int i;
        for (i = 0; i < nmedalles; i++) {
            if (llista[i].esDaquestSexe(sexe) && llista[i].celebratAny(any) && llista[i].esTipusMedalla(medalla)){
                return (llista[i]);
            }
        } 
        return null;
        
    }

    /**
     * Metode per fer una consulta concreta: la primera medalla d'una dona que cumpleix ciutat i any
     * @param ciutat
     * @param any
     * @return Medalla instancia de la primera medalla
     **/

    public Medalla consultaMedallaPrimeraDona (String ciutat, int any){
        
        int i;
        for (i = 0; i < nmedalles; i++) {
            if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any) && llista[i].esDaquestSexe("Women")){
                return (llista[i].copia());
            }
        } 
        return null;
    }

    /**
     * Metode per fer una consulta concreta: el pais amb mes d'una medalla concreta
     * @param medalla
     * @return String inicials del pais
     **/

    public String consultaPais(String medalla) {
        int numPaisos = 0;
        int maxim = 0;
        int pos_maxim = 0;
        String[] taulaPaises = new String[300];
        int[] taulaMedalles = new int[300];
        
        for (int i = 0; i < nmedalles; i++) {
            if (llista[i].esTipusMedalla(medalla)) {
                boolean trobat = false;
                int j = 0;
                
                while (j < numPaisos && !trobat) {
                    if (llista[i].esDaquestPais(taulaPaises[j])) {
                        trobat = true;
                    } else {
                        j++;
                    }
                }
                
                if (trobat) {
                    taulaMedalles[j]++;
                } else {
                    taulaPaises[numPaisos] = llista[i].getPais();
                    taulaMedalles[numPaisos] = 1;
                    numPaisos++;
                }
            }
        }
    
        for (int index = 0; index < numPaisos; index++) {
            if (taulaMedalles[index] > maxim) {
                maxim = taulaMedalles[index];
                pos_maxim = index;
            }
        }
    
        return taulaPaises[pos_maxim];
    }

    /**
     * Metode per fer una consulta concreta: medalles de cada tipus d'un país
     * @param pais
     * @return int taula de quantita de medalles del pais
     **/


    public int[] Medaller (String pais){
        int[] taulaMedaller = new int[3];
        for (int i = 0; i < taulaMedaller.length;i++){
            taulaMedaller[i]=0;
        }
        for (int i = 0; i < nmedalles; i++) {
            if (llista[i].esDaquestPais(pais)) {
                    if (llista[i].esTipusMedalla("GOLD")){
                        taulaMedaller[0]++;
                    }
                    if (llista[i].esTipusMedalla("SILVER")){
                        taulaMedaller[1]++;
                    }
                    if (llista[i].esTipusMedalla("BRONZE")){
                        taulaMedaller[2]++;
                    }
            }
        }
        return (taulaMedaller);

    }

    /**
     * Metode per fer una consulta concreta: medalles d'un tipus, ciutat y any 
     * @param tipus
     * @param ciutat
     * @param any
     * @return LlistaMedalles retorna un nou objecte amb les dades dessitjades
     **/

    public LlistaMedalles medallesAconseguides(String tipus, String ciutat, int any){


            int nummedalles = 0;
            for (int i = 0; i < nmedalles; i++) {
                if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any) && llista[i].esAquestaProva(tipus)){
                    nummedalles++;
                }
            }
        LlistaMedalles llista2 = new LlistaMedalles(nummedalles++);
        for (int i = 0; i < nmedalles; i++) {
            if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any) && llista[i].esAquestaProva(tipus)){
                llista2.afegirMedalla(llista[i]);
            }
        }
        return llista2;

    }

    /**
     * Metode per esborrar totes les medalles que cumpleixen ciutat i any
     * @param ciutat
     * @param any
     **/

    public void esborraMedalles(String ciutat, int any){

        int i = 0;
        while (i < nmedalles){
            if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any)){
                int j = i;
                while (j<(nmedalles-1)){
                    llista[j] =llista[j+1].copia();
                    j++;
                }    
            nmedalles--;            
            }
            else
                i++;

    }


}

    
}
