import java.util.Scanner;
//Classe sistema: é aqui que irá armazenar os dados dos funcionarios, computar o valor da bonificação e imprimir os valores finais
//@author: Davi Braga

public class Sistema {
    private Funcionario funcionario[];
    private int cap;

    public Sistema(){ //Construtor da classe
        this.funcionario= new Funcionario[50];
        this.cap=0;
    }

    public void init(){ //inicio do programa, usei do/while para checar as condições do programa
        Scanner sc = new Scanner(System.in);
        String nome="";
        String tmp=""; //serve para checar se o usuario nao colocou letras ao escrever o salario
        String option="";
        Double salario=0.0;
        boolean err=false;
        do{
            System.out.println("INSIRA O NOME DO FUNCIONARIO: ");
            nome= sc.nextLine();
            err= checkNome(nome);
        }while(err==true);
        
        do{
            System.out.println("INSIRA O SALARIO DO FUNCIONARIO: ");
            tmp= sc.nextLine();
            err =checkSalario(tmp);
        }while(err==true);
        salario=Double.parseDouble(tmp); //converte o valor para double
        
        funcionario[this.cap]=new Funcionario(nome,salario);
        do{
            System.out.println("DESEJA ADICIONAR OUTRO FUNCIONARIO?   S/N");
            option=sc.nextLine();
            if (option.charAt(0)=='s'){
                this.cap+=1;
                if(cap==50){
                    System.out.println("ERRO: CAPACIDADE TOTAL DE FUNCIONARIOS NO SISTEMA LOTADA! \n");
                    result();
                }else{
                    init();
                }
            
            }else if (option.charAt(0)=='n'){
                result();
            }else{
                err=true;
                System.out.println("ERRO: COMANDO NÃO RECONHECIDO! \n");
            }
        }while(err==true); 
        sc.close();
        
    }

    private void result(){// Imprime os resultados das bonificações geradas por cada funcionario registrado
        double bo=0;
        for(int i=0;i<=this.cap;i++){
            bo=bonificacao(funcionario[i].getSalario());

            System.out.println("NOME: " + funcionario[i].getNome() +"\n");
            System.out.println("SALARIO: R$" + funcionario[i].getSalario() +"\n");
            System.out.println("BONIFICAÇÃO: R$" + bo +"\n");
            System.out.println("NOVO SALARIO: R$" + (funcionario[i].getSalario() + bo) +"\n \n \n");
        }
        System.out.println("OBRIGADO!! :) \n");
    }

    private double bonificacao(double s){ //Caclula a bonificação
        double resp=0;
        if(s<=1000){
            resp=s*0.2;
        }else if(s>1000 && s<=2000){
            resp=s*0.1;
        }else{
            resp=-(s*0.1);
        }
        return resp;
    }

    private boolean checkNome(String n){ //Checa se o nome está dentro dos parametros requeridos (apenas letras)
        n=n.toLowerCase();
        for(int i=0;i<n.length();i++){
            if((((int)n.charAt(i))>=97 && ((int)n.charAt(i))<=122)==false){
                System.out.println("ERRO: APENAS É PERMITIDO LETRAS NO NOME!! \n");
                return true;
            }
        }
        return false;
    }

    private boolean checkSalario(String n){ //Checa se o salario está dentro dos parametros requeridos (apenas numeros)
        n=n.toLowerCase();
        for(int i=0;i<n.length();i++){
            if(((((int)n.charAt(i))>=48 && ((int)n.charAt(i))<=57) || (n.charAt(i)=='.')) ==false){
                System.out.println("ERRO: APENAS É PERMITIDO NUMEROS!! \n");
                return true;
            }
        }
        return false;
    }

}
