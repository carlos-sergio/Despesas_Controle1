package EX_SECAO10;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListEx {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // criar lista com strings
        List<String> list = new ArrayList<>();

        list.add("Jão");
        list.add("Maria");
        list.add("José"); /* Carlos ficará aqui*/
        list.add("Zé");

        // adicionando elemento na segunda posição, vai entrar no lugar de josé*
        list.add(2, "Carlos");

        //ver tamanho da lista
        System.out.println("tamanho da lista: " + list.size());
        System.out.println("----------------------------");
        // remover elemento da lista, maria
        list.remove(1);
        // ou... list.remove("Maria"); para buscar o valor exato para remover

        // usa-se o x para representar a lista
        // percorrer toda a lista
        System.out.println("lista sem o elemento da posição 1");
        System.out.println("----------------------------");
        for (String x: list){
            System.out.println(x);
        }
        System.out.println("-----------------------------");
        //remover elemento, lambda. x tal que o caractere char na posição 0 seja igual a C.
        list.removeIf(x -> x.charAt(0) == 'C');
        for (String x: list){
            System.out.println(x);
        }

        // filtrar nome que comece com letra especifica,
        List<String> result = list.stream().filter(x-> x.charAt(0) == 'Z').collect(Collectors.toList());
        System.out.println("----------------------------");
        for (String x: result) {
            System.out.println("filtro da letra Z: " + x);
        }

        System.out.println("-----------------------------");
        // encontrar posição de elemento: result.indexOf(elemento)
        System.out.println("posição de " + "Jão: " + list.indexOf("Jão") );
        // quando não encontra a posição do elemento ele retorna um negativo
        System.out.println("posição de " + "Marco: " + list.indexOf("Marco") );
        System.out.println("-----------------------------");
        System.out.println("----------------------------");
        // esse filtro i´ra retornar o primeiro nome da lista com a letra escolhida, caso contrário retorna null.
        // findfirst chama o primeiro elemento da string
        String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
        System.out.println("primeiro com a letra J: " + name);

        }
}
