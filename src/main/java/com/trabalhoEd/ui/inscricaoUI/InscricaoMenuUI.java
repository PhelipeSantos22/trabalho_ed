package main.java.com.trabalhoEd.ui.inscricaoUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InscricaoMenuUI extends JFrame {
    public InscricaoMenuUI() {
        setTitle("Menu Inscrição");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton inserirButton = new JButton("Inserir Inscrição");
        inserirButton.setBounds(50, 30, 200, 30);
        add(inserirButton);

        JButton consultarButton = new JButton("Consultar Inscrição");
        consultarButton.setBounds(50, 70, 200, 30);
        add(consultarButton);

        JButton atualizarButton = new JButton("Atualizar Inscrição");
        atualizarButton.setBounds(50, 110, 200, 30);
        add(atualizarButton);

        JButton removerButton = new JButton("Remover incrição");
        removerButton.setBounds(50, 150, 200, 30);
        add(removerButton);

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InscricaoInserirUI();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InscricaoAtualizarUI();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InscricaoRemoverUI();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InscricaoConsultarUI();
            }
        });
        setVisible(true);
    }
}
