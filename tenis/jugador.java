public class jugador {
    
    private String nombre;
    private int puntaje;
    private int games;
    private int sets;

    public jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.games = 0;
        this.sets = 0;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerPuntaje() {
        return puntaje;
    }

    public void guardarPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int obtenerGames() {
        return games;
    }

    public void guardarGames(int games) {
        this.games = games;
    }

    public int obtenerSets() {
        return sets;
    }

    public void guardarSets(int sets) {
        this.sets = sets;
    }

    public void incrementarPuntaje(int valor) {
        this.puntaje += valor;
    }

    public void incrementarGames() {
        this.games += 1;
    }

    public void incrementarSets() {
        this.sets += 1;
    }

    public void resetearPuntaje() {
        this.puntaje = 0;
    }
}
