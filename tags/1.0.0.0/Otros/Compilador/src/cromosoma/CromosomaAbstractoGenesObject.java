package cromosoma;

import solucion.Solucion;
import comp.ManejadorDeElementos;

public abstract class CromosomaAbstractoGenesObject implements InterfaceCromosoma{
	
//	protected int largo;
	
//	public static Cromosoma newInstance()
//	{
//		Cromosoma cromosoma = null;
//		
//		return cromosoma;
//		
//	}
	private Solucion solucion;
	
	protected int valor;
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	private boolean aptitudEvaluada=false;

	private int aptitud;
	
	public abstract Object[] getGenes();

	
	public void setSolucion(Solucion solucion) {
		this.solucion=solucion;
	};
	
	public Solucion getSolucion() {
		return this.solucion;
	};
	
//	public abstract void mutaGenEnPosicon(int posicion);
//	
//	public abstract void generate();
	
	//Q cantidad sea una variable de instancia que se mete por el sist.
	public int getCantidadDeGenes()
	{
		return this.getGenes().length;
	}
	
	public void meterGenEn(int posicionGenEsteCromosoma,InterfaceCromosoma crom, int posicionGenOtroCromosoma)
	{
		this.getGenes()[posicionGenEsteCromosoma]=((CromosomaAbstractoGenesObject) crom).getGenes()[posicionGenOtroCromosoma];
	}
	
	
	public int evaluate() { 
		
		if(!this.aptitudEvaluada)
		{
			FuncionDeAptitud funcion=this.solucion.getFuncionDeAptitud();
			this.aptitudEvaluada=true;
			this.aptitud = funcion.evaluar(this);
			
		}
		
		return this.aptitud;
	}
	
}
