import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer>codonMap;

    public CodonCount() {
        codonMap = new HashMap<String, Integer>();
    }

    public void buildCodonMap(int start, String dna) {
        codonMap.clear();

        for(int i=start; i< dna.length()-2; i++) {
            String codon = dna.substring(i, i+3);
            int count = 1;
//            if(!codonMap.containsKey(dna.substring(i, i+3))) {
            if(!codonMap.containsKey(codon)) {
//                codonMap.put(dna.substring(i, i + 3), 1);
                codonMap.put(codon, count);
                i+=2;
            } else {
                codonMap.put(codon, count+=1);
                i+=2;
            }
        }
    }

    public void test() {
        buildCodonMap(0, "CGTTCAAGTTCAA");
        System.out.println(codonMap);
    }
}
