package poblacion;


import cromosoma.FabricaDeCromosomasInterface;
import cromosoma.InterfaceCromosoma;
import java.util.ArrayList;
import java.util.List;


public class Poblacion{

	/**
	 * Tiene el tama
	 */
	private List<InterfaceCromosoma> listaDeCromosomas;
//	private Solucion solucion;
    private int aptitudMedia;
    private InterfaceCromosoma cromosomaAptitudMin;
    private InterfaceCromosoma cromosomaAptitudMax;
//    private  FabricaDeCromosomasInterface fabricaDeCromosomas;
	
	
//	public static int getCantidad() {
//		return cantidad;
//	}
//
//	public static void setCantidad(int cantidad) {
//		Poblacion.cantidad = cantidad;
//	}

	public List<InterfaceCromosoma> getListaDeCromosomas() {
		
//		ArrayList<InterfaceCromosoma> list = new ArrayList<InterfaceCromosoma>();
//		
//		list.addAll(this.listaDeCromosomas);
//		
//		return list;
		
		return this.listaDeCromosomas;
	}

	public void setListaDeCromosomas(List<InterfaceCromosoma> listaDeCromosomas) {
		this.listaDeCromosomas = listaDeCromosomas;
	}
 
	public void generarPoblacionInicial(FabricaDeCromosomasInterface fabricaDeCromosomas, int cantidad)
	{
		
		for(int i=0; i< cantidad; i++ )
		{
			InterfaceCromosoma cromo=fabricaDeCromosomas.crearCromosomaGenesLLenadosAlAzar();
			this.listaDeCromosomas.add(cromo);
		}	
		
	}
	
//	public Poblacion(Solucion sol)
//	{
//		
//		this.listaDeCromosomas= new ArrayList<InterfaceCromosoma>();
//                
//                this.fabricaDeCromosomas=this.solucion.getFabricaDeCromosomas(); 
//	}
	
	public Poblacion() {
		this.listaDeCromosomas= new ArrayList<InterfaceCromosoma>();
	}
	
	public void add(InterfaceCromosoma cromosoma) {
		this.listaDeCromosomas.add(cromosoma);
	}
	
//	public Poblacion poblacionOrdenada(Comparator comp)
//	{
//		
//		Poblacion poblacion = new Poblacion();
//		
//		
//	}
//	
//	
//	private void ordenar(Comparator comp)
//	{
//		Collections.sort(this.listaDeCromosomas, comp);
//	}

    public int getAptitudMaxima() {
            
            calcularMaxMinYMedia();
            return this.cromosomaAptitudMax.evaluate();

    }

    private void calcularMaxMinYMedia() {
        
        if(this.cromosomaAptitudMax==null){
            this.cromosomaAptitudMax=listaDeCromosomas.get(0);
            this.cromosomaAptitudMin=listaDeCromosomas.get(0);
            long acumulado=0; 

            for(InterfaceCromosoma crom:this.listaDeCromosomas){
                int aptitud = crom.evaluate();

                if(aptitud>this.cromosomaAptitudMax.evaluate()){
                    this.cromosomaAptitudMax=crom;
                }else{

                   if(aptitud<this.cromosomaAptitudMin.evaluate()) {
                       this.cromosomaAptitudMin=crom; 
                   }
                }

                acumulado += aptitud;

            }
            this.aptitudMedia= (int) (acumulado / listaDeCromosomas.size()); 
        }
    
    }

    public int getAptitudMedia() {
        
        calcularMaxMinYMedia();
        return this.aptitudMedia;
    }
    
    public int getAptitudMinima() {
        
        calcularMaxMinYMedia();
        return this.cromosomaAptitudMin.evaluate();
    }
    
}
