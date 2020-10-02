package com.lybxxx.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

/**
 *
 * @author  lybxxx
 */
public class MainFrm2 extends javax.swing.JFrame {

	/** Creates new form MainFrm2 */
	public MainFrm2() {
		initComponents();
		this.setExtendedState(MAXIMIZED_BOTH);
	}


	private void initComponents() {

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("用户登录主界面");

		jMenu1.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/classmanage.png")));
		jMenu1.setText("入住管理");

		jMenuItem2.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/edit.png")));
		jMenuItem2.setText("办理入住");
		jMenuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/modify.png")));
		jMenuItem3.setText("信息修改");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuBar1.add(jMenu1);

		jMenu3.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/search.png")));
		jMenu3.setText("信息查询");

		jMenuItem1.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/reapir.png")));
		jMenuItem1.setText("护工信息");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem1);

		jMenuItem4.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/grademanage.png")));
		jMenuItem4.setText("老人信息");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem4);

		jMenuBar1.add(jMenu3);

		jMenu2.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/about.png")));
		jMenu2.setText("退出");

		jMenuItem6.setIcon(new ImageIcon(MainFrm2.class.getResource("/images/me.png")));
		jMenuItem6.setText("退出系统");
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem6);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE));

		pack();
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "确定要退出？");
		if (a == 0) {
			this.dispose();
		}
	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		NurseSearchInterFrm roomSearch = new NurseSearchInterFrm();
		roomSearch.setVisible(true);
		this.table.add(roomSearch);
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		OlderSearchInterFrm OlderSearch = new OlderSearchInterFrm();
		OlderSearch.setVisible(true);
		this.table.add(OlderSearch);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		OlderModifyInterFrm OlderModify = new OlderModifyInterFrm();
		OlderModify.setVisible(true);
		this.table.add(OlderModify);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		OlderInterFrm Older = new OlderInterFrm();
		Older.setVisible(true);
		this.table.add(Older);
	
	}




	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JDesktopPane table;


}