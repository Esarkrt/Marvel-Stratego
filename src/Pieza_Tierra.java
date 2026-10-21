
public class Pieza_Tierra extends Pieza {

    public Pieza_Tierra( BANDO Bando,String Icono) {
        super("Earth", 0, Bando,Icono);
    }
    @Override
    public boolean puedeMoverse(){
        return false;
    }
}
