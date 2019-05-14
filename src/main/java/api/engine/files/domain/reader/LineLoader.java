package api.engine.files.domain.reader;

import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

final class LineLoader<T> {

    private final Consumer<T> consumer;
    private final LineReader<T> lineReader;

    public LineLoader(LineReader<T> lineReader, Consumer<T> consumer) {
        this.consumer = consumer;
        this.lineReader = lineReader;
    }

    public void load(String linha) {
        T linhaCarregada = lineReader.build(linha);
        consumer.accept(linhaCarregada);
    }

    public boolean startWith(String linha) {
        return StringUtils.startsWith(linha, lineReader.getTipo());
      }
}