package farm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Bdatoa {
	public static void ps(String x) {
		System.out.print(x);
	}

	public static int LeerEntero() {
		String l�nea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			l�nea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int ne = 0;
		try {
			ne = Integer.parseInt(l�nea);
		} catch (Exception e) {
		}
		return (ne);
	}

	public static String LeerCadena() {
		String l�nea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			l�nea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		double ne = 0;
		return (l�nea);
	}
}