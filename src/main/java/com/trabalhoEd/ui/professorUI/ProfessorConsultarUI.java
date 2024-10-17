package main.java.com.trabalhoEd.ui.professorUI;

import main.java.com.trabalhoEd.model.Professor;
import main.java.com.trabalhoEd.service.ProfessorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProfessorConsultarUI {
    private JFrame frame;
    private ProfessorService professorService;

    public ProfessorConsultarUI() {
        professorService = new ProfessorService(); // Inicializa o serviço de Professor
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Consultar Professores");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Área de texto para exibir os resultados da consulta
        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false); // Impede a edição do texto
        JScrollPane scrollPane = new JScrollPane(resultadoArea); // Adiciona barra de rolagem
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Botão de consulta
        JButton consultarButton = new JButton("Consultar Professores");
        frame.getContentPane().add(consultarButton, BorderLayout.SOUTH);

        // ActionListener para o botão Consultar
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarProfessores(resultadoArea);
            }
        });

        frame.setVisible(true);
    }

    private void consultarProfessores(JTextArea resultadoArea) {
        List<Professor> professores = professorService.consultar();
        StringBuilder resultado = new StringBuilder();

        // Verifica se existem professores e monta a string para exibição
        if (!professores.isEmpty()) {
            for (Professor professor : professores) {
                resultado.append("CPF: ").append(professor.getCpf()).append("\n")
                        .append("Nome: ").append(professor.getNome()).append("\n")
                        .append("Área: ").append(professor.getArea()).append("\n")
                        .append("Pontos: ").append(professor.getPontos()).append("\n")
                        .append("----------------------------------------------------\n");
            }
        } else {
            resultado.append("Nenhum professor encontrado.");
        }

        // Atualiza o JTextArea com o resultado
        resultadoArea.setText(resultado.toString());
    }
}
