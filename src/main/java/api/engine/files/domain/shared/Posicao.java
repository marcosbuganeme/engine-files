package api.engine.files.domain.shared;

import org.apache.commons.lang3.Validate;

public final class Posicao implements Comparable<Posicao> {
 
    private final int inicio;
    private final int fim;

    public Posicao(int inicio, int fim) {
        Validate.isTrue(fim >= inicio, "Posição informada é inválida");

        this.inicio = inicio;
        this.fim = fim;
    }

    public static Posicao of(int inicio, int fim) {
      return new Posicao(inicio, fim);
    }

    public int getInicio() {
      return inicio - 1;
    }

    public int getTamanho() {
      return fim - inicio + 1;
    }

    public int getFim() {
      return fim;
    }

    public @Override int compareTo(Posicao outro) {
      return Integer.compare(fim, outro.getFim());
    }
  
    public @Override String toString() {
      return String.format("Posicao [inicio=%s, fim=%s]", inicio, fim);
    }
}