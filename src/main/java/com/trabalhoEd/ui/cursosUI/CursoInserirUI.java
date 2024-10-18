package main.java.com.trabalhoEd.ui.cursosUI;

import main.java.com.trabalhoEd.model.Curso;
import main.java.com.trabalhoEd.service.CursoService;

import javax.swing.*;
import java.awt.*;

public class CursoInserirUI extends JFrame {
    private CursoService cursoService = new CursoService();
    private JTextField codigoField, nomeField, areaConhecimentoField;

    public CursoInserirUI() {
        setTitle("Inserir Curso - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Criação dos componentes
        JLabel codigoLabel = new JLabel("Código:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel areaConhecimentoLabel = new JLabel("Área de Conhecimento:");

        codigoField = new JTextField();
        nomeField = new JTextField();
        areaConhecimentoField = new JTextField();

        JButton inserirButton = new JButton("Inserir");

        // Definição do layout dos componentes
        codigoLabel.setBounds(10, 20, 150, 25);
        codigoField.setBounds(170, 20, 200, 25);

        nomeLabel.setBounds(10, 60, 150, 25);
        nomeField.setBounds(170, 60, 200, 25);

        areaConhecimentoLabel.setBounds(10, 100, 150, 25);
        areaConhecimentoField.setBounds(170, 100, 200, 25);

        inserirButton.setBounds(150, 150, 100, 30);

        // Adiciona componentes ao JFrame
        add(codigoLabel);
        add(codigoField);
        add(nomeLabel);
        add(nomeField);
        add(areaConhecimentoLabel);
        add(areaConhecimentoField);
        add(inserirButton);

        // Ação do botão inserir
        inserirButton.addActionListener(e -> inserirCurso());

        setVisible(true);
    }

    private void inserirCurso() {
        String codigo = codigoField.getText();
        String nome = nomeField.getText();
        String areaConhecimento = areaConhecimentoField.getText();

        if (codigo.isEmpty() || nome.isEmpty() || areaConhecimento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Curso curso = new Curso(codigo, nome, areaConhecimento);
            cursoService.inserir(curso);
            JOptionPane.showMessageDialog(this, "Curso inserido com sucesso!");

            // Limpar campos após inserção
            codigoField.setText("");
            nomeField.setText("");
            areaConhecimentoField.setText("");
        }
    }
}
