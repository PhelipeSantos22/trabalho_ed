package main.java.com.trabalhoEd.ui;

import main.java.com.trabalhoEd.model.Disciplina;
import main.java.com.trabalhoEd.service.DisciplinaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisciplinaUI {
    private JFrame frame;
    private JTextField codigoField, nomeField, diaDaSemanaField, horarioInicialField, horasDiariasField, codigoCursoField;
    private JTextArea resultadoArea;
    private DisciplinaService disciplinaService;

    public DisciplinaUI() {
        disciplinaService = new DisciplinaService(); // Inicializa o serviço de Disciplina
        initialize();
    }

    private void initialize() {
        // Configuração da janela
        frame = new JFrame("Gerenciamento de Disciplinas");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(9, 2));

        // Componentes da UI
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
        JButton consultarButton = new JButton("Consultar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton removerButton = new JButton("Remover");

        frame.getContentPane().add(inserirButton);
        frame.getContentPane().add(consultarButton);
        frame.getContentPane().add(atualizarButton);
        frame.getContentPane().add(removerButton);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        frame.getContentPane().add(new JScrollPane(resultadoArea));

        // ActionListeners para os botões
        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inserirDisciplina();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarDisciplinas();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarDisciplina();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerDisciplina();
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
            resultadoArea.setText("Disciplina inserida com sucesso!");

        } catch (Exception e) {
            resultadoArea.setText("Erro ao inserir a disciplina. Verifique os dados.");
            e.printStackTrace();
        }
    }

    private void consultarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaService.consultar();
        StringBuilder resultado = new StringBuilder();

        for (Disciplina disciplina : disciplinas) {
            resultado.append(disciplina.getCodigo()).append(", ")
                    .append(disciplina.getNome()).append(", ")
                    .append(disciplina.getDiaDaSemana()).append(", ")
                    .append(disciplina.getHorarioInicial()).append(", ")
                    .append(disciplina.getHorasDiarias()).append(", ")
                    .append(disciplina.getCodigoCurso()).append("\n");
        }

        resultadoArea.setText(resultado.toString());
    }

    private void atualizarDisciplina() {
        try {
            String codigo = codigoField.getText();
            String nome = nomeField.getText();
            String diaDaSemana = diaDaSemanaField.getText();
            String horarioInicial = horarioInicialField.getText();
            int horasDiarias = Integer.parseInt(horasDiariasField.getText());
            String codigoCurso = codigoCursoField.getText();

            Disciplina disciplinaAtualizada = new Disciplina(codigo, nome, diaDaSemana, horarioInicial, horasDiarias, codigoCurso);
            disciplinaService.atualizar(disciplinaAtualizada);
            resultadoArea.setText("Disciplina atualizada com sucesso!");

        } catch (Exception e) {
            resultadoArea.setText("Erro ao atualizar a disciplina. Verifique os dados.");
            e.printStackTrace();
        }
    }

    private void removerDisciplina() {
        String codigo = codigoField.getText();
        disciplinaService.remover(codigo);
        resultadoArea.setText("Disciplina removida com sucesso!");
    }

    public static void main(String[] args) {
        new DisciplinaUI(); // Inicializa a interface gráfica
    }
}
