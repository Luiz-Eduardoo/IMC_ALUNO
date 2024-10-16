package caracteristicas;
	// classe FuncoesUteis para realizar os calculos
	public class FuncoesUteis {
    // inicio da validação do CPF, verifica se os digitos são iguais
    public static boolean DigitosIguais(String cpf) {
        char primeiroDigito = cpf.charAt(0);
        for (int i = 1; i < cpf.length(); i++) { // faz o loop da verificação
            if (cpf.charAt(i) != primeiroDigito) { // se o digito for diferente retorna false
                return false;
            }
        }
        return true; // caso seja igual retorna true
    }
    // Segunda Etapa da validação do CPF
    public static boolean ValidacaoCpf(String cpf) {
        int soma = 0;
        // Soma os primeiros nove dígitos do CPF multiplicados por 10 até 2
        for (int i = 0; i < 9; i++) { // loop para fazer a verificação
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i); // getNumericValue serve para transformar um numero em uma String no seu real valor numerico
        }
        // Calcula o primeiro dígito verificador do CPF
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) {
            primeiroDigito = 0; // se o resto da divisão for menor que 2, o dígito será 0. Porém se o resto da divisão for igual ou maior que 2, então o dígito verificador será igual a 11 menos o resto da divisão
        }

        soma = 0; // reinicia a soma para fazer a verificação do segundo digito 
        // Soma os dez primeiros dígitos do CPF incluindo o primeiro dígito verificador mulitiplicados por 11 até 2
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        // Calcula o segundo dígito verificador
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) {
            segundoDigito = 0;
        }
        // Ve se os dígitos verificadores calculados são iguais aos dígitos do CPF
        return (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                segundoDigito == Character.getNumericValue(cpf.charAt(10)));
    }
    // calculo de IMC
    public static double calculaIMC(double peso, double altura) {
        return peso / Math.pow(altura, 2); // peso dividido pela altura ao quadrado
    }
    // calcula se o o aluno foi reprovado ou aprovado
    public static String verificaNota(int nota, int percentualPresença) {
        return (nota >= 5 && percentualPresença >= 75) ? "Aprovado" : "Reprovado"; // se tiver nota maior ou igual a 5 e a presença for igual ou maior que 75 foi aprovado
        // caso contrario reprovado
    }
	}