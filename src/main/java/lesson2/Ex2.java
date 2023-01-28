package lesson2;

public class Ex2 {

    public static int temp = 1;

    private static String doSimpleString(String str) {
//        if (str.trim().length() == 0) {
        if (str.isBlank()) {
            return "";
        }

        int counter = 1;
        StringBuilder sb = new StringBuilder();
        char prev;
        char curr = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            curr = str.charAt(i);
            prev = str.charAt(i - 1);

            if (curr != prev) {
                sb.append(prev);
                sb.append((counter > 1) ? counter : "");
                counter = 0;
            }

            counter++;
        }
        if (counter != 0) {
            sb.append(curr);
            sb.append((counter > 1) ? counter : "");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();
        StringBuilder new_line = new StringBuilder();
        line.append("qqqqqwwwweeeqqqwwweeewwwqqqqqqqqeeeeeeedeeeeet");
        System.out.println(line);

        for (int i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) != line.charAt(i + 1)) {
                new_line.append(line.charAt(i));
                if (temp != 1) {
                    new_line.append(temp);
                    temp = 0;
                }
            }
            temp++;
        }
        append_symbol(new_line, line, line.length() - 1);
        System.out.println(new_line);
    }

    static void append_symbol(StringBuilder new_line, StringBuilder line, int i) {

    }
}