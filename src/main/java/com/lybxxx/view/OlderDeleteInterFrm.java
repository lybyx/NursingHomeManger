package com.lybxxx.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.lybxxx.dao.OlderDao;
import com.lybxxx.model.Older;
import com.lybxxx.util.ConnectUtil;

/**
 *
 * @author  lybxxx
 */
public class OlderDeleteInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil connectUtil = new ConnectUtil();
	OlderDao Olderdao = new OlderDao();

	public OlderDeleteInterFrm() {
		initComponents();
		this.setLocation(200, 50);
	}

	private void fillTable(Older older) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = connectUtil.getCon();
			ResultSet rs = Olderdao.OlderSearch(con, older);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("family"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("dormitory"));
				v.add(rs.getString("bed"));
				dtm.addRow(v);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				connectUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		nameTxt = new javax.swing.JTextField();
		jb_search = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u8001\u4EBA\u4FE1\u606F\u5220\u9664");

		jLabel1.setText("\u59d3\u540d\uff1a");

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

		}, new String[] { "编号", "姓名", "性别", "家属", "电话", "房间号", "床号" }) {
			boolean[] canEdit = new boolean[] { false, false, false, true,
					true, true, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(table);

		jButton2.setIcon(new javax.swing.ImageIcon(
				"D:\\Myelipse\\images4\\delete.png"));
		jButton2.setText("\u5220\u9664");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setIcon(new javax.swing.ImageIcon(
				"D:\\Myelipse\\images4\\exit.png"));
		jButton3.setText("\u9000\u51fa");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(104)
					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
					.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jb_search, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(30)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jb_search))
					.addGap(18)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton2)
						.addComponent(jButton3))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}
	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String roomnumber = nameTxt.getText();
		Older older = new Older(roomnumber);
		this.fillTable(older);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String name = nameTxt.getText();
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录么");
		if (n == 0) {
			Connection con = null;
			try {
				con = connectUtil.getCon();
				Older older = new Older(name);
				int a = Olderdao.OlderDelete(con, older);
				if (a == 1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.fillTable(older);
					this.nameTxt.setText("");
					return;
				} else {
					JOptionPane.showMessageDialog(null, "删除失败!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "删除失败!");
				e.printStackTrace();
			}
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "确认退出？");
		if (a == 0) {
			this.dispose();
		}
	}


	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_search;
	private javax.swing.JTextField nameTxt;
	private javax.swing.JTable table;


}