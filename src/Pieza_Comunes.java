
public class Pieza_Comunes extends Pieza {

    public Pieza_Comunes(String Nombre, int Rango, BANDO Bando, String Icono) {
        super(Nombre, Rango, Bando, Icono);
    }

    @Override
    public boolean puedeMoverse() {
        return true;
    }
    
}
