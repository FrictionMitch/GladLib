public class Main {

    public static void main(String[] args) {
        GladLib gl = new GladLib();
//        gl.makeStory();
        CodonCount code = new CodonCount();
        code.test(0, 1, 5);
        code.test(1, 1, 5);
        code.test(2, 1, 5);
//        System.out.println(code.getMostCommonCodon());
//        code.printCodonCount(1, 5);

        WordsInFiles words = new WordsInFiles();
        words.test();
    }
}
