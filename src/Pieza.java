
public abstract class Pieza {
    protected String Nombre;
    protected int Rango;
    protected BANDO Bando;
    protected boolean Revelado;

    public Pieza(String Nombre, int Rango, BANDO Bando,String Icono) {
        this.Nombre = Nombre;
        this.Rango = Rango;
        this.Bando = Bando;
        this.Revelado = false;
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
        return Revelado;
    }

    public void setReveleado(boolean Reveleado) {
        this.Revelado = Reveleado;
    }
    
}
