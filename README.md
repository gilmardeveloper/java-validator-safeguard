# Safeguard

### Biblioteca java para validação de CPF, CNPJ, Inscrição Estadual, Telefone, CEP, placas de veículos, telefone e outros campos de texto. Integrado com provedores de validação e persistência.

## Downloads

* [Clone GitHub](https://github.com/gilmardeveloper/java-validator-safeguard.git) 
* [Download JAR](https://oss.sonatype.org/content/groups/public/com/github/gilmardeveloper/safeguard/0.0.1-RELEASE/safeguard-0.0.1-RELEASE.jar)

## Maven

### Faça o [Clone](https://github.com/gilmardeveloper/java-validator-safeguard.git) ou use o maven adicionando a dependência no seu arquivo pom.xml.
```
<dependencies>
	<dependency>
		<groupId>com.github.gilmardeveloper</groupId>
		<artifactId>safeguard</artifactId>
		<version>0.0.1-RELEASE</version>
	</dependency>
</dependencies>

```
## Como usar

1. Validando um elemento

	```java
	String texto = "digite apenas letras ou números";

	Check check = new SafeguardCheck();

	boolean hasError = check
				.elementOf(texto,ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
				.validate()
				.hasError();
	```
2. Validando mais de um elemento
	```java
	String texto = "digite apenas letras ou números";
	String numeros = "1234567890";
	String cpf= "96205663279";
	
	Check check = new SafeguardCheck();

	boolean hasError = check
				.elementOf(texto,ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
				.elementOf(numeros,ParametroTipo.NUMERO)
				.elementOf(cpf,ParametroTipo.CPF)
				.validate()
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
				.validate()
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
		
		public void validar(@Valid Empresa empresa, BindingResult result, HttpServletResponse response) {

				if(!result.hasErrors()) { 
					//do anything
					response.setStatus(200);
				}else {

					response.setStatus(400);
				}

		}
		
		4.3.2 Usando a validação do JPA
		
		EntityManager manager = entityManagerFactory.createEntityManager();

		manager.persist(empresa);

		manager.close();
		
## Métodos da interface Check

- elementOf(Object object)
	- Método que recebe um objeto que tenha atributos da classe anotados com (@Verify) para ser adicionado em um (List) de elementos

- elementOf(String value, BaseParam tipo)
	- Método que recebe um (String) e um (BaseParam) para ser adicionado em um (Map) de elementos

- elementOf(String value, ParametroTipo tipo)
	- Método que recebe um (String) e um (BaseParam) para ser adicionado em um (Map) de elementos
	
- getInvalidElements()
	- Método que retorna uma lista de elementos inválidos

- getValidElements()
	- Método que retorna uma lista de elementos válidos

- hasError()
	- Método que retorna true caso os elementos verificados sejam inválidos, false caso contrário

- validate()
	- O método que faz a validação dos valores passados anteriormente no método elementOf(), e retorna a própria classe

## Lista de Validações

	/**Cadeia de caracteres que representa um documento de CPF*/
	CPF
	
	/**Cadeia de caracteres que representa um documento de CPF formatado*/
	CPF_FORMATADO
	
	/**Cadeia de caracteres que representa um documento de Titulo de Eleitor*/
	TITULO_DE_ELEITOR
	
	/**Cadeia de caracteres que representa um documento de Titulo de Eleitor formatado*/
	TITULO_DE_ELEITOR_FORMATADO
	
	/**Cadeia de caracteres que representa um documento de Número de Indentificação do Trabalhador*/
	NIT
	
	/**Cadeia de caracteres que representa um documento de Número de Indentificação do Trabalhador formatado*/
	NIT_FORMATADO
	
	/**Cadeia de caracteres que representa um CNPJ*/
	CNPJ
	
	/**Cadeia de caracteres que representa um CNPJ formatado*/
	CNPJ_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ACRE_AC
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ACRE_AC_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ALAGOAS_AL
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ALAGOAS_AL_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAPA_AP
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAPA_AP_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAZONAS_AM	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAZONAS_AM_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_BAHIA_BA
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_BAHIA_BA_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_CEARA_CE
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_CEARA_CE_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_DISTRITO_FEDERAL_DF	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_DISTRITO_FEDERAL_DF_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ESPIRITO_SANTO_ES	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ESPIRITO_SANTO_ES_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_GOIAIS_GO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_GOIAIS_GO_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MARANHAO_MA	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MARANHAO_MA_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_MT
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_MT_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_DO_SUL_MS
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_DO_SUL_MS_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MINAS_GERAIS_MG 
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MINAS_GERAIS_MG_FORMATADO 
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARA_PA		
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARA_PA_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARAIBA_PB	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARAIBA_PB_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARARA_PR		
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARARA_PR_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PERNAMBUCO_PE	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PERNAMBUCO_PE_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PIAUI_PI		
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PIAUI_PI_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_DE_JANEIRO_RJ	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_DE_JANEIRO_RJ_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_NORTE_RN
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_NORTE_RN_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_SUL_RS	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_SUL_RS_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RONDONIA_RO	 	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RONDONIA_RO_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RORAIMA_RR		
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RORAIMA_RR_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SANTA_CATARINA_SC	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SANTA_CATARINA_SC_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SAO_PAULO_SP		
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SAO_PAULO_SP_FORMATADO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SERGIPE_SE		
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SERGIPE_SE_FORMATADO	
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_TOCANTINS_TO
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_TOCANTINS_TO_FORMATADO
		
	/**
	 * Cadeia de caracteres de texto padrão, contendo caracters da tabela unicode
	 * iniciando em \u0020 e terminando em \u00FC 
	 */
	DEFAULT	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de maior */
	DEFAULT_SEM_SIMBOLO_DE_MAIOR
	
	/**Cadeia de caracteres de texto padrão sem o sinal de menor */
	DEFAULT_SEM_SIMBOLO_DE_MENOR	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de menor e maior*/
	DEFAULT_SEM_SIMBOLO_DE_MENOR_E_MAIOR	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de chaves */
	DEFAULT_SEM_SIMBOLO_DE_CHAVES		
	
	/**Cadeia de caracteres de texto padrão sem o sinal de colchetes */
	DEFAULT_SEM_SIMBOLO_DE_COLCHETES	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de parneteses */
	DEFAULT_SEM_SIMBOLO_DE_PARENTESES	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de asterisco */
	DEFAULT_SEM_SIMBOLO_DE_ASTERISCO	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de arroba */
	DEFAULT_SEM_SIMBOLO_DE_ARROBA		
	
	/**Cadeia de caracteres de texto padrão sem o sinal de hashtag */
	DEFAULT_SEM_SIMBOLO_DE_HASHTAG		
	
	/**Cadeia de caracteres de texto padrão sem o sinal de sifrão  */
	DEFAULT_SEM_SIMBOLO_DE_SIFRAO		
	
	/**Cadeia de caracteres de texto padrão sem o sinal de porcentagem */
	DEFAULT_SEM_SIMBOLO_DE_PORCENTAGEM	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de trema */
	DEFAULT_SEM_SIMBOLO_DE_TREMA	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de e comercial */
	DEFAULT_SEM_SIMBOLO_DE_E_COMERCIAL	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de underline  */
	DEFAULT_SEM_SIMBOLO_DE_UNDERLINE	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de hífem */
	DEFAULT_SEM_SIMBOLO_DE_HIFEM	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de mais  */
	DEFAULT_SEM_SIMBOLO_DE_MAIS	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de aspas simples */
	DEFAULT_SEM_SIMBOLO_DE_ASPAS_SIMPLES	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de aspas duplas  */
	DEFAULT_SEM_SIMBOLO_DE_ASPAS_DUPLA	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de ponto  */
	DEFAULT_SEM_SIMBOLO_DE_PONTO		
	
	/**Cadeia de caracteres de texto padrão sem o sinal de virgula  */
	DEFAULT_SEM_SIMBOLO_DE_VIRGULA		
	
	/**Cadeia de caracteres de texto padrão sem o sinal de dois pontos */
	DEFAULT_SEM_SIMBOLO_DE_DOIS_PONTOS	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de ponto e virgula */
	DEFAULT_SEM_SIMBOLO_DE_PONTO_E_VIRGULA	
	
	/**Cadeia de caracteres de texto padrão sem o sinal de exclamação */
	DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_EXCLAMACAO
	
	/**Cadeia de caracteres de texto padrão sem o sinal de interrogação */
	DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_INTERROGACAO
	
	/**Cadeia de caracteres de texto padrão sem pontuação */
	DEFAULT_SEM_PONTUACAO			
	
	/**Cadeia de caracteres de texto padrão sem números */
	DEFAULT_SEM_NUMEROS			
	
	/**Cadeia de caracteres de texto padrão sem sinais matemáticos */
	DEFAULT_SEM_SINAIS_MATEMATICOS		
	
	/**Cadeia de caracteres de texto padrão sem caracteres especiais */
	DEFAULT_SEM_CARACTERES_ESPECIAIS	
		
	/**Cadeia de caracteres apenas com texto, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS			
	
	/**Cadeia de caracteres apenas com texto e hífem, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM	
	
	/**Cadeia de caracteres apenas com texto e underline, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE	
	
	/**Cadeia de caracteres apenas com texto e virgula, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA		
	
	/**Cadeia de caracteres apenas com texto e pontuação, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO		
	
	/**Cadeia de caracteres apenas com texto, pontuação, hífem e underline, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE
	
	/**Cadeia de caracteres com texto e número, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS		
	
	/**Cadeia de caracteres com texto, números e hífem, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM		
	
	/**Cadeia de caracteres com texto, números e underline, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE		
	
	/**Cadeia de caracteres com texto, números e virgula, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA		
	
	/**Cadeia de caracteres com texto, números e pontuação, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO		
	
	/**Cadeia de caracteres com texto, números, pontuação, hífem e underline, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE
	
	/**Cadeia de caracteres com texto, números, virgula, hífem e underline, sem caracteres especiais*/
	TEXTO_NUMERO_VIRGULA_HIFEM_UNDERLINE_SEM_PONTUACAO		
	
	/**Cadeia de caracteres contendo apenas números*/
	NUMERO					
	
	/**Cadeia de caracteres que representa um email*/
	EMAIL						
	
	/**Cadeia de caracteres que representa um CEP*/
	CEP					
	
	/**Cadeia de caracteres que representa um CEP formatado*/
	CEP_FORMATADO															
	/**Cadeia de caracteres que representa uma placa de veículo*/
	PLACA_DE_VEICULO_BRASIL			
	
	/**Cadeia de caracteres que representa uma placa de veículo formatado*/
	PLACA_DE_VEICULO_FORMATADO_BRASIL		
	
	/**
	 * Cadeia de caracteres que representa um telefone fixo ou móvel com ou sem número da operadora, DD + NÚMERO
	 * 
	 * Exemplos:
	 * Com número da operadora  01211988774455, obs.: O dígito 9 pode ser omitido para telefones fixos 1133445566 
	 * Sem o número da operadora  11988774455
	 */
	TELEFONE																
	
	/**
	 * Cadeia de caracteres que representa um telefone fixo ou móvel com ou sem número da operadora, DD + NÚMERO formatado
	 * 
	 * Exemplos:
	 * Com número da operadora 012(11)98877-4455, obs.: O dígito 9 pode ser omitido para telefones fixos (11)3344-5566
	 * Sem o número da operadora  (11)98877-4455
	 */
	TELEFONE_FORMATADO_BRASIL	
	
	/**
	 * Cadeia de caracteres que representa um telefone fixo ou móvel com o número do país, DD + NÚMERO formatado
	 * 
	 * Exemplos:
	 * Formato internacional: +55 11 98877-4455, obs.: O dígito 9 pode ser omitido para telefones fixos +55 11 3344-5566
	 */
	TELEFONE_FORMATADO_INTERNACIONAL
	

© 2017 Gilmar Carlos All rights reserved.
