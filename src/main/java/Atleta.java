public class Atleta extends Pessoa {
    // Atributo exclusivo da classe Atleta
    String esporte;

    // Construtor da calsse Atleta
    public Atleta(String nome, int idade, double peso, double altura, String esporte) {
        super(nome, idade, peso, altura);
        this.esporte = esporte;
    }

    // Sobrescrita do método classificarIMC
    // Atletas podem ter mais massa muscular, então a classificação é diferente
    @Override
    public String classificarIMC() {
        double imc = calcularIMC();

        if (imc < 20) {
            return "Atleta abaixo do peso";
        } else if (imc < 27) {
            return "Atleta com peso adequado";
        } else if (imc < 30) {
            return "Atleta com atenção ao peso";
        } else {
            return "Atleta acima do peso";
        }
    }

    // Método exclusivo do atleta
    public void mostrarEsporte() {
        System.out.println("Esporte: " + esporte);
    }
}
