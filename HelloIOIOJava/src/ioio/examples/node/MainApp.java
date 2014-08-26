package ioio.examples.node;

import ioio.lib.util.IOIOLooper;
import ioio.lib.util.pc.IOIOSwingApp;

import java.awt.Container;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

public class MainApp extends IOIOSwingApp  {
	
	JToggleButton btnToggleLed;
	
	// Boilerplate main(). Copy-paste this code into any IOIOapplication.
	public static void main(String[] args) throws Exception {
		new MainApp().go(args);
	}



	@Override
	protected Window createMainWindow(String args[]) {
		// Use native look and feel.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		JFrame frame = new JFrame("Hello IOIO using Java");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(null);
		
		btnToggleLed = new JToggleButton("Toggle led status");
		btnToggleLed.setSize(100, 30);
		btnToggleLed.setLocation(20, 20);
		
		contentPane.add(btnToggleLed);

		// Display the window.
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null); // center it
		frame.setVisible(true);
		
		return frame;
	}

	@Override
	public IOIOLooper createIOIOLooper(String connectionType, Object extra) {
		return new Looper(this);
	}


}
