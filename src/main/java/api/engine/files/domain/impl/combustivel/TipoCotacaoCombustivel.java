package api.engine.files.domain.impl.combustivel;

public enum TipoCotacaoCombustivel {

	MINIMO, MEDIO, MAXIMO;

	public static TipoCotacaoCombustivel valueOf(int posicao) {
		switch (posicao) {

			case 0: return MINIMO;

			case 1: return MEDIO;

			case 2: return MAXIMO;

			default:
				return null;
		}
	}
}