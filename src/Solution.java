import java.io.*;
import java.util.*;

public class Solution {

    public static class FastScanner {

        private BufferedReader in;
        private BufferedWriter out;
        private StringTokenizer st;

        public FastScanner () {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public FastScanner (String in, String out) throws IOException {
            this.in = new BufferedReader(new FileReader(in));
            this.out = new BufferedWriter(new FileWriter(out));
        }

        public String nextLine () throws IOException {
            return in.readLine();
        }

        public String nextString () throws IOException {
            while ((st == null) || (!st.hasMoreTokens())) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt () throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(nextString());
        }

        public void println (String string) throws IOException {
            out.write(string);
            out.newLine();
        }

        public void print (String string) throws IOException {
            out.write(string);
        }

        public void  close () throws IOException {
            in.close();
            out.close();
        }
    }

    public static long damage (String P) {
        long ans=0;
        long d=1;
        for (int i = 0; i < P.length(); i++) {
            if (P.charAt(i)=='S') {
                ans+=d;
            }
            else {
                d*=2;
            }
        }
        return ans;
    }

    public static String solve (int D, String P) {
        int nbS=0;
        for (int i = 0; i < P.length(); i++) {
            if (P.charAt(i)=='S') {
                nbS++;
            }
        }
        int nbC=P.length()-nbS;
        if (nbS>D) {
            return "IMPOSSIBLE";
        }
        else if ((nbS==0)||(nbC==0)) {
            return "0";
        }
        int hacks=0;
        while (damage(P)>D) {
            int lastS=-1;
            for (int i = P.length()-1; i >= 0; i--) {
                if (P.charAt(i)=='S') {
                    lastS=i;
                    break;
                }
            }
            int lastC=-1;
            for (int i = lastS; i >= 0; i--) {
                if (P.charAt(i)=='C') {
                    lastC=i;
                    break;
                }
            }
            if (lastC==-1) {
                return "0";
            }
            hacks++;
            P=P.substring(0,lastC)+P.substring(lastC+1,lastC+2)+P.substring(lastC,lastC+1)+P.substring(lastC+2,P.length());
        }
        return hacks+"";
    }

    public static void main (String[] Args) throws IOException {
        //String fileName = "A-small-practice";
        //FastScanner fastScanner = new FastScanner(fileName+".in",fileName+".out");
        FastScanner fastScanner = new FastScanner();
        int T = fastScanner.nextInt();
        for (int i = 0; i < T; i++) {
            int D = fastScanner.nextInt();
            String P = fastScanner.nextString();
            String ans = solve(D,P);
            fastScanner.println("Case #"+(i+1)+": "+ans);
        }
        fastScanner.close();
    }
}
