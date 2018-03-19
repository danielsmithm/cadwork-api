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

@Entity
@Table(name = "endereco", schema = "localizacao")
public class Endereco {

	@Id	
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private double latitude;
	private double longitude;
	
	@Column(name = "tipo_localizacao")
	@Enumerated(EnumType.ORDINAL)
	private TipoLocalizacaoEnum tipoLocalizacao;

	@OneToOne
	@JoinColumn(name = "id_municipio")
	private Municipio municipio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public TipoLocalizacaoEnum getTipoLocalizacao() {
		return tipoLocalizacao;
	}

	public void setTipoLocalizacao(TipoLocalizacaoEnum tipoLocalizacao) {
		this.tipoLocalizacao = tipoLocalizacao;
	}

}
