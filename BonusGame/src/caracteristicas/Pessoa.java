package caracteristicas;
// classe Pessoa com as caracteristicas Comuns
public class Pessoa {
	// atributos comuns
    protected String nome;
    protected String cpf;
    protected double peso;
    protected double altura;
    // Método construtor para montar as caracteristicas
    public Pessoa(String nome, String cpf, double peso, double altura) {
        setNome(nome); // set para fazer a validação
        setCpf(cpf);
        setPeso(peso);
        setAltura(altura);
    }
    // método get para acessar o atributo
    public String getNome() {
        return nome;
    }
    // método set para modificar o valor do atributo
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) { // trim para tirar os espaços desnecessários e isEmpty para avisar se estiver vazio
            throw new IllegalArgumentException("Informe o nome do Aluno");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
    	// tudo que não for um valor numerico vai ser subtituitod por "", para deixar apenas os numeros para fazer a validação do cpf
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) { // se a quantidade de numeros for diferente de 11, vai dar erro
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos");
        }
        // caso o cpf colcoado tenha os numeros iguais, vai dar erro
        if (FuncoesUteis.DigitosIguais(cpf)) {
            throw new IllegalArgumentException("O CPF não pode ter todos os dígitos iguais");
        }
        // avisa se o cpf é invalido
        if (!FuncoesUteis.ValidacaoCpf(cpf)) {
            throw new IllegalArgumentException("O CPF é inválido");
        }

        this.cpf = cpf;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) { // se o peso colocado for menor ou igual 0, vai dar erro
            throw new IllegalArgumentException("O peso deve ser maior que 0"); 
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) { // se a altura colocada for menor ou igual a 0, vai dar erro
            throw new IllegalArgumentException("A altura deve ser maior que 0");
        }
        this.altura = altura;
    }
    // método para formatar a string com as caracteristicas
    public String descricao() {
        return "\nNome: " + nome + "\nCPF: " + cpf + "\nPeso: " + peso + "kgs" + "\nAltura: " + altura + " metros" + "\nIMC: " + FuncoesUteis.calculaIMC(peso, altura);
    }
}