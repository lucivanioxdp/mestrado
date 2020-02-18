package com.valores.app.model.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculadoraData {
    private String dataFinal;

    public String getDataFinal() {
        return dataFinal;
    }
    
    public static String subtarirData(int qtdDias, String dataAtual){
        Date data = new Date(dataAtual);
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        c.add(Calendar.DAY_OF_MONTH, - qtdDias);
        data = c.getTime();
        String formato = "yyyy-MM-dd";
        SimpleDateFormat dataFormatada = new SimpleDateFormat(formato);
        return dataFormatada.format(data);
    }
    
}


