package main.java.com.trabalhoEd.ui.disciplinaUI;

import main.java.com.trabalhoEd.service.DisciplinaService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisciplinaRemoverUI {
    private JFrame frame;
    private JTextField codigoField;
    private DisciplinaService disciplinaService;

    public DisciplinaRemoverUI() {
        disciplinaService = new DisciplinaService();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Remover Disciplina - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        frame.setBounds(100, 100, 600, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label e campo para Código
        JLabel codigoLabel = new JLabel("Código:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.getContentPane().add(codigoLabel, gbc);

        codigoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.getContentPane().add(codigoField, gbc);

        // Botão de remover
        JButton removerButton = new JButton("Remover");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER; // Centralizar botão
        frame.getContentPane().add(removerButton, gbc);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerDisciplina();
            }
        });

        frame.setVisible(true);
    }

    private void removerDisciplina() {
        String codigo = codigoField.getText();
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha o campo de código.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        disciplinaService.remover(codigo);
        JOptionPane.showMessageDialog(frame, "Disciplina removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        codigoField.setText("");
    }
}
