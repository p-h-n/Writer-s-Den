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
import java.util.Random;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;

public class ContentWindow extends JFrame {
    
    private JDesktopPane Contents;//OPENS UP WHEN ONE OF THE PROJECTS ARE SELECTED
    
    //SETTING UP GUI
    public ContentWindow(){
        super("Contents of Project");
        
        JMenuBar bar = new JMenuBar(); //CREATE MENU BAR
        JMenu addMenu = new JMenu(" Add ");// CREATE ADD MENU BUTTON
        JMenuItem newFrame = new JMenuItem( "Internal Frame" );
        
        addMenu.add( newFrame ); //ADD NEW FRAME ITEM TO MENU
        bar.add( addMenu );//ADD MENU TO MENU BAR
        
        setJMenuBar(bar); //SET MENU BAR 
        
        Contents = new JDesktopPane();//CREATE DESKTOP PANE
        add(Contents);//ADD DESKTOP PANE TO FRAME
        
        newFrame.addActionListener(
        new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                //CREATE INTERNAL FRAME
                JInternalFrame frame = new JInternalFrame(
                "Internal Frame", true, true, true, true
                );
                
            }
        });
        
        Contents.setPreferredSize(new Dimension(600, 600));
        
    }
    
}
