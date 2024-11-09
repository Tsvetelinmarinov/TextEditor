


/**
 * TextEditor++
 *  Application
 */

package appdata;







import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Caret;


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
    private SpinnerModel mdl = new SpinnerNumberModel(19,0,50,1);

    //size spinner
    private JSpinner size_spinner = new JSpinner(mdl);

    //font color label
    private JLabel f_color = new JLabel("color >");

    //color chooser
    private JLabel color_chooser = new JLabel();

    //Theme
    private JLabel theme_section = new JLabel("Apperance");

    //theme_label
    private JLabel theme = new JLabel("theme >");

    //The string holds the themes for the theme_box
    private String themes[] = { "classic","dark","gray" };

    //themes box
    private JComboBox<String> theme_box = new JComboBox<String>(themes);

    //menu bar color chooser
    private JLabel menu_background_chooser = new JLabel();

    //menu bar color label
    private JLabel menu_bar_color = new JLabel("menu bar >");

    //text area background color label
    private JLabel text_box_background = new JLabel("text box >");

    //text area background color chooser
    private JLabel text_box_color_chooser = new JLabel();

    //application background label
    private JLabel app_background = new JLabel("application background >");

    //application background color chooser
    private JLabel app_background_color_chooser = new JLabel();

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
        text_box.setFont(new Font("Liberation Mono",Font.PLAIN,19));
        text_box.setForeground(new Color(220,220,220));
        text_box.setBackground(new Color(25,25,25));
        text_box.setBorder(null);
        text_box.setEditable(true);
        text_box.setCaretColor(new Color(200,200,100));
        text_box.setFocusable(true);

        //Scroll pane
        scroll.setBounds(-1,50,1103,499);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(78,24,160),1));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        //main menu bar
        menu_bar.setBackground(new Color(29,29,29));
        menu_bar.setBorder(null);
        menu_bar.setBounds(0,0,230,32);

        //File menu
        file_menu.setFont(new Font("Liberation Mono",Font.PLAIN,16));
        file_menu.setForeground(new Color(230,230,230));
        file_menu.setBorder(null);
        file_menu.addMouseListener(this);
        menu_bar.add(file_menu);

        //Edit menu
        edit_menu.setFont(new Font("Liberation Mono",Font.PLAIN,16));
        edit_menu.setForeground(new Color(240,240,240));
        edit_menu.setBorder(null);
        edit_menu.addMouseListener(this);
        menu_bar.add(edit_menu);

        //Options menu
        options_menu.setFont(new Font("Liberation Mono",Font.PLAIN,16));
        options_menu.setForeground(new Color(230,230,230));
        options_menu.setBorder(null);
        options_menu.addMouseListener(this);
        menu_bar.add(options_menu);

        //About menu
        about_menu.setFont(new Font("Liberation Mono",Font.PLAIN,16));
        about_menu.setForeground(new Color(220,220,220));
        about_menu.setBorder(null);
        about_menu.addMouseListener(this);
        menu_bar.add(about_menu);

        //new file
        new_file.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        new_file.setForeground(new Color(230,230,230));
        new_file.setBackground(new Color(34,34,34));
        new_file.setBorder(null);
        new_file.addActionListener(this);
        file_menu.add(new_file);

        //open
        load.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        load.setForeground(new Color(230,230,230));
        load.setBackground(new Color(34,34,34));
        load.setBorder(null);
        load.addActionListener(this);
        file_menu.add(load);

        //save
        export.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        export.setForeground(new Color(230,230,230));
        export.setBackground(new Color(34,34,34));
        export.setBorder(null);
        export.addActionListener(this);
        file_menu.add(export);

        //new window
        new_window.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        new_window.setForeground(new Color(230,230,230));
        new_window.setBackground(new Color(34,34,34));
        new_window.setBorder(null);
        new_window.addActionListener(this);
        file_menu.add(new_window);

        //restart
        reboot.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        reboot.setForeground(new Color(230,230,230));
        reboot.setBackground(new Color(34,34,34));
        reboot.setBorder(null);
        reboot.addActionListener(this);
        file_menu.add(reboot);

        //exit
        close.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        close.setForeground(new Color(230,230,230));
        close.setBackground(new Color(34,34,34));
        close.setBorder(null);
        close.addActionListener(this);
        file_menu.add(close);

        //select all
        select_all.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        select_all.setForeground(new Color(230,230,230));
        select_all.setBackground(new Color(34,34,34));
        select_all.setBorder(null);
        select_all.addActionListener(this);
        edit_menu.add(select_all);

        //copy
        cpy.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        cpy.setForeground(new Color(230,230,230));
        cpy.setBackground(new Color(34,34,34));
        cpy.setBorder(null);
        cpy.addActionListener(this);
        edit_menu.add(cpy);

        //paste
        paste.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        paste.setForeground(new Color(230,230,230));
        paste.setBackground(new Color(34,34,34));
        paste.setBorder(null);
        paste.addActionListener(this);
        edit_menu.add(paste);

        //delete
        dlt.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        dlt.setForeground(new Color(230,230,230));
        dlt.setBackground(new Color(34,34,34));
        dlt.setBorder(null);
        dlt.addActionListener(this);
        edit_menu.add(dlt);

        //settings
        settings.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        settings.setForeground(new Color(230,230,230));
        settings.setBackground(new Color(34,34,34));
        settings.setBorder(null);
        settings.addActionListener(this);
        options_menu.add(settings);

        //information
        info.setFont(new Font("Liberation Mono",Font.PLAIN,15));
        info.setForeground(new Color(230,230,230));
        info.setBackground(new Color(34,34,34));
        info.setBorder(null);
        info.addActionListener(this);
        about_menu.add(info);




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
            font_section.setFont(new Font("Liberation Mono",Font.PLAIN,15));
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
                    font_section.setForeground(new Color(78,34,160));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    font_section.setForeground(new Color(220,220,220));
                }
            });

            f_family.setFont(new Font("Liberation Mono",Font.PLAIN,14));
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
                    f_family.setForeground(new Color(78,34,160));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    f_family.setForeground(new Color(220,220,220));
                }
            });

            font_box.setFont(new Font("Liberation Mono",Font.PLAIN,15));
            font_box.setForeground(new Color(230,230,230));
            font_box.setBackground(new Color(29,29,29));
            font_box.setSelectedItem("Liberation Mono");
            font_box.setBounds(80,128,250,25);
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

            f_size.setFont(new Font("Liberation Mono",Font.PLAIN,14));
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
                    f_size.setForeground(new Color(78,34,160));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    f_size.setForeground(new Color(220,220,220));
                }
            });

            size_spinner.setFont(new Font("Liberation Mono",Font.PLAIN,14));
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

            f_color.setFont(new Font("Liberation Mono",Font.PLAIN,14));
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
                    f_color.setForeground(new Color(78,34,160));
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

            theme_section.setFont(new Font("Liberation Mono",Font.PLAIN,14));
            theme_section.setForeground(new Color(220,220,220));
            theme_section.setBounds(270,215,100,20);
            theme_section.addMouseListener(new MouseListener(){

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
                    theme_section.setForeground(new Color(78,34,160));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    theme_section.setForeground(new Color(220,220,220));
                }
            });

            theme.setFont(new Font("Liberation Mono",Font.PLAIN,14));
            theme.setForeground(new Color(220,220,220));
            theme.setBounds(100,279,80,20);
            theme.addMouseListener(new MouseListener(){

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
                    theme.setForeground(new Color(78,34,160));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    theme.setForeground(new Color(220,220,220));
                }
            });

            theme_box.setFont(new Font("Liberation Mono",Font.PLAIN,14));
            theme_box.setForeground(new Color(230,230,230));
            theme_box.setBackground(new Color(29,29,29));
            theme_box.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
            theme_box.setSelectedItem("dark");
            theme_box.setBounds(180,275,150,30);
            theme_box.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // TODO Auto-generated method stub
                    theme_box.setBorder(new LineBorder(new Color(78,34,160)));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // TODO Auto-generated method stub
                    theme_box.setBorder(new LineBorder(new Color(29,29,29)));
                }

            });
            theme_box.addActionListener(e1 -> {
                switch(theme_box.getSelectedIndex()) {
                    case 0:
                        set_classic_theme();
                        break;
                    case 1:
                        set_dark_theme();
                        break;
                    case 2:
                        set_gray_theme();
                        break;
                }
            });

            menu_bar_color.setFont(new Font("Liberation Mono",Font.PLAIN,14));
            menu_bar_color.setForeground(new Color(220,220,220));
            menu_bar_color.setBounds(100,340,100,20);
            menu_bar_color.addMouseListener(this);

            menu_background_chooser.setBounds(210,339,20,20);
            menu_background_chooser.setBackground(((Color)getContentPane().getBackground()));
            menu_background_chooser.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
            menu_background_chooser.setOpaque(true);
            menu_background_chooser.addMouseListener(this);

            text_box_background.setFont(new Font("Liberation Mono",Font.PLAIN,14));
            text_box_background.setForeground(new Color(220,220,220));
            text_box_background.setBounds(100,370,100,20);
            text_box_background.addMouseListener(this);

            text_box_color_chooser.setBounds(210,370,20,20);
            text_box_color_chooser.setBackground(new Color(25,25,25));
            text_box_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
            text_box_color_chooser.setOpaque(true);
            text_box_color_chooser.addMouseListener(this);

            app_background.setFont(new Font("Liberation Mono",Font.PLAIN,14));
            app_background.setForeground(new Color(220,220,220));
            app_background.setBounds(100,440,220,20);
            app_background.addMouseListener(this);

            app_background_color_chooser.setBounds(330,440,20,20);
            app_background_color_chooser.setBackground(new Color(29,29,29));
            app_background_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
            app_background_color_chooser.setOpaque(true);
            app_background_color_chooser.addMouseListener(this);

            //setting up the frame
            settings_fr.setVisible(true);
            settings_fr.setBounds(200,200,630,550);
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
            settings_fr.add(theme_section);
            settings_fr.add(theme);
            settings_fr.add(theme_box);
            settings_fr.add(menu_bar_color);
            settings_fr.add(menu_background_chooser);
            settings_fr.add(text_box_background);
            settings_fr.add(text_box_color_chooser);
            settings_fr.add(app_background);
            settings_fr.add(app_background_color_chooser);
        }



        /**
         * info
         */
        if(actionEvent.getSource() == info) {
            JFrame info_fr = new JFrame("Information");
            JLabel logo_l = new JLabel("TextEditor++");
            JTextArea info_box = new JTextArea();

            logo_l.setFont(new Font("Liberation Mono",Font.PLAIN,15));
            logo_l.setForeground(new Color(200,200,200));
            logo_l.setBounds(240,30,130,23);
            logo_l.addMouseListener(new MouseListener(){

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
                    logo_l.setForeground(new Color(78,34,160));
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    logo_l.setForeground(new Color(200,200,200));
                }
            });

            info_box.setBounds(-1,65,602,555);
            info_box.setBackground(new Color(29,29,29));
            info_box.setCaretColor(new Color(29,29,29));
            info_box.setFont(new Font("Liberation Mono",Font.PLAIN,16));
            info_box.setForeground(new Color(200,200,200));
            info_box.setEditable(false);
            info_box.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
            info_box.setText(
                    "\n Application version\n"
                            + "  1.0.0\n\n License\n"
                            + "  free to use\n\n Date of manifacture\n"
                            + "  Friday 8 November 2024\n\n Programmer\n"
                            + "  Tsvetelin Marinov\n\n Company\n  none\n\n"
                            + " Description\n  Text editor for everyday use\n"
                            + "  works with basic programming files and text files\n"
            );
            info_box.addMouseListener(new MouseListener(){

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
                    info_box.setForeground(Color.white);
                }

                /**
                 * @param mouseEvent
                 */
                @Override
                public void mouseExited(MouseEvent mouseEvent) {
                    info_box.setForeground(new Color(200,200,200));
                }

            });


            //setting up the frame
            info_fr.setBounds(200,200,600,550);
            info_fr.setLayout(null);
            info_fr.setVisible(true);
            info_fr.setResizable(false);
            info_fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            info_fr.getContentPane().setBackground(new Color(30,30,30));

            //add the components to the frame
            info_fr.add(logo_l);
            info_fr.add(info_box);
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

        //menu background color chooser
        if(mouseEvent.getSource() == menu_background_chooser) {
            JColorChooser cl_chs = new JColorChooser();
            Color clr = cl_chs.showDialog(null,"pick a color",(Color)menu_bar.getBackground());

            menu_bar.setBackground(clr);
            menu_background_chooser.setBackground(clr);
        }

        //text box color chooser
        if(mouseEvent.getSource() == text_box_color_chooser) {
            JColorChooser cl_chsr = new JColorChooser();
            Color clr = cl_chsr.showDialog(null,"pick a color",new Color(25,25,25));

            text_box.setBackground(clr);
            text_box_color_chooser.setBackground(clr);
        }

        //application background chooser
        if(mouseEvent.getSource() == app_background_color_chooser) {
            JColorChooser clr_chsr = new JColorChooser();
            Color clr = clr_chsr.showDialog(null,"pick a color",new Color(29,29,29));

            getContentPane().setBackground(clr);
            app_background_color_chooser.setBackground(clr);
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

        //menu bar color label
        if(mouseEvent.getSource() == menu_bar_color) {
            menu_bar_color.setForeground(new Color(78,34,160));
        }

        //menu background color chooser
        if(mouseEvent.getSource() == menu_background_chooser) {
            menu_background_chooser.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        }

        //text box background label
        if(mouseEvent.getSource() == text_box_background) {
            text_box_background.setForeground(new Color(78,34,160));
        }

        //text box color chooser
        if(mouseEvent.getSource() == text_box_color_chooser) {
            text_box_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        }

        //application background label
        if(mouseEvent.getSource() == app_background) {
            app_background.setForeground(new Color(78,34,160));
        }

        //application background chooser
        if(mouseEvent.getSource() == app_background_color_chooser) {
            app_background_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
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

        //menu bar color label
        if(mouseEvent.getSource() == menu_bar_color) {
            menu_bar_color.setForeground(new Color(220,220,220));
        }

        //menu bar color chooser
        if(mouseEvent.getSource() == menu_background_chooser) {
            menu_background_chooser.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));
        }

        //text box background label
        if(mouseEvent.getSource() == text_box_background) {
            text_box_background.setForeground(new Color(220,220,220));
        }

        //text box color chooser
        if(mouseEvent.getSource() == text_box_color_chooser) {
            text_box_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
        }

        //app background color label
        if(mouseEvent.getSource() == app_background) {
            app_background.setForeground(new Color(220,220,220));
        }

        //app background color chooser
        if(mouseEvent.getSource() == app_background_color_chooser) {
            app_background_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(220,220,220)));
        }

    }









    /**
     *  ------------------- Themes -----------------------------
     */




    /**
     * Dark theme (original)
     */
    public void set_dark_theme(){
        getContentPane().setBackground(new Color(29,29,29));

        menu_bar.setBackground(new Color(29,29,29));

        text_box.setBackground(new Color(25,25,25));
        text_box.setForeground(new Color(230,230,230));

        scroll.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));

        file_menu.setForeground(new Color(230,230,230));
        file_menu.addMouseListener(new MouseListener(){

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
                file_menu.setForeground(new Color(78,34,160));
            }

            /**
             * @param mouseEvent
             */
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                file_menu.setForeground(new Color(230,230,230));
            }
        });

        edit_menu.setForeground(new Color(230,230,230));
        edit_menu.addMouseListener(new MouseListener(){

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
                edit_menu.setForeground(new Color(78,34,160));
            }

            /**
             * @param mouseEvent
             */
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                edit_menu.setForeground(new Color(230,230,230));
            }
        });

        options_menu.setForeground(new Color(230,230,230));
        options_menu.addMouseListener(new MouseListener(){

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
                options_menu.setForeground(new Color(78,34,160));
            }

            /**
             * @param mouseEvent
             */
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                options_menu.setForeground(new Color(230,230,230));
            }
        });

        about_menu.setForeground(new Color(230,230,230));
        about_menu.addMouseListener(new MouseListener(){

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
                about_menu.setForeground(new Color(78,34,160));
            }

            /**
             * @param mouseEvent
             */
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                about_menu.setForeground(new Color(230,230,230));
            }
        });

        new_file.setBackground(new Color(34,34,34));
        new_file.setForeground(new Color(230,230,230));

        load.setBackground(new Color(34,34,34));
        load.setForeground(new Color(230,230,230));

        Color m_b = new Color(34,34,34);
        Color m_f = new Color(230,230,230);

        export.setBackground(m_b);
        export.setForeground(m_f);

        new_window.setBackground(m_b);
        new_window.setForeground(m_f);

        reboot.setBackground(m_b);
        reboot.setForeground(m_f);

        close.setBackground(m_b);
        close.setForeground(m_f);

        select_all.setBackground(m_b);
        select_all.setForeground(m_f);

        cpy.setBackground(m_b);
        cpy.setForeground(m_f);

        paste.setBackground(m_b);
        paste.setForeground(m_f);

        dlt.setBackground(m_b);
        dlt.setForeground(m_f);

        settings.setBackground(m_b);
        settings.setForeground(m_f);

        info.setBackground(m_b);
        info.setForeground(m_f);

        settings_fr.getContentPane().setBackground(new Color(29,29,29));

        font_section.setForeground(new Color(220,220,220));
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
                font_section.setForeground(new Color(78,34,160));
            }

            /**
             * @param mouseEvent
             */
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                font_section.setForeground(new Color(220,220,220));
            }
        });

        f_family.setForeground(new Color(220,220,220));
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
                f_family.setForeground(new Color(78,34,160));
            }

            /**
             * @param mouseEvent
             */
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                f_family.setForeground(new Color(220,220,220));
            }
        });

        font_box.setBackground(new Color(29,29,29));
        font_box.setForeground(new Color(230,230,230));
        font_box.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
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
                font_box.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
            }
        });

        f_size.setForeground(new Color(220,220,220));
        f_size.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                f_size.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                f_size.setForeground(new Color(220,220,220));
            }

        });

        f_color.setForeground(new Color(220,220,220));
        f_color.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                f_color.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                f_color.setForeground(new Color(220,220,220));
            }

        });

        color_chooser.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
        color_chooser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                color_chooser.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                color_chooser.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
            }

        });

        theme_section.setForeground(new Color(220,220,220));
        theme_section.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                theme_section.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                theme_section.setForeground(new Color(220,220,220));
            }

        });

        theme.setForeground(new Color(220,220,220));
        theme.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                theme.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                theme.setForeground(new Color(220,220,220));
            }

        });

        theme_box.setBackground(new Color(29,29,29));
        theme_box.setForeground(new Color(230,230,230));
        theme_box.setBorder(BorderFactory.createLineBorder(new Color(29,29,29)));
        theme_box.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                theme_box.setBorder(new LineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                theme_box.setBorder(new LineBorder(new Color(29,29,29)));
            }

        });

        menu_bar_color.setForeground(new Color(220,220,220));
        menu_bar_color.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                menu_bar_color.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                menu_bar_color.setForeground(new Color(220,220,220));
            }

        });

        menu_background_chooser.setBorder(new LineBorder(new Color(220,220,220)));
        menu_background_chooser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                menu_background_chooser.setBorder(new LineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                menu_background_chooser.setBorder(new LineBorder(new Color(220,220,220)));
            }

        });

        text_box_background.setForeground(new Color(220,220,220));
        text_box_background.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                text_box_background.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                text_box_background.setForeground(new Color(220,220,220));
            }

        });

        text_box_color_chooser.setBorder(new LineBorder(new Color(220,220,220)));
        text_box_color_chooser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                text_box_color_chooser.setBorder(new LineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                text_box_color_chooser.setBorder(new LineBorder(new Color(220,220,220)));
            }

        });

        app_background.setForeground(new Color(220,220,220));
        app_background.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                app_background.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                app_background.setForeground(new Color(220,220,220));
            }

        });

        app_background_color_chooser.setBorder(new LineBorder(new Color(220,220,220)));
        app_background_color_chooser.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                app_background_color_chooser.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                app_background_color_chooser.setBorder(new LineBorder(new Color(220,220,220)));
            }

        });

    }





    /**
     * Classic theme
     */
    public void set_classic_theme() {
        getContentPane().setBackground(Color.white);

        menu_bar.setBackground(Color.white);

        scroll.setBorder(BorderFactory.createLineBorder(new Color(200,30,150)));

        text_box.setBackground(Color.white);
        text_box.setForeground(Color.DARK_GRAY);
        text_box.setCaretColor(Color.black);

        file_menu.setForeground(Color.DARK_GRAY);
        file_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                file_menu.setForeground(new Color(200,30,150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                file_menu.setForeground(Color.DARK_GRAY);
            }

        });

        Color alfa_c = new Color(200,30,150);

        edit_menu.setForeground(Color.DARK_GRAY);
        edit_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                edit_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                edit_menu.setForeground(Color.DARK_GRAY);
            }

        });

        options_menu.setForeground(Color.DARK_GRAY);
        options_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                options_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                options_menu.setForeground(Color.DARK_GRAY);
            }

        });

        about_menu.setForeground(Color.DARK_GRAY);
        about_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                about_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                about_menu.setForeground(Color.DARK_GRAY);
            }

        });

        new_file.setBackground(Color.white);
        new_file.setForeground(Color.DARK_GRAY);

        load.setBackground(Color.white);
        load.setForeground(Color.DARK_GRAY);

        export.setBackground(Color.white);
        export.setForeground(Color.DARK_GRAY);

        new_window.setBackground(Color.white);
        new_window.setForeground(Color.DARK_GRAY);

        reboot.setBackground(Color.white);
        reboot.setForeground(Color.DARK_GRAY);

        close.setBackground(Color.white);
        close.setForeground(Color.DARK_GRAY);

        select_all.setBackground(Color.white);
        select_all.setForeground(Color.DARK_GRAY);

        cpy.setBackground(Color.white);
        cpy.setForeground(Color.DARK_GRAY);

        paste.setBackground(Color.white);
        paste.setForeground(Color.DARK_GRAY);

        dlt.setBackground(Color.white);
        dlt.setForeground(Color.DARK_GRAY);

        settings.setBackground(Color.white);
        settings.setForeground(Color.DARK_GRAY);

        info.setBackground(Color.white);
        info.setForeground(Color.DARK_GRAY);

        settings_fr.getContentPane().setBackground(Color.white);

        font_section.setForeground(Color.DARK_GRAY);
        font_section.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                font_section.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                font_section.setForeground(Color.DARK_GRAY);
            }
        });

        f_family.setForeground(Color.DARK_GRAY);
        f_family.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                f_family.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                f_family.setForeground(Color.DARK_GRAY);
            }
        });

        font_box.setBackground(Color.white);
        font_box.setForeground(Color.DARK_GRAY);
        font_box.setBorder(BorderFactory.createLineBorder(Color.white));
        font_box.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                font_box.setBorder(BorderFactory.createLineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                font_box.setBorder(BorderFactory.createLineBorder(Color.white));
            }
        });

        f_size.setForeground(Color.DARK_GRAY);
        f_size.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                f_size.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                f_size.setForeground(Color.DARK_GRAY);
            }
        });

        f_color.setForeground(Color.DARK_GRAY);
        f_color.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                f_color.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                f_color.setForeground(Color.DARK_GRAY);
            }
        });

        color_chooser.setBackground(Color.DARK_GRAY);
        color_chooser.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        color_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                color_chooser.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

        theme_section.setForeground(Color.DARK_GRAY);
        theme_section.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme_section.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_section.setForeground(Color.DARK_GRAY);
            }
        });

        theme.setForeground(Color.DARK_GRAY);
        theme.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme.setForeground(Color.DARK_GRAY);
            }
        });

        theme_box.setBackground(Color.white);
        theme_box.setForeground(Color.DARK_GRAY);
        theme_box.setBorder(BorderFactory.createLineBorder(Color.white));
        theme_box.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme_box.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_box.setBorder(new LineBorder(Color.white));
            }
        });

        menu_bar_color.setForeground(Color.DARK_GRAY);
        menu_bar_color.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                menu_bar_color.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                menu_bar_color.setForeground(Color.DARK_GRAY);
            }
        });

        menu_background_chooser.setBackground(Color.white);
        menu_background_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
        menu_background_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                menu_background_chooser.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                menu_background_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

        text_box_background.setForeground(Color.DARK_GRAY);
        text_box_background.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                text_box_background.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                text_box_background.setForeground(Color.DARK_GRAY);
            }
        });

        text_box_color_chooser.setBackground(Color.white);
        text_box_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
        text_box_color_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                text_box_color_chooser.setBorder(BorderFactory.createLineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                text_box_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

        app_background.setForeground(Color.DARK_GRAY);
        app_background.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                app_background.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                app_background.setForeground(Color.DARK_GRAY);
            }
        });

        app_background_color_chooser.setBackground(Color.white);
        app_background_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
        app_background_color_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                app_background_color_chooser.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                app_background_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

    }





    /**
     * Gray theme
     */
    public void set_gray_theme() {
        Color alfa_c = new Color(0,60,200);
        Color gray_alfa = new Color(200,200,200);

        getContentPane().setBackground(new Color(200,200,200));

        menu_bar.setBackground(gray_alfa);

        scroll.setBorder(BorderFactory.createLineBorder(alfa_c));

        text_box.setBackground(gray_alfa);
        text_box.setForeground(Color.black);
        text_box.setCaretColor(Color.black);

        file_menu.setForeground(Color.black);
        file_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                file_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                file_menu.setForeground(Color.black);
            }

        });

        edit_menu.setForeground(Color.black);
        edit_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                edit_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                edit_menu.setForeground(Color.black);
            }

        });

        options_menu.setForeground(Color.black);
        options_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                options_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                options_menu.setForeground(Color.black);
            }

        });

        about_menu.setForeground(Color.black);
        about_menu.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                about_menu.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                about_menu.setForeground(Color.black);
            }

        });

        new_file.setBackground(gray_alfa);
        new_file.setForeground(Color.black);

        load.setBackground(gray_alfa);
        load.setForeground(Color.black);

        export.setBackground(gray_alfa);
        export.setForeground(Color.black);

        new_window.setBackground(gray_alfa);
        new_window.setForeground(Color.black);

        reboot.setBackground(gray_alfa);
        reboot.setForeground(Color.black);

        close.setBackground(gray_alfa);
        close.setForeground(Color.black);

        select_all.setBackground(gray_alfa);
        select_all.setForeground(Color.black);

        cpy.setBackground(gray_alfa);
        cpy.setForeground(Color.black);

        paste.setBackground(gray_alfa);
        paste.setForeground(Color.black);

        dlt.setBackground(gray_alfa);
        dlt.setForeground(Color.black);

        settings.setBackground(gray_alfa);
        settings.setForeground(Color.black);

        info.setBackground(gray_alfa);
        info.setForeground(Color.black);

        settings_fr.getContentPane().setBackground(gray_alfa);

        font_section.setForeground(Color.black);
        font_section.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                font_section.setForeground(alfa_c);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                font_section.setForeground(Color.black);
            }
        });

        f_family.setForeground(Color.black);
        f_family.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                f_family.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                f_family.setForeground(Color.black);
            }
        });

        font_box.setBackground(gray_alfa);
        font_box.setForeground(Color.black);
        font_box.setBorder(BorderFactory.createLineBorder(Color.white));
        font_box.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                font_box.setBorder(BorderFactory.createLineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                font_box.setBorder(BorderFactory.createLineBorder(Color.white));
            }
        });

        f_size.setForeground(Color.black);
        f_size.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                f_size.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                f_size.setForeground(Color.black);
            }
        });

        f_color.setForeground(Color.black);
        f_color.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                f_color.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                f_color.setForeground(Color.black);
            }
        });

        color_chooser.setBackground(Color.black);
        color_chooser.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        color_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                color_chooser.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

        theme_section.setForeground(Color.black);
        theme_section.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme_section.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_section.setForeground(Color.black);
            }
        });

        theme.setForeground(Color.black);
        theme.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme.setForeground(Color.black);
            }
        });

        theme_box.setBackground(gray_alfa);
        theme_box.setForeground(Color.black);
        theme_box.setBorder(BorderFactory.createLineBorder(Color.white));
        theme_box.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme_box.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_box.setBorder(new LineBorder(Color.white));
            }
        });

        menu_bar_color.setForeground(Color.black);
        menu_bar_color.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                menu_bar_color.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                menu_bar_color.setForeground(Color.black);
            }
        });

        menu_background_chooser.setBackground(gray_alfa);
        menu_background_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
        menu_background_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                menu_background_chooser.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                menu_background_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

        text_box_background.setForeground(Color.black);
        text_box_background.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                text_box_background.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                text_box_background.setForeground(Color.black);
            }
        });

        text_box_color_chooser.setBackground(gray_alfa);
        text_box_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
        text_box_color_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                text_box_color_chooser.setBorder(BorderFactory.createLineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                text_box_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

        app_background.setForeground(Color.black);
        app_background.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                app_background.setForeground(alfa_c);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                app_background.setForeground(Color.black);
            }
        });

        app_background_color_chooser.setBackground(gray_alfa);
        app_background_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
        app_background_color_chooser.addMouseListener(new MouseListener(){

            /**
             * Invoked when the mouse button has been clicked (pressed
             * and released) on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been pressed on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * Invoked when a mouse button has been released on a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                app_background_color_chooser.setBorder(new LineBorder(alfa_c));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                app_background_color_chooser.setBorder(new LineBorder(Color.DARK_GRAY));
            }
        });

    }
}
