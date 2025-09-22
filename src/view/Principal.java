package view;

import controller.FilaController;
import model.Cliente;
import br.gui.filagenerica.Fila;
import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		Fila<Cliente> fila = new Fila<>();
		Fila<Cliente> filaPrioritarios = new Fila<>();
		FilaController controller = new FilaController();
		
		int proxSenha = 1; 
        int proxSenhaPrioritaria = 100;

        int opcao = 0;

        String menu = "1. Inserir nova senha na fila normal\n" +
        		"2. Inserir nova senha na fila prioritária\n" +
        		"3. Chamar próxima pessoa\n" +
        		"4. Sair";
        
        do {
            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) break;
            try {
                opcao = Integer.parseInt(entrada);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    String nomeNormal = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    if (nomeNormal != null && !nomeNormal.isEmpty()) {
                        controller.inserir(fila, new Cliente(proxSenha++, nomeNormal));
                    }
                    break;
                case 2:
                    String nomePrior = JOptionPane.showInputDialog("Digite o nome do cliente prioritário:");
                    if (nomePrior != null && !nomePrior.isEmpty()) {
                        controller.inserir(filaPrioritarios, new Cliente(proxSenhaPrioritaria++, nomePrior));
                    }
                    break;
                case 3:
                    controller.chamado(filaPrioritarios, fila);
                    break;
                case 4:
                    //JOptionPane.showMessageDialog(null, "Encerrando sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 4);
	}
}
