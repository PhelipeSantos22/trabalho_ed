package main.java.com.trabalhoEd.ui;

import main.java.com.trabalhoEd.model.Inscricao;
import main.java.com.trabalhoEd.service.InscricaoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InscricaoUI extends JFrame {
    private InscricaoService inscricaoService = new InscricaoService();

    public InscricaoUI() {
        setTitle("Gerenciamento de Inscrições");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        // Campos para entrada
        JTextField cpfField = new JTextField();
        JTextField codigoDisciplinaField = new JTextField();
        JTextField codigoProcessoField = new JTextField();

        // Botões
        JButton inserirButton = new JButton("Inserir");
        JButton consultarButton = new JButton("Consultar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton removerButton = new JButton("Remover");

        // Adicionando componentes à tela
        add(new JLabel("CPF do Professor:"));
        add(cpfField);
        add(new JLabel("Código da Disciplina:"));
        add(codigoDisciplinaField);
        add(new JLabel("Código do Processo:"));
        add(codigoProcessoField);
        add(inserirButton);
        add(consultarButton);
        add(atualizarButton);
        add(removerButton);

        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String codigoDisciplina = codigoDisciplinaField.getText();
                String codigoProcesso = codigoProcessoField.getText();

                Inscricao inscricao = new Inscricao(cpf, codigoDisciplina, codigoProcesso);
                inscricaoService.inserir(inscricao);
                JOptionPane.showMessageDialog(InscricaoUI.this, "Inscrição inserida com sucesso!");
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Inscricao> inscricoes = inscricaoService.consultar();
                StringBuilder sb = new StringBuilder("Inscrições:\n");
                for (Inscricao inscricao : inscricoes) {
                    sb.append("CPF: ").append(inscricao.getCpf())
                            .append(", Disciplina: ").append(inscricao.getCodigoDisciplina())
                            .append(", Processo: ").append(inscricao.getCodigoProcesso())
                            .append("\n");
                }
                JOptionPane.showMessageDialog(InscricaoUI.this, sb.toString());
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String codigoDisciplina = codigoDisciplinaField.getText();
                String codigoProcesso = codigoProcessoField.getText();

                Inscricao inscricao = new Inscricao(cpf, codigoDisciplina, codigoProcesso);
                inscricaoService.atualizar(inscricao);
                JOptionPane.showMessageDialog(InscricaoUI.this, "Inscrição atualizada com sucesso!");
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                inscricaoService.remover(cpf);
                JOptionPane.showMessageDialog(InscricaoUI.this, "Inscrição removida com sucesso!");
            }
        });
        setVisible(true);
    }
}
