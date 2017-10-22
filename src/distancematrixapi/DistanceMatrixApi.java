package distancematrixapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class DistanceMatrixApi {
	private static Scanner reader = new Scanner(System.in);

	public static String set(String title) {
		String origins;

		System.out.println("Enter the " + title + " adresses");
		System.out.print("put (|) between adresses and (+ or nothing) between components of adresses: ");
		origins = reader.nextLine();

		return origins;
	}

	public static void main(String[] args) {
		String origins = set("origins");
		String destinations = set("destinations");

		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origins
					+ "&destinations=" + destinations);

			/*
			 * url.openConnection() opens the connection to the resource
			 * referenced by the url and returns an object of URLConnection
			 */

			/*
			 * URLConnection.getInputStream() returns an input stream that reads
			 * from this open connection made before
			 */

			/**
			 * To directly open connection to a resource referenced by a url and
			 * get the input stream for reading from this resource, we can use
			 * url.openStream() instead of using tow methodes as under here /
			 * 
			 * /* BufferedReader constructor must get an InputStreamReader
			 * object as argument
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
