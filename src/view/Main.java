package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main {
	
	public static void main(String[] args) {
		
		KillController killController = new KillController();
		
		String processo = "comando";
        killController.listaProcessos(processo);
		
		
	
    int opckill = Integer.parseInt(JOptionPane.showInputDialog("Digite '1' para finalizar um processo por nome."
		+ "\nDigite '2' para finalizar um processo por PID. \nDigite '0' para finalizar o programa."));	

    while (opckill != 0) {
    
    	if (opckill == 1) {
    	String param = JOptionPane.showInputDialog("Digite o nome do processo a ser finalizado.");
    	killController.mataNome(param);
    }
    if (opckill == 2) {
    	String param = JOptionPane.showInputDialog("Digite o PID do processo a ser finalizado.");
    	killController.mataPid(param);
    }
 
    
    opckill = Integer.parseInt(JOptionPane.showInputDialog("Digite '1' para finalizar um processo por nome."
    		+ "\nDigite '2' para finalizar um processo por PID. \nDigite '0' para finalizar o programa."));	
    
    if (opckill == 0) {
    	System.out.println("Programa finalizado.");
    
	}
	
	
	
	}
}
}
