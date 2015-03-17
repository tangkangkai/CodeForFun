public String replaceAEIOU(String str) {
	if (str == null || str.length() == 0) {
		return str;
	}

	StringBuilder builder = new StringBuilder();
	builder.append(str);
	int exemptIndex = 0;
	int exemptCount = 0;

	// get the exempt index
	while (exemptCount < 3) {
		if (exemptIndex >= str.length()) {
			return str;
		}

		char currChar = str.charAt(exemptIndex);
		if (isVowel(currChar)) {
			exemptCount++;
		}
		exemptIndex++;
	}

	// replace from end to start
	int replaceNum = 0;
	for (int i = str.length() - 1; i >= exemptIndex; i--) {
		if (replaceNum >= 4) {
			break;
		}

		char currChar = str.charAt(i);
		if (isVowel(currChar)) {
			builder.setCharAt(i, (char) (currChar - ('a' - 'A')));
			replaceNum++;
		}
	}

	return builder.toString();
}

public boolean isVowel(char c) {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}