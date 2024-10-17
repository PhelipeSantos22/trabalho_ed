package main.java.com.trabalhoEd.ui.professorUI;


import main.java.com.trabalhoEd.service.ProfessorService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorRemoverUI extends JFrame {
    private JTextField cpfField;
    private ProfessorService professorService;

    public ProfessorRemoverUI() {
        // Inicializa o serviço de professor
        professorService = new ProfessorService();

        setTitle("Remover Professor - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        // Campos para entrada
        cpfField = new JTextField();

        // Botões
        JButton removerButton = new JButton("Remover");

        // Adicionando componentes à tela
        add(new JLabel("CPF:"));
        add(cpfField);
        add(removerButton);

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                boolean removido = professorService.remover(cpf);
                if (removido) {
                    JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Professor não encontrado!");
                }
            }
        });
        setVisible(true);
    }
}
