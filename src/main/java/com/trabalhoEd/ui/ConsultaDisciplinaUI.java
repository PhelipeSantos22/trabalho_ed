package main.java.com.trabalhoEd.ui;

import javax.swing.*;
import java.awt.*;

public class ConsultaDisciplinaUI extends JFrame {
    public ConsultaDisciplinaUI() {
        setTitle("Consulta de Disciplinas com Processos Abertos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tabela para mostrar as disciplinas
        String[] columnNames = {"Código", "Nome", "Dia", "Horário", "Código do Curso"};
        Object[][] data = {}; // Inicialmente vazio

        JTable table = new JTable(data, columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
