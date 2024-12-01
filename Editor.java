/**
* TextEditor++
*  ControlPanel
*/

package appdata;





import java.awt.EventQueue;





/**
*
*/
public class ControlPanel {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Launch the application
		 */
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				@SuppressWarnings("unused")
				Editor application = new Editor();
			}
			
		});
	}
	
}
