import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] matrice = new String[3][3];
		int nr, nc;
		int counter = 0;
		int giocatore = 1;
		boolean vittoria=false;

		// inizializzazione matrice con spazi vuoti
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrice[i][j] = " ";

			}
		} // fine ciclo for

		do {
			System.out.println("Turno giocatore " + giocatore);
			System.out.print("inserire riga: ");
			nr = sc.nextInt();
			System.out.print("inserire colonna: ");
			nc = sc.nextInt();
			while (nr < 0 || nc < 0 || nr >= 3 || nc >= 3) {
				System.out.println("posizione non valida");
				System.out.print("inserire riga: ");
				nr = sc.nextInt();
				System.out.print("inserire colonna: ");
				nc = sc.nextInt();
			}

			if (matrice[nr][nc] != " ")
				System.out.println("posizione occupata");
			else {
				if (giocatore == 1) {
					matrice[nr][nc] = "X";
					giocatore = 2;
					counter++;
				} else {
					matrice[nr][nc] = "0";
					giocatore = 1;
					counter++;

				}
			}

			for (int i = 0; i < 3; i++) {// stampa griglia
				for (int j = 0; j < 3; j++) {
					System.out.print(matrice[i][j]);
				}
				System.out.println();
			}

			if        ((matrice[nr][0] == "X" && matrice[nr][1] == "X" && matrice[nr][2] == "X") // cnd vittoria x
					|| (matrice[0][nc] == "X" && matrice[1][nc] == "X" && matrice[2][nc] == "X")
					|| (matrice[0][0] == "X" && matrice[1][1] == "X" && matrice[2][2] == "X")
					|| (matrice[0][2] == "X" && matrice[1][1] == "X" && matrice[2][0] == "X")) {
				System.out.println("giocatore 1 vince");
				vittoria=true;
				break;
			} else if ((matrice[nr][0] == "0" && matrice[nr][1] == "0" && matrice[nr][2] == "0") // cnd vittoria 0
					|| (matrice[0][nc] == "0" && matrice[1][nc] == "0" && matrice[2][nc] == "0")
					|| (matrice[0][0] == "0" && matrice[1][1] == "0" && matrice[2][2] == "0")
					|| (matrice[0][2] == "0" && matrice[1][1] == "0" && matrice[2][0] == "0")) {
				System.out.println("giocatore 2 vince");
				vittoria=true;
				break;
			}

		} while (counter < 9);
		if(vittoria==false)
			System.out.println("pareggio");
		System.out.println("partita finita");

	}// fine metodo
}// fine classe