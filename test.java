import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        ArrayList<String>[] L = new ArrayList[4];
        for (int x = 0; x < L.length; x++) {
            L[x] = new ArrayList<>();
        }


        L[0].add("ggg");
        L[0].add("hhh");
        L[1].add("ttt");
        L[2].add("aaa");
        L[3].add("bbb");

        /*for(int i=0;i<L.length;i++){
            for(int j=0;j<L[i].size();j++){
                System.out.println(L[i].get(j));
            }
        }*/
        for(int i=0;i<L.length;i++){
            System.out.println(L[i]);
        }

    }

}
