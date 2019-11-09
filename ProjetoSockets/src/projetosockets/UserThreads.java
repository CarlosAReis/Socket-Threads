/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetosockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *pro15969@cefsa
 * @author CarlosAugusto
 */
class UserThreads  extends Thread {
  //String text;
  //Thread t;
  //UserThreads (String thread) {
  //text = thread;
 // t = new Thread(this, text);
  //System.out.println("New thread: " + t);
  //t.start();
   //final DataInputStream dis;
  // final DataOutputStream dos;
   final Socket s;
    DataInputStream dis;
         DataOutputStream dos;
  public UserThreads (Socket s) throws IOException{
        this.dos = new DataOutputStream(s.getOutputStream());
        this.dis = new DataInputStream(s.getInputStream());
  
      this.s= s;
      
        
  
  }
 public void run(){
     
     while(true){
      try {
                     
          
      dos.writeUTF("What do you want to write?..\n"+ 
                            "Type Exit to terminate connection.");
      
      String received;
      
      received = dis.readUTF();
      System.out.println(received);
      if(received.equals("Exit")) 
                {  
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                   break;
                } else{
      
      
                    System.out.println(received);
      
                }
      
      
  /* for (int i = 5; i > 0; i--) {
    System.out.println( ": " + i);
   Thread.sleep(1000);
   }*/
  } /*catch (InterruptedException e) {
//   System.out.println(text + "Interrupted");
      System.out.println("END");
  }*/    catch (IOException ex) {
           Logger.getLogger(UserThreads.class.getName()).log(Level.SEVERE, null, ex);
           break;
       }
       
     }
      System.out.println("EXITING");
      
 }
}
