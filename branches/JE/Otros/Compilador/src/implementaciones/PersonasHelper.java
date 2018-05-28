package implementaciones;

public class PersonasHelper {
	String[] personas = {"PePe","Paco","Ana","Maria","Pablo","Anaconda","Pepita","Anatomia"};
	
	public String getRandomPerson(){
		 
		 int random = ((int) Math.random() * (personas.length-1));
		 
		 return personas[random];
	}
	
	public String[] getPersonas(){
		
		 return personas.clone();
		 
		 
	}

	public int valorRelacion(String string, String string2) {
		// TODO Auto-generated method stub
		if (string.startsWith(string2.substring(0, 1)))
			return 10;
		
		return 0;
	}
}
