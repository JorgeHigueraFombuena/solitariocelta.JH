package es.upm.miw.SolitarioCelta;

public class Resultado {

    private int _id;
    private String _nombreJugador;
    private int _puntuacion;
    private String _tablero;
    private long _tiempo;

    public Resultado(int _id, String _nombreJugador, int _puntuacion, String _tablero, long _tiempo) {
        this._id = _id;
        this._nombreJugador = _nombreJugador;
        this._puntuacion = _puntuacion;
        this._tablero = _tablero;
        this._tiempo = _tiempo;
    }

    public Resultado(){}

    public int get_id() {
        return _id;
    }

    public String get_nombreJugador() {
        return _nombreJugador;
    }

    public int get_puntuacion() {
        return _puntuacion;
    }

    public String get_tablero() {
        return _tablero;
    }

    public long get_tiempo() {
        return _tiempo;
    }

    public String serialize(){
        return "{" + _id + ";" + _nombreJugador + ";" + _puntuacion + ";" + _tablero + ";" + _tiempo + "}";
    }

    public void deserialize(String value){
        value = value.substring(1,value.length()-1);
        String[] values = value.split(";");
        this._id = Integer.valueOf(values[0]);
        this._nombreJugador = values[1];
        this._puntuacion = Integer.valueOf(values[2]);
        this._tablero = values[3];
        this._tiempo = Long.valueOf(values[4]);
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "_id=" + _id +
                ", _nombreJugador='" + _nombreJugador + '\'' +
                ", _puntuacion=" + _puntuacion +
                ", _tablero='" + _tablero + '\'' +
                ", _tiempo=" + _tiempo +
                '}';
    }
}
