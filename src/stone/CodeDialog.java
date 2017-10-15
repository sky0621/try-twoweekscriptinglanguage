package stone;

import javax.swing.*;
import java.io.*;

/**
 * Created by SS on 2017/10/16.
 */
public class CodeDialog extends Reader {
    private String buffer = null;
    private int pos = 0;

    /**
     * Reads characters into a portion of an array.  This method will block
     * until some input is available, an I/O error occurs, or the end of the
     * stream is reached.
     *
     * @param cbuf Destination buffer
     * @param off  Offset at which to start storing characters
     * @param len  Maximum number of characters to read
     * @return The number of characters read, or -1 if the end of the
     * stream has been reached
     * @throws IOException If an I/O error occurs
     */
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (buffer == null) {
            String in = showDialog();
            if (in == null) {
                return -1;
            } else {
                print(in);
                buffer = in + "\n";
                pos = 0;
            }
        }
        int size = 0;
        int length = buffer.length();
        while (pos < length && size < len) {
            cbuf[off + size++] = buffer.charAt(pos++);
        }

        if (pos == length) {
            buffer = null;
        }
        return size;
    }

    protected void print(String s) {
        System.out.println(s);
    }

    /**
     * Closes the stream and releases any system resources associated with
     * it.  Once the stream has been closed, further read(), ready(),
     * mark(), reset(), or skip() invocations will throw an IOException.
     * Closing a previously closed stream has no effect.
     *
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        // Nothing
    }

    protected String showDialog() {
        JTextArea area = new JTextArea(20, 40);
        JScrollPane pane = new JScrollPane(area);
        int result = JOptionPane.showOptionDialog(null, pane, "Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        if (result == JOptionPane.OK_OPTION) {
            return area.getText();
        } else {
            return null;
        }
    }

    public static Reader file() throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return new BufferedReader(new FileReader(chooser.getSelectedFile()));
        } else {
            throw new FileNotFoundException("no file specified");
        }
    }
}
