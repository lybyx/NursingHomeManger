
package com.lybxxx.view;


import javax.swing.*;

/**
 *
 * @author  lybxxx
 */
public class MainFrm extends JFrame {

	/** Creates new form MainFrm */
	public MainFrm() {
		initComponents();
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	
	private void initComponents() {

		jMenuBar2 = new JMenuBar();
		jMenu3 = new  JMenu();
		jMenu4 = new  JMenu();
		jMenuBar3 = new  JMenuBar();
		jMenu5 = new  JMenu();
		jMenu6 = new  JMenu();
		table = new JDesktopPane();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new  JMenu();
		jMenuItem2 = new  JMenuItem();
		jMenuItem3 = new  JMenuItem();
		jMenu9 = new  JMenu();
		jMenuItem1 = new  JMenuItem();
		jMenuItem5 = new  JMenuItem();
		jMenu2 = new  JMenu();
		jMenuItem4 = new  JMenuItem();
		enter = new  JMenuItem();
		jMenu7 = new  JMenu();
		jMenuItem6 = new  JMenuItem();
		jMenuItem7 = new  JMenuItem();
		jMenu8 = new  JMenu();
		exit = new  JMenuItem();

		jMenu3.setText("File");
		jMenuBar2.add(jMenu3);

		jMenu4.setText("Edit");
		jMenuBar2.add(jMenu4);

		jMenu5.setText("File");
		jMenuBar3.add(jMenu5);

		jMenu6.setText("Edit");
		jMenuBar3.add(jMenu6);

		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
		setTitle("管理员登录主页");

		jMenu1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png"))); // NOI18N
		jMenu1.setText("护工信息管理");

		jMenuItem2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/student01.png"))); // NOI18N
		jMenuItem2.setText("护工信息修改");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/delete.png"))); // NOI18N
		jMenuItem3.setText("护工信息删除");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuBar1.add(jMenu1);

		jMenu9.setIcon(new ImageIcon(MainFrm.class.getResource("/images/classrepair.png"))); // NOI18N
		jMenu9.setText("老人信息管理");

		jMenuItem1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png"))); // NOI18N
		jMenuItem1.setText("老人信息修改");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu9.add(jMenuItem1);

		jMenuItem5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/delete.png"))); // NOI18N
		jMenuItem5.setText("老人信息删除");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu9.add(jMenuItem5);

		jMenuBar1.add(jMenu9);

		jMenu2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png"))); // NOI18N
		jMenu2.setText("住宿管理");

		jMenuItem4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png"))); // NOI18N
		jMenuItem4.setText("房间管理");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem4);

		enter.setIcon(new ImageIcon(MainFrm.class.getResource("/images/userName.png"))); // NOI18N
		enter.setText("办理入住");
		enter.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enterActionPerformed(evt);
			}
		});
		jMenu2.add(enter);

		jMenuBar1.add(jMenu2);

		jMenu7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/grademanage.png"))); // NOI18N
		jMenu7.setText("信息查询");

		jMenuItem6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/search.png"))); // NOI18N
		jMenuItem6.setText("老人信息查询");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu7.add(jMenuItem6);

		jMenuItem7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/reset.png"))); // NOI18N
		jMenuItem7.setText("护工信息查询");
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu7.add(jMenuItem7);

		jMenuBar1.add(jMenu7);

		jMenu8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png"))); // NOI18N
		jMenu8.setText("退出");

		exit.setIcon(new ImageIcon(MainFrm.class.getResource("/images/me.png"))); // NOI18N
		exit.setText("退出系统");
		exit.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitActionPerformed(evt);
			}
		});
		jMenu8.add(exit);

		jMenuBar1.add(jMenu8);

		setJMenuBar(jMenuBar1);

		 GroupLayout layout = new  GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				 GroupLayout.Alignment.LEADING).addComponent(table,
				 GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				 GroupLayout.Alignment.LEADING).addComponent(table,
				 GroupLayout.Alignment.TRAILING,
				 GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE));

		pack();
	}

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
		OlderDeleteInterFrm OlderDelete = new OlderDeleteInterFrm();
		OlderDelete.setVisible(true);
		this.table.add(OlderDelete);
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		OlderModifyInterFrm OlderModify = new OlderModifyInterFrm();
		OlderModify.setVisible(true);
		this.table.add(OlderModify);
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
		OlderSearchInterFrm OlderSearch = new OlderSearchInterFrm();
		OlderSearch.setVisible(true);
		this.table.add(OlderSearch);
	}

	private void enterActionPerformed(java.awt.event.ActionEvent evt) {
		OlderInterFrm Older = new OlderInterFrm();
		Older.setVisible(true);
		this.table.add(Older);
	}

	private void exitActionPerformed(java.awt.event.ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "确定要退出？");
		if (a == 0) {
			this.dispose();
		}
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		NurseDeleteInterFrm roomDelete = new NurseDeleteInterFrm();
		roomDelete.setVisible(true);
		this.table.add(roomDelete);
	}

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
		NurseSearchInterFrm roomSearch = new NurseSearchInterFrm();
		roomSearch.setVisible(true);
		this.table.add(roomSearch);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		NurseManagerInterFrm roommanager = new NurseManagerInterFrm();
		roommanager.setVisible(true);
		this.table.add(roommanager);
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {

		RoomInterFrm room = new RoomInterFrm();
		room.setVisible(true);
		this.table.add(room);
	}




	private  JMenuItem enter;
	private  JMenuItem exit;
	private  JMenu jMenu1;
	private  JMenu jMenu2;
	private  JMenu jMenu3;
	private  JMenu jMenu4;
	private  JMenu jMenu5;
	private  JMenu jMenu6;
	private  JMenu jMenu7;
	private  JMenu jMenu8;
	private  JMenu jMenu9;
	private  JMenuBar jMenuBar1;
	private  JMenuBar jMenuBar2;
	private  JMenuBar jMenuBar3;
	private  JMenuItem jMenuItem1;
	private  JMenuItem jMenuItem2;
	private  JMenuItem jMenuItem3;
	private  JMenuItem jMenuItem4;
	private  JMenuItem jMenuItem5;
	private  JMenuItem jMenuItem6;
	private  JMenuItem jMenuItem7;
	private  JDesktopPane table;

}