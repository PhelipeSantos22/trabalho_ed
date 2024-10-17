package main.java.com.trabalhoEd.ui.cursosUI;

import main.java.com.trabalhoEd.model.Curso;
import main.java.com.trabalhoEd.service.CursoService;

import javax.swing.*;
import java.util.List;

public class CursoAtualizarUI extends JFrame {
    private CursoService cursoService = new CursoService();
    private JTextField codigoField, nomeField, areaConhecimentoField;

    public CursoAtualizarUI() {
        setTitle("Atualizar Curso - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel codigoLabel = new JLabel("Código:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel areaConhecimentoLabel = new JLabel("Área de Conhecimento:");

        codigoField = new JTextField();
        nomeField = new JTextField();
        areaConhecimentoField = new JTextField();

        JButton atualizarButton = new JButton("Atualizar");

        // Define posições e tamanhos dos componentes
        codigoLabel.setBounds(10, 10, 150, 25);
        codigoField.setBounds(160, 10, 100, 25);
        nomeLabel.setBounds(10, 40, 150, 25);
        nomeField.setBounds(160, 40, 100, 25);
        areaConhecimentoLabel.setBounds(10, 70, 150, 25);
        areaConhecimentoField.setBounds(160, 70, 100, 25);
        atualizarButton.setBounds(10, 130, 100, 25);

        // Adiciona componentes ao JFrame
        add(codigoLabel);
        add(codigoField);
        add(nomeLabel);
        add(nomeField);
        add(areaConhecimentoLabel);
        add(areaConhecimentoField);
        add(atualizarButton);

        // Ações dos botões
        atualizarButton.addActionListener(e -> atualizarCurso());

        setVisible(true);
    }

    private void atualizarCurso() {
        String codigo = codigoField.getText();
        String nome = nomeField.getText();
        String areaConhecimento = areaConhecimentoField.getText();
        Curso curso = new Curso(codigo, nome, areaConhecimento);
        cursoService.atualizar(curso);
        JOptionPane.showMessageDialog(this, "Curso atualizado com sucesso!");
    }
}
