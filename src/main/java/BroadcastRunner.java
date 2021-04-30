import other.Constant;

/**
 * @auther: stan
 * @create: 2021-04-30 15:18
 */
public class BroadcastRunner {

    /**
     * 运行消息广播
     * @param args
     */
    public static void main(String[] args) {
        NoticeBroadcast broadcast = null;
        try {
            broadcast = new NoticeBroadcast(Constant.ACCEPTER_PORT);
            broadcast.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            broadcast.stop();
        }
    }
}
