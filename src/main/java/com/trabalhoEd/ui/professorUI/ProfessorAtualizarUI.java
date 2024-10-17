package main.java.com.trabalhoEd.ui.professorUI;

import main.java.com.trabalhoEd.model.Professor;
import main.java.com.trabalhoEd.service.ProfessorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorAtualizarUI extends JFrame {
    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField areaField;
    private JTextField pontosField;
    private ProfessorService professorService;

    public ProfessorAtualizarUI() {
        // Inicializa o serviço de professor
        professorService = new ProfessorService();

        setTitle("Atualização Professor - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        // Campos para entrada
        cpfField = new JTextField();
        nomeField = new JTextField();
        areaField = new JTextField();
        pontosField = new JTextField();

        // Botões
        JButton atualizarButton = new JButton("Atualizar");

        // Adicionando componentes à tela
        add(new JLabel("CPF:"));
        add(cpfField);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Área:"));
        add(areaField);
        add(new JLabel("Pontos:"));
        add(pontosField);
        add(atualizarButton);

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
        setVisible(true);
    }
}
