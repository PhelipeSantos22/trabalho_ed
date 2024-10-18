package main.java.com.trabalhoEd.ui.inscricaoUI;

import main.java.com.trabalhoEd.model.Inscricao;
import main.java.com.trabalhoEd.service.InscricaoService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InscricaoInserirUI extends JFrame {
    private InscricaoService inscricaoService = new InscricaoService();

    public InscricaoInserirUI() {
        setTitle("Inserir Inscrição - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos para entrada
        JTextField cpfField = new JTextField();
        JTextField codigoDisciplinaField = new JTextField();
        JTextField codigoProcessoField = new JTextField();

        // Botões
        JButton inserirButton = new JButton("Inserir");

        // Adicionando componentes à tela
        add(new JLabel("CPF do Professor:"));
        add(cpfField);
        add(new JLabel("Código da Disciplina:"));
        add(codigoDisciplinaField);
        add(new JLabel("Código do Processo:"));
        add(codigoProcessoField);
        add(inserirButton);

        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String codigoDisciplina = codigoDisciplinaField.getText();
                String codigoProcesso = codigoProcessoField.getText();

                Inscricao inscricao = new Inscricao(cpf, codigoDisciplina, codigoProcesso);
                inscricaoService.inserir(inscricao);
                JOptionPane.showMessageDialog(InscricaoInserirUI.this, "Inscrição inserida com sucesso!");
            }
        });
        setVisible(true);
    }
}
