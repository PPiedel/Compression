package src;

import javafx.application.Application;
import javafx.stage.Stage;
import src.algorithms.CompressionService;
import src.algorithms.ZipService;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        CompressionService zipAlgorithm = new ZipService();
        String target = "compressed.zip";
        String source = "file.txt";
        zipAlgorithm.compressFile(source, target);
        zipAlgorithm.decompressFile(target, "decompressed");
    }

    public static void main(String[] args) {
        launch(args);

    }
}
