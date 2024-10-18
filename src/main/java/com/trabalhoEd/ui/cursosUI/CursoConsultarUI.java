package main.java.com.trabalhoEd.ui.cursosUI;

import main.java.com.trabalhoEd.model.Curso;
import main.java.com.trabalhoEd.service.CursoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CursoConsultarUI {
    private JFrame frame;
    private CursoService cursoService;

    public CursoConsultarUI() {
        cursoService = new CursoService(); // Inicializa o serviço de Curso
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Consultar Cursos");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Área de texto para exibir os resultados da consulta
        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false); // Impedir a edição do texto
        JScrollPane scrollPane = new JScrollPane(resultadoArea); // Adicionar barra de rolagem
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Botão de consulta
        JButton consultarButton = new JButton("Consultar Cursos");
        frame.getContentPane().add(consultarButton, BorderLayout.SOUTH);

        // ActionListener para o botão Consultar
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarCursos(resultadoArea);
            }
        });

        frame.setVisible(true);
    }

    private void consultarCursos(JTextArea resultadoArea) {
        List<Curso> cursos = cursoService.consultar();
        StringBuilder resultado = new StringBuilder();

        // Verifica se existem cursos e monta a string para exibição
        if (!cursos.isEmpty()) {
            for (Curso curso : cursos) {
                resultado.append("Código: ").append(curso.getCodigo()).append("\n")
                        .append("Nome: ").append(curso.getNome()).append("\n")
                        .append("Área de Conhecimento: ").append(curso.getAreaConhecimento()).append("\n")
                        .append("----------------------------------------------------\n");
            }
        } else {
            resultado.append("Nenhum curso encontrado.");
        }
        resultadoArea.setText(resultado.toString());
    }
}
