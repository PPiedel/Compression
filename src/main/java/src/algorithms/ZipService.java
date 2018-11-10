package src.algorithms;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;


public class ZipService implements CompressionService {

    @Override
    public void compressFile(String targetPath, String destinationFilePath) {
        removeDestinationFile(destinationFilePath);

        try {
            System.out.println("Zip compression started for file " + targetPath);
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

            ZipFile zipFile = new ZipFile(destinationFilePath);

            File targetFile = new File(targetPath);
            if (targetFile.isFile()) {
                zipFile.addFile(targetFile, parameters);
            } else if (targetFile.isDirectory()) {
                zipFile.addFolder(targetFile, parameters);
            }
            System.out.println("Zip compression finished for file " + targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decompressFile(String targetPath, String destinationFolderPath) {
        try {
            System.out.println("Zip decompression started for file " + targetPath);
            ZipFile zipFile = new ZipFile(targetPath);
            zipFile.extractAll(destinationFolderPath);
            System.out.println("Zip decompression finished for file " + targetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeDestinationFile(String destinationFilePath) {
        File file = new File(destinationFilePath);
        file.delete();
    }
}
