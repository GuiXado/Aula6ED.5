package controller;

import br.gui.filagenerica.*;
import model.Cliente;
import javax.swing.JOptionPane;

public class FilaController {

	private int contadorPrioritarios = 0;

	public void inserir(Fila<Cliente> fila, Cliente cliente) {
		fila.insert(cliente);
		JOptionPane.showMessageDialog(null,
				"Senha " + cliente.getNumero() + " de " + cliente.getNome() + " inserida com sucesso!");
	}

	public void remover(Fila<Cliente> fila) {
		if (fila.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Fila vazia! Nenhuma senha para remover.");
		} else {
			Cliente cliente = null;
			try {
				cliente = fila.remove();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			JOptionPane.showMessageDialog(null,
					"Atendendo: " + cliente.getNome() + " (senha " + cliente.getNumero() + ")");
		}
	}

	public void chamado(Fila<Cliente> filaPrioritarios, Fila<Cliente> fila) {
		Cliente cliente = null;

		if (contadorPrioritarios < 3 && !filaPrioritarios.isEmpty()) {
			try {
				cliente = filaPrioritarios.remove();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			contadorPrioritarios++;
			JOptionPane.showMessageDialog(null,
					"Atendendo prioridade: " + cliente.getNome() + " (senha " + cliente.getNumero() + ")");
		} else if (!fila.isEmpty()) { // chama um da fila normal
			try {
				cliente = fila.remove();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			JOptionPane.showMessageDialog(null,
					"Atendendo normal: " + cliente.getNome() + " (senha " + cliente.getNumero() + ")");
			contadorPrioritarios = 0; // reseta o contador de prioritários
		} else if (!filaPrioritarios.isEmpty()) { // se não tiver normal, chama prioritário
			try {
				cliente = filaPrioritarios.remove();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			JOptionPane.showMessageDialog(null,
					"Atendendo prioridade: " + cliente.getNome() + " (senha " + cliente.getNumero() + ")");
			contadorPrioritarios++; // continua contando
		} else {
			remover(fila);
			//JOptionPane.showMessageDialog(null, "Não há pessoas para chamar.");
		}
	}
}
