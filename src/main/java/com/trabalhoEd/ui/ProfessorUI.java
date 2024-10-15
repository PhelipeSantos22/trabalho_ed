package main.java.com.trabalhoEd.ui;

import main.java.com.trabalhoEd.model.Professor;
import main.java.com.trabalhoEd.service.ProfessorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorUI extends JFrame {
    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField areaField;
    private JTextField pontosField;
    private ProfessorService professorService;

    public ProfessorUI() {
        // Inicializa o serviço de professor
        professorService = new ProfessorService();

        setTitle("Gerenciamento de Professores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        // Campos para entrada
        cpfField = new JTextField();
        nomeField = new JTextField();
        areaField = new JTextField();
        pontosField = new JTextField();

        // Botões
        JButton inserirButton = new JButton("Inserir");
        JButton atualizarButton = new JButton("Atualizar");
        JButton removerButton = new JButton("Remover");
        JButton consultarButton = new JButton("Consultar");

        // Adicionando componentes à tela
        add(new JLabel("CPF:"));
        add(cpfField);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Área:"));
        add(areaField);
        add(new JLabel("Pontos:"));
        add(pontosField);
        add(inserirButton);
        add(atualizarButton);
        add(removerButton);
        add(consultarButton);

        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String nome = nomeField.getText();
                String area = areaField.getText();
                int pontos = Integer.parseInt(pontosField.getText());
                Professor professor = new Professor(cpf, nome, area, pontos);
                boolean inserido = professorService.inserir(professor);
                if (inserido) {
                    JOptionPane.showMessageDialog(null, "Professor inserido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Professor com CPF já existente!");
                }
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String nome = nomeField.getText();
                String area = areaField.getText();
                int pontos = Integer.parseInt(pontosField.getText());
                Professor novoProfessor = new Professor(cpf, nome, area, pontos);
                boolean atualizado = professorService.atualizar(novoProfessor);
                if (atualizado) {
                    JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Professor não encontrado!");
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                boolean removido = professorService.remover(cpf);
                if (removido) {
                    JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Professor não encontrado!");
                }
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                Professor professor = professorService.consultarPorCpf(cpf);
                if (professor != null) {
                    nomeField.setText(professor.getNome());
                    areaField.setText(professor.getArea());
                    pontosField.setText(String.valueOf(professor.getPontos()));
                    JOptionPane.showMessageDialog(null, "Professor encontrado!");
                } else {
                    JOptionPane.showMessageDialog(null, "Professor não encontrado!");
                }
            }
        });

        // Define a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        new ProfessorUI();
    }
}
