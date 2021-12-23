/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import javax.swing.*;

/**
 *
 * @author traig
 */
public  class CalendarPanel extends JPanel {
  public final Dimension size = new Dimension(40, 26);
  public final JLabel yearMonthLabel = new JLabel("", SwingConstants.CENTER);
   private ArrayList<LocalDate> mDates = new ArrayList<>();
   
  public final JList<LocalDate> monthList = new JList<LocalDate>() {
    @Override public void updateUI() {
      setCellRenderer(null);
      super.updateUI();
      setLayoutOrientation(JList.HORIZONTAL_WRAP);
      setVisibleRowCount(CalendarViewListModel.ROW_COUNT); // ensure 6 rows in the list
      setFixedCellWidth(size.width);
      setFixedCellHeight(size.height);
      setCellRenderer(new CalendarListRenderer());
        System.out.println(mDates.size());
      getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }
  };
  public final LocalDate realLocalDate = LocalDate.now(ZoneId.systemDefault());
  private LocalDate currentLocalDate;

  public LocalDate getCurrentLocalDate() {
    return currentLocalDate;
  }

 public  CalendarPanel(ArrayList<LocalDate> dates) {

    super();
    mDates = dates;
    installActions();

    JButton prev = new JButton("<");
    prev.addActionListener(e -> updateMonthView(getCurrentLocalDate().minusMonths(1)));

    JButton next = new JButton(">");
    next.addActionListener(e -> updateMonthView(getCurrentLocalDate().plusMonths(1)));

    JPanel yearMonthPanel = new JPanel(new BorderLayout());
    yearMonthPanel.add(yearMonthLabel);
    yearMonthPanel.add(prev, BorderLayout.WEST);
    yearMonthPanel.add(next, BorderLayout.EAST);

    DefaultListModel<DayOfWeek> weekModel = new DefaultListModel<>();
    DayOfWeek firstDayOfWeek = WeekFields.of(Locale.getDefault()).getFirstDayOfWeek();
    for (int i = 0; i < DayOfWeek.values().length; i++) {
      weekModel.add(i, firstDayOfWeek.plus(i));
    }
    JList<DayOfWeek> header = new JList<DayOfWeek>(weekModel) {
      @Override public void updateUI() {
        setCellRenderer(null);
        super.updateUI();
        ListCellRenderer<? super DayOfWeek> renderer = getCellRenderer();
        setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
          JLabel c = (JLabel) renderer.getListCellRendererComponent(list, value, index, false, false);
          c.setHorizontalAlignment(SwingConstants.CENTER);
          // String s = value.getDisplayName(TextStyle.SHORT_STANDALONE, l);
          // c.setText(s.substring(0, Math.min(2, s.length())));
          c.setText(value.getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault()));
          c.setBackground(new Color(0xDC_DC_DC));
          return c;
        });
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        setLayoutOrientation(JList.HORIZONTAL_WRAP);
        setVisibleRowCount(0);
        setFixedCellWidth(size.width);
        setFixedCellHeight(size.height);
      }
    };
    updateMonthView(realLocalDate);

    JScrollPane scroll = new JScrollPane(monthList);
    scroll.setColumnHeaderView(header);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    JLabel label = new JLabel(" ", SwingConstants.CENTER);

    monthList.getSelectionModel().addListSelectionListener(e -> {
      ListSelectionModel lsm = (ListSelectionModel) e.getSource();
      if (lsm.isSelectionEmpty()) {
        label.setText(" ");
      } else {
        ListModel<LocalDate> model = monthList.getModel();
        LocalDate from = model.getElementAt(lsm.getMinSelectionIndex());
        LocalDate to = model.getElementAt(lsm.getMaxSelectionIndex());
        label.setText(Period.between(from, to).toString());
      }
    });

    Box box = Box.createVerticalBox();
    box.add(yearMonthPanel);
    box.add(Box.createVerticalStrut(2));
    box.add(scroll);
    box.add(label);

    add(box);
    setPreferredSize(new Dimension(320, 240));
  }

  private void installActions() {
    InputMap im = monthList.getInputMap(JComponent.WHEN_FOCUSED);
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "selectNextIndex");
    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "selectPreviousIndex");

    ActionMap am = monthList.getActionMap();
    am.put("selectPreviousIndex", new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        int index = monthList.getLeadSelectionIndex();
        if (index > 0) {
          monthList.setSelectedIndex(index - 1);
        } else {
          LocalDate d = monthList.getModel().getElementAt(0).minusDays(1);
          updateMonthView(getCurrentLocalDate().minusMonths(1));
          monthList.setSelectedValue(d, false);
        }
      }
    });
    am.put("selectNextIndex", new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        int index = monthList.getLeadSelectionIndex();
        if (index < monthList.getModel().getSize() - 1) {
          monthList.setSelectedIndex(index + 1);
        } else {
          LocalDate d = monthList.getModel().getElementAt(monthList.getModel().getSize() - 1).plusDays(1);
          updateMonthView(getCurrentLocalDate().plusMonths(1));
          monthList.setSelectedValue(d, false);
        }
      }
    });
    Action selectPreviousRow = am.get("selectPreviousRow");
    am.put("selectPreviousRow", new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        int index = monthList.getLeadSelectionIndex();
        int weekLength = DayOfWeek.values().length; // 7
        if (index < weekLength) {
          LocalDate d = monthList.getModel().getElementAt(index).minusDays(weekLength);
          updateMonthView(getCurrentLocalDate().minusMonths(1));
          monthList.setSelectedValue(d, false);
        } else {
          selectPreviousRow.actionPerformed(e);
        }
      }
    });
    Action selectNextRow = am.get("selectNextRow");
    am.put("selectNextRow", new AbstractAction() {
      @Override public void actionPerformed(ActionEvent e) {
        int index = monthList.getLeadSelectionIndex();
        int weekLength = DayOfWeek.values().length; // 7
        if (index > monthList.getModel().getSize() - weekLength) {
          LocalDate d = monthList.getModel().getElementAt(index).plusDays(weekLength);
          updateMonthView(getCurrentLocalDate().plusMonths(1));
          monthList.setSelectedValue(d, false);
        } else {
          selectNextRow.actionPerformed(e);
        }
      }
    });
  }

  public void updateMonthView(LocalDate localDate) {
    currentLocalDate = localDate;
    yearMonthLabel.setText(localDate.format(DateTimeFormatter.ofPattern("yyyy / MM").withLocale(Locale.getDefault())));
    monthList.setModel(new CalendarViewListModel(localDate));
  }

  private class CalendarListRenderer implements ListCellRenderer<LocalDate> {
    private final ListCellRenderer<? super LocalDate> renderer = new DefaultListCellRenderer();
    
    public CalendarListRenderer() {
        
    }
    
    
    @Override public Component getListCellRendererComponent(JList<? extends LocalDate> list, LocalDate value, int index, boolean isSelected, boolean cellHasFocus) {
      JLabel l = (JLabel) renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
      l.setOpaque(true);
      l.setHorizontalAlignment(SwingConstants.CENTER);
      l.setText(Objects.toString(value.getDayOfMonth()));
      Color fgc = l.getForeground();
      for(int i =0 ;i < mDates.size(); i++) {
          LocalDate ld = mDates.get(i);
           if(value.getDayOfMonth() == ld.getDayOfMonth() && value.getMonth().getValue() == ld.getMonthValue()) {
           fgc = new Color(Color.RED.getRGB());
        }
     }
                
      if (YearMonth.from(value).equals(YearMonth.from(getCurrentLocalDate()))) {
        DayOfWeek dow = value.getDayOfWeek();
//        if (value.isEqual(realLocalDate)) {
//          fgc = new Color(0x64_FF_64);
//        } 
      } else {
        fgc = Color.GRAY;
      }
      if(value.getDayOfMonth() == 10 && realLocalDate.getMonthValue() == 8) {
          fgc = new Color(0x64_64_FF);
      }
      l.setForeground(isSelected ? l.getForeground() : fgc);
      return l;
    }
  }

 
//  private static void createAndShowGui() {
//    try {
//      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//      ex.printStackTrace();
//      Toolkit.getDefaultToolkit().beep();
//    }
//    JFrame frame = new JFrame("@title@");
//    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    frame.getContentPane().add(new MainPanel());
//    frame.pack();
//    frame.setLocationRelativeTo(null);
//    frame.setVisible(true);
//  }
//}

class CalendarViewListModel extends AbstractListModel<LocalDate> {
  public static final int ROW_COUNT = 6;
  private final LocalDate startDate;

  protected CalendarViewListModel(LocalDate date) {
    super();
    LocalDate firstDayOfMonth = YearMonth.from(date).atDay(1);
    WeekFields weekFields = WeekFields.of(Locale.getDefault());
    int fdmDow = firstDayOfMonth.get(weekFields.dayOfWeek()) - 1;
    startDate = firstDayOfMonth.minusDays(fdmDow);
  }

  @Override public int getSize() {
    return DayOfWeek.values().length * ROW_COUNT;
  }

  @Override public LocalDate getElementAt(int index) {
    return startDate.plusDays(index);
  }
}}