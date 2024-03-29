package movement;

/**
 * @deprecated
 * @version 1.1.1
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SwingPaint {

	JButton clearBtn;
	AngleDrawingTool drawAngle;
	LineDrawingTool drawLine;
	private int type;
	Pair first, second, third;

	/* TYPES */
	// 0 = Line Tool
	// 1 = Angle Tool

	SwingPaint(int layerType) {
		this.type = layerType;
		show(false);
	}

	SwingPaint(Pair first, Pair second) {
		this.type = 0;
		this.first = first;
		this.second = second;
		show(true);

	}

	SwingPaint(Pair first, Pair second, Pair third) {
		this.type = 1;
		this.first = first;
		this.second = second;
		this.third = third;
		show(true);
	}

	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clearBtn) {
				if (type == 0)
					drawLine.clear();
				else if (type == 1) {
					drawAngle.clear();
					drawAngle.firstLine = true;
				}
			}
		}
	};

	public void show(boolean load) {

		JFrame frame = new JFrame();
		Container content = frame.getContentPane();

		content.setLayout(new BorderLayout());

		if (type == 0) {
			drawLine = new LineDrawingTool();

			if (load)
				drawLine.loadLine(first, second);

			content.add(drawLine, BorderLayout.CENTER);

		} else if (type == 1) {
			drawAngle = new AngleDrawingTool();

			if (load)
				drawAngle.loadAngle(first, second, third);

			content.add(drawAngle, BorderLayout.CENTER);
		}

		JPanel controls = new JPanel();

		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(actionListener);
		controls.add(clearBtn);

		content.add(controls, BorderLayout.NORTH);

		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

	}

	private void loadLine(Pair first, Pair second) {
		drawLine.loadLine(first, second);
	}

	private void loadAngle(Pair first, Pair second, Pair third) {
		drawAngle.loadAngle(first, second, third);
	}

}
