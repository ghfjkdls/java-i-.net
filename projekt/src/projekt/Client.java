package projekt;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {

        String hostname = "localhost";
        int port = 6666;
        
        Scanner input = new Scanner(System.in);

        try (Socket socket = new Socket(hostname, port)) {
        	
        	String str = input.next();//wysylanie stringa na serwer
        	OutputStream output = socket.getOutputStream();
        	PrintWriter writer = new PrintWriter(output, true);
        	writer.println(str);

            InputStream inputStream = socket.getInputStream();//odebranie danych z serwera
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String response = reader.readLine();

            System.out.println(response);


        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
        
        input.close();
    }
}
