import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main extends JFrame {
    private JTextField dateField;
    private JTextField monthField;
    private JTextField yearField;
    private JLabel resultLabel;

    private static final Map<String, String[]> horoscopeMap = new HashMap<>();

    static {
        horoscopeMap.put("ARIES", new String[]{
                "Get-togethers with friends or meetings with a small group.",
                "Your imagination should be flying high today.",
                "Keeping things in balance today might be tricky."
        });
        horoscopeMap.put("TAURUS", new String[]{
                "Today things could be rather hectic at work.",
                "Your financial goals are probably on the verge of becoming reality.",
                "Things may be tough and aggressive today."
        });
        horoscopeMap.put("GEMINI", new String[]{
                "Some new information could have you browsing the web and looking through books to learn.",
                "Conversations with a friend whose good sense you trust could open your eyes to new career possibilities.",
                "Make sure that the battle you fight today is yours."
        });
        horoscopeMap.put("CANCER", new String[]{
                "Today you might learn about new and creative ways to increase your income.",
                "Strange dreams, insights, or visions could upend your spiritual orientation.",
                "Wake up on the right side of bed."
        });
        horoscopeMap.put("LEO", new String[]{
                "Social events could put you in touch with interesting people in intriguing professions.",
                "A friend you may not have seen for a while could awaken strange new feelings for which you're unprepared.",
                "You may feel a strong connection with your fanciful, romantic side today."
        });
        horoscopeMap.put("VIRGO", new String[]{
                "A friend or colleague could recommend some books that you want to read right away.",
                "The formation of a new business partnership might transform your working life.",
                "Give people the benefit of the doubt today."
        });
        horoscopeMap.put("LIBRA", new String[]{
                "Today your mind will be quick, insightful, and inspired.",
                "Unfinished job tasks might have you wanting to pitch in and get them done no matter what it takes.",
                "Some action you took yesterday may be opposed today."
        });
        horoscopeMap.put("SCORPIO", new String[]{
                "If visitors are able to pop in and out during the day.",
                "Today you're apt to feel very sensual and passionate.",
                "If you find yourself in a slump today."
        });
        horoscopeMap.put("SAGITTARIUS", new String[]{
                "Don't be surprised if your inbox fills with email or your phone rings off the hook.",
                "A powerful desire for a current or potential romantic partner might come over you today.",
                "Use the day's boisterous energy to take charge and make things happen."
        });
        horoscopeMap.put("CAPRICORN", new String[]{
                "Inspiration is the word for today.",
                "A powerful need to reach someone either for business or personal reasons could have you spending a lot of time on the phone.",
                "There's apt to be powerful aggression today that may leave you feeling like you want to declare war on everyone."
        });
        horoscopeMap.put("AQUARIUS", new String[]{
                "Today your physical and mental energy should be operating at a very high level.",
                "Money matters could prove obsessive today.",
                "You may run into some tension today as fantasy gets in the way of your plan of attack."
        });
        horoscopeMap.put("PISCES", new String[]{
                "Your intuition is likely to be very keen today, Pisces. Accurate psychic insights could come to you thick and fast.",
                "Today you should be looking especially good and feeling particularly passionate and sensual.",
                "You may run into a great deal of frustration if you try to fight the current circumstances."
        });
    }

    public Main() {
        setTitle("Cosmic Chronicles: Unveil Your Daily Zodiac Secrets");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        JLabel dateLabel = new JLabel("Enter Your Date of Birth:");
        inputPanel.add(dateLabel);
        dateField = new JTextField();
        inputPanel.add(dateField);

        JLabel monthLabel = new JLabel("Enter Your Month of Birth:");
        inputPanel.add(monthLabel);
        monthField = new JTextField();
        inputPanel.add(monthField);

        JLabel yearLabel = new JLabel("Enter Your Year of Birth:");
        inputPanel.add(yearLabel);
        yearField = new JTextField();
        inputPanel.add(yearField);

        JButton generateButton = new JButton("Generate Fortune");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFortune();
            }
        });
        inputPanel.add(generateButton);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Helvetica", Font.ITALIC, 12));
        resultLabel.setForeground(Color.BLUE);
        resultLabel.setBackground(Color.LIGHT_GRAY);
        resultLabel.setOpaque(true);

        add(inputPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);

        JButton exitButton = new JButton("GOOD LUCK");
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(exitButton, BorderLayout.NORTH);
    }

    private String getZodiacSign(int date, int month) {
        if ((month == 3 && date >= 21) || (month == 4 && date <= 19)) return "ARIES";
        if ((month == 4 && date >= 20) || (month == 5 && date <= 20)) return "TAURUS";
        if ((month == 5 && date >= 21) || (month == 6 && date <= 20)) return "GEMINI";
        if ((month == 6 && date >= 21) || (month == 7 && date <= 22)) return "CANCER";
        if ((month == 7 && date >= 23) || (month == 8 && date <= 22)) return "LEO";
        if ((month == 8 && date >= 23) || (month == 9 && date <= 22)) return "VIRGO";
        if ((month == 9 && date >= 23) || (month == 10 && date <= 22)) return "LIBRA";
        if ((month == 10 && date >= 23) || (month == 11 && date <= 21)) return "SCORPIO";
        if ((month == 11 && date >= 22) || (month == 12 && date <= 21)) return "SAGITTARIUS";
        if ((month == 12 && date >= 22) || (month == 1 && date <= 19)) return "CAPRICORN";
        if ((month == 1 && date >= 20) || (month == 2 && date <= 18)) return "AQUARIUS";
        return "PISCES";
    }

    private void readFortune() {
        try {
            int date = Integer.parseInt(dateField.getText());
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());

            if (date < 1 || date > 31 || month < 1 || month > 12) {
                resultLabel.setText("Please enter valid date and month values.");
                return;
            }

            String zodiac = getZodiacSign(date, month);
            String[] horoscopes = horoscopeMap.get(zodiac);

            if (horoscopes != null) {
                String horoscope = horoscopes[new Random().nextInt(horoscopes.length)];
                resultLabel.setText("<html>Zodiac Sign: " + zodiac + "<br>Born in: " + year + "<br>" + horoscope + "</html>");
            } else {
                resultLabel.setText("Zodiac not found.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter numerical values for date, month, and year.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}