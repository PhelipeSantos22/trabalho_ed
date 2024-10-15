package main.java.com.trabalhoEd.ui;

import main.java.com.trabalhoEd.ui.CursoUI;
import main.java.com.trabalhoEd.ui.DisciplinaUI;
import main.java.com.trabalhoEd.ui.InscricaoUI;
import main.java.com.trabalhoEd.ui.ProfessorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame {
    public MainMenuUI() {
        setTitle("Menu Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Botões do menu
        JButton disciplinaButton = new JButton("Gerenciar Disciplinas");
        JButton cursoButton = new JButton("Gerenciar Cursos");
        JButton professorButton = new JButton("Gerenciar Professores");
        JButton inscricaoButton = new JButton("Gerenciar Inscrições");

        disciplinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisciplinaUI().setVisible(true);
            }
        });

        cursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CursoUI().setVisible(true);
            }
        });

        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorUI().setVisible(true);
            }
        });

        inscricaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InscricaoUI().setVisible(true);
            }
        });

        JPanel panel = new JPanel();
        panel.add(disciplinaButton);
        panel.add(cursoButton);
        panel.add(professorButton);
        panel.add(inscricaoButton);

        add(panel);
    }
}
