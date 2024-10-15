package main.java.com.trabalhoEd.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursoUI extends JFrame {
    public CursoUI() {
        setTitle("Gerenciamento de Cursos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos para entrada
        JTextField codigoField = new JTextField();
        JTextField nomeField = new JTextField();
        JTextField areaField = new JTextField();

        // Botões
        JButton inserirButton = new JButton("Inserir");
        JButton atualizarButton = new JButton("Atualizar");
        JButton removerButton = new JButton("Remover");
        JButton consultarButton = new JButton("Consultar");

        // Adicionando componentes à tela
        add(new JLabel("Código:"));
        add(codigoField);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Área:"));
        add(areaField);
        add(inserirButton);
        add(atualizarButton);
        add(removerButton);
        add(consultarButton);

        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de inserção
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de atualização
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementar a lógica de remoção
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
