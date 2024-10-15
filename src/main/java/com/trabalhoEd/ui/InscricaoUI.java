package main.java.com.trabalhoEd.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InscricaoUI extends JFrame {
    public InscricaoUI() {
        setTitle("Gerenciamento de Inscrições");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Campos para entrada
        JTextField cpfField = new JTextField();
        JTextField codigoDisciplinaField = new JTextField();
        JTextField codigoProcessoField = new JTextField();

        // Botões
        JButton inserirButton = new JButton("Inserir");
        JButton consultarButton = new JButton("Consultar");

        // Adicionando componentes à tela
        add(new JLabel("CPF do Professor:"));
        add(cpfField);
        add(new JLabel("Código da Disciplina:"));
        add(codigoDisciplinaField);
        add(new JLabel("Código do Processo:"));
        add(codigoProcessoField);
        add(inserirButton);
        add(consultarButton);

        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de inserção
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de consulta
            }
        });
    }
}
