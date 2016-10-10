package net;

/**
 * Created by hjh on 16-8-8.
 */
public class MultiThreadDown {
    public static void main(String[] args) throws Exception {
        final DownUtil downUtil = new DownUtil("http://www.crazyit.org/" + "attachment.php?aid=MTYONXxjNjBiYzNjN3wxMzE1NTQ2MjU5fGNhO" + "DlKVmpXVmhpNGlkWmVzR2JZbnluZWpqSllod3JzckdodXJOMUpOWWtOaTJZ,", "oracelsql.rar", 4);
        downUtil.download();
        new Thread() {
            public void run() {
                while (downUtil.getCompleteRate() < 1) {
                    System.out.println("已完成:" + downUtil.getCompleteRate());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

