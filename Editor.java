/**
 * TextEditor++
 *  Application
 */

//no package







import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;









/**
 * The type Editor.
 */
@SuppressWarnings("serial")
public class Editor extends JFrame implements ActionListener,MouseListener{



    /**
     * @params
     */
    //main menu bar
    private JMenuBar menu_bar = new JMenuBar();

    //file menu
    private JMenu file_menu = new JMenu("File");

    //edit menu
    private JMenu edit_menu = new JMenu("Edit");

    //options menu
    private JMenu options_menu = new JMenu("Options");

    //about menu
    private JMenu about_menu = new JMenu("About");

    //new file
    private JMenuItem new_file = new JMenuItem("new file");

    //open
    private JMenuItem load = new JMenuItem("open");

    //save
    private JMenuItem export = new JMenuItem("save");

    //new window
    private JMenuItem new_window = new JMenuItem("new window");

    //restart
    private JMenuItem reboot = new JMenuItem("restart");

    //exit
    private JMenuItem close = new JMenuItem("exit");

    //select all
    private JMenuItem select_all = new JMenuItem("select all");

    //copy
    private JMenuItem cpy = new JMenuItem("copy");

    //paste
    private JMenuItem paste = new JMenuItem("paste");

    //The string hold the copied text from the 'cpy' menu
    private String copied_txt;

    //delete
    private JMenuItem dlt = new JMenuItem("delete all");

    //settings
    private JMenuItem settings = new JMenuItem("settings");

    //settings window
    private JFrame settings_fr = new JFrame("settings");

    //Font and color
    private JLabel font_section = new JLabel("Font and color");

    //font family label
    private JLabel f_family = new JLabel("font >");

    //The string holds all the local fonts in the system
    private String local_fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    //font`s box
    private JComboBox<String> font_box = new JComboBox<String>(local_fonts);

    //font size label
    private JLabel f_size = new JLabel("size >");

    //number model for the size spinner
    private SpinnerModel mdl = new SpinnerNumberModel(20,0,50,1);

    //size spinner
    private JSpinner size_spinner = new JSpinner(mdl);

    //font color label
    private JLabel f_color = new JLabel("color >");

    //color chooser
    private JLabel color_chooser = new JLabel();

    //Theme
    private JLabel theme_section = new JLabel("Theme");

    //theme_label
    private JLabel theme = new JLabel("theme");

    //The string holds the themes for the theme_box
    private String themes[] = { "classic","dark","gray" };

    //themes box
    private JComboBox<String> theme_box = new JComboBox<String>(themes);

    //info
    private JMenuItem info = new JMenuItem("info");

    //Text box
    private JTextArea text_box = new JTextArea();

    //Scroll pane for the text box
    private JScrollPane scroll = new JScrollPane(text_box);








    /**
     *
     */
    Editor(){

        //Text box
        text_box.setFont(new Font("Fira Code",Font.PLAIN,20));
        text_box.setForeground(new Color(220,220,220));
        text_box.setBackground(new Color(25,25,25));
        text_box.setBorder(null);
        text_box.setEditable(true);
        text_box.setCaretColor(Color.LIGHT_GRAY);
        text_box.setFocusable(true);

        //Scroll pane
        scroll.setBounds(-1,50,1103,499);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(78,24,160),1));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //main menu bar
        menu_bar.setBackground(new Color(29,29,29));
        menu_bar.setBorder(null);
        menu_bar.setBounds(0,0,216,32);

        //File menu
        file_menu.setFont(new Font("Hack",Font.PLAIN,15));
        file_menu.setForeground(new Color(230,230,230));
        file_menu.setBorder(null);
        file_menu.addMouseListener(this);
        menu_bar.add(file_menu);

        //Edit menu
        edit_menu.setFont(new Font("Hack",Font.PLAIN,15));
        edit_menu.setForeground(new Color(240,240,240));
        edit_menu.setBorder(null);
        edit_menu.addMouseListener(this);
        menu_bar.add(edit_menu);

        //Options menu
        options_menu.setFont(new Font("Hack",Font.PLAIN,15));
        options_menu.setForeground(new Color(230,230,230));
        options_menu.setBorder(null);
        options_menu.addMouseListener(this);
        menu_bar.add(options_menu);

        //About menu
        about_menu.setFont(new Font("Hack",Font.PLAIN,15));
        about_menu.setForeground(new Color(220,220,220));
        about_menu.setBorder(null);
        about_menu.addMouseListener(this);
        menu_bar.add(about_menu);

        //new file
        new_file.setFont(new Font("Fira Code",Font.PLAIN,14));
        new_file.setForeground(new Color(230,230,230));
        new_file.setBackground(new Color(34,34,34));
        new_file.setBorder(null);
        new_file.addActionListener(this);
        file_menu.add(new_file);

        //open
        load.setFont(new Font("Fira Code",Font.PLAIN,14));
        load.setForeground(new Color(230,230,230));
        load.setBackground(new Color(34,34,34));
        load.setBorder(null);
        load.addActionListener(this);
        file_menu.add(load);

        //save
        export.setFont(new Font("Fira Code",Font.PLAIN,14));
        export.setForeground(new Color(230,230,230));
        export.setBackground(new Color(34,34,34));
        export.setBorder(null);
        export.addActionListener(this);
        file_menu.add(export);

        //new window
        new_window.setFont(new Font("Fira Code",Font.PLAIN,14));
        new_window.setForeground(new Color(230,230,230));
        new_window.setBackground(new Color(34,34,34));
        new_window.setBorder(null);
        new_window.addActionListener(this);
        file_menu.add(new_window);

        //restart
        reboot.setFont(new Font("Fira Code",Font.PLAIN,14));
        reboot.setForeground(new Color(230,230,230));
        reboot.setBackground(new Color(34,34,34));
        reboot.setBorder(null);
        reboot.addActionListener(this);
        file_menu.add(reboot);

        //exit
        close.setFont(new Font("Fira Code",Font.PLAIN,14));
        close.setForeground(new Color(230,230,230));
        close.setBackground(new Color(34,34,34));
        close.setBorder(null);
        close.addActionListener(this);
        file_menu.add(close);

        //select all
        select_all.setFont(new Font("Fira Code",Font.PLAIN,14));
        select_all.setForeground(new Color(230,230,230));
        select_all.setBackground(new Color(34,34,34));
        select_all.setBorder(null);
        select_all.addActionListener(this);
        edit_menu.add(select_all);

        //copy
        cpy.setFont(new Font("Fira Code",Font.PLAIN,14));
        cpy.setForeground(new Color(230,230,230));
        cpy.setBackground(new Color(34,34,34));
        cpy.setBorder(null);
        cpy.addActionListener(this);
        edit_menu.add(cpy);

        //paste
        paste.setFont(new Font("Fira Code",Font.PLAIN,14));
        paste.setForeground(new Color(230,230,230));
        paste.setBackground(new Color(34,34,34));
        paste.setBorder(null);
        paste.addActionListener(this);
        edit_menu.add(paste);

        //delete
        dlt.setFont(new Font("Fira Code",Font.PLAIN,14));
        dlt.setForeground(new Color(230,230,230));
        dlt.setBackground(new Color(34,34,34));
        dlt.setBorder(null);
        dlt.addActionListener(this);
        edit_menu.add(dlt);

        //settings
        settings.setFont(new Font("Fira Code",Font.PLAIN,14));
        settings.setForeground(new Color(230,230,230));
        settings.setBackground(new Color(34,34,34));
        settings.setBorder(null);
        settings.addActionListener(this);
        options_menu.add(settings);




        /**
         * Setting up the frame
         */
        setTitle("TextEditor++");
        setBounds(100,50,1100,590);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(29,29,29));

        //add the components to the frame
        add(menu_bar);
        add(scroll);
    }















    /**
     * ------------------------ ActionListener --------------------------------
     */

    /**
     * @param actionEvent
     */
    @SuppressWarnings("static-access")
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        /**
         * new file
         */
        if(actionEvent.getSource() == new_file) {
            JOptionPane.showMessageDialog(null,"All the content will be deleted!","Warning",JOptionPane.WARNING_MESSAGE);
            text_box.setText("");
        }




        /**
         * open
         */
        if(actionEvent.getSource() == load) {
            //file chooser
            JFileChooser fl_chooser = new JFileChooser();

            //file name extension filters
            FileNameExtensionFilter txt = new FileNameExtensionFilter("text file","txt");
            FileNameExtensionFilter doc = new FileNameExtensionFilter("document","doc");
            FileNameExtensionFilter html = new FileNameExtensionFilter("html document","html");
            FileNameExtensionFilter fxml = new FileNameExtensionFilter("fxml document","fxml");
            FileNameExtensionFilter xml = new FileNameExtensionFilter("xml configuration","fxml");
            FileNameExtensionFilter c = new FileNameExtensionFilter("c file","c");
            FileNameExtensionFilter cpp = new FileNameExtensionFilter("c++ file","cpp");
            FileNameExtensionFilter cs = new FileNameExtensionFilter("C# file","cs");
            FileNameExtensionFilter java = new FileNameExtensionFilter("java file","java");
            FileNameExtensionFilter css = new FileNameExtensionFilter("stylesheet","css");
            FileNameExtensionFilter js = new FileNameExtensionFilter("java script file","js");
            FileNameExtensionFilter py = new FileNameExtensionFilter("pyton file","py");

            //applying filters
            fl_chooser.setFileFilter(txt);
            fl_chooser.setFileFilter(doc);
            fl_chooser.setFileFilter(html);
            fl_chooser.setFileFilter(fxml);
            fl_chooser.setFileFilter(xml);
            fl_chooser.setFileFilter(c);
            fl_chooser.setFileFilter(cpp);
            fl_chooser.setFileFilter(cs);
            fl_chooser.setFileFilter(java);
            fl_chooser.setFileFilter(js);
            fl_chooser.setFileFilter(py);
            fl_chooser.setFileFilter(css);

            //The file
            File dcmnt;

            //Scanner to scan the file
            Scanner scan = null;

            //@param rspns -- hold the input from the file chooser
            int rspns = fl_chooser.showOpenDialog(null);

            //load the file
            boolean isSelected = (rspns == fl_chooser.APPROVE_OPTION) ? true : false;

            if(isSelected) {
                //creating the file
                dcmnt = new File(fl_chooser.getSelectedFile().getAbsolutePath());
                try {
                    //initialize scanner to that file
                    scan = new Scanner(dcmnt);

                    //check if the file is actually file
                    if(dcmnt.isFile()){
                        while(scan.hasNextLine()){
                            //holds the file text content
                            String content = scan.nextLine() + "\n";

                            //append the text content of the file to the text box
                            text_box.append(content);
                        }
                    }
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null,"File not found","Error while loading file",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }finally {
                    scan.close();
                }
            }

        }




        /**
         * save
         */
        if(actionEvent.getSource() == export) {
            //file chooser
            JFileChooser fl_chsr = new JFileChooser();

            //The file
            File doc;

            //PrintWriter to print the text from the text box in the file
            PrintWriter _output_ = null;

            //hold the response from the file chooser
            int rsp = fl_chsr.showSaveDialog(null);

            //check if the response is positive('open' button is selected)
            //and hold the result
            boolean fileHasBeenSelected = (rsp == fl_chsr.APPROVE_OPTION) ? true : false;

            //check the response(if true -- create file)
            if(fileHasBeenSelected) {
                //create the file
                doc = new File(fl_chsr.getSelectedFile().getAbsolutePath());

                try {
                    //create the output printer
                    _output_ = new PrintWriter(doc);

                    //print the text from the text box to the file
                    _output_.println(text_box.getText());
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null,"directory not found!","Error while saving",JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }finally {
                    _output_.close();
                }
            }


        }



        /**
         * new window
         */
        if(actionEvent.getSource() == new_window) {
            //create a new window
            Editor clone = new Editor();

            //set the new window to close without closing the main window
            clone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }




        /**
         * restart
         */
        if(actionEvent.getSource() == reboot) {
            //disconnect the current window
            dispose();

            //create new window
            Editor rebooted = new Editor();
        }




        /**
         * exit
         */
        if(actionEvent.getSource() == close) {
            //exit the program
            System.exit(0);
        }




        /**
         * select all
         */
        if(actionEvent.getSource() == select_all) {
            //select all the text in the text box
            if(text_box.getText() != "") {
                text_box.selectAll();
            } else {
                JOptionPane.showMessageDialog(null, "Nothing to select!","Empty filed",JOptionPane.ERROR_MESSAGE);
            }
        }




        /**
         * copy
         */
        if(actionEvent.getSource() == cpy) {
            //save the text
            copied_txt = text_box.getSelectedText();

            //show error if the text box is empty
            if(text_box.getText() == "") {
                JOptionPane.showMessageDialog(null,"Nothing to copy!","Empty field",JOptionPane.ERROR_MESSAGE);
            }
        }




        /**
         * paste
         */
        if(actionEvent.getSource() == paste) {
            text_box.setText(copied_txt);
        }




        /**
         * delete
         */
        if(actionEvent.getSource() == dlt) {
            text_box.setText("");
        }



        /**
         * settings
         */
        if(actionEvent.getSource() == settings) {
            //setting up the components
            font_section.setFont(new Font("Fira Code",Font.PLAIN,15));
            font_section.setForeground(new Color(220,220,220));
            font_section.setBounds(250,50,250,20);
            font_section.addMouseListener(new MouseListener(){

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    font_section.setForeground(Color.white);
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    font_section.setForeground(new Color(220,220,220));
                }
            });

            f_family.setFont(new Font("Fira Code",Font.PLAIN,14));
            f_family.setForeground(new Color(220,220,220));
            f_family.setBounds(20,130,70,20);
            f_family.addMouseListener(new MouseListener(){

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    f_family.setForeground(Color.white);
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    f_family.setForeground(new Color(220,220,220));
                }
            });

            font_box.setFont(new Font("Fira Code",Font.PLAIN,15));
            font_box.setForeground(new Color(230,230,230));
            font_box.setBackground(new Color(29,29,29));
            font_box.setSelectedItem("Fira Code");
            font_box.setBounds(80,129,250,23);
            font_box.addMouseListener(new MouseListener(){

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    font_box.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    font_box.setBorder(null);
                }
            });
            font_box.addActionListener(e1 -> {
               text_box.setFont(new Font((String)font_box.getSelectedItem(),Font.PLAIN,(int)text_box.getFont().getSize()));
            });

            f_size.setFont(new Font("Fira Code",Font.PLAIN,14));
            f_size.setForeground(new Color(220,220,220));
            f_size.setBounds(360,130,60,20);
            f_size.addMouseListener(new MouseListener(){

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    f_size.setForeground(Color.white);
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    f_size.setForeground(new Color(220,220,220));
                }
            });

            size_spinner.setFont(new Font("JetBrains Mono",Font.PLAIN,14));
            size_spinner.setBounds(423,130,60,20);
            size_spinner.addChangeListener(new ChangeListener(){

                /**
                 * @param changeEvent
                 */
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    text_box.setFont(new Font((String)text_box.getFont().getFamily(),Font.PLAIN,(int)size_spinner.getValue()));
                }
            });

            f_color.setFont(new Font("Fira Code",Font.PLAIN,14));
            f_color.setForeground(new Color(220,220,220));
            f_color.setBounds(513,131,80,20);
            f_color.addMouseListener(new MouseListener(){

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseEntered(MouseEvent mouseEvent) {
                    f_color.setForeground(Color.white);
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    f_color.setForeground(new Color(220,220,220));
                }
            });

            color_chooser.setBackground(new Color(220,220,220));
            color_chooser.setOpaque(true);
            color_chooser.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
            color_chooser.setBounds(585,130,20,20);
            color_chooser.addMouseListener(this);

            //setting up the frame
            settings_fr.setVisible(true);
            settings_fr.setBounds(200,200,630,600);
            settings_fr.setLayout(null);
            settings_fr.setResizable(false);
            settings_fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            settings_fr.getContentPane().setBackground(new Color(34,34,34));

            //add the components to the frame
            settings_fr.add(font_section);
            settings_fr.add(f_family);
            settings_fr.add(font_box);
            settings_fr.add(f_size);
            settings_fr.add(size_spinner);
            settings_fr.add(f_color);
            settings_fr.add(color_chooser);
        }

    }







    /**
     * ------------------------ MouseListener ---------------------------------
     */

    /**
     * @param mouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //color chooser
        if(mouseEvent.getSource() == color_chooser) {
            JColorChooser clr_chsr = new JColorChooser();
            Color clr = clr_chsr.showDialog(null,"pick a color",new Color(220,220,220));

            text_box.setForeground(clr);
            color_chooser.setBackground(clr);
        }
    }

    /**
     * @param mouseEvent
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    /**
     * @param mouseEvent
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    /**
     * @param mouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

        //File menu
        if(mouseEvent.getSource() == file_menu) {
            file_menu.setForeground(new Color(78,34,160));
        }

        //Edit menu
        if(mouseEvent.getSource() == edit_menu) {
            edit_menu.setForeground(new Color(78,34,160));
        }

        //Options menu
        if(mouseEvent.getSource() == options_menu) {
            options_menu.setForeground(new Color(78,34,160));
        }

        //About menu
        if(mouseEvent.getSource() == about_menu) {
            about_menu.setForeground(new Color(78,34,160));
        }

        //color chooser
        if(mouseEvent.getSource() == color_chooser) {
            color_chooser.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        }

    }

    /**
     * @param mouseEvent
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

        //File menu
        if(mouseEvent.getSource() == file_menu){
            file_menu.setForeground(new Color(230,230,230));
        }

        //Edit menu
        if(mouseEvent.getSource() == edit_menu) {
            edit_menu.setForeground(new Color(230,230,230));
        }

        //Options menu
        if(mouseEvent.getSource() == options_menu) {
            options_menu.setForeground(new Color(230,230,230));
        }

        //About menu
        if(mouseEvent.getSource() == about_menu) {
            about_menu.setForeground(new Color(230,230,230));
        }

        //color chooser
        if(mouseEvent.getSource() == color_chooser) {
            color_chooser.setBorder(null);
        }

    }

}
