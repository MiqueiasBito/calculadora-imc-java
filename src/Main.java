import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Lista que armazenará várias pessoas cadastradas
        ArrayList<Pessoa> pessoas = new ArrayList<>();

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

        // Adiciona a pessoa criada dentro da lista
        pessoas.add(pessoa1);

        // Percorre a lista e mostra cada pessoa cadastrada
        for (Pessoa pessoa : pessoas) {
            System.out.println("\n=== Pessoa cadastrada ===");
            System.out.println("Nome: " + pessoa.nome);
            System.out.println("Idade: " + pessoa.idade);
            System.out.println("Peso: " + pessoa.peso);
            System.out.println("Altura: " + pessoa.altura);
            System.out.println("IMC: " + pessoa.calcularIMC());
            System.out.println("Classificação: " + pessoa.classificarIMC());
        }
        entrada.close();
    }
}
// new Pessoa (...) = cria o objeto
// pessoa.add(...) = guarda o objeto na lista
// for (...) = percorre a lista