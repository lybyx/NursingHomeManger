package com.lybxxx.view;

import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;

/**
 *
 * @author  lybxxx
 */
public class RoomInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil connectUtil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();

	public RoomInterFrm() {
		initComponents();
		this.setLocation(200, 50);
	}


	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		dm_number = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		dm_nurse = new javax.swing.JTextField();
		jb_add = new javax.swing.JButton();
		jb_reset = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u623F\u95F4\u7BA1\u7406");

		jLabel1.setText("\u623F\u95F4\u53F7\uFF1A");

		jLabel2.setText("\u62A4  \u5DE5\uFF1A");

		jb_add.setIcon(new ImageIcon(
				"D:\\Myelipse\\images4\\add.png"));
		jb_add.setText("\u6dfb\u52a0");
		jb_add.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_addActionPerformed(evt);
			}
		});

		jb_reset.setIcon(new ImageIcon(
				"D:\\Myelipse\\images4\\reset.png"));
		jb_reset.setText("\u91cd\u7f6e");
		jb_reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_resetActionPerformed(evt);
			}
		});

		jLabel3.setIcon(new ImageIcon(RoomInterFrm.class.getResource("/images/winnie_the_pooh_bear_64px_548217_easyicon.net (1).png")));

		GroupLayout layout = new GroupLayout(
				getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(22)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dm_nurse, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dm_number, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(jb_add, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(75)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jb_reset, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(29)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(dm_number, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(70)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel2)
								.addComponent(dm_nurse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jb_add)
								.addComponent(jb_reset))
							.addContainerGap(44, Short.MAX_VALUE))))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jb_addActionPerformed(java.awt.event.ActionEvent evt) {
		String name = dm_number.getText();
		String nurse = dm_nurse.getText();
		Room room = new Room(name, nurse);
		Connection con = null;
		try {
			con = connectUtil.getCon();
			int a = roomdao.roomAdd(con, room);
			if (a == 1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "添加失败！");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "添加失败！");
			e.printStackTrace();
		} finally {
			try {
				connectUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void resetValue() {
		this.dm_nurse.setText("");
		this.dm_number.setText("");
	}

	private void jb_resetActionPerformed(java.awt.event.ActionEvent evt) {
		this.dm_number.setText("");
		this.dm_nurse.setText("");
	}

	private javax.swing.JTextField dm_nurse;
	private javax.swing.JTextField dm_number;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JButton jb_add;
	private javax.swing.JButton jb_reset;

}