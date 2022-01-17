import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Teste <T> {
    boolean teste(T t);
}

class Pessoa {
    public String nome;
    public Integer idade;
    Pessoa(String nome, Integer idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return this.nome;
    }
}

class FiltradorDePessoas {
    List <Pessoa> filtra (List<Pessoa> todas, Teste<Pessoa> matcher) {
        List <Pessoa> result = new ArrayList<>();
        for (Pessoa p: todas) {
            if(matcher.teste(p)) {
                result.add(p);
            }
        }
        return result;
    }
}

public class Lambda {
    public static void main(String [] args){
        List<Pessoa> pessoas = Arrays.asList( 
            new Pessoa("jose", 32),
            new Pessoa("ana", 31),
            new Pessoa("maria", 17), 
            new Pessoa("joao", 10));

        FiltradorDePessoas filtrador = new FiltradorDePessoas();

        Teste<Pessoa> criterio = (Pessoa p) -> { return p.idade > 18;};
        
        List<Pessoa> result = filtrador.filtra(pessoas, criterio);
        System.out.println(result);

    } 
}