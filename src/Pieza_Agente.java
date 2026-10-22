
public class Pieza_Agente extends Pieza_Comunes{
    
    public Pieza_Agente(String Nombre,BANDO bando, String icono){
        super(Nombre,1,bando,icono);
    }
    
    @Override
    public boolean puedeMoverse(){
        return true;
    }
}
