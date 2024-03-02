import java.io.File;

import javax.swing.JOptionPane;

public class ExitCommand implements Command {
    private File file;

    public ExitCommand(File file) {
        this.file = file;
    }

    @Override
    public void execute() {
        EmployeeDetails ed = new EmployeeDetails();
        String generatedFileName = null;
        boolean changesMade = false;

        if (file.length() != 0) {
            if (changesMade) {
                int returnVal = JOptionPane.showOptionDialog(ed, "Do you want to save changes?", "Save",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                // if the user chooses to save file, save file
                if (returnVal == JOptionPane.YES_OPTION) {
                    ed.saveFile();
                    // delete generated file if the user saved details to another file
                    if (file.getName().equals(generatedFileName))
                        file.delete();
                    System.exit(0);
                } else if (returnVal == JOptionPane.NO_OPTION) {
                    if (file.getName().equals(generatedFileName))
                        file.delete();
                    System.exit(0);
                }
            } else {
                if (file.getName().equals(generatedFileName))
                    file.delete();
                System.exit(0);
            }
        } else {
            if (file.getName().equals(generatedFileName))
                file.delete();
            System.exit(0);
        }
    }
}