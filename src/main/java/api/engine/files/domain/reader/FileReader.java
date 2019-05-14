package api.engine.files.domain.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class FileReader<T> {

    private List<LineLoader<?>> lines;

    public FileReader() {
        lines = new ArrayList<>();
    }

    protected <E> void add(LineReader<E> splitLine, Consumer<E> consumer) {
        lines.add(new LineLoader<>(splitLine, consumer));
      }
}