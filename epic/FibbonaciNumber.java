public List<Integer> getFibbonaciNumber(int start, int end) {
	List<Integer> resList = new ArrayList<>();
	if (start > end) {
		return resList;
	}

	int init = 0;
	for (int i = 1; (init = generate(i)) <= end; i++) {
		int prev = i;
		int curr = 2 * i;
		StringBuilder builder = new StringBuilder();
		builder.append(init);
		while (init <= end) {
			resList.add(init);
			int next = prev + curr;
			prev = curr;
			curr = next;
			builder.append(next);
			init = Integer.valueOf(builder.toString());
		}
	}

	return resList;
}

public int generate(int num) {
	StringBuilder builder = new StringBuilder();
	builder.append(num);
	builder.append(num);
	builder.append(num * 2);
	return Integer.valueOf(builder.toString());
}

@Test
public void test1() {
	System.out.println(getFibbonaciNumber(112, 555555));
}