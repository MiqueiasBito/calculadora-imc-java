import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static int lerInteiro(Scanner entrada, String mensagem) throws EntradaInvalidaException{
        System.out.println(mensagem);

        try {
            return Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException erro) {
            throw new EntradaInvalidaException("Valor inválido. Digite um número inteiro.");
        }
    }

    public static int lerInteiroPositivo(Scanner entrada, String mensagem) throws EntradaInvalidaException {
        int valor = lerInteiro(entrada, mensagem);

        if (valor <= 0) {
            throw new EntradaInvalidaException("Valor inválido. Digite um número inteiro maior que zero.");
        }

        return valor;
    }

    public static double lerDouble(Scanner entrada, String mensagem) throws EntradaInvalidaException {
        System.out.println(mensagem);

        try {
            String texto = entrada.nextLine().trim().replace(",", ".");
            double valor = Double.parseDouble(texto);

            if (!Double.isFinite(valor) || valor <= 0) {
                throw new EntradaInvalidaException("Valor inválido. Digite um número maior que zero.");
            }

            return valor;
        } catch (NumberFormatException erro) {
            throw new EntradaInvalidaException("Valor inválido. Digite um número decimal.");
        }
    }

    public static int escolherPessoa (ArrayList<Pessoa> pessoas, Scanner entrada) {
        while (true) {
            if (pessoas.isEmpty()) {
                System.out.println("Nenhuma pessoa cadastrada.");
                return -1;
            }
            
            System.out.println("\n--- Pessoas cadastradas ---");

            for (int i = 0; i < pessoas.size(); i++) {
                System.out.println((i + 1) + " - " + pessoas.get(i).nome);
            }

            // System.out.println("Digite o número da pessoa ou 0 para voltar: ");
            int opcao;

            try {
                opcao = lerInteiro(entrada, "Digite o número da pessoa ou 0 (zero) pra voltar: ");
            } catch (EntradaInvalidaException erro) {
                System.out.println(erro.getMessage());
                continue;
            }

            if (opcao == 0) {
                return -1;
            }

            int indice = opcao - 1;

            if (indice >= 0 && indice < pessoas.size()) {
                return indice;
            }

            System.out.println("Número inválido. Tente novamente.");
        }
    }
    
    public static void main(String[] args) {

        // Scanner usado para ler entradas de dados do usuário
        Scanner entrada = new Scanner(System.in);

        //Lista que armazenará várias pessoas cadastradas
        HistoricoIMC historico = new HistoricoIMC();
        ArrayList<Pessoa> pessoas = historico.getPessoas();

        // Variável que controla a opção escolhida no menu
        int opcao = -1;

        // O menu continuará aparecendo enquando o usuário não escolher 0 (zero)
        while (opcao != 0) {

            System.out.println("\n=== Calculadora de IMC ===");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Remover pessoa");
            System.out.println("4 - Editar pessoa");
            System.out.println("5 - Buscar pessoa");
            System.out.println("6 - Cadastrar atleta");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            try {
                opcao = entrada.nextInt();
                entrada.nextLine(); // limpa a quebra de linha deixada pelo nextInt
            } catch (InputMismatchException possivelErro) {
                System.out.println("Opção inválida. Digite apenas números.");
                entrada.nextLine(); // limpa o texto inválido digitado
                continue; // volta para o início do menu
            }
                if (opcao == 1) {
                    try {

                System.out.println("Digite o nome: ");
                String nome = entrada.nextLine();

                // System.out.println("Digite a idade: ");
                // int idade = entrada.nextInt();
                int idade = lerInteiroPositivo(entrada, "Digite a idade: ");

                // System.out.println("Digite o peso em kg. Exemplo: 70,5: ");
                // double peso = entrada.nextDouble();
                double peso = lerDouble(entrada, "Digite o peso em kg. Exemplo: 70,5: ");

                // System.out.println("Digite a altura em metros. Exemplo: 1,76: ");
                // double altura = entrada.nextDouble();
                double altura = lerDouble(entrada, "Digite a altura em metros. Exemplo: 1,76: ");

                // Caso o usuário digite 178 em verz de 1,76,
                // o programa converte centímetros para metros

                if (altura > 3) {
                    altura = altura / 100;
                }

                // Cria um objeto Pessoa com os dados digitados
                Pessoa pessoa = new Pessoa(nome, idade, peso, altura);

                // Adiciona a pessoa criada dentro da lista
                historico.adicionarPessoa(pessoa);

                System.out.println("Pessoa cadastrada com sucesso!");
                  
                } catch (EntradaInvalidaException erro) {
                System.out.println(erro.getMessage());
            }   
            
        } else if (opcao == 2) {

            if (pessoas.isEmpty()) {
                System.out.println("Nenhuma pessoa cadastrada.");
            } else {
                System.out.println("Total de pessoas cadastradas: " + pessoas.size());

                //Percorre a lista e mostra cada pessoa cadastrada
                for (int i = 0; i < pessoas.size(); i++) {
                    Pessoa pessoa = pessoas.get(i);

                    System.out.println("\n=== Pessoa cadastrada ===");
                    System.out.println("Índice: " + i);
                    System.out.println("Nome: " + pessoa.nome);
                    System.out.println("Idade: " + pessoa.idade);
                    System.out.println("Peso: " + pessoa.peso);
                    System.out.println("Altura: " + pessoa.altura);
                    System.out.println("IMC: " + pessoa.calcularIMC());
                    System.out.println("Classificação: " + pessoa.classificarIMC());
                }
            }
        } else if (opcao == 3) {
            
            int indiceRemover = escolherPessoa(pessoas, entrada);

            if (indiceRemover != -1) {
                Pessoa pessoaRemovida = pessoas.remove(indiceRemover);
                System.out.println("Pessoa removida com sucesso: " + pessoaRemovida);
            }

        } else if (opcao == 4) {

            int indiceEditar = escolherPessoa(pessoas, entrada);

            if (indiceEditar != -1) {
                Pessoa pessoa = pessoas.get(indiceEditar);

                System.out.println("Novo nome: ");
                pessoa.nome = entrada.nextLine();

                try {
                    pessoa.idade = lerInteiroPositivo(entrada, "Nova idade: ");
                    pessoa.peso = lerDouble(entrada, "Novo peso: ");
                    pessoa.altura = lerDouble(entrada, "Nova altura: ");
                
                if (pessoa.altura > 3) {
                    pessoa.altura = pessoa.altura / 100;
                }
                            
                System.out.println("Pessoa editada com sucesso!");
            } catch (EntradaInvalidaException erro) {
                System.out.println(erro.getMessage());
            }
            }
        } else if (opcao == 5) {

            if (pessoas.isEmpty()) {

                System.out.println("Não existem pessoas cadastradas.");

            } else {

                System.out.println("Digite o nome que deseja buscar:");
                String nomeBuscado = entrada.nextLine();

                boolean encontrou = false;

                for (Pessoa pessoa : pessoas) {

                    if (pessoa.nome.equals(nomeBuscado)) {

                        System.out.println("\n=== Pessoa encontrada ===");
                        System.out.println("Nome: " + pessoa.nome);
                        System.out.println("Idade: " + pessoa.idade);
                        System.out.println("Peso: " + pessoa.peso);
                        System.out.println("Altura: " + pessoa.altura);
                        System.out.println("IMC: " + pessoa.calcularIMC());
                        System.out.println("Classificação: " + pessoa.classificarIMC());

                        encontrou = true;
                    }
                }

                if (!encontrou) {
                    System.out.println("Pessoa não encontrada");
                }
            }
         } else if (opcao == 6) {
            try {

            System.out.println("Digite o nome do atleta: ");
            String nome = entrada.nextLine();

            // System.out.println("Digite a idade: ");
            // int idade = entrada.nextInt();
            int idade = lerInteiroPositivo(entrada, "Digite a idade: ");

            // System.out.println("Digite o peso em kg. Exemplo: 70,5: ");
            // double peso = entrada.nextDouble();
            double peso = lerDouble(entrada, "Digite o peso em kg. Exemplo: 70,5: ");

            // System.out.println("Digite a altura em metros. Exemplo: 1,76: ");
            // double altura = entrada.nextDouble();
            double altura = lerDouble(entrada, "Digite a altura em metros. Exemplo: 1,76: ");

            if (altura > 3) {
                altura = altura / 100;
            }

            System.out.println("Digite o esporte: ");
            String esporte = entrada.nextLine();

            Atleta atleta = new Atleta(nome, idade, peso, altura, esporte);

            historico.adicionarPessoa(atleta);

            System.out.println("Atleta cadastrado com sucesso!");
        } catch (EntradaInvalidaException erro) {
            System.out.println(erro.getMessage());
        } 
    } else if (opcao == 0) {

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
// TODO: Melhorar validação para impedir erro caso o usuário digite texto
//opcao = entrada.nextInt();
//entrada.nextLine();
