package pruebas.pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> results = new ArrayList<>();

		// Imperativa, como lo voy a hacer
		for (Integer i : nums) {
			if (i % 2 == 0) {
				results.add(i);
			}
		}
		System.out.println(results);

		// Funcional, que quiero hacer
		List<String> resultsString = nums.stream().filter(Main::esPar).map(a -> "Número: " + a.toString())
				.collect(Collectors.toList());
		System.out.println(resultsString);

		// Lambdas

		Thread hilo = new Thread(new Hilo());
		hilo.start();

		Thread hilo1 = new Thread(() -> System.out.println("Hola desde el hilo1"));
		hilo1.start();

		Suma sum = (n1, n2) -> n1 + n2;
		System.out.println(sum.suma(3, 2));

		List<Integer> n = Arrays.asList(5, -5, 2, -2, 7, -7, 0, 12, -24, 32, -64, 128);

		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar = (list, predicado) -> {
			List<Integer> r = new ArrayList<>();
			for (Integer i : list) {
				if (predicado.test(i)) {
					r.add(i);
				}
			}
			return r;
		};
		System.out.println(filtrar.apply(n, x -> x > 0));
	}

	static boolean esPar(int n) {
		return n % 2 == 0;
	}

	@FunctionalInterface
	interface Suma {
		Integer suma(int n1, int n2);
	}
}
