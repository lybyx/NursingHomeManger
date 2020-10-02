package com.lybxxx.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;
import com.lybxxx.util.CheckUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author  lybxxx
 */
public class NurseDeleteInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil connectUtil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();


	public NurseDeleteInterFrm() {
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
		jb_delete = new javax.swing.JButton();
		jb_exit = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u62A4\u5DE5\u4FE1\u606F\u5220\u9664");

		jLabel1.setText("\u623F\u95F4\u53F7\uFF1A");

		jb_search.setIcon(new javax.swing.ImageIcon(
				"D:\\Myelipse\\images4\\search.png"));
		jb_search.setText("\u67e5\u8be2");
		jb_search.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_searchActionPerformed(evt);
			}
		});

		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "编号", "房间号 ", "护工" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(table);

		jb_delete.setIcon(new javax.swing.ImageIcon(
				"images4\\delete.png"));
		jb_delete.setText("\u5220\u9664");
		jb_delete.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_deleteActionPerformed(evt);
			}
		});

		jb_exit.setIcon(new javax.swing.ImageIcon(
				"images4\\exit.png"));
		jb_exit.setText("\u9000\u51fa");
		jb_exit.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_exitActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(64)
					.addComponent(jLabel1)
					.addGap(18)
					.addComponent(roomNum, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(jb_search, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addGap(76)
					.addComponent(jb_delete, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
					.addComponent(jb_exit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(28)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_search)
						.addComponent(jLabel1)
						.addComponent(roomNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_delete)
						.addComponent(jb_exit))
					.addGap(27))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jb_deleteActionPerformed(java.awt.event.ActionEvent evt) {
		int row = this.table.getSelectedRow();
		String roomnumber = (String) this.table.getValueAt(row, 1);
		if (CheckUtil.isEmpty(roomnumber)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录!");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录么");
		if (n == 0) {
			Connection con = null;
			try {
				con = connectUtil.getCon();
				Room room = new Room(roomnumber);
				int deleteNum = roomdao.roomDelete(con, room);
				System.out.print(deleteNum);
				if (deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.roomNum.setText("");
					this.fillTable(new Room());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "删除失败");
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
	}

	private void jb_exitActionPerformed(java.awt.event.ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "确认要退出？");
		if (a == 0) {
			this.dispose();
		}
	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String roomnumber = roomNum.getText();
		Room room = new Room(roomnumber);
		this.fillTable(room);
	}


	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_delete;
	private javax.swing.JButton jb_exit;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextField roomNum;
	private javax.swing.JTable table;

}