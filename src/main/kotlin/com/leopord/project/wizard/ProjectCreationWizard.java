package com.leopord.project.wizard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectCreationWizard extends JPanel implements ActionListener {
    private JList myProjectTypes;
    private JPanel myRoot;
    private JPanel myProjectUI;
    private JButton myPreviousBtn;
    private JButton myNextBtn;
    private JButton myCancelBtn;

    public ProjectCreationWizard() {
        myPreviousBtn.addActionListener(this);
        myCancelBtn.addActionListener(this);
        myNextBtn.addActionListener(this);

        add(myRoot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public JList getMyProjectTypes() {
        return myProjectTypes;
    }

    public JPanel getMyProjectUI() {
        return myProjectUI;
    }
}
