


import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import operadores.SeleccionInterface;
import poblacion.Poblacion;
import proceso.Proceso;
import util.ComparadorPorFDA;



public class Ranking implements SeleccionInterface{
    //<param>
    public String porcentaje="0.5";
    //</param>
    
    private float fraccion;

	public Poblacion ejecutar(Poblacion poblacion) {

		List list= poblacion.getListaDeCromosomas();
		
		Collections.sort(list, new ComparadorPorFDA());
		
		Iterator it = list.iterator();
		
		int cantAremover=(int) (list.size() * this.fraccion);
		for (int i = 0; i < cantAremover; i++) 
		{
			it.next();
			it.remove();
			
		}	
		
		return poblacion; 
	}

    public void inicializate(Proceso proceso) {
    try{ 
        
           this.fraccion= 1 - Float.parseFloat(this.porcentaje);
       
       }catch(NumberFormatException ex){
           proceso.mensajeDeError("Error al parsear "+ex.getMessage(), true, false, false);
       }
    }

    public void parametrizate() {
    }





}

