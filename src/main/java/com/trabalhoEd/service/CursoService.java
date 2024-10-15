package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Curso;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoService {
    private final String filePath = "src\\main\\resources\\csv\\cursos.csv";

    public void inserir(Curso curso) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(curso.getCodigo()).append(",")
                    .append(curso.getNome()).append(",")
                    .append(curso.getAreaConhecimento()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> consultar() {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                Curso curso = new Curso(partes[0], partes[1], partes[2]);
                cursos.add(curso);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    public Curso consultarPorCodigo(String codigo) {
        List<Curso> cursos = consultar();
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null; // Retorna null se o curso não for encontrado
    }

    public void atualizar(Curso curso) {
        List<Curso> cursos = consultar();
        try (FileWriter writer = new FileWriter(filePath, false)) { // Sobrescreve o arquivo
            for (Curso c : cursos) {
                if (c.getCodigo().equals(curso.getCodigo())) {
                    writer.append(curso.getCodigo()).append(",")
                            .append(curso.getNome()).append(",")
                            .append(curso.getAreaConhecimento()).append("\n");
                } else {
                    writer.append(c.getCodigo()).append(",")
                            .append(c.getNome()).append(",")
                            .append(c.getAreaConhecimento()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String codigo) {
        List<Curso> cursos = consultar();
        try (FileWriter writer = new FileWriter(filePath, false)) { // Sobrescreve o arquivo
            for (Curso curso : cursos) {
                if (!curso.getCodigo().equals(codigo)) {
                    writer.append(curso.getCodigo()).append(",")
                            .append(curso.getNome()).append(",")
                            .append(curso.getAreaConhecimento()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
