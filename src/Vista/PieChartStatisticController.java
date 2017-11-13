/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Reserva;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class PieChartStatisticController {

    @FXML
    private PieChart  pieChart;
    
    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    
    @FXML
    private void initialize() {
        String[] months = DateFormatSymbols.getInstance(Locale.ENGLISH).getShortMonths();
        
        monthNames.addAll(Arrays.asList(months));
        
    }
    
    public void setPersonData(List<Reserva> persons) {
        int[] monthCounter = new int[12];
        int totalCounter = 0;
        for (Reserva p : persons) {
            int month = p.getSala().getMonthValue() - 1;
            monthCounter[month]++;
            totalCounter++;
        }
        

        for (int i = 0; i < monthCounter.length; i++) {
            PieChart.Data datos = new PieChart.Data(monthNames.get(i), monthCounter[i]);
            pieChart.getData().add(datos);
        }
        
        
    }
}
