package main.java.com.trabalhoEd.ui;

import main.java.com.trabalhoEd.ui.disciplinaUI.DisciplinaMenuUI;
import main.java.com.trabalhoEd.ui.cursosUI.CursoMenuUI;
import main.java.com.trabalhoEd.ui.inscricaoUI.InscricaoMenuUI;
import main.java.com.trabalhoEd.ui.professorUI.ProfessorMenuUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame {

    public MainMenuUI() {
        // Configurações da janela principal
        setTitle("Menu Principal");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Botões
        JButton btnDisciplina = new JButton("Gerenciar Disciplinas");
        btnDisciplina.setBounds(50, 30, 200, 30);
        add(btnDisciplina);

        JButton btnCurso = new JButton("Gerenciar Cursos");
        btnCurso.setBounds(50, 70, 200, 30);
        add(btnCurso);

        JButton btnProfessor = new JButton("Gerenciar Professores");
        btnProfessor.setBounds(50, 110, 200, 30);
        add(btnProfessor);

        JButton btnInscricao = new JButton("Gerenciar Inscrições");
        btnInscricao.setBounds(50, 150, 200, 30);
        add(btnInscricao);

        // Ação dos botões
        btnDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisciplinaMenuUI();
            }
        });

        btnCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CursoMenuUI();
            }
        });

        btnProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProfessorMenuUI();
            }
        });

        btnInscricao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InscricaoMenuUI();
            }
        });
        // Define a janela visível
        setVisible(true);
    }
}
