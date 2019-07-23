package varargs_simple_addition;

public class Add {

	public String add(int... ns) {
		int sum = 0;
		String result = "";
		for (int n: ns) {
			sum += n;
			result += n + "+";
		}
		result = result.substring(0, result.length()-1) + "=" + sum;
		System.out.println(result);
		return result;
	}

}
