package Base.base5;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道是基于“管道流”的通信方式。
 * JDK提供了PipedWriter、 PipedReader、 PipedOutputStream、 PipedInputStream
 * 前面两个是基于字符的，后面两个是基于字节流的。
 */
public class Pipe {
    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                writer.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * 线程ReaderThread开始执行，
         * 线程ReaderThread使用管道reader.read()进入”阻塞“，
         * 线程WriterThread开始执行，
         * 线程WriterThread用writer.write("test")往管道写入字符串，
         * 线程WriterThread使用writer.close()结束管道写入，并执行完毕，
         * 线程ReaderThread接受到管道输出的字符串并打印，
         * 线程ReaderThread执行完毕。
         */
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader); // 这里注意一定要连接，才能通信

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }
}
