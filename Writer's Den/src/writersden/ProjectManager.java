/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package writersden;

/**
 *
 * @author User
 */
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProjectManager {
    /*
    ADDNEWPROJECT() => function that responds to New Project button being clicked. 
    It will create a directory and two subdirectories: outline and transcript
    User must enter name of project in a  smaller GUI, and project will be placed under Load Project.
    
    LOADPROJECT() => function that responds to clicking on an already made project.
    It will close the fram and open another frame, that will allow for you to enter either the 
    outline folder or transcript folder of selected project
    
    ADDNEWFILE() => add new text file for Outline subdirectory
    
    DELETEFILE() => remove selected text file in Outline subdirectory
    
    EDITFILE() => write to selected file
    
    OPENTRANSCRIPT() => opens .odt file that stores the transcript
    
    RETURN() => open menu frame and close project frame
    
    SHOWOUTLINETEXT() => displays list of files stores inside folder. 
    Keeps project window open, but opens new frame that shows list
    */
    
    //CURRENT APP DIRECTORY
    public String path = System.getProperty("user.dir");

    public Path getProjectsDirectory() {
        return Paths.get(path, "Projects");
    }

    public List<String> listProjects() throws IOException {
        Path projectsDirectory = getProjectsDirectory();
        if (!Files.exists(projectsDirectory)) {
            return Collections.emptyList();
        }
        if (!Files.isDirectory(projectsDirectory)) {
            throw new IOException("Projects path is not a directory: " + projectsDirectory);
        }

        try (java.util.stream.Stream<Path> directories = Files.list(projectsDirectory)) {
            return directories
                    .filter(Files::isDirectory)
                    .map(directory -> directory.getFileName().toString())
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(java.util.stream.Collectors.toList());
        }
    }
    
    public void addNewProject(){
        
        String prjName = 
                JOptionPane.showInputDialog("New Project: ");
        
        //DEFINED NESTED SUBDIRECTORIES FOR OUTLINE AND TRANSCRIPT
        Path nOutDir = Paths.get(path, "Projects", prjName, "Outline");//new outline
        Path nTrDir = Paths.get(path, "Projects", prjName, "Transcript");//new transcript
        
        try{            
//create missing parent directories if they aren't there.
            Files.createDirectories(nOutDir);
            Files.createDirectories(nTrDir);
            
            if(Files.isDirectory(nOutDir)){
            System.out.println("Outline made : " + nOutDir.toAbsolutePath());
            }
            
            if(Files.isDirectory(nTrDir)){
            System.out.println("Transcript made : " + nTrDir.toAbsolutePath());
            }
            
        } catch (FileAlreadyExistsException e){
            if(Files.exists(nTrDir) || Files.exists(nOutDir))
            System.err.println("Error: A file of the same name exists.");
        }catch (IOException e) {  
            System.err.println("IO Error: Failed to create directories. Reason: " + e.getMessage());  
        }
    }
}
