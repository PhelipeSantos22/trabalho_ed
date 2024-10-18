package main.java.com.trabalhoEd.service;
import main.java.com.trabalhoEd.model.Disciplina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaService {
    private final String filePath = "src/main/resources/csv/disciplinas.csv";

    public void inserir(Disciplina disciplina) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(disciplina.getCodigo() + "," + disciplina.getNome() + "," + disciplina.getDiaDaSemana() + "," +
                    disciplina.getHorarioInicial() + "," + disciplina.getHorasDiarias() + "," + disciplina.getCodigoCurso());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Disciplina> consultar() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                disciplinas.add(new Disciplina(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]), dados[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    public void atualizar(Disciplina disciplinaAtualizada) {
        List<Disciplina> disciplinas = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("código,nome,dia_da_semana,horário_inicial,horas_diarias,código_curso");
            writer.newLine();
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

    public void remover(String codigo) {
        List<Disciplina> disciplinas = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("código,nome,dia_da_semana,horário_inicial,horas_diarias,código_curso");
            writer.newLine();
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
