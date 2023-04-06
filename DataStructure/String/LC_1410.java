package DataStructure.String;


public class LC_1410 {

    /*
        1410. HTML 实体解析器
     */
    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"")
                .replaceAll("&apos;", "'")
                .replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<")
                .replaceAll("&frasl;", "/")
                .replaceAll("&amp;", "&");

    }

    public static void main(String[] args) {

        String text = "and I quote: &quot;...&quot;";
        System.out.println(new LC_1410().entityParser(text));
    }
}
