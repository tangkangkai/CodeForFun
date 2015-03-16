public boolean validPass(String input, String expected) {
	// base handle
	char missingKey = 'k';

	int i = 0;
	int j = 0;

	for (; i < input.length() && j < expected.length(); i++, j++) {
		if (input.charAt(i) != expected.charAt(j)) {
			if (missingKey == 'k') {
				missingKey = expected.charAt(j);
			} else {
				if (missingKey != expected.charAt(j)) {
					return false;
				}
			}
			i--;
		}
	}

	for (; j < expected.length(); j++) {
		if (expected.charAt(j) != missingKey) {
			return false;
		}
	}

	return true;
}