package util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;
import view.MenuGUI;

public class MyOptionPane extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void showClosingDialog() {
		if (showConfirmDialog(null, "Are you sure you want to quit?", "Closing...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void returnToMenu(JFrame thisGUI, MenuGUI menuGUI) {
		if (showConfirmDialog(thisGUI, "Return to menu?", "Closing...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			thisGUI.dispose();
			menuGUI.setVisible(true);
		}
	}
	
	public static void returnToMenu(JFrame thisGUI, MenuGUI menuGUI, Controller controller) {
		if (showConfirmDialog(thisGUI, "Return to menu?", "Closing...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			thisGUI.dispose();
			controller.forceStop();
			menuGUI.setVisible(true);
		}
	}
	
	public static void changeBallColor(JFrame thisGUI, MenuGUI menuGUI) {
		JOptionPane.showMessageDialog(thisGUI, "Color changed successfully", "Change ball color", JOptionPane.PLAIN_MESSAGE);
		thisGUI.dispose();
		menuGUI.setVisible(true);
	}
	
	public static void resetLeaderboard(JFrame thisGUI, MenuGUI menuGUI) {
		JOptionPane.showMessageDialog(thisGUI, "Leaderboard has been reset successfully", "Leaderboard reset", JOptionPane.PLAIN_MESSAGE);
		thisGUI.dispose();
		menuGUI.setVisible(true);
	}
	
	public static void incorrectPlayerName(JFrame thisGUI) {
		JOptionPane.showMessageDialog(thisGUI, "Your name must be at least one non-white char and must not contain \"=\"",
				"Incorrect Name", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void gameOver(JFrame thisGUI, MenuGUI menuGUI, int totalShots) {
		JOptionPane.showMessageDialog(thisGUI, "You made it with a total of " + totalShots + " shots!", "Well done!", JOptionPane.PLAIN_MESSAGE);
		thisGUI.dispose();
		menuGUI.setVisible(true);
	}
	
	public static void gameOverLava(JFrame thisGUI, MenuGUI menuGUI, int totalShots) {
		JOptionPane.showMessageDialog(thisGUI, "You it a lava poddle, shots increased by 10! Total shots " + totalShots + "!", "Be careful next time!", JOptionPane.PLAIN_MESSAGE);
		thisGUI.dispose();
		menuGUI.setVisible(true);
	}
	
}
