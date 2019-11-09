/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetosockets;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author CarlosAugusto
 */
public class ProjetoSockets {

    /**
     * @param args the command line arguments
     */
    
    ////SERVIDOR!!!!!!!!!!!!!!!!1111
    
  
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");
       // Scanner scan = new Scanner(System.in);
        //  boolean out = false;
     //System.out.println(servidor.getLocalSocketAddress());
       
        //Socket cliente = servidor.accept();
        //System.out.println("Nova conexão com o cliente ");
       
        //ObjectInputStream objinstrm = new ObjectInputStream(cliente.getInputStream());
       // Scanner scanner = new Scanner(cliente.getInputStream());
        //String message = cliente.getInputStream().toString();
        // System.out.println(message);
       // String novaentrada="";
while (true) {
   // scanner = new Scanner(cliente.());
   try  {
                Socket cliente = servidor.accept();
                try  {        
                   // boolean ativo = true;
                     System.out.println("A new client is connected : " + cliente);
                     
                     System.out.println("Assigning new thread for this client"); 
                     
                     Thread t = new UserThreads(cliente);
                     
                     t.start();
                   
                   /* while (ativo)
                    {
                        if (stream.available() != 0)
                        {
                            byte[] dados = new byte[stream.available()];
                            stream.read(dados);
                            String dadosLidos = new String(dados);
                            if (dadosLidos.equals("sair"))
                                ativo = false;
                            else
                                System.out.println("Message Received: " + new String(dados));
                            
                            
                            
                           
                             }
                         }*/
                        Thread.sleep(10);
                       
                       
                         }catch (Exception e){
                         
                          System.out.println(e.getMessage());
                          break;
                         }
                   
                    
                   
                    
                }
   
   catch(Exception e){
       
                     System.out.println(e.getMessage());
                     break;
                     
                }
               
            }
   

        
        // TODO code application logic here
        //System.out.println("Saiu do while Server");
        
       //scanner.close();
        //cliente.close();
        //servidor.close();
        
    }
    
}
