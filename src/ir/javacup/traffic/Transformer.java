package ir.javacup.traffic;

public interface Transformer<T, I> {
	T transform(I input);
}
