package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "client" );
        Socket s;
        BufferedReader tastiera;
        String  send;
        DataOutputStream out;
        BufferedReader in;
        String status;

        try{

            s = new Socket("localhost",3000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new DataOutputStream(s.getOutputStream());

            System.out.println(in.readLine());
        
            tastiera = new BufferedReader(new InputStreamReader(System.in));

            do{
          
                System.out.println("inserisci carattere");
                send = tastiera.readLine();
                out.writeBytes(send+"\n");
                System.out.println("in attesa");
                status = in.readLine();
                System.out.println(status);

                
            }while(status != "1");
            System.out.println(status);
            System.out.println(in.readLine());

            s.close();

        }catch(Exception e){

                    System.out.println( "errore" + e.getMessage());

        }
        










    }
}
