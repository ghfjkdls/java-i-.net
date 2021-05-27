package projekt;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client {
	
	public static double[][] array = new double[8][2]; 
	//public static Object array = null;

    public static void main(String[] args) {

        String hostname = "localhost";
        int port = 6666;
        
        Scanner input = new Scanner(System.in);

        try (Socket socket = new Socket(hostname, port)) {
        	
        	String str = input.next();//wysylanie stringa na serwer
        	OutputStream output = socket.getOutputStream();
        	PrintWriter writer = new PrintWriter(output, true);
        	writer.println(str);

        	/*
        	
        	 ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
             try {
                 Object object = objectInput.readObject();
                 array =   object;
                 System.out.println(array);
             } catch (ClassNotFoundException e) {             
                 e.printStackTrace();
             }
        	
        	*/
        	DataInputStream inFromServer = new DataInputStream(socket.getInputStream());
        	for(int i=0;i<array.length;i++) {
                array[i][0]=inFromServer.readDouble();
                array[i][1]=inFromServer.readDouble();
        	}
        	
        	for(int i=0; i<array.length; i++) {
                System.out.println(array[i][0]+" "+array[i][1]);
            }
        	
        	
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
