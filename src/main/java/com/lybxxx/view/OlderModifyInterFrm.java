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
import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Older;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;

/**
 *
 * @author lybxxx
 */
public class OlderModifyInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil dmutil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();
	OlderDao olderdao = new OlderDao();

	public OlderModifyInterFrm() {
		initComponents();
		this.setLocation(160, 50);
		this.fillTable(new Older());
		this.fillRoom();
		this.jb_man.setSelected(true);
	}

	public void fillRoom() {
		Connection con = null;
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
				room.setNurse(rs.getString("Nurse"));
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

	private void fillTable(Older older) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dmutil.getCon();
			ResultSet rs = olderdao.OlderSearch(con, older);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("family"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("roomnumber"));
				v.add(rs.getString("bed"));
				dtm.addRow(v);
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
phoneTxt = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
familyTxt = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
bedTxt = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
jb_man = new javax.swing.JRadioButton();
jb_women = new javax.swing.JRadioButton();
jLabel6 = new javax.swing.JLabel();
jcb_room = new javax.swing.JComboBox();
jScrollPane1 = new javax.swing.JScrollPane();
table = new javax.swing.JTable();
jb_modify = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jLabel7 = new javax.swing.JLabel();
idTxt = new javax.swing.JTextField();

setClosable(true);
setIconifiable(true);
setTitle("\u8001\u4EBA\u4FE1\u606F\u4FEE\u6539");

jLabel1.setText("\u59d3\u540d\uff1a");

jLabel2.setText("\u7535\u8BDD\uFF1A");

jLabel3.setText("\u5BB6\u5C5E\uFF1A");

jLabel4.setText("\u5e8a\u53f7\uff1a");

jLabel5.setText("\u6027\u522b\uff1a");

buttonGroup1.add(jb_man);
jb_man.setText("\u7537");

buttonGroup1.add(jb_women);
jb_women.setText("\u5973");

jLabel6.setText("\u623F\u95F4\u53F7\uFF1A");


table.setModel(new DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
			"编号", "姓名", "性别", "家属", "电话", "房间号", "床号"	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false, false
	};

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
table.addMouseListener(new java.awt.event.MouseAdapter() {
public void mousePressed(java.awt.event.MouseEvent evt) {
tableMousePressed(evt);
}
});
jScrollPane1.setViewportView(table);

jb_modify.setIcon(new javax.swing.ImageIcon("D:\\Myelipse\\images4\\modify.png"));
jb_modify.setText("\u4fee\u6539");
jb_modify.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_modifyActionPerformed(evt);
}
});

jButton2.setIcon(new javax.swing.ImageIcon("D:\\Myelipse\\images4\\exit.png"));
jButton2.setText("\u9000\u51fa");
jButton2.addActionListener(new java.awt.event.ActionListener() {
@Override
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

jLabel7.setText("\u7f16\u53f7\uff1a");

idTxt.setEditable(false);

GroupLayout layout = new GroupLayout(getContentPane());
layout.setHorizontalGroup(
	layout.createParallelGroup(Alignment.TRAILING)
		.addGroup(layout.createSequentialGroup()
			.addGap(32)
			.addGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
					.addComponent(jLabel4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bedTxt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
			.addGap(18)
			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(8)
					.addComponent(jLabel5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jb_man)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jb_women, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(jLabel6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jcb_room, 0, 168, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addGap(4)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabel3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(familyTxt, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabel7)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
			.addGap(49))
		.addGroup(layout.createSequentialGroup()
			.addContainerGap()
			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
			.addContainerGap())
		.addGroup(layout.createSequentialGroup()
			.addContainerGap(303, Short.MAX_VALUE)
			.addComponent(jb_modify, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
			.addGap(119)
			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
			.addGap(124))
);
layout.setVerticalGroup(
	layout.createParallelGroup(Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
			.addGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(24)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel4)
						.addComponent(bedTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(layout.createSequentialGroup()
					.addGap(23)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3)
						.addComponent(familyTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel7)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jb_women)
						.addComponent(jb_man)
						.addComponent(jLabel5)))
				.addGroup(layout.createSequentialGroup()
					.addGap(83)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel6)
						.addComponent(jcb_room, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
			.addGap(30)
			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
			.addGap(18)
			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(jb_modify)
				.addComponent(jButton2))
			.addContainerGap(46, Short.MAX_VALUE))
);
getContentPane().setLayout(layout);

pack();
}

	private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		String name = nameTxt.getText();
		String phone = phoneTxt.getText();
		String family = familyTxt.getText();
		String bed = bedTxt.getText();
		String sex = "";
		if (jb_man.isSelected()) {
			sex = "男";
		} else if (jb_women.isSelected()) {
			sex = "女";
		}
		String id = idTxt.getText();
		Room room = (Room) this.jcb_room.getSelectedItem();
		String roomnum = room.getId();
		Connection con = null;
		try {
			con = dmutil.getCon();
			Older older = new Older(Integer.parseInt(id), name, sex,
					family, phone, Integer.parseInt(roomnum),
					Integer.parseInt(bed));
			int a = olderdao.OlderModify(con, older);
			if (a == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				this.fillTable(new Older());
				return;
			} else {
				JOptionPane.showMessageDialog(null, "修改失败!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "修改失败!");
			e.printStackTrace();
		}
	}

	private void resetValue() {
		this.nameTxt.setText("");
		this.phoneTxt.setText("");
		this.bedTxt.setText("");
		this.familyTxt.setText("");
		this.jb_man.setSelected(true);
		this.jcb_room.setSelectedIndex(0);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "确认要退出？");
		if (a == 0) {
			this.dispose();
		}
	}

	private void tableMousePressed(java.awt.event.MouseEvent evt) {
		int row = table.getSelectedRow();
		nameTxt.setText(table.getValueAt(row, 1) + "");
		familyTxt.setText(table.getValueAt(row, 3) + "");
		phoneTxt.setText(table.getValueAt(row, 4) + "");
		bedTxt.setText(table.getValueAt(row, 6) + "");
		String sex = table.getValueAt(row, 2) + "";
		idTxt.setText((String) table.getValueAt(row, 0));
		if (sex.equals("��")) {
			this.jb_man.setSelected(true);
		} else if (sex.equals("Ů")) {
			this.jb_women.setSelected(true);
		}
		String roomid = (String) table.getValueAt(row, 5);
		int n = this.jcb_room.getItemCount();
		for (int i = 0; i < n; i++) {
			Room item = (Room) this.jcb_room.getItemAt(i);
			if (item.getRoomNumber().equals(roomid)) {
				this.jcb_room.setSelectedIndex(i);
			}
		}
	}


	private javax.swing.JTextField bedTxt;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JTextField phoneTxt;
	private javax.swing.JTextField idTxt;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JRadioButton jb_man;
	private javax.swing.JButton jb_modify;
	private javax.swing.JRadioButton jb_women;
	private javax.swing.JComboBox jcb_room;
	private javax.swing.JTextField nameTxt;
	private javax.swing.JTable table;
	private javax.swing.JTextField familyTxt;

}