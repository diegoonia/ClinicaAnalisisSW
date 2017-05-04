package farm;

import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		String op = "";
		int sw = 0, sw1 = 0;
		// variables de selección usadas en los diferentes menús
		int op1, op2, op3; 
		// variables usadas en el registro de datos
		String codpac, cp, nompac, codmed, cm, enfpac, nommed, espmed; 
		 // variables en la lectura de datos
		String codp = "", codpa = "", nomp = "", nompa = "", codm = "", codme = "", enfp = "", nomm = "", espm = "";
		// variables auxiliares temporales																									
		String codtem; 

		do {
			op1 = 0;
			for(int i=0; i<20; i++)
			{
				System.out.println(""); 
			}
			Bdatoa.ps("   .............................................." + "\n");
			Bdatoa.ps("   :-:        C E N T R O  M E D I C O        :-:" + "\n");
			Bdatoa.ps("   :-:   >>>> L O S  L A U R E L E S <<<<     :-:" + "\n");
			Bdatoa.ps("   :-:  C O N T R O L  D E  P A C I E N T E S :-:" + "\n");
			Bdatoa.ps("   :-:........................................:-:" + "\n");
			Bdatoa.ps("   :-: 1.  Ingreso de datos                   :-:" + "\n");
			Bdatoa.ps("   :-: 2.  Informes                           :-:" + "\n");
			Bdatoa.ps("   :-: 3.  Salir                              :-:" + "\n");
			Bdatoa.ps("   .............................................." + "\n");
			Bdatoa.ps("   ....Elija la opcion deseada: ");
			// ps("\n");
			op1 = Bdatoa.LeerEntero();
			if (op1 < 1 || op1 > 3) {
				Bdatoa.ps("Debe digitar una opcion del menu" + "\n");
			}

			if (op1 == 1) // seleción ingreso de pacientes
			{
				for(int i=0; i<20; i++)
				{
					System.out.println(""); 
				}
				IngresoDeDatos po = new IngresoDeDatos();
			} else {
				if (op1 == 2) // seleción informes
				{
					for(int i=0; i<20; i++)
					{
						System.out.println(""); 
					}
					Informes informes = new Informes();
				}
			}
		} while (op1 != 3);

	}
}

