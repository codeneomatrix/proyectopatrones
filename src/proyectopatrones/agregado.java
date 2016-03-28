package proyectopatrones;

public interface agregado {
    public elemento getValor(int pos);
    public void colocar(int pos, elemento valor);
    public int dimension();
    public iiterador creariterador();
}
