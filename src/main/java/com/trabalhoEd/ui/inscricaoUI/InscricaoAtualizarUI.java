package main.java.com.trabalhoEd.ui.inscricaoUI;

import main.java.com.trabalhoEd.model.Inscricao;
import main.java.com.trabalhoEd.service.InscricaoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InscricaoAtualizarUI extends JFrame {
    private InscricaoService inscricaoService = new InscricaoService();

    public InscricaoAtualizarUI() {
        setTitle("Atualizar Inscrição - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos para entrada
        JTextField cpfField = new JTextField();
        JTextField codigoDisciplinaField = new JTextField();
        JTextField codigoProcessoField = new JTextField();

        JButton atualizarButton = new JButton("Atualizar");


        // Adicionando componentes à tela
        add(new JLabel("CPF do Professor:"));
        add(cpfField);
        add(new JLabel("Código da Disciplina:"));
        add(codigoDisciplinaField);
        add(new JLabel("Código do Processo:"));
        add(codigoProcessoField);
        add(atualizarButton);

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String codigoDisciplina = codigoDisciplinaField.getText();
                String codigoProcesso = codigoProcessoField.getText();

                Inscricao inscricao = new Inscricao(cpf, codigoDisciplina, codigoProcesso);
                inscricaoService.atualizar(inscricao);
                JOptionPane.showMessageDialog(InscricaoAtualizarUI.this, "Inscrição atualizada com sucesso!");
            }
        });

        setVisible(true);
    }
}
