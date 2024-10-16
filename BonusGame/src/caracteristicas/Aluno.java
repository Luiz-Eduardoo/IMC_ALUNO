package caracteristicas;
	// classe Aluno que herda caracteristicas da classe Pessoa
	public class Aluno extends Pessoa {
		// atributos específicos
	    protected int nota;
	    protected int percentualPresença;
	    
	    // metodo construtor para montar as caracteristicas
	    public Aluno(String nome, String cpf, double peso, double altura, int nota, int percentualPresença) {
	        super(nome, cpf, peso, altura); // "super" para pegar os atributos herdados da classe Pessoa
	        setNota(nota); // set para fazer a validação
	        setPercentualPresença(percentualPresença);
	    }
	    // método get para acessar o atributo
	    public int getNota() {
	        return nota;
	    }
	    // método set para modificar o valor do atributo
	    public void setNota(int nota) {
	        if (nota < 0) { 
	            throw new IllegalArgumentException("A nota não pode ser menor que 0"); // se a nota for menor que 0 vai dar erro
	        }
	        this.nota = nota;

	    }

	    public int getPercentualPresença() {
	        return percentualPresença;
	    }

	    public void setPercentualPresença(int percentualPresença) {
	        if (percentualPresença < 0) {
	            throw new IllegalArgumentException("O Percentual de Presença não pode ser menor que 0"); // se o percentual for menor que 0 vai dar erro
	        }
	        this.percentualPresença = percentualPresença;
	    }
	    

	    // metodo para formatar a string e adicionar as caracteristicas especificas
	    public String descricao() {
	        return super.descricao() +  // "super" chama a outra formatação da classe Pessoa e adiciona as caracteristicas específicas
	               "\nNota do Aluno: " + nota + "\nPercentual de Presença: " + percentualPresença + "%" + "\nSituação do Aluno: " + FuncoesUteis.verificaNota(getNota(), getPercentualPresença());
	    }
	}

