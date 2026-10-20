/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package writersden;

/**
 *
 * @author User
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuFrame extends JFrame {
    
    public MenuFrame() {
    super("Writer's Den");
    
    ProjectManager pm = new ProjectManager();
    
    //main enu
    JMenu menu = new JMenu("Menu");
    
    //newProject and loadProject
    JMenuItem newProject = new JMenuItem("New Project");
    JMenuItem loadProject = new JMenuItem("Load Project");
    menu.add(newProject);
    menu.add(loadProject);
    
    //EACH OF THE THREE MENU ITEMS HAS A UNIQUE ACTION THEY MUST LISTEN TO
    
    //NEW PROJECT ITEM TO ADD PROJECT TO PROJECTS FOLDER
    newProject.addActionListener(
    new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            pm.addNewProject();//add directory with two subdirectories
        }
    });

    //NEW FRAME WITH EXISTING PROJECTS
    loadProject.addActionListener(
    new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            //Frame to show existing projects
            ProjectFrame projectFrame = new ProjectFrame(pm);
            projectFrame.setVisible(true);
        }
    });
    
    
    //Exit
    JMenuItem exitItem = new JMenuItem("Exit");
    menu.add(exitItem);
    
    //Actionlistener to close application
    exitItem.addActionListener(
    new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
            System.exit(0);//exit application
        }
    });
    
    //creating menu bar
    JMenuBar bar = new JMenuBar();
    setJMenuBar(bar);
    bar.add(menu);
}   
}  
    
