package implementaciones;

import java.util.Random;

import poblacion.Poblacion;
import solucion.Solucion;
import cromosoma.CromosomaAbstractoGenesObject;

public class CromosomaImp extends CromosomaAbstractoGenesObject{
	
	
	protected  String[] genes= new String[8];
	
	public void mutaGenEnPosicion(int posicion) {
		
		this.aptitudEvaluada=false;
		int random1 = getSolucion().getRandomizer().nextInt(genes.length);
		
		String genAux = this.genes[posicion];
		this.genes[posicion] =this.genes[random1];
		this.genes[random1] =genAux;
	}

	public void generate() {

		PersonasHelper helper = (PersonasHelper) getSolucion().getHelper();
		Random solucionRandomizer = getSolucion().getRandomizer();
		
		this.genes = helper.getPersonas();
		int random1;
		int random2;
			
		for (int i = 0; i < (this.genes.length/2); i++) {
			
			random1 = solucionRandomizer.nextInt(genes.length);
			String genAux = this.genes[random1];
			random2 = solucionRandomizer.nextInt(genes.length);
			this.genes[random1]=this.genes[random2];
			this.genes[random2]=genAux;
		}
		
//		System.out.println("generate de "+ this +": ");
//		for (int i = 0; i < (this.genes.length); i++) {
//			System.out.print(" "+ this.genes[i] +" ");
//		}
//		System.out.println();

	}

	public String[] getGenes() {
		// TODO Auto-generated method stub
		return this.genes;
	}



}
