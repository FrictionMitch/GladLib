import edu.duke.FileResource;

import java.util.HashMap;
import java.util.Map;

public class CodonCount {
    private HashMap<String, Integer>codonMap;

    public CodonCount() {
        codonMap = new HashMap<String, Integer>();
    }

    public void buildCodonMap(int start, String dna) {
        codonMap.clear();
        dna = dna.trim();
        int count = 1;
        for(int i=start; i< dna.length()-2; i++) {
            String codon = dna.substring(i, i+3);
//            int count = 1;
//            if(!codonMap.containsKey(dna.substring(i, i+3))) {
            if(!codonMap.containsKey(codon)) {
//                codonMap.put(dna.substring(i, i + 3), 1);
                codonMap.put(codon, count);
                i+=2;
            } else {
                count++;
                codonMap.put(codon, count);
                i+=2;
            }
        }
    }

    public String getMostCommonCodon() {
        int max = 0;
        String maxString = "";
//        for(int i =0; i< codonMap.size(); i++) {
//
//        }
        for(String codon : codonMap.keySet()) {
            if(codonMap.get(codon) > max) {
                max = codonMap.get(codon);
                maxString = codon;
            }
        }
        return maxString;
    }


    public void printCodonCount(int start, int end) {
        for(String codon : codonMap.keySet()) {
            if(codonMap.get(codon) >= start && codonMap.get(codon) <= end) {
                System.out.println(codon + "\t " + codonMap.get(codon));
            }
        }
    }

    public void test(int frame, int start, int end) {
//        int frame = 2;
//        int start = 1;
//        int end = 5;
        FileResource resource = new FileResource();
        String dnaStrand = "";
        for(String word : resource.words()) {
            dnaStrand += word;
        }
        dnaStrand = dnaStrand.trim().toUpperCase();
        buildCodonMap(frame, dnaStrand);
//        buildCodonMap(frame, "CGTTCAAGTTCAA");
//        System.out.println(codonMap);
        System.out.println("Reading frame starting with " + frame +", results in " + codonMap.size() + " unique codons");
        System.out.println("The most common codon is: " + getMostCommonCodon() + " with a count of " + codonMap.get(getMostCommonCodon()));
        System.out.println("Counts of codons between " + start + " and " + end + " are:");
        printCodonCount(start, end);
    }
}
