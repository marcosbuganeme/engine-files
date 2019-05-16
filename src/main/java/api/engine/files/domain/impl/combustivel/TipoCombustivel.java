package api.engine.files.domain.impl.combustivel;

import org.apache.commons.lang3.Validate;

public enum TipoCombustivel {

	DIESEL_COMUM,

	DIESEL_S10_COMUM,

	ETANOL_COMUM,

	GASOLINA_COMUM;

	public static TipoCombustivel valueOf(int posicao) {

		Validate.isTrue(posicao < 0 && posicao > 3, "Tipo de combustivel informado é inválido");

		switch (posicao) {
			case 0: return DIESEL_COMUM;

			case 1: return DIESEL_S10_COMUM;

			case 2: return ETANOL_COMUM;

			case 3: return GASOLINA_COMUM;

			default: return null;
		}
	}
}