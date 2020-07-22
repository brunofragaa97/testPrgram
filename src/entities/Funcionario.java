package entities;
public class Funcionario {

	private Integer id;
	private String name;
	private Double salary;
	
	public Funcionario() {
		
	}
	
	public Funcionario(Integer id, String name, Double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
		//Salario vai receber o resultado de salario * porcentagem / 100, é isso que quer dizer o metodo
	public void aumentarSalario(Double porcentagem) {
		salary += salary *  porcentagem / 100.0;  
		
	}
	
	@Override
	public String toString(){
		return
			"Id: " + id +
		    ", Name: " + name +
		    ", R$" + String.format("%.2f",  salary); 
		
	}
	
	
	
	
	
}
