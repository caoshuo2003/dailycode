package CalcTrapezoidalAeraMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowTrapezoidal extends JFrame implements ActionListener {
    Trapezoidal trapezoidal;
    JTextField textUp, textDown, textHeight;
    JTextArea showArea;
    JButton controlButton;
    WindowTrapezoidal() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // 初始化页面窗口布局
    void init() {
        trapezoidal = new Trapezoidal();
        // 添加四个文本框，分别对应上底、下底、高的输入和面积的输出
        textUp = new JTextField(5);
        textDown = new JTextField(5);
        textHeight = new JTextField(5);
        showArea = new JTextArea();
        controlButton = new JButton("计算面积");
        JPanel pNorth = new JPanel();
        pNorth.add(new JLabel("上底:"));
        pNorth.add(textUp);
        pNorth.add(new JLabel("下底:"));
        pNorth.add(textDown);
        pNorth.add(new JLabel("高:"));
        pNorth.add(textHeight);
        // 添加按钮触发
        pNorth.add(controlButton);
        // 将计算按钮的事件监听器设置为当前窗口类的实例本身
        controlButton.addActionListener(this);
        // 使用 BorderLayout 布局管理器将 pNorth 面板放在窗口的北部（即上方）
        add(pNorth, BorderLayout.NORTH);
        // 将带有滚动条的文本区域放在窗口的中心位置
        add(new JScrollPane(showArea), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(textUp.getText().trim());
            double b = Double.parseDouble(textDown.getText().trim());
            double c = Double.parseDouble(textHeight.getText().trim());
            trapezoidal.setUpperBottom(a);
            trapezoidal.setDownBottom(b);
            trapezoidal.setHeight(c);
            String area = trapezoidal.getArea();
            showArea.append(String.format("梯形上底:%.1f,下底:%.1f,高:%.1f的面积:",a,b,c));
            showArea.append(area+"\n");
        }
        catch (Exception ex) {
            // 程序会将异常对象作为字符串追加到文本区域中，以便用户可以查看具体的错误信息。
            showArea.append("\n" + ex + "\n");
        }
    }

}
