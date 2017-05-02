package farm;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IngresoDeDatos {
	
	public IngresoDeDatos() throws IOException
	{
		String codpac, nompac, op, codp, codm, enfpac, codmed, nommed, espmed;
		int op2;
		do {
			Bdatoa.ps("   ..............................................." + "\n");
			Bdatoa.ps("   :-: -I N G R E S O  D E  P A C I E N T E S- :-:" + "\n");
			Bdatoa.ps("   :-:.........................................:-:" + "\n");
			Bdatoa.ps("   :-: 1.  Datos del paciente                  :-:" + "\n");
			Bdatoa.ps("   :-: 2.  Situacion del paciente              :-:" + "\n");
			Bdatoa.ps("   :-: 3.  Datos del medico                    :-:" + "\n");
			Bdatoa.ps("   :-: 4.  Anterior                            :-:" + "\n");
			Bdatoa.ps("   ..............................................." + "\n");
			Bdatoa.ps("   ....Elija la opcion deseada: ");

			op2 = Bdatoa.LeerEntero();

			if (op2 < 1 || op2 > 4) {
				Bdatoa.ps("Debe digitar una opcion del menu" + "\n");
			}

			switch (op2) {
			case 1: // ingreso de datos, datos del paciente
				DataOutputStream datopac = null;
				datopac = new DataOutputStream(new FileOutputStream("C:\\datopac.txt"));
				try {
					do {
						Bdatoa.ps("   ..............................................." + "\n");
						Bdatoa.ps("   :-:  - D A T O S  D E L  P A C I E N T E -  :-:" + "\n");
						Bdatoa.ps("   :-:.........................................:-:" + "\n");

						Bdatoa.ps("Digite el codigo del paciente: ");
						codpac = Bdatoa.LeerCadena();
						datopac.writeUTF(codpac);
						Bdatoa.ps("Digite el nombre del paciente: ");
						nompac = Bdatoa.LeerCadena();

						datopac.writeUTF(nompac);

						Bdatoa.ps("Desea ingresar otro paciente? S/N" + "\n");

						op = Bdatoa.LeerCadena();

					} while (op.equals("S") || op.equals("s"));
					
				} catch (IOException ioe) {
				}
				;

				break;
			// ingreso de datos, situacion del paciente
			case 2:
				DataOutputStream situpac = null;
				situpac = new DataOutputStream(new FileOutputStream("C:\\situpac.txt"));

				try {
					do {

						Bdatoa.ps("   ....................................................." + "\n");
						Bdatoa.ps("   :-: - S I T U A C I O N  D E L  P A C I E N T E - :-:" + "\n");
						Bdatoa.ps("   :-:...............................................:-:" + "\n");

						Bdatoa.ps("Digite el codigo del paciente: ");
						codp = Bdatoa.LeerCadena();
						situpac.writeUTF(codp);
						Bdatoa.ps("Digite el codigo del medico: ");
						codm = Bdatoa.LeerCadena();
						situpac.writeUTF(codm);
						Bdatoa.ps("Digite el diagnostico del medico: ");
						enfpac = Bdatoa.LeerCadena();
						situpac.writeUTF(enfpac);

						Bdatoa.ps("Desea ingresar otro registro al historial? S/N");
						Bdatoa.ps("\n");
						op = Bdatoa.LeerCadena();

					} while (op.equals("S") || op.equals("s"));
					situpac.close();
				} catch (IOException ioe) {
				}
				;
				break;

			case 3:
				DataOutputStream datomed = null;
				datomed = new DataOutputStream(new FileOutputStream("C:\\datomed.txt"));
				try {
					do {

						Bdatoa.ps("   ....................................................." + "\n");
						Bdatoa.ps("   :-:      - D A T O S   D E L   M E D I C O -      :-:" + "\n");
						Bdatoa.ps("   :-:...............................................:-:" + "\n");

						Bdatoa.ps("Digite el codigo del medico: ");
						codmed = Bdatoa.LeerCadena();
						datomed.writeUTF(codmed);

						Bdatoa.ps("Digite el nombre del medico: ");
						nommed = Bdatoa.LeerCadena();
						datomed.writeUTF(nommed);

						Bdatoa.ps("Digite la especializacion del medico: ");
						espmed = Bdatoa.LeerCadena();
						datomed.writeUTF(espmed);

						Bdatoa.ps("Desea ingresar otro medico? S/N");
						Bdatoa.ps("\n");

						op = Bdatoa.LeerCadena();

					} while (op.equals("S") || op.equals("s"));
				} catch (IOException ioe) {
				}
				;
				datomed.close();
			}
		} while (op2 != 4);
	}
}
