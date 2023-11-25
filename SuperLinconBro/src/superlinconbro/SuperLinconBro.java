/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package superlinconbro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Samuel
 */


public class SuperLinconBro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        JFrame janela = new  JFrame("SuperLinconBros");
        janela.setSize(600, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameLoop game = new GameLoop(600);
        janela.add(game);
        ArrayList<Integer> input = new ArrayList();     
        janela.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                int keycode = e.getExtendedKeyCode();
                if(!input.contains(keycode))
                    input.add(keycode);
            }
            public void keyReleased(KeyEvent e) {
                int keycode = e.getExtendedKeyCode();
                int ind = input.indexOf(keycode);
                input.remove (ind);
            }
        });
        //System.out.print("oi");
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gamelLogic(input);
                game.repaint();
                input.forEach((x)->System.out.print(x));
                
            }
        });
        timer.start();
        janela.setVisible(true);
    }
    
}
