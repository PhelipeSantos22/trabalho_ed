package main.java.com.trabalhoEd.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame {

    public MainMenuUI() {
        // Configurações da janela principal
        setTitle("Menu Principal");
        setSize(300, 300); // Aumentei a altura para acomodar mais botões
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                // Abre a tela de disciplinas
                new DisciplinaUI();
            }
        });

        btnCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de cursos
                new CursoUI();
            }
        });

        btnProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de professores
                new ProfessorUI();
            }
        });

        btnInscricao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de consulta de inscrições
                new InscricaoUI();
            }
        });

        // Define a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Inicializa o menu principal
        new MainMenuUI();
    }
}
