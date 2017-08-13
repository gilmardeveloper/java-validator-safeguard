package br.com.safeguard.types;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.NITValidator;
import br.com.caelum.stella.validation.TituloEleitoralValidator;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.ie.IEAcreValidator;
import br.com.caelum.stella.validation.ie.IEAlagoasValidator;
import br.com.caelum.stella.validation.ie.IEAmapaValidator;
import br.com.caelum.stella.validation.ie.IEAmazonasValidator;
import br.com.caelum.stella.validation.ie.IEBahiaValidator;
import br.com.caelum.stella.validation.ie.IECearaValidator;
import br.com.caelum.stella.validation.ie.IEDistritoFederalValidator;
import br.com.caelum.stella.validation.ie.IEEspiritoSantoValidator;
import br.com.caelum.stella.validation.ie.IEGoiasValidator;
import br.com.caelum.stella.validation.ie.IEMaranhaoValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoDoSulValidator;
import br.com.caelum.stella.validation.ie.IEMatoGrossoValidator;
import br.com.caelum.stella.validation.ie.IEMinasGeraisValidator;
import br.com.caelum.stella.validation.ie.IEParaValidator;
import br.com.caelum.stella.validation.ie.IEParaibaValidator;
import br.com.caelum.stella.validation.ie.IEParanaValidator;
import br.com.caelum.stella.validation.ie.IEPernambucoValidator;
import br.com.caelum.stella.validation.ie.IEPiauiValidator;
import br.com.caelum.stella.validation.ie.IERioDeJaneiroValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoNorteValidator;
import br.com.caelum.stella.validation.ie.IERioGrandeDoSulValidator;
import br.com.caelum.stella.validation.ie.IERondoniaValidator;
import br.com.caelum.stella.validation.ie.IERoraimaValidator;
import br.com.caelum.stella.validation.ie.IESantaCatarinaValidator;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import br.com.caelum.stella.validation.ie.IESergipeValidator;
import br.com.caelum.stella.validation.ie.IETocantinsValidator;
import br.com.safeguard.interfaces.BaseParam;
import br.com.safeguard.patterns.Patterns;
import br.com.safeguard.validators.PatternValidator;

/**
 * Enum que determina o tipo das validações e retornam o validador correspondente.
 * 
 * O Enum implementa a interface (BaseParam), e faz uso dos padrões registrados em (Patterns)
 * 
 * <p>
 * Default é validação padrão registrada pelo validador
 * </p>
 *   
 * @author Gilmar Carlos
 *
 */
public enum ParametroTipo implements BaseParam{

	/**Cadeia de caracteres que representa um documento de CPF*/
	CPF																		(new CPFValidator()),
	/**Cadeia de caracteres que representa um documento de CPF formatado*/
	CPF_FORMATADO															(new CPFValidator(true)),
	/**Cadeia de caracteres que representa um documento de Titulo de Eleitor*/
	TITULO_DE_ELEITOR														(new TituloEleitoralValidator()),
	/**Cadeia de caracteres que representa um documento de Titulo de Eleitor formatado*/
	TITULO_DE_ELEITOR_FORMATADO												(new TituloEleitoralValidator(true)),
	/**Cadeia de caracteres que representa um documento de Número de Indentificação do Trabalhador*/
	NIT																		(new NITValidator()),
	/**Cadeia de caracteres que representa um documento de Número de Indentificação do Trabalhador formatado*/
	NIT_FORMATADO															(new NITValidator(true)),
	
	/**Cadeia de caracteres que representa um CNPJ*/
	CNPJ																	(new CNPJValidator()),
	/**Cadeia de caracteres que representa um CNPJ formatado*/
	CNPJ_FORMATADO															(new CNPJValidator(true)),
	
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ACRE_AC 	 															(new IEAcreValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ACRE_AC_FORMATADO													(new IEAcreValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ALAGOAS_AL	 														(new IEAlagoasValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ALAGOAS_AL_FORMATADO	 												(new IEAlagoasValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAPA_AP	 															(new IEAmapaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAPA_AP_FORMATADO	 												(new IEAmapaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAZONAS_AM															(new IEAmazonasValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_AMAZONAS_AM_FORMATADO												(new IEAmazonasValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_BAHIA_BA	 															(new IEBahiaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_BAHIA_BA_FORMATADO	 												(new IEBahiaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_CEARA_CE	 															(new IECearaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_CEARA_CE_FORMATADO	 												(new IECearaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_DISTRITO_FEDERAL_DF	 												(new IEDistritoFederalValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_DISTRITO_FEDERAL_DF_FORMATADO	 									(new IEDistritoFederalValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ESPIRITO_SANTO_ES	 												(new IEEspiritoSantoValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_ESPIRITO_SANTO_ES_FORMATADO	 										(new IEEspiritoSantoValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_GOIAIS_GO															(new IEGoiasValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_GOIAIS_GO_FORMATADO													(new IEGoiasValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MARANHAO_MA															(new IEMaranhaoValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MARANHAO_MA_FORMATADO												(new IEMaranhaoValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_MT														(new IEMatoGrossoValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_MT_FORMATADO												(new IEMatoGrossoValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_DO_SUL_MS												(new IEMatoGrossoDoSulValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MATO_GROSSO_DO_SUL_MS_FORMATADO										(new IEMatoGrossoDoSulValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MINAS_GERAIS_MG 														(new IEMinasGeraisValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_MINAS_GERAIS_MG_FORMATADO 											(new IEMinasGeraisValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARA_PA		 														(new IEParaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARA_PA_FORMATADO		 											(new IEParaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARAIBA_PB															(new IEParaibaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARAIBA_PB_FORMATADO													(new IEParaibaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARARA_PR															(new IEParanaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PARARA_PR_FORMATADO													(new IEParanaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PERNAMBUCO_PE														(new IEPernambucoValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PERNAMBUCO_PE_FORMATADO												(new IEPernambucoValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PIAUI_PI																(new IEPiauiValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_PIAUI_PI_FORMATADO													(new IEPiauiValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_DE_JANEIRO_RJ													(new IERioDeJaneiroValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_DE_JANEIRO_RJ_FORMATADO											(new IERioDeJaneiroValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_NORTE_RN												(new IERioGrandeDoNorteValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_NORTE_RN_FORMATADO										(new IERioGrandeDoNorteValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_SUL_RS													(new IERioGrandeDoSulValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RIO_GRANDE_DO_SUL_RS_FORMATADO										(new IERioGrandeDoSulValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RONDONIA_RO	 														(new IERondoniaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RONDONIA_RO_FORMATADO	 											(new IERondoniaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RORAIMA_RR															(new IERoraimaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_RORAIMA_RR_FORMATADO													(new IERoraimaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SANTA_CATARINA_SC													(new IESantaCatarinaValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SANTA_CATARINA_SC_FORMATADO											(new IESantaCatarinaValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SAO_PAULO_SP															(new IESaoPauloValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SAO_PAULO_SP_FORMATADO												(new IESaoPauloValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SERGIPE_SE															(new IESergipeValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_SERGIPE_SE_FORMATADO													(new IESergipeValidator(true)),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_TOCANTINS_TO															(new IETocantinsValidator()),
	/**Cadeia de caracteres que representa uma Inscrição estadual*/
	IE_TOCANTINS_TO_FORMATADO												(new IETocantinsValidator(true)),
		
	/**
	 * Cadeia de caracteres de texto padrão, contendo caracters da tabela unicode
	 * iniciando em \u0020 e terminando em \u00FC 
	 */
	DEFAULT																	(new PatternValidator()),
	/**Cadeia de caracteres de texto padrão sem o sinal de maior */
	DEFAULT_SEM_SIMBOLO_DE_MAIOR											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_MAIOR)),
	/**Cadeia de caracteres de texto padrão sem o sinal de menor */
	DEFAULT_SEM_SIMBOLO_DE_MENOR											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_MENOR)),
	/**Cadeia de caracteres de texto padrão sem o sinal de menor e maior*/
	DEFAULT_SEM_SIMBOLO_DE_MENOR_E_MAIOR									(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_MENOR_E_MAIOR)),
	/**Cadeia de caracteres de texto padrão sem o sinal de chaves */
	DEFAULT_SEM_SIMBOLO_DE_CHAVES											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_CHAVES)),
	/**Cadeia de caracteres de texto padrão sem o sinal de colchetes */
	DEFAULT_SEM_SIMBOLO_DE_COLCHETES										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_COLCHETES)),
	/**Cadeia de caracteres de texto padrão sem o sinal de parneteses */
	DEFAULT_SEM_SIMBOLO_DE_PARENTESES										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_PARENTESES)),
	/**Cadeia de caracteres de texto padrão sem o sinal de asterisco */
	DEFAULT_SEM_SIMBOLO_DE_ASTERISCO										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_ASTERISCO)),
	/**Cadeia de caracteres de texto padrão sem o sinal de arroba */
	DEFAULT_SEM_SIMBOLO_DE_ARROBA											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_ARROBA)),
	/**Cadeia de caracteres de texto padrão sem o sinal de hashtag */
	DEFAULT_SEM_SIMBOLO_DE_HASHTAG			   								(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_HASHTAG)),
	/**Cadeia de caracteres de texto padrão sem o sinal de sifrão  */
	DEFAULT_SEM_SIMBOLO_DE_SIFRAO			   								(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_SIFRAO)),
	/**Cadeia de caracteres de texto padrão sem o sinal de porcentagem */
	DEFAULT_SEM_SIMBOLO_DE_PORCENTAGEM										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_PORCENTAGEM)),
	/**Cadeia de caracteres de texto padrão sem o sinal de trema */
	DEFAULT_SEM_SIMBOLO_DE_TREMA											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_TREMA)),
	/**Cadeia de caracteres de texto padrão sem o sinal de e comercial */
	DEFAULT_SEM_SIMBOLO_DE_E_COMERCIAL										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_E_COMERCIAL)),
	/**Cadeia de caracteres de texto padrão sem o sinal de underline  */
	DEFAULT_SEM_SIMBOLO_DE_UNDERLINE										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_UNDERLINE)),
	/**Cadeia de caracteres de texto padrão sem o sinal de hífem */
	DEFAULT_SEM_SIMBOLO_DE_HIFEM											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_HIFEM)),
	/**Cadeia de caracteres de texto padrão sem o sinal de mais  */
	DEFAULT_SEM_SIMBOLO_DE_MAIS												(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_MAIS)),
	/**Cadeia de caracteres de texto padrão sem o sinal de aspas simples */
	DEFAULT_SEM_SIMBOLO_DE_ASPAS_SIMPLES									(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_ASPAS_SIMPLES)),
	/**Cadeia de caracteres de texto padrão sem o sinal de aspas duplas  */
	DEFAULT_SEM_SIMBOLO_DE_ASPAS_DUPLA										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_ASPAS_DUPLA)),
	/**Cadeia de caracteres de texto padrão sem o sinal de ponto  */
	DEFAULT_SEM_SIMBOLO_DE_PONTO											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_PONTO)),
	/**Cadeia de caracteres de texto padrão sem o sinal de virgula  */
	DEFAULT_SEM_SIMBOLO_DE_VIRGULA											(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_VIRGULA)),
	/**Cadeia de caracteres de texto padrão sem o sinal de dois pontos */
	DEFAULT_SEM_SIMBOLO_DE_DOIS_PONTOS										(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_DOIS_PONTOS)),
	/**Cadeia de caracteres de texto padrão sem o sinal de ponto e virgula */
	DEFAULT_SEM_SIMBOLO_DE_PONTO_E_VIRGULA									(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_PONTO_E_VIRGULA)),
	/**Cadeia de caracteres de texto padrão sem o sinal de exclamação */
	DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_EXCLAMACAO								(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_EXCLAMACAO)),
	/**Cadeia de caracteres de texto padrão sem o sinal de interrogação */
	DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_INTERROGACAO							(new PatternValidator(Patterns.DEFAULT_SEM_SIMBOLO_DE_PONTO_DE_INTERROGACAO)),
	/**Cadeia de caracteres de texto padrão sem pontuação */
	DEFAULT_SEM_PONTUACAO													(new PatternValidator(Patterns.DEFAULT_SEM_PONTUACAO)),
	/**Cadeia de caracteres de texto padrão sem números */
	DEFAULT_SEM_NUMEROS														(new PatternValidator(Patterns.DEFAULT_SEM_NUMEROS)),
	/**Cadeia de caracteres de texto padrão sem sinais matemáticos */
	DEFAULT_SEM_SINAIS_MATEMATICOS											(new PatternValidator(Patterns.DEFAULT_SEM_SINAIS_MATEMATICOS)),
	/**Cadeia de caracteres de texto padrão sem caracteres especiais */
	DEFAULT_SEM_CARACTERES_ESPECIAIS										(new PatternValidator(Patterns.DEFAULT_SEM_CARACTERES_ESPECIAIS)),
		
	/**Cadeia de caracteres apenas com texto, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS											(new PatternValidator(Patterns.TEXTO_SEM_CARACTERES_ESPECIAIS)),
	/**Cadeia de caracteres apenas com texto e hífem, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM								(new PatternValidator(Patterns.TEXTO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM)),
	/**Cadeia de caracteres apenas com texto e underline, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE							(new PatternValidator(Patterns.TEXTO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE)),
	/**Cadeia de caracteres apenas com texto e virgula, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA								(new PatternValidator(Patterns.TEXTO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA)),
	/**Cadeia de caracteres apenas com texto e pontuação, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO							(new PatternValidator(Patterns.TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO)),
	/**Cadeia de caracteres apenas com texto, pontuação, hífem e underline, sem númeors ou caracteres especiais*/
	TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE			(new PatternValidator(Patterns.TEXTO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE)),
	
	/**Cadeia de caracteres com texto e número, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS									(new PatternValidator(Patterns.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS)),
	/**Cadeia de caracteres com texto, números e hífem, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM							(new PatternValidator(Patterns.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_HIFEM)),
	/**Cadeia de caracteres com texto, números e underline, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE						(new PatternValidator(Patterns.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_UNDERLINE)),
	/**Cadeia de caracteres com texto, números e virgula, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA						(new PatternValidator(Patterns.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_VIRGULA)),
	/**Cadeia de caracteres com texto, números e pontuação, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO						(new PatternValidator(Patterns.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO)),
	/**Cadeia de caracteres com texto, números, pontuação, hífem e underline, sem caracteres especiais*/
	TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE		(new PatternValidator(Patterns.TEXTO_NUMERO_SEM_CARACTERES_ESPECIAIS_COM_PONTUACAO_HIFEM_UNDERLINE)),
	/**Cadeia de caracteres com texto, números, virgula, hífem e underline, sem caracteres especiais*/
	TEXTO_NUMERO_VIRGULA_HIFEM_UNDERLINE_SEM_PONTUACAO						(new PatternValidator(Patterns.TEXTO_NUMERO_VIRGULA_HIFEM_UNDERLINE_SEM_PONTUACAO)),
	
	/**Cadeia de caracteres contendo apenas números*/
	NUMERO																	(new PatternValidator(Patterns.NUMERO)),
	
	/**Cadeia de caracteres que representa um email*/
	EMAIL																	(new PatternValidator(Patterns.EMAIL)),
	
	/**Cadeia de caracteres que representa um CEP*/
	CEP																		(new PatternValidator(Patterns.CEP)),
	/**Cadeia de caracteres que representa um CEP formatado*/
	CEP_FORMATADO															(new PatternValidator(Patterns.CEP_FORMATADO)),
	
	/**Cadeia de caracteres que representa uma placa de veículo*/
	PLACA_DE_VEICULO_BRASIL													(new PatternValidator(Patterns.PLACA_DE_VEICULO_BRASIL)),
	/**Cadeia de caracteres que representa uma placa de veículo formatado*/
	PLACA_DE_VEICULO_FORMATADO_BRASIL										(new PatternValidator(Patterns.PLACA_DE_VEICULO_FORMATADO_BRASIL)),
	
	/**
	 * Cadeia de caracteres que representa um telefone fixo ou móvel com ou sem número da operadora, DD + NÚMERO
	 * 
	 * 
	 * Exemplos:
	 * <ul>
	 * <li>Com número da operadora 	  01211988774455, obs.: O dígito 9 pode ser omitido para telefones fixos 1133445566 </li>
	 * <li>Sem o número da operadora  11988774455</li>
	 * </ul> 
	 *  
	 * 
	 */
	TELEFONE																(new PatternValidator(Patterns.TELEFONE)),
	
	/**
	 * Cadeia de caracteres que representa um telefone fixo ou móvel com ou sem número da operadora, DD + NÚMERO formatado
	 * 
	 * 
	 * Exemplos:
	 * <ul>
	 * <li>Com número da operadora 	  012(11)98877-4455, obs.: O dígito 9 pode ser omitido para telefones fixos (11)3344-5566 </li>
	 * <li>Sem o número da operadora  (11)98877-4455</li>
	 * </ul> 
	 *  
	 * 
	 */
	TELEFONE_FORMATADO_BRASIL												(new PatternValidator(Patterns.TELEFONE_FORMATADO_BRASIL)),
	/**
	 * Cadeia de caracteres que representa um telefone fixo ou móvel com o número do país, DD + NÚMERO formatado
	 * 
	 * 
	 * Exemplos:
	 * <ul>
	 * <li>Formato internacional: +55 11 98877-4455, obs.: O dígito 9 pode ser omitido para telefones fixos +55 11 3344-5566 </li>
	 * </ul> 
	 *  
	 * 
	 */
	TELEFONE_FORMATADO_INTERNACIONAL										(new PatternValidator(Patterns.TELEFONE_FORMATADO_INTERNACIONAL));
			
	private Validator<String> type;
		
	private ParametroTipo(Validator<String> type){
		this.type = type;
	}

	@Override
	public Validator<String> getType() {
		return type;
	}
		
}
