
public class Pieza_Bomba extends Pieza {
    
    public Pieza_Bomba(String Nombre,BANDO bando,String Icono){
        super(Nombre,11, bando, Icono);
    }
    @Override
    public boolean puedeMoverse(){
        return false;
    }

}
