class HelloWorld {
    public static void main(String[] args) {
       String s = " Hello! World@ This is a Test !. ";
       String s1 = "";  
       String res = ""; 
       for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           if (ch == '!' || ch == '@' || ch == '$' || ch == '#' || 
               ch == '%' || ch == '^' || ch == '&' || ch == '*' || ch == '.') {
               s1 += ch;  
           } else {
               res += ch;  
           }
       }
       res = res.trim().replaceAll("\\s+", " ");
       String[] words = res.split(" ");
       StringBuilder camelCase = new StringBuilder();
       for (String word : words) {
           if (!word.isEmpty()) {
               
               camelCase.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase())
                        .append(" ");  
           }
       }
       System.out.println(camelCase.toString().trim());
    }
}
