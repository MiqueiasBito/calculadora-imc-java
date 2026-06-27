public abstract class PessoaBase {

    // Atributos comuns a qualquer pessoa do sistema
    protected String nome;
    protected int idade;
    protected double peso;
    protected double altura;

    // Construtor da classe base
    public PessoaBase(String nome, int idade, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }
}