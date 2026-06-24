public class Atleta extends Pessoa {
    // Atributo exclusivo da classe Atleta
    String esporte;

    // Construtor da calsse Atleta
    public Atleta(String nome, int idade, double peso, double altura, String esporte) {
        super(nome, idade, peso, altura);
        this.esporte = esporte;
    }

    // Método exclusivo do atleta
    public void mostrarEsporte() {
        System.out.println("Esporte: " + esporte);
    }
}
