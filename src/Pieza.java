
public abstract class Pieza {
    protected String Nombre;
    protected int Rango;
    protected BANDO Bando;
    protected boolean Reveleado;

    public Pieza(String Nombre, int Rango, BANDO Bando, boolean Reveleado) {
        this.Nombre = Nombre;
        this.Rango = Rango;
        this.Bando = Bando;
        this.Reveleado = Reveleado;
    }
    public abstract boolean puedeMoverse();

    public String getNombre() {
        return Nombre;
    }

    public int getRango() {
        return Rango;
    }

    public BANDO getBando() {
        return Bando;
    }

    public boolean isReveleado() {
        return Reveleado;
    }

    public void setReveleado(boolean Reveleado) {
        this.Reveleado = Reveleado;
    }
    
}
