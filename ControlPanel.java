/**
 * TextEditor++
 * Control panel
 */

package appdata;





import java.awt.*;


/**
 *
 */
public class ControlPanel {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        /**
         * Launch the application
         */
        EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                Editor application = new Editor();
            }
        });
    }
}
