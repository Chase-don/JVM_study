package cn.edu.bupt;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread1 extends Thread{

    private String url;  //网络图片地址
    private String name; //保存的文件名

    public TestThread1(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public void run() {
        WebDownLoader webDownloader = new WebDownLoader();
        webDownloader.downloader(url, name);
        System.out.println("下载的文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1("https://assets.leetcode-cn.com/aliyun-lc-upload/users/i3eautiful-dhawan/avatar_1604558859.png?x-oss-process=image%2Fresize%2Ch_160%2Cw_160", "1.jpg");

    }
}


//下载器
class WebDownLoader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现异常");
        }
    }
}
