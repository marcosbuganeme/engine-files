package api.engine.files.domain.reader;

import java.util.function.BiConsumer;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

import api.engine.files.domain.shared.Posicao;

final class PosicaoReader<T, I> {

    private final BiConsumer<T, I> biConsumer;
    private final Function<String, I> function;

    public PosicaoReader(BiConsumer<T, I> biConsumer, Function<String, I> function) {
        this.biConsumer = biConsumer;
        this.function = function;
    }

    public void load(T obj, Posicao posicao, String linha) {
        String valor = StringUtils.substring(linha, posicao.getInicio(), posicao.getFim());;
        I apply = function.apply(valor);
        biConsumer.accept(obj, apply);
    }
}