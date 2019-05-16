package api.engine.files.domain.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class FileReader<T> {

    private List<LineLoader<?>> lines;

    public FileReader() {
        lines = new ArrayList<>();
    }

    public T reader(InputStream inputStream) throws IOException {
        load(inputStream);

        return novoObjeto();
    }

    protected abstract T novoObjeto();

    protected <E> void add(LineReader<E> lineReader, Consumer<E> consumer) {
        lines.add(new LineLoader<>(lineReader, consumer));
    }

    protected void load(InputStream inputStream) throws IOException {

        String contentFile = IOUtils.toString(inputStream, "UTF-8");
        for (String line: contentFile.split(StringUtils.LF)) {
            lines
            .stream()
            .findFirst()
            .ifPresent(lineLoader -> lineLoader.load(line));
        }
    }
}