package main.java.com.trabalhoEd.ui.cursosUI;

import main.java.com.trabalhoEd.model.Curso;
import main.java.com.trabalhoEd.service.CursoService;

import javax.swing.*;
import java.util.List;

public class CursoRemoverUI extends JFrame {
    private CursoService cursoService = new CursoService();
    private JTextField codigoField, nomeField, areaConhecimentoField;

    public CursoRemoverUI() {
        setTitle("Remover Cursos - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel codigoLabel = new JLabel("Código:");

        codigoField = new JTextField();
        nomeField = new JTextField();
        areaConhecimentoField = new JTextField();

        JButton removerButton = new JButton("Remover");

        // Define posições e tamanhos dos componentes
        codigoLabel.setBounds(10, 10, 150, 25);
        codigoField.setBounds(160, 10, 100, 25);
        removerButton.setBounds(120, 130, 100, 25);

        // Adiciona componentes ao JFrame
        add(codigoLabel);
        add(codigoField);
        add(removerButton);

        removerButton.addActionListener(e -> removerCurso());

        setVisible(true);
    }

    private void removerCurso() {
        String codigo = codigoField.getText();
        cursoService.remover(codigo);
        JOptionPane.showMessageDialog(this, "Curso removido com sucesso!");
    }
}
