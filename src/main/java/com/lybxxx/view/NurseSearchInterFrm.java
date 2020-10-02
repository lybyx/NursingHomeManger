package com.lybxxx.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

/**
 *
 * @author  lybxxx
 */
public class NurseSearchInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil connectUtil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();


	public NurseSearchInterFrm() {
		initComponents();
		this.setLocation(200, 50);
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
		roomNumTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u62A4\u5DE5\u67E5\u8BE2");

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

		},new String[] { "编号", "房间号", "护工" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(table);

		GroupLayout layout = new GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(46)
							.addComponent(jLabel1)
							.addGap(28)
							.addComponent(roomNumTxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(jb_search, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(23)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_search)
						.addComponent(roomNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String roomnumber = roomNumTxt.getText();
		Room room = new Room(roomnumber);
		this.fillTable(room);
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextField roomNumTxt;
	private javax.swing.JTable table;


}