package br.com.fileClient.model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteArquivo {
	
	private static int PORTA = 1984;

	public static void main(String[] args) {
		if(args.length != 2) {
	        System.out.println("Uso correto: <Nome da maquina> <Mensagem>");
	        System.exit(0);
	    } 
		
		try{
			  //Primeiro argumento é o nome do host destino
		      InetAddress addr = InetAddress.getByName(args[0]);
		      byte[] msg = args[1].getBytes();
		      
		      //Monta o pacote a ser enviado
		      DatagramPacket pkg = new DatagramPacket(msg,msg.length, addr, PORTA);
		      
		      // Cria o DatagramSocket que será responsável por enviar a mensagem
		      DatagramSocket ds = new DatagramSocket();
		      
		      //Envia a mensagem
		      ds.send(pkg);
		      System.out.println("Mensagem enviada para: " + addr.getHostAddress() + "\n" +
			      "Porta: " + PORTA + "\n" + "Mensagem: " + args[1]);

		      //Fecha o DatagramSocket
		      ds.close();     
		}
		
		catch(IOException ioe){
			ioe.printStackTrace();
		}

	}

}
