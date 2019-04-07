package JavaHeadFirstAndOther.StringBuilder;

public class InfoStringBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("это не обязатенльный параметр")
                .append(5)
                .append('h')
                .append(new char[]{'q', '2'});
        System.out.println(sb.toString());
    }
}
