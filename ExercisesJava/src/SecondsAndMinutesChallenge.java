public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(-3945));
        System.out.println(getDurationString(-65, 45));
        System.out.println(getDurationString(65,145));
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945));

    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid Value";
        }
        int minutes = seconds / 60;
        seconds = seconds % 60;

        return getDurationString(minutes, seconds);
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "invalid value";
        }
        int hour = minutes / 60;
        minutes = minutes % 60;
        if (seconds > 59||seconds<0) {
            return "Invalid Value";
        }
        return hour + "hour " + minutes + "minutes " + seconds + "seconds ";
    }
}