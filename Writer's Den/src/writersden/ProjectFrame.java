package writersden;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.List;


public class ProjectFrame extends JFrame {

    public ProjectFrame(ProjectManager projectManager) {
        super("Load Project");//HEADER OF FRAME
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //CREATE LIST OF EXISTING PROJECTS
        DefaultListModel<String> projectsModel = new DefaultListModel<>();
        JList<String> projectsList = new JList<>(projectsModel);
        projectsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        try {
            //ADD ELEMENTS ON FRAME ACCORDING TO THE EXISTING PROJECTS IN DIRECTORY
            List<String> projectNames = projectManager.listProjects();
            projectNames.forEach(projectsModel::addElement);
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
