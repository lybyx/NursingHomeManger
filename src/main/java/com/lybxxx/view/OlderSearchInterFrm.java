package com.lybxxx.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.lybxxx.dao.OlderDao;
import com.lybxxx.dao.RoomDao;
import com.lybxxx.model.Older;
import com.lybxxx.model.Room;
import com.lybxxx.util.ConnectUtil;

/**
 *
 * @author  lybxxx
 */
public class OlderSearchInterFrm extends javax.swing.JInternalFrame {
	ConnectUtil dmutil = new ConnectUtil();
	RoomDao roomdao = new RoomDao();
	OlderDao Olderdao = new OlderDao();


	public OlderSearchInterFrm() {
		initComponents();
		this.setLocation(5, 50);
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
			room2.setRoomNumber("��ѡ��...");
			room2.setId(-1 + "");
			this.jcb_roomnum.addItem(room2);
			while (rs.next()) {
				room = new Room();
				room.setId(rs.getInt("id") + "");
				room.setRoomNumber(rs.getString("roomnumber"));
				room.setNurse(rs.getString("nurse"));
				this.jcb_roomnum.addItem(room);
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
			ResultSet rs = Olderdao.OlderSearch(con, older);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dmutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




	private void initComponents() {

buttonGroup1 = new javax.swing.ButtonGroup();
jPanel1 = new javax.swing.JPanel();
jLabel1 = new javax.swing.JLabel();
nameTxt = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
xibieTxt = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
jb_man = new javax.swing.JRadioButton();
jb_women = new javax.swing.JRadioButton();
jLabel4 = new javax.swing.JLabel();
jcb_roomnum = new javax.swing.JComboBox();
jb_search = new javax.swing.JButton();
jLabel5 = new javax.swing.JLabel();
classTxt = new javax.swing.JTextField();
jLabel6 = new javax.swing.JLabel();
bednumTxt = new javax.swing.JTextField();
jScrollPane1 = new javax.swing.JScrollPane();
table = new javax.swing.JTable();

setClosable(true);
setIconifiable(true);

jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("\u641c\u7d22\u64cd\u4f5c"));

jLabel1.setText("\u59d3\u540d\uff1a");

jLabel2.setText("\u5BB6\u5C5E\uFF1A");

jLabel3.setText("\u6027\u522b\uff1a");

jb_man.setText("\u7537");

jb_women.setText("\u5973");

jLabel4.setText("\u623F\u95F4\u53F7\uFF1A");


jb_search.setIcon(new javax.swing.ImageIcon("D:\\Myelipse\\images4\\search.png")); // NOI18N
jb_search.setText("\u67e5\u8be2");
jb_search.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_searchActionPerformed(evt);
}
});

jLabel5.setText("\u7535\u8BDD\uFF1A");

jLabel6.setText("\u5e8a\u53f7\uff1a");

GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
jPanel1Layout.setHorizontalGroup(
	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
		.addGroup(jPanel1Layout.createSequentialGroup()
			.addContainerGap()
			.addComponent(jLabel1)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(jLabel2)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(xibieTxt, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(jLabel5)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(jLabel6)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(bednumTxt, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(jLabel3)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(jb_man)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(jb_women)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(jLabel4)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(jcb_roomnum, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
			.addGap(101)
			.addComponent(jb_search, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
);
jPanel1Layout.setVerticalGroup(
	jPanel1Layout.createParallelGroup(Alignment.LEADING)
		.addGroup(jPanel1Layout.createSequentialGroup()
			.addContainerGap()
			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addComponent(jcb_roomnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
					.addComponent(jb_search)
					.addComponent(jLabel1)
					.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabel2)
					.addComponent(xibieTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabel5)
					.addComponent(classTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabel6)
					.addComponent(bednumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(jLabel3)
					.addComponent(jb_man)
					.addComponent(jb_women)
					.addComponent(jLabel4)))
			.addContainerGap(28, Short.MAX_VALUE))
);
jPanel1.setLayout(jPanel1Layout);

table.setModel(new DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
			"编号", "姓名", "性别", "家属", "电话", "房间号", "床号"
	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false, false
	};

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
jScrollPane1.setViewportView(table);

GroupLayout layout = new GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(Alignment.LEADING)
.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
.addContainerGap()
.addGroup(layout.createParallelGroup(Alignment.TRAILING)
.addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE))
.addContainerGap())
);
layout.setVerticalGroup(
layout.createParallelGroup(Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(ComponentPlacement.UNRELATED)
.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
.addContainerGap(175, Short.MAX_VALUE))
);

pack();
}
	private void jb_searchActionPerformed(java.awt.event.ActionEvent evt) {
		String name = nameTxt.getText();
		String xibie = xibieTxt.getText();
		String sex = "";
		if (jb_man.isSelected()) {
			sex = "男";
		} else if (jb_women.isSelected()) {
			sex = "女";
		}
		String classroom = classTxt.getText();

		Room room = (Room) jcb_roomnum.getSelectedItem();
		String dormitory = room.getId();
		Older older = new Older(name, sex, xibie, classroom,
				Integer.parseInt(dormitory));
		this.fillTable(older);
	}


	private javax.swing.JTextField bednumTxt;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JTextField classTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JRadioButton jb_man;
	private javax.swing.JButton jb_search;
	private javax.swing.JRadioButton jb_women;
	private javax.swing.JComboBox jcb_roomnum;
	private javax.swing.JTextField nameTxt;
	private javax.swing.JTable table;
	private javax.swing.JTextField xibieTxt;

}