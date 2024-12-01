/**
 * TextEditor++
 *  Application
 */

package appdata;






import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;







/**
 *
 */
@SuppressWarnings("serial")
public class Editor extends JFrame implements MouseListener,ActionListener {

    /**
     * Text box
     */
    private JTextArea textBox = new JTextArea();


    /**
     * ScrollPane
     */
    private JScrollPane scroll = new JScrollPane(textBox);


    /**
     * Menu bar
     */
    private JMenuBar menuBar = new JMenuBar();


    /**
     * File menu
     */
    private JMenu fileMenu = new JMenu("File");


    /**
     * Edit menu
     */
    private JMenu editMenu = new JMenu("Edit");


    /**
     * Options menu
     */
    private JMenu optionsMenu = new JMenu("Options");



    /**
     * About menu
     */
    private JMenu aboutMenu = new JMenu("About");


    /**
     * new file
     */
    private JMenuItem newFile = new JMenuItem("new file");


    /**
     * open
     */
    private JMenuItem load = new JMenuItem("open");


    /**
     * save
     */
    private JMenuItem export = new JMenuItem("save");


    /**
     * new window
     */
    private JMenuItem newWindow = new JMenuItem("new window");


    /**
     * restart
     */
    private JMenuItem reboot = new JMenuItem("restart");


    /**
     * exit
     */
    private JMenuItem close = new JMenuItem("exit");


    /**
     * select all
     */
    private JMenuItem selectAll = new JMenuItem("select all");


    /**
     * copy
     */
    private JMenuItem cpy = new JMenuItem("copy");


    /**
     * paste
     */
    private JMenuItem paste = new JMenuItem("paste");


    /**
     * Holds the copied text
     */
    private String cpytxt;


    /**
     * delete all
     */
    private JMenuItem dltAll = new JMenuItem("delete all");


    /**
     * settings
     */
    private JMenuItem settings = new JMenuItem("settings");


    /**
     * settings window
     */
    private JFrame settingsWindow = new JFrame();


    /**
     * Font section
     */
    private JLabel fontSection = new JLabel("Font and color");


    /**
     * Font family label
     */
    private JLabel fontFamily = new JLabel("font");


    /**
     * Local fonts
     */
    String[] localFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();


    /**
     * Font box
     */
    private JComboBox<String> fontBox = new JComboBox<String>(localFonts);


    /**
     * Font size label
     */
    private JLabel fontSize = new JLabel("size");


    /**
     * Spinner model for the font size spinner
     */
    private SpinnerModel spnmdl = new SpinnerNumberModel((int)textBox.getFont().getSize(),0,50,1);


    /**
     * Font size spinner
     */
    private JSpinner fontSizeSpiner = new JSpinner(spnmdl);


    /**
     * Font style label
     */
    private JLabel fontStyle = new JLabel("style");


    /**
     * Font styles
     * normal, bold, italic
     */
    private String[] fontStyles = {"normal","bold","italic"};


    /**
     * Font style box
     */
    private JComboBox<String> fontStyleBox = new JComboBox<String>(fontStyles);


    /**
     * Font color label
     */
    private JLabel fontColor = new JLabel("color");


    /**
     * Font color color chooser
     */
    private JButton fontColorChooser = new JButton("choose");


    /**
     * Reset the font
     */
    private JButton resetFont = new JButton("reset defaults");


    /**
     * Theme section
     */
    private JLabel themeSection = new JLabel("Theme");


    /**
     * Theme label
     */
    private JLabel theme = new JLabel("theme");


    /**
     * themes
     */
    private String[] themes = {"classic","dark","gray"};


    /**
     * themes box
     */
    private JComboBox<String> themeBox = new JComboBox<String>(themes);


    /**
     * Manal set the apperance
     */
    private JButton apperButton = new JButton("configure manual");


    /**
     * Spacer
     */
    private JLabel spacer1 = new JLabel("-----------------------------------");


    /**
     * Spacer
     */
    private JLabel spacer2 = new JLabel("-------------------------------------");


    /**
     * Spacer
     */
    private JLabel spacer3 = new JLabel("----------------------------------------");


    /**
     * Spacer
     */
    private JLabel spacer4 = new JLabel("-------------------------------------------");


    /**
     * Spacer
     */
    private JLabel spacer5 = new JLabel("----------------------");


    /**
     * Scpacer
     */
    private JLabel spacer6 = new JLabel("-----------------------");


    /**
     * Manual settings window
     */
    private JFrame manualFrame = new JFrame("Manual settings");


    /**
     * Manual settings logo label
     */
    private JLabel apperLogo = new JLabel("Configure apperance manual");


    /**
     * Font label
     */
    private JLabel manualFont = new JLabel("foreground");


    /**
     * Font color chooser
     */
    private JButton manualFontColorChooser = new JButton("choose");


    /**
     * Text box background label
     */
    private JLabel manualTextBoxBackground = new JLabel("text box background");


    /**
     * Text box background color chooser
     */
    private JButton manualTextBoxBackgroundButton = new JButton("choose");


    /**
     * Application background label
     */
    private JLabel appBackground = new JLabel("application background");


    /**
     * Application background color chooser
     */
    private JButton appColorChooser = new JButton("choose");


    /**
     * Border color label
     */
    private JLabel borderColor = new JLabel("border line color");


    /**
     * Border color chooser
     */
    private JButton borderColorChooser = new JButton("choose");


    /**
     * Reset defaults button
     */
    private JButton resetDefaults = new JButton("reset defaults");


    /**
     * info
     */
    private JMenuItem info = new JMenuItem("information");
    
    
    /**
     * Information window
     */
    private JFrame infoFrame = new JFrame("About");
    
    
    /**
     * Information window text area
     */
    private JTextArea infoBox = new JTextArea();
    
    
    /**
     * Tips and tricks
     */
    private JMenuItem tipsAndTricks = new JMenuItem("tips and tricks");
    
    
    /**
     * Tips window
     */
    private JFrame tipsWindow = new JFrame("Tips and tricks");
    
    
    /**
     * Tips text box
     */
    private JTextArea tipsBox = new JTextArea();
    
    
    /**
     * Scroll pane for the text box
     */
    private JScrollPane tipsScroll = new JScrollPane(tipsBox);
    
    
    




    /**
     *
     */
    Editor(){
        /**
         * Text box
         */
        textBox.setFont(new Font("Cascadia Mono",Font.PLAIN,20));
        textBox.setForeground(Color.black);
        textBox.setCaretColor(new Color(78,34,160));
        textBox.setBackground(new Color(251,251,251));
        textBox.setFocusable(true);


        /**
         * Scroll pane
         */
        scroll.setBounds(-1,40,1086,471);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setWheelScrollingEnabled(true);


        /**
         * Menu bar
         */
        menuBar.setBounds(0,0,300,25);
        menuBar.setBorder(null);
        menuBar.setBackground(new Color(248,248,248));
        menuBar.addMouseListener(this);


        /**
         * file menu
         */
        fileMenu.setFont(new Font("Cascadia Code",Font.PLAIN,16));
        fileMenu.setForeground(Color.DARK_GRAY);
        fileMenu.setBackground(Color.white);
        fileMenu.setBorder(null);
        fileMenu.addMouseListener(this);
        menuBar.add(fileMenu);


        /**
         * edit menu
         */
        editMenu.setFont(new Font((String)fileMenu.getFont().getFamily(), (int)fileMenu.getFont().getStyle(), (int)fileMenu.getFont().getSize()));
        editMenu.setForeground((Color)fileMenu.getForeground());
        editMenu.setBackground((Color)fileMenu.getBackground());
        editMenu.setBorder((Border)fileMenu.getBorder());
        editMenu.addMouseListener(this);
        menuBar.add(editMenu);


        /**
         * options menu
         */
        optionsMenu.setFont(new Font((String)fileMenu.getFont().getFamily(), (int)fileMenu.getFont().getStyle(), (int)fileMenu.getFont().getSize()));
        optionsMenu.setForeground((Color)fileMenu.getForeground());
        optionsMenu.setBackground((Color)fileMenu.getBackground());
        optionsMenu.setBorder((Border)fileMenu.getBorder());
        optionsMenu.addMouseListener(this);
        menuBar.add(optionsMenu);



        /**
         * about menu
         */
        aboutMenu.setFont(new Font((String)fileMenu.getFont().getFamily(), (int)fileMenu.getFont().getStyle(), (int)fileMenu.getFont().getSize()));
        aboutMenu.setForeground((Color)fileMenu.getForeground());
        aboutMenu.setBackground((Color)fileMenu.getBackground());
        aboutMenu.setBorder((Border)fileMenu.getBorder());
        aboutMenu.addMouseListener(this);
        menuBar.add(aboutMenu);


        
        //The menu item background color
        Color back = new Color(180,200,250);
        /**
         * new file
         */
        newFile.setFont(new Font( (String)fileMenu.getFont().getFamily(), (int)fileMenu.getFont().getStyle(),(14)));
        newFile.setForeground(Color.black);
        newFile.setBackground(back);
        newFile.setBorder(null);
        newFile.addMouseListener(this);
        newFile.addActionListener(this);
        fileMenu.add(newFile);


        /**
         * open
         */
        load.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        load.setForeground((Color)newFile.getForeground());
        load.setBackground(back);
        load.setBorder((Border)newFile.getBorder());
        load.addMouseListener(this);
        load.addActionListener(this);
        fileMenu.add(load);


        /**
         * save
         */
        export.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize() ));
        export.setForeground((Color)newFile.getForeground());
        export.setBackground(back);
        export.setBorder((Border)newFile.getBorder());
        export.addActionListener(this);
        export.addMouseListener(this);
        fileMenu.add(export);


        /**
         * new window
         */
        newWindow.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        newWindow.setForeground((Color)newFile.getForeground());
        newWindow.setBackground(back);
        newWindow.setBorder((Border)newFile.getBorder());
        newWindow.addMouseListener(this);
        newWindow.addActionListener(this);
        fileMenu.add(newWindow);


        /**
         * restart
         */
        reboot.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        reboot.setForeground((Color)newFile.getForeground());
        reboot.setBackground(back);
        reboot.setBorder((Border)newFile.getBorder());
        reboot.addMouseListener(this);
        reboot.addActionListener(this);
        fileMenu.add(reboot);


        close.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        close.setForeground((Color)newFile.getForeground());
        close.setBackground(back);
        close.setBorder((Border)newFile.getBorder());
        close.addMouseListener(this);
        close.addActionListener(this);
        fileMenu.add(close);


        /**
         * select all
         */
        selectAll.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        selectAll.setForeground((Color)newFile.getForeground());
        selectAll.setBackground(back);
        selectAll.setBorder((Border)newFile.getBorder());
        selectAll.addMouseListener(this);
        selectAll.addActionListener(this);
        editMenu.add(selectAll);


        /**
         * copy
         */
        cpy.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        cpy.setForeground((Color)newFile.getForeground());
        cpy.setBackground(back);
        cpy.setBorder((Border)newFile.getBorder());
        cpy.addMouseListener(this);
        cpy.addActionListener(this);
        editMenu.add(cpy);


        /**
         * paste
         */
        paste.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        paste.setForeground((Color)newFile.getForeground());
        paste.setBackground(back);
        paste.setBorder((Border)newFile.getBorder());
        paste.addMouseListener(this);
        paste.addActionListener(this);
        editMenu.add(paste);


        /**
         * delete all
         */
        dltAll.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        dltAll.setForeground((Color)newFile.getForeground());
        dltAll.setBackground(back);
        dltAll.setBorder((Border)newFile.getBorder());
        dltAll.addMouseListener(this);
        dltAll.addActionListener(this);
        editMenu.add(dltAll);
        
        

        /**
         * settings
         */
        settings.setFont(new Font((String)newFile.getFont().getFamily(), (int)newFile.getFont().getStyle(), (int)newFile.getFont().getSize()));
        settings.setForeground((Color)newFile.getForeground());
        settings.setBackground(back);
        settings.setBorder((Border)newFile.getBorder());
        settings.addMouseListener(this);
        settings.addActionListener(this);
        optionsMenu.add(settings);
        
        
        /**
         * Information 
         */
        info.setFont((Font)newFile.getFont());
        info.setForeground((Color)newFile.getForeground());
        info.setBackground(back);
        info.setBorder(null);
        info.setFocusable(true);
        info.addMouseListener(this);
        info.addActionListener(this);
        aboutMenu.add(info);
        
        
        /**
         * Tips and tricks
         */
        tipsAndTricks.setFont((Font)info.getFont());
        tipsAndTricks.setForeground((Color)info.getForeground());
        tipsAndTricks.setBackground(back);
        tipsAndTricks.setBorder(null);
        tipsAndTricks.addMouseListener(this);
        tipsAndTricks.addActionListener(this);
        aboutMenu.add(tipsAndTricks);


        /**
         * setting up the frame
         */
        this.setTitle("TextEditor++");
        this.setSize(1100,550);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(249,249,249));


        /**
         * add the components to the frame
         */
        this.add(menuBar);
        this.add(scroll);
    }







    /**
     * ------------------------------ ActionListener -----------------------------------
     *
     * @param e -- the event to be proccesed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        /**
         * new file
         */
        if(e.getSource() == newFile) {

            //show warning
            JOptionPane.showMessageDialog(
                    this,
                    "Unsaved data will be lost!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );


            //clear the text box
            textBox.setText("");

        }


        /**
         * open
         */
        if(e.getSource() == load){

            //File chooser
            JFileChooser fileChooser = new JFileChooser();

            //The future file
            File document;

            //Holds the response from the file chooser
            int response;

            //Scanner to scan selected file
            Scanner scanner = null;
            
            //File extensions
            FileNameExtensionFilter txt = new FileNameExtensionFilter("text file","txt");
            FileNameExtensionFilter html = new FileNameExtensionFilter("html document","html");
            FileNameExtensionFilter fxml = new FileNameExtensionFilter("fxml document","fxml");
            FileNameExtensionFilter xml = new FileNameExtensionFilter("xml configuration","xml");
            FileNameExtensionFilter cpp = new FileNameExtensionFilter("C++ file","cpp");
            FileNameExtensionFilter c = new FileNameExtensionFilter("C file","c");
            FileNameExtensionFilter cs = new FileNameExtensionFilter("C# file","cs");
            FileNameExtensionFilter java = new FileNameExtensionFilter("java file","java");
            FileNameExtensionFilter css = new FileNameExtensionFilter("style sheet","css");
            FileNameExtensionFilter js = new FileNameExtensionFilter("java script file","js");
            FileNameExtensionFilter py = new FileNameExtensionFilter("pyton file","py");
            FileNameExtensionFilter iml = new FileNameExtensionFilter("iml configuration","iml");
            
            
            //Apply filters to the file chooser
            fileChooser.setFileFilter(txt);
            fileChooser.setFileFilter(html);
            fileChooser.setFileFilter(fxml);
            fileChooser.setFileFilter(xml);
            fileChooser.setFileFilter(cpp);
            fileChooser.setFileFilter(c);
            fileChooser.setFileFilter(cs);
            fileChooser.setFileFilter(java);
            fileChooser.setFileFilter(css);
            fileChooser.setFileFilter(js);
            fileChooser.setFileFilter(py);
            fileChooser.setFileFilter(iml);


            //show file chooser and select a file
            response = fileChooser.showOpenDialog(this);


            //Check the response
            @SuppressWarnings("static-access")
            boolean hasSelectedFileToOpen = (response == fileChooser.APPROVE_OPTION)
                    ? true : false
            ;

            //if file has be selected to open, read the file
            if(hasSelectedFileToOpen) {
                //create the file local
                document = new File(fileChooser.getSelectedFile().getAbsolutePath());

                //check if the file is actually a file and read it
                if(document.isFile()) {
                    //Create the scanner to the file
                    try {
                        scanner = new Scanner(document);

                        //set the scanner to scan the text in the file
                        //and copy it to the new local file in the text box
                        while(scanner.hasNextLine()) {
                            String content = scanner.nextLine()+"\n";

                            //append the text from the file to the text box
                            textBox.append(content);
                        }
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(
                                this,
                                "Unable to load file!",
                                "Directory not found",
                                JOptionPane.ERROR_MESSAGE
                        );
                        e1.printStackTrace();
                    }finally {
                        //close the scanner to avoid direct access to the system
                        scanner.close();
                    }
                }
            }

        }



        /**
         * save
         */
        if(e.getSource() == export) {

            //Printwriter to write the the text from the text box to a new file
            PrintWriter _output_ = null;

            //New file
            File doc;

            //FileChooser
            JFileChooser fileChooser = new JFileChooser();

            //Holds the response from the file chooser
            int response;


            //show save dialog
            response = fileChooser.showSaveDialog(this);


            //check the response
            @SuppressWarnings("static-access")
            boolean fileHasBeenSelected = (response == fileChooser.APPROVE_OPTION)
                    ? true : false
            ;


            //if the new file is selected to be created, create the printer and the file
            if(fileHasBeenSelected) {
                //initialize file
                doc = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try {
                    //initialize printer
                    _output_ = new PrintWriter(doc);

                    //Print the text from the text box to the new file
                    _output_.println(textBox.getText());
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(
                            this,
                            "Unable to save file",
                            "Directory not found",
                            JOptionPane.ERROR_MESSAGE
                    );
                    e1.printStackTrace();
                }finally {
                    //close the printer to avoid contact with the system
                    _output_.close();
                }

            }

        }


        /**
         * new window
         */
        if(e.getSource() == newWindow) {
            //Show warning
            JOptionPane.showMessageDialog(
                    this,
                    "Unsaved data will be lost!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );


            //create new window
            Editor clone = new Editor();

            //set the new  window to close without
            //closing the main window
            clone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }


        /**
         * restart
         */
        if(e.getSource() == reboot) {
            //show warning first
            JOptionPane.showMessageDialog(
                    this,
                    "Unsaved data will be lost!",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );

            //dispose current window
            dispose();

            //Launch new application
            @SuppressWarnings("unused")
            Editor rebooted = new Editor();
        }


        /**
         * exit
         */
        if(e.getSource() == close) {
            //ask first
            JOptionPane.showMessageDialog(
                    this,"Do you really want to quit?",
                    "Warning",
                    JOptionPane.QUESTION_MESSAGE
            );


            //terminate the application
            System.exit(0);
        }


        /**
         * settings
         */
        if(e.getSource() == settings) {
            /**
             * font section
             */
            fontSection.setFont(new Font("Fira Code",Font.PLAIN,18));
            fontSection.setForeground((Color)textBox.getForeground());
            fontSection.setBounds(220,30,200,25);
            fontSection.addMouseListener(this);


            /**
             * font family
             */
            fontFamily.setFont(new Font((String)fontSection.getFont().getFamily(), (int)fontSection.getFont().getStyle(), 17));
            fontFamily.setForeground((Color)fontSection.getForeground());
            fontFamily.setBounds(32,90,70,22);
            fontFamily.addMouseListener(this);


            /**
             * font box
             */
            fontBox.setBounds(70,89,250,25);
            fontBox.setFont(new Font("Cascadia Code",Font.PLAIN,16));
            fontBox.setBackground((Color)getContentPane().getBackground());
            fontBox.setBorder(null);
            fontBox.setForeground((Color)textBox.getForeground());
            fontBox.setSelectedItem((String)textBox.getFont().getFamily());
            fontBox.addMouseListener(this);
            fontBox.addActionListener(this);


            /**
             * font size label
             */
            fontSize.setFont((Font)fontFamily.getFont());
            fontSize.setForeground((Color)fontFamily.getForeground());
            fontSize.setBounds(417,90,60,25);
            fontSize.addMouseListener(this);


            /**
             * Font size spinner
             */
            fontSizeSpiner.setBounds(455,90,65,25);
            fontSizeSpiner.setFont((Font)fontFamily.getFont());
            fontSizeSpiner.setBackground(Color.black);
            fontSizeSpiner.setValue((int)textBox.getFont().getSize());
            fontSizeSpiner.setBorder(new LineBorder(Color.black,1));
            fontSizeSpiner.addMouseListener(this);
            fontSizeSpiner.addChangeListener(e1 -> textBox.setFont(new Font((String)textBox.getFont().getFamily(), (int)textBox.getFont().getStyle(), (int)fontSizeSpiner.getValue())));


            /**
             * Font style label
             */
            fontStyle.setFont((Font)fontFamily.getFont());
            fontStyle.setForeground((Color)fontFamily.getForeground());
            fontStyle.setBounds(27,150,50,25);
            fontStyle.addMouseListener(this);


            /**
             * Font styles box
             */
            fontStyleBox.setBounds(70,150,110,25);
            fontStyleBox.setFont((Font)fontBox.getFont());
            fontStyleBox.setForeground((Color)fontBox.getForeground());
            fontStyleBox.setBorder(null);
            fontStyleBox.setSelectedIndex((int)textBox.getFont().getStyle());
            fontStyleBox.setBackground((Color)getContentPane().getBackground());
            fontStyleBox.addMouseListener(this);
            fontStyleBox.addActionListener(this);


            /**
             * Font color label
             */
            fontColor.setFont((Font)fontFamily.getFont());
            fontColor.setForeground((Color)fontFamily.getForeground());
            fontColor.setBounds(410,149,70,25);
            fontColor.addMouseListener(this);


            /**
             * Font color chooser button
             */
            fontColorChooser.setBounds(455,149,95,25);
            fontColorChooser.setFont(new Font("System",Font.PLAIN,15));
            fontColorChooser.setForeground(Color.black);
            fontColorChooser.setFocusable(true);
            fontColorChooser.addActionListener(this);
            fontColorChooser.addMouseListener(this);


            /**
             * reset default font
             */
            resetFont.setBounds(200,230,190,28);
            resetFont.setFont((Font)fontColorChooser.getFont());
            resetFont.setForeground((Color)fontColorChooser.getForeground());
            resetFont.setFocusable(true);
            resetFont.addActionListener(this);
            resetFont.addMouseListener(this);


            /**
             * Theme section label
             */
            themeSection.setFont(new Font((String)fontSection.getFont().getFamily(), (int)fontSection.getFont().getStyle(), (int)fontSection.getFont().getSize()));
            themeSection.setForeground((Color)fontSection.getForeground());
            themeSection.setBounds(250,350,80,25);
            themeSection.addMouseListener(this);


            /**
             * theme label
             */
            theme.setFont((Font)fontFamily.getFont());
            theme.setForeground((Color)fontFamily.getForeground());
            theme.setBounds((int)fontFamily.getX() + 20,410,80,25);
            theme.addMouseListener(this);


            /**
             * Theme box
             */
            themeBox.setBounds(110,410,120,25);
            themeBox.setFont((Font)fontBox.getFont());
            themeBox.setForeground((Color)fontBox.getForeground());
            themeBox.setBackground((Color)getContentPane().getBackground());
            themeBox.setBorder(null);
            themeBox.setSelectedIndex((int)themeBox.getSelectedIndex());
            themeBox.addMouseListener(this);
            themeBox.addActionListener(this);


            /**
             * Manual configuration button
             */
            apperButton.setFont((Font)fontColorChooser.getFont());
            apperButton.setForeground((Color)fontColorChooser.getForeground());
            apperButton.setFocusable(true);
            apperButton.setBounds(300,410,200,25);
            apperButton.addActionListener(this);
            apperButton.addMouseListener(this);


            /**
             * Spacers
             */
            spacer1.setFont((Font)fontFamily.getFont());
            spacer1.setForeground((Color)textBox.getForeground());
            spacer1.setBounds(5,32,270,20);

            spacer2.setFont((Font)fontFamily.getFont());
            spacer2.setForeground((Color)spacer1.getForeground());
            spacer2.setBounds(345,32,250,20);

            spacer3.setFont((Font)fontFamily.getFont());
            spacer3.setForeground((Color)spacer1.getForeground());
            spacer3.setBounds(5,352,270,20);

            spacer4.setFont((Font)fontFamily.getFont());
            spacer4.setForeground((Color)spacer1.getForeground());
            spacer4.setBounds(315,352,300,20);



            //setting up the settings window
            settingsWindow.setTitle("Prefferences");
            settingsWindow.setSize(600,570);
            settingsWindow.setLocationRelativeTo(null);
            settingsWindow.setVisible(true);
            settingsWindow.setResizable(false);
            settingsWindow.setLayout(null);
            //set the settings window to close without cloing the application
            settingsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            settingsWindow.getContentPane().setBackground((Color)getContentPane().getBackground());


            /**
             * add the components to the frame
             */
            settingsWindow.add(fontSection);
            settingsWindow.add(fontFamily);
            settingsWindow.add(fontBox);
            settingsWindow.add(fontSize);
            settingsWindow.add(fontSizeSpiner);
            settingsWindow.add(fontStyle);
            settingsWindow.add(fontStyleBox);
            settingsWindow.add(fontColor);
            settingsWindow.add(fontColorChooser);
            settingsWindow.add(resetFont);
            settingsWindow.add(themeSection);
            settingsWindow.add(theme);
            settingsWindow.add(themeBox);
            settingsWindow.add(apperButton);
            settingsWindow.add(spacer1);
            settingsWindow.add(spacer2);
            settingsWindow.add(spacer3);
            settingsWindow.add(spacer4);

        }


        /**
         * select all
         */
        if(e.getSource() == selectAll){
            //check if the text box is empty first
            boolean textBoxIsEmpty = textBox.getText().isEmpty();

            if(textBoxIsEmpty) {
                //show warning
                JOptionPane.showInternalMessageDialog(
                        null,
                        "The text box is empty!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }


            if(!textBoxIsEmpty) {
                //select all the text in the text box
                textBox.selectAll();
            }

        }


        /**
         * copy
         */
        if(e.getSource() == cpy){
            //check if the text box has content
            boolean textBoxHasNotContent = textBox.getText().isEmpty()
                    ?
                    true : false
            ;

            if(textBoxHasNotContent) {
                //show error
                JOptionPane.showInternalMessageDialog(
                        null,
                        "The text box is empty!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            if(!textBoxHasNotContent) {
                //copy the selected text
                cpytxt = textBox.getSelectedText();
            }

        }


        /**
         * paste
         */
        if(e.getSource() == paste){
            //check if the string that hold the copied text is empty
            boolean hasNotCopiedText = cpytxt == ""
                    ?
                    true : false
            ;

            if(hasNotCopiedText) {
                //show warning
                JOptionPane.showInternalMessageDialog(
                        null,
                        "Copy some text first!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }


            if(!hasNotCopiedText) {
                //append the copied text to the text box
                textBox.append((String) getCopiedText());

                //clear the string for new copied text
                cpytxt = "";
            }

        }


        /**
         * delete all
         */
        if(e.getSource() == dltAll) {
            //check if the text box has text
            boolean hasNotText = textBox.getText().isEmpty()
                    ? true : false
            ;

            if(!hasNotText) {
                //delete all the text in the text box
                textBox.setText("");
            }


            if(hasNotText) {
                //show error
                JOptionPane.showInternalMessageDialog(null, "Empty field!", "Error", JOptionPane.ERROR_MESSAGE);
            }


        }


        /**
         * Font box
         */
        if(e.getSource() == fontBox) {
            //set the text box's font
            textBox.setFont(new Font((String) fontBox.getSelectedItem(), (int) textBox.getFont().getStyle(), (int) textBox.getFont().getSize()));

        }


        /**
         * Font style box
         */
        if(e.getSource() == fontStyleBox) {
            //set the text box's font style
            textBox.setFont(new Font((String) textBox.getFont().getFamily(), (int) fontStyleBox.getSelectedIndex(), (int) textBox.getFont().getSize()));

        }

        /**
         * Font color chooser
         */

        if(e.getSource() == fontColorChooser) {
            //Color chooser to pick a new font color
            JColorChooser clrChooser = new JColorChooser();

            //The new color
            @SuppressWarnings("static-access")
            Color newColor = clrChooser.showDialog(clrChooser, "Pick a color", (Color)textBox.getForeground());

            //set the new foreground color
            textBox.setForeground(newColor);
        }


        /**
         * Reset font button
         */
        if(e.getSource() == resetFont) {
            //reset the font
            fontBox.setSelectedItem("Cascadia Mono");

            //reset the font size
            fontSizeSpiner.setValue(20);

            //reset the font style
            fontStyleBox.setSelectedIndex(0);

            //reset the font color
            textBox.setForeground(Color.black);
        }



        /**
         * Manual config button
         */
        if(e.getSource() == apperButton) {
            /**
             * Logo
             */
            apperLogo.setBounds(145,20,250,25);
            apperLogo.setFont(new Font("System",Font.PLAIN,15));
            apperLogo.setForeground((Color)textBox.getForeground());


            /**
             * Spacers
             */
            spacer5.setFont((Font)spacer1.getFont());
            spacer5.setForeground((Color)spacer1.getForeground());
            spacer5.setBounds(5,22,175,20);

            spacer6.setFont((Font)spacer1.getFont());
            spacer6.setForeground((Color)spacer1.getForeground());
            spacer6.setBounds(340,22,160,20);


            /**
             * Font color label
             */
            manualFont.setFont((Font)apperLogo.getFont());
            manualFont.setForeground((Color)apperLogo.getForeground());
            manualFont.setBounds(97,100,100,22);


            /**
             * Font color chooser
             */
            manualFontColorChooser.setFont(new Font((String)resetFont.getFont().getFamily(),(int)resetFont.getFont().getStyle(),(int)resetFont.getFont().getSize()-3));
            manualFontColorChooser.setForeground((Color)resetFont.getForeground());
            manualFontColorChooser.setBackground((Color)resetFont.getBackground());
            manualFontColorChooser.setFocusable(true);
            manualFontColorChooser.setBounds(180,100,101,22);
            manualFontColorChooser.addActionListener(this);
            manualFontColorChooser.addMouseListener(this);


            /**
             * Manual text box background
             */
            manualTextBoxBackground.setFont((Font)manualFont.getFont());
            manualTextBoxBackground.setForeground((Color)manualFont.getForeground());
            manualTextBoxBackground.setBounds(40,150,250,25);


            /**
             * Text box background color chooser
             */
            manualTextBoxBackgroundButton.setFont((Font)manualFontColorChooser.getFont());
            manualTextBoxBackgroundButton.setForeground((Color)manualFontColorChooser.getForeground());
            manualTextBoxBackgroundButton.setBackground((Color)manualFontColorChooser.getBackground());
            manualTextBoxBackgroundButton.setFocusable(true);
            manualTextBoxBackgroundButton.setBounds(180,151,100,22);
            manualTextBoxBackgroundButton.addActionListener(this);
            manualTextBoxBackgroundButton.addMouseListener(this);


            /**
             * Application background label
             */
            appBackground.setFont((Font)apperLogo.getFont());
            appBackground.setForeground((Color)apperLogo.getForeground());
            appBackground.setBounds(22,200,180,22);


            /**
             * Application color button
             */
            appColorChooser.setFont((Font)manualFontColorChooser.getFont());
            appColorChooser.setForeground((Color)manualFontColorChooser.getForeground());
            appColorChooser.setBounds(180,200,100,22);
            appColorChooser.setFocusable(true);
            appColorChooser.setBackground((Color)manualFontColorChooser.getBackground());
            appColorChooser.addMouseListener(this);
            appColorChooser.addActionListener(this);


            /**
             * Border color label
             */
            borderColor.setFont((Font)appBackground.getFont());
            borderColor.setForeground((Color)appBackground.getForeground());
            borderColor.setBounds(65,250,200,22);


            /**
             * Border color chooser
             */
            borderColorChooser.setFont((Font)appColorChooser.getFont());
            borderColorChooser.setForeground((Color)appColorChooser.getForeground());
            borderColorChooser.setBackground((Color)appColorChooser.getBackground());
            borderColorChooser.setBounds(180,251,100,22);
            borderColorChooser.setFocusable(true);
            borderColorChooser.addMouseListener(this);
            borderColorChooser.addActionListener(this);
            
            
            /**
             * reset defaults button
             */
            resetDefaults.setFont((Font)borderColorChooser.getFont());
            resetDefaults.setForeground((Color)appColorChooser.getForeground());
            resetDefaults.setBackground(appColorChooser.getBackground());
            resetDefaults.setFocusable(true);
            resetDefaults.setBounds(150,330,200,22);
            resetDefaults.addMouseListener(this);
            resetDefaults.addActionListener(this);


            //setting up the frame
            manualFrame.setSize(500,450);
            manualFrame.setVisible(true);
            manualFrame.setResizable(false);
            manualFrame.getContentPane().setBackground((Color)settingsWindow.getContentPane().getBackground());
            manualFrame.setLocationRelativeTo(null);
            manualFrame.setLayout(null);
            manualFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //add the components to the frame
            manualFrame.add(apperLogo);
            manualFrame.add(spacer5);
            manualFrame.add(spacer6);
            manualFrame.add(manualFont);
            manualFrame.add(manualFontColorChooser);
            manualFrame.add(manualTextBoxBackground);
            manualFrame.add(manualTextBoxBackgroundButton);
            manualFrame.add(appBackground);
            manualFrame.add(appColorChooser);
            manualFrame.add(borderColor);
            manualFrame.add(borderColorChooser);
            manualFrame.add(resetDefaults);
        }


        /**
         * Manual font color chooser
         */
        if(e.getSource() == manualFontColorChooser){
            //Color chooser
            JColorChooser manual_color_chooser = new JColorChooser();

            //The new manual color
            @SuppressWarnings("static-access")
			Color manual_clr = manual_color_chooser.showDialog(null,"Pick a color",(Color)textBox.getForeground());

           //Apply settings
           textBox.setForeground(manual_clr);
        }


        /**
         * Manual text box background button
         */
        if(e.getSource() == manualTextBoxBackgroundButton){
            //Color chooser
            JColorChooser clr_chsr = new JColorChooser();

            //The new color
            @SuppressWarnings("static-access")
			Color clr = clr_chsr.showDialog(null,"Pick a color",(Color)textBox.getBackground());

            //apply the changes
            textBox.setBackground(clr);
        }


        /**
         * Application background button
         */
        if(e.getSource() == appColorChooser){
            //Color chooser to select a color and use it
            JColorChooser clrchsr = new JColorChooser();

            //The new color
            @SuppressWarnings("static-access")
			Color clr = clrchsr.showDialog(null,"pick a color",getContentPane().getBackground());

            //Apply changes
            getContentPane().setBackground(clr);
        }


        /**
         * Border color button
         */
        if(e.getSource() == borderColorChooser) {
            //Color chooser to pick a color
            JColorChooser clrchsr = new JColorChooser();

            //The new color
            @SuppressWarnings("static-access")
			Color clr = clrchsr.showDialog(null,"pick a color",new Color(78,34,160));

            //Apply changes
            scroll.setBorder(BorderFactory.createLineBorder(clr,1));
        }

        
        
        /**
         * Reset defaults button(Manual apperance settings)
         */
        if(e.getSource() == resetDefaults) {
        	//reset the foreground color
        	textBox.setForeground(Color.black);
        	
        	//reset the text box background color
        	textBox.setBackground(new Color(251,251,251));
        	
        	//reset the application background color
        	getContentPane().setBackground(new Color(248,248,248));
        	
        	//reset the border line color
        	scroll.setBorder(BorderFactory.createLineBorder(new Color(78,34,160),1));
        }
        
        
        /**
         * Information menu item
         */
        if(e.getSource() == info) {   	
        	/**
        	 * Holds all the information
        	 */
        	String information = 
        	        "\n\n                   Main information\n\n" + 
        	        "\n\n Application version\n  1.0.0" +
        	        "\n\n Application description\n  Text editor for every day use, works with basic" +
        	        "\n  programming files and text files\n\n Date of manifacture\n  ...\n\n License\n  free for use open source project"+
        	        "\n\n Programmer\n  Tsvetelin Marinov\n\n Place\n  Sofia, Bulgaria, EU\n\n"	
        	;
        	
        	
        	/**
        	 * Text box
        	 */
        	infoBox.setBounds(0,0,500,530);
        	infoBox.setFont(new Font("Cascadia Mono",Font.PLAIN,16));
        	infoBox.setForeground((Color)textBox.getForeground());
        	infoBox.setBackground((Color)textBox.getBackground());
        	infoBox.setCaretColor((Color)textBox.getBackground());
        	infoBox.setText(information);
        	infoBox.setEditable(false);
        	
        	
        	//setting up the frame
        	infoFrame.setSize(500,550);
        	infoFrame.setVisible(true);
        	infoFrame.setLayout(null);
        	infoFrame.setResizable(false);
        	infoFrame.setLocationRelativeTo(null);
        	infoFrame.getContentPane().setBackground((Color)getContentPane().getBackground());
        	//set the information window to close without closing the application
        	infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	
        	//add the components to the frame
        	infoFrame.add(infoBox);
        }
        
        
        /**
         * Tips and tricks
         */
        if(e.getSource() == tipsAndTricks) {
        	String tips = "\n\n                                   Tips\n\n\n\n > Create new file"
        		+ "\n  To create new file open the File menu and click 'new file'"
       	        + "\n\n\n > Open a file\n  To open a file open the File menu and click 'open'"+
       	        "\n\n\n > Save a file\n  To save a file open the File menu and click 'save'"+
       	        "\n\n\n > Create new window\n  To create new window open the File menu and click 'new window'"+
       	        "\n\n\n > Restart the application\n  To restart the application open the File menu and click 'restart'"+
       	        "\n\n\n > Close the application\n  To close the application open the File menu and click 'exit'"+
       	        "\n\n\n > Select all the text\n  To select the text in the text box open the Edit menu and click\n"+
       	        "  'select all' or press CTRL + A\n\n\n > Copy text\n  To copy selected text open "
       	        + "the Edit menu and click 'copy'\n  or press CTRL + C"+
       	        "\n\n\n > Paste text\n  To paste some copied text open the Edit menu and click 'copy' or press\n"+
       	         "  CTRL + V\n\n\n > Delete all the text\n  To delete all the text from the text box open the Edit menu\n"+
       	        "  and press 'delete' or press Delete\n\n\n > Set the font\n  To set the font of the application\n"+
       	        "  open the Options menu and click 'settings'. The font options are\n  under"
       	        + " 'Font and color' section\n\n\n > Change the theme\n  To change the theme open the\n"+
       	        "  Options menu and click 'settings'. The theme options are under\n  'Theme' section.\n"+
       	        "  You can set the colors of the application manual\n  "
       	        + "by pressing 'configure manual' button\n\n\n > Contact me\n  Find me at Facebook\n  "+
       	        "https://www.facebook.com/profile.php?id=100010457925248\n\n"
       	    ;
     	
        	
        	/**
        	 * Text box
        	 */
        	tipsBox.setFont(new Font("Cascadia Mono",Font.PLAIN,16));
        	tipsBox.setForeground((Color)textBox.getForeground());
        	tipsBox.setBackground((Color)getContentPane().getBackground());
        	tipsBox.setCaretColor((Color)getContentPane().getBackground());
        	tipsBox.setEditable(false);
        	tipsBox.setText(tips);
        	
        	
        	/**
        	 * Scroll pane
        	 */
        	tipsScroll.setBounds(-1,0,686,461);
        	tipsScroll.setBorder(null);
        	tipsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        	
        	
        	
        	//setting up the frame
        	tipsWindow.setSize(700,500);
        	tipsWindow.setVisible(true);
        	tipsWindow.setLayout(null);
        	tipsWindow.setResizable(false);
        	tipsWindow.setLocationRelativeTo(null);
        	tipsWindow.getContentPane().setBackground((Color)getContentPane().getBackground());
        	//set the tips window to close without closing the application
        	tipsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	
        	//add the components to the frame
        	tipsWindow.add(tipsScroll);
        }
        
        
        /**
         * Theme box
         */
        if(e.getSource() == themeBox) {
        	switch(themeBox.getSelectedIndex()) {
        	case 0:
        		setClassicTheme();
        		break;
        	case 1:
        		setDarkTheme();
        		break;
        	case 2:
        		setGrayTheme();
        		break;
        	}
        }
        
        
    }







    /**
     * --------------------------- MouseListener --------------------------------------
     *
     * @param e -- the event to be proccesed
     */

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
        /**
         * file menu
         */
        if(e.getSource() == fileMenu)
        	fileMenu.setForeground(Color.black);



        /**
         * edit menu
         */
        if(e.getSource() == editMenu)
        	editMenu.setForeground(Color.black);




        /**
         * options menu
         */
        if(e.getSource() == optionsMenu) 
        	optionsMenu.setForeground(Color.black);



        /**
         * about menu
         */
        if(e.getSource() == aboutMenu)
        	aboutMenu.setForeground(Color.black);




        /**
         * new file
         */
        if(e.getSource() == newFile) 
        	newFile.setFont(new Font((String) newFile.getFont().getFamily(), (int) newFile.getFont().getStyle(), 16));



        /**
         * open
         */
        if(e.getSource() == load)
        	load.setFont(new Font((String) load.getFont().getFamily(), (int) load.getFont().getStyle(), 16));



        /**
         * save
         */
        if(e.getSource() == export)
        	export.setFont(new Font((String) export.getFont().getFamily(), (int) export.getFont().getStyle(), 16));



        /**
         * new window
         */
        if(e.getSource() == newWindow)
            newWindow.setFont(new Font((String) newWindow.getFont().getFamily(), (int) newWindow.getFont().getStyle(), 16));



        /**
         * restart
         */
        if(e.getSource() == reboot)
        	reboot.setFont(new Font((String) reboot.getFont().getFamily(), (int) reboot.getFont().getStyle(), 16));



        /**
         * exit
         */
        if(e.getSource() == close)
        	close.setFont(new Font((String) close.getFont().getFamily(), (int) close.getFont().getStyle(), 16));



        /**
         * select all
         */
        if(e.getSource() == selectAll)
        	selectAll.setFont(new Font((String)selectAll.getFont().getFamily(), (int)selectAll.getFont().getStyle(),16));



        /**
         * copy
         */
        if(e.getSource() == cpy) 
        	cpy.setFont(new Font((String)cpy.getFont().getFamily(), (int)cpy.getFont().getStyle(),16));



        /**
         * paste
         */
        if(e.getSource() == paste) 
        	paste.setFont(new Font((String)paste.getFont().getFamily(), (int)paste.getFont().getSize(),16));



        /**
         * delete all
         */
        if(e.getSource() == dltAll)
        	dltAll.setFont(new Font((String)dltAll.getFont().getFamily(), (int)dltAll.getFont().getStyle(), (16)));


        /**
         * settings
         */
        if(e.getSource() == settings) 
        	settings.setFont(new Font((String)settings.getFont().getFamily(), (int)settings.getFont().getStyle(), 16));


        /**
         * Font section label
         */
        if(e.getSource() == fontSection)
        	fontSection.setForeground(Color.DARK_GRAY);


        /**
         * Font family label
         */
        if(e.getSource() == fontFamily)
        	fontFamily.setForeground(Color.DARK_GRAY);


        /**
         * Font box
         */
        if(e.getSource() == fontBox)
        	fontBox.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));


        /**
         * Font size label
         */
        if(e.getSource() == fontSize)
        	fontSize.setForeground(Color.DARK_GRAY);


        /**
         * Font size spinner
         */
        if(e.getSource() == fontSizeSpiner) 
        	fontSizeSpiner.setBorder(BorderFactory.createLineBorder(new Color(78,34,160)));



        /**
         * Font style label
         */
        if(e.getSource() == fontStyle) 
        	fontStyle.setForeground(Color.DARK_GRAY);


        /**
         * Font style box
         */
        if(e.getSource() == fontStyleBox)
        	fontStyleBox.setBorder(new LineBorder(new Color(78,34,160)));


        /**
         * Font color label
         */
        if(e.getSource() == fontColor)
            fontColor.setForeground(Color.DARK_GRAY);


        /**
         * Font color chooser
         */
       // if(e.getSource() == fontColorChooser) 
        	//fontColorChooser.setBackground(new Color(180,200,250));


        /**
         * Reset font button
         */
        //if(e.getSource() == resetFont) 
        	//resetFont.setBackground(new Color(180,200,250));



        /**
         * Theme section
         */
        if(e.getSource() == themeSection)
        	themeSection.setForeground(Color.DARK_GRAY);


        /**
         * theme label
         */
        if(e.getSource() == theme) 
        	theme.setForeground(Color.DARK_GRAY);


        /**
         * Theme box
         */
        if(e.getSource() == themeBox)
        	themeBox.setBorder(new LineBorder(new Color(78,34,160)));


        /**
         * Manual configuration button
         */
       // if(e.getSource() == apperButton) 
        	//apperButton.setBackground(new Color(180,200,250));


        /**
         * Manual foreground button
         */
       // if(e.getSource() == manualFontColorChooser)
           // manualFontColorChooser.setBackground(new Color(180,200,250));


        /**
         * Manual background button
         */
       // if(e.getSource() == manualTextBoxBackgroundButton) 
        //	manualTextBoxBackgroundButton.setBackground(new Color(180,200,250));


        /**
         * Application background button
         */
       // if(e.getSource() == appColorChooser) 
        //	appColorChooser.setBackground(new Color(180,200,250));


        /**
         * Border color button
         */
       // if(e.getSource() == borderColorChooser)
        //	borderColorChooser.setBackground(new Color(180,200,250));


        /**
         * Reset defaults button
         */
       // if(e.getSource() == resetDefaults)
          //  resetDefaults.setBackground(new Color(180,200,250));
        
        
        
        /**
         * Information menu item
         */
        if(e.getSource() == info)
        	info.setFont(new Font((String)info.getFont().getFamily(),(int)info.getFont().getStyle(),16));
        
        
        
        /**
         * Tips and trics menu item
         */
        if(e.getSource() == tipsAndTricks)
        	tipsAndTricks.setFont(new Font((String)tipsAndTricks.getFont().getFamily(),(int)tipsAndTricks.getFont().getStyle(),16));
        
    }





    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        /**
         * file menu
         */
        if(e.getSource() == fileMenu)
        	fileMenu.setForeground(Color.DARK_GRAY);



        /**
         * edit menu
         */
        if(e.getSource() == editMenu)
        	editMenu.setForeground(Color.DARK_GRAY);



        /**
         * options menu
         */
        if(e.getSource() == optionsMenu) 
        	optionsMenu.setForeground(Color.DARK_GRAY);



        /**
         * about menu
         */
        if(e.getSource() == aboutMenu)
        	aboutMenu.setForeground(Color.DARK_GRAY);



        /**
         * new file
         */
        if(e.getSource() == newFile) 
        	newFile.setFont(new Font((String) newFile.getFont().getFamily(), (int) newFile.getFont().getStyle(), 14));



        /**
         * open
         */
        if(e.getSource() == load) 
        	load.setFont(new Font((String) load.getFont().getFamily(), (int) load.getFont().getStyle(), 14));



        /**
         * save
         */
        if(e.getSource() == export)
        	export.setFont(new Font((String) export.getFont().getFamily(), (int) export.getFont().getStyle(), 14));



        /**
         * new window
         */
        if(e.getSource() == newWindow)
        	newWindow.setFont(new Font((String) newWindow.getFont().getFamily(), (int) newWindow.getFont().getStyle(), 14));



        /**
         * restart
         */
        if(e.getSource() == reboot)
        	reboot.setFont(new Font((String) reboot.getFont().getFamily(), (int) reboot.getFont().getStyle(), 14));



        /**
         * exit
         */
        if(e.getSource() == close)
        	close.setFont(new Font((String) close.getFont().getFamily(), (int) close.getFont().getStyle(), 14));



        /**
         * select all
         */
        if(e.getSource() == selectAll)
        	selectAll.setFont(new Font((String)selectAll.getFont().getFamily(), (int)selectAll.getFont().getStyle(),14));



        /**
         * copy
         */
        if(e.getSource() == cpy) 
        	cpy.setFont(new Font((String)cpy.getFont().getFamily(), (int)cpy.getFont().getStyle(),14));



        /**
         * paste
         */
        if(e.getSource() == paste)
        	paste.setFont(new Font((String)paste.getFont().getFamily(), (int)paste.getFont().getStyle(),14));


        /**
         * delete all
         */
        if(e.getSource() == dltAll)
        	dltAll.setFont(new Font((String)dltAll.getFont().getFamily(), (int)dltAll.getFont().getStyle(), 14));


        /**
         * settings
         */
        if(e.getSource() == settings) 
        	settings.setFont(new Font((String)settings.getFont().getFamily(), (int)settings.getFont().getStyle(), 14));


        /**
         * Secret button
         */
        
        @SuppressWarnings("unused")
		JButton secret_btn = new JButton();



        /**
         * Font section label
         */
        if(e.getSource() == fontSection)
        	fontSection.setForeground(Color.black);


        /**
         * Font family label
         */
        if(e.getSource() == fontFamily)
        	
        	fontFamily.setForeground(Color.black);


        /**
         * Font box
         */
        if(e.getSource() == fontBox)
        	fontBox.setBorder(null);


        /**
         * Font size label
         */
        if(e.getSource() == fontSize)
        	fontSize.setForeground((Color)fontFamily.getForeground());


        /**
         * Font size spinner
         */
        if(e.getSource() == fontSizeSpiner)
        	fontSizeSpiner.setBorder(BorderFactory.createLineBorder(Color.black));


        /**
         * Font style label
         */
        if(e.getSource() == fontStyle)
        	fontStyle.setForeground((Color)fontFamily.getForeground());


        /**
         * Font style box
         */
        if(e.getSource() == fontStyleBox)
        	fontStyleBox.setBorder(null);


        /**
         * Font color label
         */
        if(e.getSource() == fontColor) 
        	fontColor.setForeground((Color)fontFamily.getForeground());


        /**
         * Font color chooser
         */
        //if(e.getSource() == fontColorChooser) 
        	//fontColorChooser.setBackground((Color)secret_btn.getBackground());


        /**
         * Reset font button
         */
       // if(e.getSource() == resetFont)
        //	resetFont.setBackground((Color)secret_btn.getBackground());


        /**
         * Theme section label
         */
        if(e.getSource() == themeSection) 
        	themeSection.setForeground((Color)fontSection.getForeground());


        /**
         * theme
         */
        if(e.getSource() == theme)
        	theme.setForeground((Color)fontFamily.getForeground());


        /**
         * Theme box
         */
        if(e.getSource() == themeBox) 
        	themeBox.setBorder(null);


        /**
         * Manual configuration button
         */
        //if(e.getSource() == apperButton) 
        	//apperButton.setBackground((Color)secret_btn.getBackground());


        /**
         * Manual foreground button
         */
       // if(e.getSource() == manualFontColorChooser)
        	//manualFontColorChooser.setBackground((Color)secret_btn.getBackground());


        /**
         * Manual text box color button
         */
        //if(e.getSource() == manualTextBoxBackgroundButton) 
        //	manualTextBoxBackgroundButton.setBackground((Color)secret_btn.getBackground());


        /**
         * Application background button
         */
       // if(e.getSource() == appColorChooser)
        //	appColorChooser.setBackground((Color)secret_btn.getBackground());


        /**
         * Border color button
         */
      //  if(e.getSource() == borderColorChooser) 
        //	borderColorChooser.setBackground((Color)secret_btn.getBackground());


        /**
         * 
         */
       // if(e.getSource() == resetDefaults) 
        //	resetDefaults.setBackground((Color)secret_btn.getBackground());
        
        
        /**
         * Information menu item
         */
        if(e.getSource() == info) info.
        setFont(new Font((String)info.getFont().getFamily(),(int)info.getFont().getStyle(),14));
        
        
        
        /**
         * tips and tricks menu item
         */
        if(e.getSource() == tipsAndTricks) 
        	tipsAndTricks.setFont(new Font((String)tipsAndTricks.getFont().getFamily(),(int)tipsAndTricks.getFont().getStyle(),14));
        
    }







    /**
     * Getter for the copied text
     */
    public String getCopiedText() { return cpytxt; }
    
    
    
    
    
    
    /**
     *  ---------------------------- Themes ----------  ----------------------
     */

    
    
    
    /**
     * Dark theme
     */
    public void setDarkTheme() {
    	/**
    	 * Update background
    	 */
    	getContentPane().setBackground(new Color(29,29,29));
    	
    	
    	/**
    	 * Update text box
    	 */
    	textBox.setBackground(new Color(27,27,27));
    	textBox.setForeground(new Color(220,220,220));
    	textBox.setCaretColor(Color.YELLOW);
    	
    	
    	/**
    	 * Update menu bar
    	 */
    	menuBar.setBackground(new Color(30,30,30));
    	
    	
    	/**
    	 * Update menus
    	 */
    	fileMenu.setBackground(new Color(30,30,30));
    	fileMenu.setForeground(new Color(220,220,220));
    	fileMenu.addMouseListener(new AlfaListener());
    	
    	editMenu.setBackground(new Color(30,30,30));
    	editMenu.setForeground(new Color(220,220,220));
    	editMenu.addMouseListener(new AlfaListener());
    	
    	optionsMenu.setBackground(new Color(30,30,30));
    	optionsMenu.setForeground(new Color(220,220,220));
    	optionsMenu.addMouseListener(new AlfaListener());
    	
    	aboutMenu.setBackground(new Color(30,30,30));
    	aboutMenu.setForeground(new Color(220,220,220));
    	aboutMenu.addMouseListener(new AlfaListener());
    
    	
    	/**
    	 * Update the menu items
    	 */
    	//The new background
    	Color back = new Color(30,30,30);
    	
    	//The new foreground
    	Color fore = new Color(230,230,230);
    	
    	newFile.setBackground(back);
    	newFile.setForeground(fore);
    	
    	load.setBackground(back);
    	load.setForeground(fore);
    	
    	export.setBackground(back);
    	export.setForeground(fore);
    	
    	newWindow.setBackground(back);
    	newWindow.setForeground(fore);
    	
    	reboot.setBackground(back);
    	reboot.setForeground(fore);
    	
    	close.setBackground(back);
    	close.setForeground(fore);
    	
    	selectAll.setBackground(back);
    	selectAll.setForeground(fore);
    	
    	cpy.setBackground(back);
    	cpy.setForeground(fore);
    	
    	paste.setBackground(back);
    	paste.setForeground(fore);
    	
    	dltAll.setBackground(back);
    	dltAll.setForeground(fore);
    	
    	settings.setBackground(back);
    	settings.setForeground(fore);
    	
    	info.setBackground(back);
    	info.setForeground(fore);
    	
    	tipsAndTricks.setBackground(back);
    	tipsAndTricks.setForeground(fore);
    	
    	
    	/**
    	 * Update visual effect of the settings window
    	 */
    	fontSection.addMouseListener(new AlfaListener());
    	fontFamily.addMouseListener(new AlfaListener());
    	fontSize.addMouseListener(new AlfaListener());
    	fontStyle.addMouseListener(new AlfaListener());
    	fontColor.addMouseListener(new AlfaListener());
    	themeSection.addMouseListener(new AlfaListener());
    	theme.addMouseListener(new AlfaListener());
    	
    	fontColorChooser.setForeground(Color.black);
    	fontColorChooser.setBackground(new Color(80,80,70));
    	fontColorChooser.addMouseListener(new AlfaListener());
    	
    	resetFont.setBackground(new Color(80,80,70));
    	resetFont.setForeground(Color.black);
    	resetFont.addMouseListener(new AlfaListener());
    	
    	apperButton.setBackground(new Color(80,80,70));
    	apperButton.setForeground(Color.black);
    	apperButton.addMouseListener(new AlfaListener());
    	
    	manualFontColorChooser.addMouseListener(new AlfaListener());
    	
    	manualTextBoxBackgroundButton.addMouseListener(new AlfaListener());
    	
    	appColorChooser.addMouseListener(new AlfaListener());
    	
    	borderColorChooser.addMouseListener(new AlfaListener());
    	
    	resetDefaults.addMouseListener(new AlfaListener());
    	
    }
    
    
    
    
    
    /**
     * Classic theme
     */
    public void setClassicTheme() {
    	/**
    	 * Update content pane
    	 */
    	getContentPane().setBackground(new Color(247,247,247));
    	
    	
    	/**
    	 * Update text box
    	 */
    	textBox.setBackground(new Color(251,251,251));
    	textBox.setCaretColor(new Color(78,36,160));
    	textBox.setForeground(Color.black);
    	
    	
    	/**
    	 * Update the menu bar
    	 */
    	menuBar.setBackground(new Color(247,247,247));
    	
    	
    	/**
    	 * Update menus
    	 */
    	fileMenu.setForeground(Color.black);
    	fileMenu.addMouseListener(new BetaListener());
    	
    	editMenu.setForeground(Color.black);
    	editMenu.addMouseListener(new BetaListener());
    	
    	optionsMenu.setForeground(Color.black);
    	optionsMenu.addMouseListener(new BetaListener());
    	
    	aboutMenu.setForeground(Color.black);
    	aboutMenu.addMouseListener(new BetaListener());
    	
    	
    	/**
    	 * Update menu items
    	 */
    	//The new menu item background
    	Color back = new Color(180,200,250);
    	Color fore = Color.black;
    	
    	newFile.setBackground(back);
    	newFile.setForeground(fore);
    	
    	load.setBackground(back);
    	load.setForeground(fore);
    	
    	export.setBackground(back);
    	export.setForeground(fore);
    	
    	newWindow.setBackground(back);
    	newWindow.setForeground(fore);
    	
    	reboot.setBackground(back);
    	reboot.setForeground(fore);
    	
    	close.setBackground(back);
    	close.setForeground(fore);
    	
    	selectAll.setBackground(back);
    	selectAll.setForeground(fore);
    	
    	cpy.setBackground(back);
    	cpy.setForeground(fore);
    	
    	paste.setBackground(back);
    	paste.setForeground(fore);
    	
    	dltAll.setBackground(back);
    	dltAll.setForeground(fore);
    	
    	settings.setBackground(back);
    	settings.setForeground(fore);
    	
    	info.setBackground(back);
    	info.setForeground(fore);
    	
    	tipsAndTricks.setBackground(back);
    	tipsAndTricks.setForeground(fore);
    	
    	
    	/**
    	 * Update visual effects of the settings window buttons
    	 */
    	 //Secret button with no functionality
    	JButton secretButton = new JButton();
    	
    	
    	//The new background(the original background)
    	Color backg = (Color)secretButton.getBackground();
    	
    	fontColorChooser.setBackground(backg);
    	fontColorChooser.addMouseListener(new BetaListener());
    	
    	resetFont.setBackground(backg);
    	resetFont.addMouseListener(new BetaListener());
    	
    	apperButton.setBackground(backg);
    	apperButton.addMouseListener(new BetaListener());
    	
    	manualFontColorChooser.setBackground(backg);
    	manualFontColorChooser.addMouseListener(new BetaListener());
    	
    	manualTextBoxBackgroundButton.setBackground(backg);
    	manualTextBoxBackgroundButton.addMouseListener(new BetaListener());
    	
    	appColorChooser.setBackground(backg);
    	appColorChooser.addMouseListener(new BetaListener());
    	
    	borderColorChooser.setBackground(backg);
    	borderColorChooser.addMouseListener(new BetaListener());
    	
    	resetDefaults.setBackground(backg);
    	resetDefaults.addMouseListener(new BetaListener());
    	
    	
    }
    
    
    
    
    /**
     * Gray theme
     */
    public void setGrayTheme() {
    	/**
    	 * Update application background
    	 */
    	getContentPane().setBackground(new Color(200,200,200));
    	
    	
    	/**
    	 * Update text box
    	 */
    	textBox.setBackground(new Color(180,180,180));
    	textBox.setForeground(Color.black);
    	textBox.setCaretColor(Color.YELLOW);
    	
    	
    	/**
    	 * Update the menu bar and menus
    	 */
    	menuBar.setBackground(new Color(200,200,200));
    	
    	Color clr = Color.black;
    	
    	fileMenu.setForeground(clr);
    	fileMenu.addMouseListener(new GamaListener());
    	
    	editMenu.setForeground(clr);
    	editMenu.addMouseListener(new GamaListener());
    	
    	optionsMenu.setForeground(clr);
    	optionsMenu.addMouseListener(new GamaListener());
    	
    	aboutMenu.setForeground(clr);
    	aboutMenu.addMouseListener(new GamaListener());
    	
    	Color menuclr = new Color(180,180,180);
    	Color menufore = new Color(2,2,2);
    	
    	newFile.setBackground(menuclr);
    	newFile.setForeground(menufore);
    	
    	load.setBackground(menuclr);
    	load.setForeground(menufore);
    	
    	export.setBackground(menuclr);
    	export.setForeground(menufore);
    	
    	newWindow.setBackground(menuclr);
    	newWindow.setForeground(menufore);
    	
    	reboot.setBackground(menuclr);
    	reboot.setForeground(menufore);
    	
    	close.setBackground(menuclr);
    	close.setForeground(menufore);
    	
    	selectAll.setBackground(menuclr);
    	selectAll.setForeground(menufore);
    	
    	cpy.setBackground(menuclr);
    	cpy.setForeground(menufore);
    	
    	paste.setBackground(menuclr);
    	paste.setForeground(menufore);
    	
    	dltAll.setBackground(menuclr);
    	dltAll.setForeground(menufore);
    	
    	settings.setBackground(menuclr);
    	settings.setForeground(menufore);
    	
    	info.setBackground(menuclr);
    	info.setForeground(menufore);
    	
    	tipsAndTricks.setBackground(menuclr);
    	tipsAndTricks.setForeground(menufore);
    	
    	
    	//Secret button
    	JButton secretButton = new JButton();
    	
    	//Original background
    	Color org_back = secretButton.getBackground();
    	
    	/*
    	 * Update buttons 
    	 */
    	fontColorChooser.setBackground(org_back);
    	fontColorChooser.addMouseListener(new GamaListener());
    	
    	resetFont.setBackground(org_back);
    	resetFont.addMouseListener(new GamaListener());
    	
    	apperButton.setBackground(org_back);
    	apperButton.addMouseListener(new GamaListener());
    	
    	manualFontColorChooser.setBackground(org_back);
    	manualFontColorChooser.addMouseListener(new GamaListener());
    	
    	manualTextBoxBackgroundButton.setBackground(org_back);
    	manualTextBoxBackgroundButton.addMouseListener(new GamaListener());
    	
    	appColorChooser.setBackground(org_back);
    	appColorChooser.addMouseListener(new GamaListener());
    	
    	borderColorChooser.setBackground(org_back);
    	borderColorChooser.addMouseListener(new GamaListener());
    	
    	resetDefaults.setBackground(org_back);
    	resetDefaults.addMouseListener(new GamaListener());
    	
    }
    
    
    
    
    
    
    /**
     * MouseListener for the dark theme
     */
    protected class AlfaListener implements MouseListener{

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
    		/**
    		 * File menu
    		 */
    		if(e.getSource() == fileMenu)
    			fileMenu.setForeground(Color.white);
    		
    		
    		
    		/**
    		 * Edit menu
    		 */
    		if(e.getSource() == editMenu)
    			editMenu.setForeground(Color.white); 
    		
    		
    		
    		/**
    		 * Options menu
    		 */
    		if(e.getSource() == optionsMenu) 
    			optionsMenu.setForeground(Color.white);
    		
    		
    		/**
    		 * About menu
    		 */
    		if(e.getSource() == aboutMenu)
    			aboutMenu.setForeground(Color.white);
    		
    		
    		/**
    		 * Font section
    		 */
    		if(e.getSource() == fontSection) 
    			fontSection.setForeground(new Color(200,200,200));
    		
    		
    		/**
    		 * Font labels
    		 */
    		if(e.getSource() == fontFamily)
    			fontFamily.setForeground(new Color(200,200,200));
    		
    	    if(e.getSource() == fontSize)
    	    	fontSize.setForeground(new Color(200,200,200));
    	    
    	    if(e.getSource() == fontStyle)
    	    	fontStyle.setForeground(new Color(220,220,200));
    	    
    	    if(e.getSource() == fontColor) 
    	    	fontColor.setForeground(new Color(200,200,200));
    		
    	    
    	    /**
    	     * Theme section and theme label
    	     */
    	    if(e.getSource() == themeSection) 
    	    	themeSection.setForeground(new Color(200,200,200));
    	    
    	    if(e.getSource() == theme)
    	    	theme.setForeground(new Color(200,200,200));
    	    
    	    
    	    /**
    	     * Buttons
    	     */
    	    if(e.getSource() == fontColorChooser) 
    	    fontColorChooser.setBackground(new Color(80,160,170));
    	    
    	    if(e.getSource() == resetFont) 
    	    	resetFont.setBackground(new Color(80,160,170));
    	     
    	    
    	   if(e.getSource() == apperButton)
    		   apperButton.setBackground(new Color(80,160,170));
    	   
    	   if(e.getSource() == manualFontColorChooser)
    		   manualFontColorChooser.setBackground(new Color(80,160,170));
    	   
    	   if(e.getSource() == manualTextBoxBackgroundButton)
    		   manualTextBoxBackgroundButton.setBackground(new Color(80,160,170));
    	   
    	   if(e.getSource() == appColorChooser)
    		   appColorChooser.setBackground(new Color(80,160,170));
    	   
    	   if(e.getSource() == borderColorChooser)
    		   borderColorChooser.setBackground(new Color(80,160,170));
    	   
    	   if(e.getSource() == resetDefaults)
    		   resetDefaults.setBackground(new Color(80,160,170));
    	
    	}

    	@Override
    	public void mouseExited(MouseEvent e) {
    		// TODO Auto-generated method stub
    		/**
    		 * File menu
    		 */
    		if(e.getSource() == fileMenu) 
    			fileMenu.setForeground(new Color(220,220,220));
    	
    		
    		/**
    		 * Edit menu
    		 */
    		if(e.getSource() == editMenu) 
    			editMenu.setForeground(new Color(220,220,220));	
    		
    		
    		/**
    		 * Options menu
    		 */
    		if(e.getSource() == optionsMenu) 
    			optionsMenu.setForeground(new Color(220,220,200));
    		
    		
    		/**
    		 * About menu
    		 */
    		if(e.getSource() == aboutMenu) 
    			aboutMenu.setForeground(new Color(220,220,220));
    		
    		
    		/**
    		 * Font section
    		 */
    		if(e.getSource() == fontSection) 
    			fontSection.setForeground((Color)textBox.getForeground());
    		
    		
    		/**
    		 * Font labels
    		 */
    		if(e.getSource() == fontFamily) 
    			fontFamily.setForeground((Color)textBox.getForeground());
    		
    		if(e.getSource() == fontSize) 
    			fontSize.setForeground((Color)textBox.getForeground());
    		
    		if(e.getSource() == fontStyle) 
    			fontStyle.setForeground((Color)textBox.getForeground());
    		
    		if(e.getSource() == fontColor) 
    			fontColor.setForeground((Color)textBox.getForeground());
    		
    		
    		/**
    		 * Theme section and theme label
    		 */
    		if(e.getSource() == themeSection) 
    			themeSection.setForeground((Color)textBox.getForeground());
    		
    		if(e.getSource() == theme)
    			theme.setForeground((Color)textBox.getForeground());
    		
            
    		/**
    		 * Buttons
    		 */
    		if(e.getSource() == fontColorChooser) 
    			fontColorChooser.setBackground(new Color(80,80,70));
    		
    		if(e.getSource() == resetFont)
    			resetFont.setBackground(new Color(80,80,70));
    		
    		
    		if(e.getSource() == apperButton)
    			apperButton.setBackground(new Color(80,80,70));
    					
    		if(e.getSource() == manualFontColorChooser)
    			manualFontColorChooser.setBackground(new Color(80,80,70));
    		
    		if(e.getSource() == manualTextBoxBackgroundButton)
    			manualTextBoxBackgroundButton.setBackground(new Color(80,80,70));
    		
    		if(e.getSource() == appColorChooser)
    			appColorChooser.setBackground(new Color(80,80,70));
    		
    		if(e.getSource() == borderColorChooser)
    			borderColorChooser.setBackground(new Color(80,80,70));
    		
    		if(e.getSource() == resetDefaults)
    			resetDefaults.setBackground(new Color(80,80,70));
    		
    	}
    	
    }
   
    
    
    
    
    /**
     * Mouse Listener for the classic theme
     */
    protected class BetaListener implements MouseListener{

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
			/**
			 * File menu
			 */
			if(e.getSource() == fileMenu)
				fileMenu.setForeground(Color.DARK_GRAY);
			
			
			/**
			 * Edit menu
			 */
			if(e.getSource() == editMenu)
				editMenu.setForeground(Color.DARK_GRAY);
			
			
			/**
			 * Options menu
			 */
			if(e.getSource() == optionsMenu)
				optionsMenu.setForeground(Color.DARK_GRAY);
			
			
			/**
			 * About menu
			 */
			if(e.getSource() == aboutMenu)
				aboutMenu.setForeground(Color.DARK_GRAY);
			
			
			/**
			 * Buttons
			 */
			if(e.getSource() == fontColorChooser)
				fontColorChooser.setBackground(new Color(180,200,250));
			
			Color backgr = new Color(180,200,250);
			
			if(e.getSource() == resetFont)
				resetFont.setBackground(backgr);
			
			if(e.getSource() == apperButton)
				apperButton.setBackground(backgr);
			
			if(e.getSource() == manualFontColorChooser)
				manualFontColorChooser.setBackground(backgr);
			
			if(e.getSource() == manualTextBoxBackgroundButton)
				manualTextBoxBackgroundButton.setBackground(backgr);
			
			if(e.getSource() == appColorChooser)
				appColorChooser.setBackground(backgr);
			
			if(e.getSource() == borderColorChooser)
				borderColorChooser.setBackground(backgr);
			
			if(e.getSource() == resetDefaults)
				resetDefaults.setBackground(backgr);
		
		}
		
		

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Color blk = Color.black;
			
			/**
			 * File menu
			 */		
			if(e.getSource() == fileMenu)
				fileMenu.setForeground(Color.black);
			
			
			/**
			 * Edit menu
			 */
			if(e.getSource() == editMenu)
				editMenu.setForeground(Color.black);
			
			
			/**
			 * Options menu
			 */
			if(e.getSource() == optionsMenu)
				optionsMenu.setForeground(blk);
			
			
			/**
			 * About menu
			 */
			if(e.getSource() == aboutMenu)
				aboutMenu.setForeground(blk);
		 
			
			/**
			 * Buttons
			 */	
			//Secret button with no functioanlity
			JButton secret = new JButton();
			
			Color backgr = secret.getBackground(); 
					
			if(e.getSource() == fontColorChooser)
				fontColorChooser.setBackground(backgr);
			
			if(e.getSource() == resetFont)
				resetFont.setBackground(backgr);
			
			if(e.getSource() == apperButton)
				apperButton.setBackground(backgr);
			
			if(e.getSource() == manualFontColorChooser)
				manualFontColorChooser.setBackground(backgr);
			
			if(e.getSource() == manualTextBoxBackgroundButton)
				manualTextBoxBackgroundButton.setBackground(backgr);
			
			if(e.getSource() == appColorChooser)
				appColorChooser.setBackground(backgr);
			
			if(e.getSource() == borderColorChooser)
				borderColorChooser.setBackground(backgr);
			
			if(e.getSource() == resetDefaults)
				resetDefaults.setBackground(backgr);
		
			
		}
    	
    }
    
    
    
    
    /**
     * MouseListener for the gray theme
     */
    protected class GamaListener implements MouseListener{

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
			Color clr = Color.DARK_GRAY;
			
			/**
			 * Menus
			 */
			if(e.getSource() == fileMenu)
				fileMenu.setForeground(clr);
			
			if(e.getSource() == editMenu)
				editMenu.setForeground(clr);
			
			if(e.getSource() == optionsMenu)
				optionsMenu.setForeground(clr);
			
			if(e.getSource() == aboutMenu)
				aboutMenu.setForeground(clr);
			
			
			Color hover = new Color(180,210,240);
			
			/**
			 * Buttons
			 */
		    if(e.getSource() == fontColorChooser)
		    	fontColorChooser.setBackground(hover);
		    
		    if(e.getSource() == resetFont)
		    	resetFont.setBackground(hover);
		    
		    if(e.getSource() == apperButton)
		    	apperButton.setBackground(hover);
		    
		    if(e.getSource() == manualFontColorChooser)
		    	manualFontColorChooser.setBackground(hover);
		    
		    if(e.getSource() == manualTextBoxBackgroundButton)
		    	manualTextBoxBackgroundButton.setBackground(hover);
		    
		    if(e.getSource() == appColorChooser)
		    	appColorChooser.setBackground(hover);
		    
		    if(e.getSource() == borderColorChooser)
		    	borderColorChooser.setBackground(hover);
		    
		    if(e.getSource() == resetDefaults)
		    	resetDefaults.setBackground(hover);
			
			
		}
		
		

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
           Color clr = Color.black;
			
			/**
			 * Menus
			 */
			if(e.getSource() == fileMenu)
				fileMenu.setForeground(clr);
			
			if(e.getSource() == editMenu)
				editMenu.setForeground(clr);
			
			if(e.getSource() == optionsMenu)
				optionsMenu.setForeground(clr);
			
			if(e.getSource() == aboutMenu)
				aboutMenu.setForeground(clr);
			
			
			
			//Secret button
			JButton secret_button = new JButton();
			
            Color hover = (Color)secret_button.getBackground();
			
			/**
			 * Buttons
			 */
		    if(e.getSource() == fontColorChooser)
		    	fontColorChooser.setBackground(hover);
		    
		    if(e.getSource() == resetFont)
		    	resetFont.setBackground(hover);
		    
		    if(e.getSource() == apperButton)
		    	apperButton.setBackground(hover);
		    
		    if(e.getSource() == manualFontColorChooser)
		    	manualFontColorChooser.setBackground(hover);
		    
		    if(e.getSource() == manualTextBoxBackgroundButton)
		    	manualTextBoxBackgroundButton.setBackground(hover);
		    
		    if(e.getSource() == appColorChooser)
		    	appColorChooser.setBackground(hover);
		    
		    if(e.getSource() == borderColorChooser)
		    	borderColorChooser.setBackground(hover);
		    
		    if(e.getSource() == resetDefaults)
		    	resetDefaults.setBackground(hover);
			
		}
    	
    }

}
