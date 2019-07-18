package phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        if (!this.urls.isEmpty()) {
            for (String url : this.urls) {
                if (validateUrl(url)) {
                    sb.append("Browsing: ").append(url).append("!");
                } else {
                    sb.append("Invalid URL!");
                }
                sb.append(System.lineSeparator());
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        if (!this.numbers.isEmpty()) {
            for (String number : this.numbers) {
                if (validateNumber(number)) {
                    sb.append("Calling... ").append(number);
                } else {
                    sb.append("Invalid number!");
                }
                sb.append(System.lineSeparator());
            }
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private boolean validateNumber(String number) {
        boolean isValid = true;

        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                isValid = false;
            }
        }

        return isValid;
    }

    private boolean validateUrl(String url) {
        List<Character> chars = new ArrayList<>();
        Arrays.stream("1 2 3 4 5 6 7 8 9 0".split("\\s+"))
                .forEach(e -> chars.add(e.charAt(0)));

        boolean isValid = true;
        for (Character aChar : chars) {
            if (url.contains(aChar.toString())) {
                isValid = false;
            }
        }
        return isValid;
    }
}
