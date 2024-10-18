package main.java.com.trabalhoEd.ui.inscricaoUI;

import main.java.com.trabalhoEd.service.InscricaoService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InscricaoRemoverUI extends JFrame {
    private InscricaoService inscricaoService = new InscricaoService();

    public InscricaoRemoverUI() {
        setTitle("Remover Inscrição - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(600, 200); // Tamanho ajustado para melhor visibilidade
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout()); // Usando GridBagLayout para melhor controle

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label e Campo para entrada de CPF
        JLabel cpfLabel = new JLabel("CPF do Professor:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(cpfLabel, gbc);

        JTextField cpfField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(cpfField, gbc);

        // Botão de Remover
        JButton removerButton = new JButton("Remover");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(removerButton, gbc);

        // Ação do botão remover
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                inscricaoService.remover(cpf);
                JOptionPane.showMessageDialog(InscricaoRemoverUI.this, "Inscrição removida com sucesso!");
            }
        });

        setVisible(true);
    }
}
