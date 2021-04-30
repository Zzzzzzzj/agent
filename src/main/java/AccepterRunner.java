/**
 * @auther: stan
 * @create: 2021-04-30 15:27
 */
public class AccepterRunner {
    /**
     * 运行通知接收任务
     * @param args
     */
    public static void main(String[] args) {
        NoticeAccepter accepter = null;
        try {
            accepter = new NoticeAccepter();
            accepter.run();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            accepter.stop();
        }
    }
}
