package implementaciones;

import cromosoma.CromosomaAbstractoGenesObject;

public class CromosomaImp extends CromosomaAbstractoGenesObject{
	
	
	protected  String[] genes= new String[8];
	
	public void mutaGenEnPosicon(int posicion) {
		// TODO Auto-generated method stub
		int random1 = ((int) Math.random() * (genes.length-1));
		
		String genAux = this.genes[posicion];
		this.genes[posicion] =this.genes[random1];
		this.genes[random1] =genAux;
	}

	public void generate() {

		PersonasHelper helper = (PersonasHelper) getSolucion().getHelper();
		
		this.genes = helper.getPersonas();
		int random1;
		int random2;
		
		for (int i = 0; i < (this.genes.length/2); i++) {
			
			random1 = ((int) (Math.random() * (genes.length-1)));
			String genAux = this.genes[random1];
			random2 = ((int) (Math.random() * (genes.length-1)));
			this.genes[random1]=this.genes[random2];
			this.genes[random2]=genAux;
		}
		
		System.out.println("generate de "+ this +": ");
		for (int i = 0; i < (this.genes.length); i++) {
			System.out.print(" "+ this.genes[i] +" ");
		}
		System.out.println();

	}

	public String[] getGenes() {
		// TODO Auto-generated method stub
		return this.genes;
	}



}
