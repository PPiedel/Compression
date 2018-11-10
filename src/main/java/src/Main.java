package src;

import src.algorithms.CompressionService;
import src.algorithms.ZipService;


public class Main {

    public static void main(String[] args) {
        CompressionService zipAlgorithm = new ZipService();
        String target = "compressed.zip";
        String source = "file.mkv";
        zipAlgorithm.compressFile(source, target);
        zipAlgorithm.decompressFile(target, "decompressed");

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Total memory used : " + (double) memory / (double) 1000000 + " megabytes");
    }
}
