public abstract class Pieza implements Atacable {
    protected String Nombre;
    protected int Rango;
    protected BANDO Bando;
    protected boolean Revelado;
    protected boolean destruida; 

    public Pieza(String Nombre, int Rango, BANDO Bando, String Icono) {
        this.Nombre = Nombre;
        this.Rango = Rango;
        this.Bando = Bando;
        this.Revelado = false;
        this.destruida = false;
    }
    
    public abstract boolean puedeMoverse();

    
    @Override
    public void serAtacante(Pieza atacante) {
        
        this.Revelado = true;
    }

    @Override
    public boolean estaDestruida() {
        return this.destruida;
    }

    public void setDestruida(boolean destruida) {
        this.destruida = destruida;
    }

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

    public void setReveleado(boolean Revelado) {
        this.Revelado = Revelado;
    }
}