package sk.umb.examples.api.fatclient;

import java.awt.*;
import java.awt.event.*;

public class FatClient extends Frame {
    private TextField tfInput;
    private TextField tfName;

    private final PersonServiceImpl personService;

    public static void main(String[] args) {
        new FatClient(new PersonServiceImpl());
    }

    public FatClient(PersonServiceImpl personService) {
        this.personService = personService;
        this.initApp();
    }

    private class BtnCountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            final int actualValue = Integer.parseInt(tfInput.getText());
            final String newValue = personService.getPerson(actualValue).getName();

            tfName.setText(String.valueOf(newValue));
        }
    }

    // -------- Not Interesting -----------------

    private void initApp() {
        setLayout(new FlowLayout());

        tfInput = new TextField(String.valueOf(1), 10);
        tfInput.setEditable(true);
        add(tfInput);

        tfName = new TextField("", 10);
        tfName.setEditable(false);
        add(tfName);

        Button btnCount = new Button("Load Person");
        add(btnCount);

        BtnCountListener listener = new BtnCountListener();
        btnCount.addActionListener(listener);

        setTitle("Person Loader");
        setSize(300, 100);

        setVisible(true);

        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                dispose();
            }
        });
    }
}