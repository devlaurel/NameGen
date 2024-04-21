import javax.swing.*;
import java.util.Random;

public final class NameGen {

    private final JTextField nameField;

    private final String CONSONANTS = "bcdfghklmnprstw";
    private final String VOWELS = "aeiou";

    public NameGen() {
        JFrame frame = new JFrame("NameGen");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 280);
        frame.setLocationRelativeTo(null);

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(e -> generateName());

        nameField = new JTextField(20);
        nameField.setEditable(false);

        JButton secretButton = new JButton("");
        secretButton.addActionListener(e -> lol());

        JPanel panel = new JPanel();
        panel.add(generateButton);
        panel.add(nameField);
        frame.add(panel);
        panel.add(secretButton);

        frame.setVisible(true);
    }

    private void lol() {
        SoundUtil.playSound("weh.wav");
    }

    private void generateName() {
        Random random = new Random();
        StringBuilder nameBuilder = new StringBuilder();

        if (random.nextBoolean()) {
            nameBuilder.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
        } else {
            nameBuilder.append(VOWELS.charAt(random.nextInt(VOWELS.length())));
        }

        int length = random.nextInt(4) + 6;
        boolean isConsonant = random.nextBoolean();
        for (int i = 1; i < length; i++) {
            if (isConsonant) {
                nameBuilder.append(CONSONANTS.charAt(random.nextInt(CONSONANTS.length())));
            } else {
                nameBuilder.append(VOWELS.charAt(random.nextInt(VOWELS.length())));
            }
            isConsonant = !isConsonant;

            if (random.nextDouble() < 0.05) {
                nameBuilder.append("_");
            }
        }

        if (random.nextDouble() < 0.75) {
            nameBuilder.append(random.nextInt(10));
            if (random.nextDouble() < 0.50) {
                nameBuilder.append(random.nextInt(10));
            }
        }

        nameField.setText(nameBuilder.toString());
    }
}
