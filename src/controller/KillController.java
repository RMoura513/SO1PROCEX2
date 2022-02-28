package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.management.RuntimeOperationsException;

public class KillController {

	
	public KillController() {
	super();	
		
	}
	
	String os = os();
		
	private String os() {
	String os = System.getProperty("os.name");
	
	if (os.contains("Windows")) {
	System.out.println("O sistema operacional é Windows.");
	}
	else {
		System.out.println("O sistema operacional é Linux");
	}
	
    return os;
	}
	

	
	
	public void listaProcessos(String processo) {
		if (os.contains("Windows")) {
			processo = "TASKLIST /FO TABLE";
		}
		else {
			processo = "ps -ef";
		}
		try {
			Process n = Runtime.getRuntime().exec(processo);
			InputStream f = n.getInputStream();
			InputStreamReader l = new InputStreamReader(f);
			BufferedReader buffer = new BufferedReader(l);
			String li = buffer.readLine();
			while (li != null) {
				System.out.println(li);
				li = buffer.readLine();
			}
			buffer.close();
			l.close();
			f.close();
		}catch(IOException e) {
			e.printStackTrace();	
			
		}
	}
	
	public void mataPid (String param) {
		String cmdPID = "comando";
		if (os.contains("Windows")) {
		cmdPID = "TASKKILL /PID";
		if (!param.contains("TASKLIST /FO TABLE")) {
			System.out.println("Não há nenhum PID correspondente com o digitado.");
		}
		}
		else {
        cmdPID = "kill -9";
		if (!param.contains("ps -ef")) {
			System.out.println("Não há nenhum PID correspondente com o digitado.");
		}
		}
		
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		pid = Integer.parseInt(param);
		buffer.append(cmdPID);
		buffer.append(" ");
		buffer.append(pid);
		
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mataNome (String param) {
		
		String so = System.getProperty("os.name");
		String cmdNOME = "comando";
		if (so.contains("Windows")) {
			cmdNOME = "TASKKILL /IM";
			if (!param.contains("TASKLIST /FO TABLE")) {
				System.out.println("Não há nenhum processo correspondente com o digitado.");
			}
		}
		else { 
			cmdNOME = "pkill -f";
			if (!param.contains("ps -ef")) {
				System.out.println("Não há nenhum processo correspondente com o digitado.");
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		
			buffer.append(cmdNOME);
			buffer.append(" ");
			buffer.append(param);
			

		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
	


