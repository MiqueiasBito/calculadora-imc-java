import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        // Scanner usado para ler entradas de dados do usuário
        Scanner entrada = new Scanner(System.in);

        //Lista que armazenará várias pessoas cadastradas
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        // Variável que controla a opção escolhida no menu
        int opcao = -1;

        // O menu continuará aparecendo enquando o usuário não escolher 0 (zero)
        while (opcao != 0) {

            System.out.println("\n=== Calculadora de IMC ===");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Remover pessoa");
            System.out.println("4 - Editar pessoa");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine(); // limpa a quebra de linha deixada pelo nextInt

            if (opcao == 1) {

                System.out.println("Digite o nome: ");
                String nome = entrada.nextLine();

                System.out.println("Digite a idade: ");
                int idade = entrada.nextInt();

                System.out.println("Digite o peso em kg. Exemplo: 70,5: ");
                double peso = entrada.nextDouble();

                System.out.println("Digite a altura em metros. Exemplo: 1,76: ");
                double altura = entrada.nextDouble();

                // Caso o usuário digite 178 em verz de 1,76,
                // o programa converte centímetros para metros

                if (altura > 3) {
                    altura = altura / 100;
                }

                // Cria um objeto Pessoa com os dados digitados
                Pessoa pessoa = new Pessoa(nome, idade, peso, altura);

                // Adiciona a pessoa criada dentro da lista
                pessoas.add(pessoa);

                System.out.println("Pessoa cadastrada com sucesso!");
            
        } else if (opcao == 2) {

            if (pessoas.isEmpty()) {
                System.out.println("Nenhuma pessoa cadastrada.");
            } else {

                //Percorre a lista e mostra cada pessoa cadastrada
                for (int i = 0; i < pessoas.size(); i++) {
                    Pessoa pessoa = pessoas.get(i);

                    System.out.println("\n=== Pessoa cadastrada ===");
                    System.out.println("Nome: " + pessoa.nome);
                    System.out.println("Idade: " + pessoa.idade);
                    System.out.println("Peso: " + pessoa.peso);
                    System.out.println("Altura: " + pessoa.altura);
                    System.out.println("IMC: " + pessoa.calcularIMC());
                    System.out.println("Classificação: " + pessoa.classificarIMC());
                }
            }
        } else if (opcao == 3) {
            if (pessoas.isEmpty()) {

                System.out.println("Não existem pessoas cadastradas.");
                
            } else {

                // Mostra as pessoas com seus indices
                for (int i = 0; i < pessoas.size(); i++) {

                    Pessoa pessoa = pessoas.get(i);

                    System.out.println(i + " - " + pessoa.nome);
                }

                System.out.println("Digite o índice que deseja remover: ");

                int indice = entrada.nextInt();

                pessoas.remove(indice);

                System.out.println("Pessoa removida com sucesso!");
            }           
        } else if (opcao == 4) {

            if (pessoas.isEmpty()) {

                System.out.println("Não existem pessoas cadastradas.");

            } else {

                // Mostra as pessoas cadastradas com seus índices
                for (int i = 0; i < pessoas.size(); i++) {
                    Pessoa pessoa = pessoas.get(i);
                    System.out.println(i + " - " + pessoa.nome);
                }

                System.out.println("Digite o índice da pessoa que deseja editar: ");
                int indice = entrada.nextInt();
                entrada.nextLine(); // limpa a quebra de linha

                if (indice >= 0 && indice < pessoas.size()) {
                    
                    // Pega a pessoa escolhida na lista
                    Pessoa pessoa = pessoas.get(indice);

                    System.out.println("Digite o novo nome: ");
                    pessoa.nome = entrada.nextLine();

                    System.out.println("Digite a nova idade: ");
                    pessoa.idade = entrada.nextInt();

                    System.out.println("Digite o novo peso em kg. Exemplo: 70,5: ");
                    pessoa.peso = entrada.nextDouble();

                    System.out.println("Digite a nova altura em metros. Exemplo: 1,76: ");
                    pessoa.altura = entrada.nextDouble();

                    // Se o usuário digitar altura em centímetros, converte para metros
                    if (pessoa.altura > 3) {
                        pessoa.altura = pessoa.altura / 100;
                    }

                    System.out.println("Pessoa editada com sucesso!");

                } else {

                    System.out.println("Índice inválido.");

                }
            }      
        }
        else if (opcao == 0) {

            System.out.println("Encerrando o programa...");
            
        } else {

            System.out.println("Opção inválida.");
        }
    }
        entrada.close();
    }
}
// new Pessoa (...) = cria o objeto
// pessoa.add(...) = guarda o objeto na lista
// for (...) = percorre a lista