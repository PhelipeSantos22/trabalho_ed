package main.java.com.trabalhoEd.ui.disciplinaUI;

import main.java.com.trabalhoEd.model.Disciplina;
import main.java.com.trabalhoEd.service.DisciplinaService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisciplinaInserirUI {
    private JFrame frame;
    private JTextField codigoField, nomeField, diaDaSemanaField, horarioInicialField, horasDiariasField, codigoCursoField;
    private DisciplinaService disciplinaService;

    public DisciplinaInserirUI() {
        disciplinaService = new DisciplinaService(); // Inicializa o serviço de Disciplina
        initialize();
    }
    private void initialize() {
        frame = new JFrame("inserir Disciplina - (NÃO DEIXE NENHUM CAMPO EM BRANCO)");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(8, 2));

        JLabel codigoLabel = new JLabel("Código:");
        codigoField = new JTextField();
        frame.getContentPane().add(codigoLabel);
        frame.getContentPane().add(codigoField);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        frame.getContentPane().add(nomeLabel);
        frame.getContentPane().add(nomeField);

        JLabel diaDaSemanaLabel = new JLabel("Dia da Semana:");
        diaDaSemanaField = new JTextField();
        frame.getContentPane().add(diaDaSemanaLabel);
        frame.getContentPane().add(diaDaSemanaField);

        JLabel horarioInicialLabel = new JLabel("Horário Inicial:");
        horarioInicialField = new JTextField();
        frame.getContentPane().add(horarioInicialLabel);
        frame.getContentPane().add(horarioInicialField);

        JLabel horasDiariasLabel = new JLabel("Horas Diárias:");
        horasDiariasField = new JTextField();
        frame.getContentPane().add(horasDiariasLabel);
        frame.getContentPane().add(horasDiariasField);

        JLabel codigoCursoLabel = new JLabel("Código do Curso:");
        codigoCursoField = new JTextField();
        frame.getContentPane().add(codigoCursoLabel);
        frame.getContentPane().add(codigoCursoField);

        JButton inserirButton = new JButton("Inserir");

        frame.getContentPane().add(inserirButton);

        // ActionListeners para os botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirDisciplina();
            }
        });

        frame.setVisible(true);
    }

    private void inserirDisciplina() {
        try {
            String codigo = codigoField.getText();
            String nome = nomeField.getText();
            String diaDaSemana = diaDaSemanaField.getText();
            String horarioInicial = horarioInicialField.getText();
            int horasDiarias = Integer.parseInt(horasDiariasField.getText());
            String codigoCurso = codigoCursoField.getText();

            Disciplina disciplina = new Disciplina(codigo, nome, diaDaSemana, horarioInicial, horasDiarias, codigoCurso);
            disciplinaService.inserir(disciplina);
            JOptionPane.showMessageDialog(frame, "Disciplina inserida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao inserir a disciplina. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
