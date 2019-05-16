package api.engine.files.domain.impl.combustivel;

import api.engine.files.domain.reader.LineReader;

public class CotacaoLineReader extends LineReader<CotacaoCombustivel> {

	public CotacaoLineReader() {

		put(1, 60, string(CotacaoCombustivel::setRazaoSocial));
		put(61, 72, string(CotacaoCombustivel::setNomeFantasia));
		put(1, 60, string(CotacaoCombustivel::setMunicipio));
		put(61, 72, string(CotacaoCombustivel::setBairro));
		put(1, 60, string(CotacaoCombustivel::setTipoCombustivel));
		put(61, 72, string(CotacaoCombustivel::setTipoCotacaoCombustivel));
	}

	public @Override CotacaoCombustivel novoObjeto() {
		return null;
	}
}