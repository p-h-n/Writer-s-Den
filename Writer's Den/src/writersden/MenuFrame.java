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
    
    //main enu
    JMenu menu = new JMenu("Menu");
    
    //newProject and loadProject
    JMenuItem newProject = new JMenuItem("New Project");
    JMenuItem loadProject = new JMenuItem("Load Project");
    menu.add(newProject);
    menu.add(loadProject);
    
    /*
    ACTIONLISTENER 
        ACTIONPERFORMED(ACTIONEVENT EVENT)
        
        IF NEW PROJECT IS SELECTED, A NEW FOLDER IS MADE WITH TWO SUBDIRECTORIES:
        OUTLINE AND TRANSCRIPT
        IF LOAD PROJECT IS SELECTED, PREVIOUSLY MADE FOLDERS WITH TITLES
        WITH ACTIVE SUBDIRECTORIES: OUTLINE AND TRANSCRIPT
    */
    
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
    

