import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        int NS = S.length();
        int NT = S.length();
        for (int i = 1; i < NS; ++i) {
            if (S.charAt(i) == '#') {
                int j = i - 1;
                while (j > 0 && S.charAt(j) == '#') {
                    --j;
                }
                if (j > 0 && j < NS - 1) {
                    S = S.substring(0, j - 1) + S.substring(j + 1, NS);
                }
            }
        }
        for (int i = 1; i < NT; i++) {
            if (T.charAt(i) == '#') {
                int j = i - 1;
                while (j > 0 && T.charAt(j) == '#') {
                    j--;
                }
                if (j > 0 && j < NT - 1) {
                    T = T.substring(0, j - 1) + T.substring(j + 1, NT);
                }
            }
        }
        return S.equals(T);
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare().backspaceCompare("ab##", "c#d#"));
    }
}
