package main.java.com.trabalhoEd.ui.professorUI;

import main.java.com.trabalhoEd.model.Professor;
import main.java.com.trabalhoEd.service.ProfessorService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorInserirUI extends JFrame {
    private JTextField cpfField;
    private JTextField nomeField;
    private JTextField areaField;
    private JTextField pontosField;
    private ProfessorService professorService;

    public ProfessorInserirUI() {
        // Inicializa o serviço de professor
        professorService = new ProfessorService();

        setTitle("Inserir Professor - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
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
        JButton inserirButton = new JButton("Inserir");

        // Adicionando componentes à tela
        add(new JLabel("CPF:"));
        add(cpfField);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Área:"));
        add(areaField);
        add(new JLabel("Pontos:"));
        add(pontosField);
        add(inserirButton);

        // Ações dos botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                String nome = nomeField.getText();
                String area = areaField.getText();
                int pontos = Integer.parseInt(pontosField.getText());
                Professor professor = new Professor(cpf, nome, area, pontos);
                boolean inserido = professorService.inserir(professor);
                if (inserido) {
                    JOptionPane.showMessageDialog(null, "Professor inserido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Professor com CPF já existente!");
                }
            }
        });
        // Define a janela visível
        setVisible(true);
    }
}
