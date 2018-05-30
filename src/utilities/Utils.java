package utilities;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    /* ********** Logging ********** */
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getCanonicalName());

    /* ********** Candidate Quiz Processing ********** */
    public static String getPersonality(String... questions) {
        int consciencieux = 0;
        int dominant = 0;
        int influent = 0;
        int stable = 0;
        float percentage = 0;
        String result = "Non Défini";

        /* ********** Orders Of The Quiz Answers ********** */
        final String[] orders = new String[]{"c,d,i,s", "s,d,c,i", "s,i,c,d", "s,i,c,d", "c,s,d,i", "c,s,i,d"};

        /* ********** Processing Candidate Answers ********** */
        for (int i = 0; i < orders.length; i++) {
            String[] order = orders[i].split(",");
            int question = Integer.parseInt(questions[i]) - 1;
            switch (order[question]) {
                case "c":
                    consciencieux += 1;
                    break;
                case "d":
                    dominant += 1;
                    break;
                case "i":
                    influent += 1;
                    break;
                case "s":
                    stable += 1;
                    break;
            }
        }

        /* ********** Processing Candidate Personality  ********** */
        if (consciencieux >= dominant && consciencieux >= influent && consciencieux >= stable) {
            result = "Consciencieux";
            percentage = consciencieux * 100 / 6;
        } else if (stable >= dominant && stable >= influent) {
            result = "Stable";
            percentage = stable * 100 / 6;
        } else if (dominant >= stable && dominant >= influent) {
            result = "Dominant";
            percentage = dominant * 100 / 6;
        } else if (influent >= dominant) {
            result = "Influent";
            percentage = influent * 100 / 6;
        }

        LOGGER.log(Level.INFO, "[Personalité: " + result + " | Percentage: " + percentage + "%]");

        return result;
    }
    
	public static String hash(String password_rec) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password_rec.getBytes());
		
		byte byteData[] = md.digest();
		
		StringBuffer sb= new StringBuffer();
		for (int i =0; i<byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
