public class Pessoa {

    // Atributos; responsavel por características que toda pessoa terá
    String nome;
    int idade;
    double peso;
    double altura;

    // Construtor: usado para criar uma pessoa já com dados preenchidos
    public Pessoa (String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    // Método responsável por calcular o IMC da pessoa
    double calcularIMC() {
        return peso / (altura * altura);
    }

    // Método responsável por classificar o IMC calculado
    String classificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau I";
        } else if (imc < 40) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}
