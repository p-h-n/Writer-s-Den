package writersden;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.swing.*;



public class ProjectFrame extends JFrame {

    public ProjectFrame(ProjectManager projectManager) {
        super("Load Project");//HEADER OF FRAME
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //CREATE LIST OF EXISTING PROJECTS
        DefaultListModel<String> projectsModel = new DefaultListModel<>();
        JList<String> projectsList = new JList<>(projectsModel);
        projectsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Action displayDesktop = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                ContentWindow contents = new ContentWindow();
                contents.setVisible(true);
            }
        };

        try {
            //ADD ELEMENTS ON FRAME ACCORDING TO THE EXISTING PROJECTS IN DIRECTORY
            List<String> projectNames = projectManager.listProjects();
            //projectNames.forEach( projectsModel::addElement);
            for(String project: projectNames){
               projectsModel.addElement(project);
               //ListSelectionListener openDT = new ListSelectionListener(projectNames, displayDesktop);
            }
            /*ADD ACTIONLISTENERS THAT OPEN A DESKTOP PANE 
            WHEN ONE OF THE PROJECTS IN THE LIST
            ARE SELECTED*/
            projectsList.addListSelectionListener(e -> {
               if(!e.getValueIsAdjusting()){
                   String selectedProject = projectsList.getSelectedValue();
                   if(selectedProject != null){
                       ContentWindow contents = new ContentWindow();
                       contents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                       contents.setSize(600, 600);
                        contents.setVisible(true);
                   }
               } 
            });
            /*for(Element project: projectNames){
                project.addActionListener(
                        new ActionListener(){
                            public void actionPerformed(ActionEvent event){
                                
                            }
                        }
                );
            }*/
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Could not load projects: " + e.getMessage(),
                    "Load Project Error",
                    JOptionPane.ERROR_MESSAGE);
            dispose();//CLOSE FRAME AFTER ERROR
            return;
        }
        
     

        //DISPLAY EXISTING PROJECTS
        setLayout(new BorderLayout(8, 8));
        add(new JLabel("Select a project:", SwingConstants.LEFT), BorderLayout.NORTH);
        add(new JScrollPane(projectsList), BorderLayout.CENTER);
        
        //RETURNED IF NO PROJECTS FOUND
        if (projectsModel.isEmpty()) {
            add(new JLabel("No projects found.", SwingConstants.CENTER), BorderLayout.SOUTH);
        }

        setPreferredSize(new Dimension(400, 500));
        pack();
        setLocationRelativeTo(null);
    }
}
