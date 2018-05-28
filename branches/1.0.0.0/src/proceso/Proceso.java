package proceso;

import Formularios.frmSolucion;
import Solutions.Solution;
import cromosoma.FabricaDeCromosomasInterface;
import cromosoma.FuncionDeAptitud;
import elementos.ElementoParametrizable;
import elementos.FormatoInformeInterface;
import elementos.HelperInterface;
import elementos.ParoInterface;
import helpers.functions;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import operadores.CruzamientoInterface;
import operadores.MutacionInterface;
import operadores.SeleccionInterface;
import poblacion.Poblacion;

public class Proceso implements Runnable {

    private int cantidadPoblacionInicial;
    private int cantidadDeCromosomasMutados;
    private boolean error=false;
    private boolean enviarResultados;

    public int getCantidadPoblacionInicial() {
        return cantidadPoblacionInicial;
    }

    public FabricaDeCromosomasInterface getFabricaDeCromosomas() {
        return fabricaDeCromosomas;
    }

    public MutacionInterface getOperadorMutacion() {
        return operadorMutacion;
    }

    public CruzamientoInterface getOperadorCruzamiento() {
        return operadorCruzamiento;
    }

    public SeleccionInterface getOperadorSeleccion() {
        return operadorSeleccion;
    }

    public FormatoInformeInterface getFormatoInformeResultados() {
        return formatoInformeResultados;
    }

    public ParoInterface getParo() {
        return paro;
    }

    public FuncionDeAptitud getFuncionDeAptitud() {
        return funcionDeAptitud;
    }

    public HelperInterface getHelper() {
        return helper;
    }
    private FabricaDeCromosomasInterface fabricaDeCromosomas;
    private HelperInterface helper;
    private Random randomizer = new Random();
    private MutacionInterface operadorMutacion;
    private CruzamientoInterface operadorCruzamiento;
    private SeleccionInterface operadorSeleccion;
    private ManejadorDeElementos manejadorDeElementos;
    private FormatoInformeInterface formatoInformeResultados;
    private ParoInterface paro;
    private FuncionDeAptitud funcionDeAptitud;
    private Poblacion poblacion;
    private boolean nuevo;
    private boolean pausado;
    private boolean ejecutando;
    private boolean finalizado;
    private boolean elementosListos;
    private frmSolucion frmSol;
    private int nroCiclo;
    private Thread hiloProceso;
    private Bloqueo bloqueo;

    public boolean estaNuevo() {
        return nuevo;
    }

    public boolean estaPausado() {
        return pausado;
    }

    public boolean estaEjecutando() {
        return ejecutando;
    }

    public boolean estaFinalizado() {
        return finalizado;
    }

    public frmSolucion getFrmSol() {
        return frmSol;
    }

    public Poblacion getPoblacion() {
        return poblacion;
    }

    public int getNroCiclo() {
        return nroCiclo;
    }

    public Thread getHiloProceso() {
        return hiloProceso;
    }

    public Bloqueo getBloqueo() {
        return bloqueo;
    }

    public Proceso(frmSolucion frmSolucion) {

        this.frmSol = frmSolucion;
        nuevo = true;
        elementosListos = false;
        pausado = false;
        ejecutando=false;
        finalizado=false;    
        this.manejadorDeElementos = new ManejadorDeElementos(this);
        this.bloqueo=new Bloqueo();


    }

//    public void prueba() {
//
//        this.paro = new ParoPorCiclos();
//
//        this.formatoInformeResultados = new InformeDePrueba();
//        this.helper = new PersonasHelper();
//        //this.helper = new PersonasHelperCSV();
//        this.fabricaDeCromosomas = new FabricaCromosomasPersonas();
//        this.operadorMutacion = new MutacionCambioDeEltos();
//        this.operadorSeleccion = new Torneo();
//        this.operadorCruzamiento = new CruzaMascaraDoble();
//        this.funcionDeAptitud = new FuncionDeAptitudImpl();
//        
//        this.helper.inicializate(this);
//        this.fabricaDeCromosomas.inicializate(this);
//        this.funcionDeAptitud.inicializate(this);
//        this.operadorSeleccion.inicializate(this);
//        this.operadorCruzamiento.inicializate(this);
//        this.operadorMutacion.inicializate(this);
//        this.paro.inicializate(this);
//        this.formatoInformeResultados.inicializate(this);
//
//        this.helper.parametrizate();
//        this.fabricaDeCromosomas.parametrizate();
//        this.funcionDeAptitud.parametrizate();
//        this.operadorSeleccion.parametrizate();
//        this.operadorCruzamiento.parametrizate();
//        this.operadorMutacion.parametrizate();
//        this.paro.parametrizate();
//        this.formatoInformeResultados.parametrizate();
//
//
//
//        cantidadPoblacionInicial = 100;
//        elementosListos = true;
//    }

    public void usa(Solution configSolution) {
        if(this.manejadorDeElementos.usa(configSolution)){
            this.cantidadPoblacionInicial=configSolution.getIntSize();
            elementosListos=true;
        }
//        this.prueba();
    }

    public void ejecutate() {

        if (nuevo) {

            if (elementosListos) {
                this.nuevo = false;
                this.error=false;
                enviarResultados=true;
//            this.ejecutando = true;
                this.hiloProceso = new Thread(this);
                this.hiloProceso.start();
            }
        }



    }

//    private void imprimirCromo(Poblacion poblacion) {
//        List<InterfaceCromosoma> lista = new ArrayList<>();
//        for (InterfaceCromosoma crom : poblacion.getListaDeCromosomas()) {
//
////            Object[] genes = ((CromosomaAbstractoGenesObject) crom).getGenes();
////            for (int i = 0; i < (genes.length); i++) {
////
////                System.out.print(" " + genes[i] + " ");
////            }
//            if(lista.contains(crom)){
//             // System.out.print("Este Ya estaba ");
//
//            }
//            //System.out.print(crom);
//            lista.add(crom);
//            //System.out.println();
//            
//        }
//    }

    public void run() {
        try {
            
            comienzoEjecucion();



            while (paro.continuar()) {

//                System.out.println("Ciclo "+this.nroCiclo);
               if(operadorSeleccion!=null) 
                poblacion = operadorSeleccion.ejecutar(poblacion);

//			System.out.println("Seleccion");
//			imprimirCromo(poblacion);	
               if(operadorCruzamiento!=null)
                poblacion = operadorCruzamiento.ejecutar(poblacion);

//			System.out.println("Cruza");
//			imprimirCromo(poblacion);	
                
//                System.out.println("Muta");
                if(operadorMutacion!=null)
                   poblacion = operadorMutacion.ejecutar(poblacion);

		
//			imprimirCromo(poblacion);

//			poblacion = opMuta.ejecutar(opCruza.ejecutar(opSeleccion.ejecutar(poblacion, solucion), solucion), solucion);
                ++nroCiclo;


                this.frmSol.setAptitudMaxima(poblacion.getAptitudMaxima());
                this.frmSol.setAptitudMedia(poblacion.getAptitudMedia());
                this.frmSol.setAptitudMinima(poblacion.getAptitudMinima());
                this.frmSol.setCiclo(this.nroCiclo);
                this.frmSol.setPoblacionActual(poblacion.getListaDeCromosomas().size());
                this.frmSol.setMutaciones(this.cantidadDeCromosomasMutados);

//                        System.err.println("Antes de la grafica");
                        
                        if(this.frmSol.Grafica!=null){
                        
                            this.frmSol.Grafica.MostrarPunto
                                (poblacion.getAptitudMinima(), poblacion.getAptitudMedia(), poblacion.getAptitudMaxima());
                           
                        if (this.frmSol.Sleep > 0) 
                            this.hiloProceso.sleep(this.frmSol.Sleep);                            
                        
                        }
                        if (pausado) {
                            
                            pausa();
                            
                            if(finalizado){
                                ejecutando=false;
                                pausado=false;
                                break;
                            }
                            
                        }
                         

		} // FIN while (paro.continuar())
            
             
             if(!error && enviarResultados){

                List listaString=generarResultados();
                this.frmSol.procesoFinalizado(listaString);
             }
             //System.out.println("Final");
        }catch(Exception e){
           this.mensajeDeError("Excepcion en proceso :"+functions.armarStackTrace(e), true, false, false);
           this.frmSol.procesoFinalizadoConError();
           return;
        }


    }

    public void pausate() {
        if(ejecutando){
        this.pausado = true;
        this.ejecutando = false;
        }
    }

    public void reanudate() {
        if(pausado){
        this.pausado = false;
        this.ejecutando = true;
        try {
            bloqueo.liberate();
            //        reanudar.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    private void pausa() {
        try {

            bloqueo.espera();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void finalizate() {
        
        pausate();
        this.finalizado = true;
        reanudate();
        
//       this.poblacion.getListaDeCromosomas();



    }

    public Random getRandomizer() {
        return randomizer;
    }

    public void mensajeDeAdvetencia(String message, boolean aPantalla, boolean aLogDeEjecucion, boolean aInformeDeEjecucionDelProceso) {
        
        this.frmSol.mostrarMensaje("Advertencia:" + message);
    }

    public void mensajeDeError(String message, boolean aPantalla, boolean aLogDeEjecucion, boolean aInformeDeEjecucionDelProceso) {
        pausate();
        this.frmSol.mostrarMensaje("Error:" + message);
        finalizate();
    }

    void llenarElementos() {

        ElementoParametrizable elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(FuncionDeAptitud.class);

        if (elto == null) {
            this.funcionDeAptitud = null;
        } else {
            this.funcionDeAptitud = (FuncionDeAptitud) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(CruzamientoInterface.class);
        if (elto == null) {
            this.operadorCruzamiento = null;
        } else {
            this.operadorCruzamiento = (CruzamientoInterface) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(SeleccionInterface.class);
        if (elto == null) {
            this.operadorSeleccion = null;
        } else {
            this.operadorSeleccion = (SeleccionInterface) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(MutacionInterface.class);
        if (elto == null) {
            this.operadorMutacion = null;
        } else {
            this.operadorMutacion = (MutacionInterface) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(FabricaDeCromosomasInterface.class);
        if (elto == null) {
            this.fabricaDeCromosomas = null;
        } else {
            this.fabricaDeCromosomas = (FabricaDeCromosomasInterface) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(HelperInterface.class);
        if (elto == null) {
            this.helper = null;

        } else {

            this.helper = (HelperInterface) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(FormatoInformeInterface.class);

        if (elto == null) {
            this.formatoInformeResultados = null;
        } else {
            this.formatoInformeResultados = (FormatoInformeInterface) elto;
        }

        elto = this.manejadorDeElementos.getElementoInstanciadoSegunSuInterfaz(ParoInterface.class);
        if (elto == null) {
            this.paro = null;
        } else {
            this.paro = (ParoInterface) elto;
        }

    }

    void vaciarElementos() {

        this.paro = null;
        this.formatoInformeResultados = null;
        this.helper = null;
        this.fabricaDeCromosomas = null;
        this.operadorMutacion = null;
        this.operadorSeleccion = null;
        this.operadorCruzamiento = null;
        this.funcionDeAptitud = null;
    }

    public void setCantidadDeCromosomasMutados(int cantidadDeCromosomasMutados) {
        this.cantidadDeCromosomasMutados=cantidadDeCromosomasMutados;
    }

    private void comienzoEjecucion() {
            

            this.nroCiclo = 0;

            this.poblacion = new Poblacion();

            this.poblacion.generarPoblacionInicial(this.fabricaDeCromosomas, cantidadPoblacionInicial);
            
            this.ejecutando = true;
            
//            List listaString = this.formatoInformeResultados.ejecutar(this.poblacion.getListaDeCromosomas());
            
//            System.out.println(listaString);
            
            this.frmSol.procesoEjecutando();
            
    }       

    public List generarResultados() {
             List listaString=null;
             if(this.formatoInformeResultados!=null){
                 
                 listaString=this.formatoInformeResultados.ejecutar(this.poblacion.getListaDeCromosomas());
             }
             
             return listaString;
    }

    public void finalizateSinResultados() {
        this.enviarResultados=false;
    }
}
