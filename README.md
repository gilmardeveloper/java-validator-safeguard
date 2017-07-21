# Safeguard

### Validação para CPF, CNPJ, Inscrição Estadual, Telefone, CEP, placas de veículos, telefone e outros campos de texto. Integrado com provedores de validação e persistência.

## Dowloads

* [Clone GitHub](https://github.com/gilmardeveloper/java-validator-safeguard.git) 
* [Dowload JARs ZIP](https://github.com/gilmardeveloper/java-validator-safeguard/raw/master/downloads/safeguard.zip)

## Mavem

### Faça o [Fork](https://github.com/gilmardeveloper/java-validator-safeguard.git) ou baixe o [Zip](https://github.com/gilmardeveloper/java-validator-safeguard/archive/master.zip), instale no seu repositório local com comando mvn install, e adicione as dependências no seu projeto.

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

1. Validando um texto

 ```
 String textoPadraoSemCaracteresEspeciais = "Você pode digita apenas letras ou números";
 String apenasTexto = "Apenas texto sem caracteres especiais ou números";
 String apenasNumeros = "1234567890";
 String textoEnumero = "texto com números 1234567890";
 String textoEnumeroComPontuacao = "texto com números 1234567890 ?!.:;";
 
 Check check = new SafeguardCheck();
 
 boolean hasError = check.elementOf(textoPadraoSemCaracteresEspeciais, ParametroTipo.DEFAULT_SEM_CARACTERES_ESPECIAIS)
		          			   .elementOf(apenasTexto, ParametroTipo.TEXTO_SEM_CARACTERES_ESPECIAIS)
							   .elementOf(apenasNumeros, ParametroTipo.NUMERO)
							   .elementOf(textoEnumero, ParametroTipo.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS)
							   .elementOf(textoEnumeroComPontuacao, ParametroTipo.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO)
							   .Validate()
							   .hasError();
 
 ```


## Collections                                                   
                                                                  
### List                                                            
É uma classe genérica que representa uma lista de elementos.

1. [Documentação](https://github.com/gilmardeveloper/javascript/raw/master/dowloads/docs.zip)
2. [Dowload](https://github.com/gilmardeveloper/javascript/raw/master/dowloads/collections.zip)
3. CDN
   
   ```
   <script src="https://cdn.rawgit.com/gilmardeveloper/javascript/master/collections/list.js"></script>
   <script src="https://cdn.rawgit.com/gilmardeveloper/javascript/master/collections/list-min.js"></script>  

   ```

### Controller                                                            
É uma classe genérica que representa um controlador crud.

1. [Documentação](https://github.com/gilmardeveloper/javascript/raw/master/dowloads/docs.zip)
2. [Dowload](https://github.com/gilmardeveloper/javascript/raw/master/dowloads/controller.zip)
3. CDN
   
   ```
   <script src="https://cdn.rawgit.com/gilmardeveloper/javascript/master/controller/controller.js"></script>
   <script src="https://cdn.rawgit.com/gilmardeveloper/javascript/master/controller/controller-min.js"></script>  

   ```

### Hash                                                            
Classe que gera um hash a partir de uma string

1. [Documentação](https://github.com/gilmardeveloper/javascript/raw/master/dowloads/docs.zip)
2. [Dowload](https://github.com/gilmardeveloper/javascript/raw/master/dowloads/hash.zip)
3. CDN
   
   ```
   <script src="https://cdn.rawgit.com/gilmardeveloper/javascript/master/hash/hash.js"></script>
   <script src="https://cdn.rawgit.com/gilmardeveloper/javascript/master/hash/hash-min.js"></script>  

   ```
 
© 2017 Gilmar Carlos All rights reserved.
