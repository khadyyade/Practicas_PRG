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

		// Inicialització de variables

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
		LlistaMedalles llista = new LlistaMedalles(numLinies+20);

		//Inseció dels elements a la classe

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
			trobat = false;
			j = 0;

	   }
	   


		m = new Medalla(disciplina, poblacioJocs, anyJocs, nomProva, genere, medalla, tipusParticipacio, paisAtleta);
		llista.afegirMedalla(m);

	   //Mostrar menu

        int opcio = 0;
		boolean continuar = true;

        while (continuar) {
            System.out.println("\n\n--- Menú ---\n");
            System.out.println("1. Mostrar el conjunt de dades de la llista.");
            System.out.println("2. Mostrar el número de medalles aconseguides per un país, d’un cert tipus, en els jocs d’un any en una ciutat.");
            System.out.println("3. Mostrar la primera medalla d’un cert tipus, obtinguda per una persona d’un determinat sexe i en un any.");
            System.out.println("4. Mostrar la primera medalla aconseguida per una dona en els jocs olímpics d’un cert any.");
            System.out.println("5. Mostrar el país que ha aconseguit més medalles d’un cert tipus.");
            System.out.println("6. Mostrar el medaller del país.");
            System.out.println("7. Mostrar qui ha aconseguit les medalles en un tipus de prova i en uns jocs.");
            System.out.println("8. En el conjunt de medalles d’un tipus de prova i jocs, mostrar la primera medalla d’un cert tipus, obtinguda per una persona d’un determinat sexe i en un any.");
            System.out.println("9. En el conjunt de medalles d’un tipus de prova i jocs, mostrar el país que ha aconseguit més medalles d’un cert tipus.");
            System.out.println("10. Eliminar el conjunt de medalles d’uns jocs en un tipus de prova.");
            System.out.println("11. Sortir del programa.");
            System.out.print("Selecciona una opció: ");
            
			opcio =  Integer.parseInt(teclat.nextLine());

            switch (opcio) {
                case 1: System.out.println(llista.toString()); break;
                case 2:  
					System.out.print("Exemple: ITA GOLD 2022 beijing\n");
					System.out.print(">> Introdueix les inicials del país: ");
                    paisAtleta = teclat.nextLine();
                    System.out.print(">> Introdueix el tipus de medalla: ");
                    medalla = teclat.nextLine();
                    System.out.print(">> Introdueix l’any: ");
                    anyJocs = Integer.parseInt(teclat.nextLine());
                    System.out.print(">> Introdueix la ciutat: ");
                    poblacioJocs = teclat.nextLine();
                    System.out.println("Numero de medalles: " + llista.consultaMedalles(poblacioJocs, anyJocs, medalla, paisAtleta));
					break;
                case 3:
					System.out.print("Exemple: GOLD Mixed 2022\n");
                    System.out.print(">> Introdueix el tipus de medalla: ");
                    medalla = teclat.nextLine();
                    System.out.print(">> Introdueix el sexe: ");
                    genere =  teclat.nextLine();
                    System.out.print(">> Introdueix l’any: ");
                    anyJocs = Integer.parseInt(teclat.nextLine());
                    System.out.println(llista.consultaMedallaprimera(medalla, genere, anyJocs));
					break;
                case 4:
					System.out.print("Exemple: beijing 2022\n");
					System.out.print(">> Introdueix la ciutat: ");
					poblacioJocs = teclat.nextLine();
                    System.out.print(">> Introdueix l’any: ");
                    anyJocs = Integer.parseInt(teclat.nextLine());
                    System.out.println(llista.consultaMedallaPrimeraDona (poblacioJocs, anyJocs));
					break;
                case 5: 
					System.out.print("Exemple: SILVER\n");
					System.out.print(">> Introdueix el tipus de medalla: ");
                    medalla = teclat.nextLine();
                    System.out.println("País amb més medalles: " + llista.consultaPais(medalla));
					break;
                case 6: 
					System.out.print("Exemple: USA\n");
					System.out.print(">> Introdueix les inicials del país: ");
                    paisAtleta = teclat.nextLine();
					System.out.println("GOLD: "+llista.Medaller(paisAtleta)[0]);
					System.out.println("SILVER: "+llista.Medaller(paisAtleta)[1]);
					System.out.println("BRONZE: "+llista.Medaller(paisAtleta)[2]);
					break;
				case 7:
					System.out.print("Exemple: Men's Freeski Big Air 2022 beijing\n");
					System.out.print(">> Introdueix el tipus de prova: ");
					disciplina = teclat.nextLine();
					System.out.print(">> Introdueix l'any dels jocs: ");
					anyJocs = Integer.parseInt(teclat.nextLine());
					System.out.print(">> Introdueix la ciutat: ");
					poblacioJocs = teclat.nextLine();
					LlistaMedalles llista2 = llista.medallesAconseguides(disciplina, poblacioJocs, anyJocs);
					System.out.println(llista2.toString());
					break;
				case 8:
					System.out.print("Exemple: Men's Freeski Big Air 2022 beijing GOLD Men\n");
					System.out.print(">> Introdueix el tipus de prova: ");
					disciplina = teclat.nextLine();
					System.out.print(">> Introdueix l'any dels jocs: ");
					anyJocs = Integer.parseInt(teclat.nextLine());
					System.out.print(">> Introdueix la ciutat: ");
					poblacioJocs = teclat.nextLine();
					System.out.print(">> Introdueix el tipus de medalla: ");
                    medalla = teclat.nextLine();
                    System.out.print(">> Introdueix el sexe: ");
                    genere =  teclat.nextLine();
					LlistaMedalles llista3 = llista.medallesAconseguides(disciplina, poblacioJocs, anyJocs);
					System.out.println(llista3.consultaMedallaprimera(medalla, genere, anyJocs));

					break;
				case 9:
				System.out.print("Exemple: Men's Freeski Big Air 2022 beijing SILVER\n");
				System.out.print(">> Introdueix el tipus de prova: ");
				disciplina = teclat.nextLine();
				System.out.print(">> Introdueix l'any dels jocs: ");
				anyJocs = Integer.parseInt(teclat.nextLine());
				System.out.print(">> Introdueix la ciutat: ");
				poblacioJocs = teclat.nextLine();
				System.out.print(">> Introdueix el tipus de medalla: ");
				medalla = teclat.nextLine();
				LlistaMedalles llista4 = llista.medallesAconseguides(disciplina, poblacioJocs, anyJocs);
				System.out.println("País amb més medalles: " + llista4.consultaPais(medalla));

					break;
				case 10:
					System.out.print("Introdueix el tipus de prova: ");
					disciplina = teclat.nextLine();
					System.out.print("Introdueix la ciutat: ");
					poblacioJocs = teclat.nextLine();
					System.out.print("Introdueix l'any: ");
					anyJocs = Integer.parseInt(teclat.nextLine());
					System.out.println("Medalles abans: " + llista.toString());
					llista.esborraMedalles(poblacioJocs, anyJocs);
					System.out.println("Medalles després: " + (llista.toString()));
					break;
				case 11: 
					continuar = false;
					System.out.println("Sortint del programa...");
					break;
                default: System.out.println("Opció invàlida."); break;
            }
		}



	}

	private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
		String[] result;
		if (nLinies < 0)
			nLinies = 0;
		if (nLinies > 21694)
			nLinies = 21694;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("Practica2_pdp/olympic_medals_part_UTF8.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent\n" + capcalera);
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

}