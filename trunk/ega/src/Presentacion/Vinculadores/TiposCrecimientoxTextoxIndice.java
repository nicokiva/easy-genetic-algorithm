package Presentacion.Vinculadores;

import enums.TiposCrecimiento;
import java.util.ArrayList;

public class TiposCrecimientoxTextoxIndice {
    private static ArrayList<TipoCrecimientoxTextoxIndice> TCxTxI = new ArrayList<TipoCrecimientoxTextoxIndice>();
    
    private static boolean CrecimientosNoIngresados(){
        return TiposCrecimientoxTextoxIndice.TCxTxI.isEmpty();
    }
    
    
        public static void LlenarTiposCrecimiento(){
        if (TiposCrecimientoxTextoxIndice.CrecimientosNoIngresados()){
            TiposCrecimientoxTextoxIndice.TCxTxI.add(new TipoCrecimientoxTextoxIndice(TiposCrecimiento.Fijo, 0, "fixed"));
            TiposCrecimientoxTextoxIndice.TCxTxI.add(new TipoCrecimientoxTextoxIndice(TiposCrecimiento.Creciente, 1, "up"));
            TiposCrecimientoxTextoxIndice.TCxTxI.add(new TipoCrecimientoxTextoxIndice(TiposCrecimiento.Decreciente, 2, "down"));
        }
    }
    
    public static int ObtenerIndice(TiposCrecimiento TipoCrecimiento){
        TiposCrecimientoxTextoxIndice.LlenarTiposCrecimiento();
        for (TipoCrecimientoxTextoxIndice TC : TiposCrecimientoxTextoxIndice.TCxTxI){
            if (TC.ObtenerTipoCrecimiento() == TipoCrecimiento){
                return TC.ObtenerIndice();
            }
        }
        
        return 0;
    }
    
    public static int ObtenerIndice(String Texto){
        TiposCrecimientoxTextoxIndice.LlenarTiposCrecimiento();
        for (TipoCrecimientoxTextoxIndice TC : TiposCrecimientoxTextoxIndice.TCxTxI){
            if (TC.ObtenerTexto().equals(Texto)){
                return TC.ObtenerIndice();
            }
        }
        
        return 0;
    }
    
    public static TiposCrecimiento ObtenerTipoCrecimiento(Integer Indice){
        TiposCrecimientoxTextoxIndice.LlenarTiposCrecimiento();
        for (TipoCrecimientoxTextoxIndice TC : TiposCrecimientoxTextoxIndice.TCxTxI){
            if (TC.ObtenerIndice() == Indice){
                return TC.ObtenerTipoCrecimiento();
            }
        }
        
        return TiposCrecimiento.Fijo;
    }
    
    public static TiposCrecimiento ObtenerTipoCrecimiento(String Texto){
        TiposCrecimientoxTextoxIndice.LlenarTiposCrecimiento();
        for (TipoCrecimientoxTextoxIndice TC : TiposCrecimientoxTextoxIndice.TCxTxI){
            if (TC.ObtenerTexto().equals(Texto)){
                return TC.ObtenerTipoCrecimiento();
            }
        }
        
        return TiposCrecimiento.Fijo;
    }
    
    public static String ObtenerTexto(TiposCrecimiento TipoCrecimiento){
        TiposCrecimientoxTextoxIndice.LlenarTiposCrecimiento();
        for (TipoCrecimientoxTextoxIndice TC : TiposCrecimientoxTextoxIndice.TCxTxI){
            if (TC.ObtenerTipoCrecimiento() == TipoCrecimiento){
                return TC.ObtenerTexto();
            }
        }
        
        return "";
    }
    
    public static String ObtenerTexto(Integer Indice){
        TiposCrecimientoxTextoxIndice.LlenarTiposCrecimiento();
        for (TipoCrecimientoxTextoxIndice TC : TiposCrecimientoxTextoxIndice.TCxTxI){
            if (TC.ObtenerIndice() == Indice){
                return TC.ObtenerTexto();
            }
        }
        
        return "";
    }
    
}
