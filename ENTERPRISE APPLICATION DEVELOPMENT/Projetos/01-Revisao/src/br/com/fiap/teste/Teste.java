package br.com.fiap.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.fiap.beans.Carro;
import br.com.fiap.beans.Transmissao;

public class Teste {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Carro carro = new Carro();	
		
		carro.setCambio(Transmissao.AUTOMATICO);
		
		Calendar data = Calendar.getInstance();
											//ANO, MES, DIA
		Calendar data2 = new GregorianCalendar(2000, Calendar.JANUARY, 19);
		
		
		carro.setDataLancamento(data);
		
		System.out.println(carro.getCambio());
		
		//Formatar a data
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		System.out.println(sdf.format(data.getTime()));
		System.out.println(sdf.format(data2.getTime()));
		
		Date dat3 = new Date();
		
	}
	
}
