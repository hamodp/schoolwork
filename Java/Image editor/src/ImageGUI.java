import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageGUI implements ActionListener{

	ImageGUI(){
		
	}
	JFrame window = new JFrame("Image editor");
	ImagePanel picture = new ImagePanel();
	JFileChooser selection;
	
	//creates a tool bar for editing the picture
	public JMenuBar createToolBar(){
		
		//creates a tool bar with file and image menus
		JMenuBar toolBar = new JMenuBar();
		
		//creates file section in tool bar for opening pictures
		JMenu file = new JMenu("File");
		toolBar.add(file);
		JMenuItem FileOpen = new JMenuItem("File Open");
		file.add(FileOpen);
		
		//allows a file to be opened
		FileOpen.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent e){
			selectFile();
			}
		});
		
		JMenu imageT = new JMenu("Image");
		return toolBar;
	}
	
	public void selectFile(){
		selection = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG or PNG files", "JPG",
				"JPEG", "PNG");
		int approve = selection.showOpenDialog(window);
		
		if(approve == JFileChooser.APPROVE_OPTION){
			File pic = selection.getSelectedFile();
			Image image = new javax.swing.ImageIcon(pic.getPath()).getImage();
			picture.loadImage(image);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
