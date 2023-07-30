public class BraceChecker {

    public boolean isValid(String braces) {
        boolean isParenthesisOpen = false;
        boolean isBracketOpen = false;
        boolean isCurlyBraceOpen = false;
        for (int i = 0; i < braces.length(); i++) {
            char currentChar = braces.charAt(i);
            boolean isAnyoneOpen = isParenthesisOpen || isBracketOpen || isCurlyBraceOpen;
            boolean isThisCharClosing = (currentChar == ')') || (currentChar == ']') || (currentChar == '}');
            if (isAnyoneOpen & isThisCharClosing) {
                return false;
            } else {
                switch (currentChar) {
                    case '(':
                        isParenthesisOpen = true;
                        break;
                    case '[':
                        isBracketOpen = true;
                        break;
                    case '{':
                        isCurlyBraceOpen = true;
                        break;
                    case ')':
                        isParenthesisOpen = false;
                        break;
                    case ']':
                        isBracketOpen = false;
                        break;
                    case '}':
                        isCurlyBraceOpen = false;
                        break;
                }
            }
        }
        return !(isParenthesisOpen || isBracketOpen || isCurlyBraceOpen);
    }
}