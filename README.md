# Safeguard

### Biblioteca java para validação de CPF, CNPJ, Inscrição Estadual, Telefone, CEP, placas de veículos, telefone e outros campos de texto. Integrado com provedores de validação e persistência.

## Dowloads

* [Clone GitHub](https://github.com/gilmardeveloper/java-validator-safeguard.git) 
* [Dowload JARs ZIP](https://github.com/gilmardeveloper/java-validator-safeguard/raw/master/downloads/safeguard.zip)

## Mavem

### Faça o [Fork](https://github.com/gilmardeveloper/java-validator-safeguard.git) ou baixe o [Zip](https://github.com/gilmardeveloper/java-validator-safeguard/archive/master.zip), instale no seu repositório local com comando mvn install, e adicione a dependência no seu projeto.

```
<dependencies>
	<dependency>
		<groupId>br.com.gilmarcarlos.developer</groupId>
		<artifactId>safeguard</artifactId>
		<version>0.0.1-SNAPSHOT</version>
	</dependency>
</dependencies>

```
## Como usar

1. Validando um elemento

	```java
	String texto = "Você pode digita apenas letras ou números";

	Check check = new SafeguardCheck();

	boolean hasError = check
				.elementOf(texto,ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
				.Validate()
				.hasError();
	```
2. Validando mais de um elemento
	```java
	String texto = "Você pode digita apenas letras ou números";
	String numeros = "1234567890";
	String cpf= "96205663279";
	
	Check check = new SafeguardCheck();

	boolean hasError = check
				.elementOf(texto,ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
				.elementOf(numeros,ParametroTipo.NUMERO)
				.elementOf(cpf,ParametroTipo.CPF)
				.Validate()
				.hasError();
	```
3. Validando o mesmo elemento
	
	**Obs.: Apenas opções do tipo DEFAULT devem ser usadas em um mesmo elemento, sendo distintas entre si.**
	
	```java
	String texto = "Você pode digita apenas letras ou números";
		
	Check check = new SafeguardCheck();

	boolean hasError = check
				.elementOf(texto,ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
				.elementOf(texto,ParametroTipo.DEFAULT_SEM_NUMEROS)
				.Validate()
				.hasError();
	```
4. Validando atributos de classe
	
	4.1. Anotando atributos com @Verify
	
	```java
	public class Empresa {
	
	@Verify(ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
	private String nome;
	@Verify(ParametroTipo.CNPJ)
	private String cnpj;
	@Verify(ParametroTipo.IE_SAO_PAULO_SP)
	private String ie;
	
	}
	```
	4.2. Validando a instância da classe de forma manual
	
	```java
	Empresa empresa = new Empresa(nome, cnpj, ie);
		
	Check check = new SafeguardCheck();

	boolean hasError = check.elementOf(empresa).Validate().hasError();
	```
	
	4.3. Usando um provedor de validação
	
		4.3.1 Usando a validação do Spring MVC
		
		```java
		
		public void validar(@Valid Empresa empresa, BindingResult result, HttpServletResponse response) {

				if(!result.hasErrors()) { 
					//do anything
					response.setStatus(200);
				}else {

					response.setStatus(400);
				}

		}
		```
		
		4.3.2 Usando a validação do JPA
		
		```java

		EntityManager manager = entityManagerFactory.createEntityManager();

		manager.persist(empresa);

		manager.close();

		```
 
© 2017 Gilmar Carlos All rights reserved.
