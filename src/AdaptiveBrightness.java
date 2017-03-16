
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gitaumoses4
 */
public class AdaptiveBrightness extends TimerTask {

    private final Runtime runtime;
    private boolean charging = false;
    private static Timer timer = new Timer();
    private static final int DELAY = 0;
    private static final int PERIOD = 1000;

    public AdaptiveBrightness() {
        runtime = Runtime.getRuntime();
    }

    public static void main(String[] args) {
        AdaptiveBrightness adaptiveBrightness = new AdaptiveBrightness();
        timer.scheduleAtFixedRate(adaptiveBrightness, DELAY, PERIOD);
    }

    @Override
    public void run() {
        try {
            Process process = runtime.exec("acpi -i");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = reader.readLine();
            if (line != null) {
                Pattern pattern = Pattern.compile("Battery\\s+\\d:\\s+(\\w+),\\s+(\\d+)%.*");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String status = matcher.group(1);
                    //TODO: use percentage
                    String percentage = matcher.group(2);

                    if (status.equals("Charging") && !charging) {
                        runtime.exec("xbacklight -set 80");
                        charging = true;
                    }
                    if (status.equals("Discharging") && charging) {
                        runtime.exec("xbacklight -set 20");
                        charging = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
