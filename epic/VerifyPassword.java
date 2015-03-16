/*
 * Verify if the given password is valid/invalid. 1. must be 5-12 characters
 * long 2. must contain at least one number and one lowercase character 3. a
 * sequence must not be followed by the same sequence (like 123123qs is
 * invalid, 123qs123 is valid)
 */

public boolean verifyPassword(String password) {
	// Requirement 1
	if (password == null || password.length() < 5 || password.length() > 12) {
		return false;
	}

	// Requirement 2 & 3
	boolean hasNumber = false;
	boolean hasLowercase = false;

	// key: character, value: list of indexes
	Map<Character, List<Integer>> map = new HashMap<>();

	for (int i = 0; i < password.length(); i++) {
		char currChar = password.charAt(i);
		if (isNumber(currChar)) {
			hasNumber = true;
		}

		if (isLowerCase(currChar)) {
			hasLowercase = true;
		}

		if (map.containsKey(currChar)) {
			List<Integer> list = map.get(currChar);
			for (int index : list) {
				if (password.length() - i > i - index
						&& password.substring(index, i).equals(
								password.substring(i, 2 * i - index))) {
					return false;
				} else {
					List<Integer> newList = new ArrayList<>(list);
					newList.add(i);
					map.put(currChar, newList);
				}
			}
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(i);
			map.put(currChar, list);
		}
	}
	return hasNumber && hasLowercase;
}

public boolean isNumber(char c) {
	return c >= '0' && c <= '9';
}

public boolean isLowerCase(char c) {
	return c >= 'a' && c <= 'z';
}

@Test
public void test() {
	Assert.assertFalse(verifyPassword("123123qs"));
	Assert.assertTrue(verifyPassword("123qs123"));
}