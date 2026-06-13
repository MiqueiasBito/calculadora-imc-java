public class Main {
    
    public static void main(String[] args) {
        
        Pessoa pessoa1 = new Pessoa();

        pessoa1.nome = "Miqueias";
        pessoa1.idade = 23;
        pessoa1.peso = 86.0;
        pessoa1.altura = 1.80;

        System.out.println("Nome: " + pessoa1.nome);
        System.out.println("Idade: " + pessoa1.idade);
        System.out.println("Peso: " + pessoa1.peso);
        System.out.println("Altura: " + pessoa1.altura);

        double imc = pessoa1.calcularIMC();

        System.out.println("IMC: " + imc);
        System.out.println("Classificação: " + pessoa1.classificarIMC());
    }
}
