/**
 * TextEditor++
 */


package appdata;






import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;
import static java.awt.Color.DARK_GRAY;








/**
 *
 */
@SuppressWarnings("serial")
public class Editor extends JFrame implements MouseListener,ActionListener {



    /**
     * @params
     */

    //Main menu bar
    private JMenuBar menu_bar = new JMenuBar();

    //File menu contains usual file options
    private JMenu file_menu = new JMenu("File");

    //Edit menu contains usual edit options
    private JMenu edit_menu = new JMenu("Edit");

    //Options menu contains font and theme settings
    private JMenu options_menu = new JMenu("Options");

    //About menu contains main information
    private JMenu about_menu = new JMenu("About");

    //open a file
    private JMenuItem load_item = new JMenuItem("open");

    //save current file
    private JMenuItem export_item = new JMenuItem("save");

    //open new window
    private JMenuItem new_window_item = new JMenuItem("new window");

    //close the application
    private JMenuItem close_item = new JMenuItem("exit");

    //select all the text in the text box
    private JMenuItem select_all = new JMenuItem("select all");

    //copy selected text in the text box
    private JMenuItem cpy_item = new JMenuItem("copy");

    //append copied text
    private JMenuItem paste_item = new JMenuItem("paste");

    //delete all the text from the text box
    private JMenuItem dlt_item = new JMenuItem("delete");

    //font settings
    private JMenuItem font_settings = new JMenuItem("font and color");

    //theme settings
    private JMenuItem theme_settings = new JMenuItem("theme");

    //show information
    private JMenuItem info_item = new JMenuItem("info");

    //the string contains all the system fonts
    private String local_fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    //choose a font
    private JComboBox<String> font_box = new JComboBox<String>(local_fonts);

    //the string contains the theme options(themes);
    private String themes[] = {"classic","dark","darker","gray"};

    //choose a theme
    private JComboBox<String> theme_box = new JComboBox<String>(themes);

    //model for the size of the font(minimum -- 0, maximum -- 50, default -- 12)
    private SpinnerModel size_mdl = new SpinnerNumberModel(13,0,50,1);

    //choose font size
    private JSpinner size_spin = new JSpinner(size_mdl);

    //font settings window
    private JFrame font_config_frame = new JFrame("Font settings");

    //theme settings window
    private JFrame theme_frame = new JFrame("Theme");

    //Information window
    private JFrame info_frame = new JFrame("About");

    //Font name
    private JLabel family_lbl = new JLabel("font >");

    //Font size
    private JLabel size_lbl = new JLabel("size >");

    //Font color
    private JLabel color_lbl = new JLabel("color >");

    //theme name
    private JLabel theme_lbl = new JLabel("theme >");

    //choose a color
    private JLabel color_block = new JLabel();

    //about
    private JLabel info_lbl = new JLabel("about");

    //hold the text from the text box(when 'copy' menu item request it)
    private String cpytxt;

    //The text box
    private JTextArea text_box = new JTextArea();

    //scroll pane fot the text box
    private JScrollPane scroll = new JScrollPane(text_box);

    //All the main information wrote(setEditable = false)
    private JTextArea info_area = new JTextArea();








    /**
     *
     */
    Editor() {
        //setting up the menu bar
        menu_bar.setBackground(Color.WHITE);
        menu_bar.setBounds(0,0,400,20);
        menu_bar.setBorder(null);

        //setting up the text box
        text_box.setFont(new Font("Fira Code",Font.PLAIN,14));
        text_box.setBackground(Color.white);
        text_box.setEditable(true);
        text_box.setLineWrap(true);
        text_box.setWrapStyleWord(true);
        text_box.setCaretColor(Color.DARK_GRAY);

        //setting up the scroll pane of the text box
        scroll.setBorder(BorderFactory.createLineBorder(new Color(78,34,160),1));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(-1,35,1095,510);

        //setting up the file menu
        file_menu.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,14));
        file_menu.setForeground(DARK_GRAY);
        file_menu.setBorder(null);
        file_menu.addMouseListener(this);
        menu_bar.add(file_menu);

        //setting up the edit menu
        edit_menu.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,14));
        edit_menu.setForeground(DARK_GRAY);
        edit_menu.setBorder(null);
        edit_menu.addMouseListener(this);
        menu_bar.add(edit_menu);

        //setting up the options menu
        options_menu.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,14));
        options_menu.setForeground(DARK_GRAY);
        options_menu.setBorder(null);
        options_menu.addMouseListener(this);
        menu_bar.add(options_menu);

        //setting up the information menu
        about_menu.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,14));
        about_menu.setForeground(DARK_GRAY);
        about_menu.setBorder(null);
        about_menu.addMouseListener(this);
        menu_bar.add(about_menu);

        //open menu
        load_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        load_item.setForeground(DARK_GRAY);
        load_item.setBorder(null);
        load_item.addActionListener(this);
        file_menu.add(load_item);

        //save menu
        export_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        export_item.setForeground(DARK_GRAY);
        export_item.setBorder(null);
        export_item.addActionListener(this);
        file_menu.add(export_item);

        //new window menu
        new_window_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        new_window_item.setForeground(DARK_GRAY);
        new_window_item.setBorder(null);
        new_window_item.addActionListener(this);
        file_menu.add(new_window_item);

        //exit menu
        close_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        close_item.setForeground(DARK_GRAY);
        close_item.setBorder(null);
        close_item.addActionListener(this);
        file_menu.add(close_item);

        //select all menu
        select_all.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        select_all.setForeground(Color.DARK_GRAY);
        select_all.setBorder(null);
        select_all.addActionListener(this);
        edit_menu.add(select_all);

        //copy menu
        cpy_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        cpy_item.setForeground(DARK_GRAY);
        cpy_item.setBorder(null);
        cpy_item.addActionListener(this);
        edit_menu.add(cpy_item);

        //paste menu
        paste_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        paste_item.setForeground(DARK_GRAY);
        paste_item.setBorder(null);
        paste_item.addActionListener(this);
        edit_menu.add(paste_item);

        //delete menu
        dlt_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        dlt_item.setForeground(DARK_GRAY);
        dlt_item.setBorder(null);
        dlt_item.addActionListener(this);
        edit_menu.add(dlt_item);

        //font settings
        font_settings.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        font_settings.setForeground(DARK_GRAY);
        font_settings.setBorder(null);
        font_settings.addActionListener(this);
        options_menu.add(font_settings);

        //theme settings
        theme_settings.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        theme_settings.setForeground(Color.DARK_GRAY);
        theme_settings.setBorder(null);
        theme_settings.addActionListener(this);
        options_menu.add(theme_settings);

        //info menu
        info_item.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
        info_item.setForeground(Color.DARK_GRAY);
        info_item.setBorder(null);
        info_item.addActionListener(this);
        about_menu.add(info_item);

        /**
         * Setting up the frame
         */
        setTitle("TextEditor++");
        setVisible(true);
        setBounds(100,100,1100,580);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        add(menu_bar);
        add(scroll);
    }







    /**
     *  -------------------- Action listener --------------------------------
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        /**
         * open
         */
        if(e.getSource()==load_item) {
            JFileChooser file_chooser = new JFileChooser();
            File file;
            Scanner scan = null;

            FileNameExtensionFilter java = new FileNameExtensionFilter("java file","java");
            FileNameExtensionFilter txt = new FileNameExtensionFilter("text file","txt");
            FileNameExtensionFilter cpp = new FileNameExtensionFilter("c++ file","cpp");
            FileNameExtensionFilter html = new FileNameExtensionFilter("html document","html");
            FileNameExtensionFilter fxml = new FileNameExtensionFilter("fxml document","fxml");
            FileNameExtensionFilter css = new FileNameExtensionFilter("stylesheet","css");
            FileNameExtensionFilter xml = new FileNameExtensionFilter("xml document", "xml");

            file_chooser.setFileFilter(txt);
            file_chooser.setFileFilter(cpp);
            file_chooser.setFileFilter(java);
            file_chooser.setFileFilter(html);
            file_chooser.setFileFilter(fxml);
            file_chooser.setFileFilter(css);
            file_chooser.setFileFilter(xml);

            int response = file_chooser.showOpenDialog(null);

            boolean has_selected = (response == JFileChooser.APPROVE_OPTION) ?
              true
              :
              false
            ;

            if(has_selected) {
                file = new File(file_chooser.getSelectedFile().getAbsolutePath());
                try {
                    scan = new Scanner(file);
                    if(file.isFile()) {
                        while(scan.hasNextLine()) {
                            String content=scan.nextLine()+"\n";
                            text_box.append(content);
                        }
                    }
                }catch(IOException ioex) {
                    JOptionPane.showMessageDialog(null,"File not found!");
                }finally {
                    scan.close();
                }
            }
        }

        /**
         * save
         */
        if(e.getSource() == export_item) {
            JFileChooser file_chooser=new JFileChooser();
            File doc;
            PrintWriter _output_=null;

            int response=file_chooser.showSaveDialog(null);

            boolean is_selected=(response==JFileChooser.APPROVE_OPTION) ?
              true
              :
              false
            ;
            if(is_selected) {
                doc = new File(file_chooser.getSelectedFile().getAbsolutePath());

                try {
                    _output_=new PrintWriter(doc);
                    _output_.println(text_box.getText());
                }catch(IOException io_ex) {
                    JOptionPane.showMessageDialog(null, "File not found!");
                }finally {
                    _output_.close();
                }
            }

        }

        /**
         * new window
         */
        if(e.getSource()==new_window_item) {
            new Editor().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        /**
         * exit
         */
        if(e.getSource()==close_item) {
            System.exit(0);
        }

        /**
         * select all
         */
        if(e.getSource() == select_all) {
            text_box.selectAll();
        }

        /**
         * copy
         */
        if(e.getSource()==cpy_item) {
            cpytxt=text_box.getSelectedText();
        }

        /**
         * paste
         */
        if(e.getSource()==paste_item) {
            text_box.setText(cpytxt);
        }

        /**
         * delete
         */
        if(e.getSource()==dlt_item) {
            boolean has_not_content=(text_box.getText()=="") ?
                    true
                    :
                    false
                    ;
            if(has_not_content) {
                JOptionPane.showMessageDialog(null,"Empty field!");
            }else {
                text_box.setText("");
            }
        }

        /**
         * font and color
         */
        if(e.getSource() == font_settings) {
            //initialize components
            family_lbl.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            family_lbl.setForeground(DARK_GRAY);
            family_lbl.setBounds(10,22,80,20);
            family_lbl.addMouseListener(this);

            font_box.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            font_box.setForeground(DARK_GRAY);
            font_box.setBorder(null);
            font_box.setSelectedItem("Ubuntu Mono");
            font_box.setBounds(55,23,230,20);
            font_box.addMouseListener(this);
            font_box.addActionListener(e1 -> {
                text_box.setFont(new Font((String)font_box.getSelectedItem(),Font.PLAIN,(int)text_box.getFont().getSize()));
            });

            size_lbl.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            size_lbl.setForeground(DARK_GRAY);
            size_lbl.setBounds(300,22,60,20);
            size_lbl.addMouseListener(this);

            size_spin = new JSpinner(size_mdl);
            size_spin.setBounds(347,23,55,20);
            size_spin.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            size_spin.setForeground(DARK_GRAY);
            size_spin.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // TODO Auto-generated method stub
                    text_box.setFont(new Font((String)text_box.getFont().getFamily(),Font.PLAIN,(int)size_spin.getValue()));
                }
            });

            color_lbl.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            color_lbl.setForeground(DARK_GRAY);
            color_lbl.setBounds(417,22,60,20);
            color_lbl.addMouseListener(this);

            color_block.setBounds(470,20,25,25);
            color_block.setBackground(DARK_GRAY);
            color_block.setOpaque(true);
            color_block.setBorder(BorderFactory.createLineBorder(Color.black));
            color_block.addMouseListener(this);

            //Setting up the frame
            font_config_frame.setBounds(300,300,516,100);
            font_config_frame.setLayout(null);
            font_config_frame.setVisible(true);
            font_config_frame.setResizable(false);
            font_config_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            font_config_frame.getContentPane().setBackground(Color.white);
            font_config_frame.add(family_lbl);
            font_config_frame.add(font_box);
            font_config_frame.add(size_lbl);
            font_config_frame.add(size_spin);
            font_config_frame.add(color_lbl);
            font_config_frame.add(color_block);
        }

        /**
         * theme
         */
        if(e.getSource() == theme_settings){
            //initialize components
            theme_lbl.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            theme_lbl.setForeground(Color.DARK_GRAY);
            theme_lbl.setBounds(34,7,70,20);
            theme_lbl.addMouseListener(this);

            theme_box.setBounds(95,8,100,20);
            theme_box.setFont(new Font("Ubuntu Mono Regular",Font.PLAIN,13));
            theme_box.setForeground(Color.DARK_GRAY);
            theme_box.setBorder(null);
            theme_box.addActionListener(e1 -> {
                switch(theme_box.getSelectedIndex()){
                    case 0:
                        set_classic_theme();
                        break;
                    case 1:
                        set_dark_theme();
                        break;
                    case 2:
                        set_darker_theme();
                        break;
                    case 3:
                        set_gray_theme();
                    break;
                }
            });
            theme_box.addMouseListener(this);

            //setting up the frame
            theme_frame.setBounds(300,300,250,30);
            theme_frame.setLayout(null);
            theme_frame.setVisible(true);
            theme_frame.setResizable(false);
            theme_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            theme_frame.getContentPane().setBackground(Color.white);
            theme_frame.add(theme_lbl);
            theme_frame.add(theme_box);
        }

        /**
         * Info
         */
        if(e.getSource() == info_item){
            info_lbl.setBounds(120,10,70,20);
            info_lbl.setForeground(Color.DARK_GRAY);
            info_lbl.setFont(new Font("Z003",Font.PLAIN,21));
            info_lbl.addMouseListener(this);

            info_area.setBackground(new Color(250,250,250));
            info_area.setForeground(Color.DARK_GRAY);
            info_area.setEditable(false);
            info_area.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
            info_area.setBounds(0,43,getContentPane().getWidth(),getContentPane().getHeight() - 42);
            info_area.setCaretColor(new Color(247,247,247));
            info_area.setText(
              "\n  > Application name\n TextEditor++\n\n  > Application version\n 1.0.8"
              + "\n\n  > Date of manifacture\n Friday 01 Novermber 2024\n\n  > Programmer"
              + "\n Tsvetelin Marinov\n\n  > License\n Free to use"
            );
            info_area.addMouseListener(this);

            //setting up the frame
            info_frame.setBounds(300,300,300,350);
            info_frame.setVisible(true);
            info_frame.setLayout(null);
            info_frame.setResizable(false);
            info_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            info_frame.getContentPane().setBackground(Color.white);
            info_frame.add(info_lbl);
            info_frame.add(info_area);
        }
    }






    /**
     *  ---------------------- Mouse Listener ------------------------------
     */
    @Override
    @SuppressWarnings("static-access")
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        /**
         * show color chooser and select a color
         */
        if(e.getSource() == color_block){
            JColorChooser clr_chsr = new JColorChooser();
            Color color = clr_chsr.showDialog(null,"choose color",Color.DARK_GRAY);
            text_box.setForeground(color);
            color_block.setBackground(color);
        }
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

        /**
         * File menu
         */
        if(e.getSource() == file_menu) {
            file_menu.setForeground(new Color(78,34,160));
        }

        /**
         * Edit menu
         */
        if(e.getSource() == edit_menu) {
            edit_menu.setForeground(new Color(78,34,160));
        }

        /**
         * Options menu
         */
        if(e.getSource() == options_menu) {
            options_menu.setForeground(new Color(78,34,160));
        }

        /**
         * About menu
         */
        if(e.getSource() == about_menu) {
            about_menu.setForeground(new Color(78,34,160));
        }

        /**
         * Font box
         */
        if(e.getSource()==font_box) {
            font_box.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        }

        /**
         * Theme box
         */
        if(e.getSource() == theme_box) {
            theme_box.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        }

        /**
         * family label
         */
        if(e.getSource() == family_lbl){
            family_lbl.setForeground(new Color(78,34,160));
        }

        /**
         * size label
         */
        if(e.getSource() == size_lbl){
            size_lbl.setForeground(new Color(78,34,160));
        }

        /**
         * color label
         */
        if(e.getSource() == color_lbl){
            color_lbl.setForeground(new Color(78,34,160));
        }

        /**
         * color block
         */
        if(e.getSource() == color_block){
            color_block.setBorder(BorderFactory.createLineBorder(new Color(78,34,160),1));
        }

        /**
         * information label
         */
        if(e.getSource() == info_lbl){
            info_lbl.setForeground(new Color(78,34,160));
        }

        /**
         * information text area
         */
        if(e.getSource() == info_area){
            info_area.setForeground(Color.black);
            info_area.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }

        /**
         * theme label
         */
        if(e.getSource() == theme_lbl){
            theme_lbl.setForeground(new Color(78,34,160));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        /**
         * File menu
         */
        if(e.getSource() == file_menu) {
            file_menu.setForeground(DARK_GRAY);
        }

        /**
         * Edit menu
         */
        if(e.getSource() == edit_menu) {
            edit_menu.setForeground(DARK_GRAY);
        }

        /**
         * Options menu
         */
        if(e.getSource() == options_menu) {
            options_menu.setForeground(DARK_GRAY);
        }

        /**
         * About menu
         */
        if(e.getSource() == about_menu) {
            about_menu.setForeground(DARK_GRAY);
        }

        /**
         * font box
         */
        if(e.getSource()==font_box) {
            font_box.setBorder(null);
        }

        /**
         * theme box
         */
        if(e.getSource() == theme_box) {
            theme_box.setBorder(null);
        }

        /**
         * font family name label
         */
        if(e.getSource() == family_lbl){
            family_lbl.setForeground(Color.DARK_GRAY);
        }

        /**
         * font size label
         */
        if(e.getSource() == size_lbl){
            size_lbl.setForeground(Color.DARK_GRAY);
        }

        /**
         * color label
         */
        if(e.getSource() == color_lbl){
            color_lbl.setForeground(Color.DARK_GRAY);
        }

        /**
         * color block
         */
        if(e.getSource() == color_block){
            color_block.setBorder(BorderFactory.createLineBorder(Color.black));
        }

        /**
         * information label
         */
        if(e.getSource() == info_lbl){
            info_lbl.setForeground(Color.DARK_GRAY);
        }

        /**
         * information text area
         */
        if(e.getSource() == info_area){
            info_area.setForeground(Color.DARK_GRAY);
            info_area.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        }

        /**
         * theme name label
         */
        if(e.getSource() == theme_lbl){
            theme_lbl.setForeground(Color.DARK_GRAY);
        }
    }






    /**
     * -------------------------- Themes ----------------------------------
     */




    /**
     * -------------------------- Classic theme ----------------------------
     */
    public void set_classic_theme() {
        getContentPane().setBackground(Color.white);

        menu_bar.setBackground(Color.white);

        text_box.setForeground(Color.black);
        text_box.setBackground(Color.white);
        text_box.setCaretColor(Color.DARK_GRAY);

        file_menu.setBackground(Color.white);
        file_menu.setForeground(Color.DARK_GRAY);
        file_menu.addMouseListener(new MouseListener(){
            @Override
            public void mousePressed(MouseEvent ms_evnt){

            }

            @Override
            public void mouseReleased(MouseEvent ms_evnt){

            }

            @Override
            public void mouseClicked(MouseEvent ms_evnt){

            }

            @Override
            public void mouseEntered(MouseEvent ms_evnt){
                file_menu.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent ms_evnt){
                file_menu.setForeground(Color.DARK_GRAY);
            }
        });

        edit_menu.setForeground(Color.DARK_GRAY);
        edit_menu.setBackground(Color.white);
        edit_menu.addMouseListener(new MouseListener(){
            @Override
            public void mousePressed(MouseEvent ms_evnt){

            }

            @Override
            public void mouseReleased(MouseEvent ms_evnt){

            }

            @Override
            public void mouseClicked(MouseEvent ms_evnt){

            }

            @Override
            public void mouseEntered(MouseEvent ms_evnt){
                edit_menu.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent ms_evnt){
                edit_menu.setForeground(Color.DARK_GRAY);
            }

        });

        options_menu.setBackground(Color.white);
        options_menu.setForeground(Color.DARK_GRAY);
        options_menu.addMouseListener(new MouseListener(){
            @Override
            public void mousePressed(MouseEvent ms_evnt){

            }

            @Override
            public void mouseReleased(MouseEvent ms_evnt){

            }

            @Override
            public void mouseClicked(MouseEvent ms_evnt){

            }

            @Override
            public void mouseExited(MouseEvent ms_evnt){
                options_menu.setForeground(Color.DARK_GRAY);
            }

            @Override
            public void mouseEntered(MouseEvent ms_evnt){
                options_menu.setForeground(new Color(78,34,160));
            }
        });

        about_menu.setBackground(Color.white);
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
                about_menu.setForeground(new Color(78,34,160));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                about_menu.setForeground(Color.DARK_GRAY);
            }

        });

        load_item.setBackground(Color.white);
        load_item.setForeground(Color.DARK_GRAY);

        export_item.setBackground(Color.white);
        export_item.setForeground(Color.DARK_GRAY);

        new_window_item.setBackground(Color.white);
        new_window_item.setForeground(Color.DARK_GRAY);

        close_item.setBackground(Color.white);
        close_item.setForeground(Color.DARK_GRAY);

        select_all.setForeground(Color.DARK_GRAY);
        select_all.setBackground(Color.white);

        cpy_item.setBackground(Color.white);
        cpy_item.setForeground(Color.DARK_GRAY);

        paste_item.setBackground(Color.white);
        paste_item.setForeground(Color.DARK_GRAY);

        dlt_item.setBackground(Color.white);
        dlt_item.setForeground(Color.DARK_GRAY);

        font_settings.setBackground(Color.white);
        font_settings.setForeground(Color.DARK_GRAY);

        theme_settings.setBackground(Color.white);
        theme_settings.setForeground(Color.DARK_GRAY);

        info_item.setBackground(Color.white);
        info_item.setForeground(Color.DARK_GRAY);

        text_box.setBackground(Color.white);

        scroll.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));

        font_config_frame.getContentPane().setBackground(Color.white);

        family_lbl.setForeground(Color.DARK_GRAY);
        family_lbl.addMouseListener(new MouseListener(){

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
                family_lbl.setForeground(new Color(78,34,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                family_lbl.setForeground(Color.DARK_GRAY);
            }
        });

        font_box.setBackground(Color.white);
        font_box.setForeground(Color.DARK_GRAY);
        font_box.addMouseListener(new MouseListener() {

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
                font_box.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                font_box.setBorder(null);
            }

        });

        size_lbl.setForeground(Color.DARK_GRAY);
        size_lbl.addMouseListener(new MouseListener(){

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
                size_lbl.setForeground(new Color(78,34,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                size_lbl.setForeground(new Color(78,34,160));
            }
        });

        size_spin.setBackground(Color.white);
        size_spin.setForeground(Color.DARK_GRAY);

        color_lbl.setForeground(Color.DARK_GRAY);
        color_lbl.addMouseListener(new MouseListener(){

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
                color_lbl.setForeground(new Color(78,34,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                color_lbl.setForeground(Color.DARK_GRAY);
            }
        });

        theme_frame.getContentPane().setBackground(Color.white);

        theme_lbl.setForeground(Color.DARK_GRAY);
        theme_lbl.addMouseListener(new MouseListener(){

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
                theme_lbl.setForeground(new Color(78,34,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_lbl.setForeground(Color.DARK_GRAY);
            }
        });

        theme_box.setForeground(Color.DARK_GRAY);
        theme_box.setBackground(Color.white);
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
                theme_box.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                theme_box.setBorder(null);
            }

        });

        info_frame.getContentPane().setBackground(Color.white);

        info_lbl.setForeground(Color.DARK_GRAY);

        info_area.setBackground(new Color(251,251,251));
        info_area.setForeground(Color.black);
    }




    /**
     * ----------------------- Dark theme ------------------------------------
     */
    public void set_dark_theme(){
        getContentPane().setBackground(Color.DARK_GRAY);

        menu_bar.setBackground(Color.DARK_GRAY);

        scroll.setBorder(BorderFactory.createLineBorder(Color.cyan));

        text_box.setBackground(new Color(40,40,40));
        text_box.setForeground(Color.white);
        text_box.setCaretColor(Color.white);

        file_menu.setBackground(Color.DARK_GRAY);
        file_menu.setForeground(Color.white);
        file_menu.addMouseListener(new MouseListener(){

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
                file_menu.setForeground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                file_menu.setForeground(Color.white);
            }
        });

        edit_menu.setBackground(Color.DARK_GRAY);
        edit_menu.setForeground(Color.white);
        edit_menu.addMouseListener(new MouseListener(){

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
                edit_menu.setForeground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                edit_menu.setForeground(Color.white);
            }
        });

        options_menu.setBackground(Color.DARK_GRAY);
        options_menu.setForeground(Color.white);
        options_menu.addMouseListener(new MouseListener(){

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
                options_menu.setForeground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                options_menu.setForeground(Color.white);
            }
        });

        about_menu.setBackground(Color.DARK_GRAY);
        about_menu.setForeground(Color.white);
        about_menu.addMouseListener(new MouseListener(){

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
                about_menu.setForeground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                about_menu.setForeground(Color.white);
            }
        });

        load_item.setBackground(Color.DARK_GRAY);
        load_item.setForeground(Color.white);

        export_item.setBackground(Color.DARK_GRAY);
        export_item.setForeground(Color.white);

        new_window_item.setBackground(Color.DARK_GRAY);
        new_window_item.setForeground(Color.white);

        close_item.setBackground(Color.DARK_GRAY);
        close_item.setForeground(Color.white);

        select_all.setBackground(Color.DARK_GRAY);
        select_all.setForeground(Color.white);

        cpy_item.setBackground(Color.DARK_GRAY);
        cpy_item.setForeground(Color.white);

        paste_item.setBackground(Color.DARK_GRAY);
        paste_item.setForeground(Color.white);

        dlt_item.setBackground(Color.DARK_GRAY);
        dlt_item.setForeground(Color.white);

        font_settings.setBackground(Color.DARK_GRAY);
        font_settings.setForeground(Color.white);

        theme_settings.setBackground(Color.DARK_GRAY);
        theme_settings.setForeground(Color.white);

        info_item.setBackground(Color.DARK_GRAY);
        info_item.setForeground(Color.white);

        font_config_frame.getContentPane().setBackground(Color.DARK_GRAY);

        family_lbl.setForeground(Color.white);

        font_box.setBackground(new Color(25,25,25));
        font_box.setForeground(Color.white);
        font_box.setBorder(BorderFactory.createLineBorder(Color.cyan));
        font_box.addMouseListener(new MouseListener(){

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
                font_box.setBorder(BorderFactory.createLineBorder(Color.black));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                font_box.setBorder(null);
            }
        });

        size_lbl.setForeground(Color.white);

        size_spin.setBackground(Color.DARK_GRAY);
        size_spin.setForeground(Color.white);
        size_spin.setBorder(BorderFactory.createLineBorder(Color.cyan));

        color_lbl.setForeground(Color.white);

        color_block.setBorder(BorderFactory.createLineBorder(Color.cyan));

        theme_frame.getContentPane().setBackground(Color.DARK_GRAY);

        theme_lbl.setForeground(Color.white);
        theme_lbl.addMouseListener(new MouseListener(){

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
                theme_lbl.setForeground(Color.cyan);
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_lbl.setForeground(Color.white);
            }
        });

        theme_box.setBackground(new Color(30,30,30));
        theme_box.setForeground(Color.white);
        theme_box.addMouseListener(new MouseListener(){

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
                theme_box.setBorder(BorderFactory.createLineBorder(Color.cyan));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                theme_box.setBorder(null);
            }
        });

        info_frame.getContentPane().setBackground(Color.DARK_GRAY);

        info_lbl.setForeground(Color.white);

        info_area.setBackground(new Color(27,27,27));
        info_area.setForeground(Color.white);
        info_area.setCaretColor(new Color(27,27,27));
    }




    /**
     * ---------------------- Gray theme --------------------------------
     */
    public void set_gray_theme(){
        getContentPane().setBackground(new Color(240,240,240));

        text_box.setBackground(new Color(236,236,236));

        scroll.setBorder(BorderFactory.createLineBorder(new Color(66,0,200)));

        menu_bar.setBackground(new Color(240,240,240));

        file_menu.setForeground(Color.black);
        file_menu.setBackground(new Color(220,220,220));
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
                file_menu.setForeground(new Color(66,0,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                file_menu.setForeground(Color.black);
            }

        });

        edit_menu.setForeground(Color.black);
        edit_menu.setBackground(new Color(220,220,220));
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
                edit_menu.setForeground(new Color(66,0,200));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                edit_menu.setForeground(Color.black);
            }

        });

        options_menu.setForeground(Color.black);
        options_menu.setBackground(new Color(220,220,220));
        options_menu.addMouseListener(new MouseListener(){

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
                options_menu.setForeground(new Color(66,0,200));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                options_menu.setForeground(Color.black);
            }
        });

        about_menu.setForeground(Color.black);
        about_menu.setBackground(new Color(220,220,220));
        about_menu.addMouseListener(new MouseListener(){

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mousePressed(MouseEvent e) {

            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                about_menu.setForeground(new Color(66,0,200));
            }

            /**
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                about_menu.setForeground(Color.black);
            }
        });

        font_box.setForeground(Color.black);
        font_box.setBackground(Color.white);
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
                font_box.setBorder(BorderFactory.createLineBorder(new Color(66,0,200)));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                font_box.setBorder(null);
            }
        });

        theme_box.setBackground(Color.white);
        theme_box.setForeground(Color.black);
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
                theme_box.setBorder(BorderFactory.createLineBorder(new Color(66,0,200)));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_box.setBorder(null);
            }
        });

        theme_lbl.setForeground(Color.black);
        theme_lbl.addMouseListener(new MouseListener(){

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
                theme_lbl.setForeground(new Color(66,0,200));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_lbl.setForeground(Color.black);
            }
        });

        theme_frame.getContentPane().setBackground(new Color(236,236,236));

        load_item.setForeground(Color.black);
        load_item.setBackground(new Color(220,220,220));

        export_item.setForeground(Color.black);
        export_item.setBackground(new Color(220,220,220));

        new_window_item.setForeground(Color.black);
        new_window_item.setBackground(new Color(220,220,220));

        close_item.setForeground(Color.black);
        close_item.setBackground(new Color(220,220,220));

        select_all.setForeground(Color.black);
        select_all.setBackground(new Color(220,220,220));
        cpy_item.setForeground(Color.black);
        cpy_item.setBackground(new Color(220,220,220));

        paste_item.setForeground(Color.black);
        paste_item.setBackground(new Color(220,220,220));

        dlt_item.setForeground(Color.black);
        dlt_item.setBackground(new Color(220,220,220));

        font_settings.setForeground(Color.black);
        font_settings.setBackground(new Color(220,220,220));

        theme_settings.setBackground(new Color(220,220,220));
        theme_settings.setForeground(Color.black);

        info_item.setForeground(Color.black);
        info_item.setBackground(new Color(220,220,220));
    }




    /**
     * ---------------------- Darker theme -------------------------------------
     */
    public void set_darker_theme(){
        getContentPane().setBackground(new Color(20,20,20));

        scroll.setBorder(BorderFactory.createLineBorder(new Color(160,90,160)));

        text_box.setBackground(new Color(20, 20, 20));
        text_box.setForeground(new Color(220, 220, 240));
        text_box.setCaretColor(Color.yellow);

        menu_bar.setBackground(new Color(20,20,20));

        file_menu.setForeground(new Color(220,220,240));
        file_menu.addMouseListener(new MouseListener(){

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
                file_menu.setForeground(new Color(160,90,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                file_menu.setForeground(new Color(220,220,240));
            }
        });

        edit_menu.setForeground(new Color(220,220,240));
        edit_menu.addMouseListener(new MouseListener(){

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
                edit_menu.setForeground(new Color(160,90,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                edit_menu.setForeground(new Color(220,220,240));
            }
        });

        options_menu.setForeground(new Color(220,220,240));
        options_menu.addMouseListener(new MouseListener(){

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
                options_menu.setForeground(new Color(160,90,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                options_menu.setForeground(new Color(220,220,240));
            }
        });

        about_menu.setForeground(new Color(220,220,240));
        about_menu.addMouseListener(new MouseListener(){

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
                about_menu.setForeground(new Color(160,90,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                about_menu.setForeground(new Color(220,220,240));
            }
        });

        theme_frame.getContentPane().setBackground(new Color(20,20,20));

        theme_lbl.setForeground(new Color(230,230,230));
        theme_lbl.addMouseListener(new MouseListener(){

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
                theme_lbl.setForeground(new Color(160,90,160));
            }

            /**
             * Invoked when the mouse enters a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                theme_lbl.setForeground(new Color(160,90,160));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_lbl.setForeground(new Color(230,230,230));
            }
        });

        theme_box.setBackground(new Color(20,20,20));
        theme_box.setForeground(Color.white);
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
                theme_box.setBorder(BorderFactory.createLineBorder(new Color(160,90,160)));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                theme_box.setBorder(null);
            }
        });

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
                font_box.setBorder(BorderFactory.createLineBorder(new Color(160,90,160)));
            }

            /**
             * Invoked when the mouse exits a component.
             *
             * @param e the event to be processed
             */
            @Override
            public void mouseExited(MouseEvent e) {
                font_box.setBorder(null);
            }
        });

        theme_frame.getContentPane().setBackground(new Color(20,20,20));

        load_item.setBackground(new Color(20,20,20));
        load_item.setForeground(Color.white);

        export_item.setBackground(new Color(20,20,20));
        export_item.setForeground(Color.white);

        new_window_item.setBackground(new Color(20,20,20));
        new_window_item.setForeground(Color.white);

        close_item.setBackground(new Color(20,20,20));
        close_item.setForeground(Color.white);

        select_all.setBackground(new Color(20,20,20));
        select_all.setForeground(Color.white);

        cpy_item.setBackground(new Color(20,20,20));
        cpy_item.setForeground(Color.white);

        paste_item.setBackground(new Color(20,20,20));
        paste_item.setForeground(Color.white);

        dlt_item.setBackground(new Color(20,20,20));
        dlt_item.setForeground(Color.white);

        font_settings.setBackground(new Color(20,20,20));
        font_settings.setForeground(Color.white);

        theme_settings.setBackground(new Color(20,20,20));
        theme_settings.setForeground(Color.white);

        info_item.setBackground(new Color(20,20,20));
        info_item.setForeground(Color.white);
    }

}