package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		byte op, i;
		byte contagemEmpregado = 1;
		String name;
		Double salary;
		
//Cria a lista do tipo Funcionario (classe personalizada), Cada posição sera da classee funcionario
						
		List<Funcionario> list = new ArrayList<>();									
						

		
		System.out.println("Quantos empregados vão ser registrados? ");
		op = sc.nextByte();
		
		for (i = 0; i < op; i++ ) {
			System.out.println("\nEmpregado #" + (i + 1) + ":");
			System.out.print  ("Id: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {	
				System.out.print("\nId already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Salary: ");
			salary = sc.nextDouble();
		
			Funcionario fun = new Funcionario(id, name, salary);
			list.add(fun);
}
/*-----------------------------------------------------------------------------------------------------
			OUTRA MANEIRA PARA ADCIONAR UM NOVO OBJETO EM ALGUMA POSICAO NA LISTA
  
		>>>		listaFuncionarios.add(new Funcionario(id, name, salary))
		   
-------------------------------------------------------------------------------------------------	  */
	
		
//Encotra o objeto na lista com base em uma informação. Por exp: ID  OBS:Da para fazer de outra forma

		System.out.print("\nEntre com o numero do ID do funcionario qual o salário será Aumentado: ");
		int id = sc.nextInt();
		Integer pos = posicao(list, id);
		if(pos == null) {
			System.out.println("Id não existe, operação Anulada");
		}
			else {
			System.out.print("Qual a porcentagem de aumento? ");
			double porcentagem = sc.nextDouble();
			list.get(pos).aumentarSalario(porcentagem);	
		}
		
		
/*--------------ESTE comando PERCORRE a lista e retorna o valor na posicao especificada, exp: ID---------
 
		Funcionario funcionarioAumento = list.stream().filter(x -> x.getId() ==  id).findFirst().orElse(null);
		if(funcionarioAumento == null) {
			System.out.println("Id não existe, operação Anulada");
		}
			else {
			System.out.println("Qual a porcentagem de aumento? ");
			double porcentagem = sc.nextDouble();
			funcionarioAumento.aumentarSalario(porcentagem);	
		}
	todo esse comando perccore e encontra o valor de um ID, basedo na posicao dele na lista
	
	
-------------------------------------------------------------------------------------------------------*/
		
//For EACH utilizado para percorrer a lista e mostrar os valores dos objetos criados
		System.out.println("\nLista de empregados:");
		for (Funcionario mostrarFuncionarios : list) {
			System.out.println(mostrarFuncionarios);
		}
		sc.close();
	}
	
	
	
//--------------------------MÉTODOS AULIXIARES NA EXECUÇÃO DO PROGRAMA----------------------------------
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
		
	
		//Este metodo encontra o ID em uma posicão na lista, varrendo a lista posicao por posicao
	public static Integer posicao(List<Funcionario> list,  int id){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}
