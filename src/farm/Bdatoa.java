package farm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Bdatoa {
	public static void ps(String x) {
		System.out.print(x);
	}

	public static int LeerEntero() {
		String línea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			línea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int ne = 0;
		try {
			ne = Integer.parseInt(línea);
		} catch (Exception e) {
		}
		return (ne);
	}

	public static String LeerCadena() {
		String línea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			línea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		double ne = 0;
		return (línea);
	}
}