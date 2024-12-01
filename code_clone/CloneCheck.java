package code_clone;

import IO.ProjectReader;
import console.Command;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class CloneCheck {

    static ArrayList<String> ProjectFileName1 = new ArrayList<>();
    static ArrayList<String> ProjectFileName2 = new ArrayList<>();
    public static String path1;
    public static String path2;

    public String pathGenerate(String projectName) {
        String currentpath = Command.currentPath;
        currentpath = new Command().pathGenerate(currentpath);
        String current = currentpath.replaceAll("\\\\", "-").replace(":", "");//location of current file
        String Pathname = "H:\\2-1\\project\\ProcessAllFiles" + "\\ProcessFile$" + current + "-" + projectName;

        return Pathname;
    }

    public void getFileListforProject1(String projectOne) throws IOException {
        String Pathname1 = pathGenerate(projectOne);
        ProjectReader.getFileList(projectOne, Pathname1, ProjectFileName1);

    }

    public void getFileListforProject2(String projectTwo) throws IOException {
        String Pathname2 = pathGenerate(projectTwo);
        ProjectReader.getFileList(projectTwo, Pathname2, ProjectFileName2);

    }

    /*   public void getFileList1(String project1) {

        String currentpath = Command.currentPath;
        String current = currentpath.replaceAll("\\\\", "-").replace(":", "");//location of current file
        String Pathname1 = "H:\\coding_helper" + "\\ProcessFile$" + current + "-" + project1;
        File folder = new File(Pathname1);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].toString().endsWith(".txt")) {
                //  String newFilename = listOfFiles[i].getName().replaceAll(".{3}$", "java");
                ProjectFileName1.add(listOfFiles[i].getName().replaceAll(".{3}$", "java"));
            }
        }

    }

    public void getFileList2(String project2) {

        String currentpath = Command.currentPath;
        String current = currentpath.replaceAll("\\\\", "-").replace(":", "");//location of current file
        String Pathname2 = "H:\\coding_helper" + "\\ProcessFile$" + current + "-" + project2;
        File folder = new File(Pathname2);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].toString().endsWith(".txt")) {
                //  String newFilename = listOfFiles[i].getName().replaceAll(".{3}$", "java");
                ProjectFileName2.add(listOfFiles[i].getName().replaceAll(".{3}$", "java"));
            }
        }

    }
     */
    public void Code_clone(String project1, String project2) throws IOException {
        // Step 1: Generate paths
        path1 = generateProjectPath(project1);
        path2 = generateProjectPath(project2);

        // Step 2: Preprocess project files
        preprocessProjectFiles(project1, path1, ProjectReader.projectOne);
        preprocessProjectFiles(project2, path2, ProjectReader.projectTwo);

        // Step 3: Retrieve file lists
        retrieveFileList(project1, path1, ProjectFileName1);
        retrieveFileList(project2, path2, ProjectFileName2);

        // Step 4: Perform TF-IDF and cosine similarity calculations
        performTfIdfCalculations(path1, path2);
        new CosineSimilarity().getCosinesimilarity();

        // Step 5: Display results using a chart
        new BoxAndWhiskerChart().display();

        // Step 6: Clear static data
        clearStaticData();
    }
}
