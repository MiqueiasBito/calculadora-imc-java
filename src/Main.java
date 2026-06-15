import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Calculadora de IMC ===");

        System.out.println("Digite o nome: ");
        String nome = entrada.nextLine();

        System.out.println("Digite a idade: ");
        int idade = entrada.nextInt();

        System.out.println("Digite o peso: ");
        double peso = entrada.nextDouble();

        // Lê a altura digitada pelo usuário
        System.out.println("Digite sua altura em metros. Exemplo: 1,76: ");
        double altura = entrada.nextDouble();

        // Se o usuário digitar 176, o programa entende que foi em centímetros
        // Caso o usuário digite 176 em vez de 1,76
        // O programa converte para de centímetros para metros
        if (altura > 3) {
            altura = altura / 100;
        }
        
        Pessoa pessoa1 = new Pessoa(nome, idade, peso, altura);

        System.out.println("\n=== Resultado ===");
        System.out.println("Nome: " + pessoa1.nome);
        System.out.println("Idade: " + pessoa1.idade);
        System.out.println("Peso: " + pessoa1.peso);
        System.out.println("Altura: " + pessoa1.altura);

        double imc = pessoa1.calcularIMC();

        System.out.println("IMC: " + imc);
        System.out.println("Classificação: " + pessoa1.classificarIMC());

        entrada.close();
    }
}
