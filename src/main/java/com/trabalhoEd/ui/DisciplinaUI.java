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
        frame.getContentPane().setLayout(new GridLayout(8, 2)); // Mudança para 8 linhas

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
            JOptionPane.showMessageDialog(frame, "Disciplina inserida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao inserir a disciplina. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void consultarDisciplinas() {
        List<Disciplina> disciplinas = disciplinaService.consultar();
        StringBuilder resultado = new StringBuilder();

        for (Disciplina disciplina : disciplinas) {
            resultado.append("Código: ").append(disciplina.getCodigo()).append(", ")
                    .append("Nome: ").append(disciplina.getNome()).append(", ")
                    .append("Dia da Semana: ").append(disciplina.getDiaDaSemana()).append(", ")
                    .append("Horário Inicial: ").append(disciplina.getHorarioInicial()).append(", ")
                    .append("Horas Diárias: ").append(disciplina.getHorasDiarias()).append(", ")
                    .append("Código do Curso: ").append(disciplina.getCodigoCurso()).append("\n");
        }

        if (resultado.length() > 0) {
            JOptionPane.showMessageDialog(frame, resultado.toString(), "Disciplinas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, "Nenhuma disciplina encontrada.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
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
            JOptionPane.showMessageDialog(frame, "Disciplina atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao atualizar a disciplina. Verifique os dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void removerDisciplina() {
        String codigo = codigoField.getText();
        disciplinaService.remover(codigo);
        JOptionPane.showMessageDialog(frame, "Disciplina removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new DisciplinaUI(); // Inicializa a interface gráfica
    }
}
