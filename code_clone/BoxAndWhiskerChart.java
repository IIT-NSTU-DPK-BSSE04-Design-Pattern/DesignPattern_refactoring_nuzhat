package code_clone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public class BoxAndWhiskerChart {
    ChartPanel chartPanel;

    JScrollPane scrollPane;

    private List<Double> getInputData(double l[]) {
        ArrayList<Double> list = new ArrayList<>();
        for (int j = 0; j < l.length; j++) {
            double d = l[j];
            //    System.out.println("k=="+l[j]);
            list.add(l[j]);

        }//System.out.println("");
        return list;
    }

    public void display() {
        JFrame frame = createFrame("Clone_Check");
        DefaultBoxAndWhiskerCategoryDataset dataset = buildDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = createChartPanel(chart);

        frame.add(chartPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Creates the JFrame
    private JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return frame;
    }

    // Creates the ChartPanel
    private ChartPanel createChartPanel(JFreeChart chart) {
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(DEFAULT_DIMENSION);
        return chartPanel;
    }


    public static void BoxWhisker() {
        EventQueue.invokeLater(new BoxAndWhiskerChart()::display);
    }
}
