package main.java.com.trabalhoEd.service;
import main.java.com.trabalhoEd.model.Disciplina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaService {
    private final String filePath = "src/main/resources/csv/disciplinas.csv";

    public void inserir(Disciplina disciplina) {
        boolean arquivoExiste = new java.io.File(filePath).exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Verificar se o cabeçalho já foi escrito
            if (!arquivoExiste) {
                writer.write("código,nome,dia_da_semana,horário_inicial,horas_diarias,código_curso");
                writer.newLine();
            }
            // Escrever a nova disciplina
            writer.write(disciplina.getCodigo() + "," + disciplina.getNome() + "," + disciplina.getDiaDaSemana() + "," +
                    disciplina.getHorarioInicial() + "," + disciplina.getHorasDiarias() + "," + disciplina.getCodigoCurso());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Consultar todas as disciplinas no CSV
    public List<Disciplina> consultar() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Ignorar o cabeçalho
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                // Verificar se há a quantidade correta de dados
                if (dados.length == 6) {
                    disciplinas.add(new Disciplina(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]), dados[5]));
                } else {
                    System.err.println("Linha inválida: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    // Atualizar uma disciplina existente no CSV
    public void atualizar(Disciplina disciplinaAtualizada) {
        List<Disciplina> disciplinas = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescrever o cabeçalho
            writer.write("código,nome,dia_da_semana,horário_inicial,horas_diarias,código_curso");
            writer.newLine();
            // Reescrever todas as disciplinas, substituindo a disciplina atualizada
            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equals(disciplinaAtualizada.getCodigo())) {
                    writer.write(disciplinaAtualizada.getCodigo() + "," + disciplinaAtualizada.getNome() + "," +
                            disciplinaAtualizada.getDiaDaSemana() + "," + disciplinaAtualizada.getHorarioInicial() + "," +
                            disciplinaAtualizada.getHorasDiarias() + "," + disciplinaAtualizada.getCodigoCurso());
                } else {
                    writer.write(disciplina.getCodigo() + "," + disciplina.getNome() + "," + disciplina.getDiaDaSemana() + "," +
                            disciplina.getHorarioInicial() + "," + disciplina.getHorasDiarias() + "," + disciplina.getCodigoCurso());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Remover uma disciplina pelo código no CSV
    public void remover(String codigo) {
        List<Disciplina> disciplinas = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescrever o cabeçalho
            writer.write("código,nome,dia_da_semana,horário_inicial,horas_diarias,código_curso");
            writer.newLine();
            // Reescrever todas as disciplinas, exceto a que deve ser removida
            for (Disciplina disciplina : disciplinas) {
                if (!disciplina.getCodigo().equals(codigo)) {
                    writer.write(disciplina.getCodigo() + "," + disciplina.getNome() + "," + disciplina.getDiaDaSemana() + "," +
                            disciplina.getHorarioInicial() + "," + disciplina.getHorasDiarias() + "," + disciplina.getCodigoCurso());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

