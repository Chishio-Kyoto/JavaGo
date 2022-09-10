import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class Sample04 {
    public static void main(String[] args) {
        /**
        int x = -1;
        assert x >= 0;
        assert x >= 0 : "x must >= 0";
        System.out.println(x);
         */
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");

        Logger logger2 = Logger.getLogger(Sample04.class.getName());
        logger2.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // TODO: 使用logger.severe()打印异常
            logger2.severe("invalidCharsetName > UnsupportedEncodingException");
        }
        logger2.info("Process end.");
    }
}
