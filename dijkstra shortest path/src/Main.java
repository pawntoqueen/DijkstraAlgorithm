import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static int AVGKomsu(HashMap<String ,Integer> hm){
        int toplam = 0;
        for (String s: hm.keySet()) {
            toplam +=  hm.get(s);
        }
        return toplam / hm.size();
    }

    public static int KenarSayısı(EdgeList el){
        return el.edges.size()/2;
    }

    public static void main(String[] args) throws IOException {
        ShortestPath sp = new ShortestPath();
        EdgeList el = new EdgeList();
        String[] str;
        HashMap<String ,String> ht= new HashMap<>();
        HashMap<String ,Integer> hm= new HashMap<>();


        System.out.println();
        System.out.println();

        FileReader fileReader = new FileReader("dosya.txt");
        String line;
        BufferedReader br = new BufferedReader(fileReader);
        while ((line = br.readLine()) != null) {
            str = line.split(";");
            ht.put(str[0],str[1]);
            hm.put(str[0],0);
            ht.put(str[1],str[0]);
            hm.put(str[1],0);
        }
        br.close();

        for (String s: ht.keySet()) {
            el.addVertex(s);
        }

        fileReader = new FileReader("dosya.txt");
        br = new BufferedReader(fileReader);
        while ((line = br.readLine()) != null) {
            str = line.split(";");
            el.addEdge(str[0],str[1],Integer.parseInt(str[2]));
            hm.put(str[0],hm.get(str[0])+1);
            hm.put(str[1],hm.get(str[1])+1);
        }

        System.out.print("Ortalama Komsuluk sayıları: ");
        System.out.println(AVGKomsu(hm));
        System.out.println();

        System.out.print("Kenar Sayısı: ");
        System.out.println(KenarSayısı(el));

        System.out.println();

        sp.dijkstra2(el,"İstanbul","İzmir");
        sp.dijkstra2(el,"Tekirdağ","Manisa");
        sp.dijkstra2(el,"İstanbul","Afyon");
        sp.dijkstra2(el,"Balıkesir","Antalya");
        sp.dijkstra2(el,"Sakarya","Çanakkale");


    }
}
