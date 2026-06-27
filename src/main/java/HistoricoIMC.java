import java.util.ArrayList;

public class HistoricoIMC {

    private ArrayList<Pessoa> pessoas;

    public HistoricoIMC() {
        pessoas = new ArrayList<>();
    }
    
    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public int getTotalPessoas() {
        return pessoas.size();
    }
}
