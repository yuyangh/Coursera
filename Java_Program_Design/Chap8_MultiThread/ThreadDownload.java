package Chap8_MultiThread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

class ThreadDownload {
    public static void main(String[] args)
            throws IOException {
        final URL[] urls = {
                new URL("http://www.pku.edu.cn"),
                new URL("http://www.baidu.com"),
                new URL("http://www.sina.com.cn"),
                new URL("http://www.dstang.com")
        };
        final String[] files = {
                "pku.htm",
                "baidu.htm",
                "sina.htm",
                "study.htm",
        };

        for (int i = 0; i < urls.length; i++) {
            final int idx = i;
            new Thread(() -> {
                try {
                    System.out.println(urls[idx]);
                    download(urls[idx], files[idx]);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
    }

    static void download(URL url, String file)
            throws IOException {
        try (InputStream input = url.openStream();
             OutputStream output = new FileOutputStream(file)) {
            byte[] data = new byte[1024];
            int length;
            while ((length = input.read(data)) != -1) {
                output.write(data, 0, length);
            }
        }
    }
}


