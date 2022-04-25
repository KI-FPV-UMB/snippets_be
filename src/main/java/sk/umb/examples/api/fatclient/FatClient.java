package sk.umb.examples.api.fatclient;

import sk.umb.examples.api.api.CounterService;
import sk.umb.examples.api.client.CounterServiceClient;

import java.awt.*;
import java.awt.event.*;

public class FatClient extends Frame {
    private TextField tfCount;

    private final CounterService counterService;

    public static void main(String[] args) {
        new FatClient(new CounterServiceClient());
    }

    public FatClient(CounterService counterService) {
        this.counterService = counterService;
        this.initApp();
    }

    private class BtnCountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            final int actualValue = Integer.parseInt(tfCount.getText());
            final int newValue = counterService.increment(actualValue);

            tfCount.setText(String.valueOf(newValue));
        }
    }

    // -------- Not Interesting -----------------

    private void initApp() {
        setLayout(new FlowLayout());
        Label lblCount = new Label("Counter");
        add(lblCount);

        tfCount = new TextField(String.valueOf(0), 10);
        tfCount.setEditable(false);
        add(tfCount);

        Button btnCount = new Button("Count");
        add(btnCount);

        BtnCountListener listener = new BtnCountListener();
        btnCount.addActionListener(listener);

        setTitle("AWT Counter");
        setSize(300, 100);

        setVisible(true);

        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                dispose();
            }
        });
    }
}