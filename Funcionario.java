public class Funcionario{
    private String nome;
    private double salario;


    public Funcionario(){
        this.nome="";
        this.salario=0;
    }

    public Funcionario(String nome, double salario){
        this.nome=nome;
        this.salario=salario;
    }

    public String getNome(){
        return this.nome;
    }

    public double getSalario(){
        return this.salario;
    }
}