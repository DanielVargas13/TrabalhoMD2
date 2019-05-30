package interG;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import diofantina.Euclides;
import diofantina.Parcial;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Quadro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;
	private Parcial p;
	private Euclides euclides;
	private JButton btnLimpar;
	private LinkedHashMap<Integer, Integer> solucoes;

	public Quadro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(67, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(186, 11, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(306, 11, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblA = new JLabel("a:");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(34, 14, 34, 14);
		contentPane.add(lblA);

		JLabel lblB = new JLabel("b:");
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setBounds(155, 14, 34, 14);
		contentPane.add(lblB);

		JLabel lblC = new JLabel("c:");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setBounds(271, 14, 34, 14);
		contentPane.add(lblC);

		JButton btnResolver = new JButton("Resolver");
		btnResolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				euclides = new Euclides();
				solucoes = new LinkedHashMap<Integer, Integer>();
				int a = 0, b = 0, c = 0;

				try {
					a = Integer.parseInt(textField.getText());
				} catch (NumberFormatException ex) {
					textArea.append("O campo a não possui um valor válido");
					return;
				}

				try {
					b = Integer.parseInt(textField_1.getText());
				} catch (NumberFormatException ex) {
					textArea.append("O campo b não possui um valor válido");
					return;
				}

				try {
					c = Integer.parseInt(textField_2.getText());
				} catch (NumberFormatException ex) {
					textArea.append("O campo c não possui um valor válido");
					return;
				}

				textArea.setText("\nEquação: " + a + "x" + " + " + b + "y" + " = " + c);
				p = euclides.reversao(a, b, c);
				if (p == null) {
					textArea.append("\n\nEssa equação diofantina não possui solução");
				} else {
					textArea.append("\n\nSoluções:\n");
					solucoes = euclides.calcularSolucoes(p);
					for (int x : solucoes.keySet()) {
						int y = solucoes.get(x);
						textArea.append("\nx = " + x + " , " + "y = " + y);
					}
				}
			}
		});
		btnResolver.setBounds(106, 51, 89, 23);
		contentPane.add(btnResolver);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 414, 154);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
			}
		});
		btnLimpar.setBounds(216, 51, 89, 23);
		contentPane.add(btnLimpar);
	}
}
