package cromosoma;

import proceso.Proceso;

public abstract class CromosomaAbstractoGenesObject implements InterfaceCromosoma{
	
    
    protected Proceso proceso;
	
    protected boolean aptitudEvaluada=false;

    protected int aptitud;
    
    protected  Object[] genes;

    public Object[] getGenes() {
        return genes;
    }

    public void setGenes(Object[] genes) {
        this.genes = genes;
    }
    
	
	public void setProceso(Proceso proceso) {
		this.proceso=proceso;
	}
	

	
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
			FuncionDeAptitud funcion=this.proceso.getFuncionDeAptitud();
			this.aptitudEvaluada=true;
			this.aptitud = funcion.evaluar(this);
			
		}
		
		return this.aptitud;
	}
        
       public InterfaceCromosoma clone(){
            
            InterfaceCromosoma obj=null;
            
            try{
                
                obj=(InterfaceCromosoma) super.clone();
            
            }catch(CloneNotSupportedException ex){
               
                this.proceso.mensajeDeError(" No se puede clonar ", true, false, false);
               
            }
            
            CromosomaAbstractoGenesObject cromoAbstract = (CromosomaAbstractoGenesObject) obj;
//            Object[] arrayGenes = cromoAbstract.getGenes();
//            this.genes=arrayGenes.clone();
            cromoAbstract.setGenes(this.genes.clone());
            
            return obj;
        }
	
}
