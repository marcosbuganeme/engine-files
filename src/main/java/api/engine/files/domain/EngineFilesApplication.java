package api.engine.files.domain;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import api.engine.files.domain.reader.FileReader;
import api.engine.files.domain.reader.LineReader;

@SpringBootApplication
public class EngineFilesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EngineFilesApplication.class, args);

		//InputStream stream = EngineFilesApplication.class.getClassLoader().getResourceAsStream("DR9920161117.TXT");

	}

	public class Teste {

		private String nome;
		private String cpf;

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
	}

	public class TesteFileReader extends FileReader<Teste> {

		private Teste teste;

		public TesteFileReader() {
			add(new TesteLineReader(), test -> this.teste = test);
		}

		public Teste loadStream(InputStream stream) throws IOException {
			return new TesteFileReader().reader(stream);
		}

		public @Override Teste novoObjeto() {
			return new Teste();
		}
	}

	public class TesteLineReader extends LineReader<Teste> {

		public TesteLineReader() {
			put(1, 60, string(Teste::setNome));
			put(61, 72, string(Teste::setCpf));
		}

		public @Override Teste novoObjeto() {
			return new Teste();
		}
	}
}
