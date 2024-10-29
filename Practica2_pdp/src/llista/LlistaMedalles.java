package llista;
import dades.*;



public class LlistaMedalles {


    private int nmedalles;
    private Medalla[] llista;
    

    public LlistaMedalles(int n){
        nmedalles = 0;
        llista = new Medalla[n];
    }

    public void afegirMedalla(Medalla m){

        if(nmedalles < llista.length){
            llista[nmedalles] = m.copia();
            nmedalles++;
        }

    }

    public String toString() {
        String resultat= "";
        for (int i = 0; i < nmedalles; i++) {
            resultat = resultat +"["+(i+1)+"] "+ llista[i].toString() + "\n";
        }
        return resultat;
	}

    public int consultaMedalles(String ciutat, int any, String medalla, String inicials){
        int nummedalles = 0;
        for (int i = 0; i < nmedalles; i++) {
            if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any) && llista[i].esDaquestPais(inicials) && llista[i].esTipusMedalla(medalla)){
                nummedalles++;
            }
        }
        return nummedalles;
    }

    public Medalla consultaMedallaprimera (String medalla, String sexe, int any){
        
        int i;
        for (i = 0; i < nmedalles; i++) {
            if (llista[i].esDaquestSexe(sexe) && llista[i].celebratAny(any) && llista[i].esTipusMedalla(medalla)){
                return (llista[i-1]);
            }
        } 
        return null;
        
    }

    public Medalla consultaMedallaPrimeraDona (String ciutat, int any){
        
        int i;
        for (i = 0; i < nmedalles; i++) {
            if (llista[i].celebratEn(ciutat) && llista[i].celebratAny(any) && llista[i].esDaquestSexe("Women")){
                return (llista[i-1].copia());
            }
        } 
        return null;
    }


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
    


    
    /*public void afegirMedalla(Medalla m){
        int i = 0;
        boolean error = false;
        while(i < nmedalles){

            if (llista[i].getNom().equals(p.getNom()) && llista[i].getDefinicio().equals(p.getDefinicio()))
                error = true;
            i++;
        }
        if(nmedalles < llista.length && error == false){
            llista[nmedalles] = p.copia();
            nmedalles++;
        }
    }

    public void esborrarMedalla(String p){
        int i = 0;

        while (i < nmedalles){
            if (llista[i].getNom().equals(p)){
                int j = i;
                while (j<Definicions(nmedalles-1)){
                    llista[j] =llista[j+1].copia();
                    j++;
                }    
            nmedalles--;            
            }
            else
                i++;

        }
    

    }

    public String mostraMedalles(){

        String texto = "";

        int i = 0;

        while (i < nmedalles){
           
            texto = texto + "["+i+"] "+ llista[i].getNom() + ": " + llista[i].getDefinicio()+"\n";
            i++;

        }

        return texto;

    }

    public int numDefinicions(String p){

        int num = 0;
        int i = 0;
        while (i < nmedalles){
            if (llista[i].getNom().equals(p)){
                num++;
            }
            i++;
        }

        return num;
        
    }

    public String consultDefinicio(int acepcio, String p){

        String def = "";
        int num_acepcio = 0;
        int i = 0;
        boolean trobat = false;
        while (i < nmedalles && !trobat){
            if (llista[i].getNom().equals(p)){
                num_acepcio++;
                if (num_acepcio == acepcio){
                    def = ""+llista[i].getDefinicio();
                    trobat = true;
                }
               
            }
            i++;
        }

        return def;
        
    }

    public String totesDefinicionsParaula (String p){

        String def = "";
        int i = 0;
        while (i < nmedalles){
            if (llista[i].getNom().equals(p)){
                def = def + "["+(i+1)+"] "+ llista[i].getDefinicio()+"\n";
            }
            i++;
        }

        return def;
        
    }

    public int numParaules (){

        return nmedalles;
        
    }

    public Paraula paraulaIessima(int num_paraula){

        return llista[num_paraula];
        
    }
        */








    
}
