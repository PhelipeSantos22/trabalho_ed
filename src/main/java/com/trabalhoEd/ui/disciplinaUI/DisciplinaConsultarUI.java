package main.java.com.trabalhoEd.ui.disciplinaUI;

import main.java.com.trabalhoEd.model.Disciplina;
import main.java.com.trabalhoEd.service.DisciplinaService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisciplinaConsultarUI {
    private JFrame frame;
    private DisciplinaService disciplinaService;

    public DisciplinaConsultarUI() {
        disciplinaService = new DisciplinaService();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Consultar Disciplinas");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JTextArea resultadoArea = new JTextArea();
        resultadoArea.setEditable(false); // Impedir a edição do texto
        JScrollPane scrollPane = new JScrollPane(resultadoArea); // Adicionar barra de rolagem
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Botão de consulta
        JButton consultarButton = new JButton("Consultar Disciplinas");
        frame.getContentPane().add(consultarButton, BorderLayout.SOUTH);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarDisciplinas(resultadoArea);
            }
        });

        frame.setVisible(true);
    }

    private void consultarDisciplinas(JTextArea resultadoArea) {
        List<Disciplina> disciplinas = disciplinaService.consultar();
        StringBuilder resultado = new StringBuilder();

        if (!disciplinas.isEmpty()) {
            for (Disciplina disciplina : disciplinas) {
                resultado.append("Código: ").append(disciplina.getCodigo()).append("\n")
                        .append("Nome: ").append(disciplina.getNome()).append("\n")
                        .append("Dia da Semana: ").append(disciplina.getDiaDaSemana()).append("\n")
                        .append("Horário Inicial: ").append(disciplina.getHorarioInicial()).append("\n")
                        .append("Horas Diárias: ").append(disciplina.getHorasDiarias()).append("\n")
                        .append("Código do Curso: ").append(disciplina.getCodigoCurso()).append("\n")
                        .append("----------------------------------------------------\n");
            }
        } else {
            resultado.append("Nenhuma disciplina encontrada.");
        }
        resultadoArea.setText(resultado.toString());
    }
}
