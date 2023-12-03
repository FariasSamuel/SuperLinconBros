package superlinconbro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cecil
 */
import javax.swing.*;

public class AskPlayer {
    private String playerName;

    public void askName() {
        JFrame frame = new JFrame();
        
        while (true) {
            String input = JOptionPane.showInputDialog(frame, "Bem-vindo(a) ao Super Lincon Bros World!! "
                    + "Qual é o seu nome?");
            if (input != null && !input.trim().isEmpty()) {
                this.playerName = input;
                JOptionPane.showMessageDialog(frame, "Prepara-se, " + playerName + "! O jogo já vai começar.");
                break;
            } 
            else {
                JOptionPane.showMessageDialog(frame, "Por favor, digite um nome válido para começar.");
            }
        }
        
        frame.dispose();
    }

    public String getPlayerName() {
        return playerName;
    }
}
