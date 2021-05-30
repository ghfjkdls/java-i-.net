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
        	
        	double[] wspWielomianu = new double[5];
        	
        	for (int i = 0; i < wspWielomianu.length; i++) {
        		System.out.println("podaj a"+(i+1));
                wspWielomianu[i]=input.nextDouble();
            }
        	DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            for (int i = 0; i < wspWielomianu.length; i++) {
                outToServer.writeDouble(wspWielomianu[i]);
            }

        	DataInputStream inFromServer = new DataInputStream(socket.getInputStream());
        	for(int i=0;i<array.length;i++) {
                array[i][0]=inFromServer.readDouble();
                array[i][1]=inFromServer.readDouble();
        	}
        	
        	for(int i=0; i<array.length; i++) {
                System.out.println(array[i][0]+" "+array[i][1]);
            }
        	

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
        
        input.close();
    }
}
