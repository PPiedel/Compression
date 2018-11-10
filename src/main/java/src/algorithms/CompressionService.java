package src.algorithms;

public interface CompressionService {
    void compressFile(String targetPath, String destinationFilePath);

    void decompressFile(String targetPath, String destinationFilePath);
}
