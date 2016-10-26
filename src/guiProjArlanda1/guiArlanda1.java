package guiProjArlanda1;

import java.sql.*;
import java.util.Queue;
import java.util.Stack;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.Color;

public class guiArlanda1 {
	

	private JFrame frame;
	private JTable table;
	sqlString rsGet = new sqlString();
	private static JTextField textField_Flight;
	private static JTextField textField_Destination;
	private JTextField textField_AirLine;
	private JTextField textField_AirCraft;
	private JTextField textField_QueueSize;
	private static JTextField textField_peek;
	private JTextField textField_FlightAdded;
	private JTextField textField_Off;
	private JTextField textField_AddStack;
	private JTextField textField_StackSize;
	private JTextField textField_LastF;
	private JTextField textField_RomveLF;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiArlanda1 window = new guiArlanda1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiArlanda1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		QueueFlight queue = new QueueFlight();
		stackFlight stack = new stackFlight(5);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 789, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 66, 460, 306);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("View Departure Table");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				rsGet.sqlSetView();
				table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
				}
				catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(449, 33, 155, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Departure");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsGet.sqlSetInsert(textField_Flight.getText(), textField_Destination.getText(), textField_AirLine.getText(), textField_AirCraft.getText());
					rsGet.sqlSetView();
					table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(10, 196, 138, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit Departure");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsGet.sqlSetEdit(textField_Flight.getText(), textField_Destination.getText(), textField_AirLine.getText(), textField_AirCraft.getText());
					rsGet.sqlSetView();
					table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(10, 227, 138, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Remove Departure");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsGet.sqlSetRemove(textField_Flight.getText());
					rsGet.sqlSetView();
					table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(10, 257, 138, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Search by Destination");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsGet.sqlSetSearchDis(textField_Destination.getText());
					table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(10, 287, 138, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Search by Air Line");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsGet.sqlSetSearchAirLine(textField_AirLine.getText());
					table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(10, 318, 138, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Search by Flight");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rsGet.sqlSetSearchFlight(textField_Flight.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(DbUtils.resultSetToTableModel(rsGet.sqlGet()));
			}
		});
		btnNewButton_7.setBounds(10, 349, 138, 23);
		frame.getContentPane().add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("Flight");
		lblNewLabel.setBounds(10, 67, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Distination");
		lblNewLabel_1.setBounds(10, 90, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Air Line");
		lblNewLabel_2.setBounds(10, 115, 69, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Air Craft");
		lblNewLabel_3.setBounds(10, 140, 69, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_8 = new JButton("Add Flight in Queue");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queue.enqueue(textField_Flight.getText());
				textField_FlightAdded.setText(textField_Flight.getText());
				btnNewButton_2.doClick();
			}
		});
		btnNewButton_8.setBounds(10, 422, 138, 23);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Queue Size");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Integer.toString(queue.listSizeFun());
				textField_QueueSize.setText(s + " Flights");
			}
		});
		btnNewButton_9.setBounds(10, 452, 138, 23);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("First Flight");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_peek.setText((String) queue.peek());
			}
		});
		btnNewButton_10.setBounds(10, 481, 138, 23);
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Take Off First Flight");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				queue.dequeue();
				textField_Off.setText(textField_peek.getText());
					rsGet.sqlSetRemoveQ(textField_peek.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_11.setBounds(10, 510, 138, 23);
		frame.getContentPane().add(btnNewButton_11);
		
		
		
		JButton btnNewButton_12 = new JButton("Add Flight to Stack");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stack.push(textField_Flight.getText());
				textField_AddStack.setText(textField_Flight.getText());
			}
		});
		btnNewButton_12.setBounds(288, 422, 132, 23);
		frame.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Stack Size");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String size = Integer.toString(stack.stackSize());
				textField_StackSize.setText(size);
			}
		});
		btnNewButton_13.setBounds(288, 452, 132, 23);
		frame.getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Last Flight");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stack.peek();
				textField_LastF.setText(stack.peek());
			}
		});
		btnNewButton_14.setBounds(288, 481, 132, 23);
		frame.getContentPane().add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Remove Last Flight");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stack.pop();
				textField_RomveLF.setText(stack.peek());
			}
		});
		btnNewButton_15.setBounds(288, 510, 132, 23);
		frame.getContentPane().add(btnNewButton_15);
		
		textField_Flight = new JTextField();
		textField_Flight.setBounds(101, 64, 90, 20);
		frame.getContentPane().add(textField_Flight);
		textField_Flight.setColumns(10);
		
		textField_Destination = new JTextField();
		textField_Destination.setBounds(101, 87, 90, 20);
		frame.getContentPane().add(textField_Destination);
		textField_Destination.setColumns(10);
		
		textField_AirLine = new JTextField();
		textField_AirLine.setBounds(101, 112, 90, 20);
		frame.getContentPane().add(textField_AirLine);
		textField_AirLine.setColumns(10);
		
		textField_AirCraft = new JTextField();
		textField_AirCraft.setBounds(101, 137, 90, 20);
		frame.getContentPane().add(textField_AirCraft);
		textField_AirCraft.setColumns(10);
		
		textField_QueueSize = new JTextField();
		textField_QueueSize.setBounds(158, 453, 107, 20);
		frame.getContentPane().add(textField_QueueSize);
		textField_QueueSize.setColumns(10);
		
		textField_peek = new JTextField();
		textField_peek.setBounds(158, 482, 107, 20);
		frame.getContentPane().add(textField_peek);
		textField_peek.setColumns(10);
		
		textField_FlightAdded = new JTextField();
		textField_FlightAdded.setBounds(158, 423, 107, 20);
		frame.getContentPane().add(textField_FlightAdded);
		textField_FlightAdded.setColumns(10);
		
		textField_Off = new JTextField();
		textField_Off.setBounds(158, 511, 107, 20);
		frame.getContentPane().add(textField_Off);
		textField_Off.setColumns(10);
		
		textField_AddStack = new JTextField();
		textField_AddStack.setBounds(430, 423, 124, 20);
		frame.getContentPane().add(textField_AddStack);
		textField_AddStack.setColumns(10);
		
		textField_StackSize = new JTextField();
		textField_StackSize.setBounds(430, 453, 124, 20);
		frame.getContentPane().add(textField_StackSize);
		textField_StackSize.setColumns(10);
		
		textField_LastF = new JTextField();
		textField_LastF.setBounds(430, 482, 124, 20);
		frame.getContentPane().add(textField_LastF);
		textField_LastF.setColumns(10);
		
		textField_RomveLF = new JTextField();
		textField_RomveLF.setBounds(430, 511, 124, 20);
		frame.getContentPane().add(textField_RomveLF);
		textField_RomveLF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Arlanda SQL - STACK - QUEUE\r");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(45, 11, 196, 23);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblMiladHavva = new JLabel("Milad & Havva\r");
		lblMiladHavva.setForeground(Color.DARK_GRAY);
		lblMiladHavva.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMiladHavva.setBounds(45, 33, 196, 23);
		frame.getContentPane().add(lblMiladHavva);
		
		
		
	}
}
