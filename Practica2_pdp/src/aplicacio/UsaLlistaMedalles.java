package aplicacio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dades.*;
import llista.LlistaMedalles;

public class UsaLlistaMedalles {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Indica el número de línies a llegir del fitxer (màxim 21694)");
		int numLinies = Integer.parseInt(teclat.nextLine());
		String[] dataset = llegirLiniesFitxer(numLinies);

		// mostrem el contingut que hem llegit. Això ho eliminarem en les
		// versions finals del codi
		for (int i = 0; i < dataset.length; i++) {
			 System.out.println("Linia " + (i + 1) + " conté " + dataset[i]);
		}

		// Completar el codi a partir d'aquí

		String disciplina = "";
		String poblacioJocs = "";
		int anyJocs = 0;
		String nomProva = "";
		String genere = "";
		String medalla = "";
		String tipusParticipacio = "";
		String paisAtleta = "";
		char caracter = ' ';
		int j = 0;
		int cas = 0;
		int memoria = 0;
		boolean trobat = false;
		Medalla m;
		LlistaMedalles llista = new LlistaMedalles(numLinies);

		for (int i = 0; i < dataset.length; i++) {
			cas = 0;
			while (j < dataset[i].length()){
				caracter = dataset[i].charAt(j);
				if(caracter == ';' ){
						cas++;
						if (cas != 7){
						j++;
						caracter = dataset[i].charAt(j);
						}
				}

				switch (cas) {
					case 0:
						disciplina = disciplina + caracter;
						break;

					case 1:
						if (trobat){
							memoria = (caracter - '0') * 1000;
							anyJocs = memoria;
							j++;
							caracter = dataset[i].charAt(j);
							memoria = (caracter - '0') * 100;
							anyJocs = anyJocs + memoria;
							j++;
							caracter = dataset[i].charAt(j);
							memoria = (caracter - '0') * 10;
							anyJocs = anyJocs + memoria;
							j++;
							caracter = dataset[i].charAt(j);
							memoria = (caracter - '0');
							anyJocs = anyJocs + memoria;
							
						}
						else if(caracter == '-')
							trobat = true;
						else
							poblacioJocs = poblacioJocs + caracter;
						break;

					case 2:
						nomProva = nomProva + caracter;
						break;
					case 3:
					    genere = genere + caracter;
						break;
					case 4:
                        medalla = medalla + caracter;
						break;
					case 5:
					    tipusParticipacio = tipusParticipacio + caracter;
						break;
					case 6:
					    paisAtleta = paisAtleta + caracter;
						break;
					default:
					    break;
				}
				j++;



			}

			m = new Medalla(disciplina, poblacioJocs, anyJocs, nomProva, genere, medalla, tipusParticipacio, paisAtleta);
			llista.afegirMedalla(m);
			disciplina = "";
			poblacioJocs = "";
			anyJocs = 0;
			nomProva = "";
			genere = "";
			medalla = "";
			tipusParticipacio = "";
			paisAtleta = "";

			j = 0;

	   }

	   System.out.println(llista.toString());

	}

	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 21694)
			nLinies = 21694;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("olympic_medals_part_UTF8.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

}