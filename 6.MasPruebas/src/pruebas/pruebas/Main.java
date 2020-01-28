package pruebas.pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> results = new ArrayList<>();

		// Imperativa, como lo voy a hacer
		// ********************************************************************
		for (Integer i : nums) {
			if (i % 2 == 0) {
				results.add(i);
			}
		}
		System.out.println(results);

		// Funcional, que quiero hacer
		// ********************************************************************
		List<String> resultsString = nums.stream().filter(Main::esPar).map(a -> "Número: " + a.toString())
				.collect(Collectors.toList());
		System.out.println(resultsString);

		// Lambdas
		// ********************************************************************
		Thread hilo = new Thread(new Hilo());
		hilo.start();

		Thread hilo1 = new Thread(() -> System.out.println("Hola desde el hilo1"));
		hilo1.start();

		Suma sum = (n1, n2) -> n1 + n2;
		System.out.println(sum.suma(3, 2));

		List<Integer> n = Arrays.asList(5, -5, 2, -2, 7, -7, 0, 12, -24, 32, -64, 128);

		System.out.println(filter(x -> x > 0, n));
		System.out.println(filter(x -> x < 0, n));
		System.out.println(filter(x -> x > 10, n));

		System.out.println(n.stream().distinct().count());
		System.out.println(n.stream().filter(x -> x != 2).count());

		// Funciones puras / no puras
		// ********************************************************************
		List<Prueba> p = new ArrayList<>();
		p.add(new Prueba("a"));
		funcionNoPura(p);
		System.out.println(p);

		System.out.println(funcionPura(p));

		// Reduce
		// ********************************************************************
		n.stream().reduce((accumulator, i) -> {
			return accumulator + i;
		}).ifPresent(v -> System.out.println(v));

		// Optionals
		// ********************************************************************
		Optional<String> opString = Optional.ofNullable(null);
		opString.ifPresentOrElse((str) -> {
			System.out.println(str);
		}, () -> {
			System.out.println("No existe");
		});

		String res = opString.orElseThrow(NullPointerException::new);
		System.out.println(res);
	}

	static List<Prueba> funcionPura(List<Prueba> a) {
		List<Prueba> list = new ArrayList<>();
		Prueba p = new Prueba("");

		p.a = a.get(0).a + "hola";
		list.add(p);
		return list;
	}

	static void funcionNoPura(List<Prueba> a) {
		Prueba b = a.get(0);
		b.a = "cambiado";
	}

	static class Prueba {
		public String a;

		public Prueba(String a) {
			this.a = a;
		}

		@Override
		public String toString() {
			return this.a;
		}
	}

	static List<Integer> filter(Predicate<Integer> pred, List<Integer> list) {
		BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar = (l, predicado) -> {
			return l.stream().filter(predicado).collect(Collectors.toList());
		};
		return filtrar.apply(list, pred);
	}

	static boolean esPar(int n) {
		return n % 2 == 0;
	}

	@FunctionalInterface
	interface Suma {
		Integer suma(int n1, int n2);
	}
}
