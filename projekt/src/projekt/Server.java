package projekt;

import java.io.*;
import java.net.*;



public class Server{
	
	public static double wynik=0;

    public static void main(String[] args) {

        int port = 6666;
        double[][] array = new double[8][2]; 
        

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");//polaczenie z klientem
                
                InputStream input = socket.getInputStream();//odbieranie wiamosci od klienta
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String get = reader.readLine();
                System.out.println(get);
                
               
                
                Compute comp = new Compute(2, 1, -6); //obliczenia
                array = comp.resolve();
                for(int i=0; i<array.length; i++) {
                    System.out.println(array[i][0]+" "+array[i][1]);
                }
                
                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                for (int i = 0; i < array.length; i++) {
                    outToClient.writeDouble(array[i][0]);//+" "+array[i][1]);
                    outToClient.writeDouble(array[i][1]);
                }
                
                /*
                try {
                	Obiect obj = array;
                	ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
                    objectOutput.writeObject(obj);
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
                //*/
                OutputStream output = socket.getOutputStream();//wysylanie informacji zwrotnej
                PrintWriter writer = new PrintWriter(output, true);
                String str = Double.toString(wynik);
                writer.println(str);
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    

}

