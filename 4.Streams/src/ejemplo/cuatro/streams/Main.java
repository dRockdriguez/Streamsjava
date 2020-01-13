package ejemplo.cuatro.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private static List<User> users;

	public static void main(String[] args) {
		setUpUsers();

		// For each
		System.out.println("FOREACH");
		System.out.println("************************************");
		users.stream().forEach((user) -> user.setName(user.getName() + " Hola"));
		imprimirLista();

		// Map
		System.out.println();
		System.out.println("MAP");
		System.out.println("************************************");
		List<String> lista = users.stream().map(User::toString).collect(Collectors.toList());
		lista.stream().forEach((i) -> System.out.println(i));

		// Filter
		System.out.println();
		System.out.println("FILTER");
		System.out.println("************************************");
		setUpUsers();
		List<User> fil = users.stream().filter((u) -> !u.getName().equals("Alberto"))
				.filter((user) -> user.getId() != 3).collect(Collectors.toList());
		fil.stream().forEach((i) -> System.out.println(i));

		// FindFirst
		System.out.println();
		System.out.println("FINDFIRST");
		System.out.println("************************************");
		setUpUsers();
		User u = users.stream().filter((user) -> user.getName().equals("Alberasdfto")).findFirst()
				.orElse(new User(0, "No existe"));
		System.out.println(u);

		// FlatMap
		System.out.println();
		System.out.println("FLATMAP");
		System.out.println("************************************");
		setUpUsers();
		List<List<String>> nombres = new ArrayList<>(
				Arrays.asList(new ArrayList<String>(Arrays.asList("Alberto", "Manolo", "Joselito", "Marisol")),
						new ArrayList<String>(Arrays.asList("Victor", "Manuel", "David", "Pablo"))));

		List<String> n = nombres.stream().flatMap(e -> e.stream()).collect(Collectors.toList());

		n.stream().forEach(s -> System.out.println(s));

		// Peek
		System.out.println();
		System.out.println("PEEK");
		System.out.println("************************************");
		setUpUsers();
		List<User> uPeek = users.stream().peek(e -> e.setName(e.getName() + " Adios")).filter(e -> e.getId() % 2 == 0)
				.collect(Collectors.toList());

		uPeek.stream().forEach(e -> System.out.println(e));

		// Count
		System.out.println();
		System.out.println("COUNT");
		System.out.println("************************************");
		setUpUsers();

		long numeroFiltrado = users.stream().filter(e -> e.getId() % 2 == 0).count();
		System.out.println("N�mero de ids pares " + numeroFiltrado);

		// Skip y Limit
		System.out.println();
		System.out.println("SKIP Y LIMIT");
		System.out.println("************************************");
		String[] abc = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "�", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		List<String> abcFilter = Arrays.stream(abc).skip(2).limit(3).collect(Collectors.toList());
		abcFilter.stream().forEach(e -> System.out.println(e));

		// Sorted
		System.out.println();
		System.out.println("SORTED");
		System.out.println("************************************");
		setUpUsers();
		users = users.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
		imprimirLista();

		// min y max
		System.out.println();
		System.out.println("MIN Y MAX");
		System.out.println("************************************");
		setUpUsers();
		User min = users.stream().min(Comparator.comparing(User::getId)).orElse(new User(0, "No existe"));
		System.out.println("Min: " + min);
		User max = users.stream().max(Comparator.comparing(User::getId)).orElse(new User(0, "No existe"));
		System.out.println("Max: " + max);

		// distinct
		System.out.println();
		System.out.println("DISTINCT");
		System.out.println("************************************");
		setUpUsers();

		List<User> d = users.stream().distinct().collect(Collectors.toList());
		d.stream().forEach(e -> System.out.println(e));

		// allmatch, any match, nonematch
		System.out.println();
		System.out.println("ALLMATCH, ANYMATCH, NONEMATCH");
		System.out.println("************************************");
		List<Integer> numeros = Arrays.asList(1000, 300, 900, 5000);
		boolean allMatch = numeros.stream().allMatch(num -> num > 301);
		boolean anyMatch = numeros.stream().anyMatch(num -> num > 301);
		boolean noneMatch = numeros.stream().noneMatch(num -> num > 300001);
		System.out.println("ALL MATCH " + allMatch);
		System.out.println("ANY MATCH " + anyMatch);
		System.out.println("NONE MATCH " + noneMatch);

		// sum, average, range
		System.out.println();
		System.out.println("SUM, AVERAGE, RANGE");
		System.out.println("************************************");
		setUpUsers();
		double resultSum = users.stream().mapToInt(User::getId).sum();
		System.out.println("SUM de ids: " + resultSum);

		double resultAverage = users.stream().mapToInt(User::getId).average().orElse(0);
		System.out.println("Media de ids: " + resultAverage);
	}

	private static void setUpUsers() {
		users = new ArrayList<>();
		users.add(new User(1, "Alberto"));
		users.add(new User(2, "Marta"));
		users.add(new User(3, "Maria"));
		users.add(new User(4, "Pablo"));
		users.add(new User(5, "Adolfo"));
		users.add(new User(6, "Alberto"));
	}

	private static void imprimirLista() {
		users.stream().forEach((user) -> System.out.println(user));

	}
}
