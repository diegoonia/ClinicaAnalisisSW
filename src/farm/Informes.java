package farm;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Informes {

	public Informes() throws IOException
	{
		String codpac, nompac, op, codp, codm, enfpac, codmed = null, nommed = null, espmed, codtem;
		int op2, sw, sw1;
		//Informes inf = new Informes();

		do {
			Bdatoa.ps("   ..............................................." + "\n");
			Bdatoa.ps("   :-:  C O N T R O L  D E  P A C I E N T E S  :-:" + "\n");
			Bdatoa.ps("   ..............................................." + "\n");
			Bdatoa.ps("   :-:           - I N F O R M E S -           :-:" + "\n");
			Bdatoa.ps("   :-:.........................................:-:" + "\n");
			Bdatoa.ps("   :-: 1. Listado de pacientes por medico      :-:" + "\n");
			Bdatoa.ps("   :-: 2. Enfermedades que atiende cada medico :-:" + "\n");
			Bdatoa.ps("   :-: 3. Anterior                             :-:" + "\n");
			Bdatoa.ps("   ..............................................." + "\n");
			Bdatoa.ps("   ....Elija la opcion deseada: ");
			op2 = Bdatoa.LeerEntero();
			if (op2 < 1 || op2 > 3) {
				Bdatoa.ps("Seleccione una de las opciones del menu" + "\n");
			}

			switch (op2) {
			case 1:
				try {

					Bdatoa.ps("Digite el codigo del medico que desea consultar: ");
					codtem = Bdatoa.LeerCadena();

					DataInputStream datomed = null;
					datomed = new DataInputStream(new FileInputStream("datomed.txt"));

					sw = 1;
					while (sw != 0) {
						try {
							codmed = datomed.readUTF();
							nommed = datomed.readUTF();
							espmed = datomed.readUTF();

						} catch (EOFException e) {
							sw = 0;
						}

						if (codmed.equals(codtem)) // compara el codigo extraido de la tabla "datomed" con el codigo digitado
						{
							Bdatoa.ps("::: El medico " + nommed + " atiende a los siguientes pacientes: " + "\n");
							DataInputStream situpac = null;
							situpac = new DataInputStream(new FileInputStream("situpac.txt"));

							sw = 1;
							while (sw != 0) {
								try {
									codp = situpac.readUTF();
									codmed = situpac.readUTF();
									enfpac = situpac.readUTF();

									if (codmed.equals(codtem)) // compara el codigo medico de la tabla "datomed" con le de la tabla "situpac"
									{
										DataInputStream datopac = null;
										datopac = new DataInputStream(
												new FileInputStream("datopac.txt"));

										sw1 = 1;
										while (sw1 != 0) {
											try {
												codpac = datopac.readUTF();
												nompac = datopac.readUTF();

												if (codpac.equals(codp)) // compara el codigo del paciente de la tabla "situpac" con le codigo del paciente de la tabla "datopac"
												{
													Bdatoa.ps("::: Paciente: " + nompac + "\n");
												}
											} catch (EOFException e) {
												sw1 = 0;
											}
										}
									}
								} catch (EOFException e) {
									sw = 0;
								}
							}
						}
					}

				} catch (IOException ioe) {
				}
				;
				break;

			case 2:

				Bdatoa.ps("Digite el codigo del medico que desea consultar: ");
				codtem = Bdatoa.LeerCadena();

				DataInputStream datomed = null;
				datomed = new DataInputStream(new FileInputStream("datomed.txt"));

				sw1 = 1;
				while (sw1 != 0) {
					try {
						codm = datomed.readUTF();
						nommed = datomed.readUTF();
						espmed = datomed.readUTF();

						if (codm.equals(codtem)) // compara el codigo digitado con le codigo del medico de la tabla "datomed"
						{
							Bdatoa.ps("El medico " + nommed + " trata las siguientes enfermedades:" + "\n");

							DataInputStream situpac = null;
							situpac = new DataInputStream(new FileInputStream("situpac.txt"));

							sw = 1;
							while (sw != 0) {
								try {
									codp = situpac.readUTF();
									codmed = situpac.readUTF();
									enfpac = situpac.readUTF();

									if (codtem.equals(codmed)) // compara el codigo del medico de la tabla "datomed" con el codigo del medico en la tabla "situpac"
									{
										Bdatoa.ps(">>>> " + enfpac + "\n");
									}
								} catch (EOFException e) {
									sw = 0;
								}
							}
						}
					} catch (EOFException e) {
						sw1 = 0;
					}
				}
				break;
			}

		} while (op2 != 3);


	}
	
}
