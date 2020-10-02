package com.lybxxx.view;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.lybxxx.dao.OlderDao;
import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Older;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

/**
 *
 * @author lybxxx
 */
public class OlderInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil dmutil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();
	OlderDao Olderdao = new OlderDao();


	public OlderInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable();
		this.jb_man.setSelected(true);
	}

	public void fillTable() {
		Connection con = null;
		Older older = null;
		Room room = new Room();
		try {
			con = dmutil.getCon();
			ResultSet rs = roomdao.roomList(con, room);
			Room room2 = new Room();
			room2.setRoomNumber("请选择...");
			room2.setId(-1 + "");
			this.jcb_room.addItem(room2);
			while (rs.next()) {
				room = new Room();
				room.setId(rs.getInt("id") + "");
				room.setRoomNumber(rs.getString("roomnumber"));
				room.setNurse(rs.getString("nurse"));
				this.jcb_room.addItem(room);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				dmutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}



	private void initComponents() {

buttonGroup1 = new javax.swing.ButtonGroup();
jLabel1 = new javax.swing.JLabel();
nameTxt = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
jb_man = new javax.swing.JRadioButton();
jb_women = new javax.swing.JRadioButton();
jLabel3 = new javax.swing.JLabel();
jLabel4 = new javax.swing.JLabel();
jLabel5 = new javax.swing.JLabel();
jLabel6 = new javax.swing.JLabel();
jb_regist = new javax.swing.JButton();
jb_exit = new javax.swing.JButton();
jcb_room = new javax.swing.JComboBox();
jLabel7 = new javax.swing.JLabel();
xibieTxt = new javax.swing.JTextField();
classTxt = new javax.swing.JTextField();
bedTxt = new javax.swing.JTextField();

setClosable(true);
setIconifiable(true);
setResizable(true);
setTitle("\u8001\u4EBA\u767B\u8BB0");

jLabel1.setText("\u59d3\u540d\uff1a");

jLabel2.setText("\u6027\u522b\uff1a");

buttonGroup1.add(jb_man);
jb_man.setText("\u7537");

buttonGroup1.add(jb_women);
jb_women.setText("\u5973");

jLabel3.setText("\u5BB6\u5C5E\uFF1A");

jLabel4.setText("\u7535\u8BDD\uFF1A");

jLabel5.setText("\u623F\u95F4\u53F7\uFF1A");

jLabel6.setText("\u5e8a\u53f7\uff1a");

jb_regist.setIcon(new ImageIcon("D:\\Myelipse\\images4\\add.png"));
jb_regist.setText("\u767b\u8bb0");
jb_regist.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_registActionPerformed(evt);
}
});

jb_exit.setIcon(new ImageIcon("D:\\Myelipse\\images4\\exit.png"));
jb_exit.setText("\u9000\u51fa");
jb_exit.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_exitActionPerformed(evt);
}
});


jLabel7.setIcon(new ImageIcon(OlderInterFrm.class.getResource("/images/mickey_mouse_cartoon_96px_548219_easyicon.net (1).png")));

GroupLayout layout = new GroupLayout(getContentPane());
layout.setHorizontalGroup(
	layout.createParallelGroup(Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel6)
					.addGap(192))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
									.addGroup(layout.createSequentialGroup()
										.addComponent(jLabel4)
										.addGap(20))
									.addComponent(jLabel5))
								.addComponent(jLabel3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jcb_room, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(bedTxt)
								.addComponent(classTxt)
								.addComponent(xibieTxt, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE))
						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jb_man)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jb_women, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, layout.createSequentialGroup()
								.addComponent(jLabel1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jb_regist, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
					.addGap(125)
					.addComponent(jb_exit, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
			.addGap(24)
			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
			.addGap(56))
);
layout.setVerticalGroup(
	layout.createParallelGroup(Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
			.addGap(26)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jLabel1)
				.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(32)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jLabel2)
				.addComponent(jb_man)
				.addComponent(jb_women))
			.addGap(29)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jLabel3)
				.addComponent(xibieTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(26)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jLabel4)
				.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(30)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jLabel6)
				.addComponent(bedTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGap(29)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jLabel5)
				.addComponent(jcb_room, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jb_regist)
				.addComponent(jb_exit))
			.addContainerGap(22, Short.MAX_VALUE))
		.addGroup(layout.createSequentialGroup()
			.addGap(39)
			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(163, Short.MAX_VALUE))
);
getContentPane().setLayout(layout);

pack();
}


	private void jb_registActionPerformed(java.awt.event.ActionEvent evt) {
		String name = nameTxt.getText();
		String xibie = xibieTxt.getText();
		String classroom = classTxt.getText();
		String bed = bedTxt.getText();
		String sex = "";
		if (jb_man.isSelected()) {
			sex = "男";
		} else if (jb_women.isSelected()) {
			sex = "女";
		}
		Room room = (Room) this.jcb_room.getSelectedItem();
		String dormitory = room.getId();
		Connection con = null;
		try {
			con = dmutil.getCon();
			Older Older = new Older(name, sex, xibie, classroom,
					Integer.parseInt(dormitory), Integer.parseInt(bed));
			int a = Olderdao.OlderAdd(con, Older);
			if (a == 1) {
				JOptionPane.showMessageDialog(null, "登记成功！");
				this.resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "登记失败！");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "登记失败！");
			e.printStackTrace();
		}
	}

	private void resetValue() {
		nameTxt.setText("");
		xibieTxt.setText("");
		classTxt.setText("");
		bedTxt.setText("");
		this.jb_man.setSelected(true);
		this.jcb_room.setSelectedIndex(0);

	}

	private void jb_exitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
		if (result == 0) {
			this.dispose();
		}
	}


	private javax.swing.JTextField bedTxt;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JTextField classTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JButton jb_exit;
	private javax.swing.JRadioButton jb_man;
	private javax.swing.JButton jb_regist;
	private javax.swing.JRadioButton jb_women;
	private javax.swing.JComboBox jcb_room;
	private javax.swing.JTextField nameTxt;
	private javax.swing.JTextField xibieTxt;


}