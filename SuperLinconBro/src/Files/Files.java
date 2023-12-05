/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import superlinconbro.AskPlayer;

/**
 *
 * @author Antonio
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public void writeFiles (String nomeArquivo, String informacao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(informacao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Método para escrever o nome do jogador no arquivo
    public void writePlayerName(String nomeArquivo, String nomeJogador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Nome do jogador: " + nomeJogador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/*
public class Files {
    public static void main(String[] args) {
        
        AskPlayer askPlayer = new AskPlayer();
        
        
        String name = askPlayer.getPlayerName();
        
        String filePath = "player_results.txt";

        savePlayerResult(name, filePath);
    }

    public static void savePlayerResult(String playerName,  String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            
            writer.write("Jogador: " + playerName);
           
            System.out.println("Resultado salvo com sucesso no arquivo: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o resultado: " + e.getMessage());
        }
    }
}
*/