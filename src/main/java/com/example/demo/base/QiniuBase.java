package com.example.demo.base;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class QiniuBase {
    static String ACCESS_KEY = "kz8nN52T9NS-dDdx5NMbmDTr5BpysobQY4dCoTAK"; //这两个登录七牛 账号里面可以找到
    static String SECRET_KEY = "vHlaAR0T8iXlSqZm5VnmwM8LayqnRJUdktsB4Tu0";
    //要上传的空间
    //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置私有）
    static String bucketname = "my-all-files-yangxp";
    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    String upToken = auth.uploadToken(bucketname);
    Configuration cfg = new Configuration(Zone.zone2());
    UploadManager uploadManager = new UploadManager(cfg);

    /**
     *获取七牛云的上传token
     * @author 杨小平
     * @date  2022年10月24日
     * @param
     * @return
     */
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    /**
     *文件上传到七牛云
     * @author 杨小平
     * @date  2022年10月24日
     * @param FilePath, key
     * @return 没有
     */
    public void upload(String FilePath, String key) throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
            System.out.println("上传成功");
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
        }
    }

    /**
     *文件从七牛云私有下载，带token
     * @author 杨小平
     * @date  2022年10月24日
     * @param URL
     * @return 文件URL
     */
    public String privateDownloadFiles(String URL) {
        //调用privateDownloadUrl方法生成下载链接,第二个参数可以设置Token的过期时间
        String downloadRUL = auth.privateDownloadUrl(URL, 3600);
        System.out.println(downloadRUL);
        return downloadRUL;
    }

    /**
     *根据URL获取文件名称
     * @author 杨小平
     * @date  2022年10月24日
     * @param fileURl
     * @return 文件名
     */
    public String getFileName(String fileURl) throws URISyntaxException {
        //获取要下载的文件名与token
        String fileName = fileURl.substring(fileURl.lastIndexOf("/") + 1);
        return  Paths.get(new URI(fileName).getPath()).getFileName().toString();
    }

    /**
     *根据文件名称获取文件拓展名
     * @author 杨小平
     * @date  2022年10月24日
     * @param fileName
     * @return 文件类型
     */
    public String getFileType(String fileName){
        //获取要下载的文件名与token
        return  fileName.substring(fileName.lastIndexOf(".")+1);
    }

    public static void main(String[] args) throws URISyntaxException {
        String FilePatt = "C:\\Users\\iu\\Desktop\\自我进化\\Java\\企业应用架构模式_201004.pdf";//本地文件
        String key = "files/企业应用架构模式_201004.pdf";//上传七牛云保存的位置
        QiniuBase qiniuBase = new QiniuBase();
//		qiniuBase.upload(FilePatt,key);
        //下载七牛云上面的文件
        String downloadURL = qiniuBase.privateDownloadFiles("http://rk5rrv13f.hn-bkt.clouddn.com/images/查看WiFi密码.png");
//		qiniuBase.download("http://rk5rrv13f.hn-bkt.clouddn.com/images/查看WiFi密码.png");
        String fileName = downloadURL.substring(downloadURL.lastIndexOf("/") + 1);//获取要下载的文件名
        String fileName1 = Paths.get(new URI(fileName).getPath()).getFileName().toString();
//		fileName = URLEncoder.encode(fileName,"UTF-8");
        System.out.println(qiniuBase.getFileName(downloadURL));
        String res = qiniuBase.getFileName(downloadURL);
        System.out.println(qiniuBase.getFileType(res));
    }
}
