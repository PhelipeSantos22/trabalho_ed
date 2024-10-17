package main.java.com.trabalhoEd.ui.inscricaoUI;

import main.java.com.trabalhoEd.model.Inscricao;
import main.java.com.trabalhoEd.service.InscricaoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InscricaoConsultarUI {
    private JFrame frame;
    private InscricaoService inscricaoService;

    public InscricaoConsultarUI() {
        inscricaoService = new InscricaoService(); // Inicializa o serviço de Inscrição
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Consultar Inscrições");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Área de texto para exibir os resultados da consulta
        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false); // Impede a edição do texto
        JScrollPane scrollPane = new JScrollPane(resultadoArea); // Adiciona barra de rolagem
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Botão de consulta
        JButton consultarButton = new JButton("Consultar Inscrições");
        frame.getContentPane().add(consultarButton, BorderLayout.SOUTH);

        // ActionListener para o botão Consultar
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarInscricoes(resultadoArea);
            }
        });

        frame.setVisible(true);
    }

    private void consultarInscricoes(JTextArea resultadoArea) {
        List<Inscricao> inscricoes = inscricaoService.consultar();
        StringBuilder resultado = new StringBuilder();

        // Verifica se existem inscrições e monta a string para exibição
        if (!inscricoes.isEmpty()) {
            for (Inscricao inscricao : inscricoes) {
                resultado.append("CPF: ").append(inscricao.getCpf()).append("\n")
                        .append("Código da Disciplina: ").append(inscricao.getCodigoDisciplina()).append("\n")
                        .append("Código do Processo: ").append(inscricao.getCodigoProcesso()).append("\n")
                        .append("----------------------------------------------------\n");
            }
        } else {
            resultado.append("Nenhuma inscrição encontrada.");
        }

        // Atualiza o JTextArea com o resultado
        resultadoArea.setText(resultado.toString());
    }
}
