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

		System.out.print("Quantos funcion�rios v�o ser registrados ? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.println();
			System.out.println("Funcion�rio #" + (i + 1) + ": ");

			System.out.print("Id: ");
			Integer idFuncionario = sc.nextInt();

			System.out.print("Nome: ");
			sc.nextLine();
			String nomeFuncionario = sc.nextLine();

			System.out.print("Sal�rio: ");
			Double salarioFuncionario = sc.nextDouble();

			/*
			 * Instanciando um novo objeto funcion�rio com o construtor de 3 argumentos,
			 * preenchendo os dados (idFuncionario, nomeFuncionario, salarioFuncionario) com
			 * os dados digitados acima
			 */
			Funcionario func = new Funcionario(idFuncionario, nomeFuncionario, salarioFuncionario);

			// Adicionando o objeto funcionario na lista, por meio da vari�vel list
			// (declarada acima)
			list.add(func);

		}

		System.out.println();
		System.out.print("Entre com o ID do funcion�rio que vai ter o sal�rio alterado: ");
		int idAumentaSalario = sc.nextInt();
		
		/* Explica��o dos passos seguintes:
		 * 
		 * Ap�s pedir para que digite o ID do funcion�rio � criado uma variavel Integer (posicao) 
		 * Onde, a variavel posicao recebe o resultado da fun��o posicaoIdFuncionario()
		 * 
		 * Um IF � criado afim de verificar se o ID foi encontrado:
		 * 
		 * Se n�o for encontrado e a fun��o retornar null, o programa retorna uma mensagem "Este Id n�o existe"
		 * 
		 * Se for encontrado, ele l� a porcentagem, acessa a lista, pega o funcion�rio que esta na posicao encontrada e ent�o, 
		 * chama a fun��o para aumentar o salario do funcionario, isso � o mesmo que list.get(posicao).aumentaSalario(porcentagem);
		 * */
		
		Integer posicao = posicaoIdFuncionario(list, idAumentaSalario);

		if (posicao == null) {
			System.out.println("Este Id n�o existe");
		} else {
			System.out.print("Entre com a porcentagem: ");
			double porcentagem = sc.nextDouble();
			list.get(posicao).aumentaSalario(porcentagem);
		}

		System.out.println();
		System.out.println("Lista de funcion�rios: ");
		
		/*Explica��o do ForEach
		 * Foi criado um toString para imprimir os funcion�rios
		 * O ForEach significa: Para cada Funcionario func, na lista list, ir� imprimir o func
		 * */
		
		for (Funcionario func : list) {
			System.out.println(func);
		}

	}

	/*
	 * Explica��o da fun��o
	 * 
	 * FUN��O Auxiliar definida como static, pois, para chamar uma fun��o da mesma classe, essa sendo static, a fun��o deve ser static tamb�m;
	 * 
	 * A FUN��O deve retornar a posi��o do id na lista;
	 * 
	 * O FOR abaixo significa: Enquanto i for menor que o tamanho da lista, os pasos s�o executados;
	 * 
	 * O IF est� testando se o Id do elemento da posi��o i � igual ao Id passado no par�metro - (list.get(i).getId(), isto � igual a: 
	 * Se o elemento da lista na posi��o i e seu Id for igual ao Id que foi pasado como argumento, se for,quer dizer que a posi��o � a posi��o i
	 * 
	 * Se o for se esgotar e n�o retornar nada, ele retornar� o valor nulo, pois a fun��o retorna um Integer e n�o um int
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
