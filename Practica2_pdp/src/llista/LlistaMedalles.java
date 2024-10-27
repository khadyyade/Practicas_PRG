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
