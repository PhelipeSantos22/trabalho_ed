package main.java.com.trabalhoEd.ui.cursosUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursoMenuUI extends JFrame {
    public CursoMenuUI() {
        setTitle("Menu Cursos");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton inserirButton = new JButton("Inserir Curso");
        inserirButton.setBounds(50, 30, 200, 30);
        add(inserirButton);

        JButton consultarButton = new JButton("Consultar Curso");
        consultarButton.setBounds(50, 70, 200, 30);
        add(consultarButton);

        JButton atualizarButton = new JButton("Atualizar Curso");
        atualizarButton.setBounds(50, 110, 200, 30);
        add(atualizarButton);

        JButton removerButton = new JButton("Remover Curso");
        removerButton.setBounds(50, 150, 200, 30);
        add(removerButton);

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CursoInserirUI();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CursoAtualizarUI();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CursoRemoverUI();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CursoConsultarUI();
            }
        });
        setVisible(true);
    }
}
