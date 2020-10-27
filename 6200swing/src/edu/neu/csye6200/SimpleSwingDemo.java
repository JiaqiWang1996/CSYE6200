package edu.neu.csye6200;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class SimpleSwingDemo implements Runnable {
//	private JPanel m_controlPanel = new JPanel();
//	private JLabel m_headerLabel  = new JLabel();
	private JLabel m_dateStatusLabel  = new JLabel();
	private JLabel m_fruitStatusLabel  = new JLabel();
	private final Logger m_logger = Logger.getLogger(this.getClass().getCanonicalName());
	private String m_currentPattern = null;

	/**
	 * allow each object created from this class to be a Runnable object
	 */
	@Override
	public void run() {
		System.out.println("I'm a Swing'N '" + SimpleSwingDemo.class.getName() + "' Object running in a new Thread");
	}
	
	private class MyPerson {
		
		private Integer id = null;
		private String firstName = null;
		private String lastName = null;
		private Integer age = null;
		
		public MyPerson() {
			super();
			this.init(1, "John", "Doe", 1);
		}

		public MyPerson(Integer id, String firstName, String lastName, Integer age) {
			super();
			this.init(id, firstName, lastName, age);
		}

		private void init(Integer id, String firstName, String lastName, Integer age) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			StringBuilder info = new StringBuilder("Person: ");
			info.append(this.getFirstName());
			info.append(" ").append(this.getLastName());
			info.append(", age: ").append(this.getAge());
			info.append(", id: ").append(this.getId());
			return info.toString();
		}
		
		public void show() {
			System.out.println(this.toString());
		}
	}

	private class MyItem {
		private int id;
		private double price;
		private String name;
		
		public MyItem() {
			super();
			// TODO Auto-generated constructor stub
		}
		public MyItem(int id, double price, String name) {
			super();
			this.id = id;
			this.price = price;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "# " + id + " $" + price + ", " + name + "";
		}
	}
	
	/**
	 * demonstrate how java auto-boxing works
	 * for using primitive types in a collection
	 */
	public void demoAutoBoxing() {
      List<Integer> integers = new ArrayList<Integer>();
      /*
       *  auto-boxing:
       *   literal int type is placed inside Integer object
       *   to add to sequential container
       *   (sequential containers cannot work with primitive types)
       */
      integers.add(2);				// autobox literal int 2
      integers.add(3);				// autobox literal int 3
      integers.add(1);				// autobox literal int 1
      /**
       * no auto-boxing required
       * the following is the equivalent to auto-boxing of literal 4 integer
       */
      integers.add(new Integer(4));	// add Integer holding literal int 4
	}
	
	/**
	 * show how to use a Thread object to execute a Runnable object
	 */
	public void runThySelf() {
		System.out.println("\n\t" + SimpleSwingDemo.class.getName() + ".runThySelf()...");
		
		
		Thread t1 = new Thread(this); // create Thread
		t1.start();	// Start Thread running
		//I'm a Swing'N Object running in a new Thread

		try {
			t1.join();	// Original Thread waits for new Thread to complete
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Runnable r1 = () -> System.out.println("I'm a r1 Lambda running in a new Thread");
		// I'm a r1 Lambda running in a new Thread


		Thread t2 = new Thread(r1); // create Thread
		t2.start();	// Start Thread running
		//I'm a Swing'N Object running in a new Thread

		try {
			t2.join();	// Original Thread waits for new Thread to complete
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Thread t3 = new Thread(() -> System.out.println("Hi")); // create Thread
		// Hi
		t3.start();	// Start Thread running
		try {
			t3.join();	// Original Thread waits for new Thread to complete
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hi, It's Anonymous ME!");
			}
		}); // create Thread
		t4.start();	// Start Thread running
		// Hi, It's Anonymous ME!

		try {
			t4.join();	// Original Thread waits for new Thread to complete
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * Use Thread pool and Runnable
		 */
		ExecutorService executor = Executors.newFixedThreadPool(10);
//		executor.execute(()-> System.out.println("Executing..."));
		
		System.out.println("\n\t" + SimpleSwingDemo.class.getName() + ".runThySelf()... done!");
		
	}
	
	
	/**
	 * create a GUI pop-up window containing supplied component
	 *  
	 * @param c		GUI component to 
	 */
	public void simplePopUpWindow(String windowTitle, Component c) {
		/**
		 * create a pop-up window (JFrame) for containing table
		 */
		JFrame frame = new JFrame(windowTitle);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		/**
		 * create a JScrollPane for wrapping the table and
		 *  1) add table to JScrollPane; 
		 *  2) add JScrollPane to the JFrame
		 */
		frame.add(c);
		/*
		 * size window (JFrame) to contained components for a simple window layout
		 */
		frame.pack();	
		frame.setVisible(true);	// make JFrame visible to user
	}
	
	/**
	 * create a GUI pop-up window containing supplied component
	 *  
	 * @param c		GUI component to 
	 */
	public void simplePopUpWindow(Component c) {
		simplePopUpWindow("Simple Pop-up Window Example", c);
	}
	
	/**
	 * create a table (JTable) with the supplied data
	 * 
	 * @param tableTitle	String table name
	 * @param colnames		String array containing table column names
	 * @param data			Object array containing table data
	 */
	public void simpleTable(String tableTitle, String[] colnames, Object[][] data) {
		JTable table = new JTable(data, colnames);
		table.setAutoCreateRowSorter(true); // sortable table
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		/*
		 * create scroll pane for wrapping the table
		 */
		simplePopUpWindow(tableTitle, new JScrollPane(table));
	}
	
	/**
	 * create a table (JTable) with the supplied data
	 * 
	 * @param myTM		table model containing table data
	 */
	public void simpleTable(DefaultTableModel myTM) {
		JTable table = new JTable();	// create JTable
		table.setModel(myTM);			// set table model in JTable
		/**
		 * make table automatically sort-able with click on table column
		 * and automatically resize-able with a mouse dragging border or corner stretch
		 */
		table.setAutoCreateRowSorter(true); // sortable table
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		/*
		 * create scroll pane for wrapping the table
		 */
		simplePopUpWindow("MyPerson Table Example", new JScrollPane(table));
	}	
	
	/**
	 * create a table model of MyPerson objects for simpleTable().
	 *  
	 * Given:
	 *  1) a String array of titles and 
	 *  2) a list of MyPerson objects, 
	 * create a Table Model and pass it to simpleTable() for GUI display.
	 * 
	 * @param colTitles		String array of table column titles
	 * @param list			List of MyPerson objects
	 */
	public void personTable(String[] colTitles, List<MyPerson> list) {
		/**
		 * Create a table model for containing table data
		 */
        DefaultTableModel myTM = new DefaultTableModel();
        /**
         * Set the table columns and their titles
         */
        myTM.setColumnCount(colTitles.length);
        myTM.setColumnIdentifiers(colTitles);
        int ix = 0;
        
        for (MyPerson p : list) {
        	String fname = p.getFirstName();
        	String lname = p.getLastName();
        	int age = p.getAge();
        	myTM.addRow(new Object[]{++ix, p.getId(), fname, lname, age});
        }
        simpleTable(myTM);
        
	}

	public void myPersonTableDemo() {
		String [] colTitles = {"ID", "Pres #", "First Name","Last Name", "Age"};
		List<MyPerson> list = new ArrayList<>();
		
//		List<Person> list = new ArrayList<>();
//		Person p1 = new Person(1, "George", "Washington", 43);
//		Person p2 = new Person(4, "James", "Madison", 49);
//		Person p3 = new Person(2, "John", "Adams", 48);
//		Person p4 = new Person(45, "Danald", "Trump", 71);
		// Person p5 = new Person(46, "Daniel", "Peters", 17);
//		list.add(p1);
//		list.add(p2);
//		list.add(p3);
//		list.add(p4);
		
		list.add(new MyPerson(46, "Daniel", "Peters", 17));
		list.add(new MyPerson(1, "George", "Washington", 43));
		list.add(new MyPerson(4, "James", "Madison", 49));
		list.add(new MyPerson(2, "John", "Adams", 48));
		list.add(new MyPerson(45, "Danald", "Trump", 71));
		
		personTable(colTitles, list);
	}
	
	public void filteredMyPersonTableDemo() {
		System.out.println("\n\t" + SimpleSwingDemo.class.getName() + ".filteredPersonTableDemo()..." );
		
		String [] colTitles = {"ID", "Pres #", "First Name","Last Name", "Age"};
		List<MyPerson> allPresidents = new ArrayList<>();
		allPresidents.add(new MyPerson(45, "Donald", "Trump", 71));
		allPresidents.add(new MyPerson(1, "George", "Washington", 43));
		allPresidents.add(new MyPerson(4, "James", "Madison", 49));
		allPresidents.add(new MyPerson(2, "John", "Adams", 48));
		// list.add(Person(46, "Daniel", "Peters", 17));
		allPresidents.add(new MyPerson(46, "Daniel", "Peters", 17));
		
		/**
		 * Filter list showing ONLY early presidents (first 10)
		 */
		List<MyPerson> earlyPresidents =	// use with .collect terminal operation
				
		allPresidents.stream()
		.filter(p -> p.getId() < 10)
		
		// sort stream using supplied Lambda method reference as keyExtractor (for Comparator)
		.sorted(Comparator.comparing(MyPerson::getFirstName))
//		.sorted(comparing(Person::getLastName))
		
		.collect( Collectors.toList() );// terminate Stream in a new List
//		.forEach(System.out::println);	// terminate Stream with output to stdout
		
		personTable(colTitles, earlyPresidents);	// show list in a pop-up GUI table
		
		personTable(colTitles, allPresidents);		// show list in a pop-up GUI table
		
		
		
		System.out.println("\n\t" + SimpleSwingDemo.class.getName() + ".filteredPersonTableDemo()... done!" );
	}
	

	public void itemTableDemo() {
		String[] colNames = {"ID", "PRICE", "NAME"};
		List<SimpleSwingDemo.MyItem> list = new ArrayList<SimpleSwingDemo.MyItem>();
		list.add(new MyItem(1,1.29,"Bread"));
		list.add(new MyItem(2,3.49,"Oj"));
		list.add(new MyItem(3,2.79,"Milk"));
		list.add(new MyItem(4,.79,"Candy"));
		Object[][] data = new Object[list.size()][3];
		int i = 0;
		for (MyItem myItem : list) {
			data[i][0] = myItem.getId();
			data[i][1] = myItem.getPrice();
			data[i][2] = myItem.getName();
			i++;
		}
		simpleTable("MyItem Table Example", colNames, data);
	}

	/**
	 * reformat the current date and time according to supplied pattern.
	 * @param curPattern
	 */
	private void reformat(String curPattern) {
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(curPattern);
		try{
			String dateString = formatter.format(today);
			m_dateStatusLabel.setForeground(Color.BLACK);
			m_dateStatusLabel.setText(dateString);
			System.out.println(dateString);
		} catch (IllegalArgumentException iae) {
			m_dateStatusLabel.setForeground(Color.red);
			m_dateStatusLabel.setText("ERROR: "+iae.getMessage());
			System.err.println("ERROR: IllegalArgumentException: "+ iae.getMessage());
			iae.printStackTrace();
		}
	}

	public void demoDateComboboxDemo() {
		JPanel controlPanel = new JPanel();
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Control in action: Date JComboBox ");

		String[] patternExamples = {
				"dd MMMMM yyyy",
				"dd.MM.yy",
				"MM/dd/yy",
				"yyyy.MM.dd G 'at' hh:mm:ss z",
				"EEE, MMM d, ''yy",
				"h:mm a",
				"H:mm:ss:SSS",
				"K:mm a,z",
				"yyyy.MMMMM.dd GGG hh:mm aaa"
			};
		final JComboBox<String> patternList = new JComboBox<>(patternExamples);
		patternList.setEditable(true);
		patternList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String newSelection = (String) cb.getSelectedItem();
				m_currentPattern = newSelection;
				reformat(m_currentPattern);
				m_logger.log(Level.ALL, "patternList CB Selected'{0}'", newSelection);
			}
		});
		m_currentPattern = patternExamples[0];
		patternList.setSelectedIndex(0);

		JScrollPane patternListScrollPane = new JScrollPane(patternList);

		JButton showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (patternList.getSelectedIndex() != -1) {
					data = "Pattern Selected: " + patternList.getItemAt(patternList.getSelectedIndex());
				}
				m_dateStatusLabel.setText(data);
			}
		});
		controlPanel.add(headerLabel);
		controlPanel.add(patternListScrollPane);
		controlPanel.add(showButton);
		controlPanel.add(m_dateStatusLabel);

		/*
		 * create pop-up window (JFrame with a JScrillPanel) for this GUI
		 */
		simplePopUpWindow("Date combo box Example", new JScrollPane(controlPanel));
	}

	public void demoFruitCombobox() {
		JPanel controlPanel = new JPanel();
		JLabel headerLabel = new JLabel();
		headerLabel.setText("Control in action: Fruit JComboBox");
		m_fruitStatusLabel.setText("Show Selected Fruit Here");

		final DefaultComboBoxModel<String> fruitNameCombo = new DefaultComboBoxModel<>();

		fruitNameCombo.addElement("Apple");
		fruitNameCombo.addElement("Grapes");
		fruitNameCombo.addElement("Mango");
		fruitNameCombo.addElement("Pear");
		fruitNameCombo.addElement("BlueBerry");
		fruitNameCombo.addElement("Banana");
		fruitNameCombo.addElement("Cherry");

		final JComboBox<String> fruitCombo = new JComboBox<>(fruitNameCombo);
		fruitCombo.setSelectedIndex(0);		// initially selected a combo box element

		JScrollPane fruitNameScrollPane = new JScrollPane(fruitCombo);

		JButton showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Invalid Selection!";
				if (fruitCombo.getSelectedIndex() != -1) {
					data = "Fruits Selected: " + fruitCombo.getItemAt(fruitCombo.getSelectedIndex());
				}
				m_fruitStatusLabel.setText(data);
			}
		});
		
		controlPanel.add(headerLabel);
		controlPanel.add(fruitNameScrollPane);
		controlPanel.add(showButton);
		controlPanel.add(m_fruitStatusLabel);
//		JPanel statusPanel = new JPanel(); 
//		controlPanel.add(statusPanel.add(m_statusLabel));

		/*
		 * create pop-up window (JFrame with a JScrillPanel) for this GUI
		 */
		simplePopUpWindow("Fruit name combo box Example", new JScrollPane(controlPanel));
	}
	
	public void demoRadioButtonDemo() {		
		JPanel controlPanel = new JPanel();
		JLabel headerLabel = new JLabel();
		JLabel statusLabel = new JLabel();
		
		headerLabel.setText("Control in action: RadioButton");

		final JRadioButton radApple = new JRadioButton("Apple", true);
		final JRadioButton radMango = new JRadioButton("Mango");
		final JRadioButton radPear = new JRadioButton("Pear");

		radApple.setMnemonic(KeyEvent.VK_A);
		radMango.setMnemonic(KeyEvent.VK_M);
		radPear.setMnemonic(KeyEvent.VK_P);

		radApple.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Apple RadioButton: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		radMango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Mango RadioButton: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		radPear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Pear RadioButton: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(radApple);
		group.add(radMango);
		group.add(radPear);

		/**
		 * add each GUI control to a JPanel
		 * (just for GUI organization)
		 */
		controlPanel.add(headerLabel);
		controlPanel.add(radApple);
		controlPanel.add(radMango);
		controlPanel.add(radPear);
		controlPanel.add(statusLabel);

		/*
		 * create pop-up window (JFrame with a JScrillPanel) for this GUI
		 */
		simplePopUpWindow("Fruit Radio Button Example", new JScrollPane(controlPanel));
	}

	
	public static void demo() {
		System.out.println("\n\t" + SimpleSwingDemo.class.getName() + ".demo()...");
		
		SimpleSwingDemo obj = new SimpleSwingDemo();
		
//		obj.myPersonTableDemo();			// table of MyPerson objects
//		obj.itemTableDemo();				// table of Item objects
//		obj.filteredMyPersonTableDemo();
//		obj.demoRadioButtonDemo(); 			// radio buttons
		obj.demoFruitCombobox(); 			// combo box
		obj.demoDateComboboxDemo(); 		// combo box
		
//		obj.runThySelf();	// demonstrate Thread and Runnable
		
		System.out.println("\n\t" + SimpleSwingDemo.class.getName() + ".demo()... done!");
	}
}