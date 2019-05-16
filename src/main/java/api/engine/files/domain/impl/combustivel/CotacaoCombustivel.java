package api.engine.files.domain.impl.combustivel;

public final class CotacaoCombustivel {

	private String razaoSocial;
	private String nomeFantasia;
	private String municipio;
	private String bairro;
	private TipoCombustivel tipoCombustivel;
	private TipoCotacaoCombustivel tipoCotacaoCombustivel;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public TipoCotacaoCombustivel getTipoCotacaoCombustivel() {
		return tipoCotacaoCombustivel;
	}

	public void setTipoCotacaoCombustivel(TipoCotacaoCombustivel tipoCotacaoCombustivel) {
		this.tipoCotacaoCombustivel = tipoCotacaoCombustivel;
	}
}