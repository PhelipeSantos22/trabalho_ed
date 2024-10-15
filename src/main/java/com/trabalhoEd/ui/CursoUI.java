package main.java.com.trabalhoEd.ui;

import main.java.com.trabalhoEd.model.Curso;
import main.java.com.trabalhoEd.service.CursoService;

import javax.swing.*;
import java.util.List;

public class CursoUI extends JFrame {
    private CursoService cursoService = new CursoService();
    private JTextField codigoField, nomeField, areaConhecimentoField;

    public CursoUI() {
        setTitle("Gerenciar Cursos");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel codigoLabel = new JLabel("Código:");
        JLabel nomeLabel = new JLabel("Nome:");
        JLabel areaConhecimentoLabel = new JLabel("Área de Conhecimento:");

        codigoField = new JTextField();
        nomeField = new JTextField();
        areaConhecimentoField = new JTextField();

        JButton inserirButton = new JButton("Inserir");
        JButton consultarButton = new JButton("Consultar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton removerButton = new JButton("Remover");

        // Define posições e tamanhos dos componentes
        codigoLabel.setBounds(10, 10, 150, 25);
        codigoField.setBounds(160, 10, 100, 25);
        nomeLabel.setBounds(10, 40, 150, 25);
        nomeField.setBounds(160, 40, 100, 25);
        areaConhecimentoLabel.setBounds(10, 70, 150, 25);
        areaConhecimentoField.setBounds(160, 70, 100, 25);
        inserirButton.setBounds(10, 100, 100, 25);
        consultarButton.setBounds(120, 100, 100, 25);
        atualizarButton.setBounds(10, 130, 100, 25);
        removerButton.setBounds(120, 130, 100, 25);

        // Adiciona componentes ao JFrame
        add(codigoLabel);
        add(codigoField);
        add(nomeLabel);
        add(nomeField);
        add(areaConhecimentoLabel);
        add(areaConhecimentoField);
        add(inserirButton);
        add(consultarButton);
        add(atualizarButton);
        add(removerButton);

        // Ações dos botões
        inserirButton.addActionListener(e -> inserirCurso());
        consultarButton.addActionListener(e -> consultarCursos());
        atualizarButton.addActionListener(e -> atualizarCurso());
        removerButton.addActionListener(e -> removerCurso());

        setVisible(true);
    }

    private void inserirCurso() {
        String codigo = codigoField.getText();
        String nome = nomeField.getText();
        String areaConhecimento = areaConhecimentoField.getText();

        Curso curso = new Curso(codigo, nome, areaConhecimento);
        cursoService.inserir(curso);
        JOptionPane.showMessageDialog(this, "Curso inserido com sucesso!");
    }

    private void consultarCursos() {
        List<Curso> cursos = cursoService.consultar();
        StringBuilder sb = new StringBuilder("Cursos:\n");
        for (Curso curso : cursos) {
            sb.append(curso.getCodigo()).append(" - ").append(curso.getNome())
                    .append(" - ").append(curso.getAreaConhecimento()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void atualizarCurso() {
        String codigo = codigoField.getText();
        String nome = nomeField.getText();
        String areaConhecimento = areaConhecimentoField.getText();
        Curso curso = new Curso(codigo, nome, areaConhecimento);
        cursoService.atualizar(curso);
        JOptionPane.showMessageDialog(this, "Curso atualizado com sucesso!");
    }

    private void removerCurso() {
        String codigo = codigoField.getText();
        cursoService.remover(codigo);
        JOptionPane.showMessageDialog(this, "Curso removido com sucesso!");
    }
}
