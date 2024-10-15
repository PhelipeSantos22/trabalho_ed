package main.java.com.trabalhoEd.ui;

import javax.swing.*;
import java.awt.*;

public class ConsultaInscricaoUI extends JFrame {
    public ConsultaInscricaoUI() {
        setTitle("Consulta de Inscrições");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tabela para mostrar as inscrições
        String[] columnNames = {"CPF", "Código da Disciplina", "Código do Processo"};
        Object[][] data = {}; // Inicialmente vazio

        JTable table = new JTable(data, columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
