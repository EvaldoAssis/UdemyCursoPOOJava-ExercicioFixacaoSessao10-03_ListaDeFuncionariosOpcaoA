package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Funcionario;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Declarando e instanciando uma lista
		List<Funcionario> list = new ArrayList<>();

		System.out.print("Quantos funcionários vão ser registrados ? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println();
			System.out.println("Funcionário #" + (i + 1) + ": ");

			System.out.print("Id: ");
			Integer idFuncionario = sc.nextInt();

			System.out.print("Nome: ");
			sc.nextLine();
			String nomeFuncionario = sc.nextLine();

			System.out.print("Salário: ");
			Double salarioFuncionario = sc.nextDouble();

			/*
			 * Instanciando um novo objeto funcionário com o construtor de 3 argumentos,
			 * preenchendo os dados (idFuncionario, nomeFuncionario, salarioFuncionario) com
			 * os dados digitados acima
			 */
			Funcionario func = new Funcionario(idFuncionario, nomeFuncionario, salarioFuncionario);

			// Adicionando o objeto funcionario na lista, por meio da variável list
			// (declarada acima)
			list.add(func);

		}

		System.out.println();
		System.out.print("Entre com o ID do funcionário que vai ter o salário alterado: ");
		int idAumentaSalario = sc.nextInt();
		
		/* Explicação dos passos seguintes:
		 * 
		 * Após pedir para que digite o ID do funcionário é criado uma variavel Integer (posicao) 
		 * Onde, a variavel posicao recebe o resultado da função posicaoIdFuncionario()
		 * 
		 * Um IF é criado afim de verificar se o ID foi encontrado:
		 * 
		 * Se não for encontrado e a função retornar null, o programa retorna uma mensagem "Este Id não existe"
		 * 
		 * Se for encontrado, ele lê a porcentagem, acessa a lista, pega o funcionário que esta na posicao encontrada e então, 
		 * chama a função para aumentar o salario do funcionario, isso é o mesmo que list.get(posicao).aumentaSalario(porcentagem);
		 * */
		
		Integer posicao = posicaoIdFuncionario(list, idAumentaSalario);

		if (posicao == null) {
			System.out.println("Este Id não existe");
		} else {
			System.out.print("Entre com a porcentagem: ");
			double porcentagem = sc.nextDouble();
			list.get(posicao).aumentaSalario(porcentagem);
		}

		System.out.println();
		System.out.println("Lista de funcionários: ");
		
		/*Explicação do ForEach
		 * Foi criado um toString para imprimir os funcionários
		 * O ForEach significa: Para cada Funcionario func, na lista list, irá imprimir o func
		 * */
		
		for (Funcionario func : list) {
			System.out.println(func);
		}

	}

	/*
	 * Explicação da função
	 * 
	 * FUNÇÃO Auxiliar definida como static, pois, para chamar uma função da mesma classe, essa sendo static, a função deve ser static também;
	 * 
	 * A FUNÇÃO deve retornar a posição do id na lista;
	 * 
	 * O FOR abaixo significa: Enquanto i for menor que o tamanho da lista, os pasos são executados;
	 * 
	 * O IF está testando se o Id do elemento da posição i é igual ao Id passado no parâmetro - (list.get(i).getId(), isto é igual a: 
	 * Se o elemento da lista na posição i e seu Id for igual ao Id que foi pasado como argumento, se for,quer dizer que a posição é a posição i
	 * 
	 * Se o for se esgotar e não retornar nada, ele retornará o valor nulo, pois a função retorna um Integer e não um int
	 */
	
	public static Integer posicaoIdFuncionario(List<Funcionario> list, int idAumentaSalario) {
		for (int i = 0; i < list.size(); i++) {
			//
			if (list.get(i).getIdFuncionario() == idAumentaSalario) {
				return i;
			}
		}

		return null;
	}

}
