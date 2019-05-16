package api.engine.files.domain.reader;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.apache.commons.lang3.math.NumberUtils;

import api.engine.files.domain.shared.Posicao;

public abstract class LineReader<T> {

    static final DateTimeFormatter DATA_PATTERN = DateTimeFormatter.ofPattern("yyyyMMdd");
    static final DateTimeFormatter HORA_PATTERN = DateTimeFormatter.ofPattern("HHmmss");

    private final Map<Posicao, PosicaoReader<T, ?>> map;

    protected LineReader() {
        map = new LinkedHashMap<>();
    }

    public abstract T novoObjeto();

    public T build(String linha) {
        T obj = novoObjeto();
        load(obj, linha);
        return obj;
      }

    protected LineReader<T> put(int inicio, int fim, PosicaoReader<T, ?> posicaoReader) {
        map.put(Posicao.of(inicio, fim), posicaoReader);
        return this;
      }

    protected PosicaoReader<T, BigDecimal> number(BiConsumer<T, BigDecimal> biConsumer) {
        return new PosicaoReader<>(biConsumer, informacao -> NumberUtils.createBigDecimal(informacao));
    }

    protected PosicaoReader<T, String> string(BiConsumer<T, String> biConsumer) {
        return new PosicaoReader<>(biConsumer, informacao -> informacao);
    }

    protected PosicaoReader<T, LocalDate> date(BiConsumer<T, LocalDate> biConsumer) {
        return new PosicaoReader<>(biConsumer, informacao -> LocalDate.parse(informacao, DATA_PATTERN));
    }

    protected PosicaoReader<T, LocalTime> time(BiConsumer<T, LocalTime> biConsumer) {
        return new PosicaoReader<>(biConsumer, informacao -> LocalTime.parse(informacao, HORA_PATTERN));
    }

    private void load(T obj, String linha) {
        map
        .entrySet()
        .forEach(posicaoReader -> posicaoReader.getValue().load(obj, posicaoReader.getKey(), linha));
      }
}