package implementaciones;

import elementos.HelperInterface;

import proceso.Proceso;

public class PersonasHelper implements HelperInterface{
	String[] personas = {"PePe","Paco","Ana","Maria","Pablo","Anaconda","Pepita","Anatomia"};
	
//	private Random solucionRandomizer;

//	
//	public String getRandomPerson(){
//		 
//		 return personas[this.solucionRandomizer.nextInt(personas.length)];
//	}
//	
//	public String[] getPersonas(){
//		
//		 return (String[]) personas.clone();
//		 
//	}

	public int valorRelacion(String string, String string2) {
		// TODO Auto-generated method stub
		
		if(string.equals(string2))
			return -100000;
			
		if (string.startsWith(string2.substring(0, 1)))
			return 10;
		
		return 0;
	}



    
    public void inicializate(Proceso proceso) {
    }

    public void parametrizate() {
    }

}
