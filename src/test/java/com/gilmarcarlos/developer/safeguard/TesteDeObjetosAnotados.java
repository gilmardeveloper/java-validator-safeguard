package com.gilmarcarlos.developer.safeguard;

import java.io.Serializable;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.safeguard.check.SafeguardCheck;
import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteDeObjetosAnotados {

	@Test
	public void loads() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("João da Silva");
		pessoa.setCpf("12345678901");
		pessoa.setTelefone("(11)3266-4455");
		pessoa.setEndereco("Rua A, 123, Bananal, Guarulhos - SP");
			
		Check check = new SafeguardCheck();
		
		/*Validação manual usando a interface Check*/
		Check resultados = check.elementOf(pessoa).Validate();
		int quantidadeDeElementosInvalidos = resultados.getInvalidElements().size();
		boolean temErro = resultados.hasError();
			
		/*Validação pelo provedor de validação, usando javax.validation*/
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<Pessoa>> violacoes = validator.validate(pessoa, Default.class);
		
		Assert.assertEquals(1, quantidadeDeElementosInvalidos);
		Assert.assertEquals(true, temErro);
		Assert.assertEquals(1, violacoes.size());
				  
	}

}

class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String nome;
	
	@Verify(value = ParametroTipo.CPF)
	private String cpf;
	
	@Verify(ParametroTipo.TELEFONE_FORMATADO_BRASIL)
	private String telefone;
	
	@Verify(ParametroTipo.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE)
	private String endereco;
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
		

}
