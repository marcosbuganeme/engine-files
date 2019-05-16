package api.engine.files.domain.impl.combustivel;

import java.io.IOException;
import java.io.InputStream;

import api.engine.files.domain.EngineFilesApplication.Teste;
import api.engine.files.domain.reader.FileReader;

public class CotacaoFileReader extends FileReader<CotacaoCombustivel> {

	private CotacaoCombustivel cotacaoCombustivel;

	public CotacaoFileReader() {
		add(new CotacaoLineReader(), cotacao -> this.cotacaoCombustivel = cotacao);
	}

	public Teste loadStream(InputStream stream) throws IOException {
		return new CotacaoFileReader().reader(stream);
	}

	public @Override CotacaoCombustivel novoObjeto() {
		return new CotacaoCombustivel();
	}
}
