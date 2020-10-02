package com.lybxxx.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author lybxxx
 */
public class NurseManagerInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil connectUtil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();

	public NurseManagerInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new Room());
	}

	private void fillTable(Room room) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = connectUtil.getCon();
			ResultSet rs = roomdao.roomList(con, room);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("roomnumber"));
				v.add(rs.getString("nurse"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connectUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		roomNum = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		idTxt = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		roomnumber = new javax.swing.JTextField();
		jb_modify = new javax.swing.JButton();
		jb_exit = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		roomnurse = new javax.swing.JTextField();

		setClosable(true);
		setIconifiable(true);
		setTitle("护工信息管理");

		jLabel1.setText("房间号：");

		jb_search.setIcon(new javax.swing.ImageIcon(
				"D:\\Myelipse\\images4\\search.png"));
		jb_search.setText("查询");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_searchActionPerformed(evt);
			}
		});

		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "编号", "房间号", "护工" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				tableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(table);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("表单操作"));

		jLabel2.setText("编号：");

		idTxt.setEditable(false);

		jLabel3.setText("房间号：");

		jb_modify.setIcon(new javax.swing.ImageIcon(
				"D:\\Myelipse\\images4\\modify.png"));
		jb_modify.setText("\u4fee\u6539");
		jb_modify.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_modifyActionPerformed(evt);
			}
		});

		jb_exit.setIcon(new javax.swing.ImageIcon(
				"D:\\Myelipse\\images4\\exit.png"));
		jb_exit.setText("\u9000\u51fa");
		jb_exit.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_exitActionPerformed(evt);
			}
		});

		jLabel4.setText("\u62A4\u5DE5\uFF1A");

		GroupLayout jPanel1Layout = new GroupLayout(
				jPanel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(39)
					.addComponent(jb_modify, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addComponent(jb_exit, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(64))
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(21)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jLabel4)
						.addComponent(jLabel2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(roomnurse)
						.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(jLabel3)
					.addGap(10)
					.addComponent(roomnumber, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
					.addGap(62))
		);
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addGap(19)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3)
						.addComponent(roomnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(roomnurse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_modify)
						.addComponent(jb_exit))
					.addContainerGap())
		);
		jPanel1.setLayout(jPanel1Layout);

		GroupLayout layout = new GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(41)
					.addComponent(jLabel1)
					.addGap(18)
					.addComponent(roomNum, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jb_search, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(jPanel1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(jb_search)
						.addComponent(roomNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String member = roomNum.getText();
		Room room = new Room(member);
		this.fillTable(room);
	}

	private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		String roomNumber = roomnumber.getText();
		String roomNurse = roomnurse.getText();
		String id = idTxt.getText();
		Connection con = null;
		try {
			con = connectUtil.getCon();
			Room room = new Room(id, roomNumber, roomNurse);
			int a = roomdao.roomModify(con, room);
			if (a == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				this.fillTable(new Room());
				return;
			} else {
				JOptionPane.showMessageDialog(null, "修改失败!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "修改失败!");
			e.printStackTrace();
		}
	}

	public void resetValue() {
		roomnumber.setText("");
		roomnurse.setText("");
		idTxt.setText("");
	}

	private void jb_exitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
		if (result == 0) {
			this.dispose();
		}
	}

	private void tableMousePressed(java.awt.event.MouseEvent evt) {
		int row = table.getSelectedRow();
		idTxt.setText(table.getValueAt(row, 0) + "");
		roomnumber.setText(table.getValueAt(row, 1) + "");
		roomnurse.setText(table.getValueAt(row, 2) + "");
	}


	private javax.swing.JTextField idTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_exit;
	private javax.swing.JButton jb_modify;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextField roomNum;
	private javax.swing.JTextField roomnurse;
	private javax.swing.JTextField roomnumber;
	private javax.swing.JTable table;


}