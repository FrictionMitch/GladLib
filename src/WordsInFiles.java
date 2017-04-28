import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String, ArrayList>wordsMap;
    private ArrayList<String> fileList;
    private int wordCount = 0;

    public WordsInFiles() {
        wordsMap = new HashMap<String, ArrayList>();
        fileList = new ArrayList<String>();
    }

    private void addWordsFromFile(File f) {
        FileResource resource = new FileResource(f);
//        CSVParser parser = f.;
        String fileName = f.getName();
        for(String word : resource.words()) {
            if(!wordsMap.containsKey(word)){
                fileList = new ArrayList<String>();
                wordsMap.put(word, fileList);
            }
            if(wordsMap.containsKey(word)){
                if(!fileList.contains(f.getName())) {
                    fileList.add(f.getName());
                }
            }
        }
    }

    public void buildWordFileMap() {
        wordsMap.clear();
        DirectoryResource dResource = new DirectoryResource();
        for(File file : dResource.selectedFiles()) {
            addWordsFromFile(file);
        }
    }

    public void maxNumber() {
        
    }

    public void test() {
//        FileResource resource = new FileResource();
//        for(String word : resource.words()) {
//            System.out.println(word);
//        }
    }
}
