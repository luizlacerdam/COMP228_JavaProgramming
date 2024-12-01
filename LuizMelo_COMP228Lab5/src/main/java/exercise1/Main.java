package exercise1;

import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Game Player Application");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 500);
      frame.setLayout(new BorderLayout());

      JTabbedPane tabbedPane = new JTabbedPane();
      tabbedPane.addTab("Insert Players", InsertPlayerTab.createInsertPlayerTab());
      tabbedPane.addTab("Insert Games", InsertGameTab.createInsertGameTab());
      tabbedPane.addTab("Insert Player and Game", InsertPlayerAndGameTab.createInsertPlayerAndGameTab());

      frame.add(tabbedPane, BorderLayout.CENTER);
      frame.setVisible(true);
    });
  }
}
