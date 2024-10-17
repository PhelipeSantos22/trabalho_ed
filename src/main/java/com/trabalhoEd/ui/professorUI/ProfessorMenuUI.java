package main.java.com.trabalhoEd.ui.professorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorMenuUI extends JFrame {
    public ProfessorMenuUI() {
        setTitle("Menu Professores");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Botões
        JButton inserirButton = new JButton("Inserir Professor");
        inserirButton.setBounds(50, 30, 200, 30);
        add(inserirButton);

        JButton atualizarButton = new JButton("Atualizar Professor");
        atualizarButton.setBounds(50, 70, 200, 30);
        add(atualizarButton);

        JButton removerButton = new JButton("Remover Professor");
        removerButton.setBounds(50, 110, 200, 30);
        add(removerButton);

        JButton consultarButton = new JButton("Consultar Professor");
        consultarButton.setBounds(50, 150, 200, 30);
        add(consultarButton);


        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorInserirUI();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorAtualizarUI();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new ProfessorRemoverUI();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorConsultarUI();
            }
        });
        setVisible(true);
    }
}
