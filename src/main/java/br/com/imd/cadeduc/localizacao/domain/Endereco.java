package br.com.imd.cadeduc.localizacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * Classe que define o modelo Endereco
 * 
 * @author Welligton Miguel
 * @version 0.4
 */

@Entity
@Table(name = "endereco", schema = "localizacao")
@ApiModel
public class Endereco {

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true, notes = "ID gerado automaticamente pela base de dados")
	private Long id;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Logradouro de um endereço, ex: Rua, Av. etc.", required = true)
	private String logradouro;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Numero de uma instituição", required = true)
	private String numero;

	@ApiModelProperty(notes = "Complementação do endereço")
	private String complemento;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Bairro da Instituição", required = true)
	private String bairro;

	@NotBlank(message = "Campo em branco")
	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "CEP do endereço", required = true)
	private String cep;

	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Latitude da Instituição", required = true)
	@Column(nullable = true)
	private double latitude;

	@NotNull(message = "Campo nulo")
	@ApiModelProperty(notes = "Longitude da Instituição", required = true)
	@Column(nullable = true)
	private double longitude;

	@NotNull(message = "Campo nulo")
	@Column(name = "tipo_localizacao")
	@Enumerated(EnumType.ORDINAL)
	@ApiModelProperty(notes = "Tipo do local da instituição", required = true)
	private TipoLocalizacaoEnum tipoLocalizacao;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_municipio")
	@ApiModelProperty(notes = "Município da instituição ", required = true)
	private Municipio municipio;

	public Endereco(){
		id = new Long(0);
	}
	
	/**
	 * Método para retorno do id de uma instância de Endereco
	 * 
	 * @return Long - Valor do id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Altera o valor do id de uma instância de Endereco
	 * 
	 * @param id
	 *            Long - Novo valor do id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o logradouro de um endereço
	 * 
	 * @return String - logradouro de um endereço
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Altera o logradouro de um endereço
	 * 
	 * @param logradouro
	 *            String - novo logradouro de um endereço
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * Retorna o número de um endereço
	 * 
	 * @return String - número de um endereço
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Altera o número de um endereço
	 * 
	 * @param numero
	 *            String - número de um endereço
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna o complemento de um endereço
	 * 
	 * @return String - complemento de um endereço
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Altera o complemento de um endereço
	 * 
	 * @param complemento
	 *            String - novo complemento de um endereço
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Retorna o bairro de um endereço
	 * 
	 * @return String - bairro de um endereço
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Altera o bairro de um endereço
	 * 
	 * @param bairro
	 *            String - novo bairro de um endereço
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Retorna o CEP de um endereço
	 * 
	 * @return String - CEP de um endereço
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Altera o CEP de um endereço
	 * 
	 * @param cep
	 *            String - novo CEP de um endereço
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Retorna a latitude de um endereço
	 * 
	 * @return double - latitude de um endereço
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Altera a latitude de um endereço
	 * 
	 * @param latitude
	 *            double - nova latitude de um endereço
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Retorna a longitude de um endereço
	 * 
	 * @return double - longitude de um endereço
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Altera a longitude de um endereço
	 * 
	 * @param longitude
	 *            double - nova longitude de um endereço
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Retorna o município de um endereço
	 * 
	 * @return Municipio - município de um endereço
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * Altera o município de um endereço
	 * 
	 * @param municipio
	 *            Municipio - novo município de um endereço
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * Retorna o tipo de localização de um endereço
	 * 
	 * @return TipoLocalizacaoEnum - tipo de localização de um endereço
	 */
	public TipoLocalizacaoEnum getTipoLocalizacao() {
		return tipoLocalizacao;
	}

	/**
	 * Altera o tipo de localização de um endereço
	 * 
	 * @param tipoLocalizacao
	 *            TipoLocalizacaoEnum - novo tipo de localização de um endereço
	 */
	public void setTipoLocalizacao(TipoLocalizacaoEnum tipoLocalizacao) {
		this.tipoLocalizacao = tipoLocalizacao;
	}

}
