package sorting.walkthrough;

public class Util {
	public static boolean VERBOSE = false;

	public static <E> void log(String message, int calln, int depth, E[] a,
			int begin, int end) {
		log(message, calln, depth, a, begin, end, -1);
	}

	public static <E> void log(String message, int calln, int depth, E[] a,
			int begin, int end, int pi) {

		if (Util.VERBOSE) {
			System.out.print(Util.ident(depth) + message + " call # " + calln
					+ ": ");
			System.out.print(a2String(a, begin, end, pi));
			System.out.println(" (" + begin + " - " + end + ")");
		}
	}

	public static String ident(int n) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += "    ";
		}
		return result;
	}

	public static String a2String(Object[] a, int begin, int end, int pi) {
		String result = "[";
		boolean first = true;
		for (int i = 0; i < begin; i++) {
			if (first)
				first = !first;
			else
				result += ", ";
			result = append(a, result, i, pi);
		}
		if (!first) {
			result += ", ";
			first = true;
		}

		result += "[";
		for (int i = begin; i <= end; i++) {
			if (first)
				first = !first;
			else
				result += ", ";
			result = append(a, result, i, pi);
		}
		result += "]";

		for (int i = end + 1; i < a.length; i++) {
			if (first)
				first = !first;
			else
				result += ", ";
			result = append(a, result, i, pi);
		}
		result += "]";
		return result;
	}

	static String append(Object[] a, String result, int i, int pi) {
		if (i == pi)
			result += "<";
		result += a[i];
		if (i == pi)
			result += ">";
		return result;
	}
}
